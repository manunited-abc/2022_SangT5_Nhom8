package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.ComboFood;
import nlu.nhcnpm.nhom8.model.dto.ComboFoodDto;
import nlu.nhcnpm.nhom8.model.mapper.Mapper;
import nlu.nhcnpm.nhom8.repository.ComboFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComboFoodServiceImp implements ComboFoodService {
    @Autowired
    ComboFoodRepository comboFoodRepository;
    @Override
    public List<ComboFoodDto> getAllComboFood() {
        List<ComboFood> comboFoods = comboFoodRepository.findAll();
        List<ComboFoodDto> comboFoodDtos = new ArrayList<>();
        for(ComboFood comboFood : comboFoods){
            comboFoodDtos.add(Mapper.toComboFood(comboFood));
        }
        return comboFoodDtos;
    }
}
