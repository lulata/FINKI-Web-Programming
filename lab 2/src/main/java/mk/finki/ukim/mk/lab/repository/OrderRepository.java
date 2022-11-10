package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    public List<Order> findByUserName(String clientName) {
        return orders.stream().filter(order -> order.getClientName().equals(clientName)).collect(Collectors.toList());
    }

    public Optional<Order> save(Long id,String balloonColor, String ballonSize, String clientName, String address) {
        if(id!=null){
            orders.removeIf(order -> order.getOrderId().equals(id));
        }
        Order order = new Order(balloonColor, ballonSize, clientName, address);
        orders.add(order);
        return Optional.of(order);
    }

    public void deleteById(Long id) {
        orders.removeIf(order -> order.getOrderId().equals(id));
    }

    public List<Order> allOrders() {
        return orders;
    }



}
