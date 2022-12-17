package mk.finki.ukim.mk.lab.bootstrap;

import lombok.Getter;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
@Getter
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    @PostConstruct
    public void init() {

        balloons.add(new Balloon("pink", "pink balloon"));
        balloons.add(new Balloon("red", "red balloon"));
        balloons.add(new Balloon("orange", "orange balloon"));
        balloons.add(new Balloon("yellow", "yellow balloon"));
        balloons.add(new Balloon("green", "green balloon"));
        balloons.add(new Balloon("blue", "blue balloon"));

        manufacturers.add(new Manufacturer("D", "Germany", "DE"));
        manufacturers.add(new Manufacturer("I", "Italy", "IT"));
        manufacturers.add(new Manufacturer("E", "England", "EN"));


    }

}
