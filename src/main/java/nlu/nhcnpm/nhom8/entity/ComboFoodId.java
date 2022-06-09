package nlu.nhcnpm.nhom8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComboFoodId implements Serializable {
    @Column(name="order_id")
    int idOrder;
    @Column(name="combofood_id")
    int idComboFood;
}
