package nlu.nhcnpm.nhom8.repository;

import nlu.nhcnpm.nhom8.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
