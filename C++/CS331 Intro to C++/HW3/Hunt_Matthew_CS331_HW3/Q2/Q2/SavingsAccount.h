#pragma once
#include "Account.h"

class SavingsAccount : public Account
{
private:
	double interestRate;

public:
	SavingsAccount(double, double);
	virtual ~SavingsAccount();
	double calculateInterest();

};

