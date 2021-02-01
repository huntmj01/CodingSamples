package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import other.Persistence;
import other.PersistenceUtils;

/*
 * 
 * Name: 		Zarni Mon, Nick Becker, Matthew Hunt
 * Course:		CS360-01 Software Engineering
 * Instructor: 	eProf Sedlmeyer
 * Project:		Assignment 9: Sprint 2
 * Date:		03/28/18
 * Due:			04/11/18
 * 
 * Class:		Tournament.java
 * Description:	A Tournament consists of many tiers. A tier
 * 				consists of a name (for example sectional, regional, 
 * 				semi-state, state) and events. An event consists of
 * 				feeders. Tournament is a Singleton.
 * 				
 **/
public class Tournament extends Observable implements Serializable {
	
	///
	/// declare private fields
	///
	
	private static final long serialVersionUID
		= 8090321957756167422L;				// holds id for serializable
	
	private String name;					// holds the name of the tournament
	private ArrayList<Team> teams;			// holds the teams in the tournament
	private ArrayList<Tier> tiers;			// holds the tiers in the tournament
	private String tierToString = "";		// holds a string representation of a tier in the tournament
	private String[] tierEventToString;
	private ArrayList<Double[]> latLongPairs;
	private double avgDistance = 0.0;
	private double maxDistance = 0.0;
	private double minDistance = 0.0;
	
	
	private static Tournament tournament 
		= new Tournament();					// holds singleton instance of tournament	
	
	// create a new tournament constructor
	private Tournament() {
		super();
		Persistence dataBase = new Persistence();
		this.name = null;
		this.teams = dataBase.populateDefaultTeams();
		this.tiers = dataBase.populateDefaultTiers();
		
		// load teams into sectionals
		Tier sectionals  = Tier.getTierById(1, tiers);
		populateSectionalEventTeams(sectionals);
		
		// load teams into regionals
		Tier regionals = Tier.getTierById(2, tiers);
		populateRegionalEventTeams(regionals, sectionals);
		
		// load teams into semi states
		Tier semistates = Tier.getTierById(3, tiers);
		populateSemiStateEventTeams(semistates, regionals);
		
		// load teams into state finals
		Tier state = Tier.getTierById(4, tiers);
		populateStateEventTeams(state, semistates);
		
		populateAvgDistances(dataBase);
		populateLatLngs(dataBase);
		
		dataBase.close();
	}
	
	// load sectional event teams
	public void populateSectionalEventTeams(Tier sectionals) {
		
		// loop through each event in the sectional
		for (Event event : sectionals.getEvents()) {
			
			// loop through each feeder
			for (Feeder feeder : event.getFeeders()) {
				
				if (feeder.getParentEventId() < 33) {
					
					Team team = Team.getTeamById(feeder.getObjectId(), teams);
					
					if (team != null) {
						event.getTeams().add(team);
					}
					
				}else {
					break;
				}
			}
		}
	}
	
	// load regional event teams
	public void populateRegionalEventTeams(Tier regionals, Tier sectionals) {
		
		// loop through each regional event
		for (Event event : regionals.getEvents()) {
			
			// loop through each feeder
			for (Feeder feeder : event.getFeeders()) {
				
				int feederEventId = feeder.getParentEventId();
				
				if (feederEventId > 32 && feederEventId < 49) {
					
					Event feederEvent = Event.getEventById(feeder.getObjectId(), sectionals.getEvents());
					
					if (feederEvent != null) {
						event.getTeams().addAll(feederEvent.getTeams());
					}
	
				}	
			}	
		}
	}
	
	// TODO Merge below two methods into above method
	
	// load semi state event teams
	public void populateSemiStateEventTeams(Tier semistates, Tier regionals) {
		
		// loop through each semistate event
		for (Event event : semistates.getEvents()) {
			
			// loop through each feeder
			for (Feeder feeder : event.getFeeders()) {
				
				int feederEventId = feeder.getParentEventId();
				
				if (feederEventId > 48 && feederEventId < 53) {
					
					Event feederEvent = Event.getEventById(feeder.getObjectId(), regionals.getEvents());
					
					if (feederEvent != null) {
						event.getTeams().addAll(feederEvent.getTeams());
					}
	
				}	
			}	
		}
	}
	
	// load state event teams
	public void populateStateEventTeams(Tier state, Tier semistates) {
		
		// loop through each semistate event
		for (Event event : state.getEvents()) {
			
			// loop through each feeder
			for (Feeder feeder : event.getFeeders()) {
				
				int feederEventId = feeder.getParentEventId();
				
				if (feederEventId == 53) {
					
					Event feederEvent = Event.getEventById(feeder.getObjectId(), semistates.getEvents());
					
					if (feederEvent != null) {
						event.getTeams().addAll(feederEvent.getTeams());
					}
	
				}	
			}	
		}
		
	}
	
	private void populateLatLngs(Persistence dataBase) {
		for (Team team : teams) {
			// check to see if we have it cached
			if (team.getLat().equals("")) {
				String locationStr = team.getAddress() + ", " + team.getCity() + ", " + team.getState();
				String[] temp = PersistenceUtils.getGeoPointFromAddress(locationStr);
				if (temp[0] != "") {
					dataBase.setTeamLocation(temp, team.getTeam_id());
					System.out.println("Distance data added to Team " + team.getTeam_id());
				}else {
					System.out.println("Distance data failed to be added to Team " + team.getTeam_id());
				}
			}
		}
	}
	
	
	// load avg distances
	private void populateAvgDistances(Persistence dataBase) {
		
		for (Tier tier : tiers) {
			for (Event event : tier.getEvents()) {
				if (event.getAvgDistance() == 0.0) {
					
					String eventLatLng = event.getLat() + "," + event.getLng();
					
					double avg_dist = 0;
					double sum_dist = 0;
					double count_dist = 0;
					double min_dist = 0;
					double max_dist = 0;
					
					for (Team team : event.getTeams()) {
						
						try {
							
							String teamLatLng = team.getLat() + "," + team.getLng();
							String temp = PersistenceUtils.calculateDistance(eventLatLng, teamLatLng);
							
							if (temp != "") {
								
								double temp2 = Double.parseDouble(temp);
								sum_dist += temp2;
								count_dist++;
								if (temp2 > max_dist) {
									max_dist = temp2;
								}
								if (temp2 < min_dist || min_dist == 0) {
									min_dist = temp2;
								}
								
							}else {
								
							}
							
						}catch (Exception e) {
							
						}
					}
					System.out.println("");
					avg_dist = sum_dist / count_dist;
					dataBase.setEventDistance(event.getEventId(), avg_dist, min_dist, max_dist);
					
					System.out.println("Distance data added to Event " + event.getEventId());
				}
			}
		}
	}
	
	// converts tournament tier to string representation
	public void tierToString(String tier) {
		
		Tier temp = new Tier();
		String result = "";
		int count = 0;
		
		// grrrr hardcode ... but it will work for now
		// TODO: Remove hardcode
		if (tier.equals("sectionals")) {		
			temp = tiers.get(0);
		}else if (tier.equals("regionals")) {
			temp = tiers.get(1);
		}else if (tier.equals("semi-states")) {
			temp = tiers.get(2);
		}else if (tier.equals("state")){
			temp = tiers.get(3);
		}else {
			result = " "; 
		}
		
		// loop through each event
		if(!result.equals(" ")) {
			result += "<html><head><style> body { font-size: 20px; } div { background-color: #df4e6 } </style></head><body>---" +  temp.getName().toUpperCase() + "---\n";
			for (Event event : temp.getEvents()) {
				count++;
				result += "<div>"+ count + ". " + event.getName() + ", " + event.getLocation() + "</div>";
				
				for (Team team : event.getTeams()) {
					result += " • " + team.getName();
				}
				
				/*
				if (tier.equals("sectionals")) {
					for (Team team : event.getTeams()) {
						result += " • " + team.getName();
					}
				}else {
					for (Feeder feeder : event.getFeeders()) {
						result += " • " + feeder.getName();
					}
				}
				*/
			}
		}
		
		result += "</html>";
		
		setTierToString(result);
		
	}
	
	// converts tournament tier events to string representation
	public void tierEventToString(String tier) {
		
		ArrayList<Event> tierEvents  = new ArrayList<Event>();
		
		if (tier.equals("sectionals")) {		
			tierEvents = tiers.get(0).getEvents();
		}else if (tier.equals("regionals")) {
			tierEvents = tiers.get(1).getEvents();
		}else if (tier.equals("semi-states")) {
			tierEvents = tiers.get(2).getEvents();
		}else if (tier.equals("state")){
			tierEvents = tiers.get(3).getEvents();
		}else {
			// tierEvents = " "; 
		}
		
		String tierEventToStringTemp[] = new String[tierEvents.size()];
		
		int i = 0;
		
		for (Event event : tierEvents) {
			tierEventToStringTemp[i] = event.getEventId() + " " + event.getName(); 
			i++;
		}
		
		setTierEventToString(tierEventToStringTemp);
		
	}
	
	// retrieves the lat long pairs of a sectional
	public void latLongPairs(int eventId) {
		
		ArrayList<Double[]> result = new ArrayList<Double[]>();

		for (Tier tier : tiers) {
			for (Event event : tier.getEvents()) {
				if (event.getEventId() == eventId) {
					Double[] dbl= {0.0,0.0,0.0};
					
					dbl[0] = event.getLat();
					dbl[1] = event.getLng();
					dbl[2] = 0.0 + event.getEventId();
				
					result.add(dbl);
					
					for (Team team : event.getTeams()) {
						
						try {
							Double[] dbl2= {0.0,0.0,0.0};
							double lat = Double.parseDouble(team.getLat());
							double lng = Double.parseDouble(team.getLng());
							
							dbl2[0] = lat;
							dbl2[1] = lng;
							dbl2[2] = 0.0 + team.getTeam_id();
							
							result.add(dbl2);
						} catch (Exception ex) {
							
						}						
					}
					break;
				}
			}
		}
		
		
		setLatLongPairs(result);
	}
	
	public void distance(int eventId) {
		
		double conversion = 0.000621371192;
		
		for (Tier tier : tiers) {
			for (Event event : tier.getEvents()) {
				
				if (event.getEventId() == eventId) {
					double avgDist = event.getAvgDistance(); 
					double maxDist = event.getMaxDistance(); 
					double minDist = event.getMinDistance();
					avgDist*=conversion;
					maxDist*=conversion;
					minDist*=conversion;
					setAvgDistance(avgDist);
					setMaxDistance(maxDist);
					setMinDistance(minDist);
					return;
				}
			}
		}
	}
	
	// getters and setters
	
	public static Tournament getTournament() {
		return tournament;
	}
	
	public void saveTournament(Tournament tour) {

		JFrame frame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
        int userInput = fileChooser.showSaveDialog(frame);
        if (userInput == JFileChooser.APPROVE_OPTION) {
            try{
                File file = fileChooser.getSelectedFile();
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file+".tour"));

                outputStream.writeObject(tour);
                outputStream.close();

		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found. " + fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.println("IO Error. " + ioe.getMessage());
		}
            }

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public ArrayList<Tier> getTiers() {
		return tiers;
	}

	public void setTiers(ArrayList<Tier> tiers) {
		this.tiers = tiers;
		setChanged();
		notifyObservers();
	}

	public String getTierToString() {
		return tierToString;
	}

	public void setTierToString(String tierToString) {
		this.tierToString = tierToString;
		setChanged();
		notifyObservers();
	}
	
	public String[] getTierEventToString() {
		return tierEventToString;
	}

	public void setTierEventToString(String[] tierEventToString) {
		this.tierEventToString = tierEventToString;
		setChanged();
		notifyObservers();
	}
	
	public ArrayList<Double[]> getLatLongPairs() {
		return latLongPairs;
	}

	public void setLatLongPairs(ArrayList<Double[]> latLongPairs) {
		this.latLongPairs = latLongPairs;
		setChanged();
		notifyObservers();
	}
	
	public double getAvgDistance() {
		return avgDistance;
	}

	public void setAvgDistance(double avgDistance) {
		this.avgDistance = avgDistance;
		setChanged();
		notifyObservers();
	}

	public double getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
		setChanged();
		notifyObservers();
	}

	public double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
		setChanged();
		notifyObservers();
	}
	
	
}
