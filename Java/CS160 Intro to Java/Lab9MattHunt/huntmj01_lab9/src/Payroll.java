import java.text.DecimalFormat;

public class Payroll {

    // a private final constant int field called SIZE.  Set it to 7.
    private final int SIZE = 7;

    // The Payroll class needs the four following fields:
    // employeeID an array of Strings, which will hold employee ID numbers. 
    // It should be private and have size SIZE
    // hours an array of integers, which will hold the hours the employees 
    // worked.  It should have size SIZE
    // payRates an array of doubles holding the pay rates for employees
    // wages an array of doubles holding the wages for employees
    
    private String[] employeeID = new String[SIZE];
    private int[] hours = new int[SIZE];
    private double[] payRates = null;
    private double[] wages = null;
    
    // The Payroll constructor takes no arguments.  It should initialize wages
    // to an empty array of size SIZE.  Assigns the 7 values to the 
    // employeeID array.  
    // 7623A, 1182B, 1182C, 1337G, 8910Y, 2323X, 6921F
    
    public Payroll(){
        wages = new double[SIZE];
        employeeID = new String[]{"7623A", "1182B", "1182C", "1337G", "8910Y", 
            "2323X", "6921F"};
    }
    
    // Payroll needs a method setWages.  
    // setWages is void and has the following algorithm:
    // Using a regular for loop:
    // Calculate pay = hours * payRate for a given index
    // Set wage[i] = pay, where i is the current elements of the array being accessed

    public void setWages(){
        for (int i = 0; i < wages.length; i++){
            wages[i] = hours[i] * payRates[i];
        }
    }
    
    // toString method, that prints out:
    // PAYROLL DATA
    // -----
    // For each Employee:
    // EmployeeID : the ID (from the array)
    // Pay: the wage (from the array) .  
    // Uses a DecimalFormat object to round to two decimal points
    // The sum of hours and wages, using ArrayOps’ sum methods

    public String toString(){
        
        DecimalFormat df = new DecimalFormat("##.##");
        
        String str = "";
        str += "PAYROLL DATA\n";
        str += "-----\n";
        
        for(int i = 0; i < employeeID.length; i++){
            str += "Employee ID: ";
            str += employeeID[i];
            str += "\n";
            str += "Pay: ";
            str += ""+df.format(wages[i]);
            str += "\n";
        }
        
        return str; 
    }
    
    // getters for all fields

    public String[] getEmployeeID() {
        return employeeID;
    }

    public int[] getHours() {
        return hours;
    }

    public double[] getPayRates() {
        return payRates;
    }

    public double[] getWages() {
        return wages;
    }
    
    // setters for hours and payRates

    // Instead of just using field = argument, hours uses 
    // ArrayOps copyIntArray method (hours = copyIntArray(argumentarray)
    public void setHours(int[] hours) {
        this.hours = ArrayOps.copyIntArray(hours);
    }

    // payRates uses the copyDoubleArray
    public void setPayRates(double[] payRates) {
        this.payRates = ArrayOps.copyDoubleArray(payRates);
    }
    
}
