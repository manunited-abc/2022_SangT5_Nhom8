package nlu.nhcnpm.nhom8.repository;

import nlu.nhcnpm.nhom8.entity.ComboFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ComboFoodRepository extends JpaRepository<ComboFood,Integer> {
    @Query("select c from ComboFood c where c.id=:id")
    public ComboFood findById(@Param("id") int id);
}
