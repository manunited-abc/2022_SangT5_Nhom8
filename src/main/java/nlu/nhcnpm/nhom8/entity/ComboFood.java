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
@Table(name = "combofood")
public class ComboFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nameCombo;
    String description;
    String avatar;
    double price;
    @OneToMany(mappedBy = "comboFood")
    Set<ComboFoodDetail> comboFoodDetails = new HashSet<>();
}
