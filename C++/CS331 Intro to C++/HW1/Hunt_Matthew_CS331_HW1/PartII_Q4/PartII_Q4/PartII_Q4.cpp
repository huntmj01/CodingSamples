/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/4/2018
* ASSIGNMENT:	HW1_PartII_Q4
*/

#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

class Employee
{

private:
	string firstName;
	string lastName;
	int hiredYear;
	int hiredMonth;
	int monthlySalary;

public:

	Employee()
	{
		firstName = "";
		lastName = "";
		hiredYear = 0;
		hiredMonth = 0;
		monthlySalary = 0;
	}

	void displayHireDate() {
		cout << hiredMonth << "/" << hiredYear;
	}

	int getYearlySalary()
	{
		int monthsInYear = 12;

		return monthlySalary * monthsInYear;
	}

	string getFirstName()
	{
		return firstName;
	}
	void setFirstName(string fn)
	{
		firstName = fn;
	}
	string getLastName()
	{
		return lastName;
	}
	void setLastName(string ln)
	{
		lastName = ln;
	}
	int getHiredYear()
	{
		return hiredYear;
	}
	void setHiredYear(int hy)
	{
		hiredYear = hy;
	}
	int getHiredMonth()
	{
		return hiredMonth;
	}
	void setHiredMonth(int hm)
	{
		hiredMonth = hm;

		if (hiredMonth < 1 || hiredMonth > 12)
		{
			hiredMonth = 1;
		}
	}
	int getMonthlySalary()
	{
		return monthlySalary;
	}
	void setMonthlySalary(int ms)
	{
		monthlySalary = ms;

		if (monthlySalary < 0)
		{
			monthlySalary = 0;
		}
	}
};

int main()
{
	// create two employee objects
	Employee emp1;
	Employee emp2;

	emp1.setFirstName("Matt");
	emp1.setLastName("Hunt");
	emp1.setHiredYear(2015);
	emp1.setHiredMonth(3);
	emp1.setMonthlySalary(5600);

	emp2.setFirstName("Phil");
	emp2.setLastName("Hiendel");
	emp2.setHiredYear(2016);
	emp2.setHiredMonth(5);
	emp2.setMonthlySalary(4200);

	// displays each employee’s yearly salary with the employee’s fist name and last name.
	cout << emp1.getFirstName() << " " << emp1.getLastName() << " $" << emp1.getYearlySalary() << endl;
	cout << emp2.getFirstName() << " " << emp2.getLastName() << " $" << emp2.getYearlySalary() << endl;

	// gives each employee a 10 percent raise and then display each employee’s yearly salary again.
	double tenPercentRaise = 1.10;
	emp1.setMonthlySalary(emp1.getMonthlySalary() * tenPercentRaise);
	emp2.setMonthlySalary(emp2.getMonthlySalary() * tenPercentRaise);
	cout << emp1.getFirstName() << " " << emp1.getLastName() << " $" << emp1.getYearlySalary() << endl;
	cout << emp2.getFirstName() << " " << emp2.getLastName() << " $" << emp2.getYearlySalary() << endl;

	// displays each employee’s hire date with the employee’s first and last name
	emp1.displayHireDate();
	cout << " " << emp1.getFirstName() << " " << emp1.getLastName() << endl;
	emp2.displayHireDate();
	cout << " " << emp2.getFirstName() << " " << emp2.getLastName() << endl;

	return 0;
}