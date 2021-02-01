/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/30/2018
* ASSIGNMENT:	HW4_Q1
*/

#include "stdafx.h"
#include <iostream>
#include <string>

using namespace std;

class StrExcept { };   //String Out of Bounds Exception

					   // COMPLETE
class BCheckString : public string
{
public:
	/*
	A BCheckString(string s) constructor that receives a string object passed by
	value and passes it on to the base class constructor. It just calls the base class constructor
	using its constructor initialization list
	*/
	BCheckString::BCheckString(string s) :string(s)
	{
	}

	/*
	A overloaded operator function, char operator[ ](int k), throws an
	exception, a BoundsException object (i.e., StrExcept()) if its parameter, k is
	out bounds (i.e., negative or greater than or equal to the length of the string), otherwise it
	will return the character at position k in the string with calling operator [] in the
	string base class
	*/
	char BCheckString::operator[](int k)
	{
		// negative or greater than or equal to the length of the string
		if (k < 0 || k >= this->length())
		{
			throw StrExcept();
		}

		return string::operator[](k);
	}
};

int main()
{
	//Explain program to user
	cout << "This program demonstrates bounds checking on string object.";

	//Get string from user and create boundCheck string object
	cout << "\nEnter a string: ";
	string str;
	getline(cin, str);
	BCheckString h(str);

	//Let user access characters at specified positions in the string
	//COMPLETE

	/*
	* Test your class with a main function that attempts to access characters that are within and
	outside the bounds of a suitably initialized BCheckString objects
	*/

	cout << "Legitimate string positions are: " << 0 << ".." << h.length() - 1 << endl;
	for (int k = 1; k <= 5; k++)
	{
		cout << "Enter an integer describing a position inside or outside the string: ";
		int pos;
		cin >> pos;
		cout << "The character at position " << pos << " is " << h[pos] << endl;
	}

	return 0;
}