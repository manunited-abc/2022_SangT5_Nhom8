package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.ShowingTime;
import nlu.nhcnpm.nhom8.entity.Theatre;
import nlu.nhcnpm.nhom8.model.dto.TheatreDto;
import nlu.nhcnpm.nhom8.model.mapper.Mapper;
import nlu.nhcnpm.nhom8.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TheatreServiceImp implements TheatreService{
    @Autowired
    TheatreRepository theatreRepository;
    @Override
    public List<TheatreDto> getTheatreByCityId(int id) {
        List<Theatre> theatres = theatreRepository.findAllTheatreByCityId(id);
        List<TheatreDto> theatreDtos = new ArrayList<>();
        for(Theatre t : theatres){
            theatreDtos.add(Mapper.toTheatreDto(t));
        }
        return theatreDtos;
    }

    @Override
    public TheatreDto getTheatreById(int id) {
        return Mapper.toTheatreDto(theatreRepository.findAllById(id));
    }

    @Override
    public Theatre getTheatreById2(int id) {
        return theatreRepository.findAllById(id);
    }
}
