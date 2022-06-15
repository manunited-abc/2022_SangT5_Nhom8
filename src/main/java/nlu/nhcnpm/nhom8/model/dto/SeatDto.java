package nlu.nhcnpm.nhom8.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SeatDto {
    int id;
    String codeSeat;
    String typeSeat;
    double price;
    String status;
}
