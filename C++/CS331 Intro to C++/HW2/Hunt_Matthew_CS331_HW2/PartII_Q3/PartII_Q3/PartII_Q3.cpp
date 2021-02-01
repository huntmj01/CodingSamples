/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/17/2018
* ASSIGNMENT:	HW2_PartII_Q3
*/

#include "stdafx.h"		
#include <iostream>
#include "HugeInteger.h" // include definition of class HugeInteger

using namespace std;

int main() {

	HugeInteger n1{ 7654321 }; // HugeInteger object n1
	HugeInteger n2{ "100000000000000" }; // HugeInteger object n2
	HugeInteger n3; // HugeInteger object n3
	HugeInteger n4{ 5 }; // HugeInteger object n4
	HugeInteger n5; // HugeInteger object n5   

	// checks for equality between n2 and n2 
	if (n2.isEqualTo(n2)) {
		cout << n2.toString() << " is equal to " << n2.toString() << "\n\n";
	}

	// checks for inequality between n1 and n2
	if (n1.isNotEqualTo(n2)) {
		cout << n1.toString() << " is not equal to " << n2.toString() << "\n\n";
	}

	// tests for greater number between n2 and n1 
	if (n2.isGreaterThan(n1)) {
		cout << n2.toString() << " is greater than " << n1.toString() << "\n\n";
	}

	// tests for smaller number between n4 and n2
	if (n4.isLessThan(n2)) {
		cout << n4.toString() << " is less than " << n2.toString() << "\n\n";
	}

	// tests for zero at n3
	if (n3.isZero()) {
		cout << "n3 contains " << n3.toString() << "\n";
	}
	
}
