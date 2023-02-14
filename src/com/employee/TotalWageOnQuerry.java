package com.employee;
import java.util.HashMap;
import java.util.LinkedList;
public interface TotalWageOnQuerry {
    public int computeEmpWage(CompanyEmpWage companyEmpWage);
    public void addCompany(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours);
    public void computeEmpWage();
    public int getTotalWage(String company);
}

public class CompanyEmpWage {
    public final String COMPANY_NAME;
    public final int WAGE_PER_HR;
    public final int MAX_WORKING_DAYS;
    public final int MAX_WORKING_HRS;
    public int totalEmpWage;                      // instance variable
    public int []dailyWage;
    public int totalDailyWage;
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
    public void storeDailyWage(){
        for (int i = 0; i < dailyWage.length; i++){
            System.out.println("Day " + (i+1) + "\tDaily Wage : " + dailyWage[i]);
            totalDailyWage += dailyWage[i];
        }
    }
    @Override
    public String toString() {
        System.out.println("Details of " + COMPANY_NAME + " employee");
        System.out.println("-----------------------------------------------------");
        System.out.println("Wage per hour:" + WAGE_PER_HR);
        System.out.println("Maximum working days:" + MAX_WORKING_DAYS);
        System.out.println("Maximum working hours:" + MAX_WORKING_HRS);
        return "The total employee wage of company " + COMPANY_NAME + " is " + totalEmpWage + "\n";
    }
}



public class EmployeeWageComputation implements EmployeeWageBuilder{
    public static final int PART_TIME = 1;          // class constant
    public static final int FULL_TIME = 2;
    private LinkedList<CompanyEmpWage> companyEmpWageList;                        // instance variables
    private HashMap<String,CompanyEmpWage> companyEmpWageHashMap;
    public EmployeeWageComputation(int n) {
        companyEmpWageList = new LinkedList<>();             //using arraylist
        companyEmpWageHashMap = new HashMap<>();
    }

    public void addCompany(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(companyName, wagePerHour, maxWorkingDays, maxWorkingHours);
        companyEmpWageList.add(companyEmpWage);
        companyEmpWageHashMap.put(companyName,companyEmpWage);
    }
    public void computeEmpWage() {
        for (int i = 0; i < companyEmpWageList.size(); i++) {
            CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
            companyEmpWage.setTotalEmployeeWage(this.computeEmpWage(companyEmpWage));
            companyEmpWage.storeDailyWage();
            System.out.println(companyEmpWage);
        }
    }
    public int getTotalWage(String company){                           //method to get total wage when asked by company
        return companyEmpWageHashMap.get(company).totalEmpWage;
    }
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {           // Compute Wage method
        int empHrs;                                                      // Local variables
        int totalWorkingDays = 0;
        int totalEmpHrs = 0;
        companyEmpWage.dailyWage = new  int[companyEmpWage.MAX_WORKING_DAYS];
        System.out.println("Calculating Wage for Company: " + companyEmpWage.COMPANY_NAME);
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
            }
            totalEmpHrs += empHrs;
            companyEmpWage.dailyWage[totalWorkingDays-1] = empHrs * companyEmpWage.WAGE_PER_HR;
            System.out.println("Day: " + totalWorkingDays + "\tEmployee Hour: " + empHrs);
        }
        return totalEmpHrs * companyEmpWage.WAGE_PER_HR;
    }
}

public class EmployeeWageMain {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Employee Wage Computation");
        System.out.println("************************************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of companies: ");
        int number = scanner.nextInt();
        TotalWageOnQuerry empWageBuilder = new EmployeeWageComputation(number);                 //Object creation
        for (int i = 0; i < number; i++) {
            System.out.println("Enter Company Details as given:\n1. CompanyName\t2. EmployeeRatePerHour\t3. NoOfWorkingDays\n4. MaxHoursPerMonth");
            empWageBuilder.addCompany(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        empWageBuilder.computeEmpWage();                 // Method calling
        System.out.println("Enter the company name: ");
        /*The total wage will be shown after being asked to enter the company name*/
        System.out.println("The total employee wage is " + empWageBuilder.getTotalWage(scanner.next()));
    }
}