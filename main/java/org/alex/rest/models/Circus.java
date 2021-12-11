package org.alex.rest.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor
@Entity

public class Circus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Missing name")
    @Size(min=2, max=32)
    private String name;

    @NotNull(message = "Missing amountOfPlaces")
    @Min(1)
    @Max(999999)
    private int amountOfPlaces;

    @NotNull(message = "Missing location")
    @Size(min=2, max=32)
    private String address;

    @NotNull(message = "Missing performancePerYear")
    @Min(1)
    @Max(999999)
    private int performancesPerYear;


    public Circus(final String namePar, final String locationPar, final int amountOfPlaces,
                  final int performancesPerYear) {
        this.name = namePar;
        this.address = locationPar;
        this.amountOfPlaces = amountOfPlaces;
        this.performancesPerYear = performancesPerYear;
    }

    public String objToString() {
        return "________________________"
                + "\n|Name: " + name
                + "|\n|address: " + address
                + "|\n|amountOfPlaces: " + amountOfPlaces
                + "|\n|performancePerYear: " + performancesPerYear;
    }

    @Override
    public String toString() {
        return objToString() + "|\n________________________\n";
    }

}
