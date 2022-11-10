package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BalloonRepository {

    private static final List<Balloon> balloons = new ArrayList<>();

    @PostConstruct
    public void init(){
        this.balloons.add(new Balloon("Balloon 1", "1st balloon"));
        this.balloons.add(new Balloon("Balloon 2", "2nd balloon"));
        this.balloons.add(new Balloon("Balloon 3", "3rd balloon"));
        this.balloons.add(new Balloon("Balloon 4", "4th balloon"));
        this.balloons.add(new Balloon("Balloon 5", "5th balloon"));
        this.balloons.add(new Balloon("Balloon 6", "6th balloon"));
        this.balloons.add(new Balloon("Balloon 7", "7th balloon"));
        this.balloons.add(new Balloon("Balloon 8", "8th balloon"));
        this.balloons.add(new Balloon("Balloon 9", "9th balloon"));
        this.balloons.add(new Balloon("Balloon 10", "10th balloon"));
    }
    public List<Balloon> findAllBalloons() {
        return balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text) {
        List<Balloon> result = new ArrayList<>();
        for (Balloon balloon : balloons) {
            if (balloon.getName().contains(text) || balloon.getDescription().contains(text)) {
                result.add(balloon);
            }
        }
        return result;
    }

}
