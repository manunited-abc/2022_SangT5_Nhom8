package nlu.nhcnpm.nhom8.repository;

import nlu.nhcnpm.nhom8.entity.Movie;
import nlu.nhcnpm.nhom8.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie,Integer> {
    @Query("select m from Movie m where m.statusShowing='now showing' and m.status='public' order by m.releaseTime desc ")
    List<Movie> findAllMovieNowShowing();
}
