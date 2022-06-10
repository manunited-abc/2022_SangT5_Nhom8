package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.Movie;
import nlu.nhcnpm.nhom8.model.dto.MovieDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    public List<MovieDto> getMovieNowShowing();
    public List<MovieDto> getMovieComingSoon();
    public MovieDto getMovieById(int id);
}
