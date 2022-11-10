package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> placeOrder(Long id,String balloonColor, String balloonSize, String clientName, String address);

    List<Order> findByUserName(String clientName);

    Optional<Order> findByID(Long id);
    void deleteOrder(Long id);

    List<Order> allOrders();
}
