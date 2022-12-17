package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final BalloonService balloonService;
    private final OrderService orderService;

    public OrderController(OrderService orderService, BalloonService balloonService) {
        this.orderService = orderService;
        this.balloonService = balloonService;
    }

    @GetMapping()
    public String getOrdersByCurrentClient(HttpSession session, Model model) {

        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);

        return "userOrders";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
        return "redirect:/orders";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam String color, @RequestParam String size,HttpSession session,@RequestParam Long orderID) {
        if (color != null && !color.isEmpty() && size != null && !size.isEmpty() ) {
            Order order = orderService.findById(orderID).get();
            orderService.deleteById(orderID);
            order.setBalloonColor(color);
            order.setBalloonSize(size);
            orderService.placeOrder(order.getBalloonColor(),order.getBalloonSize(),order.getUsername(),order.getDateTime());
            return "redirect:/orders";
        }
        return "redirect:/orders?error=InvalidOrder";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model) {
        orderService.findById(id).ifPresent(order -> model.addAttribute("order", order));
        if(orderService.findById(id).isEmpty()){
            return "redirect:/orders?error=OrderNotFound";
        }

        return "add-order";
    }
}
