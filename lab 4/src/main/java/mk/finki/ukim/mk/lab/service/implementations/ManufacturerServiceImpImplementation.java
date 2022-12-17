package mk.finki.ukim.mk.lab.service.implementations;

import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.ManufacturerRepository;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpImplementation implements ManufacturerService {

    private final ManufacturerRepository ManufacturerRepository;

    public ManufacturerServiceImpImplementation(ManufacturerRepository ManufacturerRepository
    ) {
        this.ManufacturerRepository = ManufacturerRepository;
    }


    @Override
    public List<Manufacturer> findAll() {
        return ManufacturerRepository.findAll();
    }

    @Override
    public Manufacturer findById(Long id) {
        return ManufacturerRepository.findById(id).orElseThrow();
    }

    @Override
    public Manufacturer saveManu(String address, String name, String country) {
        return ManufacturerRepository.save(new Manufacturer(name, country, address));
    }

}
