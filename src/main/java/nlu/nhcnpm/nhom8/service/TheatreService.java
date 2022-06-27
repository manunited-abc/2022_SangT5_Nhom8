package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.Theatre;
import nlu.nhcnpm.nhom8.model.dto.TheatreDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TheatreService{
    public List<TheatreDto> getTheatreByCityId(int id);
    public TheatreDto getTheatreById(int id);
    public Theatre getTheatreById2(int id);
}
