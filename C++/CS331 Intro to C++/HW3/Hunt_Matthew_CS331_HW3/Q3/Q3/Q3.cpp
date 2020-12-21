/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/25/2018
* ASSIGNMENT:	HW3_Q3
*/

#include "stdafx.h"		// header file
#include "Point.h"
#include <iostream>		// precompiled class

using namespace std;	// standard library

int main()
{
	Point pt; // create point object
			  // ask user to enter point
	cout << "Enter a point in the form (x, y):\n";
	cin >> pt; // store user entered point

	if (!cin.fail()) { // validate input
		cout << "Point entered was: " << pt << endl; // display point
	}
	else {
		cout << "\nInvalid data\n"; // tell user invalid data was entered
	}

    return 0;
}

