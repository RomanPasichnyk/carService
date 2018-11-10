package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "cars")
public class CarEntity extends BaseEntity {

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String model;

    @Column(name = "engine_capacity", nullable = false, columnDefinition = "DECIMAL(2,1)")
    private BigDecimal engCap;

    @Enumerated(EnumType.STRING)
    private FuelType fuel;

    @Enumerated(EnumType.STRING)
    private BodyType body;

    @Column(nullable = false, unique = true)
    private String regNumber;

    @Column(nullable = false)
    private String problem;

}
