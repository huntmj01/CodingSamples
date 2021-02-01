/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			08/03/2018
* ASSIGNMENT:	HW4_Q2
*/

#include "stdafx.h"

#include <vector>
#include <iostream>
#include <string>

using namespace std;

// rotateLeft template function - void rotateLeft (vector <T>& v)
template <typename Type>
void rotateLeft (vector<Type>& v)
{
	Type valAtIndex1 = v.at(0);
	v.push_back(valAtIndex1);
	v.erase(v.begin());
}

// output template function - void output(vector<T> v)
template <typename Type>
void output(vector<Type> v)
{
	for (unsigned int i = 0; i < v.size(); i++)
	{
		cout << v.at(i) << " ";
	}
}

int main(int argc, char** argv)
{
	// Create a vector v with "1 3 5 7"
	
	vector<int> v;

	v.push_back(1);
	v.push_back(3);
	v.push_back(5);
	v.push_back(7);

	for (int k = 0; k < v.size(); k++)
	{
		cout << k << ": ";
		output(v);
		cout << endl;
		rotateLeft(v);
	}

	cout << endl;

	string  as[] = { "a", "b", "c", "d", "e" };

	// Create a vector vs with "a b c d e"

	vector<string> vs;

	vs.push_back("a");
	vs.push_back("b");
	vs.push_back("c");
	vs.push_back("d");
	vs.push_back("e");

	for (int k = 0; k < vs.size(); k++)
	{
		output(vs);
		cout << endl;
		rotateLeft(vs);
	}
	return 0;
}