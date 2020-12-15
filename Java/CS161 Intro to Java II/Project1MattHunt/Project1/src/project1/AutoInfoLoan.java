/*
 * Matthew Hunt
 * CS 161 Project 1 
 */

package project1;

import java.text.DecimalFormat;

/*
 * AutoInfoLoan
 * 
 * Holds the data fields and methods for computing the 
 * auto loan
 * 
 */

public class AutoInfoLoan {
	
	/* 
	 * Private Static Fields
	 * 
	 * basePrice: a double that holds the base price of the 
	 * loan that the user entered
	 * 
	 * downPayment: a double that holds the down payment
	 * of the loan that the user entered
	 * 
	 * salesTaxRate: a double that holds the sales tax
	 * that the user entered
	 * 
	 * intrestRate: a double that holds the intrestRate
	 * of the loan which will depend on the duration of 
	 * the loan
	 * 
	 * optionsCost: a double that holds the total cost 
	 * of additional options to add to the loan the 
	 * user may have chosen
	 * 
	 * salesTaxAmount: a double that holds the total 
	 * cost of the sales tax
	 * 
	 * loanTermInMonth: a double that holds the duration
	 * of the loan
	 * 
	 * loanAmount: a double that holds the computed value
	 * of the total amount of the loan
	 * 
	 * monthlyPayment: a double that holds the computed value
	 * of the monthly payment of the loan
	 * 
	 * totalPayment: a double that holds the computed value
	 * of the total payment the user will end up paying 
	 * for the loan
	 * 
	 */
	
	private static double basePrice;
	private static double downPayment;
	private static double salesTaxRate;
	
	private static double interestRate;
	private static double monthlyInterestRate;
	private static double optionsCost;
	private static double salesTaxAmount;
	
	private static double loanTermInMonth;
	private static double loanAmount;
	private static double monthlyPayment;
	private static double totalPayment;
	
	// constructor
	public static void computeAutoLoan(){
		
		// retrieve values of text boxes from the 
		// FinancingInformationJPanel
		basePrice = FinancingInformationJPanel.getBasePrice();
		downPayment = FinancingInformationJPanel.getDownPayment();
		salesTaxRate = FinancingInformationJPanel.getSalesTax();
		
		// retrieve the length of the loan in months
		// from the LoanTermJPanel
		loanTermInMonth = LoanTermJPanel.getLoanTerm();
		
		// calculate the salesTaxAmount by subtracting downPayment
		// from basePrice, adding options cost, and then multiplying 
		// by sales tax rate
		salesTaxAmount = (basePrice - downPayment + optionsCost) 
				* salesTaxRate/100;	// Divide sales tax rate by 100 to make percent
		
		// calculate the loan amount by subtracting the down payment
		// from the base price, adding options cost, and adding the
		// sales tax amount
		loanAmount = basePrice - downPayment + optionsCost + salesTaxAmount;
		
		// to get the monthly payment we need to divide the interest 
		// rate by 12
		monthlyInterestRate = interestRate/12;
		
		// calculate the monthly payment by doing a lot of fancy math
		// (Im to lazy to write it out)
		monthlyPayment = loanAmount * monthlyInterestRate / 
				(1-(Math.pow(1/(1+monthlyInterestRate),loanTermInMonth)));
		
		// calculate total payment by multiply the loan term by
		// the monthly payment and adding the down payment
		totalPayment = monthlyPayment * loanTermInMonth + downPayment;
		
		// call the set labels method from the payment information
		// jpanel and send it the loan amount monthly payment and 
		// total payment
		PaymentInformationJPanel.setLabels(twoDecFormat(loanAmount),
				twoDecFormat(monthlyPayment),
				twoDecFormat(totalPayment));
		
	}
	
	/*
	 * private method to format doubles to 2 decimal places
	 * 
	 * @param double d, the double to format
	 * 
	 * @return string, the formated double
	 * 
	 */
	private static String twoDecFormat(double d){
		DecimalFormat df = new DecimalFormat("$0.00");
		return df.format(d);
	}

	// setter for interest rate
	public static void setInterestRate(double interestRate) {
		AutoInfoLoan.interestRate = interestRate;
	}

	// setter for options cost
	public static void setOptionsCost(double optionsCost) {
		AutoInfoLoan.optionsCost = optionsCost;
	}
	
}
