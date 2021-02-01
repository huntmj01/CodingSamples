package view;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import model.Tournament;

/*
 * 
 * Name: 		Nick Becker, Matthew Hunt, Zarni Mon
 * Course:		CS360-01 Software Engineering
 * Instructor: 	eProf Sedlmeyer
 * Project:		Assignment 9: Sprint 2
 * Date:		03/28/18
 * Due:			04/11/18
 * 
 * Class:		TournamentCreatorGUI.java
 * Description:	Creates the GUI following the MVC model
 * 				
 * 
 * 
 **/
public class TournamentCreatorGui extends JFrame implements Observer {

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 1L;

	// declare private fields
	private Tournament theModel; // holds instance of Tournament
	private JButton btnViewState1;
	private JTextPane textPane;
	private JTextPane textPaneAvg;
	private JTextPane textPaneMin;
	private JTextPane textPaneMax;

	//private GoogleMapView mapView;  // omitted by NB, x2 check
	protected static GoogleMapView mapComponent;
	protected static GoogleMap map;
	JPanel mapPane = new JPanel();
	JTabbedPane tabbedPane;
	JComboBox<String> comboBox;

	// Constructor
	/**
	 * 
	 * @param label
	 * @param model
	 */
	public TournamentCreatorGui(String label, Tournament model) {

		super();
		theModel = model;
		theModel.addObserver(this);
		setTitle("IHSAA Tournament Creator");
		setSize(1100, 750);

		// Create eventListener
		TournamentChangeListener tcl = new TournamentChangeListener();
		
		// Create and Configure JMenuBar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		// Create "Load Girls 2017 Tournament" menu Item
		JMenuItem mntmLoadTournament = new JMenuItem("Load Girls 2017 Tournament");
		mntmLoadTournament.addActionListener(tcl);
		mnFile.add(mntmLoadTournament);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(tcl);
		mnFile.add(mntmSave);

		// Create "Exit" menu Item
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(tcl);

		//ButtonGroup btgroup = new ButtonGroup(); // omitted by NB, x2 check

		// Create and Configure JPanel
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);

		// Create and Add "View Sectional" Button
		JButton btnViewSectionals = new JButton("View Sectionals");
		btnViewSectionals.setBounds(8, 663, 134, 23);
		btnViewSectionals.addActionListener(tcl);
		panel.setLayout(null);
		panel.add(btnViewSectionals);

		// Create and Add "View Regionals" Button
		JButton btnViewRegionals = new JButton("View Regionals");
		btnViewRegionals.setBounds(181, 663, 134, 23);
		btnViewRegionals.addActionListener(tcl);
		panel.add(btnViewRegionals);

		// Create and Add "View Semi-states" Button
		JButton btnViewSemiState = new JButton("View Semi-states");
		btnViewSemiState.setBounds(351, 663, 134, 23);
		btnViewSemiState.addActionListener(tcl);
		panel.add(btnViewSemiState);

		// Create and Configure "View State" Button
		@SuppressWarnings("unused") //it is used
		JButton btnViewState = new JButton();
		btnViewState1 = new JButton("View State");
		btnViewState1.setBounds(527, 663, 134, 23);
		btnViewState1.addActionListener(tcl);
		panel.add(btnViewState1);

		// Create and Add "Clear View" Button
		JButton btnClearView = new JButton("Clear View");
		btnClearView.setBounds(694, 663, 134, 23);
		btnClearView.addActionListener(tcl);
		panel.add(btnClearView);

		// scrollPane.setViewportView(list);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		textPaneAvg = new JTextPane();
		textPaneAvg.setBounds(969, 32, 97, 20);
		textPaneAvg.setEditable(false);
		panel.add(textPaneAvg);

		textPaneMin = new JTextPane();
		textPaneMin.setBounds(969, 63, 98, 23);
		textPaneMin.setEditable(false);
		panel.add(textPaneMin);

		textPaneMax = new JTextPane();
		textPaneMax.setBounds(969, 97, 97, 20);
		textPaneMax.setEditable(false);
		panel.add(textPaneMax);

		JLabel lblAverageDistance = new JLabel("Average Distance");
		lblAverageDistance.setBounds(838, 32, 121, 20);
		panel.add(lblAverageDistance);

		JLabel lblMinimumDistance = new JLabel("Minimum Distance");
		lblMinimumDistance.setBounds(838, 63, 120, 23);
		panel.add(lblMinimumDistance);

		JLabel lblMaximumDistance = new JLabel("Maximum Distance");
		lblMaximumDistance.setBounds(838, 97, 121, 20);
		panel.add(lblMaximumDistance);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 818, 635);
		panel.add(tabbedPane);

		tabbedPane.addTab("Map View", null, mapPane, null);

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Table View", null, scrollPane, null);

		textPane = new JTextPane();
		textPane.setContentType("text/html");
		scrollPane.setViewportView(textPane);

		JLabel lblNewLabel = new JLabel("Select an event to view:");
		lblNewLabel.setBounds(838, 128, 134, 14);
		panel.add(lblNewLabel);

		// Create and Configure JComboBox
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(tcl);
		comboBox.setBounds(838, 153, 228, 20);
		panel.add(comboBox);

		// Start thread for map panel
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initAndShowGui(mapPane, theModel.getLatLongPairs());
			}
		});
	}

	/**
	 * Update the JTextPane of this GUI application in response to user input.
	 * 
	 * 
	 */
	@Override
	public void update(Observable arg0, Object arg1) {

		// Updates JComboBox

		String[] tierEventToString = theModel.getTierEventToString();
		setComboBoxList(tierEventToString);

		if (tabbedPane.getSelectedIndex() == 0) {

			// Updates Map Markers
			mapPane.removeAll();
			initAndShowGui(mapPane, theModel.getLatLongPairs());
		} else {
			// Update table view
			textPane.setText(theModel.getTierToString());
			textPane.setCaretPosition(0);
		}

		textPaneAvg.setText("" + theModel.getAvgDistance());
		textPaneMin.setText("" + theModel.getMinDistance());
		textPaneMax.setText("" + theModel.getMaxDistance());
	}


	/**
	 * @author Team 10;
	 */
	private class TournamentChangeListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String event = e.getActionCommand();

			if (event.equalsIgnoreCase("Exit")) {
				System.exit(0);
			// Add comment here...........
			} else if (comboBox == e.getSource()) {
				int comboBoxIndex = comboBox.getSelectedIndex();
				System.out.println(comboBoxIndex);
				String selectedItem = (String) comboBox.getSelectedItem();
				String[] tokens = selectedItem.split(" ");
				String itemIndexAsString = tokens[0];
				int itemIndex = Integer.parseInt(itemIndexAsString);
				theModel.latLongPairs(itemIndex);
				theModel.distance(itemIndex);
				comboBox.setSelectedIndex(comboBoxIndex);
			} else if (event.equals("Load Girls 2017 Tournament")) {
				theModel.tierToString("state");
			} else if (event.equals("Save")) {
				theModel.saveTournament(theModel);
			// View Sectionals Event
			} else if (event.equals("View Sectionals")) {
				// Map
				if (tabbedPane.getSelectedIndex() == 0) {
					theModel.tierEventToString("sectionals");
					comboBox.setSelectedIndex(0);
				} else {
					// Table
					theModel.tierToString("sectionals");
					theModel.tierEventToString("sectionals");
					comboBox.setSelectedIndex(0);
				}
			// View Regionals Event
			} else if (event.equals("View Regionals")) {
				// Map
				if (tabbedPane.getSelectedIndex() == 0) {
					theModel.tierEventToString("regionals");
					comboBox.setSelectedIndex(0);
				} else {
					// Table
					theModel.tierToString("regionals");
					theModel.tierEventToString("regionals");
					comboBox.setSelectedIndex(0);
				}
			// View Semi-states Event
			} else if (event.equals("View Semi-states")) {
				// Map
				if (tabbedPane.getSelectedIndex() == 0) {
					theModel.tierEventToString("semi-states");
					comboBox.setSelectedIndex(0);
					// theModel.latLongPairs(comboBox.getSelectedIndex());
				} else {
					// Table
					theModel.tierToString("semi-states");
					theModel.tierEventToString("semi-states");
					comboBox.setSelectedIndex(0);
				}
			// View State
			} else if (event.equals("View State")) {
				// Map
				if (tabbedPane.getSelectedIndex() == 0) {
					theModel.tierEventToString("View State");
					comboBox.setSelectedIndex(0);
				} else {
					// Table
					theModel.tierToString("state");
					theModel.tierEventToString("state");
					comboBox.setSelectedIndex(0);
				}
			// Clear View
			} else if (event.equals("Clear View")) {
				// Map
				if (tabbedPane.getSelectedIndex() == 0) {
					theModel.tierEventToString("clear view");
					comboBox.setSelectedIndex(0);
				} else {
					// Table
					theModel.tierToString("clear view");
					theModel.tierEventToString("clear view");
					comboBox.setSelectedIndex(0);
				}
			} else {
				System.out.print("Error: Event not Detected");
			}
		}
	}

	private void initAndShowGui(JPanel pane, Collection<Double[]> latLongPairs) {
		// This method is invoked on the EDT thread
		// JFrame frame = new JFrame("Swing and JavaFX");
		final JFXPanel fxPanel = new JFXPanel();
		pane.add(fxPanel);
		pane.setSize(300, 200);
		pane.setVisible(true);
		// pane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				initFx(fxPanel, latLongPairs);
			}
		});
	}

	private void initFx(JFXPanel fxPanel, Collection<Double[]> latLongPairs) {
		// This method is invoked on the JavaFX thread
		Scene scene = createScene(latLongPairs);
		fxPanel.setScene(scene);
	}

	private Scene createScene(Collection<Double[]> latLongPairs) {
		Group root = new Group();
		Scene scene = new Scene(root);

		mapComponent = new GoogleMapView();
		mapComponent.addMapInitializedListener(() -> configureMap(latLongPairs));
		root.getChildren().add(mapComponent);
		return (scene);
	}

	protected void configureMap(Collection<Double[]> latLongPairs) {
		MapOptions mapOptions = new MapOptions();

		mapOptions.center(new LatLong(39.99, -86.126976)).mapType(MapTypeIdEnum.ROADMAP).zoom(7);
		map = mapComponent.createMap(mapOptions, false);
		boolean first = true;
		for (Double[] mark : latLongPairs) {
			MarkerOptions marker = new MarkerOptions();
			marker.position(new LatLong(mark[0], mark[1]));
			marker.label("" + mark[2]);
			if (first) {
				marker.icon("http://maps.google.com/mapfiles/kml/pal3/icon23.png");
				first = false;
			} else {
				marker.icon("http://maps.google.com/mapfiles/ms/icons/blue-dot.png");
			}
			map.addMarker(new Marker(marker));
		}
	}

	private void setComboBoxList(String[] tierEvents) {

		// populate combobox
		if (tierEvents != null) {
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(tierEvents);
			comboBox.setModel(model);
		}

	}
}
