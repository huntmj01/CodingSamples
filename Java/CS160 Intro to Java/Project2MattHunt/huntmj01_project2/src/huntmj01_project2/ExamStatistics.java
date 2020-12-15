/* * Matthew Hunt * CS16000 Fall 2015 * Project 2:
Exam Statistics * * Description: This program allows
the user to select a file with exam scores.  Once the
program confirms that the file exists, the data is 
imported and then used to find the number of scores,
minimum, grade total, maximum, scores at or above 70, 
percent of scores above 70, scores above average,
and percent of scores above average. Once those 
numbers are calculated, the results are printed
to the console and also printed to the 
ExamStatFile.txt file.*/

package huntmj01_project2;

//Imports

//File is used to retrieve the users file that holds 
//the exam scores.
import java.io.File;

//IOException is used to throw IOExceptions in 
//the main method in case file is not found.
import java.io.IOException;

//Print Writer is used to print the results to 
//the ExamStatFile.txt file.
import java.io.PrintWriter;

//Decimal format is used to format the The average to
//be rounded to one decimal place. The percentages of scores will
//also rounded to one decimal place.  Everything else
//will be formated to have no decimals.
import java.text.DecimalFormat;

//Scanner is used to retrieve scores from the user's
//input file.
import java.util.Scanner;

//JOptionPane is used to retrieve input file name from user
//and also alert the user if the file is not found.
import javax.swing.JOptionPane;

public class ExamStatistics {

	//constant to pass the exam
	public int PASSING_CUTOFF = 70;
	
	public static void main(String[] args) throws IOException {	//throws IOException if file is not found

		// variables, in order of use when results are printed
		
		// The integer numOfScores is a counter for the total number
		// of scores found in the file.
		int numOfScores = 0;
		
		// The double min is used to store the minimum score found
		// in the file.
		double min = 0.0;
		
		// The double scoreTotal holds the total of all the scores
		// in the file and will be used to calculate the average.
		double scoreTotal = 0.0;
		
		// The double avg will be used to hold the average of 
		// the scores found in the file.
		double avg = 0.0;
		
		// The double max is used to store the maximum score found
		// in the file.
		double max = 0.0;
		
		// The integer scoresAtOrAbove70 is a counter for the
		// total number of scores that are greater than
		// or equal to 70 that are found in the file.
		int scoresAtOrAbove70 = 0;
		
		// The double percentAtOrAbove70 will be used to 
		// hold the percent of scores that are greater than
		// or equal to 70.
		double percentAtOrAbove70 = 0.0;
		
		// The integer scoresAboveAvg is a counter for the
		// total number of scores that are greater than
		// than average.
		int scoresAboveAvg = 0;
		
		// The double percentAtOrAbove70 will be used to 
		// hold the percent of scores that are greater than
		// or equal to 70.
		double percentAboveAvg = 0.0;

		// flags
		
		// The flag gradesRetrieved will be used to end the do
		// loop if scores are found in the file.
		
		boolean gradesRetrieved = false;

		// decimal formatters 
		
		DecimalFormat dfTenth = new DecimalFormat("##.#");
		DecimalFormat dfInt = new DecimalFormat("##");

		// retrieve filename from user and loop until file has been found
		do {

			// retrieve file name
			String filename = JOptionPane.showInputDialog("Enter exam filename: ");


			// open the file
			File file = new File(filename);

			// file does not exist
			if (!file.exists()) {
				// notify the user
				JOptionPane.showMessageDialog(null, "File not found.");
				//continue the loop to try again
				continue;
			}

			//create a scanner for input file
			Scanner inputFile = new Scanner(file);
			
			//loop through input file until end is reached
			while (inputFile.hasNext()) {
				
				//set the grades retrieved flag to true
				gradesRetrieved = true;

				// read the next double from the file
				double grade = inputFile.nextDouble();

				// display the grade to the console
				System.out.println(grade);

				// increase number of scores counter
				numOfScores++;

				// check if current grade is less than min
				if (grade < min || min == 0) {
					min = grade;
				}

				// add grade to avg
				scoreTotal += grade;

				// check if current grade is greater than max
				if (grade > max) {
					//set current grade as the new max
					max = grade;
				}

				// check if score is at or above 70
				if (grade >= 70) {
					//increase scores at or above 70 counter 
					scoresAtOrAbove70++;
				}

			}
			
			//calculate the average by dividing the score total by the number of scores
			avg = scoreTotal / numOfScores;
			
			//find the percent of grades by dividing scores at or above 70 by number of scores
			percentAtOrAbove70 = ((double) (scoresAtOrAbove70) / (double) (numOfScores)) * 100;


			//create a scanner for the input file to find the average
			Scanner avgScan = new Scanner(file);

			//loop through the file until the end is reached
			while (avgScan.hasNext()) {
				
				// read the next double from the file
				double grade = avgScan.nextDouble();
				
				//check to see if current grade is greater than avg
				if (grade > avg) {
					//increase scores above average counter
					scoresAboveAvg++;
				}
			}
			
			//calculate the percent above average by dividing scores above average by number of scores
			percentAboveAvg = ((double) (scoresAboveAvg) / (double) (numOfScores)) * 100;

			// print results
			String str = "Number of scores: " + numOfScores + "\n" + "Minimum: " + dfInt.format(min) + "\n" +
								"Average: " + avg + "\n" + "Maximum: " + dfInt.format(max) + "\n" + "Scores at or above 70: " + 
								scoresAtOrAbove70 + " (" + dfTenth.format(percentAtOrAbove70) + "%)" + "\n" +
								"Scores at or above average: " + scoresAboveAvg + " (" + dfTenth.format(percentAboveAvg) + "%)";
			
			System.out.println(str);

			//close scanners
			inputFile.close();
			avgScan.close();

			//create a print writer to write the results to the ExamStatFile.txt
			PrintWriter writer = new PrintWriter("ExamStatFile.txt", "UTF-8");
			
			//write results to file
			writer.println("Number of scores: " + numOfScores);
			writer.println("Minimum: " + dfInt.format(min));
			writer.println("Average: " + avg);
			writer.println("Maximum: " + dfInt.format(max));
			writer.println("Scores at or above 70: " + scoresAtOrAbove70 + " (" + dfTenth.format(percentAtOrAbove70) + "%)");
			writer.println("Scores at or above average: " + scoresAboveAvg + " (" + dfTenth.format(percentAboveAvg) + "%)");
			writer.close();
			
			//end loop if grades have been retrieved from file
		} while (gradesRetrieved = false);

	}

}
