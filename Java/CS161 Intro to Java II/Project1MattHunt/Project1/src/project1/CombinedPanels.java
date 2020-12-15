/*
 * Matthew Hunt
 * CS 161 Project 1 
 */

package project1;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

/*
 * CombinedPanels
 * 
 * Contains all of the JPanel Subclasses
 * 
 */

public class CombinedPanels {

	// JPanel field to hold the main panel
	public static JPanel main;

	public CombinedPanels() {

		// create variables to hold the JPanels
		HeaderJPanel hp = new HeaderJPanel();
		PaymentInformationJPanel pi = new PaymentInformationJPanel();
		FinancingInformationJPanel fi = new FinancingInformationJPanel();
		LoanTermJPanel lt = new LoanTermJPanel();
		PriceWithOptionsJPanel po = new PriceWithOptionsJPanel();
		ActionButtonsJPanel ab = new ActionButtonsJPanel();

		// create the center east and west panels
		JPanel eastPanel = new JPanel();
		JPanel westPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		
		// add a grid layout with 2 rows and 1 column
		// to east and west panel
		eastPanel.setLayout(new GridLayout(2, 1));
		westPanel.setLayout(new GridLayout(2, 1));
		
		// add a grid layout with 1 row and 2 columns
		// to the center panel
		centerPanel.setLayout(new GridLayout(1, 2));

		// build all the panels
		hp.buildPanel();
		pi.buildPanel();
		fi.buildPanel();
		lt.buildPanel();
		po.buildPanel();
		ab.buildPanel();

		// add the loan term panel and price with options 
		// to the east panel
		eastPanel.add(lt.loanTermPanel);
		eastPanel.add(po.priceWithOptionsPanel);
		
		// add the payment information and financing information
		// panels to the west panel
		westPanel.add(pi.paymentInformationPanel);
		westPanel.add(fi.financingInformationPanel);

		// add the west and east panel to the center panel
		centerPanel.add(westPanel);
		centerPanel.add(eastPanel);
		
		// initialize the main panel
		main = new JPanel();

		// add a border layout the the main panel
		main.setLayout(new BorderLayout());

		// add panels to the main JPanel
		main.add(hp.headerPanel, BorderLayout.NORTH);
		main.add(centerPanel, BorderLayout.CENTER);
		main.add(ab.actionButtonPanel, BorderLayout.SOUTH);
	}

}
