package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.logos.entity.CarEntity;

import java.util.List;

//@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    @Query("SELECT c FROM CarEntity c WHERE c.regNumber = :regNumber")
    CarEntity findCarByRegistrNumber(@Param("regNumber") String number);

    CarEntity findByRegNumber(String regNumber);

    List<CarEntity> findByModel(String model);

    List<CarEntity> findByModelOrManufacturerOrRegNumber(String model, String manufacturer, String regNumber);
}
