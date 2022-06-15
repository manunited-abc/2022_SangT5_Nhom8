package nlu.nhcnpm.nhom8.repository;

import nlu.nhcnpm.nhom8.entity.Seat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Integer> {
    @Query("select s from Seat s where s.id =:id ")
    public Seat findSeatById(@Param("id") int id);
}
