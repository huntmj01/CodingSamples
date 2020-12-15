/*
 * Matthew Hunt
 * CS 161 Project 1 
 */

package project1;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * HeaderJPanel
 * 
 * The top of the GUI that contains the title
 * 
 */

public class HeaderJPanel {

	// A JPanel and a JLabel field

	public JPanel headerPanel;
	private JLabel headerLabel;

	public void buildPanel() {

		// create the header label
		headerLabel = new JLabel("Auto Loan Calculator");

		// initialize the JPanel
		headerPanel = new JPanel();

		// change the color of the panel and
		// label background
		headerPanel.setBackground(Color.ORANGE);
		headerLabel.setForeground(Color.BLUE);

		// add the label component to the JPanel
		headerPanel.add(headerLabel);

	}
}
