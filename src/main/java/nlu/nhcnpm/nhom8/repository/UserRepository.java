package nlu.nhcnpm.nhom8.repository;

import nlu.nhcnpm.nhom8.entity.User;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u.email from User u where u.email=?1")
    String findByEmail(String email);
    @Query("select u from User u where u.email=?1 and u.password=?2 and u.role='customer'" )
    User findByPassword(String email, String password);
}
