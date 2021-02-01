/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/23/2018
* ASSIGNMENT:	HW3_Q1
*/

#include "stdafx.h"
#include "SavingsAccount.h"
#include <iostream>

using namespace std;

/*
SavingsAccount’s constructor should receive the initial
balance, as well as an initial value for the SavingsAccount’s
interest rate. The constructor does a job similar with the base
class construction. For initialing the balance, use the base
class’s constructor. The constructor should also validate the
initial interest rate to ensure that it’s greater than or equal to
0.0. If not the rate should be set to 0.0 and the constructor
should display an error message, indicating that the initial rate
was invalid.
 */
SavingsAccount::SavingsAccount(double initialBalance, double initialRate): Account(initialBalance)
{
	if (initialRate >= 0)
	{
		interestRate = initialRate;
	}
	else
	{
		interestRate = 0.0;
		cout << " initial rate invalid" << endl;
	}
}

/*
A public member function calculateInterest returns a
double indicating the amount of interest earned by an account.
It should determine this amount by multiplying the interest rate
by the account balance.
 */
double SavingsAccount::calculateInterest()
{
	return interestRate * getBalance();
}
