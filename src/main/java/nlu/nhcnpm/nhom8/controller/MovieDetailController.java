package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.model.dto.MovieDto;
import nlu.nhcnpm.nhom8.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class MovieDetailController {
    @Autowired
    MovieService movieService;
    @GetMapping("movie-detail/{id}")
    public String movieDetail(HttpSession session,Model model, @PathVariable int id) {
        MovieDto movieDto = movieService.getMovieById(id);
        session.setAttribute("movie",movieDto);
        model.addAttribute("movie",movieDto);
        return "movie-detail";
    }
}
