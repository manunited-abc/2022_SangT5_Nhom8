package nlu.nhcnpm.nhom8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String codeSeat;
    String typeSeat;
    double price;
    String status;
    @OneToMany(mappedBy = "seat")
    Set<SeatDetail> seatDetails = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    Theatre theatre;
}
