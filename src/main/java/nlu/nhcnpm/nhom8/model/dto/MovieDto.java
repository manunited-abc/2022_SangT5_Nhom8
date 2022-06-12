package nlu.nhcnpm.nhom8.model.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieDto implements Serializable {
    int id;
    String name;
    String type;
    String actor;
    String director;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date releaseTime;
    String runningTime;
    String description;
    String language;
    String avatar;
    String trailer;
    int numberOfShowingDate;
    ArrayList<Date> showTimes;
}
