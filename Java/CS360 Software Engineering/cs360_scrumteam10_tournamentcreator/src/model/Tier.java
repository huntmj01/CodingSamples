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
 * Class:		Tier.java
 * Description:	A Tournament consists of many tiers. A tier
 * 				consists of a name (for example sectional, regional, 
 * 				semi-state, state) and events.
 * 				
 **/
public class Tier extends Observable implements Serializable {

	///
	/// declare private fields
	///
	
	private static final long serialVersionUID 
			= 8009923240845507338L;		// holds id for serializable	
	
	private int tierId;
	private String name;				// holds the name of the tier
	private ArrayList<Event> events;	// holds the events for this tier
	
	// constructor
	public Tier(String name, ArrayList<Event> events) {
		this.name = name;
		this.events = events;
	}
	
	// overload the constructor
	// allow client to set values manually
	public Tier() {
		this.name = null;
		this.events = null;
	}

	public static Tier getTierById(int tierId, ArrayList<Tier> tiers) {
		
		Tier result = null;
		
		for(Tier tier : tiers) {
			if (tier.getTierId() == tierId) {
				result = tier;
				break;
			}
		}
		
		return result;
		
	}
	
	// getters and setters
	
	public int getTierId() {
		return tierId;
	}

	public void setTierId(int tierId) {
		this.tierId = tierId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers();
	}

	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
		setChanged();
		notifyObservers();
	}
	
	
}
