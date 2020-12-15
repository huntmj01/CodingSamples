package lab1B;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab1BDriver {

	public static void main(String[] args) throws FileNotFoundException {
		
		// create an array of students, the max size is 30
		Student[] students = new Student[30];
		
		// file to hold lab1b.in
		File f = new File("Lab1B.in");
		// scanner to recieve data from file
		Scanner scan = new Scanner(f);
		// print writer to print results to file
		PrintWriter pw;
		
		// counter to keep track of iterations
		int count = 0;
		
		// create an array of grades that will hold all of the grades
		// from the text file
		int[][] grades = new int[30][5];
		
		// loop until scanner hits the end of file
		while (scan.hasNext()){
			
			// initialize the student at the current index 
			students[count] = new Student();
			
			// set the name of the student at the current index
			students[count].setName(scan.next());
		
			// loop 5 times since there are 5 grades per student
			for (int i = 0; i < 5; i++){
				// set the grades of the student at the current index
				grades[count][i] = scan.nextInt();
			}
			
			// add 1 to the counter
			count++;
		}
		
		// create the output file
		File of = new File("Lab1B.out");
		
		// set the print writer to the output file
		pw = new PrintWriter(of);
		
		// write header to output file
		pw.println("Student" + "\t" + "1" + "\t" + "2" + "\t" + "3" + "\t" + "4" + "\t" + "5" + "\t" + "Average" +"\t" +"Grade");
		
		// skip line
		pw.println("");
		
		// double to hold the sum of all the students averages
		double sum = 0;
		
		// loop through students
		for (int i = 0; i < students.length; i++){
			
			// if the current student or grade is null end the loop
			if (students[i] == null || grades[i] == null){break;}
			
			// set the score of the student at the current index
			students[i].setScores(grades[i]);
			
			// calculate the average of the student at the current index
			students[i].calculateAverage();
			
			// calculate the grade of the student at the current index
			students[i].calculateGrade();
			
			// print to output file
			students[i].generateOutput(pw);
			
			// add to the sum
			sum += students[i].getAverage();
		}
		
		// calculate the class average by dividing the sum by the count
		double classAvg = sum / count;
		
		// skip a line in the file
		pw.println();
		
		// print the class average to the output file
		pw.println("Class average: " + classAvg);
		
		// close the print writer
		pw.close();
		
	}
}
