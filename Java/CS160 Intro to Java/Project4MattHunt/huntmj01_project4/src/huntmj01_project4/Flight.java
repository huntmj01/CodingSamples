package huntmj01_project4;

public class Flight {
	
	/* 7 global variables
	 * string of the flight id exp: AA1150
	 * string of the date exp: 20Dec15
	 * string of the departure time exp: 23:00
	 * string of the arrival time exp: 02:00
	 * string of the departure city exp: FORT WAYNE
	 * string of the destination city exp: ORLANDO
	 * integer of the amount of available seats in the flight exp: 70
	*/
	private String ID = new String();
	private String date = new String();
	private String departureTime = new String();
	private String arrivalTime = new String();
	private String departureCity = new String();
	private String destinationCity = new String();
	private int availableSeats;
	
	// constructor
	public Flight(String flightID, String flightDate, String flightDepartureTime,
			String flightArrivalTime, String flightDepartureCity,
			String flightDestinationCity, int flightAvailableSeats) {
		
		ID = flightID;
		date = flightDate;
		departureTime = flightDepartureTime;
		arrivalTime = flightArrivalTime;
		departureCity = flightDepartureCity;
		destinationCity = flightDestinationCity;
		availableSeats = flightAvailableSeats;
	}

	// getters and setters
	
	public Flight() {

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	
	
}
