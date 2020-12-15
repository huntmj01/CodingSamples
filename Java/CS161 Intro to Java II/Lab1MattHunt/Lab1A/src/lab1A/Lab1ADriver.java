package lab1A;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab1ADriver {
	
	public static void main (String args[]) throws FileNotFoundException{
		
		// file to hold the rectangle data file
		File f = new File("rectangleData.txt");
		
		// scanner to scan through the input file
		Scanner fileScn = new Scanner(f);
		
		// retrieve the size from the top of the array
		final int SIZE = fileScn.nextInt();
		
		// object array that will hold Rectangle objects
		Rectangle[] rect = new Rectangle[SIZE];
		
		// counter to keep track of iterations
		int count = 0;
		
		// loop until end of file
		while (fileScn.hasNext()){
			
			// retrieve  the rows colums and filled on the current line
			int rows = fileScn.nextInt();
			int cols = fileScn.nextInt();
			String fill = fileScn.next();
			
			// initialize the rectangle at the current index
			rect[count] = new Rectangle();
			
			// set the rows and colums of the rectangle at the current index
			rect[count].setNumRows(rows);
			rect[count].setNumCols(cols);
			
			// rectangle is filled
			if (fill.equals("filled")){
				rect[count].setFilled(true);
			}else{
				rect[count].setFilled(false);
			}
			
			// add 1 to the counter
			count++;
		}
		
		// loop through each rectangle
		for (Rectangle r : rect){
			
			// skip 2 lines
			System.out.print("\n\n");
			
			// check if the current rectangle is null
			if (r!=null){
				// print the toString to the console
				System.out.print(r.toString());
			}
		}
		
		// close the scanner
		fileScn.close();
	}
	
}
