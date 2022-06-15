package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.Order;
import nlu.nhcnpm.nhom8.entity.Seat;
import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.model.dto.MovieDto;
import nlu.nhcnpm.nhom8.model.dto.SeatDto;
import nlu.nhcnpm.nhom8.service.MovieService;
import nlu.nhcnpm.nhom8.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MovieSeatPlanController {
    @Autowired
    MovieService movieService;
    @Autowired
    SeatService seatService;
    @GetMapping("movie-seat-plan/{id}")
    public String movieSeatPlan(Model model, @PathVariable int id, HttpServletRequest request) {

        MovieDto movieDto = movieService.getMovieById(id);
        model.addAttribute("movie", movieDto);

        List<SeatDto> seatDtos = seatService.getAllSeat();

        List<SeatDto> singleSeats = findSeatByType("single", seatDtos);
        List<SeatDto> doubleSeats = findSeatByType("double", seatDtos);
        Map<String, List<SeatDto>> s1 = statisticalSeatByCode(singleSeats);
        model.addAttribute("singleMap",s1);
        Map<String, List<SeatDto>> s2 = statisticalSeatByCode(doubleSeats);
        model.addAttribute("doubleMap",s2);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "movie-seat-plan";
        } else {
            return "redirect:/signIn";
        }
    }
    public List<SeatDto> findSeatByType(String type, List<SeatDto> seats){
        List<SeatDto> result = new ArrayList<>();
        for(SeatDto sdto:seats){
            if(sdto.getTypeSeat().equals(type)){
                result.add(sdto);
            }
        }
        return result;
    }
    public Map<String, List<SeatDto>> statisticalSeatByCode(List<SeatDto> seats){
        Map<String,List<SeatDto>> result= new HashMap<>();
        for(SeatDto seatDto : seats){
            String key = seatDto.getCodeSeat().substring(0,1);
            if(result.containsKey(key)){
                List<SeatDto> seatDtos = result.get(key);
                seatDtos.add(seatDto);
                result.put(key,seatDtos);
            }else{
                List<SeatDto> seatDtos = new ArrayList<>();
                seatDtos.add(seatDto);
                result.put(key,seatDtos);
            }
        }
        return result;
    }
}
