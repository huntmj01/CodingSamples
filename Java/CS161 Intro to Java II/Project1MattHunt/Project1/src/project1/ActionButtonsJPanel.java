/*
 * Matthew Hunt
 * CS 161 Project 1 
 */

package project1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * ActionButtonsJPanel
 * 
 * The bottom JPanel of the GUI that contains
 * the calculate, reset, and exit buttons.
 * 
 */

public class ActionButtonsJPanel {

	// 1 public JPanel field so JPanel can be
	// accessed by other classes, 2 private
	// JLabels to add spacing to the grid layout,
	// and 3 private JButtons
	public JPanel actionButtonPanel;
	private JLabel lblBlank;
	private JLabel lblBlank2;
	private JButton btnCalculate;
	private JButton btnReset;
	private JButton btnExit;

	// constructor
	public void buildPanel() {

		// initialize the fields

		// initialize the panel
		actionButtonPanel = new JPanel();

		// initialize blank labels
		lblBlank = new JLabel("");
		lblBlank2 = new JLabel("");

		// initialize the calculate button
		btnCalculate = new JButton("Calculate");

		// initialize the reset button
		btnReset = new JButton("Reset");

		// initialize the exit button
		btnExit = new JButton("Exit");

		// add listeners to the buttons
		btnCalculate.addActionListener(new CalculateButtonHandler());
		btnReset.addActionListener(new ResetButtonHandler());
		btnExit.addActionListener(new ExitButtonHandler());

		// add a titled border to the panel
		actionButtonPanel.setBorder(BorderFactory.createTitledBorder("Action Buttons"));

		// add a grid layout with 1 row and 5 columns
		actionButtonPanel.setLayout(new GridLayout(1, 5));

		// add the button and label components to the JPanel
		actionButtonPanel.add(btnCalculate); // row 1, col 1
		actionButtonPanel.add(lblBlank); // row 1, col 2
		actionButtonPanel.add(btnReset); // row 1, col 3
		actionButtonPanel.add(lblBlank2); // row 1, col 4
		actionButtonPanel.add(btnExit); // row 1, col 5

	}

	// Listeners

	// user clicks the calculate button
	public class CalculateButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// log to the console that the user has clicked
			// the calculate button
			System.out.println("Calculate button clicked. Computing Auto Loan.");
			// call the computeAutoLoan() method from the
			// AutoInfoLoan class
			AutoInfoLoan.computeAutoLoan();
		}
	}

	// user clicks the reset button
	private class ResetButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// call the reset method for each JPanel class
			PaymentInformationJPanel.reset();
			LoanTermJPanel.reset();
			FinancingInformationJPanel.reset();
			PriceWithOptionsJPanel.reset();
			// log to the console that the page has been reset
			System.out.println("Page has been reset to default values.");
		}
	}

	// user clicks the exit button
	private class ExitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// log to the console that the exit button has been clicked
			System.out.println("Exit button clicked. Exiting the program.");
			// exit the program
			System.exit(0);
		}
	}

}
