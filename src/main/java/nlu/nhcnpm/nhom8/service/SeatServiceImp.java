package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.Seat;
import nlu.nhcnpm.nhom8.entity.SeatDetail;
import nlu.nhcnpm.nhom8.repository.SeatDetailRepository;
import nlu.nhcnpm.nhom8.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SeatServiceImp implements  SeatService{
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    SeatDetailRepository seatDetailRepository;
    @Override
    public List<Seat> getAllSeat() {
        List<Seat> seats = seatRepository.findAll();

        return seats;
    }

    @Override
    public Seat getSeatById(int id) {
        return seatRepository.findSeatById(id);
    }

    @Override
    public boolean createSeatDetail(SeatDetail seatDetail) {
        try{
            seatDetailRepository.save(seatDetail);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
