package nlu.nhcnpm.nhom8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
@Table(name="showing_time")
public class ShowingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    LocalTime time;
    @ManyToOne(fetch = FetchType.LAZY)
    Theatre theatre;
    @OneToMany(
            mappedBy = "showingTime",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    Set<Order> orders;

}
