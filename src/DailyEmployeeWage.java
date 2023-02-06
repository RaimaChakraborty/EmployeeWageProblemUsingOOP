package com.employee;
public class DailyEmployeeWage {
    public static void main(String[] args) {
        // Constants
        int IS_FULL_TIME = 1;
        int EMP_RATE_PER_HOUR = 20;

        //Variables
        int empHrs;
        int empWage;

        // Computation
        double empCheck = Math.floor(Math.random() * 10) % 2;
        if (empCheck == IS_FULL_TIME)

            empHrs = 8;
         else
            empHrs = 0;

        empWage = empHrs * EMP_RATE_PER_HOUR;
        System.out.println("Employee Wage: " + empWage);
    }
    }

