package nlu.nhcnpm.nhom8.model.dto;

import lombok.*;
import nlu.nhcnpm.nhom8.entity.Theatre;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CityDto {
    int id;
    String nameCity;

    List<TheatreDto> theatres;
}
