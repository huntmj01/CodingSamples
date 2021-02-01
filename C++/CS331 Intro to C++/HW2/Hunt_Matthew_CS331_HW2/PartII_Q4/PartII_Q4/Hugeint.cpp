/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/17/2018
* ASSIGNMENT:	HW2_PartII_Q4
*/

// Hugeint.cpp
// HugeInt member-function and friend-function definitions.

#include "stdafx.h"
#include <iostream>
#include <stdexcept>
#include <cctype> // isdigit function prototype
#include "Hugeint.h" // HugeInt class definition

using namespace std;

// default constructor; conversion constructor that converts
// a long integer into a HugeInt object
HugeInt::HugeInt(long value) {
	// initialize array to zero
	for (size_t i{ 0 }; i < digits; ++i) {
		integer[i] = 0;
	}

	// place digits of argument into array
	for (int j{ digits - 1 }; value != 0 && j >= 0; --j) {
		integer[j] = value % 10;
		value /= 10;
	}
}

// conversion constructor that converts a character string
// representing a large integer into a HugeInt object
HugeInt::HugeInt(const string& number) {
	// initialize array to zero
	for (size_t i{ 0 }; i < digits; ++i) {
		integer[i] = 0;
	}

	// place digits of argument into array
	size_t length{ number.size() };

	for (size_t j{ digits - length }, k{ 0 }; j < digits; ++j, ++k) {
		if (isdigit(number[k])) {
			integer[j] = number[k] - '0';
		}
	}
}

// equality operator; HugeInt == HugeInt
bool HugeInt::operator==(HugeInt hugeInt)
{
	bool isEqual = true;

	int i = 0; // used for looping

	for (; i < 40; ++i) { // display the HugeInteger
		if (hugeInt.integer[i] != integer[i]) {
			isEqual = false;
		}
	}

	return isEqual;
}

// inequality operator; HugeInt != HugeInt
bool HugeInt::operator!=(HugeInt hugeInt){
	bool isNotEqual = false;

	int i = 0; // used for looping

	for (; i < 40; ++i) { // display the HugeInteger
		if (hugeInt.integer[i] != integer[i]) {
			isNotEqual = true;
		}
	}

	return isNotEqual;
}

// less than operator; HugeInt < HugeInt
bool HugeInt::operator<(HugeInt hugeInt) {
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

// greater than operator; HugeInt > HugeInt
bool HugeInt::operator>(HugeInt hugeInt) {
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

// overloaded output operator
ostream& operator<<(ostream& output, const HugeInt& num) {
	size_t i;

	for (i = 0; i < HugeInt::digits && num.integer[i] == 0; ++i) {
		; // skip leading zeros
	}

	if (i == HugeInt::digits) {
		output << 0;
	}
	else {
		for (; i < HugeInt::digits; ++i) {
			output << num.integer[i];
		}
	}

	return output;
}