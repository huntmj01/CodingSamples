/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/17/2018
* ASSIGNMENT:	HW2_PartII_Q4
*/

#include "stdafx.h"
#include <iostream>
#include "Hugeint.h"
using namespace std;

int main() {
	HugeInt n1{ 7654321 };
	HugeInt n2{ 7891234 };
	HugeInt n3{ "99999999999999999999999999999" };
	HugeInt n4{ "1" };
	HugeInt n5{ "12341234" };
	HugeInt n6{ "7888" };
	HugeInt result;

	cout << "n1 is " << n1 << "\nn2 is " << n2
		<< "\nn3 is " << n3 << "\nn4 is " << n4
		<< "\nn5 is " << n5 << "\nn6 is " << n6
		<< "\nresult is " << result << "\n\n";

	// test relational and equality operators

	if (n1 == n2) {
		cout << "n1 equals n2" << endl;
	}

	if (n1 != n2) {
		cout << "n1 is not equal to n2" << endl;
	}

	if (n1 < n2) {
		cout << "n1 is less than n2" << endl;
	}

	if (n1 > n2) {
		cout << "n1 is greater than n2" << endl;
	}

}