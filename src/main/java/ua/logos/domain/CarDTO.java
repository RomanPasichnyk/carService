package ua.logos.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.entity.BodyType;
import ua.logos.entity.FuelType;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor

public class CarDTO {
    private Long id;
    private String manufacturer;
    private String model;
    private BigDecimal engCap;
    private FuelType fuel;
    private BodyType body;
    private String regNumber;
    private String problem;
}
