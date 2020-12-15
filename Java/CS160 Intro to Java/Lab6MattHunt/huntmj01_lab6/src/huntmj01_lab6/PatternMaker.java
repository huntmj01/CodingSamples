package huntmj01_lab6;

import java.io.*;
import java.util.Scanner;

public class PatternMaker {

	public static void main(String[] args) throws IOException {
		
		//create a scanner to retrieve user input
		Scanner scan = new Scanner(System.in);
		
		//ask user for pattern type
		System.out.print("Enter a pattern type: ");
		String patternType = scan.nextLine();
		
		//ask user for number of lines
		System.out.print("Enter the number of lines: ");
		int numOfLines = scan.nextInt();
		
		//create a print writer to write shape to file
		PrintWriter writer =  new PrintWriter("Pattern.txt", "UTF-8");
			
		//determine which pattern the user chose. If neither square or rectangle was entered, tells
		//the user to buzz off and end the program.
		if (patternType.equals("rectangle")){
			
			//If the pattern input is rectangle, print out a three wide rectangle of @
			//that is numLines lines long using a for loop to print that number
			//of lines. (That is, run the loop from 0 to numLines)
			
			String rectangle = "";
			
			for (int line = 0; line < numOfLines; line++){
				rectangle += "@@@\n";
			}
			
			System.out.print(rectangle);
			
			//write rectangle to file
			writer.print(rectangle);
			
		}else if (patternType.equals("square")){
			
			 //If the pattern input is square, print out a numLines by numLines square of a
			 //symbol of !. This will required the use of print and nested for loops (a for loop
			 //for square width and a for loop for square height). Note that the outermost loop (the one
			 //that controls height) should print the newlines and the innermost loop (the one that
			 //controls width for each new row) should print symbols.
			
			for (int height = 0; height < numOfLines; height++){
				
				String square = "";
				
				for (int width = 0; width < numOfLines; width++){
					square += "!";
				}
				
				System.out.println(square);
				
				//write square to file
				writer.print(square+ "\n");
				
			}
			
		}else{
			
			//notify user that they have failed
			System.out.println("Buzz off!!!");
			//end the program
			System.exit(0);
			
		}
		
		//close the scanner and the writer
		scan.close();
		writer.close();
		
	}

}
