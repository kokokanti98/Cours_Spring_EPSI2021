package com.example.demoJPA;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Car {
    private String plateNumber;
    private String brand;
    private int price;

    public Car() {
        super();
    }

    @Id
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
