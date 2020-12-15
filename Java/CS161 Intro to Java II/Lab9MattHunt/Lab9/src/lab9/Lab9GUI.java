package lab9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class Lab9GUI extends JFrame {

	// private fields
	
	private static final String[] BACKGROUND_COLORS = { "Red", "Blue", "Purple" };
	private static final String[] FOREGROUND_COLORS = { "White", "Grey", "Yellow" };
	private static final String PURPLE_HEX_CODE = "#663399";

	private JPanel textAreaPanel, colorPanel, buttonPanel, masterPanel;

	private JTextArea tbxText;
	private JList<String> lstBackground;
	private JComboBox<String> cbxForeground;
	private JButton btnSave, btnLoad;

	public Lab9GUI() {
		// set the title and size of JPanel
		setTitle("Simple Color Word");
		setSize(600, 600);

		// build the GUI
		buildGUI();

		// set the default close operation to exit on close
		// because java and set the JPanel visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void buildGUI() {

		// initialize text box
		tbxText = new JTextArea();
		// set the default background color and size
		tbxText.setBackground(Color.WHITE);
		
		// add a scroll pane to the text area
		JScrollPane scroll = new JScrollPane(tbxText);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scroll.setPreferredSize(new Dimension(300, 500));
		
		// initialize the text area panel,
		// set its default background color,
		// and add the text box to it
		textAreaPanel = new JPanel();
		textAreaPanel.setBackground(Color.RED);
		textAreaPanel.add(scroll);
		
		// initialize the list and combo box
		lstBackground = new JList<String>(BACKGROUND_COLORS);
		cbxForeground = new JComboBox<String>(FOREGROUND_COLORS);

		// add listeners
		lstBackground.addListSelectionListener(new ListHandler());
		cbxForeground.addActionListener(new BoxHandler());

		// add borders to list and combo box
		lstBackground.setBorder(BorderFactory.createTitledBorder("Background Color"));
		cbxForeground.setBorder(BorderFactory.createTitledBorder("Foreground Color"));

		// initialize the color panel and add the list
		// and combo boxes to it
		colorPanel = new JPanel(new GridLayout(2, 1));
		colorPanel.add(lstBackground);
		colorPanel.add(cbxForeground);

		// initialize buttons
		btnSave = new JButton("Save");
		btnLoad = new JButton("Load");
		
		// add action listener to buttons
		btnSave.addActionListener(new SaveButtonHandler());
		btnLoad.addActionListener(new LoadButtonHandler());

		// initialize button panel and add buttons to it
		buttonPanel = new JPanel(new GridLayout(1, 2));
		buttonPanel.add(btnSave);
		buttonPanel.add(btnLoad);

		// initialize master panel and add the other
		// panels to it
		masterPanel = new JPanel(new BorderLayout());
		masterPanel.add(textAreaPanel, BorderLayout.CENTER);
		masterPanel.add(colorPanel, BorderLayout.EAST);
		masterPanel.add(buttonPanel, BorderLayout.SOUTH);

		// add the master panel to the JFrame
		add(masterPanel);

	}

	// user selects a different value in the list
	public class ListHandler implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {

			JList<String> temp = (JList<String>) arg0.getSource();

			// set to the new color
			if (temp.getSelectedValue().equals("Red")) {
				textAreaPanel.setBackground(Color.RED);
			} else if (temp.getSelectedValue().equals("Blue")) {
				textAreaPanel.setBackground(Color.BLUE);
			} else {
				textAreaPanel.setBackground(Color.decode(PURPLE_HEX_CODE));
			}
		}

	}
	
	// user changes drop down option
		public class BoxHandler implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				JComboBox<String> temp = (JComboBox<String>) e.getSource();

				// set to the new color
				if (temp.getSelectedItem().equals("White")) {
					tbxText.setBackground(Color.WHITE);
				} else if (temp.getSelectedItem().equals("Grey")) {
					tbxText.setBackground(Color.GRAY);
				} else {
					tbxText.setBackground(Color.YELLOW);
				}
			}

		}

	// user clicks save button
	public class SaveButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			try {

				// create a JFileChooser so user can select
				// a file to create
				JFileChooser fileChooser = new JFileChooser();
				int status = fileChooser.showSaveDialog(null);
				String fileName = "";

				if (status == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					fileName = selectedFile.getPath();
				}

				// create file output stream
				FileOutputStream fstream = new FileOutputStream(fileName + ".dat");
				// add the file output stream to the object output stream
				ObjectOutputStream outputFile = new ObjectOutputStream(fstream);
				// serialize the text area background and foreground to the output file
				outputFile.writeObject(tbxText.getText());
				outputFile.writeObject(lstBackground.getSelectedValue());
				outputFile.writeObject(cbxForeground.getSelectedItem().toString());
				// close the output file
				outputFile.close();

			} catch (Exception ex) {
				// print the exception
				System.out.println("An error has occured: " + ex);
			}

		}
	}

	// user clicks exit button
	public class LoadButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {

				// create a JFileChooser so user can select
				// a file to open
				JFileChooser fileChooser = new JFileChooser();
				// add dat filter to the file chooser
				fileChooser.addChoosableFileFilter(new DatFilter());
				// disable the select all file filter
				fileChooser.setAcceptAllFileFilterUsed(false);

				int status = fileChooser.showOpenDialog(null);

				String fileName = "";

				if (status == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					fileName = selectedFile.getPath();
				}

				// create file input stream
				FileInputStream fstream = new FileInputStream(fileName);
				// add the file input stream to the object input stream
				ObjectInputStream inputFile = new ObjectInputStream(fstream);
				// deserialize binary file
				
				String textArea = (String)inputFile.readObject();
				String background = (String)inputFile.readObject();
				String foreground = (String)inputFile.readObject();
				
				// set the background and foreground and text area to data
				// that was retrieved
				tbxText.setText(textArea);
				lstBackground.setSelectedValue(background, false);
				cbxForeground.setSelectedItem(foreground);
				
				// close the input file
				inputFile.close();

			} catch (Exception ex) {
				// print the exception
				System.out.println("An error has occured: " + ex);
			}
		}
	}

	public static void main(String[] args) {
		Lab9GUI gui = new Lab9GUI();
	}

}
