package com.example.demo.model;

import java.util.UUID;

public class Car {

    public Car(UUID carID, String name) {
        this.carID = carID;
        this.name = name;
    }

    private UUID carID;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getCarID() {
        return carID;
    }

    public void setCarID(UUID carID) {
        this.carID = carID;
    }
}
