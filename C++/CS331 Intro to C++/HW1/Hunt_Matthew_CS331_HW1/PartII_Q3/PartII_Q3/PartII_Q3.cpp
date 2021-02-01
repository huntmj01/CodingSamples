/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/4/2018
* ASSIGNMENT:	HW1_PartII_Q3
*/

#include "stdafx.h"		
#include <iostream>		

using namespace std;

int main()
{
	int monkeyDiet[3][7];

	monkeyDiet[0][0] = 1;
	monkeyDiet[0][1] = 3;
	monkeyDiet[0][2] = 2;
	monkeyDiet[0][3] = 4;
	monkeyDiet[0][4] = 3;
	monkeyDiet[0][5] = 2;
	monkeyDiet[0][6] = 1;

	monkeyDiet[1][0] = 2;
	monkeyDiet[1][1] = 5;
	monkeyDiet[1][2] = 3;
	monkeyDiet[1][3] = 6;
	monkeyDiet[1][4] = 1;
	monkeyDiet[1][5] = 4;
	monkeyDiet[1][6] = 3;

	monkeyDiet[2][0] = 4;
	monkeyDiet[2][1] = 2;
	monkeyDiet[2][2] = 5;
	monkeyDiet[2][3] = 3;
	monkeyDiet[2][4] = 2;
	monkeyDiet[2][5] = 1;
	monkeyDiet[2][6] = 1;

	// calculate average amount of food per day by all monkeys
	int totalLbs = 0;
	int avgAmountOfFoodPerDay = 0;
	int rows = sizeof monkeyDiet / sizeof monkeyDiet[0];
	int cols = sizeof monkeyDiet[0] / sizeof(int);

	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < cols; j++)
		{
			totalLbs += monkeyDiet[i][j];
		}
	}

	avgAmountOfFoodPerDay = (totalLbs / rows) / cols;

	// The least amount of food eater during the week by any one monkey
	int leastAmtOfFood = 0;

	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < cols; j++)
		{
			totalLbs += monkeyDiet[i][j];
		}
		if (i == 0 || totalLbs < leastAmtOfFood)
		{
			leastAmtOfFood = totalLbs;
		}
		totalLbs = 0;
	}

	// The greatest amount of food eaten during the week by any one monkey. 
	int greatestAmtOfFood = 0;

	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < cols; j++)
		{
			totalLbs += monkeyDiet[i][j];
		}
		if (i == 0 || totalLbs > greatestAmtOfFood)
		{
			greatestAmtOfFood = totalLbs;
		}
		totalLbs = 0;
	}

	cout << "Avg amount of food for all monkies: " << avgAmountOfFoodPerDay << endl;
	cout << "Least amount of food eaten by monkey: " << leastAmtOfFood << endl;
	cout << "Greatest amount of food eaten by monkey: " << greatestAmtOfFood << endl;

	return 0;
}