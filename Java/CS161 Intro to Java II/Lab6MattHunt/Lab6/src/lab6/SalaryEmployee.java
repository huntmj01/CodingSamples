package lab6;

/*4.	SalaryEmployee adds a salary.  getPay returns the salary.  
 * SalaryEmployees get standard benefits and need their own
 *  toString.*/

public class SalaryEmployee extends Employee {

	private double salary;
	
	/**
	 * @return salary, the salary of the employee
	 */
	@Override
	public double getPay() {
		return salary;
	}
	
	/**
	 * @return Salary Employees get standard benefits.
	 */
	@Override
	public String determineBenifits() {
		return "Salary Employees get standard benefits.";
	}
	
	/**
	 * @return firstName, lastName, company, salary 
	 */
	@Override
	public String toString(){
		return getFirstName() + " " + getLastName() 
				+ " from " + getCompany() + ". this workers salary was "
				+ df.format(getPay()) + ".";
	}
	
	// getter and setters
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
