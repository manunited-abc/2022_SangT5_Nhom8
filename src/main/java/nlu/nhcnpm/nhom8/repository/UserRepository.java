package nlu.nhcnpm.nhom8.repository;

import nlu.nhcnpm.nhom8.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("select u.email from User u where u.email=?1")
    String findByEmail(String email);
    @Query("select u.email from User u where u.email=?1 and u.password=?2")
    String findByPassword(String email, String password);
}
