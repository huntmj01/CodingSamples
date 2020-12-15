package project2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TableGUI extends JFrame {

	// fields

	PlayerPanel playerPanel;
	
	private JLabel lblTableHeader;

	public TableGUI() {
		
		// set up the JFrame

		// set the window title
		setTitle("Twenty One Game Table");

		// Set the size of the window
		setSize(400, 450);

		// specify what happens when the
		// GUI is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// turn off the option to resize the window
		setResizable(false);

		// build the panel
		buildPanel();

		// set the JFrame visible
		setVisible(true);
	}

	
	/**
	 * 
	 * buildPanel() creates a panel with labels to show
	 * the hands of both the dealer and the guest
	 * and then adds the panel to the JFrame 
	 * 
	 */
	public void buildPanel() {
		
		// initialize JLabels

		lblTableHeader = new JLabel("Empty Table", JLabel.CENTER);

		// create a header panel to hold header
		JPanel headerPanel = new JPanel();

		// add the table header label to the
		// header panel and change the background to green
		headerPanel.add(lblTableHeader);
		headerPanel.setBackground(Color.GREEN);

		// create a master panel to hold all the other panels
		// add a border layout
		JPanel masterPanel = new JPanel(new BorderLayout());

		// create a player panel to retrieve the guest and
		// dealer panels
		playerPanel = new PlayerPanel();
		
		// create a combined panel to hold both the
		// guest panel and the dealer panel
		JPanel combinedPanel = new JPanel(new GridLayout(1,2));
		
		combinedPanel.add(playerPanel.getGuestPanel());
		combinedPanel.add(playerPanel.getDealerPanel());
		
		// add the header and combined panel to the master panel
		masterPanel.add(headerPanel, BorderLayout.NORTH);
		masterPanel.add(combinedPanel, BorderLayout.CENTER);

		// add the master panel to the JFrame
		add(masterPanel);
		
	}
	
	/**
	 * 
	 * clearTable() calls the playerPanels
	 * clearTalbe() method
	 * 
	 */
	public void clearTable(){
		playerPanel.clearTable();
	}
	
	// getters and setters
	
	public void setLblTableHeader(String newHeader) {
		lblTableHeader.setText(newHeader);
	}
	
	public void setGuestTable(Card[] hand, int value){
		playerPanel.setGuestTable(hand, value);
	}
	
	public void setDealerTable(Card[] hand, int value){
		playerPanel.setDealerTable(hand, value);
	}
	
	
}
