package nlu.nhcnpm.nhom8.model.dto;

import nlu.nhcnpm.nhom8.entity.Theatre;

import java.util.Date;
import java.util.Set;

public class OrderDto {
    int id;
    Date createTime;
    MovieDto nameMovie;
    Theatre theatre;
    String showingTime;
    Date showingDate;
    UserDto user;
    Set<ComboFoodDetailDto> comboFoodDetails;
}
