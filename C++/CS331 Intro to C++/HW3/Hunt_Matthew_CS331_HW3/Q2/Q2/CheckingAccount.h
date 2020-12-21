#pragma once
#include "Account.h"
class CheckingAccount :
	public Account
{
private: 
	double transactionFee;
	void chargeFee();
public:
	CheckingAccount(double, double);
	virtual ~CheckingAccount();
	void credit(double);
	void debit(double);
};

