package nlu.nhcnpm.nhom8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatId implements Serializable {
    @Column(name="order_id")
    int idOrder;
    @Column(name="seat_id")
    int idSeat;
}
