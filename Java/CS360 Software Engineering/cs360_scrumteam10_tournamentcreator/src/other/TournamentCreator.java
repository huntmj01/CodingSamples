package other;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import model.Event;
import model.Feeder;
import model.Team;
import model.Tier;
import model.Tournament;
import view.TournamentCreatorGui;

/*
 * 
 * Name: 		Zarni Mon, Nick Becker, Matthew Hunt
 * Course:		CS360-01 Software Engineering
 * Instructor: 	eProf Sedlmeyer
 * Project:		Assignment 9: Sprint 2
 * Date:		03/28/18
 * Due:			04/11/18
 * 
 * Class:		TournamentCreator.java
 * Description:	Holds main method to run program
 * 				
 **/

public class TournamentCreator extends JFrame {

	
	public static void main(String[] args) {

		try {
			com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green", "INSERT YOUR LICENSE KEY HERE", "my company");
			// Set LAF
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

			// create the model
			// Tournament tour = new Tournament("2017-18 GIRLS CROSS COUNTRY STATE
			// TOURNAMENT");
			//Tournament tour = loadTournament("./save/2017_Girls_Tournament.tour");

			Tournament tour = Tournament.getTournament();
			
			//printTournament(tour);
			
			//saveTournament("./save/2017_Girls_Tournament.tour", tour);
			
			TournamentCreatorGui gui = new TournamentCreatorGui("lbl", tour);
			
			gui.setSize(1105, 750);
			gui.setVisible(true);

			// save a tournament
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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

	private static Tournament loadTournament(String filename) {

		Tournament result = null;

		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
			result = (Tournament) is.readObject();
			is.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found. " + fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.println("IO Error. " + ioe.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Class not found. " + cnfe.getMessage());
		}

		return result;

	}

	private static void printTournament(Tournament tour) {

		ArrayList<Tier> tiers = tour.getTiers();
		String format = "%-40s";
		String format2 = "%-40s%-40s";

		for (Tier tier : tiers) {
			System.out.printf(format2, "\n\n---" + tier.getName().toUpperCase() + " NAME---",
					"---" + tier.getName().toUpperCase() + " LOCATION---\n");
			for (Event event : tier.getEvents()) {
				System.out.printf(format2, "\n" + event.getName(), event.getLocation());
				System.out.print("\n\tFeeder: >> ");
				for (Feeder feeder : event.getFeeders()) {
					System.out.print(feeder.getName() + ", ");
				}
				System.out.print("<<");
			}
		}

	}

	private static void printTeams(Tournament tour) {

		System.out.println("\n---" + tour.getName() + "---\n");
		ArrayList<Team> teams = tour.getTeams();
		String format = "%-40s %-30s %-30s %-30s %-30s %n";

		System.out.printf(format, "name", "address", "city, state", "zip", "gender");
		System.out.printf(format, "----", "-------", "-----------", "---", "------");

		for (Team team : teams) {
			System.out.printf(format, team.getName(), team.getAddress(), team.getCity() + ", " + team.getState(),
					team.getZip(), team.getGender());
		}

	}

}
