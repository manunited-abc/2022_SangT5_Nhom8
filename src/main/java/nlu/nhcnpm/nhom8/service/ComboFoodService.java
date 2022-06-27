package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.ComboFood;
import nlu.nhcnpm.nhom8.entity.ComboFoodDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComboFoodService {
    public List<ComboFood> getAllComboFood();
    public ComboFood getComboFoodById(int id);
    public boolean createComboFoodDetail(ComboFoodDetail comboFoodDetail);
}
