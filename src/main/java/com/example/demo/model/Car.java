package com.example.demo.model;

import com.example.demo.utils.ModelCar;
import com.example.demo.utils.TypeCar;

import java.time.LocalDate;
import java.util.UUID;

public class Car {


    private UUID carID;
    final private ModelCar modelCar;
    final private LocalDate productionDate;
    final private TypeCar typeCar;


//    public Car(UUID carID, ModelCar modelCar, LocalDate productionDate, TypeCar typeCar) {
//        this.carID = carID;
//        this.modelCar = modelCar;
//        this.productionDate = productionDate;
//        this.typeCar = typeCar;
//    }

    public Car(ModelCar modelCar, LocalDate productionDate, TypeCar typeCar) {
        this.modelCar = modelCar;
        this.productionDate = productionDate;
        this.typeCar = typeCar;
    }


    public UUID getCarID() {
        return carID;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public ModelCar getModelCar() {
        return modelCar;
    }

    public TypeCar getTypeCar() {
        return typeCar;
    }

    public void setCarID(UUID carID) {
        this.carID = carID;
    }
}


