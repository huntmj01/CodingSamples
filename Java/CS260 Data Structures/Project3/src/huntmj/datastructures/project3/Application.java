package huntmj.datastructures.project3;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		Project 3
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	12/12/2016
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
	public static void main(String[] args) {
		Test t = new Test();
		t.testArrayInsertionSort();
		t.testLinkedListInsertionSort();
		t.testArrayMergeSort();
		t.testLinkedListMergeSort();
		t.testHeapSort();
	}
	
}
