package huntmj01_lab10;

public class ArrayOps2D {

	public static double getTotal(double[][] array) {

		// variable to hold the sum of the numbers in the 2d array
		double sum = 0;

		// loop through rows
		for (int i = 0; i < array.length; i++) {
			// loop through columns
			for (int j = 0; j < array[i].length; j++) {

				// add the current field to the sum
				sum += array[i][j];

			}
		}

		// return the sum
		return sum;

	}

	public static double getAverage(double[][] array) {

		// variable to hold the sum of the elements in the 2d array
		double sum = 0;
		// counter to count the amount of elements in the 2d array
		double iterations = 0;

		// loop through rows
		for (int i = 0; i < array.length; i++) {
			// loop through columns
			for (int j = 0; j < array[i].length; j++) {

				// add the current field to the sum
				sum += array[i][j];
				iterations++;

			}
		}

		// calculate the average by dividing the sum by the amount of elements
		double average = sum / iterations;

		// return the average
		return average;
	}

	public static double getRowTotal(double[][] array, int row) {

		// variable to hold the sum of the row
		double sum = 0;
		// retrieve the number of elements in the row
		int numOfElements = array[row].length;

		// loop through elements
		for (int i = 0; i < numOfElements; i++) {
			sum += array[row][i];
		}

		// return the sum
		return sum;

	}

	public static void findHighestValue(double[][] array) {

		// variable to hold the highest value in the 2d array
		double highestValue = 0;

		int row = 0;
		int column = 0;

		// loop through rows
		for (int i = 0; i < array.length; i++) {
			// loop through columns
			for (int j = 0; j < array[i].length; j++) {

				// variable to hold the current element
				double currentElement = array[i][j];

				// set the highest value as the current element if highest
				// value is 0 or highest value is less than current element
				if ((highestValue == 0) || (highestValue < currentElement)) {
					highestValue = currentElement;
					row = i;
					column = j;
				}
			}
		}

		System.out.println("The highest value is " + highestValue + ", from row " + row + ", column " + column);

	}

	public static int findHighestValueInRow(double[][] array, int row) {

		// variable to hold the highest value in the 2d array
		double highestValue = 0;
		
		// variable to hold the column with the highest value
		int column = 0;

		// retrieve the number of elements in the row
		int numOfElements = array[row].length;

		// loop through elements
		for (int i = 0; i < numOfElements; i++) {
			// variable to hold the current element
			double currentElement = array[row][i];

			// set the highest value as the current element if highest
			// value is 0 or highest value is less than current element
			if ((highestValue == 0) || (highestValue < currentElement)) {
				highestValue = currentElement;
				column = i;
			}
		}
		
		// return the index of the highest value
		return column;
	}
	
	public static void sequentialSearch(double[][] array, double value){

		// loop through rows
		for (int i = 0; i < array.length; i++) {
			// loop through columns
			for (int j = 0; j < array[i].length; j++) {

				if (array[i][j] == value){
					System.out.println(value + " found at row " + i + ", column "+ j);
				}

			}
		}
	}

}
