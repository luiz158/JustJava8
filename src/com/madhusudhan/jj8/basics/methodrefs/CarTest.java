/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.madhusudhan.jj8.basics.methodrefs;

import java.util.function.Function;

/**
 *
 * @author mkonda
 */
public class CarTest {
    
    Function<Integer, Car> car = this::getCar;
    
    private Car getNewCar() {
        Car c = car.apply(1);
        return c;
    }
    
    public Car getCar(int i){
        return new Car("Toyota","Avensis");
    }

    public static void main(String[] args) {
        CarTest test = new CarTest();
        System.out.println("Car: "+test.getNewCar());
    }
   
}
