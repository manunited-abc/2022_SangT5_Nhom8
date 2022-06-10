package nlu.nhcnpm.nhom8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "seat_detail")
public class SeatDetail {
    @EmbeddedId
    SeatId id;

    @ManyToOne
    @MapsId("idOrder")
    @JoinColumn(name = "order_id")
    Order order;

    @ManyToOne
    @MapsId("idSeat")
    @JoinColumn(name = "seat_id")
    Seat seat;

}
