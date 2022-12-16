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
//        String clientName = (String) session.getAttribute("clientName");
//        System.out.println(clientName);
//
//        if (clientName != null && !clientName.isEmpty()) {
//
//
//            List<Order> orderList = orderService.findAllByUser_Username(clientName);
//
//            System.out.println(orderList);
//
//            if (orderList.isEmpty()) {
//                return "redirect:/balloons?error:NoOrders";
//            } else {
//                model.addAttribute("orders", orderList);
//
//                return "userOrders";
//            }
//        }
//        return "redirect:/balloons?error:NoOrders";
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);

        return "userOrders";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
        return "redirect:/orders";
    }

//    @PostMapping("/add")
//    public String saveBalloon(@RequestParam String color, @RequestParam String size, @RequestParam String address,HttpSession session) {
//        if (color != null && !color.isEmpty() && size != null && !size.isEmpty() && address != null && !address.isEmpty()) {
//            String clientName = (String) session.getAttribute("clientName");
//            orderService.placeOrder(color, size, (String) session.getAttribute("clientName"), address);
//            return "redirect:/orders";
//        }
//        return "redirect:/orders?error=InvalidOrder";
//    }
//
//    @GetMapping("/add-form")
//    public String getAddBalloonPage(@RequestParam(required = false) String error, Model model) {
//        if (error != null && !error.isEmpty()) {
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", error);
//        }
//
//        return "add-order";
//    }
//
//    @GetMapping("/edit-form/{id}")
//    public String getEditBalloonPage(@PathVariable Long id, Model model) {
//        orderService.findByID(id).ifPresent(order -> model.addAttribute("order", order));
//        if(orderService.findByID(id).isEmpty()){
//            return "redirect:/orders?error=OrderNotFound";
//        }
//
//        return "add-order";
//    }
}
