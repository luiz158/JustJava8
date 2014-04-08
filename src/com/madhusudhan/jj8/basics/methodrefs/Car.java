/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jj8.basics.methodrefs;

import java.util.Random;

/**
 *
 * @author mkonda
 */
public class Car {

    private int id = 0;

    private String make = null;

    private String model = null;

    public Car(int id, String make, String model) {
        this.id = id;
        this.make = make;
        this.model = model;
    }

    Car(String make, String model) {
        System.out.println("Invoked this constructor"+make+","+model);
        new Car(new Random().nextInt(100), make, model);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", make=" + make + ", model=" + model + '}';
    }

}
