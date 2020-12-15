package huntmj01_lab5;

import java.util.Scanner;
import java.text.DecimalFormat;

public class MassHandler {

	public static void main(String[] args) {
		
		//counters
		int count = 0;
		int countValid = 0;
		double validWeight = 0;
		
		// create a decimal formater to round to 1 decimal place
		DecimalFormat df = new DecimalFormat("##.#");
		
		// create a scanner to get user input
		Scanner scan = new Scanner(System.in);
		
		while (true) {

			// retrieve the objects name
			System.out.print("Enter the objects name -> ");
			String objectName = scan.nextLine();

			// retrieve objects mass
			System.out.print("Enter the objects mass -> ");
			double objectMass = scan.nextDouble();

			//if objectMass = -5 exit the loop
			if (objectMass == -5) {
				break;
				
			//else increase the count
			}else{
				count++;
			}
			
			// Directly after calling nextDouble(), also
			// call nextLine(). Java console input can sometimes leave residual
			// newlines, which
			// mess with future inputs
			scan.nextLine();

			// calculate the weight
			double weight = objectMass * 9.8;

			// check weight
			// weight is greater than 1000
			if (weight > 1000) {
				System.out.println(objectName + " is too heavy!");

			// weight is less than 10
			} else if (weight < 10) {
				System.out.println(objectName + " is too light!");

			// else
			} else {
				//increase valid count by 1
				countValid++;
				// print weight
				System.out.println(objectName + " weighs " + df.format(weight) + " Newtons.");
				validWeight += weight;
			}
		}
		
		//print out totals and average
		if (countValid != 0){
			System.out.println("--------");
			System.out.println("Total input count: " + count);
			System.out.println("Total valid count: " + countValid);
			System.out.println("Total valid weight input: " + validWeight);
			System.out.println("Average valid weight: " + validWeight/countValid);
		}
	scan.close();
	}
}
