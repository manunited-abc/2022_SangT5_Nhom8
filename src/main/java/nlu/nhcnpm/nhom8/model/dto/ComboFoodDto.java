package nlu.nhcnpm.nhom8.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ComboFoodDto {
    int id;
    String nameCombo;
    String description;
    String avatar;
    double price;
}
