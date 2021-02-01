#pragma once
#include <string>
using namespace  std;

class Point
{
private:
	
public:
	int xCoordinate;
	int yCoordinate;
	Point();
	~Point();
	friend ostream& operator<<(ostream& os, const Point& pt);
	friend istream& operator>>(istream& is, Point& pt);

};

