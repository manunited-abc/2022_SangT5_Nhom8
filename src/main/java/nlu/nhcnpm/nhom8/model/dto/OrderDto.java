package nlu.nhcnpm.nhom8.model.dto;

import nlu.nhcnpm.nhom8.entity.Theatre;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

public class OrderDto {
    int id;
    String createTime;
    MovieDto nameMovie;
    Theatre theatre;
    String showingTime;
    String showingDate;
    UserDto user;
    Set<ComboFoodDetailDto> comboFoodDetails;
}
