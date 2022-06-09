package nlu.nhcnpm.nhom8.model.mapper;

import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.model.dto.UserDto;

import java.time.LocalDateTime;
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

//    public static void main(String[] args) {
//        Date dt = new Date();
//        Calendar c = Calendar.getInstance();
//        c.setTime(dt);
//        c.add(Calendar.DATE, 7);
//        dt = c.getTime();
//        System.out.println(dt);
//    }
}
