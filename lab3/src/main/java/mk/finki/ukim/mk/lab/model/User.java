package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.finki.ukim.mk.lab.model.converts.UserFullName;
import mk.finki.ukim.mk.lab.model.converts.UserNameConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @Convert(converter = UserNameConverter.class)
    private UserFullName userFullName;

    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private List<ShoppingCart> shoppingCarts;


}


