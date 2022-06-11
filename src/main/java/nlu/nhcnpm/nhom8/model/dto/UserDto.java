package nlu.nhcnpm.nhom8.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    int id;
    String name;
    String email;
    String password;
    String phoneNumber;
    String avatar;
}
