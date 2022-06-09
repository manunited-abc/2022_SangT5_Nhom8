package nlu.nhcnpm.nhom8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "combofood_detail")
public class ComboFoodDetail  {
    @EmbeddedId
    ComboFoodId id;

    @ManyToOne
    @MapsId("idOrder")
    @JoinColumn(name = "order_id")
    Order order;

    @ManyToOne
    @MapsId("idComboFood")
    @JoinColumn(name = "combofood_id")
    ComboFood comboFood;


    int quantity;
}
