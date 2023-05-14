package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.repo.CarRepository;

@Service
public class CarService {
	@Autowired
    private CarRepository carRepository;

	
	
    public Car sellCar(Car car) {
        // Perform any necessary validations or business logic
        // before saving the car
        return carRepository.save(car);
    }


    public List<Car> getCars() {
        return (List<Car>) carRepository.findAll();
    }
    
}

