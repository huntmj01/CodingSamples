/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/25/2018
* ASSIGNMENT:	HW3_Q3
*/

#include "stdafx.h"
#include "Point.h"
#include <iostream>		// precompiled class
#include <string>

using namespace std;	// standard library'

Point::Point()
{
}

Point::~Point()
{
}

ostream& operator<<(ostream& os, const Point& pt)
{
	os << "(" << pt.xCoordinate << "," << pt.yCoordinate << ")";
	return os;
}

istream& operator>>(istream& is, Point& pt){
	
	bool fail = false;

	char c;
	is.read(&c, 1);
	if (c != '(')
	{
		fail = true;
	}

	is >> pt.xCoordinate;
	
	is.read(&c, 1);
	if (c != ',')
	{
		fail = true;
	}

	is.read(&c, 1);
	if (c != ' ')
	{
		fail = true;
	}

	is >> pt.yCoordinate;

	is.read(&c, 1);
	if (c != ')')
	{
		fail = true;
	}

	if (fail)
	{
		cin.setstate(ios::failbit);
	}

	return is;
}