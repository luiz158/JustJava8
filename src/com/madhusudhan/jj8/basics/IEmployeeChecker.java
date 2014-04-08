/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.madhusudhan.jj8.basics;

import com.madhusudhan.jj8.domain.Employee;

/**
 *
 * @author mkonda
 */

@FunctionalInterface
public interface IEmployeeChecker {
    public boolean check(Employee emp);
}
