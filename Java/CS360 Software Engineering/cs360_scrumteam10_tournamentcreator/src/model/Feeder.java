package model;

import java.io.Serializable;
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
 * Class:		Feeder.java
 * Description:	In a tournament, each tier consists of one or more
 * 				event(s). Each event has one or more feeders that
 * 				feed into it. A feeder can be an event or a team. 
 * 				For example, in the first tier, teams feed into
 * 				sectional. In the second tier, sectionals feed
 * 				into a regional.
 * 				
 **/
@Deprecated
public class Feeder extends Observable implements Serializable {

	
	///
	/// declare private fields
	///
	
	private static final long serialVersionUID 
			= -2246863772944416054L;	// holds id for serializable
	
	private int feederId;
	private int parentEventId;
	private String name;				// holds the name of the feeder
	private int objectId;
	private Object feederObj;

	// constructor
	public Feeder(String name) {
		super();
		this.name = name;
	}
	
	// overload the constructor
	// allow client to set values manually
	public Feeder() {
		super();
		this.name = null;
	}

	// getters and setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers();
	}
	
	public int getFeederId() {
		return feederId;
	}

	public void setFeederId(int feederId) {
		this.feederId = feederId;
	}

	public int getParentEventId() {
		return parentEventId;
	}

	public void setParentEventId(int parentEventId) {
		this.parentEventId = parentEventId;
	}

	public Object getFeederObj() {
		return feederObj;
	}

	public void setFeederObj(Object feederObj) {
		this.feederObj = feederObj;
	}
	
	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
}
