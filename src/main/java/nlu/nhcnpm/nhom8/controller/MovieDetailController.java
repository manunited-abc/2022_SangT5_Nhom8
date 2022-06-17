package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.model.dto.MovieDto;
import nlu.nhcnpm.nhom8.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MovieDetailController {
    @Autowired
    MovieService movieService;
    @GetMapping("movie-detail/{id}")
    public String movieDetail(Model model, @PathVariable int id, HttpServletRequest request) {
        MovieDto movieDto = movieService.getMovieById(id);
        model.addAttribute("movie",movieDto);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);

        return "movie-detail";
    }
}
