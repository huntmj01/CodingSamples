package huntmj01_project4;

public class Passenger {
	
	/* 4 global variables
	 * string of the passengers id exp: E8742784
	 * string of the passengers name exp: John Smith
	 * string of the passengers seat exp: 2A
	 * string of the flight id exp: AA1230
	*/
	private String ID = new String();
	private String name = new String();
	private String seat = new String();
	private String flightID = new String();
	
	// constructor
	public Passenger(String passengerID, String passengerName,
					String passengerSeat, String flightID){
		
		ID = passengerID;
		name = passengerName;
		seat = passengerSeat;
		this.flightID = flightID;
		
	}
	
	public Passenger() {
		// TODO Auto-generated constructor stub
	}
	
	// getters and setters
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	
}
