package nlu.nhcnpm.nhom8.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    int id;
    String name;
    String type;
    String actor;
    String director;
    Date releaseTime;
    String runningTime;
    String description;
    String language;
    String avatar;
    String trailer;
}
