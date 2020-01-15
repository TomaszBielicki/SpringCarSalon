package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping("/add_new_car")
    public int addNewCar (@RequestBody Car car){
        UUID carId = UUID.randomUUID();
        car.setCarID(carId);
        return carService.addNewCar(car);
    }

    @GetMapping("/{modelName}")
    public List<Car> findCarByModel(@PathVariable("modelName") String modelName) {
        return carService.findCarByModel(modelName);
    }

    
}
