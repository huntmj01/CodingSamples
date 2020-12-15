package lab2A;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProgressReport {
	
	// fields
	
	// 2D array storing Student objects for two sections
	// Each row of the array represents a particular section 
	// and each column represents an individual student of that section
	Student[][] sectionArray = new Student[2][];
	
	public void readInputFile() throws FileNotFoundException{
		
		// Read data from the input file, “Lab2A.in”, 
		File lab2AIn = new File("Lab2A.in");
		Scanner scan = new Scanner(lab2AIn);
		
		// retrieve the amount of students in 
		// section 1 from the file
		int amt1 = scan.nextInt();
		
		// instantiate Student objects
		sectionArray[0] = new Student[amt1];
		
		// loop through cols
		for (int i = 0; i < amt1; i++){
			
			// retrieve the name from the file
			String name = scan.next();
			
			// create a variable to hold the scores
			int scores[] = new int[5];
			
			// loop through rest of row to get the scores 
			// for the current student
			for(int j = 0; j < scores.length; j++){
				scores[j] = scan.nextInt();
			}
			
			// initialize data fields of the students using the 
			// data in the input file
			sectionArray[0][i] = new Student();
			sectionArray[0][i].setName(name);
			sectionArray[0][i].setScores(scores);
			sectionArray[0][i].calculateAverage();
			sectionArray[0][i].calculateGrade();
			
		}
		
		
		// retrieve the amount of students in 
		// section 2 from the file
		int amt2 = scan.nextInt();
		
		// instantiate Student objects
		sectionArray[1] = new Student[amt2];
		
		// loop through columns 
		for (int i = 0; i < amt2; i++){
			
			// retrieve the name from the file
			String name = scan.next();
			int scores[] = new int[5];
	
			// loop through rows
			for(int j = 0; j < scores.length; j++){
				scores[j] = scan.nextInt();
			}
			
			// initialize data fields of the students using the 
			// data in the input file
			sectionArray[1][i] = new Student();
			sectionArray[1][i].setName(name);
			sectionArray[1][i].setScores(scores);
			sectionArray[1][i].calculateAverage();
			sectionArray[1][i].calculateGrade();
			
		}
		
		// close the scanner
		scan.close();
	}
	
	public void generateReport(){
		
		// header
		System.out.println("Progress Report\n");
		System.out.println("Section 1");
		
		// loop through first section array
		for (int i = 0; i < sectionArray[0].length; i++){
			// output data for current student
			System.out.println(sectionArray[0][i].getName() + "\t" + sectionArray[0][i].getAverage() + "\t" + sectionArray[0][i].getGrade());
		}
		
		//header
		System.out.println("\nSection 2");
		
		// loop through second section array
		for (int i = 0; i < sectionArray[1].length; i++){
			// output data for current student
			System.out.println(sectionArray[1][i].getName() + "\t" + sectionArray[1][i].getAverage() + "\t" + sectionArray[1][i].getGrade());
		}
		
	}
	
	public void sortByName(){
		
		// selection sort algorithm from page 467
		int startScan; 
		int index = 0;
		int minIndex;
		Student minValue = new Student();
		
		// sort section 1
		for (startScan = 0; startScan < (sectionArray[0].length-1); startScan++){
			
			minIndex = startScan;
			minValue = sectionArray[0][startScan];
			
			for (index = startScan + 1; index < sectionArray[0].length; index++){
				if (sectionArray[0][index].getName().compareTo(minValue.getName())<0){
					minValue = sectionArray[0][index];
					minIndex = index;
				}	
			}
			
			if (minIndex != startScan){
				sectionArray[0][minIndex] = sectionArray[0][startScan];
				sectionArray[0][startScan] = (minValue);
			}
		}
		
		// reset variables to sort section 2
		startScan = 0;
		index = 0;
		minIndex = 0;
		
		// sort section 2
		for (startScan = 0; startScan < (sectionArray[1].length-1); startScan++){
			
			minIndex = startScan;
			minValue = sectionArray[1][startScan];
			
			for (index = startScan + 1; index < sectionArray[1].length; index++){
				if (sectionArray[1][index].getName().compareTo(minValue.getName())<0){
					minValue = sectionArray[1][index];
					minIndex = index;
				}	
			}
			
			if (minIndex != startScan){
				sectionArray[1][minIndex] = sectionArray[1][startScan];
				sectionArray[1][startScan] = (minValue);
			}
		}
	}
	
	public Student binarySearch(int section, String searchName){
		
		int first;		// First array element
		int last;		// Last array element
		int middle;		// Midpoint of search
		int position;	// Position of each search
		boolean found;	// Flag
		
		// set the initial values
		first=0;
		last = sectionArray[section].length - 1;
		position = -1;
		found = false;
		
		//search for the value
		while (!found && first <= last){
			// Calculate midpoint
			middle = (first + last) / 2;
			// if value found at midpoint
			if (sectionArray[section][middle].getName().compareTo(searchName) == 0){
				found = true;
				position = middle;
			} 
			// else if the value is in the lower half
			else if (sectionArray[section][middle].getName().compareTo(searchName) > 0){
				last = middle - 1;
			}
			// else if value is in the upper half
			else{
				first = middle + 1;
			}
		}
		
		// if no value is found return null
		if (position == -1){
			return null;
		}
		
		// return the student
		return sectionArray[section][position];
	}
	
}
