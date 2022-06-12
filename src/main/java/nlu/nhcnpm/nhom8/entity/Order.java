package nlu.nhcnpm.nhom8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    Set<ComboFoodDetail> comboFoodDetails = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    Movie movie;
    @ManyToOne(fetch = FetchType.LAZY)
    Theatre theatre;
    @ManyToOne(fetch = FetchType.LAZY)
    User user;
    String showingTime;

}
