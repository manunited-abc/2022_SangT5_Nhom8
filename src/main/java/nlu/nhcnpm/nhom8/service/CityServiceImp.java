package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.model.dto.CityDto;
import nlu.nhcnpm.nhom8.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityServiceImp implements CityService {

    @Autowired
    CityRepository cityRepository;
    @Override
    public List<CityDto> getAllCity() {
          List<Object[]> cities = cityRepository.findAllCity2();
          List<CityDto> cityDtos = new ArrayList<>();
          for(Object[] c: cities){
              CityDto ct = new CityDto((int)c[0],(String)c[1],null);
              cityDtos.add(ct);
          }
          return cityDtos;
    }
}
