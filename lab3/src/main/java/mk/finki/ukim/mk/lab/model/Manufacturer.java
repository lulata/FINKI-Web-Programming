package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Manufacturer {
    private Long id;
    private String name;
    private String country;
    private String address;

    public Manufacturer(String name, String country, String address) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.id = (long) (Math.random() * 1000000);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
