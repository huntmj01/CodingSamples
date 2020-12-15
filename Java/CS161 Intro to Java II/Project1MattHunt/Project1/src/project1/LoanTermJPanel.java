/*
 * Matthew Hunt
 * CS 161 Project 1 
 */

package project1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
 * term loan part of the GUI that
 * lets the user pick between 
 * 24, 36, 48, and 60 months
 * 
 */

public class LoanTermJPanel {

	// fields
	
	// JPanel to hold the loanTermPanel
	public JPanel loanTermPanel;
	
	// 4 radio buttons and a button group to hold them
	private ButtonGroup radioButtonGroup;
	private static JRadioButton twentyFourMonths;
	private static JRadioButton thirtySixMonths;
	private static JRadioButton fourtyEightMonths;
	private static JRadioButton sixtyMonths;

	public void buildPanel() {
		
		// set the interest rate to .045 by default
		AutoInfoLoan.setInterestRate(.045);
		
		// initialize radio buttons
		twentyFourMonths = new JRadioButton("24 Months", true);	// set twenty four months to true
		thirtySixMonths = new JRadioButton("36 Months"); 
		fourtyEightMonths = new JRadioButton("48 Months");
		sixtyMonths = new JRadioButton("60 Months");
		
		// add listener to each radio button
		twentyFourMonths.addActionListener(new RadioHandler());
		thirtySixMonths.addActionListener(new RadioHandler());
		fourtyEightMonths.addActionListener(new RadioHandler());
		sixtyMonths.addActionListener(new RadioHandler());
		
		// group the radio buttons
		radioButtonGroup = new ButtonGroup();
		
		radioButtonGroup.add(twentyFourMonths);
		radioButtonGroup.add(thirtySixMonths);
		radioButtonGroup.add(fourtyEightMonths);
		radioButtonGroup.add(sixtyMonths);
		
		// initialize the JPanel
		loanTermPanel = new JPanel();

		// add a titled border
		loanTermPanel.setBorder(BorderFactory.createTitledBorder("Loan Term"));
		
		// add a grid layout
		loanTermPanel.setLayout(new GridLayout(4,1));	// 4 rows, 1 column
		
		// add the radio buttons to the JPanel
		loanTermPanel.add(twentyFourMonths);	// col 1, row 1
		loanTermPanel.add(thirtySixMonths);		// col 1, row 2
		loanTermPanel.add(fourtyEightMonths);	// col 1, row 3
		loanTermPanel.add(sixtyMonths);			// col 1, row 4

	}
	
	/*
	 * getLoanTerm finds which radio button is selected
	 * and returns the loan term
	 * 
	 * @return int term, the term of the loan
	 * 
	 */
	public static int getLoanTerm(){
		
		// set the default term to 24
		int term  = 24;
		
		// find which radio button is selected and
		// set the loan term
		if (twentyFourMonths.isSelected()){
			term = 24;
		}else if (thirtySixMonths.isSelected()){
			term = 36;
		}else if (fourtyEightMonths.isSelected()){
			term = 48;
		}else if (sixtyMonths.isSelected()){
			term = 60;
		}
		
		// return the loan term
		return term;
	}
	
	/*
	 * reset resets the the radio buttons to
	 * default value
	 * 
	 */
	public static void reset(){
		twentyFourMonths.setSelected(true);
	}
	
	// user selects a different radio button
	private class RadioHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// determine the interest rate by 
			// which radio button is selected
			
			double interestRate = 0;
			
			if (twentyFourMonths.isSelected()){
				interestRate = 0.045;
			} else if (thirtySixMonths.isSelected()){
				interestRate = 0.055;
			} else if (fourtyEightMonths.isSelected()){
				interestRate = 0.065;
			} else if (sixtyMonths.isSelected()){
				interestRate = 0.07;
			}
			
			// change the interest rate in the auto info loan
			AutoInfoLoan.setInterestRate(interestRate);
		}
	}
	
}
