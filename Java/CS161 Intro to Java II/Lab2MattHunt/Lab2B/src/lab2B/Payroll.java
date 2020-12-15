package lab2B;

import java.util.Random;

public class Payroll {

	// fields
	int[] employeeId;
	int[] hours;
	double[] payRate;

	// default constructor
	// Initialize all data fields to 0
	public Payroll() {

		employeeId = new int[5];
		hours = new int[5];
		payRate = new double[5];

		for (int i = 0; i > employeeId.length; i++) {
			employeeId[i] = 0;
		}

		for (int i = 0; i > hours.length; i++) {
			hours[i] = 0;
		}

		for (int i = 0; i > payRate.length; i++) {
			payRate[i] = 0.0;
		}

	}

	// copy constructor
	public Payroll(Payroll obj) {

		for (int i = 0; i > employeeId.length; i++) {
			this.employeeId[i] = obj.employeeId[i];
		}

		for (int i = 0; i > hours.length; i++) {
			this.hours[i] = obj.hours[i];
		}

		for (int i = 0; i > payRate.length; i++) {
			this.payRate[i] = obj.payRate[i];
		}

	}

	// Returns the emp ID number at a specified element of the employeeId array
	public int getEmployeeIdAt(int index) {
		return employeeId[index];
	}

	// Returns worked hours at a specified element of the hours array
	public int getHoursAt(int index) {
		return hours[index];
	}

	// Returns the pay rate at a specified element of the payRate array
	public double getPayRateAt(int index) {
		return payRate[index];
	}

	// Returns the gross pay for the employee that is computed by worked hours *
	// pay rate
	public double getGrossPayAt(int index) {
		return payRate[index] * hours[index];
	}

	// setters

	// Stores an ID number at a specified element of the employeeId array
	public void setEmployeeIdAt(int index, int id) {
		this.employeeId[index] = id;
	}

	public void setHoursAt(int index, int hours) {
		this.hours[index] = hours;
	}

	public void setPayRateAt(int index, double payRate) {
		this.payRate[index] = payRate;
	}

	// An overloaded method that generates a random number between 15~50
	// and stores the random number at a specified element of the hours array.
	public void setHoursAt(int index) {
		// random number between 15 and 50
		Random rand = new Random();
		int number = rand.nextInt((50 - 15) + 1) + 15;

		this.hours[index] = number;
	}

}
