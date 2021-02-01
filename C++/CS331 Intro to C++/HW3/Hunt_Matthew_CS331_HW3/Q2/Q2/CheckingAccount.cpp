/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/24/2018
* ASSIGNMENT:	HW3_Q2
*/

#include "stdafx.h"
#include "CheckingAccount.h"
#include <iostream>

using namespace std;

/*
CheckingAccount’s constructor should receive the initial
balance, as well as a parameter indicating a fee amount. The
constructor does a job similar with the base class
construction. For initialing the balance, use the base class’s
constructor. The constructor should also validate the initial
transaction fee to ensure that it’s greater than or equal to 0.0.
If not the transaction fee should be set to 0.0 and the
constructor should display an error message, indicating that
the initial fee was invalid.
 */
CheckingAccount::CheckingAccount(double initialBalance, double feeAmount) : Account(initialBalance)
{
	if (feeAmount >= 0)
	{
		transactionFee = feeAmount;
	}
	else
	{
		feeAmount = 0.0;
		cout << " initial rate invalid" << endl;
	}
}

CheckingAccount::~CheckingAccount()
{
	
}


/*
Class CheckingAccount should refine member functions
credit of Account. This public function adds an amount
to the account balance, and then charges fee.
CheckingAccount’s credit always charge fee. 
 */
void CheckingAccount::credit(double amount)
{
	Account::credit(amount);
	chargeFee();
}

/*
Class CheckingAccount should refine member functions
debit of Account.
This public function subtracts an amount to the account
balance, and then should charge fee only if money is actually
withdrawn (i.e., the debit amount does not exceed the account
balance). [Hint: Define Account’s debit function so that it
retunes a bool indicating whether money was withdrawn.
Then use the return value to determine whether a fee should
be charged.]
 */
void CheckingAccount::debit(double amount)
{
	
	bool result = Account::debit(amount);
	
	if (result) chargeFee();
	
}


/*
 A private member function to charge fee. This function
substract the transaction fee from the account balance. 
 */
void CheckingAccount::chargeFee()
{
	setBalance(getBalance() - transactionFee);
	cout << "$" << transactionFee << " transaction fee charged." << endl;
}
