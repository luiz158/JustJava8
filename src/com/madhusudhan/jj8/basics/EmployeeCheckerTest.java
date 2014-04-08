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
public class EmployeeCheckerTest {

    IEmployeeChecker highestPaidEmployee = e -> e.getSalary() > 100000;
    static IEmployeeChecker outstandingEmployee = e -> e.getRating() > 10;
    IEmployeeChecker nightShiftEmployee = e -> e.isNightShift();
    IEmployeeChecker remoteWorkingEmployee = e -> e.isRemoteWorking();

    private void testEmployee(IEmployeeChecker checker, Employee emp) {
        if (checker.check(emp)) {
            System.out.println("Outstanding Employee :" + emp);
        }
    }

    public static void main(String[] args) {
        EmployeeCheckerTest test = new EmployeeCheckerTest();

        Employee emp = new Employee();
        emp.setFirstName("Madhusudhan");
        emp.setLastName("Konda");
        emp.setRating(15);
        emp.setRole("DIRECTOR");
        test.testEmployee(outstandingEmployee, emp);
        test.testEmployee((e) -> e.getSalary() > 100000, emp);
        test.testEmployee((e) -> e.getRating() > 10, emp);
        test.testEmployee((e) -> e.isNightShift(), emp);
    }
}
