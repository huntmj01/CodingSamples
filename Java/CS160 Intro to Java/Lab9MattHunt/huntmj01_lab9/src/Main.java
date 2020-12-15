import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // make three arrays – 
        // an array of ints and one double array.  
        // They should be all be size 7.
        
        int[] intArray1 = new int[7];
        double[] doubleArray1 = new double[7];
        
        // scanner
        Scanner scan = new Scanner(System.in);
        
        // make an instance of Payroll
        
        Payroll payroll = new Payroll();
        
        // loop through the employeeID array of the Payroll object.  
        // store it temporarily (String[] arr = employeeID’s accessor method] 
        // The loop:
        // Asks the user for the hours worked by the current employee and store it 
        // in the int array
        // Asks the user for the pay rate for the current employee and store it in 
        // one of the double arrays
        
        String[] arr = payroll.getEmployeeID();
        
        for (int i = 0; i < arr.length; i++){
            
            System.out.print("Enter amount of hours for employee with ID "
                    + arr[i] + ": ");
            intArray1[i] = scan.nextInt();
            
            System.out.print("Enter the hourly rate for employee with ID "
                    + arr[i] + ": ");
            doubleArray1[i] = scan.nextDouble();
            
        }
        
        // use Payroll’s setter methods to set the int array 
        // as the hours and the double array as the rates.
        payroll.setHours(intArray1);
        payroll.setPayRates(doubleArray1);
        
        // Call Payroll.setWages()
        payroll.setWages();
        
        // print out Payroll.  uses the toString 
        System.out.println(payroll.toString());
        
        // close the scanner
        scan.close();
        
    }
    
}
