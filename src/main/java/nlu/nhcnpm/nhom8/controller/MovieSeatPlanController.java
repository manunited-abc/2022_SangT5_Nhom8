package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.Seat;
import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.model.dto.MovieDto;
import nlu.nhcnpm.nhom8.model.dto.TheatreDto;
import nlu.nhcnpm.nhom8.service.MovieService;
import nlu.nhcnpm.nhom8.service.SeatService;
import nlu.nhcnpm.nhom8.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class MovieSeatPlanController {
    @Autowired
    MovieService movieService;
    @Autowired
    SeatService seatService;
    @Autowired
    TheatreService theatreService;
    @GetMapping("movie-seat-plan/{idMovie}/{idTheatre}/{time}/{date}")

    public String movieSeatPlan(Model model, @PathVariable String idMovie,
                                @PathVariable String idTheatre,@PathVariable String time,
                                @PathVariable String date, HttpServletRequest request ) {

        MovieDto movieDto = movieService.getMovieById(Integer.parseInt(idMovie));
        model.addAttribute("movie", movieDto);

        TheatreDto theatreDto = theatreService.getTheatreById(Integer.parseInt(idTheatre));
        model.addAttribute("theatre",theatreDto);

        model.addAttribute("time",time);
        model.addAttribute("date",date);

        List<Seat> seat = seatService.getAllSeat();

        List<Seat> singleSeats = findSeatByType("single", seat);
        List<Seat> doubleSeats = findSeatByType("double", seat);
        Map<String, List<Seat>> s1 = statisticalSeatByCode(singleSeats);
        model.addAttribute("singleMap",s1);
        Map<String, List<Seat>> s2 = statisticalSeatByCode(doubleSeats);
        model.addAttribute("doubleMap",s2);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        if(user!=null) {
            // 7.1 Chuyển đến trang MovieSeatPlanGUI
            return "movie-seat-plan";
        }else{
            // 7.2 Chuyển đến trang đang nhập
            return "redirect:/signIn";
        }
    }
    public List<Seat> findSeatByType(String type, List<Seat> seats){
        List<Seat> result = new ArrayList<>();
        for(Seat s:seats){
            if(s.getTypeSeat().equals(type)){
                result.add(s);
            }
        }
        return result;
    }
    public Map<String, List<Seat>> statisticalSeatByCode(List<Seat> seats){
        Map<String,List<Seat>> result= new HashMap<>();
        for(Seat seatDto : seats){
            String key = seatDto.getCodeSeat().substring(0,1);
            if(result.containsKey(key)){
                List<Seat> seatDtos = result.get(key);
                seatDtos.add(seatDto);
                result.put(key,seatDtos);
            }else{
                List<Seat> seatDtos = new ArrayList<>();
                seatDtos.add(seatDto);
                result.put(key,seatDtos);
            }
        }
        return result;
    }
}
