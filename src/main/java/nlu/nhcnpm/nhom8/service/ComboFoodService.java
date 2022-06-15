package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.ComboFood;
import nlu.nhcnpm.nhom8.model.dto.ComboFoodDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComboFoodService {
    public List<ComboFoodDto> getAllComboFood();
}
