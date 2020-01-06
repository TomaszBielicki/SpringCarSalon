package com.example.demo.service;

import com.example.demo.datasource.CarDataAccess;
import com.example.demo.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarDataAccess carDataAccess;

    @Autowired
    public CarService(CarDataAccess carDataAccess) {
        this.carDataAccess = carDataAccess;
    }

    public List<Car> getAllCars() {
        return carDataAccess.selectAllCars();
    }

    public int addNewCar(Car car) {
        return carDataAccess.insert(car);

    }
}
