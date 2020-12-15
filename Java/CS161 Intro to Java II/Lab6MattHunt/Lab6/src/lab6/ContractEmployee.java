package lab6;

/*
 * 3.	ContractEmployee adds a contract fee as a double that
 *  is an additional amount of money paid out.  It does not need
 *   its own toString, but does need a getPay method which 
 *   is simply hours * wages + contractFee.  
 *   ContractEmployees don’t get benefit
 */

public class ContractEmployee extends Employee{
	
	private double contractFee;
	private double wage;
	private int hours;
	
	/**
	 * @return weeklyPay, which is hours*wage + contractorFee 
	 */
	@Override
	public double getPay() {
		return hours * wage + contractFee;
	}
	
	/**
	 * @return "Contract Employees do not get benefits."
	 */
	@Override
	public String determineBenifits() {
		return "Contract Employees do not get benefits.";
	}

	// getters and setters
	
	public double getContractFee() {
		return contractFee;
	}

	public void setContractFee(double contractFee) {
		this.contractFee = contractFee;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	
}
