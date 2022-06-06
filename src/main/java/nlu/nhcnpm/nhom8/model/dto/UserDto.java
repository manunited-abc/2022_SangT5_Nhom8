package nlu.nhcnpm.nhom8.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    int id;
    String name;
    String email;
    String phoneNumber;
}
