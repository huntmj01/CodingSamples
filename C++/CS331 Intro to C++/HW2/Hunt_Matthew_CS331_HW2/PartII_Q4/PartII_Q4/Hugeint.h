/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/17/2018
* ASSIGNMENT:	HW2_PartII_Q4
*/

// Hugeint.h
// HugeInt class definition.
#ifndef HUGEINT_H
#define HUGEINT_H

#include <iostream>
#include <string>
using namespace std;

class HugeInt
{
	friend ostream &operator<<(ostream&, const HugeInt&);
public:
	static const size_t digits = 30; // maximum digits in a HugeInt

	HugeInt(long = 0);			// conversion/default constructor
	HugeInt(const string&);		// conversion constructor

	bool operator==(HugeInt);	// equality operator
	bool operator!=(HugeInt);	// inequality operator
	bool operator<(HugeInt);	// less than operator
	bool operator>(HugeInt);	// greater than operator

private:
	short integer[digits];
};

#endif