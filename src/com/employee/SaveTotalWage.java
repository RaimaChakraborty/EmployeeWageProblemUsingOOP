package com.employee;
public class SaveTotalWage {
   public  static final int PART_TIME = 1;                // class constant
    public static final int FULL_TIME = 2;
   private final String COMPANY_NAME;                    // instance constant
  private final int WAGE_PER_HOUR;
   private final int MAX_WORKING_DAYS;
   private final int MAX_WORKING_HOURS;
   private int totalWage;                                // instance variable

    public SaveTotalWage(String flipkart, int i, int i1, int i2) {
    }

    /*Creating constructor of the same class*/
    public void  employeeWageComputation(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours)
    {
        this.COMPANY_NAME = companyName;
      this.WAGE_PER_HOUR = wagePerHour;
       this.MAX_WORKING_DAYS = maxWorkingDays;
        this.MAX_WORKING_HOURS = maxWorkingHours;
    }
    public int workHours(int employeeType)                //It will return the working hours
    {
        switch (employeeType)
        {
            case FULL_TIME:
                return 8;
            case PART_TIME:
                return 4;
            default:
                return 0;
        }
    }
    public void calculateTotalWage()                         //Calculating and storing the total wage for the month
    {
        System.out.println("Computation of total wage of " + COMPANY_NAME + " employee");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Working hours", "Wage", "Total working hrs");
        int workingHours;
        for (int day = 1, totalWorkingHours = 0; day <= MAX_WORKING_DAYS
                && totalWorkingHours <= MAX_WORKING_HOURS; day++, totalWorkingHours += workingHours) {
            int empCheck = (int) (Math.random() * 100) % 3;
            workingHours = workHours(empCheck);
            int wage = workingHours * WAGE_PER_HOUR;
            totalWage += wage;
            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHours, wage, totalWorkingHours + workingHours);
        }
    }

    public String toString()
    {
        System.out.println("Details of " + COMPANY_NAME + " employee");
        System.out.println("-----------------------------------------------------");
        System.out.println("Wage per hour:" + WAGE_PER_HOUR);
        System.out.println("Maximum working days in a month:" + MAX_WORKING_DAYS);
        System.out.println("Maximum working hours in a month:" + MAX_WORKING_HOURS);
        return "Total employee wage for Company: " + COMPANY_NAME + "  is: " + totalWage + "\n";
    }
    public static void main(String []args)
    {
         SaveTotalWage flipkart = new SaveTotalWage("Flipkart", 4, 20, 115);
        SaveTotalWage wipro = new SaveTotalWage("Wipro", 8, 30, 130);
        flipkart.calculateTotalWage();
        System.out.println(flipkart);
        wipro.calculateTotalWage();
        System.out.println(wipro);
    }
}
