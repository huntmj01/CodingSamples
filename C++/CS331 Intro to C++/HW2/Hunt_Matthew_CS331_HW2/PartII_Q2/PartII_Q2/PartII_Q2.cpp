/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/12/2018
* ASSIGNMENT:	HW2_PartII_Q2
*/

#include "stdafx.h"		// header file
#include <string>
#include <cctype>
#include <iostream>

using namespace std;

// Prototypes
bool isLongEnough(string s);
bool hasDigit(string s);
bool hasUpperAndLowerCase(string s);

const int LENGTH = 6; // Minimum length for a safe password

int main()
{
	// Explain program to user and request a password
	cout << "This program checks passwords to see if they are secure.";
	cout << "\nEnter a password to check: ";
	// Read user's input
	string password;
	cin >> password;
	// Check the password
	if (!isLongEnough(password))
	{
		cout << "Password must be at least six characters long.";
		exit(0);
	}
	if (!hasDigit(password))
	{
		cout << "Password must have at least one digit.";
		exit(0);
	}
	if (!hasUpperAndLowerCase(password))
	{
		cout << "Password must have both lower case and upper case letters.";
		exit(0);
	}
	cout << "The password " << password << " is OK.";
	return 0;
}

bool isLongEnough(string s)
{
	bool isLongEnough = true;

	if (s.length() < LENGTH) isLongEnough = false;

	return isLongEnough;
}

bool hasDigit(string s)
{
	bool hasDigit = false;

	for (int x = 0; x < s.length(); x++)
	{
		if (isdigit(s.at(x))) hasDigit = true;
	}

	return hasDigit;
}

bool hasUpperAndLowerCase(string s)
{
	bool hasUpperCase = false;
	bool hasLowerCase = false;
	bool hasUpperAndLowerCase = false;

	for (int x = 0; x < s.length(); x++)
	{
		if (isupper(s.at(x))) hasUpperCase = true;
		if (islower(s.at(x))) hasLowerCase = true;
	}

	hasUpperAndLowerCase = hasUpperCase && hasLowerCase;

	return hasUpperAndLowerCase;
}