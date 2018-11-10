package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.CarDTO;
import ua.logos.service.CarService;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CarDTO carDTO) {
        carService.create(carDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<CarDTO> carDTOS = carService.findAll();
        return new ResponseEntity<List<CarDTO>>(carDTOS, HttpStatus.OK);
    }

    @GetMapping("{carId}")
    public ResponseEntity<?> getById(@PathVariable Long carId) {
        CarDTO carDTO = carService.findById(carId);
        return new ResponseEntity<CarDTO>(carDTO, HttpStatus.OK);
    }

    @GetMapping("number")
    public ResponseEntity<?> getByRegNumber(@RequestParam(name = "name", required = true) String regNumber) {
        System.out.println("Reg Number: " + regNumber);
        CarDTO carDTO = carService.findByRegNumber(regNumber);
        return new ResponseEntity<CarDTO>(carDTO, HttpStatus.OK);
    }

    @GetMapping("model")
    public ResponseEntity<?> getByModel(@RequestParam(name = "model", required = true) String model) {
        System.out.println("Model: " + model);
        List<CarDTO> carDTO = carService.findAllByModel(model);
        return new ResponseEntity<List<CarDTO>>(carDTO, HttpStatus.OK);
    }

    @GetMapping("mmr")
    public ResponseEntity<?> getByModelOrManufacturerOrRegNumber(
            @RequestParam(name = "model") String model,
            @RequestParam(name = "manufacturer") String manufacturer,
            @RequestParam(name = "regNumber") String regNumber) {
        List<CarDTO> carDTOS = carService.findAllByModelOrByRegNumberOrManufacturer(model, manufacturer, regNumber);
        return new ResponseEntity<List<CarDTO>>(carDTOS, HttpStatus.OK);

    }

}
