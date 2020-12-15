/*
 * Matthew Hunt
 * CS 161 Project 1 
 */

package project1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * price with options part of the GUI that
 * lets the user pick select additional items
 * to add on to the car such as auto transmission,
 * anti lock break, sun roof, navigation system,
 * audio package
 * 
 */

public class PriceWithOptionsJPanel {

	// 1 JPanel, 6 JLabels to correspond with
	// the check boxes, and 6 check boxes
	// the user can add additional items
	// to their loan

	public JPanel priceWithOptionsPanel;

	private JLabel lblAutoTransmission;
	private JLabel lblAntiLockBrake;
	private JLabel lblSunRoof;
	private JLabel lblNavigationSystem;
	private JLabel lblAudioPackage;

	private static JCheckBox cbxAutoTransmission;
	private static JCheckBox cbxAntiLockBrake;
	private static JCheckBox cbxSunRoof;
	private static JCheckBox cbxNavigationSystem;
	private static JCheckBox cbxAudioPackage;

	public void buildPanel() {

		// set the options cost to 1200 by default
		AutoInfoLoan.setOptionsCost(1200.0);
		
		// initialize labels
		lblAutoTransmission = new JLabel("Auto Transsmission: $1,800");
		lblAntiLockBrake = new JLabel("Anti-Lock Brake: $1,200");
		lblSunRoof = new JLabel("Sun Roof: $800");
		lblNavigationSystem = new JLabel("Navigation System: $1,350");
		lblAudioPackage = new JLabel("Audio Package: $1,550");

		// initialize check boxes
		cbxAutoTransmission = new JCheckBox();
		cbxAntiLockBrake = new JCheckBox("", true); // set this check box to true by default
		cbxSunRoof = new JCheckBox();
		cbxNavigationSystem = new JCheckBox();
		cbxAudioPackage = new JCheckBox();

		// add listener to check boxes
		cbxAutoTransmission.addActionListener(new CheckBoxHandler());
		cbxAntiLockBrake.addActionListener(new CheckBoxHandler());
		cbxSunRoof.addActionListener(new CheckBoxHandler());
		cbxNavigationSystem.addActionListener(new CheckBoxHandler());
		cbxAudioPackage.addActionListener(new CheckBoxHandler());
		
		// initialize JPanel
		priceWithOptionsPanel = new JPanel();

		// add a titled border
		priceWithOptionsPanel.setBorder(BorderFactory.createTitledBorder("Price with Options"));

		// add a grid layout with 2 columns and 5 rows
		priceWithOptionsPanel.setLayout(new GridLayout(5, 2));

		// add check boxes and labels to the panel
		priceWithOptionsPanel.add(cbxAutoTransmission); // row 1, col 1
		priceWithOptionsPanel.add(lblAutoTransmission); // row 1, col 2
		priceWithOptionsPanel.add(cbxAntiLockBrake); // row 2, col 1
		priceWithOptionsPanel.add(lblAntiLockBrake); // row 2, col 2
		priceWithOptionsPanel.add(cbxSunRoof); // row 3, col 1
		priceWithOptionsPanel.add(lblSunRoof); // row 3, col 2
		priceWithOptionsPanel.add(cbxNavigationSystem); // row 4, col 1
		priceWithOptionsPanel.add(lblNavigationSystem); // row 4, col 2
		priceWithOptionsPanel.add(cbxAudioPackage); // row 5, col 1
		priceWithOptionsPanel.add(lblAudioPackage); // row 5, col 2

	}

	/*
	 * reset resets the the check boxes to their default value
	 * 
	 */
	public static void reset() {
		cbxAutoTransmission.setSelected(false);
		cbxAntiLockBrake.setSelected(true);
		cbxSunRoof.setSelected(false);
		cbxNavigationSystem.setSelected(false);
		cbxAudioPackage.setSelected(false);
	}

	// user selects a check box
	private class CheckBoxHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int total = 0;

			if (cbxAutoTransmission.isSelected()) {
				total += 1800;
			}
			if (cbxAntiLockBrake.isSelected()) {
				total += 1200;
			}
			if (cbxSunRoof.isSelected()) {
				total += 800;
			}
			if (cbxNavigationSystem.isSelected()) {
				total += 1350;
			}
			if (cbxAudioPackage.isSelected()) {
				total += 1550;
			}
			// change the interest rate in the auto info loan
			AutoInfoLoan.setOptionsCost(total);
		}
	}

}
