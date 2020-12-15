package com.test.hw1;

/*
NAME:		Matthew Hunt
PROJECT:	HW 1
COURSE:		CS 260
INSTRUCTOR:	Petruska
DUE DATE:	September 3, 2016

DESCRIPTION:
	A Average represents an array of numbers whose averages can be calculated.

CONSTRUCTOR METHODS:
  Average
    Constructs a average and sets the numberArray variable.

INSTANCE VARIABLES:
  numberArray
    Holds the number array passed to the class.   

INSTANCE METHODS:
  computeAverage
    Returns the average of the number array.
  compareAverage
    Returns whether or not the two number arrays have the same average.
*/

// generic class
public class Average<T extends Number>{ // Type has to extend number

	//
	// declare instance variable to hold number array 
	//
	private T[] numberArray;
	
	/**
	 * 
	 * Constructs a average and sets the number array
	 * to that which was passed to the class
	 * 
	 **/
	public Average(
			T[] numberArray	// the number array passed to the class
			) {
		this.numberArray = numberArray;
	} // end Average()
	
	/**
	 * 
	 * computeAverage() is a generic method that computes
	 * the average of a number array and returns the
	 * average as a double.  The method uses a for loop
	 * to add up all of the numbers in the array.  Once
	 * out of the for loop, the average is calculated by
	 * dividing the sum by the number array length. The 
	 * average is then returned. 
	 * 
	 **/
	@SuppressWarnings("hiding")
	public <T> double computeAverage(){
		
		//
		// declare local variables to hold sum
		// and average of the number array
		//
		double sum = 0;
		double avg = 0;
		
		//
		// loop through the number array to get the sum,
		// divide the sum by the number array length to
		// get the average, then return the average
		//
		for (int i = 0; i < numberArray.length; i++){
			sum += numberArray[i].doubleValue();
		}
		
		avg = sum/numberArray.length;
		
		return avg;
		
	}// end computeAverage()
	
	/**
	 * 
	 * compareAverage() is a method that compares
	 * the average of a number array to that of another
	 * number array and returns true if they are the same. 
	 * The method uses an if statement to check the average
	 * of the current array. Once the averages have been
	 * compared, a boolean is then returned.
	 * 
	 **/
	public boolean compareAverage(
			Average<?> other	// the other array to compare of any average type 
			){
		
		//
		// declare local variable to flag whether
		// or not the averages are the same
		//
		boolean isTheSame = false;
		
		//
		// check if the array averages are the same,
		// if so set isTheSame flag to true, then 
		// return the flag
		//
		if (this.computeAverage()  == other.computeAverage())
			isTheSame = true;
		
		return isTheSame;
		
	}// end compareAverage()
	
}// end class Average
