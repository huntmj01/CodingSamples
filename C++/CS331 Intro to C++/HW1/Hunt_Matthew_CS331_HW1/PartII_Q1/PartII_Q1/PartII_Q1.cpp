/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/2/2018
* ASSIGNMENT:	HW1_PartII_Q1
*/

#include "stdafx.h"		
#include <iostream>		
#include <math.h>

using namespace std;

class LoanCalculator
{

private:

	double monthlyInterestRate;
	double numberOfPayments;
	double loanAmount;
	double monthlyPayment;
	double amountPaidBack;
	double interestPaid;

public:

	LoanCalculator()
	{
		monthlyInterestRate = 0.0;
		numberOfPayments = 0.0;
		loanAmount = 0.0;
		monthlyPayment = 0.0;
		amountPaidBack = 0.0;
		interestPaid = 0.0;
	}

	void setMonthlyInterestRate(double mir)
	{
		monthlyInterestRate = mir;
	}

	void setNumberOfPayments(double nop)
	{
		numberOfPayments = nop;
	}

	void setLoanAmount(double la)
	{
		loanAmount = la;
	}

	double getMonthlyInterestRate() const
	{
		return monthlyInterestRate;
	}

	double getNumberOfPayments() const
	{
		return numberOfPayments;
	}

	double getLoanAmount() const
	{
		return loanAmount;
	}

	double getMonthlyPayment() const
	{
		return monthlyPayment;
	}

	double getAmountPaidBack() const
	{
		return amountPaidBack;
	}

	double getInterestPaid() const
	{
		return interestPaid;
	}

	void calculateMonthlyPayment()
	{
		// payment = 
		// monthlyInterestRate * ((1 + Rate)^numberOfPayments)
		// ( ---------------------------------------------------	)* loanAmount
		// (1 + Rate)^N - 1 

		double dividend = monthlyInterestRate * pow(1 + monthlyInterestRate, numberOfPayments);
		double divisor = pow(1 + monthlyInterestRate, numberOfPayments) - 1;

		monthlyPayment = (dividend / divisor) * loanAmount;

	}

	void calculateAmountPaidBack()
	{
		amountPaidBack = monthlyPayment * numberOfPayments;
	}

	void calculateInterestPaid()
	{
		interestPaid = amountPaidBack - loanAmount;
	}

};

int main()
{
	LoanCalculator loan_calculator;
	double input;

	cout << "Please enter monthly interest rate: ";
	cin >> input;
	loan_calculator.setMonthlyInterestRate(input);

	cout << "Please enter number of payments: ";
	cin >> input;
	loan_calculator.setNumberOfPayments(input);

	cout << "Please enter loan amount: ";
	cin >> input;
	loan_calculator.setLoanAmount(input);

	loan_calculator.calculateMonthlyPayment();
	loan_calculator.calculateAmountPaidBack();
	loan_calculator.calculateInterestPaid();

	cout << "Loan Amount: " << loan_calculator.getLoanAmount() << endl;
	cout << "Monthly Interest Rate: " << loan_calculator.getMonthlyInterestRate() << endl;
	cout << "Number of Payments: " << loan_calculator.getNumberOfPayments() << endl;
	cout << "Monthly Payment: " << loan_calculator.getMonthlyPayment() << endl;
	cout << "Amount Paid Back: " << loan_calculator.getAmountPaidBack() << endl;
	cout << "Interest Paid: " << loan_calculator.getInterestPaid() << endl;

	return 0;	// program ran fine without any errors
}