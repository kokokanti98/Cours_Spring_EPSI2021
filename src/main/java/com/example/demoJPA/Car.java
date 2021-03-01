package com.example.demoJPA;

import javax.persistence.*;

@Entity
//@Table(name="Car")
public class Car {
    //@Column(name="plateNumber")
    @Column(nullable = false)
    private String plateNumber;
    //@Column(name="brand")
    @Basic(optional = false)
    @Column(nullable = false)
    private String brand;
    //@Column(name="price")
    @Basic(optional = false)
    @Column(nullable = false)
    private int price;

    public Car(String p_platenumber,String brand,int price) {
        super();
        this.plateNumber = p_platenumber;
        this.brand = brand;
        this.price = price;
    }

    public Car() {

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
