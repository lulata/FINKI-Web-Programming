package mk.finki.ukim.mk.lab.service.implementations;


import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.enums.Status;
import mk.finki.ukim.mk.lab.repository.ShoppingCartRepository;
import mk.finki.ukim.mk.lab.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImplementation implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImplementation(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public void changeStatus(Long id) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id).get();
        shoppingCart.setStatus(Status.FINISHED);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
