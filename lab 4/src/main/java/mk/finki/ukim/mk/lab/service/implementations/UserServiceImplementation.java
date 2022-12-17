package mk.finki.ukim.mk.lab.service.implementations;

import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.enums.Status;
import mk.finki.ukim.mk.lab.repository.UserRepository;
import mk.finki.ukim.mk.lab.service.ShoppingCartService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final ShoppingCartService shoppingCartService;
    public UserServiceImplementation(UserRepository userRepository, ShoppingCartService shoppingCartService) {
        this.userRepository = userRepository;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public ShoppingCart findActiveShoppingCart(String username) {
        User user = this.userRepository.findByUsername(username).get();

        Optional<ShoppingCart> cart = user.getShoppingCarts().stream().filter(shoppingCart -> shoppingCart.getStatus().equals(Status.ACTIVE)).findFirst();
        if(!cart.isPresent()){
            ShoppingCart cart1 = new ShoppingCart(user, LocalDateTime.now());
            return shoppingCartService.save(cart1);
        }
        return cart.get();
    }

    @Override
    public void setCurrentShoppingCartToFinished(String username) {
        User user = this.userRepository.findByUsername(username).get();
        ShoppingCart cart = user.getShoppingCarts().stream().filter(shoppingCart -> shoppingCart.getStatus().equals(Status.ACTIVE)).findFirst().get();
        this.shoppingCartService.changeStatus(cart.getId());
    }
}
