package ua.logos.service;

import ua.logos.domain.CarDTO;

import java.util.List;

public interface CarService {

    void create(CarDTO carDTO);

    CarDTO findById(Long id);

    List<CarDTO> findAll();

    CarDTO findByRegNumber(String regNumber);

    List<CarDTO> findAllByModel(String model);

    List<CarDTO> findAllByModelOrByRegNumberOrManufacturer(String model, String regNumber, String manufacturer);

}
