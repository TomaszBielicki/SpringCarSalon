package com.example.demo.utils;

import com.example.demo.model.Car;

public class CarHelper {

    public static Object[] getCar(Car car){
        return new Object[] {
                car.getCarID(),
                car.getProductionDate(),
                car.getModelCar().toString(),
                car.getTypeCar().toString()
        };
    }
}
