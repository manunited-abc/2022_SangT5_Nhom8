package nlu.nhcnpm.nhom8.repository;

import nlu.nhcnpm.nhom8.entity.Theatre;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    @Query("select distinct t from Theatre t join fetch t.showingTimes where t.city.id =:id ")
    public List<Theatre> findAllTheatreByCityId(@Param("id") int id);
    @Query("select t from Theatre t join fetch t.showingTimes where  t.id=:id")
    public Theatre findAllById(@Param("id") int id);
}
