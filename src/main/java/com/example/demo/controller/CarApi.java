package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-api")
public class CarApi {

    private CarService carService;

    @Autowired
    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars(){
       return carService.getAllCars();
    }

    @PostMapping
    public int addNewCar (@RequestBody Car car){
        return carService.addNewCar(car);
    }
}
