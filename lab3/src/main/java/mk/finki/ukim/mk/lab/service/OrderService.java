package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderService {



    Order placeOrder(String balloonColor, String balloonSize,String clientName, LocalDateTime dateTime);

    List<Order> findAll();

    Optional<Order> deleteById(Long id);
}
