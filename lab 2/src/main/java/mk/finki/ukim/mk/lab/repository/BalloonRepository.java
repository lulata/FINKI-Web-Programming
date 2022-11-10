package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BalloonRepository {

    public List<Balloon> findAllBalloons() {
        return DataHolder.balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text) {
        List<Balloon> result = new ArrayList<>();
        for (Balloon balloon : DataHolder.balloons) {
            if (balloon.getName().contains(text) || balloon.getDescription().contains(text)) {
                result.add(balloon);
            }
        }
        return result;
    }

    public Optional<Balloon> save(String name, String description, Manufacturer manufacturer) {
        DataHolder.balloons.removeIf(i -> i.getName().equals(name));
        Balloon balloon = new Balloon(name, description, manufacturer);
        DataHolder.balloons.add(balloon);
        return Optional.of(balloon);
    }

    public void deleteBalloon(Long id) {
        System.out.printf("Deleting balloon with id %d", id);
        DataHolder.balloons.removeIf(balloon -> balloon.getId().equals(id));
    }


}
