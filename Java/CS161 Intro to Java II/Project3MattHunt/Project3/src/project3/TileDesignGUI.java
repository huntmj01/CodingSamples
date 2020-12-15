package project3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 
 * The TileDesignGUI class creates the graphical user interface as depicted in
 * Figures 1 and 2. It utilizes the TileDesign object to generate the correct
 * 9X9 tile matrix. It handles the button events as well.
 * 
 * @author 2015H_000
 *
 */

@SuppressWarnings("serial")
public class TileDesignGUI extends JFrame {

	// final fields
	
	private static final String[] COLOR_STRINGS = { "Black", "White", "Red", 
			"Green", "Blue", "Cyan", "Magenta", "Orange", "Pink", "Yellow", "Purple" };
	private static final String PURPLE_HEX_CODE = "#663399";
	
	// fields

	Tile[][] tiles;

	private JButton btnSave;
	private JButton btnLoad;
	private JButton btnExit;

	private JButton btnReset;

	private ButtonGroup bgpForegroundColor;
	private JRadioButton rbnBlack;
	private JRadioButton rbnWhite;
	private JRadioButton rbnRed;
	private JRadioButton rbnGreen;
	private JRadioButton rbnBlue;
	private JRadioButton rbnCyan;
	private JRadioButton rbnMagenta;
	private JRadioButton rbnOrange;
	private JRadioButton rbnPink;
	private JRadioButton rbnYellow;
	private JRadioButton rbnPurple;
	
	private JComboBox<String> cbxBackgroundColor;

	// constructor
	public TileDesignGUI() {
		// set up the JFrame

		// set the window title
		setTitle("Tile Designer");

		// Set the size of the window
		setSize(600, 400);

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

	private void buildPanel() {

		// initialize an empty 9x9 array of tiles
		tiles = new Tile[9][9];

		// create the tile panel to hold the tiles
		JPanel tilePanel = new JPanel(new GridLayout(9, 9));

		// loop through tiles array
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				// create new tile
				tiles[i][j] = new Tile();
				tiles[i][j].addActionListener(new TileHandler());
				// add blank tile to tile panel
				tilePanel.add(tiles[i][j]);
			}
		}

		// initialize the reset button
		btnReset = new JButton("Reset");

		// initialize the foreground color radio buttons
		rbnBlack = new JRadioButton("Black");
		rbnWhite = new JRadioButton("White", true); // default radio button
		rbnRed = new JRadioButton("Red");
		rbnGreen = new JRadioButton("Green");
		rbnBlue = new JRadioButton("Blue");
		rbnCyan = new JRadioButton("Cyan");
		rbnMagenta = new JRadioButton("Magenta");
		rbnOrange = new JRadioButton("Orange");
		rbnPink = new JRadioButton("Pink");
		rbnYellow = new JRadioButton("Yellow");
		rbnPurple = new JRadioButton("Purple");

		// initialize the foreground color button group
		bgpForegroundColor = new ButtonGroup();

		// add the foreground color radio buttons to the
		// foreground color button group
		bgpForegroundColor.add(rbnBlack);
		bgpForegroundColor.add(rbnWhite);
		bgpForegroundColor.add(rbnRed);
		bgpForegroundColor.add(rbnGreen);
		bgpForegroundColor.add(rbnBlue);
		bgpForegroundColor.add(rbnCyan);
		bgpForegroundColor.add(rbnMagenta);
		bgpForegroundColor.add(rbnOrange);
		bgpForegroundColor.add(rbnPink);
		bgpForegroundColor.add(rbnYellow);
		bgpForegroundColor.add(rbnPurple);

		// create the left radio panel with a 6,1 grid layout
		JPanel radioPanelLeft = new JPanel(new GridLayout(6, 1));

		// add the radio buttons to the radio panel
		radioPanelLeft.add(rbnBlack);
		radioPanelLeft.add(rbnWhite);
		radioPanelLeft.add(rbnRed);
		radioPanelLeft.add(rbnGreen);
		radioPanelLeft.add(rbnBlue);
		
		// create the right radio panel with a 6,1 grid layout
		JPanel radioPanelRight = new JPanel(new GridLayout(6, 1));
		
		// add the radio buttons to the radio panel
		radioPanelRight.add(rbnCyan);
		radioPanelRight.add(rbnMagenta);
		radioPanelRight.add(rbnOrange);
		radioPanelRight.add(rbnPink);
		radioPanelRight.add(rbnYellow);
		radioPanelRight.add(rbnPurple);

		JPanel radioPanel = new JPanel(new GridLayout(1,2));
		
		// add a titled border to the radio panel
		radioPanel.setBorder(BorderFactory.createTitledBorder("FG Color"));
		
		radioPanel.add(radioPanelLeft);
		radioPanel.add(radioPanelRight);

		// initialize the background color combo box and padd the
		// color strings to the drop down list
		cbxBackgroundColor = new JComboBox<String>(COLOR_STRINGS);

		// create the combo box panel
		JPanel comboBoxPanel = new JPanel();

		// add a border to the combo box panel
		comboBoxPanel.setBorder(BorderFactory.createTitledBorder("BG Color"));

		// add the background color combo box to the combo box panel
		comboBoxPanel.add(cbxBackgroundColor);

		// create the side panel with a 3,1 grid layout
		JPanel sidePanel = new JPanel(new GridLayout(3, 1));

		// add the reset button, radio panel, and combo box panel
		// to the side panel
		sidePanel.add(btnReset);
		sidePanel.add(radioPanel);
		sidePanel.add(comboBoxPanel);

		// initialize JButtons for bottom panel
		btnSave = new JButton("Save");
		btnLoad = new JButton("Load");
		btnExit = new JButton("Exit");

		// create the bottom panel with a 1,3 grid layout
		JPanel bottomPanel = new JPanel(new GridLayout(1, 3));

		// add JButtons to the bottom panel
		bottomPanel.add(btnSave);
		bottomPanel.add(btnLoad);
		bottomPanel.add(btnExit);

		// add action listeners to buttons
		btnReset.addActionListener(new ResetButtonHandler());
		btnSave.addActionListener(new SaveButtonHandler());
		btnLoad.addActionListener(new LoadButtonHandler());
		btnExit.addActionListener(new ExitButtonHandler());
		
		// add HotKeys to buttons
		btnReset.setMnemonic(KeyEvent.VK_R);
		btnSave.setMnemonic(KeyEvent.VK_S);
		btnLoad.setMnemonic(KeyEvent.VK_L);
		btnExit.setMnemonic(KeyEvent.VK_X);
		
		// add tool tips to buttons
		btnReset.setToolTipText("Resets the GUI to defaults.");
		btnSave.setToolTipText("Saves the current tile structure.");
		btnLoad.setToolTipText("Loads a new .til file.");
		btnExit.setToolTipText("Closes the program.");
		
		// create a master panel and add a border layout
		JPanel masterPanel = new JPanel(new BorderLayout());

		// add the tile panel, side panel, and bottom panel to the master panel
		masterPanel.add(tilePanel, BorderLayout.CENTER);
		masterPanel.add(sidePanel, BorderLayout.EAST);
		masterPanel.add(bottomPanel, BorderLayout.SOUTH);

		// add the master panel to JFrame
		add(masterPanel);

	}

	// user clicks a tile
	public class TileHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			// get the tile that was clicked
			Tile tileClicked = (Tile) e.getSource();

			// check which color is selected in the radio
			// boxes and set the tile foreground to that color
			if (rbnBlack.isSelected()) {
				tileClicked.setForegroundColor(Color.BLACK);
			} else if (rbnWhite.isSelected()) {
				tileClicked.setForegroundColor(Color.WHITE);
			} else if (rbnRed.isSelected()) {
				tileClicked.setForegroundColor(Color.RED);
			} else if (rbnGreen.isSelected()) {
				tileClicked.setForegroundColor(Color.GREEN);
			} else if (rbnBlue.isSelected()) {
				tileClicked.setForegroundColor(Color.BLUE);
			} else if (rbnCyan.isSelected()){
				tileClicked.setForegroundColor(Color.CYAN);
			} else if (rbnMagenta.isSelected()){
				tileClicked.setForegroundColor(Color.MAGENTA);
			} else if (rbnOrange.isSelected()){
				tileClicked.setForegroundColor(Color.ORANGE);
			} else if (rbnPink.isSelected()){
				tileClicked.setForegroundColor(Color.PINK);
			} else if (rbnYellow.isSelected()){
				tileClicked.setForegroundColor(Color.YELLOW);
			} else if (rbnPurple.isSelected()){
				tileClicked.setForegroundColor(Color.decode(PURPLE_HEX_CODE));
			}

			// check which color is selected in the combo box and set
			// the tile background to that color
			if (cbxBackgroundColor.getSelectedItem().equals("Black")) {
				tileClicked.setBackgroundColor(Color.BLACK);
			} else if (cbxBackgroundColor.getSelectedItem().equals("White")) {
				tileClicked.setBackgroundColor(Color.WHITE);
			} else if (cbxBackgroundColor.getSelectedItem().equals("Red")) {
				tileClicked.setBackgroundColor(Color.RED);
			} else if (cbxBackgroundColor.getSelectedItem().equals("Green")) {
				tileClicked.setBackgroundColor(Color.GREEN);
			} else if (cbxBackgroundColor.getSelectedItem().equals("Blue")) {
				tileClicked.setBackgroundColor(Color.BLUE);
			} else if (cbxBackgroundColor.getSelectedItem().equals("Cyan")){
				tileClicked.setBackgroundColor(Color.CYAN);
			} else if(cbxBackgroundColor.getSelectedItem().equals("Magenta")){
				tileClicked.setBackgroundColor(Color.MAGENTA);
			} else if(cbxBackgroundColor.getSelectedItem().equals("Orange")){
				tileClicked.setBackgroundColor(Color.ORANGE);
			} else if(cbxBackgroundColor.getSelectedItem().equals("Pink")){
				tileClicked.setBackgroundColor(Color.PINK);
			} else if(cbxBackgroundColor.getSelectedItem().equals("Yellow")){
				tileClicked.setBackgroundColor(Color.YELLOW);
			// because max
			} else if(cbxBackgroundColor.getSelectedItem().equals("Purple")){
				tileClicked.setBackgroundColor(Color.decode(PURPLE_HEX_CODE));
			}

			// check if label content of tile is X or O and then change
			// the label content to the opposite
			if (tileClicked.getLabelContent().equals("X")) {
				tileClicked.setLabelContent("O");
			} else if (tileClicked.getLabelContent().equals("O")) {
				tileClicked.setLabelContent("!");
			} else if (tileClicked.getLabelContent().equals("!")) {
				tileClicked.setLabelContent("@");
			} else if (tileClicked.getLabelContent().equals("@")) {
				tileClicked.setLabelContent("#");
			} else if (tileClicked.getLabelContent().equals("#")) {
				tileClicked.setLabelContent("X");
			}

		}
	}

	// user clicks reset button
	public class ResetButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// loop through tiles array
			for (int i = 0; i < tiles.length; i++) {
				for (int j = 0; j < tiles[i].length; j++) {
					// call the reset method of each tile
					tiles[i][j].reset();
				}
			}
			
			// reset background color comobo box and foreground 
			// color rbn list
			cbxBackgroundColor.setSelectedIndex(0);
			rbnWhite.setSelected(true);
			
		}
	}
	
	// user clicks save button
	public class SaveButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try{
				
				// create a JFileChooser so user can select 
				// a file to create
				JFileChooser fileChooser = new JFileChooser();
				int status = fileChooser.showSaveDialog(null);
				String fileName = "";
				
				if (status == JFileChooser.APPROVE_OPTION){
					File selectedFile = fileChooser.getSelectedFile();
					fileName = selectedFile.getPath();
				}
				
				// create file output stream
				FileOutputStream fstream = new FileOutputStream(fileName + ".til");
				// add the file output stream to the object output stream
				ObjectOutputStream outputFile = new ObjectOutputStream(fstream);
				// serialize the tiles object to the output file
				outputFile.writeObject(tiles);
				// close the output file
				outputFile.close();
				
			}catch (Exception ex){
				// print the exception
				System.out.println("An error has occured: " + ex);
			}
			
		}
	}

	// user clicks load button
	public class LoadButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try{
				
				// create a JFileChooser so user can select 
				// a file to open
				JFileChooser fileChooser = new JFileChooser();
				// add tile filter to the file chooser
				fileChooser.addChoosableFileFilter(new TileFilter());
				// disable the select all file filter
				fileChooser.setAcceptAllFileFilterUsed(false);
				
				int status = fileChooser.showOpenDialog(null);
				
				String fileName = "";
				
				if (status == JFileChooser.APPROVE_OPTION){
					File selectedFile = fileChooser.getSelectedFile();
					fileName = selectedFile.getPath();
				}
				
				// create file input stream
				FileInputStream fstream = new FileInputStream(fileName);
				// add the file input stream to the object input stream
				ObjectInputStream inputFile = new ObjectInputStream(fstream);
				// deserialize binary file to a tiles array
				Tile[][] inputTiles = (Tile[][])inputFile.readObject();
				
				// load tiles onto gui
				
				// loop through tiles array
				for (int i = 0; i < tiles.length; i++) {
					for (int j = 0; j < tiles[i].length; j++) {
						// set the tiles on the gui to the tiles in the file
						tiles[i][j].setBackgroundColor(inputTiles[i][j].getBackgroundColor());
						tiles[i][j].setForegroundColor(inputTiles[i][j].getForegroundColor());
						tiles[i][j].setLabelContent(inputTiles[i][j].getLabelContent());
					}
				}
				
				// close the input file
				inputFile.close();
				
			}catch (Exception ex){
				// print the exception
				System.out.println("An error has occured: " + ex);
			}
			
		}
	}
	
	// user clicks exit button
	public class ExitButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// exit the program
			System.exit(0);
		}
	}
}
