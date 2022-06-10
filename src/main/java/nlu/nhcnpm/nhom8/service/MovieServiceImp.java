package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.Movie;
import nlu.nhcnpm.nhom8.model.dto.MovieDto;
import nlu.nhcnpm.nhom8.model.mapper.Mapper;
import nlu.nhcnpm.nhom8.repository.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MovieServiceImp implements MovieService{
    @Autowired
    MovieRepository movieRepository;
    @Override
    public List<MovieDto> getMovieNowShowing() {
        List<Movie> movies = movieRepository.findAllMovieNowShowing();
        List<MovieDto> movieDtos = new ArrayList<>();
        for(int i =0;i<movies.size();i++){
            movieDtos.add(Mapper.toMovieDto(movies.get(i)));
        }
        return movieDtos;
    }

    @Override
    public List<MovieDto> getMovieComingSoon() {
        return null;
    }

    @Override
    public MovieDto getMovieById(int id) {
        Movie movie = findById(id);
        MovieDto movieDto = Mapper.toMovieDto(movie);
        return movieDto;
    }
    public Movie findById(int id){
            Optional<Movie> optionalUser = movieRepository.findById(id);
            Movie movie = new Movie();
            BeanUtils.copyProperties(optionalUser.get(), movie);
            return movie;

    }
}
