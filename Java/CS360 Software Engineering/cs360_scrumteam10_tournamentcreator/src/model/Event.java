package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

/*
 * 
 * Name: 		Zarni Mon, Nick Becker, Matthew Hunt
 * Course:		CS360-01 Software Engineering
 * Instructor: 	eProf Sedlmeyer
 * Project:		Assignment 9: Sprint 2
 * Date:		03/28/18
 * Due:			04/11/18
 * 
 * Class:		Event.java
 * Description:	In a tournament, each tier consists of one or more
 * 				event(s). An event consists of a name, location, and 
 * 				feeders. For example, the event Crown Point is the 2nd
 * 				sectional.
 * 				
 **/
public class Event extends Observable implements Serializable {
	
	///
	/// declare private fields
	///
	
	private static final long serialVersionUID 
			= -3232596802800199462L;	// holds id for serializable
	
	private int eventId;
	private int tierId;
	private String name;				// holds the name of the event
	private String location;			// holds the location of the event					
	private ArrayList<Feeder> feeders;	// holds the feeders in this event
	private ArrayList<Team> teams;
	private double avgDistance;
	private double minDistance;
	private double maxDistance;
	private double lat;
	private double lng;
	
	// constructor
	public Event(String event, String location, ArrayList<Feeder> feeders) {
		super();
		this.name = event;
		this.location = location;
		this.feeders = feeders;
	}
	
	// overload the constructor
	// allow client to set values manually
	public Event() {
		super();
		this.name = null;
		this.location = null;
		this.feeders = null;
		this.teams = new ArrayList<Team>();
	}
	
	public static Event getEventById(int eventId, ArrayList<Event> events) {
		
		Event result = null;
		
		for(Event event : events) {
			if (event.getEventId() == eventId) {
				result = event;
				break;
			}
		}
		
		return result;
		
	}
	
	// getters and setters
	
	public String getName() {
		return name;
	}

	public void setName(String event) {
		this.name = event;
		setChanged();
		notifyObservers();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
		setChanged();
		notifyObservers();
	}

	public ArrayList<Feeder> getFeeders() {
		return feeders;
	}

	public void setFeeders(ArrayList<Feeder> feeders) {
		this.feeders = feeders;
		setChanged();
		notifyObservers();
	}
	
	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
		setChanged();
		notifyObservers();
	}
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getTierId() {
		return tierId;
	}

	public void setTierId(int tierId) {
		this.tierId = tierId;
	}

	public double getAvgDistance() {
		return avgDistance;
	}

	public void setAvgDistance(double avgDistance) {
		this.avgDistance = avgDistance;
	}

	public double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	public double getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}
	
	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

}
