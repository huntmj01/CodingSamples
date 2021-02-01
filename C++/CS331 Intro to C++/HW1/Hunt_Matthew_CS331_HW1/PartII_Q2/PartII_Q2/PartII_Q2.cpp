/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/4/2018
* ASSIGNMENT:	HW1_PartII_Q2
*/

#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

bool isValidPrimaryColor(string color)
{
	bool isValid = false;

	if (color.compare("red") == 0 || color.compare("blue") == 0 || color.compare("yellow") == 0)
	{
		isValid = true;
	}

	return isValid;
}

string mixColors(string firstPrimaryColor, string secondPrimaryColor)
{
	string secondaryColor = "failed to mix colors";

	if (firstPrimaryColor.compare("red") == 0 && secondPrimaryColor.compare("blue") == 0)
	{
		secondaryColor = "purple";
	}
	else if (firstPrimaryColor.compare("red") == 0 && secondPrimaryColor.compare("yellow") == 0)
	{
		secondaryColor = "orange";
	}
	else if (firstPrimaryColor.compare("blue") == 0 && secondPrimaryColor.compare("red") == 0)
	{
		secondaryColor = "purple";
	}
	else if (firstPrimaryColor.compare("blue") == 0 && secondPrimaryColor.compare("yellow") == 0)
	{
		secondaryColor = "green";
	}
	else if (firstPrimaryColor.compare("yellow") == 0 && secondPrimaryColor.compare("red") == 0)
	{
		secondaryColor = "orange";
	}
	else if (firstPrimaryColor.compare("yellow") == 0 && secondPrimaryColor.compare("blue") == 0)
	{
		secondaryColor = "green";
	}

	return secondaryColor;
}

int main()
{
	string firstColorInput = "";
	string secondColorInput = "";
	string secondaryColor = "";

	cout << "Enter First Primary Color: ";
	cin >> firstColorInput;

	cout << "Enter Second Primary Color: ";
	cin >> secondColorInput;

	if (!(isValidPrimaryColor(firstColorInput) && isValidPrimaryColor(secondColorInput)))
	{
		cout << "Invalid input. " << endl;
		exit(0);
	}

	secondaryColor = mixColors(firstColorInput, secondColorInput);

	cout << "When you mix " << firstColorInput << " and " << secondColorInput << ", you get " << secondaryColor << "." << endl;

	return 0;
}