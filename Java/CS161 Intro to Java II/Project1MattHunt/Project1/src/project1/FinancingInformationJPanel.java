/*
 * Matthew Hunt
 * CS 161 Project 1 
 */

package project1;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * FinancingInformationJPanel
 * 
 * financing information part of the GUI that
 * lets the user set the 
 * Base Price, Down Payment, and Sales Tax
 * 
 */

public class FinancingInformationJPanel {
	
	// fields
	public JPanel financingInformationPanel;
	
	// 3 labels to hold headers for text boxes
	private JLabel lblBasePrice;
	private JLabel lblDownPayment;
	private JLabel lblSalesTax;
	
	// 3 text boxes for user to enter information
	private static JTextField tbxBasePrice;
	private static JTextField tbxDownPayment;
	private static JTextField tbxSalesTax;
	
	public void buildPanel(){
		
		// initialize fields
		
		financingInformationPanel = new JPanel();
		
		lblBasePrice = new JLabel("Base Price: $");
		lblDownPayment = new JLabel("Down Payment: $");
		lblSalesTax = new JLabel("Sales Tax: %");
		
		tbxBasePrice = new JTextField("0.0");
		tbxDownPayment = new JTextField("0.0");
		tbxSalesTax = new JTextField("7.0");
		
		// add a titled border
		financingInformationPanel.setBorder(BorderFactory.createTitledBorder("Financing Information"));
		
		// add a grid layout with 2 cols and 3 rows
		financingInformationPanel.setLayout(new GridLayout(3,2));
		
		// add the labels and text boxes to the panel
		financingInformationPanel.add(lblBasePrice);
		financingInformationPanel.add(tbxBasePrice);
		financingInformationPanel.add(lblDownPayment);
		financingInformationPanel.add(tbxDownPayment);
		financingInformationPanel.add(lblSalesTax);
		financingInformationPanel.add(tbxSalesTax);
	}
	
	/*
	 * getBasePrice retrieves the value the user entered
	 * in the base price text box 
	 * 
	 * @return double, the value in the base price 
	 * text box
	 * 
	 */
	public static double getBasePrice(){
		return Double.parseDouble(tbxBasePrice.getText());
	}
	
	/*
	 * getDownPayment retrieves the value the user entered
	 * in the down payment text box 
	 * 
	 * @return double, the value in the down payment 
	 * text box
	 * 
	 */
	public static double getDownPayment(){
		return Double.parseDouble(tbxDownPayment.getText());
	}
	
	/*
	 * getBasePrice retrieves the value the user entered
	 * in the sales tax text box 
	 * 
	 * @return double, the value in the sales tax
	 * text box
	 * 
	 */
	public static double getSalesTax(){
		return Double.parseDouble(tbxSalesTax.getText());
	}
	
	/*
	 * reset resets the the text boxes to their 
	 * default value
	 * 
	 */
	public static void reset(){
		tbxBasePrice.setText("0.0");
		tbxDownPayment.setText("0.0");
		tbxSalesTax.setText("7.0");
	}
}
