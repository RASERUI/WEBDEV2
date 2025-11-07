package com.russellroy.carshop;

import com.russellroy.carshop.exception.CarNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }

    public Car getById(Integer id) {
        // If the car is not found, throw CarNotFoundException
        return carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
    }
}
