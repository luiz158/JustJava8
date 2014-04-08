/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.madhusudhan.jj8.basics.methodrefs;

/**
 *
 * @author mkonda
 */
public class CarFactory {
    public static Car getCar(int i){
        return new Car("Toyota","Avensis");
    }

}
