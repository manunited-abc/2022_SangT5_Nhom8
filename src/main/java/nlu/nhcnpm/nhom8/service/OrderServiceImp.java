package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.Order;
import nlu.nhcnpm.nhom8.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public boolean createOrder(Order order) {
        try{
            orderRepository.save(order);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }

    }
}
