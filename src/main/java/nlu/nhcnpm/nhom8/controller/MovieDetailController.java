package nlu.nhcnpm.nhom8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieDetailController {
    @GetMapping("movie-detail")
    public String moiveDetail() {
        return "movie-detail";
    }
}
