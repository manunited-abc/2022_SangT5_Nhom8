package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.model.dto.MovieDto;
import nlu.nhcnpm.nhom8.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    MovieService movieService;
    @GetMapping(value = {"index.html","/","index"})
    public String homePage(Model model, HttpServletRequest request ){
        List<MovieDto> movieDtos = movieService.getMovieNowShowing();
        model.addAttribute("movies",movieDtos);
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);



        return "index";
    }

}
