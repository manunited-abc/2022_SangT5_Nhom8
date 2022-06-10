package nlu.nhcnpm.nhom8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
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
    LocalDateTime createDate;
    LocalDateTime showingDate;
    @OneToMany(mappedBy = "order")
    Set<ComboFoodDetail> comboFoodDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    Movie movie;
    @ManyToOne(fetch = FetchType.LAZY)
    Theatre theatre;
    @ManyToOne(fetch = FetchType.LAZY)
    User user;
    @ManyToOne(fetch = FetchType.LAZY)
    ShowingTime showingTime;

}
