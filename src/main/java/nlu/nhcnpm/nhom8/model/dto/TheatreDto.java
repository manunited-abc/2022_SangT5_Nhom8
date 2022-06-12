package nlu.nhcnpm.nhom8.model.dto;

import lombok.*;
import nlu.nhcnpm.nhom8.entity.City;
import nlu.nhcnpm.nhom8.entity.Order;
import nlu.nhcnpm.nhom8.entity.ShowingTime;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TheatreDto implements Serializable {
    int id;
    String nameTheatre;
    String address;
    int idCity;
    List<ShowingTimeDto> showingTimes ;
}
