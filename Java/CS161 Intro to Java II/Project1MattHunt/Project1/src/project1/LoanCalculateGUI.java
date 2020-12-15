/*
 * Matthew Hunt
 * CS 161 Project 1 
 */

package project1;

import javax.swing.JFrame;

/*
 * LoanCalculateGUI
 * 
 * constructs the GUI
 * 
 */

@SuppressWarnings("serial")
public class LoanCalculateGUI extends JFrame {
	public LoanCalculateGUI() {
		
		// set up the JFrame

		// set the window title
		setTitle("Auto Loan Calculator");

		// Set the size of the window
		setSize(675, 400);

		// specify what happens when the 
		// GUI is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// turn off the option to resize the window
		setResizable(false);
		
		// call the combined panels constructor
		new CombinedPanels();

		// add the main panel to the JFrame
		add(CombinedPanels.main);

		// set the JFrame visible
		setVisible(true);

	}
}
