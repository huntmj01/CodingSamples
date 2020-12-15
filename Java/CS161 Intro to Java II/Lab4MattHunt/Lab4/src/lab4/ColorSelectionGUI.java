package lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class ColorSelectionGUI extends JFrame {

	// fields

	// colors
	private final Color RED = Color.RED;
	private final Color GREEN = Color.GREEN;
	private final Color BLUE = Color.BLUE;
	private final Color PURPLE = Color.decode("#551a8b");	// decode hex code to get EC and make max happy
	private final Color WHITE = Color.WHITE;

	// JPanels
	private JPanel centerCombinedPanel;
	private JPanel locationsPanel;
	private JPanel backgroundColorPanel;

	private JPanel northPanel;
	private JPanel eastPanel;
	private JPanel southPanel;
	private JPanel westPanel;

	// Labels
	private JLabel lblNorth;
	private JLabel lblEast;
	private JLabel lblSouth;
	private JLabel lblWest;

	private JLabel lblLocationsNorth;
	private JLabel lblLocationsEast;
	private JLabel lblLocationsSouth;
	private JLabel lblLocationsWest;

	private JLabel lblRed;
	private JLabel lblGreen;
	private JLabel lblBlue;
	private JLabel lblPurple;

	// check boxes
	private JCheckBox cbxNorth;
	private JCheckBox cbxSouth;
	private JCheckBox cbxEast;
	private JCheckBox cbxWest;

	// radio buttons
	private ButtonGroup radioGroup;
	private JRadioButton rbnRed;
	private JRadioButton rbnGreen;
	private JRadioButton rbnBlue;
	private JRadioButton rbnPurple;

	public ColorSelectionGUI() {

		// set up the JFrame

		// set the window title
		setTitle("Color Selection GUI");

		// Set the size of the window
		setSize(400, 200);

		// specify what happens when the
		// GUI is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// turn off the option to resize the window
		setResizable(false);

		// add a border layout to the JFrame
		setLayout(new BorderLayout());

		// build the panels
		buildPanel();

		// add the panels to the JFrame
		add(northPanel, BorderLayout.NORTH);
		add(eastPanel, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
		add(westPanel, BorderLayout.WEST);
		add(centerCombinedPanel, BorderLayout.CENTER);

		// set the JFrame visible
		setVisible(true);
	}

	private void buildPanel() {

		// initialize panels
		centerCombinedPanel = new JPanel();
		locationsPanel = new JPanel();
		backgroundColorPanel = new JPanel();
		northPanel = new JPanel();
		eastPanel = new JPanel();
		southPanel = new JPanel();
		westPanel = new JPanel();

		// initialize labels
		lblNorth = new JLabel("North", SwingConstants.CENTER);
		lblEast = new JLabel("East");
		lblSouth = new JLabel("South", SwingConstants.CENTER);
		lblWest = new JLabel("West");

		// set text color to white
		lblNorth.setForeground(WHITE);
		lblEast.setForeground(WHITE);
		lblSouth.setForeground(WHITE);
		lblWest.setForeground(WHITE);

		lblLocationsNorth = new JLabel("North");
		lblLocationsEast = new JLabel("East");
		lblLocationsSouth = new JLabel("South");
		lblLocationsWest = new JLabel("West");

		lblRed = new JLabel("Red");
		lblGreen = new JLabel("Green");
		lblBlue = new JLabel("Blue");
		lblPurple = new JLabel("Purple");

		// set text color accordingly
		lblRed.setForeground(RED);
		lblGreen.setForeground(GREEN);
		lblBlue.setForeground(BLUE);
		lblPurple.setForeground(PURPLE);

		// initialize check boxes
		cbxNorth = new JCheckBox("", true);
		cbxEast = new JCheckBox("", true);
		cbxSouth = new JCheckBox("", true);
		cbxWest = new JCheckBox("", true);

		// initialize radio group and radio buttons
		radioGroup = new ButtonGroup();
		rbnRed = new JRadioButton();
		rbnGreen = new JRadioButton();
		rbnBlue = new JRadioButton();
		rbnPurple = new JRadioButton("", true);
		
		// add listeners to radio buttons
		rbnRed.addActionListener(new RadioHandler());
		rbnGreen.addActionListener(new RadioHandler());
		rbnBlue.addActionListener(new RadioHandler());
		rbnPurple.addActionListener(new RadioHandler());
		
		// add radio buttons to radio group
		radioGroup.add(rbnRed);
		radioGroup.add(rbnGreen);
		radioGroup.add(rbnBlue);
		radioGroup.add(rbnPurple);

		// add labels to north south east and west panels
		// and set the background color to purple
		northPanel.add(lblNorth);
		northPanel.setBackground(PURPLE);

		eastPanel.setLayout(new GridLayout(1, 1));
		eastPanel.add(lblEast);
		eastPanel.setBackground(PURPLE);

		southPanel.add(lblSouth);
		southPanel.setBackground(PURPLE);

		westPanel.setLayout(new GridLayout(1, 1));
		westPanel.add(lblWest);
		westPanel.setBackground(PURPLE);

		// add a border to locations panel
		locationsPanel.setBorder(new TitledBorder("Locations"));

		// add a grid layout with 4 rows and 2 columns
		// to the location panel
		locationsPanel.setLayout(new GridLayout(4, 2));

		// add elements to locations panel
		locationsPanel.add(cbxNorth);
		locationsPanel.add(lblLocationsNorth);
		locationsPanel.add(cbxEast);
		locationsPanel.add(lblLocationsEast);
		locationsPanel.add(cbxSouth);
		locationsPanel.add(lblLocationsSouth);
		locationsPanel.add(cbxWest);
		locationsPanel.add(lblLocationsWest);

		// add a titled border to the background panel
		backgroundColorPanel.setBorder(new TitledBorder("BG Color"));

		// add a grid layout with 4 rows and 2 columns
		// to the background color panel
		backgroundColorPanel.setLayout(new GridLayout(4, 2));

		// add elements to background color panel
		backgroundColorPanel.add(rbnRed);
		backgroundColorPanel.add(lblRed);
		backgroundColorPanel.add(rbnGreen);
		backgroundColorPanel.add(lblGreen);
		backgroundColorPanel.add(rbnBlue);
		backgroundColorPanel.add(lblBlue);
		backgroundColorPanel.add(rbnPurple);
		backgroundColorPanel.add(lblPurple);

		// add a grid layout with 1 row and 2 columns
		// to the combined panel and then add the
		// location and background panel to it
		centerCombinedPanel.setLayout(new GridLayout(1, 2));
		centerCombinedPanel.add(locationsPanel);
		centerCombinedPanel.add(backgroundColorPanel);
	}

	// user selects a different radio button
	private class RadioHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// determine which radio button is
			// selected and then call changeColor
			if (rbnRed.isSelected()) {
				changeColor(RED);
			} else if (rbnGreen.isSelected()) {
				changeColor(GREEN);
			} else if (rbnBlue.isSelected()) {
				changeColor(BLUE);
			} else {
				changeColor(PURPLE);
			}
		}

		// helper method
		private void changeColor(Color c) {
			
			// determine which check boxes
			// are selected and then change
			// the panel(s) to the specified color
			if (cbxNorth.isSelected()) {
				northPanel.setBackground(c);
			}
			if (cbxEast.isSelected()) {
				eastPanel.setBackground(c);
			}
			if (cbxSouth.isSelected()) {
				southPanel.setBackground(c);
			}
			if (cbxWest.isSelected()) {
				westPanel.setBackground(c);
			}
		}
	}

}
