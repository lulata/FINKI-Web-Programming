package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Balloon {
    private String name;

    private String description;


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
