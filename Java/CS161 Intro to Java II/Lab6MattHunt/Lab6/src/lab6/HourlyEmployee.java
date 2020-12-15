package lab6;

/*
 * 2.	HourlyEmployee adds wages and hours as a double and int.  
 * It implements determineBenefits, giving the employee benefits only if their hours are >= 40.
 * a.	Wage is wage * hours if hours <= 40, or wage*hours + 3 dollars extra for overtime.
 * b.	The toString, shown below, includes the weekly pay.
 */

public class HourlyEmployee extends Employee {

	private int hours;
	private double wage;
	
	/**
	 * @return weeklyPay, which is hours * wage
	 */
	@Override
	public double getPay() {
		return hours * wage;
	}

	/**
	 * @return "This worker gets benefits!"
	 */
	@Override
	public String determineBenifits() {
		if (hours <= 40) {
			wage = hours * wage;
		} else {
			wage = hours * wage + 3;
		}
		return "This worker gets benifits!";
	}

	/**
	 * @return firstName, lastName, company, weeklyPay
	 */
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + " from " + getCompany() + ". This workers pay"
				+ " for this week was " + getPay() + ".";
	}

	// getters and setters

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

}
