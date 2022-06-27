package nlu.nhcnpm.nhom8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Calendar createDate;
    Calendar showingDate;
    @OneToMany(mappedBy = "order")
    List<ComboFoodDetail> comboFoodDetails = new ArrayList<>();
    @OneToMany(mappedBy = "order")
    List<SeatDetail> seatDetails = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    Movie movie;
    @ManyToOne(fetch = FetchType.LAZY)
    Theatre theatre;
    @ManyToOne(fetch = FetchType.LAZY)
    User user;
    String showingTime;

}
