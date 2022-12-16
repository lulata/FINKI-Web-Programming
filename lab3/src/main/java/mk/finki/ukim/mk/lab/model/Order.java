package mk.finki.ukim.mk.lab.model;
import lombok.AllArgsConstructor;
import lombok.Data;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String balloonColor;
    private String balloonSize;

    private LocalDateTime dateTime;
    @ManyToOne
    private ShoppingCart shoppingCart;
    private String username;

    public Order(String balloonColor,String balloonSize, String username, ShoppingCart shoppingCart) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.username = username;
        this.shoppingCart = shoppingCart;
    }
    public Order(String balloonColor,String balloonSize, String username, ShoppingCart shoppingCart, LocalDateTime dateTime) {
        this.balloonColor = balloonColor;
        this.username = username;
        this.balloonSize = balloonSize;
        this.shoppingCart = shoppingCart;
        this.dateTime = dateTime;
    }
}
