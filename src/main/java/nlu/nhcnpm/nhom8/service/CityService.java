package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.City;
import nlu.nhcnpm.nhom8.model.dto.CityDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    public List<CityDto> getAllCity();
}
