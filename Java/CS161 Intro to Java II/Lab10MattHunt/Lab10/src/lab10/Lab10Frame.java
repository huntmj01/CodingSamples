package lab10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Lab10Frame extends JFrame {

	private static Lab10Frame frame;
	private static Lab10Panel panel;
	private Timer timer;

	// The following will reference menu components.
	private JMenuBar menuBar; // The menu bar
	private JMenu fileMenu; // The File menu
	private JMenu animalsMenu; // The animals menu
	private JMenuItem exitItem; // To exit
	private JRadioButtonMenuItem turkeyItem; // Makes turkey drawing
	private JRadioButtonMenuItem fishItem; // Makes fish drawing
	private JRadioButtonMenuItem rockItem; // Makes rock drawing
	private JCheckBoxMenuItem rotateItem; // slideshow of terrible drawings

	public static void main(String[] args) {
		// initialize panel and frame
		panel = new Lab10Panel();
		frame = new Lab10Frame();
		// set the frame visible
		frame.setVisible(true);
	}

	public Lab10Frame() {

		// add panel to jframe
		add(panel);
		// set size
		setSize(500, 500);
		// because java
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// build the menu bar
		buildMenuBar();
		pack();
		timer = new Timer(3000, new TimerListener());
	}

	// menu bar
	private void buildMenuBar() {
		// Create the menu bar.
		menuBar = new JMenuBar();

		// build the menu
		buildFileMenu();
		buildAnimalsMenu();

		// Add the file and text menus to the menu bar.
		menuBar.add(fileMenu);
		menuBar.add(animalsMenu);

		// Set the window's menu bar.
		setJMenuBar(menuBar);
	}

	private void buildFileMenu() {
		// Create an Exit menu item.
		exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.addActionListener(new ExitListener());

		// Create a check box menu item
		rotateItem = new JCheckBoxMenuItem("Rotate", false);
		rotateItem.setMnemonic(KeyEvent.VK_R);
		rotateItem.addActionListener(new RotateListener());

		// Create a JMenu object for the File menu.
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);

		fileMenu.add(rotateItem);
		fileMenu.addSeparator(); // Add a separator bar.

		// Add the Exit menu item to the File menu.
		fileMenu.add(exitItem);
	}

	private void buildAnimalsMenu() {

		// create the 3 animal menu items, set mnemonics for them,
		// and add action listeners
		
		turkeyItem = new JRadioButtonMenuItem("Turkey on Crack", true);
		turkeyItem.setMnemonic(KeyEvent.VK_T);
		turkeyItem.addActionListener(new ItemListener());

		fishItem = new JRadioButtonMenuItem("Fish that I actually tried on");
		fishItem.setMnemonic(KeyEvent.VK_F);
		fishItem.addActionListener(new ItemListener());

		rockItem = new JRadioButtonMenuItem("Domesticated Pet Rock");
		rockItem.setMnemonic(KeyEvent.VK_D);
		rockItem.addActionListener(new ItemListener());

		// Create a button group for the radio button items.
		ButtonGroup group = new ButtonGroup();
		group.add(turkeyItem);
		group.add(fishItem);
		group.add(rockItem);

		// Create a JMenu object for the Animals menu.
		animalsMenu = new JMenu("Animals");
		animalsMenu.setMnemonic(KeyEvent.VK_A);

		// Add the menu items to the Animals menu.
		animalsMenu.add(turkeyItem);
		animalsMenu.add(fishItem);
		animalsMenu.add(rockItem);
	}

	// user clicks exit button
	private class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	// user selects another animal
	private class ItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// find which animal is currently selected,
			// change it to the next one, and repaint
			if (turkeyItem.isSelected()) {
				panel.setAnimal(0);
				repaint();
			} else if (fishItem.isSelected()) {
				panel.setAnimal(1);
				repaint();
			} else if (rockItem.isSelected()) {
				panel.setAnimal(2);
				repaint();
			}
		}
	}
	
	// user selects timer check box
	private class RotateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// if checked start timer else stop timer
			if (rotateItem.isSelected())
				timer.start();
			else
				timer.stop();
		}
	}

	// fires every 3 seconds
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// check which item is selected, check the next item,
			// and repaint
			if (turkeyItem.isSelected()) {
				fishItem.setSelected(true);
				panel.setAnimal(1);
				repaint();
			} else if (fishItem.isSelected()) {
				rockItem.setSelected(true);
				panel.setAnimal(2);
				repaint();
			} else {
				turkeyItem.setSelected(true);
				panel.setAnimal(0);
				repaint();
			}
		}
	}
}
