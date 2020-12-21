/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/17/2018
* ASSIGNMENT:	HW2_PartII_Q3
*/

// HugeInteger.h
// HugeInteger class definition.
#ifndef HUGEINTEGER_H
#define HUGEINTEGER_H
#include <array>
#include <string>

class HugeInteger {
public:
	HugeInteger(long = 0); // conversion/default constructor
	HugeInteger(const std::string&); // copy constructor

									 // is equal to
									 // not equal to
									 // greater than
									 // less than
									 // is zero

	std::string toString() const; // output   

	bool isEqualTo(const HugeInteger&);
	bool isNotEqualTo(const HugeInteger&);
	bool isGreaterThan(const HugeInteger&);
	bool isLessThan(const HugeInteger&);
	bool isZero();
private:
	std::array<short, 40> integer; // 40 element array
};

#endif