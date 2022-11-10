package mk.finki.ukim.mk.lab.service.implementations;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.lab.repository.ManufacturerRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImplementation implements BalloonService {
    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;

    public BalloonServiceImplementation(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return this.balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }


    @Override
    public Optional<Balloon> findByID(Long id) {
       return balloonRepository.findAllBalloons().stream().filter(balloon -> balloon.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Balloon> addBalloon(String name, String  desc, Long manufacturerId) {
        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId).orElseThrow();
        return this.balloonRepository.save(name, desc, manufacturer);
    }


    @Override
    public void deleteBalloon(Long id) {
        this.balloonRepository.deleteBalloon(id);
    }

}
