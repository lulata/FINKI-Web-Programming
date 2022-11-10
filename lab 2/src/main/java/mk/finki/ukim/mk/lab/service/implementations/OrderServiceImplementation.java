package mk.finki.ukim.mk.lab.service.implementations;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> placeOrder(Long id,String balloonColor, String ballonSize, String clientName, String address) {

        return orderRepository.save(id,balloonColor, ballonSize, clientName, address);
    }

    @Override
    public List<Order> findByUserName(String clientName) {
        if (clientName != null && !clientName.isEmpty()) {
            return orderRepository.findByUserName(clientName);
        }
        return null;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> findByID(Long orderId) {
        return orderRepository.allOrders().stream().filter(order -> order.getOrderId().equals(orderId)).findFirst();
    }

    @Override
    public List<Order> allOrders() {
        return orderRepository.allOrders();
    }


}
