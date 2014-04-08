/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jj8.domain;

/**
 *
 * @author mkonda
 */
public class Account {

    double amount = 0.0;
    boolean isCredit = false;
    
    public Account(double amount){
        setAmount(amount);
        if(amount > 0)
            isCredit = true;
    }
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isIsCredit() {
        return isCredit;
    }

    public void setIsCredit(boolean isCredit) {
        this.isCredit = isCredit;
    }
}
