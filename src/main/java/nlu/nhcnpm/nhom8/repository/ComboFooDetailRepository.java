package nlu.nhcnpm.nhom8.repository;

import nlu.nhcnpm.nhom8.entity.ComboFoodDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ComboFooDetailRepository extends JpaRepository<ComboFoodDetail,Integer> {
}
