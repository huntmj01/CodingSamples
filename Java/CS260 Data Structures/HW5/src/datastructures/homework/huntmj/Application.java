package datastructures.homework.huntmj;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		Project 1
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	10/19/2016
 *
 * DESCRIPTION: The Application class contains the main method.
 *
 * CLASS METHODS:
 * 		main(String[] args)
 *  		The main method that runs the program.
 * 			
 **/
public class Application {
	
	/**
	 * 
	 * main() where the magic happens.
	 *
	 **/
	public static void main(String args[]) throws FileNotFoundException{
		
		//
		// declare local variables to hold stacks 
		// and input file information
		//
		LinkedStack<Integer> integerStack = new LinkedStack<Integer>();				// the actual stack that holds the sorted list of integers
		LinkedStack<Integer> temporaryIntegerStack = new LinkedStack<Integer>();	// temporary stack to help order the actual stack
		File file = new File("numbers.txt");										// holds the numbers text file
		Scanner inputFileScanner;													// file scanner for the input file
		
		// check to see if file exists
		if (!file.exists()){
			// notify the user that the file was not found
			JOptionPane.showMessageDialog(null, "File not found.");
			// exit the program
			System.exit(0);
		}
		
		// Initialize the input file scanner with the file
		inputFileScanner = new Scanner(file);
		
		
		/**
		 * 
		 * Big-O
		 * 
		 * In order to keep the stack sorted numerically, 
		 * a nested loop is needed. One loop to go through
		 * each item in the file and one loop to go through
		 * and push the items into a temporary stack until the
		 * item finds a top that is less than it is.
		 * 
		 * Therefore this algorithm is O(n^2)
		 * 
		 **/
		
		// loop through the file
		while(inputFileScanner.hasNext()){
			
			// retrieve the next integer from the file
			Integer item = inputFileScanner.nextInt();
			
			// check to see if the integer stack size is zero
			if (integerStack.size() == 0){
				
				// push the item to the stack
				integerStack.push(item);
			
			// else the stack size is not zero
			} else {
				
				// flag to hold whether item has been pushed or not
				boolean pushComplete = false;
				
				// loop until push is complete
				do {
					
					// check to see if integer stack size is zero or the item on the
					// top of the stack is less than that of item
					if (integerStack.size() == 0 || integerStack.peek() < item){
						
						// push the item to the stack
						integerStack.push(item);
						// set flag to true
						pushComplete = true;
						
					// else the item is less than the item that is on top of the stack
					}else{
						
						// pop the integer on the top of the stack and
						// push it to the temporary stack
						temporaryIntegerStack.push(integerStack.pop());
						
					}
					
				}while(!pushComplete);
				
				// loop through each item in the temporary stack
				while(!temporaryIntegerStack.isEmpty()){
					
					// pop the integer in the temporary stack and
					// place it back on the integer stack
					integerStack.push(temporaryIntegerStack.pop());
					
				}
			}				
		}
		
		// loop through each item in the integer stack
		while(!integerStack.isEmpty()){
			
			// pop integer and print it to the console
			System.out.println(integerStack.pop());
			
		}
		
		// close the scanner
		inputFileScanner.close();
	}
}

/**
 * 
 * PUSEDO CODE
 * 
 * declare stack
 * declare temporaryStack
 * declare file = numbers.txt
 * 
 * loop file.hasNext
 * 		declare item = file.nextItem
 * 		if stack = 0 then push item
 * 		else
 * 			declare pushComplete as flag
 * 			loop until pushComplete = true
 * 				if stack.size = 0 or stack.peek < item then
 * 					stack.push(item)
 * 					pushComplete = true
 * 				else
 * 					temporaryStack.push(integerStack.pop)
 * 			end loop
 * 			loop until temporaryStack.isEmpty
 * 				stack.push(temporaryStack.pop)
 * 			end loop
 * 		end if
 * end loop
 *
 * loop until stack.isEmpty
 * 		syso(stack.pop)
 * end loop
 * 
 **/
