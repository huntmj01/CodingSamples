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
 * Class:		Team.java
 * Description:	A Tournament consists of many teams of the
 * 				same gender. A team consists of a name, location,
 * 				and a gender.
 * 				
 **/
public class Team extends Observable implements Serializable {
	
	///
	/// declare private fields
	///
	
	private static final long serialVersionUID 
			= 6169542785845520613L;		// holds id for serializable
	
	
	private int teamId;
	private String name;				// holds the name of the team
	private String address;				// holds the address of the team
	private String city;				// holds the city the team is located at
	private String state;				// holds the state the team is located at
	private String zip;					// holds the zip code the team is located at
	private String gender;				// holds the gender of the team
	private String lat;
	private String lng;

	// constructor
	public Team(String name, String address, String city, String state, String zip, String gender) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.gender = gender;
	}
	
	// overload the constructor
	// allow client to set values manually
	public Team() {
		super();
		this.name = null;
		this.address = null;
		this.city = null;
		this.state = null;
		this.zip = null;
		this.gender = null;
	}
	
	/**
	 * 
	 * @param teamId
	 * @param teams
	 * @return
	 */
	public static Team getTeamById(int teamId, ArrayList<Team> teams) {
		
		Team result = null;
		
		for(Team team : teams) {
			if (team.getTeam_id() == teamId) {
				result = team;
				break;
			}
		}
		
		return result;
		
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		setChanged();
		notifyObservers();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
		setChanged();
		notifyObservers();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		setChanged();
		notifyObservers();
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
		setChanged();
		notifyObservers();
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
		setChanged();
		notifyObservers();
	}
	public int getTeam_id() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
	
}