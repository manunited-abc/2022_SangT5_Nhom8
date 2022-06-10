package nlu.nhcnpm.nhom8.model.mapper;

import nlu.nhcnpm.nhom8.entity.Movie;
import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.model.dto.MovieDto;
import nlu.nhcnpm.nhom8.model.dto.UserDto;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

public class Mapper {
    public static UserDto toUserDto(User user) {
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setPhoneNumber(user.getPhoneNumber());
        tmp.setEmail(user.getEmail());
        return tmp;
    }
    public static MovieDto toMovieDto(Movie movie) {
        MovieDto tmp = new MovieDto();
        tmp.setId(movie.getId());
        tmp.setActor(movie.getActor());
        tmp.setAvatar(movie.getAvatar());
        tmp.setDescription(movie.getDescription());
        tmp.setName(movie.getName());
        tmp.setDirector(movie.getDirector());
        tmp.setLanguage(movie.getLanguage());
        tmp.setReleaseTime(formatDate(movie.getReleaseTime(),"dd/MM/yyyy"));
        tmp.setRunningTime(movie.getRunningTime());
        tmp.setType(movie.getType());
        tmp.setTrailer(movie.getTrailer());
        return tmp;
    }
    public static String formatDate(LocalDateTime localDateTime, String pattern){
        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
        Date date = Date.from(instant);
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String strDate = formatter.format(date);
        return strDate;
    }

//    public static void main(String[] args) {
//        Date dt = new Date();
//        Calendar c = Calendar.getInstance();
//        c.setTime(dt);
//        c.add(Calendar.DATE, 7);
//        dt = c.getTime();
//        System.out.println(dt);
//    }
}
