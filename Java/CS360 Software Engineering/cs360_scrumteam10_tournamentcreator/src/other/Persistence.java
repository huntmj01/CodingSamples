package other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.*;

import java.util.ArrayList;

import model.Event;
import model.Feeder;
import model.Team;
import model.Tier;

/*
 * 
 * Name: 		Zarni Mon, Nick Becker, Matthew Hunt
 * Course:		CS360-01 Software Engineering
 * Instructor: 	eProf Sedlmeyer
 * Project:		Assignment 9: Sprint 2
 * Date:		03/28/18
 * Due:			04/11/18
 * 
 * Class:		Persistence.java
 * Description:	Persistence maintains a connection and handles 
 * 				calls to the sqlite database.
 * 				
 **/
public class Persistence {
	
	///
	/// declare private fields
	///
	
	private static String CONNECTION_STRING 
		= "jdbc:sqlite:.\\resources\\TournamentCreatorDb.sqlite";	// holds the jdbc connection string
	
	private final String tableDefaultTeams = "default_teams";
	private final String columnTeamId = "team_id";
	private final String columnTeamName = "name";
	private final String columnTeamAdress = "address";
	private final String columnTeamCity = "city";
	private final String columnTeamState = "state";
	private final String columnTeamZip = "zip";
	private final String columnTeamGender = "gender";
	private final String columnTeamLat = "lat";
	private final String columnTeamLng = "lng";
	
	private final String tableDefaultTiers = "default_tiers";
	private final String columnTierId = "tier_id";
	private final String columnTierName = "name";
	
	private final String tableDefaultEvents = "default_events";
	private final String columnEventId = "event_id";
	private final String columnEventTierId = "tier_id";
	private final String columnEventName = "name";
	private final String columnEventLocation = "location";
	private final String columnEventAvgDist = "avg_dist";
	private final String columnEventMinDist = "min_dist";
	private final String columnEventMaxDist = "max_dist";
	private final String columnEventLat = "lat";
	private final String columnEventLng = "lng";
	
	private final String tableDefaultFeeders = "default_feeders";
	private final String columnFeederId = "feeder_id";
	private final String columnFeederEventId = "event_id";
	private final String columnFeederObjectId = "object_id";
	private final String columnFeederName = "name";
	
	private Connection conn = null;									// holds connection to sqlite database
	
	// constructor
	public Persistence() {
		conn = dbConnection();
	}
	
	/**
	 * dbConnection() attempts to make a connection to
	 * the sqlite database and returns the connection
	 * if successful.
	 * 
	 * @return conn: the connection to the sqlite database, 
	 * returns null if unsuccessful
	 */
	private Connection dbConnection() {
		
		///
		/// declare local variables
		///
		
		Connection result = null;	// holds the resulting connection
		
		// try to make the connection
		try {
			Class.forName("org.sqlite.JDBC");
			result = DriverManager.getConnection(CONNECTION_STRING);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		// return the resulting connection
		return result;
		
	}
	
	/**
	 * 
	 * close() closes the connection to the
	 * sqlite database.
	 * 
	 * @return success : whether or not the connection
	 * was closed successfully.
	 * 
	 */
	public boolean close() {
		
		///
		/// declare local variables
		///
		
		boolean success = true;		// holds whether or not connection was closed successfully
		
		// try to close the connection
		try {
			conn.close();
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		}
		
		// return whether or not the connection was closed successfully
		return success;
		
	}
	
	
	/**
	 * 
	 * populateDefaultTeams() retrieves all the teams in the
	 * default_teams table and returns them in an array list.
	 * 
	 * @return result: the resulting list of teams from the
	 * default_teams table. 
	 * 
	 */
	public ArrayList<Team> populateDefaultTeams() {
		
		///
		/// declare local variables
		///
		
		ArrayList<Team> result = new ArrayList<Team>();	// holds the resulting list of teams

		String query; 									// holds query string
		PreparedStatement stmt; 						// holds Prepared Statement to execute on the database
		ResultSet rs; 									// holds the result from the database
		
		try {
		
			// concatenate select query
			query = "SELECT * FROM " + tableDefaultTeams + " WHERE " + columnTeamGender + " = " + "?;";
	
			// initialize the prepare statement, execute it, and
			// store the result
			stmt = conn.prepareStatement(query);
			stmt.setString(1, "F");		// TODO: REMOVE HARDCODED GENDER IN SPRINT 2
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Team team = new Team();
				// store the result from the database in the team object
				team.setTeamId(rs.getInt(columnTeamId));
				team.setName(rs.getString(columnTeamName));
				team.setAddress(rs.getString(columnTeamAdress));
				team.setCity(rs.getString(columnTeamCity));
				team.setState(rs.getString(columnTeamState));
				team.setZip(rs.getString(columnTeamZip));
				team.setGender(rs.getString(columnTeamGender));
				team.setLat(rs.getString(columnTeamLat));
				team.setLng(rs.getString(columnTeamLng));
				result.add(team);
			}
		
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		// return the list of teams
		return result;
		
	}
	
	/**
	 * 
	 * populateDefaultTiers() retrieves all the tiers in the
	 * default_tiers table and returns them in an array list.
	 * 
	 * @return result: the resulting list of tiers from the
	 * default_teams table.
	 * 
	 **/
	public ArrayList<Tier> populateDefaultTiers() {
		
		///
		/// declare local variables
		///
		
		ArrayList<Tier> result = new ArrayList<Tier>();	// holds the resulting list of teams

		String query; 									// holds query string
		PreparedStatement stmt; 						// holds Prepared Statement to execute on the database
		ResultSet rs; 									// holds the result from the database
		
		try {
		
			// concatenate select query
			query = "SELECT * FROM " + tableDefaultTiers + ";";
	
			// initialize the prepare statement, execute it, and
			// store the result
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Tier tier = new Tier();
				// store the result from the database in the tier object
				tier.setTierId(rs.getInt(columnTierId));
				tier.setName(rs.getString(columnTierName));
				tier.setEvents(getDefaultEventsByTier(rs.getInt(columnTierId)));
				result.add(tier);
			}
		
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		// return the list of tiers
		return result;
		
	}
	
	/**
	 * 
	 * getDefaultEventsByTier() retrieves all the events with
	 * the specified tier_id in the default_events table 
	 * and returns them in an array list.
	 * 
	 * @param tierId : the id of the tier's whose events are
	 * to be retrieved.
	 * 
	 * @return result : the resulting list of events from the
	 * default_events table.
	 * 
	 **/
	public ArrayList<Event> getDefaultEventsByTier(int tierId) {
		
		///
		/// declare local variables
		///
		
		ArrayList<Event> result = new ArrayList<Event>();	// holds the resulting list of teams

		String query; 									// holds query string
		PreparedStatement stmt; 						// holds Prepared Statement to execute on the database
		ResultSet rs; 									// holds the result from the database
		
		try {
		
			// concatenate select query
			query = "SELECT * FROM " + tableDefaultEvents + " WHERE " + columnEventTierId + " = ?;";
	
			// initialize the prepare statement, execute it, and
			// store the result
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, tierId);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Event event = new Event();
				// store the result from the database in the event object
				event.setEventId(rs.getInt(columnEventId));
				event.setName(rs.getString(columnEventName));
				event.setLocation(rs.getString(columnEventLocation));
				event.setFeeders(getDefaultFeedersByEvent(rs.getInt(columnEventId)));
				event.setAvgDistance(rs.getDouble(columnEventAvgDist));
				event.setMinDistance(rs.getDouble(columnEventMinDist));
				event.setMaxDistance(rs.getDouble(columnEventMaxDist));
				event.setLat(rs.getDouble(columnEventLat));
				event.setLng(rs.getDouble(columnEventLng));
				result.add(event);
			}
		
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		// return the list of events
		return result;
		
	}
	
	
	
	/**
	 * 
	 * getDefaultEventsByTier() retrieves all the feeders with
	 * the specified event_id in the default_feeders table 
	 * and returns them in an array list.
	 * 
	 * @param eventId : the id of the event whose feeders 
	 * are to be retrieved
	 * 
	 * @return result : the resulting list of feeders from the
	 * default_feeders table.
	 * 
	 **/
	public ArrayList<Feeder> getDefaultFeedersByEvent(int eventId) {
		
		///
		/// declare local variables
		///
		
		ArrayList<Feeder> result = new ArrayList<Feeder>();	// holds the resulting list of teams

		String query; 									// holds query string
		PreparedStatement stmt; 						// holds Prepared Statement to execute on the database
		ResultSet rs; 									// holds the result from the database
		
		try {
		
			// concatenate select query
			query = "SELECT * FROM " +  tableDefaultFeeders + " WHERE " + columnFeederEventId + " = ?;";
	
			// initialize the prepare statement, execute it, and
			// store the result
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, eventId);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Feeder feeder = new Feeder();
				// store the result from the database in the feeder object
				feeder.setFeederId(rs.getInt(columnFeederId));
				feeder.setParentEventId(rs.getInt(columnFeederEventId));
				feeder.setName(rs.getString(columnFeederName));
				feeder.setObjectId(rs.getInt(columnFeederObjectId));
				result.add(feeder);
			}
		
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		// return the list of feeders
		return result;
		
	}
	
	public ArrayList<Team> setEventDistance(int eid, double avg_dist, double min_dist, double max_dist) {
		
		///
		/// declare local variables
		///
		
		ArrayList<Team> result = new ArrayList<Team>();	// holds the resulting list of teams

		String query; 									// holds query string
		PreparedStatement stmt; 						// holds Prepared Statement to execute on the database
		ResultSet rs; 									// holds the result from the database
		
		try {
		
			// concatenate select query
			query = "UPDATE " + tableDefaultEvents + " SET " + columnEventMaxDist + " = ?, " + columnEventMinDist + " = ?, " + columnEventAvgDist + " = ? WHERE " + columnEventId + " = ?;";
			// initialize the prepare statement, execute it, and
			// store the result
			stmt = conn.prepareStatement(query);
			
			stmt.setDouble(1, max_dist);
			stmt.setDouble(2, min_dist);
			stmt.setDouble(3, avg_dist);
			stmt.setInt(4, eid);		// TODO: REMOVE HARDCODED GENDER IN SPRINT 2
			stmt.executeUpdate();
		
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		// return the list of teams
		return result;
		
	}
	
	public ArrayList<Team> setTeamLocation(String[] location, int teamid) {
		
		///
		/// declare local variables
		///
		
		ArrayList<Team> result = new ArrayList<Team>();	// holds the resulting list of teams

		String query; 									// holds query string
		PreparedStatement stmt; 						// holds Prepared Statement to execute on the database
		ResultSet rs; 									// holds the result from the database
		
		try {
		
			// concatenate select query
			query = "UPDATE " + tableDefaultTeams + " SET " + columnTeamLat + " = ?, " + columnTeamLng + " = ? WHERE " + columnTeamId + " = ?;";
			// initialize the prepare statement, execute it, and
			// store the result
			stmt = conn.prepareStatement(query);
			stmt.setString(1, location[0]);	
			stmt.setString(2, location[1]);
			stmt.setInt(3, teamid);
			stmt.executeUpdate();
		
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		// return the list of teams
		return result;
		
	}
	
}
