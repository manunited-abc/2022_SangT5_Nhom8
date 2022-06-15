package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.Seat;
import nlu.nhcnpm.nhom8.model.dto.SeatDto;
import nlu.nhcnpm.nhom8.model.mapper.Mapper;
import nlu.nhcnpm.nhom8.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SeatServiceImp implements  SeatService{
    @Autowired
    SeatRepository seatRepository;
    @Override
    public List<SeatDto> getAllSeat() {
        List<Seat> seats = seatRepository.findAll();
        List<SeatDto> seatDtos = new ArrayList<>();
        for(Seat s : seats){
            seatDtos.add(Mapper.toSeatDto(s));
        }
        return seatDtos;
    }

    @Override
    public SeatDto getSeatById(int id) {
        return Mapper.toSeatDto(seatRepository.findSeatById(id));
    }
}
