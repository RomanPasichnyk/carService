package ua.logos.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.CarDTO;
import ua.logos.entity.CarEntity;
import ua.logos.repository.CarRepository;
import ua.logos.service.CarService;
import ua.logos.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void create(CarDTO carDTO) {
        CarEntity car = modelMapper.map(carDTO, CarEntity.class);
        carRepository.save(car);
    }

    @Override
    public CarDTO findById(Long id) {
        CarEntity car = carRepository.findById(id).get();
        CarDTO carDTO = modelMapper.map(car, CarDTO.class);
        return carDTO;
    }

    @Override
    public List<CarDTO> findAll() {
        List<CarEntity> cars = carRepository.findAll();
        List<CarDTO> carDTOS = modelMapper.mapAll(cars, CarDTO.class);
        return carDTOS;
    }

    @Override
    public CarDTO findByRegNumber(String regNumber) {
        CarEntity carEntity = carRepository.findByRegNumber(regNumber);
        CarDTO carDTO = modelMapper.map(carEntity, CarDTO.class);
        return carDTO;
    }

    @Override
    public List<CarDTO> findAllByModel(String model) {
        List<CarEntity> carEntity = carRepository.findByModel(model);
        List<CarDTO> carDTO = modelMapper.mapAll(carEntity, CarDTO.class);
        return carDTO;
    }

    @Override
    public List<CarDTO> findAllByModelOrByRegNumberOrManufacturer(String model, String regNumber, String manufacturer) {
        List<CarEntity> carEntities = carRepository.findByModelOrManufacturerOrRegNumber(model, manufacturer, regNumber);
        List<CarDTO> carDTOS = modelMapper.mapAll(carEntities, CarDTO.class);
        return carDTOS;
    }
}
