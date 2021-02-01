#pragma once
class Account
{
private:
	double balance;
public:
	Account(double);
	void credit(double);
	bool debit(double);
	double getBalance();
	void setBalance(double);
};

