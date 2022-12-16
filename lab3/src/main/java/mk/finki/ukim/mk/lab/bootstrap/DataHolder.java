package mk.finki.ukim.mk.lab.bootstrap;

import lombok.Getter;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
@Getter
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();

    @PostConstruct
    public void init() {

        balloons.add(new Balloon("a", "a"));        balloons.add(new Balloon("b", "b"));
        balloons.add(new Balloon("c", "c"));        balloons.add(new Balloon("d", "d"));
        balloons.add(new Balloon("e", "e"));        balloons.add(new Balloon("f", "f"));



        manufacturers.add(new Manufacturer("Manufacturer #1 ", "Manufacturer #1 country", "Manufacturer #1 Address"));
        manufacturers.add(new Manufacturer("Manufacturer #2 ", "Manufacturer #2 country", "Manufacturer #2 Address"));
        manufacturers.add(new Manufacturer("Manufacturer #3 ", "Manufacturer #3 country", "Manufacturer #3 Address"));
        manufacturers.add(new Manufacturer("Manufacturer #4 ", "Manufacturer #4 country", "Manufacturer #4 Address"));
        manufacturers.add(new Manufacturer("Manufacturer #5 ", "Manufacturer #5 country", "Manufacturer #5 Address"));


    }

}
