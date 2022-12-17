package mk.finki.ukim.mk.lab;


import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.repository.UserRepository;
import mk.finki.ukim.mk.lab.service.ShoppingCartService;
import mk.finki.ukim.mk.lab.service.UserService;
import mk.finki.ukim.mk.lab.service.implementations.UserServiceImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserActiveShoppingCartTest {

    @Mock
    private UserRepository userReposotory;

    @Mock
    private ShoppingCartService shoppingCartService;
    private UserService userService;
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        Mockito.when(this.shoppingCartService.save(Mockito.any(ShoppingCart.class))).thenReturn(new ShoppingCart());

        this.userService = Mockito.spy(new UserServiceImplementation(userReposotory, shoppingCartService));
    }

    @Test
    public void testActiveShoppingCart(){
        User user = new User("username", null, "password", LocalDate.now(), List.of(new ShoppingCart(new User("username"),
                LocalDateTime.now())));

        Mockito.when(this.userReposotory.findByUsername(Mockito.anyString())).thenReturn(Optional.of(user));

        ShoppingCart shoppingCart = this.userService.findActiveShoppingCart("username");
        Assert.assertNotNull("shopping cart is null", shoppingCart);

    }
    @Test
    public void testCreatingNewShopCartWhenThereIsNoActive(){

        User user = new User("username", null, "password", LocalDate.now(), new ArrayList<ShoppingCart>());

        Mockito.when(this.userReposotory.findByUsername(Mockito.anyString())).thenReturn(Optional.of(user));

        ShoppingCart shoppingCart = this.userService.findActiveShoppingCart("username");

        Assert.assertNotNull("shopping cart is null", shoppingCart);
    }
    @Test
    public void testNotExistingUsername(){
        Mockito.when(this.userReposotory.findByUsername(Mockito.anyString())).thenReturn(null);

        Assert.assertThrows("NullPointerException expected", NullPointerException.class, () ->
                this.userService.findActiveShoppingCart("username"));

    }
}

