package nlu.nhcnpm.nhom8.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto implements Serializable {
    int id;
    String name;
    String type;
    String actor;
    String director;
    String releaseTime;
    String runningTime;
    String description;
    String language;
    String avatar;
    String trailer;
}
