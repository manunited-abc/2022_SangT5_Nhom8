package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.Seat;
import nlu.nhcnpm.nhom8.model.dto.ComboFoodDto;
import nlu.nhcnpm.nhom8.model.dto.MovieDto;
import nlu.nhcnpm.nhom8.model.dto.SeatDto;
import nlu.nhcnpm.nhom8.model.dto.TheatreDto;
import nlu.nhcnpm.nhom8.service.ComboFoodService;
import nlu.nhcnpm.nhom8.service.MovieService;
import nlu.nhcnpm.nhom8.service.SeatService;
import nlu.nhcnpm.nhom8.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ComboController {
    @Autowired
    MovieService movieService;
    @Autowired
    ComboFoodService comboFoodService;
    @Autowired
    TheatreService theatreService;
    @Autowired
    SeatService seatService;
    @GetMapping("combo/{idMovie}/{idTheatre}/{time}/{date}/{idSeat}")
    public String combo(Model model, @PathVariable String idMovie,
                        @PathVariable String idTheatre, @PathVariable String time,
                        @PathVariable String date, @PathVariable String idSeat){

        MovieDto movieDto = movieService.getMovieById(Integer.parseInt(idMovie));
        model.addAttribute("movie", movieDto);

        TheatreDto theatreDto = theatreService.getTheatreById(Integer.parseInt(idTheatre));
        model.addAttribute("theatre",theatreDto);

        String [] split = idSeat.split(",");
        System.out.println(Arrays.toString(split));
        double ticketPrice =0;
        List<SeatDto> seats = new ArrayList<>();
        StringBuilder codeSeats = new StringBuilder();
        for(String s: split){
            SeatDto seatDto = seatService.getSeatById(Integer.parseInt(s));
            ticketPrice +=seatDto.getPrice();
            codeSeats.append(seatDto.getCodeSeat()+", ");
        }

        model.addAttribute("ticketPrice",ticketPrice);


        model.addAttribute("codeSeats",codeSeats.toString().substring(0,codeSeats.length()-2));

        model.addAttribute("time",time);
        model.addAttribute("date",date);

        List<ComboFoodDto> comboFoodDtos = comboFoodService.getAllComboFood();
        model.addAttribute("comboFoods", comboFoodDtos);

        return "combo";
    }
}
