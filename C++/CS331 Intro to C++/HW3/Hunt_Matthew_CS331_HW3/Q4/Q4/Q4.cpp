/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/27/2018
* ASSIGNMENT:	HW3_Q4
*/
#include "stdafx.h"
#include <iostream>
#include <fstream>

using namespace std;

// Declaration of Invtry structure
const int DESC_LEN = 31;
const int DATE_LEN = 11;

struct Invtry
{
	char desc[DESC_LEN];
	int qty;
	double wholeSale;
	double retail;
	char date[DATE_LEN];
};

// Function Prototypes
void addRecord();
void viewRecord();
void changeRecord();

fstream inventory;

int main()
{
	int choice = 0;

	do
	{
		// Display menu
		cout << "\n1. Add a new record\n";
		cout << "2. View an existing record\n";
		cout << "3. Change an existing record\n";
		cout << "4. Exit\n\n";

		// Get user's choice
		do
		{
			cout << "Enter your choice (1-4): ";
			cin >> choice;

		} while (choice < 1 && choice > 4);    //FILL

					   // Process the user's choice
		switch (choice)
		{
		case 1:
			addRecord();
			break;
		case 2:
			viewRecord();
			break;
		case 3:
			changeRecord();
		}
	} while (choice != 4);

	return 0;

}

//********************************
//  Implement   addRecord()             
//  - Add a record.                
//********************************
void addRecord()
{
	Invtry record;

	// Fill - Open file
	inventory.open("inventory.txt");

	if (inventory.is_open())    //FILL
	{
		cout << "Error opening file.\n";
		return;
	}
	cin.get();

	// Get description
	cout << "\nEnter the following inventory data:\n";
	cout << "Description: ";
	//FILL
	cin >> record.desc;

	// Get quantity
	do
	{
		cout << "Quantity: ";
		//FILL
		cin >> record.qty;
		if (record.qty < 0)
			cout << "Enter a positive value, please.\n";
	} while (record.qty < 0);              //FILL

							 // Get wholesale cost  
							 /* FILL */
	do
	{
		cout << "Wholesale cost: ";
		//FILL
		cin >> record.wholeSale;
		if (record.wholeSale < 0)
			cout << "Enter a positive value, please.\n";
	} while (record.wholeSale < 0);


							 // Get retail price
							 /* FILL */
	do
	{
		cout << "Retail price: ";
		//FILL
		cin >> record.retail;
		if (record.retail < 0)
			cout << "Enter a positive value, please.\n";
	} while (record.retail < 0);


							 // Get date 
	cout << "Date added to inventory: ";
	cin >> record.date;                      //FILL

								 // Write the inventory record to the file
								 //FILL
	inventory << record.desc << ' ' << record.qty << ' ' << record.wholeSale << ' ' << record.retail << ' ' << record.date << endl;

								 // Check if successs
		if (inventory.fail())   //FILL
			cout << "Error writing record to file.\n";
		else
			cout << "record written to file.\n\n";
	inventory.close();
}

// *********************************
//   Implement  viewRecord()
//  - View a record.                  
// *********************************
void viewRecord()
{
	Invtry record;
	long recNum;

	// Open file for reading
	/* FILL  */
	inventory.open("inventory.txt");

	// Get number of record to view and seek to it
	cout << "\nEnter the record number of the item: ";
	cin >> recNum;
	// FILL -  Locate the corresponding record in the file. 

	bool success = false;
	int i = 1;
	while (inventory >> record.desc >> record.qty >> record.wholeSale >> record.retail >> record.date)
	{
		if (recNum == i)
		{
			cout << record.desc << record.qty << record.wholeSale << record.retail << record.date;
			success = true;
		}
		i++;
	}

	// Check if success when seeking
	if (success) //FILL
	{
		cout << "\nError locating record.\n";
		inventory.close();
		return;
	}

	// FILL - Read the record

	inventory.close();

	// Display the record read
	/* FILL  */

	cout << "Press any key to continue...\n ";
	cin.get();
}

// *******************************
//  Implement changeRecord()
//  -- Change a record               *
// *******************************
void changeRecord()
{
	Invtry record;
	long recNum;

	// FILL - Open the file
	inventory.open("inventory.txt");
	if (inventory.is_open()) //FILL
	{
		cout << "Error opening file.\n";
		return;
	}

	//  Find out which record to alter and seek to it
	cout << "Enter the record number of the item: ";
	/* FILL */



	// Display the  record
	cout << "Current record contents:\n";


	// Allow user to edit the record
	cout << "Enter the new data:\n";
	cin.get();
	cout << "Description: ";
	//FILL
	cout << "Quantity: ";
	//FILL
	cout << "Wholesale cost: ";
	//FILL
	cout << "Retail price: ";
	//FILL
	cout << "Date added to inventory: ";
	//FILL

	// Write the record back to the file
	/*  Fill  */



	cout << "Press any key to continue... ";
	cin.get();
}



