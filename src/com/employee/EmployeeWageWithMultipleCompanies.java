package com.employee;
public class EmployeeWageWithMultipleCompanies
{
    public static void totalWage(String company, int wagePerHour, int maxWorkingHours, int maxWorkingDays)
    {
        final int IS_PART_TIME = 1;
        final int IS_FULL_TIME = 2;

        //variables
        int totalEmployeeWage = 0;
        int employeeHours;
        System.out.println(company + " employee details:");
        System.out.println("Maximum working days : " + maxWorkingDays);
        System.out.println("Maximum working hours : " + maxWorkingHours);
        System.out.println("Wage per hour: " + wagePerHour);
        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Working hours", "Total working hours", "Wage");
        for (int day = 1, totalWorkingHours = 0; day <= maxWorkingDays
                && totalWorkingHours <= maxWorkingHours; day++, totalWorkingHours += employeeHours)
        {
            int empCheck = (int) (Math.random() * 100) % 3;
            switch (empCheck)
            {
                case IS_FULL_TIME:
                    employeeHours = 8;
                    break;
                case IS_PART_TIME:
                    employeeHours = 4;
                    break;
                default:
                    employeeHours = 0;
                    break;
            }
            int employeeWage = employeeHours * wagePerHour;
            totalEmployeeWage += employeeWage;
            System.out.printf("%5d    %5d     %5d     %5d\n", day, employeeHours, totalWorkingHours + employeeHours, employeeWage);
        }
        System.out.println("Total wage for a month for the  " + company + " employee is " + totalEmployeeWage + "\n");
    }

                    public static void main(String []args)
                {
                    /*Calling the method and initializing the parameters*/

                    totalWage("Amazon", 40, 200, 15);
                    totalWage("Flipkart", 30, 150, 22);
                }
}
