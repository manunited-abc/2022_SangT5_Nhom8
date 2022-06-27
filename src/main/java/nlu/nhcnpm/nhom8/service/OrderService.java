package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    public boolean createOrder(Order order);
}
