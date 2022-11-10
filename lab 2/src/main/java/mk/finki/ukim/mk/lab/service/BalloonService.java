package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);

    Optional<Balloon> findByID(Long id);

    Optional<Balloon> addBalloon(String name, String description, Long manufacturer);

    void deleteBalloon(Long id);


}
