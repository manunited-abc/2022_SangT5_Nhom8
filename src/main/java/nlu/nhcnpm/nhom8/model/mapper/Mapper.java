package nlu.nhcnpm.nhom8.model.mapper;

import com.sun.source.tree.Tree;
import nlu.nhcnpm.nhom8.entity.*;
import nlu.nhcnpm.nhom8.model.dto.*;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

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
        tmp.setReleaseTime(movie.getReleaseTime().getTime());
        tmp.setRunningTime(movie.getRunningTime());
        tmp.setType(movie.getType());
        tmp.setTrailer(movie.getTrailer());
        tmp.setNumberOfShowingDate(movie.getNumberOfShowingDate());
        return tmp;
    }
    public static CityDto toCityDto(City city){
        CityDto tmp = new CityDto();
        tmp.setId(city.getId());
        tmp.setNameCity(city.getNameCity());
        if(city.getTheatres()!= null) {
            List<TheatreDto> theatreDtos = new ArrayList<>();
            for (Theatre t : city.getTheatres()) {
                theatreDtos.add(Mapper.toTheatreDto(t));
            }
            tmp.setTheatres(theatreDtos);
        }
        return tmp;
    }
    public static TheatreDto toTheatreDto(Theatre theatre){
        TheatreDto tmp = new TheatreDto();
        tmp.setId(theatre.getId());
        tmp.setNameTheatre(theatre.getNameTheatre());
        tmp.setIdCity(theatre.getCity().getId());
        tmp.setAddress(theatre.getAddress());
        List<ShowingTimeDto> showingTimes = new ArrayList<>();
        for(ShowingTime st : theatre.getShowingTimes()){
            showingTimes.add(Mapper.toShowingTimeDto(st));
        }
        tmp.setShowingTimes(showingTimes);
        return tmp;
    }
    public static ShowingTimeDto toShowingTimeDto(ShowingTime showingTime){
        ShowingTimeDto tmp = new ShowingTimeDto();
        tmp.setId(showingTime.getId());
        tmp.setTime(showingTime.getTime());
        tmp.setIdTheatre(showingTime.getTheatre().getId());
        return tmp;
    }
    public static SeatDto toSeatDto(Seat seat){
        SeatDto tmp = new SeatDto();
        tmp.setId(seat.getId());
        tmp.setCodeSeat(seat.getCodeSeat());
        tmp.setTypeSeat(seat.getTypeSeat());
        tmp.setStatus(seat.getStatus());
        tmp.setPrice(seat.getPrice());
        return tmp;
    }
    public static ComboFoodDto toComboFood(ComboFood comboFood){
        ComboFoodDto tmp = new ComboFoodDto();
        tmp.setId(comboFood.getId());
        tmp.setNameCombo(comboFood.getNameCombo());
        tmp.setDescription(comboFood.getDescription());
        tmp.setPrice(comboFood.getPrice());
        tmp.setAvatar(comboFood.getAvatar());
        return tmp;
    }
    public static String formatDate(Calendar calendar, String pattern){
        Date date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String strDate = formatter.format(date);
        return strDate;
    }
//    public static Date convertCaleToDate(LocalDateTime localDateTime){
//        Instant instant = localDateTime.toInstant();
//        Date date = Date.from(instant);
//        return date;
//    }

    public static void main(String[] args) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 0);
        dt = c.getTime();
        Date dt2 = new Date();
        Calendar c2 = Calendar.getInstance();
        c2.set(2022,06,10);
        dt2 = c2.getTime();
        System.out.println(dt.before(dt2));
    }
}
