package lab2B;

import java.util.Scanner;

public class PayrollDriver {

	public static void main(String args[]) {

		// payroll object
		Payroll pay = new Payroll();

		// Using a setter method of a Payroll object,
		// assigns an employee ID number in sequence starts from 1001
		for (int i = 1001; i < 1006; i++) {
			pay.setEmployeeIdAt(i - 1001, i);
		}

		// Scanner to retrieve user input
		Scanner scan = new Scanner(System.in);

		// loop through each employee
		for (int i = 0; i < 5; i++) {
			// Repeat promoting the user until enters a correct pay rate.
			while (true) {

				// Displays each employee number
				// the user to enter that employee’s pay rate.
				System.out.print("Enter employee number " + pay.getEmployeeIdAt(i) + " pay rate: ");
				double j = scan.nextDouble();

				// The pay rate should be higher than $7.50.
				if (j > 7.5) {
					pay.setPayRateAt(i, j);
					break;
				}

				// tell the user they have failed
				System.out.println("ERROR. Pay must be higher than $7.50.");
			}
		}

		// Using the overloaded method generates
		// a random number to define the employee’s working hours.
		for (int i = 0; i < 5; i++) {
			pay.setHoursAt(i);
		}

		// header
		System.out.println(
				"\nPAYROLL DATA\n" + "==================================" + "========================================");

		// Display each employee’s ID, hours, pay rate, and gross wages
		for (int i = 0; i < 5; i++) {
			System.out.println("Employee Id: " + pay.getEmployeeIdAt(i) + "\t" + "Hours: " + pay.getHoursAt(i) + "\t"
					+ "Rate: " + pay.getPayRateAt(i) + "\t" + "Gross Pay: " + pay.getGrossPayAt(i));
		}

		// close the scanner
		scan.close();
	}
}
