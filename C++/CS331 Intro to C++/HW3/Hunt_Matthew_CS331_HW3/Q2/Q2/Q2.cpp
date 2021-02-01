/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/24/2018
* ASSIGNMENT:	HW3_Q2
*/
#include "stdafx.h"

#include <iostream>
#include <iomanip>
#include <vector>
#include "Account.h" // Account class definition
#include "SavingsAccount.h" // SavingsAccount class definition
#include "CheckingAccount.h" // CheckingAccount class definition

using namespace std;

int main() {

	// Create a vector of Account pointers to SavingsAccount and ChekcingAccount objects.
	vector<Account*> accounts;

	// Initialize vector with Accounts
	accounts.push_back(new SavingsAccount{ 25.0, .03 });
	accounts.push_back(new CheckingAccount{ 80.0, 1.0 });
	accounts.push_back(new SavingsAccount{ 200.0, .015 });
	accounts.push_back(new CheckingAccount{ 400.0, .5 });

	// For each Account in the vector
	for (unsigned int i = 0; i < accounts.size(); i++)
	{
		// First, display the account balance
		cout << "Account " << i+1 << " balance: $" << accounts[i]->getBalance() << endl;

		// Allow the user to specify an amount of money to withdraw from the account using
		// member function debit
		int amtToWithdraw = 0;
		cout << "Enter amount to withdraw from Account " << i + 1 << ": ";
		cin >> amtToWithdraw;
		accounts[i]->debit(amtToWithdraw);

		// Allow the user to specify an amount of money to deposit into the account using
		// member function credit
		int amtToDeposit = 0;
		cout << "Enter amount to deposit into Account " << i + 1 << ": ";
		cin >> amtToDeposit;
		accounts[i]->credit(amtToDeposit);

		// To know whether an account is a SavingsAccount, use downcast pointer
		SavingsAccount* savingsAccountPtr = dynamic_cast<SavingsAccount*>(accounts[i]);

		// If an account is a SavingsAccount (i.e., savingsAccountPtr !=0), calculate
		// the amount of interest owed to the Account using member function calculateInterest,
		double intrest = 0;

		if (savingsAccountPtr != 0)
		{
			intrest = savingsAccountPtr->calculateInterest();
		}
		
		// then add the interest to the account balance using member function credit
		accounts[i]->credit(intrest);

		// After processing an Account, print the updated account balance obtained by invoking
		// base - class member function getBalance
		cout << "Updated Account " << i + 1 << " balance: $" << accounts[i]->getBalance() << endl;

	}
}
