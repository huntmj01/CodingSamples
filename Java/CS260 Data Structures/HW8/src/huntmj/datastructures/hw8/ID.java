package huntmj.datastructures.hw8;

import java.util.Random;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		HW8 
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	12/01/2016
 * 
 * DESCRIPTION: An ID consists of a first
 * and second integer.
 * 
 * CONSTRUCTOR METHODS:
 * 		ID()
 * 			Constructs an ID with two random
 * 			integers both between 0 and 2 million.
 * 		ID(int first, int second)
 * 			Constructs an ID with the two
 * 			integers specified.
 * 
 * INSTANCE VARIABLES:
 * 		first
 * 			The first number of the ID.
 * 		second
 * 			The second number of the ID.
 * 
 * INSTANCE METHODS:
 * 		equals() 
 * 			compares the given ID to 
 * 			this ID and returns whether
 * 			or not they are the same.
 * 			
 **/
public class ID {
	
	//
	// declare fields to hold the
	// first and second number of 
	// the id
	//
	int first;
	int second;
	
	// Constructs an ID with two random
	// integers between 0 and two million
	public ID(){
		
		// generate two random integers
		// between 0 and 2 million
		Random rand = new Random();
		first = rand.nextInt(2000000000);
		second = rand.nextInt(2000000000);
		
	}
	
	// Constructs an ID with the integers
	// specified
	public ID(
			int first, 		// the first integer
			int second		// the second integer
			){
		
		this.first = first;
		this.second = second;
		
	}
	
	/**
	 * 
	 * equals() compares this ID to the 
	 * given ID and returns whether or
	 * not they are equal.
	 * 
	 */
	public boolean equals(
			ID id			
			){
		
		// check if this Student's first/second integer equals that 
		// of the first/second integer of the Student specified
		if (id.first == this.first && id.second == id.first){
			return true;
		}
		// else they are not the same so return false
		return false;
	}
	
}
