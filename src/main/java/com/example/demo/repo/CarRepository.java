package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Car;

public interface CarRepository extends CrudRepository<Car, Long>{

}
