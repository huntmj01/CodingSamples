package project2;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerPanel {

	private JPanel guestPanel;
	private JPanel dealerPanel;

	private JLabel[] lblGuest;
	private JLabel[] lblDealer;

	private JLabel lblGuestSum;
	private JLabel lblDealerSum;

	// construct each player's panel
	public PlayerPanel() {

		// initialize JLabels
		lblGuest = new JLabel[12];
		lblDealer = new JLabel[12];

		lblGuestSum = new JLabel("Sum = 0", JLabel.CENTER);
		lblDealerSum = new JLabel("Sum = 0", JLabel.CENTER);

		// initialize guest panel
		guestPanel = new JPanel(new GridLayout(lblGuest.length + 1, 1));

		// add a border to the guest panel
		guestPanel.setBorder(BorderFactory.createTitledBorder("Guest Hand"));

		// add sum of hand label to guest panel
		guestPanel.add(lblGuestSum);

		// loop through guest labels
		for (int i = 0; i < lblGuest.length; i++) {
			// create JLabels with text 'empty' and centered
			lblGuest[i] = new JLabel("Empty", JLabel.CENTER);
			// add the label to the guest panel
			guestPanel.add(lblGuest[i]);
		}

		// initialize dealer panel
		dealerPanel = new JPanel(new GridLayout(lblDealer.length + 1, 1));

		// add border to dealer panel
		dealerPanel.setBorder(BorderFactory.createTitledBorder("Dealer Hand"));

		// add sum of hand to dealer panel
		dealerPanel.add(lblDealerSum);

		// loop through dealer labels
		for (int i = 0; i < lblDealer.length; i++) {
			// initialize JLabel with text 'empty' and centered
			lblDealer[i] = new JLabel("Empty", JLabel.CENTER);
			// add label to dealer panel
			dealerPanel.add(lblDealer[i]);
		}

	}
	
	/**
	 * 
	 * clearTable() clears the guest and dealer sum labels,
	 * guest card labels, and dealer card labels
	 * 
	 */
	public void clearTable(){
		
		// clear guest and dealer
		// sum labels
		lblGuestSum.setText("Sum = 0");
		lblDealerSum.setText("Sum = 0");
		
		// loop through guest card labels
		for (int i = 0; i < lblGuest.length; i++){
			// clear
			lblGuest[i].setText("");
		}
		
		// loop through dealer card labels
		for (int i = 0; i < lblDealer.length; i++){
			// clear
			lblDealer[i].setText("");
		}
		
	}
	
	// getters and setters

	public JPanel getGuestPanel() {
		return guestPanel;
	}

	public void setGuestPanel(JPanel guestPanel) {
		this.guestPanel = guestPanel;
	}

	public JPanel getDealerPanel() {
		return dealerPanel;
	}

	public void setDealerPanel(JPanel dealerPanel) {
		this.dealerPanel = dealerPanel;
	}

	public void setGuestTable(Card[] hand, int value) {
		
		// loop through cards in guest hand
		for (Card c : hand) {
			// if card is null then break the loop
			if (c == null)break;
			// loop through the guest hand labels
			for (int i = 0; i < lblGuest.length; i++){
				// check if guest label is empty
				if (lblGuest[i].getText().equals("")){
					// set the text to the card
					lblGuest[i].setText(c.toString());
					// break the loop
					break;
				}	
			}
		}
		
		// set the sum of the guest sum label
		lblGuestSum.setText("Sum = " + value);
	
	}
	
	public void setDealerTable(Card[] hand, int value) {
		
		// loop through cards in dealer hand
		for (Card c : hand) {
			// if card is null then break the loop
			if (c == null)break;
			// loop through dealer hand labels
			for (int i = 0; i < lblDealer.length; i++){
				// check if dealer hand label is empty
				if (lblDealer[i].getText().equals("")){
					// set the text to the card
					lblDealer[i].setText(c.toString());
					// break the loop
					break;
				}	
			}
		}
		
		// set the sum of the dealer sum label
		lblDealerSum.setText("Sum = " + value);
	
	}
	
}
