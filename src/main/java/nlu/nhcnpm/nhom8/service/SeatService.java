package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.Seat;
import nlu.nhcnpm.nhom8.model.dto.SeatDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeatService {
    public List<SeatDto> getAllSeat();
}
