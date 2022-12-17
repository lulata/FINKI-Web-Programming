package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Balloon {
    private Long id;
    private String name;

    private String description;

    private Manufacturer manufacturer;

    public Balloon(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = (long) (Math.random() * 1000000);
    }

    public Balloon(String name, String description, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.id = (long) (Math.random() * 1000000);
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public Manufacturer getManufacturer() {
        if (manufacturer == null) {
            return null;
        }
        return manufacturer;
    }


}
