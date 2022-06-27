package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.Seat;
import nlu.nhcnpm.nhom8.entity.SeatDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeatService {
    public List<Seat> getAllSeat();
    public Seat getSeatById(int id);
    public boolean createSeatDetail(SeatDetail seatDetail);
}
