package huntmj01_project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

	// enum to hold the different menu options
	enum MenuOption {
		NEW_FLIGHT, NEW_RESERVATION, DISPLAY_SEATS_MAP, LIST_ALL_FLIGHTS, LIST_ALL_PASSENGER_RESERVATIONS_FOR_ALL_FLIGHTS, LIST_ALL_PASSENGER_RESERVATIONS_FOR_SPECIFIC_FLIGHTS, EXIT
	};

	public static void main(String[] args) throws FileNotFoundException {

		// loop until the user clicks exit in the main menu
		while (true) {
			
			// create a try catch to allow program to continue if there is an error
			try {
				// retrieve the menu option that the user has selected
				MenuOption option = mainMenu();

				// use a switch case to find which option the user selected and
				// call the appropriate method
				switch (option) {

				case NEW_FLIGHT:
					newFlight();
					break;
					
				case NEW_RESERVATION:
					newReservation();
					break;
					
				case DISPLAY_SEATS_MAP:

					// retrieve the flight number from the user
					String flightNum = JOptionPane.showInputDialog(null, "Enter the flight number: ");

					// retrieve the flights seat map file
					File seatMapFile = new File(flightNum + ".txt");

					// create a scanner to scan through the seat map file
					Scanner fileScan = new Scanner(seatMapFile);

					// display the passengers seat map
					System.out.println(flightNum + " Reservations(X means seat is filled)\n------------");
					while (fileScan.hasNext()) {
						String line = fileScan.nextLine();
						System.out.println(line);
					}
					
					// close the scanner
					fileScan.close();

					break;
					
				case LIST_ALL_FLIGHTS:

					// retrieve the flights file
					File flightsFile = new File("flights.txt");

					// create a scanner to scan through the flights file
					Scanner flightsScan = new Scanner(flightsFile);

					// loop through the flights file display all flights
					System.out.println("ALL FLIGHTS\n------------");
					while (flightsScan.hasNext()) {
						String line = flightsScan.nextLine();
						System.out.println(line);
					}

					// close the scanner
					flightsScan.close();

					break;

				case LIST_ALL_PASSENGER_RESERVATIONS_FOR_ALL_FLIGHTS:

					// retrieve the reservations file
					File reservationsFile = new File("reservations.txt");

					// create a scanner to scan through the reservations file
					Scanner reservationScan = new Scanner(reservationsFile);

					// loop through the reservations file and display all reservations
					System.out.println("ALL RESERVATIONS\n------------");
					while (reservationScan.hasNext()) {
						String line = reservationScan.nextLine();
						System.out.println(line);
					}

					// close the scanner
					reservationScan.close();

					break;

				case LIST_ALL_PASSENGER_RESERVATIONS_FOR_SPECIFIC_FLIGHTS:

					// retrieve the flight number from the user
					flightNum = JOptionPane.showInputDialog(null, "Enter the flight number: ");
					
					// retrieve the array of passengers
					Passenger[] passengers = retrievePassengers();
					
					// print the header
					System.out.println("ID" + "\t" + "Name" + "\t" + "SeatNumber" + "\t" + "Flight#");
					
					// loop through the passengers array
					for (int i = 0; i < passengers.length; i++) {
						
						// check if current passenger is null and if so end the loop
						if (passengers[i] == null) {
							break;
						}
						
						// check if the current passengers flight id equals the flight number the user entered
						if (passengers[i].getFlightID().equals(flightNum)) {
							
							// print the passenger information
							System.out.println(passengers[i].getID() + "\t" + passengers[i].getName() + "\t"
									+ passengers[i].getSeat() + "\t" + passengers[i].getFlightID());
						}
					}

					break;

				case EXIT:
					// exit the program
					System.exit(0);
					break;
				default:
					System.out.println("An error has occured.");
					break;
				}

			} catch (Exception e) {
				// notify user of the exception
				System.out.println("The following exception was thrown: " + e + "\nReturning to main menu.");
			}
		}
	}

	
	/*
	 * A method that loops through the flights text file and fills a
	 * flight array
	 * 
	 * @ return flights, an array of flights
	 * 
	 */

	public static Flight[] retrieveFlights() throws FileNotFoundException {

		// create an array of flights. max size is 100.
		Flight[] flights = new Flight[99];

		// create a file to hold flights.txt
		File file = new File("flights.txt");
		// create a scanner for input file
		Scanner inputFile = new Scanner(file);

		// file does not exist
		if (!file.exists()) {
			// notify the user
			JOptionPane.showMessageDialog(null, "File not found.");
		}

		// retrieve the first row and do nothing with it since
		// the first row is just headers
		String title = inputFile.nextLine();

		// loop through each flight
		for (int i = 0; i < flights.length; i++) {

			// check if input file has another row
			if (inputFile.hasNext()) {

				// instantiate the current flight
				flights[i] = new Flight();

				// retrieve the next line
				String line = inputFile.nextLine();

				// split line into string array
				String[] columns = line.split("\t");

				// set the current flights information
				flights[i].setID(columns[0]);
				flights[i].setDate(columns[1]);
				flights[i].setDepartureTime(columns[2]);
				flights[i].setArrivalTime(columns[3]);
				flights[i].setDepartureCity(columns[4]);
				flights[i].setDestinationCity(columns[5]);
				flights[i].setAvailableSeats(Integer.parseInt(columns[6]));

				// file does not have a next line
			} else {
				// exit the loop
				break;
			}
		}

		// close the scanner input file
		inputFile.close();

		// return the array
		return flights;
	}

	
	/*
	 * A method that loops through the passengers text file and fills a
	 * passengers array
	 * 
	 * @ return passengers, an array of passengers
	 * 
	 */

	public static Passenger[] retrievePassengers() throws FileNotFoundException {

		// create an array of flights. max size is 100.
		Passenger[] passengers = new Passenger[99];

		// create a file to hold flights.txt
		File file = new File("reservations.txt");
		// create a scanner for input file
		Scanner inputFile = new Scanner(file);

		// file does not exist
		if (!file.exists()) {
			// notify the user
			JOptionPane.showMessageDialog(null, "File not found.");
		}

		// retrieve the first row and do nothing with it since
		// the first row is just headers
		String title = inputFile.nextLine();

		// loop through each passenger
		for (int i = 0; i < passengers.length; i++) {

			// check if input file has another row
			if (inputFile.hasNext()) {

				// initialize the current passenger
				passengers[i] = new Passenger();

				// retrieve the next line
				String line = inputFile.nextLine();

				// split line into string array
				String[] columns = line.split("\t");

				// set the current flights information
				passengers[i].setID(columns[0]);
				passengers[i].setName(columns[1]);
				passengers[i].setSeat(columns[2]);
				passengers[i].setFlightID(columns[3]);

				// file does not have a next line
			} else {
				// exit the loop
				break;
			}
		}

		// close the scanner input file
		inputFile.close();

		// return the array
		return passengers;
	}

	
	/*
	 * A static method that 
	 * 1. asks the user for flight information 
	 * 2. creates a new text file that contains the passengers seat maps 
	 * 3. adds the new flight information to flights.txt
	 * 
	 */

	public static void newFlight() throws FileNotFoundException {

		// ask the user to enter data for new flight
		String id = JOptionPane.showInputDialog(null, "Enter flight id: ");
		String date = JOptionPane.showInputDialog(null, "Enter the flight date: ");
		String departureTime = JOptionPane.showInputDialog(null, "Enter the flight departure time: ");
		String arrivalTime = JOptionPane.showInputDialog(null, "Enter the flight arrival time: ");
		String departureCity = JOptionPane.showInputDialog(null, "Enter the flight departure city: ");;
		String destinationCity = JOptionPane.showInputDialog(null, "Enter the flight destination city: ");
		int availableSeats = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter amount of available seats: "));

		// create the flight
		Flight flight = new Flight(id, date, departureTime, arrivalTime, departureCity, destinationCity,
				availableSeats);

		// create an array of flights and retrieve the current flights from the
		// flights.txt file
		Flight[] flights = retrieveFlights();

		// loop through the flights array
		for (int i = 0; i < flights.length; i++) {

			// check if current flight is null
			if (flights[i] == null) {

				// add the new flight to the array
				flights[i] = new Flight();
				flights[i] = flight;
				break;
			}
		}

		// create a file to hold the flights.txt
		File flightsFile = new File("flights.txt");

		// create a print writer to write to the text file
		PrintWriter flgihtsWriter = new PrintWriter(flightsFile);

		// write the header
		flgihtsWriter.println("Flight#" + "\t" + "FDate" + "\t" + "DTime" + "\t" + "ATime" + "\t" + "DepartCity" + "\t"
				+ "DestCity" + "\t" + "AvailableSeats");

		// loop through the flights array
		for (int i = 0; i < flights.length; i++) {

			// check to make sure the current flight is not null
			if (!(flights[i] == null)) {

				// write the new flight to the text file
				flgihtsWriter
						.println(flights[i].getID() + "\t" + flights[i].getDate() + "\t" + flights[i].getDepartureTime()
								+ "\t" + flights[i].getArrivalTime() + "\t" + flights[i].getDepartureCity() + "\t"
								+ flights[i].getDestinationCity() + "\t" + flights[i].getAvailableSeats());

				// else end the loop
			} else {
				break;
			}
		}
		createSeatMap(flight);

		// close the print writer
		flgihtsWriter.close();
	}

	
	/*
	 * A method that
	 * 1. asks the user for the flight number whose seat is to be reserved
	 * 2. asks the user for the passenger id and name
	 * 3. displays the seat map
	 * 4. asks the user to enter a seat number
	 * 5. Updates the seat map
	 * 6. adds the passengers information to the reservation file
	 * 
	 */

	public static void newReservation() throws FileNotFoundException {

		// ask the user for the flight number, passenger ID, and name
		String flightNum = JOptionPane.showInputDialog(null, "Enter flight number: ");
		String passengerID = JOptionPane.showInputDialog(null, "Enter passenger ID: ");
		String passengerName = JOptionPane.showInputDialog(null, "Enter passenger name: ");

		// retrieve the flights seat map file
		File seatMapFile = new File(flightNum + ".txt");

		// create a scanner to scan through the seat map file
		Scanner fileScan = new Scanner(seatMapFile);

		// display the passengers seat map
		System.out.println("Current Reservations(X means seat is filled)\n------------");
		while (fileScan.hasNext()) {
			String line = fileScan.nextLine();
			System.out.println(line);
		}
		
		// close the file scan
		fileScan.close();
		
		// ask the user to enter the seat number
		String seatNumber = JOptionPane.showInputDialog(null, "Enter seat number: ");

		// update number of available seats in flight
		Passenger[] passengers = retrievePassengers();
		Flight[] flights = retrieveFlights();
		Flight flight = new Flight();

		// loop through the passengers and find the first null passenger
		for (int i = 0; i < passengers.length; i++) {

			if (passengers[i] == null) {

				// mark which flight this passenger is in
				for (int j = 0; j < flights.length; j++) {
					if (!(flights[j] == null)) {
						if (flightNum.equals(flights[j].getID())) {
							flight = flights[j];
						}
					}
				}

				// add the new passenger to the new list
				passengers[i] = new Passenger();
				passengers[i].setID(passengerID);
				passengers[i].setName(passengerName);
				passengers[i].setSeat(seatNumber);
				passengers[i].setFlightID(flightNum);

				// end the loop
				break;

			}
		}

		// add the passenger to the reservations.txt file
		File outFile = new File("reservations.txt");
		PrintWriter writer = new PrintWriter(outFile);
		writer.println("ID" + "\t" + "Name" + "\t" + "SeatNumber" + "\t" + "Flight#");

		// loop through passengers
		for (int i = 0; i < passengers.length; i++) {

			// end the loop if passenger is null
			if (passengers[i] == null) {
				break;

				// otherwise write the passenger to the file
			} else {
				writer.println(passengers[i].getID() + "\t" + passengers[i].getName() + "\t" + passengers[i].getSeat()
						+ "\t" + passengers[i].getFlightID());
			}
		}

		// close the writer
		writer.close();

		// update passengers seat maps as long as flight is not null
		if (!(flight.getID().equals(""))) {
			createSeatMap(flight);
		}
	}

	
	/*
	 * A static method that takes a flight and uses that information to make a
	 * seat map for a flight
	 * 
	 * @param flight, a single flight whose seat map is to be created
	 * 
	 */

	public static void createSeatMap(Flight flight) throws FileNotFoundException {

		// create an array of flights and retrieve the current flights and
		// passengers from the
		// flights.txt file
		Passenger[] passengers = retrievePassengers();

		// seat pattern writer for new flight
		File patternFile = new File(flight.getID() + ".txt");
		PrintWriter patternWriter = new PrintWriter(patternFile);

		// create two string arrays for Phase B
		String[][] seats = new String[flight.getAvailableSeats()][8];
		String[][] takenSeats = new String[100][2];

		// counter to increment the seats taken array's rows
		int takenCount = 0;

		// loop through passengers
		for (int i = 0; i < passengers.length; i++) {

			// check is current passenger is null
			if (passengers[i] == null) {
				break;
			}

			// check if current passengers flight id equals the new flights id
			if (passengers[i].getFlightID().equals(flight.getID())) {
				String seatNum = passengers[i].getSeat();

				// check if seatNum length is 2 chars or 3 chars exp: 2A vs 10A
				if (seatNum.length() == 2) {
					takenSeats[takenCount][0] = String.valueOf(seatNum.charAt(0));
					takenSeats[takenCount][1] = String.valueOf(seatNum.charAt(1));
					takenCount++;
				} else {
					String str = seatNum.charAt(0) + "" + seatNum.charAt(1);
					takenSeats[takenCount][0] = String.valueOf(str);
					takenSeats[takenCount][1] = String.valueOf(seatNum.charAt(2));
					takenCount++;
				}
			}
		}

		// fill the seats with A-G depending on how many available seats there
		// are
		for (int i = 0; i < seats.length; i++) {
			// exp: 3 A B C D E F G
			seats[i][0] = String.valueOf(i + 1);
			seats[i][1] = "A";
			seats[i][2] = "B";
			seats[i][3] = "C";
			seats[i][4] = "D";
			seats[i][5] = "E";
			seats[i][6] = "F";
			seats[i][7] = "G";

		}

		// check which seats are full
		for (int i = 0; i < takenSeats.length; i++) {

			// check if current takenSeat is null
			if (takenSeats[i][0] == null) {
				break;
			}

			// retrieve the column and row from the taken seats array
			int row = Integer.parseInt(takenSeats[i][0]) - 1;
			String column = takenSeats[i][1];

			// loop through the seats row
			for (int j = 0; j < seats[i].length; j++) {
				// if the seat column equals the taken column
				if (seats[row][j].equals(column)) {
					// set that column
					seats[row][j] = "X";
				}
			}
		}
		
		// loops through seats
		for (int i = 0; i < seats.length; i++) {
			// check if this is the first iteration and if so skip a line in the file
			if (i != 0) {
				patternWriter.print("\n");
			}
			// loop through seat row
			for (int j = 0; j < seats[i].length; j++) {
				// print the seat to the file
				patternWriter.print(seats[i][j] + "\t");
			}
		}
		
		// close the writer
		patternWriter.close();
	}

	
	/*
	 * A static method that takes no arguments. It prints out the main menu and
	 * returns a MenuOption based off which option the user has chosen.
	 * 
	 * @return MenuOption, the menu option the user has chosen
	 * 
	 */

	public static MenuOption mainMenu() {

		// flag to check if user input was valid
		boolean invalidInput = true;
		// variable to store the menu option the user selected
		MenuOption option = null;

		// loop while user input is invalid
		while (invalidInput) {

			// user input starts off as valid
			invalidInput = false;

			String[] options = new String[] { "New Flight", "New Reservation",
					"Display Seat Map", "List All Flights",
					"List All Passenger Reservations",
					"List Reservations For Specific Flight", "Exit" };

			int response = JOptionPane.showOptionDialog(null, "Please select one: ", "Main Menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			String selectedOption = String.valueOf(response + 1);

			// find which menu option the user selected and set it to menu
			// option
			if (selectedOption.equals("1")) {
				option = MenuOption.NEW_FLIGHT;
			} else if (selectedOption.equals("2")) {
				option = MenuOption.NEW_RESERVATION;
			} else if (selectedOption.equals("3")) {
				option = MenuOption.DISPLAY_SEATS_MAP;
			} else if (selectedOption.equals("4")) {
				option = MenuOption.LIST_ALL_FLIGHTS;
			} else if (selectedOption.equals("5")) {
				option = MenuOption.LIST_ALL_PASSENGER_RESERVATIONS_FOR_ALL_FLIGHTS;
			} else if (selectedOption.equals("6")) {
				option = MenuOption.LIST_ALL_PASSENGER_RESERVATIONS_FOR_SPECIFIC_FLIGHTS;
			} else if (selectedOption.equals("7")) {
				option = MenuOption.EXIT;

				// anything the is not between 1 and 7
			} else {
				// set the invalidInput flag to true
				invalidInput = true;
				// notify the user
				System.out.println("Invalid input. Try again.");
			}

		} // end loop

		// return the menu option
		return option;

	}

}
