package project2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TwentyOneGUI extends JFrame {

	// fields

	private Deck deck;
	private Guest guest;
	private Dealer dealer;

	private boolean nextRound;

	private TableGUI tableGUI;

	private JLabel lblGuestWinsHeader;
	private JLabel lblGuestWins;
	private JLabel lblDealerWinsHeader;
	private JLabel lblDealerWins;

	private JButton btnStartGame;
	private JButton btnLeaveTable;
	private JButton btnDealGuestCards;
	private JButton btnDealDealerCards;

	private int guestScore;
	private int dealerScore;

	// Constructor
	public TwentyOneGUI() {

		// set up the JFrame

		// set the window title
		setTitle("Score Board");

		// Set the size of the window
		setSize(400, 150);

		// specify what happens when the
		// GUI is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// turn off the option to resize the window
		setResizable(false);

		// build the panel
		buildPanel();

		// set the JFrame visible
		setVisible(true);

		// initialize tableGUI
		tableGUI = new TableGUI();
	}

	/**
	 * 
	 * buildPanel() creates a panel with labels to show the amount of guest wins
	 * and dealer wins and buttons with the options to start the game, leave the
	 * table, deal the guest cards, deal the dealer cards and then adds the
	 * panel to the JFrame
	 * 
	 */
	private void buildPanel() {

		// initialize JLabels
		lblGuestWinsHeader = new JLabel("Guest Wins", JLabel.CENTER);
		lblGuestWins = new JLabel("0", JLabel.CENTER);
		lblDealerWinsHeader = new JLabel("Dealer Wins", JLabel.CENTER);
		lblDealerWins = new JLabel("0", JLabel.CENTER);

		// initialize JButtons
		btnStartGame = new JButton("Start Game");
		btnLeaveTable = new JButton("Leave Table");
		btnDealGuestCards = new JButton("Deal Guest Cards");
		btnDealDealerCards = new JButton("Deal Dealer Cards");

		// add action listeners to buttons
		btnStartGame.addActionListener(new StartGameButtonHandler());
		btnDealGuestCards.addActionListener(new DealGuestCardButtonHandler());
		btnDealDealerCards.addActionListener(new DealDealerCardButtonHandler());
		btnLeaveTable.addActionListener(new LeaveTableButtonHandler());

		// deal card buttons are disabled by default
		btnDealGuestCards.setEnabled(false);
		btnDealDealerCards.setEnabled(false);

		// create a JPanel to hold the guest labels
		// add a gridlayout to the guest panel
		JPanel guestPanel = new JPanel(new GridLayout(2, 1));

		// set the background of the guest panel to Magenta
		guestPanel.setBackground(Color.MAGENTA);

		// add the guest labels to the guest panel
		guestPanel.add(lblGuestWinsHeader);
		guestPanel.add(lblGuestWins);

		// create a JPanel to hold the dealer labels
		// add a gridlayout to the dealer panel
		JPanel dealerPanel = new JPanel(new GridLayout(2, 1));

		// set the background of the dealer panel to Cyan
		dealerPanel.setBackground(Color.CYAN);

		// add the dealer labels to the dealer panel
		dealerPanel.add(lblDealerWinsHeader);
		dealerPanel.add(lblDealerWins);

		// create a JPanel to hold the headers and buttons
		// add a grid layout to the panel
		JPanel masterPanel = new JPanel(new GridLayout(3, 2));

		// add everything to the master panel
		masterPanel.add(guestPanel);
		masterPanel.add(dealerPanel);
		masterPanel.add(btnStartGame);
		masterPanel.add(btnLeaveTable);
		masterPanel.add(btnDealGuestCards);
		masterPanel.add(btnDealDealerCards);

		// add the panel the JFrame
		add(masterPanel);
	}

	// Listeners

	// user clicks the start game button
	public class StartGameButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			// instantiate new Deck, Guest, and Dealer objects
			deck = new Deck();
			guest = new Guest();
			dealer = new Dealer();

			// initialize flag
			nextRound = false;

			// shuffle the deck
			deck.shuffle();

			// enable the deal guest cards button
			btnDealGuestCards.setEnabled(true);

			// change the header label on the twenty one game table gui
			// to say "Good Luck!"
			tableGUI.setLblTableHeader("Good Luck!");

			// clear the table
			tableGUI.clearTable();

			// disable start game button
			btnStartGame.setEnabled(false);
		}
	}

	// user clicks the deal guest card button
	public class DealGuestCardButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			// check if the table and player hands need cleared
			if (nextRound == true) {
				// call the clear method
				clear();
				// set flag to false
				nextRound = false;
			}

			// draw first card
			guest.hit(deck);

			// loop until the guest stands
			while (!guest.stand()) {
				guest.hit(deck);
			}

			// send results to the game table
			tableGUI.setGuestTable(guest.getHand(), guest.valueOf());

			// display guest hand sum on table header
			tableGUI.setLblTableHeader("Guest hand = " + guest.valueOf());

			// if value of guest hand does not exceed 21 then disable
			// the guest button and enable the dealer button
			if (!guest.bust()) {
				// set the dealer button to enabled and
				// guest button to disabled
				btnDealGuestCards.setEnabled(false);
				btnDealDealerCards.setEnabled(true);
			} else {
				// notify user that dealer won
				tableGUI.setLblTableHeader("Guest Bust => Dealer Wins!");
				// dealer wins so increase dealer score by won
				dealerScore++;
				// set flag to true
				nextRound = true;
				// update score
				lblGuestWins.setText("" + guestScore);
				lblDealerWins.setText("" + dealerScore);
			}

		}
	}

	// user clicks the deal dealer card button
	public class DealDealerCardButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			dealer.hit(deck);

			// loop until the guest stands
			while (!dealer.stand()) {
				dealer.hit(deck);
			}

			// send results to the game table
			tableGUI.setDealerTable(dealer.getHand(), dealer.valueOf());

			// display guest hand sum on table header
			tableGUI.setLblTableHeader("Dealer sum = " + dealer.valueOf());

			// display results

			if (guest.valueOf() > 21) {
				tableGUI.setLblTableHeader("Guest Bust => Dealer Wins!");
				dealerScore++;
			} else if (dealer.valueOf() > 21) {
				tableGUI.setLblTableHeader("Dealer Bust => Guest Wins!");
				guestScore++;
			} else {
				if (guest.valueOf() > dealer.valueOf()) {
					tableGUI.setLblTableHeader("Guest Wins!");
					guestScore++;
				} else {
					tableGUI.setLblTableHeader("Dealer Wins!");
					dealerScore++;
				}
			}

			nextRound = true;

			btnDealGuestCards.setEnabled(true);
			btnDealDealerCards.setEnabled(false);

			lblGuestWins.setText("" + guestScore);
			lblDealerWins.setText("" + dealerScore);
		}
	}

	// user clicks the leave table button
	public class LeaveTableButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// exit the program
			System.exit(0);
		}
	}

	/**
	 * 
	 * clear() clears the table, guest hand,
	 * and dealers hand
	 * 
	 */
	public void clear() {
		tableGUI.clearTable();
		guest.clearHand();
		dealer.clearHand();
	}
}
