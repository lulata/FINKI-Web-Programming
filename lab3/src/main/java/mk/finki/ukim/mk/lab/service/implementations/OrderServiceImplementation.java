package mk.finki.ukim.mk.lab.service.implementations;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import mk.finki.ukim.mk.lab.repository.UserRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    private final UserService userService;
    public OrderServiceImplementation(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    @Override
    public Order placeOrder(String balloonColor,String balloonSize, String clientName, LocalDateTime dateTime) {
        ShoppingCart cart = this.userService.findActiveShoppingCart(clientName);
        return this.orderRepository.save(new Order(balloonColor,balloonSize, clientName, cart, dateTime));
    }

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> deleteById(Long id) {
        Optional<Order> order = this.orderRepository.findById(id);
        this.orderRepository.deleteById(id);
        return order;
    }
}
