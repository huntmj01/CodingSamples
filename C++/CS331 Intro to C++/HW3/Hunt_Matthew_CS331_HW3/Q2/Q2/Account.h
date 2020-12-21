#pragma once
class Account
{
private:
	double balance;
public:
	Account(double);
	virtual ~Account();
	void credit(double);
	bool debit(double);
	double getBalance();
	void setBalance(double);
};

