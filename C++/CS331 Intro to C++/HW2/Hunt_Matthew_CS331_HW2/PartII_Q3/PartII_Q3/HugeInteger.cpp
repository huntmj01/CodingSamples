/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/17/2018
* ASSIGNMENT:	HW2_PartII_Q3
*/

// HugeInteger.cpp
// Member-function definitions for class HugeInteger.
#include "stdafx.h"
#include <iostream>
#include <sstream>
#include "HugeInteger.h" // include definition of class HugeInteger 

using namespace std;

// default constructor; conversion constructor that converts
// a long integer into a HugeInteger object
HugeInteger::HugeInteger(long value) {
	// initialize array to zero
	for (int i{ 0 }; i < 40; ++i) {
		integer[i] = 0;
	}

	// place digits of argument into array 
	for (int j{ 39 }; value != 0 && j >= 0; --j) {
		integer[j] = static_cast< short >(value % 10);
		value /= 10;
	}
}


// copy constructor; 
// converts a char string representing a large integer into a HugeInteger
HugeInteger::HugeInteger(const string& string) {
	// initialize array to zero
	for (int i{ 0 }; i < 40; ++i) {
		integer[i] = 0;
	}

	// place digits of argument into array
	unsigned int length{ string.size() };

	for (unsigned int j{ 40 - length }, k{ 0 }; j < 40; ++j, ++k) {
		if (isdigit(string[k])) {
			integer[j] = string[k] - '0';
		}
	}
}


// function that tests if two HugeIntegers are equal
bool HugeInteger::isEqualTo(const HugeInteger& hugeInt)
{
	bool isEqual = true;

	int i = 0; // used for looping

	for (; i < 40; ++i) { // display the HugeInteger
		if (hugeInt.integer[i] != integer[i]){
			isEqual = false;
		}
	}

	return isEqual;
}

// function that tests if two HugeIntegers are not equal
bool HugeInteger::isNotEqualTo(const HugeInteger& hugeInt)
{
	bool isNotEqual = false;

	int i = 0; // used for looping

	for (; i < 40; ++i) { // display the HugeInteger
		if (hugeInt.integer[i] != integer[i]) {
			isNotEqual = true;
		}
	}

	return isNotEqual;
}

// function to test if one HugeInteger is greater than another
bool HugeInteger::isGreaterThan(const HugeInteger& hugeInt)
{
	bool isGreaterThan = false;

	int i = 0; // used for looping

	for (; i < 40; ++i) { // display the HugeInteger
		if (hugeInt.integer[i] > integer[i]) {
			isGreaterThan = false;
			break;
		}
		else if (hugeInt.integer[i] < integer[i])
		{
			isGreaterThan = true;
			break;
		}
	}

	return isGreaterThan;
}

// function that tests if one HugeInteger is less than another
bool HugeInteger::isLessThan(const HugeInteger& hugeInt)
{
	bool isLessThan = false;

	int i = 0; // used for looping

	for (; i < 40; ++i) { // display the HugeInteger
		if (hugeInt.integer[i] < integer[i]) {
			isLessThan = false;
			break;
		}
		else if (hugeInt.integer[i] > integer[i])
		{
			isLessThan = true;
			break;
		}
	}

	return isLessThan;
}

// function that tests if a HugeInteger is zero
bool HugeInteger::isZero()
{
	bool isZero = true;

	int i = 0; // used for looping

	for (; i < 40; ++i) { // display the HugeInteger
		if (integer[i] != 0) {
			isZero = false;
		}
	}

	return isZero;
}

// overloaded output operator
string HugeInteger::toString() const {
	int i; // used for looping

	for (i = 0; (i < 40) && (integer[i] == 0); ++i) {
		; // skip leading zeros
	}
	if (i == 40) {
		return "0";
	}
	else {
		ostringstream output;

		for (; i < 40; ++i) { // display the HugeInteger
			output << integer[i];
		}

		return output.str();
	}
}
