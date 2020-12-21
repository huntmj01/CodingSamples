/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/23/2018
* ASSIGNMENT:	HW3_Q1
*/

#include "stdafx.h"
#include "Account.h"
#include <iostream>

using namespace std;

/*
A constructor that receives an initial balance and uses it to
initialize the data member. The constructor should validate the
initial balance to ensure that it’s greater than or equal to 0.0. If
not the balance should be set to 0.0 and the constructor should
display an error message, indicating that the initial balance was
invalid
 */
Account::Account(double pBalance)
{

	if (pBalance >= 0)
	{
		balance = pBalance;
	}else
	{
		balance = 0.0;
		throw invalid_argument("invalid initial balance");
	}

}

/*
 A public member function credit adds an amount to the
account current balance. 
 */
void Account::credit(double amount)
{
	balance += amount;
}

/*
 A public member function debit subtracts an amount from
the account balance. It should ensure that the debit amount
does not exceed the Account’s balance. If it does, the balance
should be left unchanged and the function should the message
“Debit amount exceeded account balance”
 */
bool Account::debit(double amount)
{
	bool success = true;

	if (balance < amount)
	{
		success = false;
		cout << "Debit amount exceeded account balance" << endl;
	}else
	{
		balance -= amount;
	}

	return success;
}

/*
 A public member function getBalance returns the account
balance. 
 */
double Account::getBalance()
{
	return balance;
}

/*
 A public member function setBalance sets the account
balance.
 */
void Account::setBalance(double pBalance)
{
	balance = pBalance;
}
