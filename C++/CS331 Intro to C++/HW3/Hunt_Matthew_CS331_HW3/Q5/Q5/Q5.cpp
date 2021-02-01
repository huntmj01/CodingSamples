/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/27/2018
* ASSIGNMENT:	HW3_Q5
*/

#include "stdafx.h"

#include <iostream>
#include <string>
#include <vector>

using namespace std;

/********************************************
*     A template function                  *
* Accumulates by adding or concatenating   *
* all elements of the vector v.            *
********************************************/

template <class T>
T accum(vector<T> v)
{
	T result = T();

	for (auto& n : v)
	{
		result += n;
	}
		
	return result;
}

int main()
{

	// Explain program
	cout << "This homework demonstrates accumulation using templates.\n";

	// Get numeric types from the user
	vector<double> dvec;
	double dvalue;
	cout << "Enter 3 numbers: ";
	cin >> dvalue;
	dvec.push_back(dvalue);
	cin >> dvalue;
	dvec.push_back(dvalue);
	cin >> dvalue;
	dvec.push_back(dvalue);

	// Process and output results
	double sum = accum(dvec);
	cout << "The sum of the numbers is " << sum << endl;

	// Get string inputs from user
	vector<string> svec;
	string svalue;
	cout << "Enter 3 strings: ";
	cin >> svalue;
	svec.push_back(svalue);
	cin >> svalue;
	svec.push_back(svalue);
	cin >> svalue;
	svec.push_back(svalue);

	// Process and output results
	string str_sum = accum(svec);
	cout << "The sum of the strings  is " << str_sum << endl;

	return 0;
}