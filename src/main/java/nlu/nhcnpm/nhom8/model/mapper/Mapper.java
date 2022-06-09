package nlu.nhcnpm.nhom8.model.mapper;

import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.model.dto.UserDto;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setPhoneNumber(user.getPhoneNumber());
        tmp.setEmail(user.getEmail());
        return tmp;
    }
}
