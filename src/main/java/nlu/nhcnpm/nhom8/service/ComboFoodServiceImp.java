package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.ComboFood;
import nlu.nhcnpm.nhom8.entity.ComboFoodDetail;
import nlu.nhcnpm.nhom8.repository.ComboFooDetailRepository;
import nlu.nhcnpm.nhom8.repository.ComboFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComboFoodServiceImp implements ComboFoodService {
    @Autowired
    ComboFoodRepository comboFoodRepository;
    @Autowired
    ComboFooDetailRepository comboFooDetailRepository;
    @Override
    public List<ComboFood> getAllComboFood() {
        List<ComboFood> comboFoods = comboFoodRepository.findAll();

        return comboFoods;
    }

    @Override
    public ComboFood getComboFoodById(int id) {
        return comboFoodRepository.findById(id);
    }

    @Override
    public boolean createComboFoodDetail(ComboFoodDetail comboFoodDetail) {
        try{
            comboFooDetailRepository.save(comboFoodDetail);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
