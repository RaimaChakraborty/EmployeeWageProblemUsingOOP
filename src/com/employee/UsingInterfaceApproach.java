package com.employee;
public class UsingInterfaceApproach {
    public static final int PART_TIME = 1;          // class constant
    public static final int FULL_TIME = 2;
    int companies = 0;                        // instance variables
    private CompanyEmpWage[] companyArray;
    public EmployeeWageComputation() {                  //Constructor of same class
        companyArray = new CompanyEmpWage[5];
    }
    private void addCompany(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        companyArray[companies] = new CompanyEmpWage(companyName, wagePerHour, maxWorkingDays, maxWorkingHours);
        companies++;
    }
    private void computeEmpWage() {
        for (int i = 0; i < companies; i++) {
            companyArray[i].setTotalEmployeeWage(this.computeEmpWage(companyArray[i]));
            System.out.println(companyArray[i]);
        }
    }
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {           // Compute Wage method
        int empHrs;                                               // Local variables
        int totalWorkingDays = 0;
        int totalEmpHrs = 0;
        while (totalEmpHrs <= companyEmpWage.MAX_WORKING_HRS && totalWorkingDays < companyEmpWage.MAX_WORKING_DAYS) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            // Case Checking
            switch (empCheck) {
                case PART_TIME:
                    empHrs = 4;
                    break;
                case FULL_TIME:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
                    break;
            }// End Case
            totalEmpHrs += empHrs;
            System.out.println("Day: " + totalWorkingDays + "\tEmp Hr: " + empHrs);
        }
        return totalEmpHrs * companyEmpWage.WAGE_PER_HR;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Employee Wage Computation");
        System.out.println("************************************");
        UsingInterfaceApproach empWageBuilder = new UsingInterfaceApproach();                 //Object creation
        empWageBuilder.addCompany("Flipkart", 20, 20, 15);
        empWageBuilder.addCompany("Reliance", 15, 25, 20);
        empWageBuilder.addCompany("Tata", 17, 22, 18);
        empWageBuilder.computeEmpWage();         // Method calling
    }
}


public class CompanyEmpWage {
    public final String COMPANY_NAME;
    public final int WAGE_PER_HR;
    public final int MAX_WORKING_DAYS;
    public final int MAX_WORKING_HRS;
    // instance variable
    public int totalEmpWage;
    /*Constructor of same class*/
    public CompanyEmpWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
        this.COMPANY_NAME = companyName;
        this.WAGE_PER_HR = wagePerHr;
        this.MAX_WORKING_DAYS = maxWorkingDays;
        this.MAX_WORKING_HRS = maxWorkingHrs;
        this.totalEmpWage = 0;
    }
    public void setTotalEmployeeWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    public String toString() {
        System.out.println("Details of " + COMPANY_NAME + " employee");
        System.out.println("-----------------------------------------------------");
        System.out.println("Wage per hour:" + WAGE_PER_HR);
        System.out.println("Maximum working days:" + MAX_WORKING_DAYS);
        System.out.println("Maximum working hours:" + MAX_WORKING_HRS);
        return "The total employee wage of " + COMPANY_NAME + " is " + totalEmpWage + "\n";
    }
}





