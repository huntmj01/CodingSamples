/*
 * Matthew Hunt
 * CS 161 Project 1 
 */

package project1;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * payment information of the GUI that contains
 * the total loan amount, monthly payment,
 * total payment
 */

public class PaymentInformationJPanel {
	
	// fields
	
	// JPanel to hold the paymentInformationPanel
	public JPanel paymentInformationPanel;
	
	// labels to hold the headers for the results
	private JLabel lblTotalLoanAmountTitle;
	private JLabel lblMonthlyPaymentTitle;
	private JLabel lblTotalPaymentTitle;
	
	// labels to hold the results
	private static JLabel lblTotalLoanAmount;
	private static JLabel lblMonthlyPayment;
	private static JLabel lblTotalPayment;

	public void buildPanel(){
		
		// initialize the fields
		
		lblTotalLoanAmountTitle = new JLabel("Total Loan Amount: ");
		lblMonthlyPaymentTitle = new JLabel("Monthly Payment: ");
		lblTotalPaymentTitle = new JLabel("Total Payment: ");
		
		lblTotalLoanAmount = new JLabel("0.0", SwingConstants.RIGHT);
		lblMonthlyPayment = new JLabel("0.0", SwingConstants.RIGHT);
		lblTotalPayment = new JLabel("0.0", SwingConstants.RIGHT);
		
		// Initialize the JPanel
		paymentInformationPanel = new JPanel();
		
		// add a titled border
		paymentInformationPanel.setBorder(BorderFactory.createTitledBorder("Payment Information"));
		
		// add a grid layout with 2 cols and 3 rows
		paymentInformationPanel.setLayout(new GridLayout(3,2));
		
		// add the labels to the panel
		paymentInformationPanel.add(lblTotalLoanAmountTitle);
		paymentInformationPanel.add(lblTotalLoanAmount);
		paymentInformationPanel.add(lblMonthlyPaymentTitle);
		paymentInformationPanel.add(lblMonthlyPayment);
		paymentInformationPanel.add(lblTotalPaymentTitle);
		paymentInformationPanel.add(lblTotalPayment);
				
	}
	
	/*
	 * setLabels is passed the results and then sets those
	 * results to the labels
	 * 
	 * @param amount, the amount of the loan
	 * 
	 * @param monthlyPayment, the monthly payment of the loan
	 * 
	 * @param total, the total of the loan
	 * 
	 */
	public static void setLabels(String amount, String monthlyPayment, String total) {
		lblTotalLoanAmount.setText(amount);
		lblMonthlyPayment.setText(monthlyPayment);
		lblTotalPayment.setText(total);
	}
	
	/*
	 * reset resets the labels to their 
	 * default value
	 * 
	 */
	public static void reset(){
		lblTotalLoanAmount.setText("0.0");
		lblMonthlyPayment.setText("0.0");
		lblTotalPayment.setText("0.0");
	}
}
