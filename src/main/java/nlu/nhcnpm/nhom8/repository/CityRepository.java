package nlu.nhcnpm.nhom8.repository;

import nlu.nhcnpm.nhom8.entity.City;
import nlu.nhcnpm.nhom8.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Integer> {
    @Query("select distinct c from City c JOIN fetch c.theatres")
    public List<City> findAllCity();
    @Query("select distinct c.id, c.nameCity from City c")
    public List<Object[]> findAllCity2();
}
