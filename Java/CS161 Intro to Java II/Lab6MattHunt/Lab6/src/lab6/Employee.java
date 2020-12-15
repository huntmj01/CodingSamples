package lab6;

import java.text.DecimalFormat;

/*
 * 1.	Employee is an abstract class which keeps track of the Employee’s 
 * company, first name, and last name.  It also has a toString() method 
 * that prints the user’s name and company.  It also has two abstract 
 * methods: double getPay() and String determineBenefits()
 * a.	Employee should ALSO have a protected DecimalFormat object 
 * set to use the format string (“$##.##”).  
 * Use this to format all numeric output.
*/

public abstract class Employee {
	
	private String company;
	private String firstName;
	private String lastName;
	
	protected DecimalFormat df = new DecimalFormat("$##.##");
	
	public abstract double getPay();
	public abstract String determineBenifits();
	
	/**
	 * @return firstName, lastName, company, pay
	 */
	public String toString(){
		return getFirstName() + " " + getLastName() 
		+ " from " + getCompany() + ". this workers pay"
		+ " for this week is "+ df.format(getPay());
	}
	
	// getters and setters
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
