package lab8;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Scanner;

public class StateZipcodeTest {

	private Scanner scan;
	private int age;
	private String fileName;
	private FileInputStream fis;
	private String[][] stateArr;
	private String state;
	private int zip;

	public StateZipcodeTest() {
		scan = new Scanner(System.in);
		age = 0;
		fileName = "";
		stateArr = new String[50][2];
		state = "";
		zip = 00000;
	}

	/**
	 * 
	 * intSurvey() prompts the customer for their age and assigns the age field
	 * to their age. If the user enters q or anything else the program exits.
	 * 
	 */
	public void initSurvey() {

		try {

			// retrieve age from user
			String temp = "";
			System.out.print("Please enter your age or 'q' to quit: ");
			temp = scan.next();

			// check if user entered q and exit the program if they did
			if (temp.equals("q")) {
				System.out.println("(1)You've chosen not to participate. Thank you for your time.");
				System.exit(0);
			}

			// parse the string retrieved into an int
			age = Integer.parseInt(temp);

		} catch (NumberFormatException nfe) {
			// exit the program
			System.out.println("You've chosen not to participate. Thank you for your time.");
			System.exit(0);
		}

	}

	/**
	 * 
	 * getInputFileName() retrieves the file name from the user, manages any
	 * errors that may occur, and checks if the user wishes to quit
	 * 
	 * @return exit, whether to exit the program or not
	 * 
	 */
	public boolean getInputFileName() {

		// flags
		boolean invalidInput = true;
		boolean exit = false;

		// loop until input is valid
		while (invalidInput) {

			// retrieve the file name from the user
			System.out.print("Please enter the name of your file or enter quit: ");
			fileName = scan.next();

			// check if user entered 'quit'
			if (fileName.equals("quit")) {
				// set exit flag to true and
				// invalid input to false
				invalidInput = false;
				exit = true;
			}

			try {

				// create a new file input stream
				fis = new FileInputStream(new File(fileName));

				// if no exception is thrown set invalid input to
				// false and exit to true
				invalidInput = false;
				exit = false;

			} catch (FileNotFoundException fnfe) {
				// the file was not found so print out the error
				// check if exit flag is false
				if (exit == false) {
					// set invalid input flag to true and print error msg
					invalidInput = true;
					System.out.println("Unable to open file, reenter the file name.");
				}
			} finally {
				// check if exit flag is set to true
				if (exit == true) {
					// tell the user that their participation has been valuable
					// to make them feel good about themselves
					System.out.println("Your participation has been valuable. ");
				}
			}

		}

		// return the exit flag
		return exit;

	}

	/**
	 * 
	 * readBinaryFile() parses the states.bin file into the state array
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void readBinaryFile() throws IOException {

		// create a data input stream
		DataInputStream inputFile = new DataInputStream(fis);

		// loop through the state array and put all the
		// states in it from the input file
		for (int i = 0; i < stateArr.length; i++) {
			for (int j = 0; j < stateArr[i].length; j++) {
				stateArr[i][j] = inputFile.readUTF();
			}
		}

	}

	/**
	 * 
	 * getState() retrieves the state abbreviation from the user, checks if its
	 * a state, and then handles any errors
	 * 
	 */
	public void getState() {

		// loop until the loop is broken
		while (true) {

			// flag to check if state abbreviation is valid
			boolean valid = false;

			// ask user to enter in 2 letter state abbreviation
			System.out.print("Please enter the 2 letter state abbreviation: ");
			String temp = scan.next();

			// loop through state array
			for (int i = 0; i < stateArr.length; i++) {
				for (int j = 0; j < stateArr[i].length; j++) {
					// if the user input is in the array set valid to true
					if (stateArr[i][j].equals(temp) && temp.toCharArray().length == 2) {
						valid = true;
						state = stateArr[i][j + 1];
					}
				}
			}

			// check if valid has been set to true and then break else throw an
			// exception
			if (valid == true) {
				break;

			} else {
				try {
					throw new InvalidStateNameException(
							"Invalid State Abbreviation Exception. Your state abbreviation is not valid.");
				} catch (InvalidStateNameException e) {
					System.out.println(e.getMessage());
				}
			}

		}
	}

	/**
	 * 
	 * getZipCode() retrieves the zip code from the user, checks if its a zip
	 * code, and then handles any errors
	 * 
	 */
	public void getZipeCode() {

		// loop until the loop is broken
		while (true) {

			// flag to check if zip code is valid
			boolean valid = false;

			// ask user to enter in 2 letter state abbreviation
			System.out.print("Please enter your zip code: ");
			String temp = scan.next();

			// check for a five digit zip code
			if (isNumeric(temp) && temp.length() == 5) {
				valid = true;
			}

			// check if valid has been set to true and then break else throw an
			// exception
			if (valid == true) {
				zip = Integer.parseInt(temp);
				break;
			} else {
				try {
					throw new InvalidZipCodeException("Invalid zip code; please reenter.");
				} catch (InvalidZipCodeException e) {
					System.out.println(e.getMessage());
				}
			}

		}
	}

	/**
	 * 
	 * isNumeric() checks is a string is numeric
	 * Comes from http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
	 * 
	 * @param str, the string to be checked
	 * @return bool, whether the string is numeric
	 * 
	 */
	public boolean isNumeric(String str) {
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		// get information from user

		StateZipcodeTest test = new StateZipcodeTest();
		test.initSurvey();

		// call the getInputFileName() method and if true
		// is returned exit the program
		if (test.getInputFileName() == true) {
			System.out.println("Thank you for your time.");
			System.exit(0);
		}

		test.readBinaryFile();
		test.getState();
		test.getZipeCode();

		// print results
		try {
			System.out.println("Your age: " + test.age);
			System.out.println("Your state and zip: " + test.state + " " + test.zip);
			System.out.println("Your participation has been valuable.");
		} finally {
			System.out.println("Thank you for your time.");
		}

	}

}
