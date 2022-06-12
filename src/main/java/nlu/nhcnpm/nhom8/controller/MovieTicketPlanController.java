package nlu.nhcnpm.nhom8.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nlu.nhcnpm.nhom8.entity.City;
import nlu.nhcnpm.nhom8.entity.Theatre;
import nlu.nhcnpm.nhom8.model.dto.CityDto;
import nlu.nhcnpm.nhom8.model.dto.MovieDto;
import nlu.nhcnpm.nhom8.model.dto.TheatreDto;
import nlu.nhcnpm.nhom8.service.CityService;
import nlu.nhcnpm.nhom8.service.MovieService;
import nlu.nhcnpm.nhom8.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class MovieTicketPlanController {
    @Autowired
    MovieService movieService;
    @Autowired
    CityService cityService;
    @Autowired
    TheatreService theatreService;
    @GetMapping("movie-ticket-plan/{id}")
    public String movieTicketPlan(Model model, @PathVariable int id) {
        MovieDto movieDto = movieService.getMovieById(id);
        movieDto.setShowTimes(showTimes(movieDto));
        model.addAttribute("movie",movieDto);

        List<CityDto> cityDtos = cityService.getAllCity();
        model.addAttribute("cities",cityDtos);

        return "movie-ticket-plan";
    }

    //Get list showtime
    public ArrayList<Date> showTimes(MovieDto movieDto){
        Date dt = movieDto.getReleaseTime();
        Calendar c = Calendar.getInstance();
        //Get date now
        Calendar now = Calendar.getInstance();
        Date currentDate = now.getTime();
        //Init list
        ArrayList<Date> showTimes = new ArrayList<>();
        //Length for loop
        long size = (long)movieDto.getNumberOfShowingDate()-getDifferenceDays(dt,currentDate);
        if(size>=0) {
            for (int i = 0; i < size; i++) {
                c.setTime(currentDate);
                c.add(Calendar.DATE, i);
                Date date = c.getTime();
                showTimes.add(date);
            }
        }
        return showTimes;
    }
    //Calculate difference between 2 date
    public long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
