package lab3;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ConversionCalculator extends JFrame {

	// Dimensions of JFrame
	private static final int WIDTH = 600;
	private static final int HEIGHT = 200;

	// Fields for elements in JFrame
	private JLabel lblCentimeters, lblMeters, lblInches, lblYards;
	private JTextField tbxCentimeters, tbxMeters, tbxInches, tbxYards;
	private JButton btnClear, btnCalculate, btnExit;

	public ConversionCalculator() {

		// set the title of the JFrame
		setTitle("Conversion Calculator");

		// initialize the elements
		lblCentimeters = new JLabel("Centimeters: ", SwingConstants.RIGHT);
		lblMeters = new JLabel("Meters: ", SwingConstants.RIGHT);
		lblInches = new JLabel("Inches: ", SwingConstants.RIGHT);
		lblYards = new JLabel("Yards: ", SwingConstants.RIGHT);

		tbxCentimeters = new JTextField(10);
		tbxMeters = new JTextField(10);
		tbxInches = new JTextField(10);
		tbxYards = new JTextField(10);

		tbxCentimeters.setText("0.0");
		tbxMeters.setText("0.0");
		tbxInches.setText("0.0");
		tbxYards.setText("0.0");

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ClearButtonHandler());
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new CalculateButtonHandler());
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ExitButtonHandler());

		// create a button panel to hold the clear and calc button
		JPanel buttonPanel = new JPanel();
		// add a grid layout with 2 rows and 1 col
		buttonPanel.setLayout(new GridLayout(2, 1));

		// add the buttons to the button panel
		buttonPanel.add(btnClear); // row 1 col 1
		buttonPanel.add(btnCalculate); // row 2 col 1

		// retrieve the pain to add the elements
		Container pane = this.getContentPane();

		// add a grid layout with 2 rows and 5 cols
		pane.setLayout(new GridLayout(2, 5));

		// add the elements to the pane
		pane.add(lblCentimeters); // row 1 col 1
		pane.add(tbxCentimeters); // row 1 col 2
		pane.add(lblInches); // row 1 col 3
		pane.add(tbxInches); // row 1 col 4
		pane.add(buttonPanel); // row 1 col 5
		pane.add(lblMeters); // row 2 col 1
		pane.add(tbxMeters); // row 2 col 2
		pane.add(lblYards); // row 2 col 3
		pane.add(tbxYards); // row 2 col 4
		pane.add(btnExit); // row 2 col 5

		// set the size of the JFrame
		setSize(WIDTH, HEIGHT);

		// set the JFrame to visible
		setVisible(true);

		// set the JFrame to exit on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// user clicks the clear button
	private class ClearButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			System.out.println("Clear Button clicked. Page has been cleared.");

			// set the text boxes back to the default
			tbxCentimeters.setText("0.0");
			tbxInches.setText("0.0");
			tbxMeters.setText("0.0");
			tbxYards.setText("0.0");
		}
	}

	// user clicks the calculate button
	private class CalculateButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Calculate Button clicked.");

			// check if centimeters text box has number other than default
			if (!(tbxCentimeters.getText().equals("0.0"))) {
				
				// retrieve the centimeters from the text box
				double centimeters = Double.parseDouble(tbxCentimeters.getText());
				
				// convert
				tbxInches.setText("" + twoDecFormat(centimeters * 0.393701));
				tbxMeters.setText("" + twoDecFormat(centimeters * 0.01));
				tbxYards.setText("" + twoDecFormat(centimeters * 0.0109361));
			}

			// check if inches text box has number other than default
			else if (!(tbxInches.getText().equals("0.0"))) {
				
				// retrieve the inches from the text box
				double inches = Double.parseDouble(tbxInches.getText());
				
				// convert
				tbxCentimeters.setText("" + twoDecFormat(inches * 2.54));
				tbxMeters.setText("" + twoDecFormat(inches * 0.0254));
				tbxYards.setText("" + twoDecFormat(inches * 0.0278));
			}
			
			// check if meters text box has number other than default
			else if (!(tbxMeters.getText().equals("0.0"))) {
				
				// retrieve the meters from the text box
				double meters = Double.parseDouble(tbxMeters.getText());
				
				// convert
				tbxCentimeters.setText("" + twoDecFormat(meters * 100));
				tbxInches.setText("" + twoDecFormat((meters * 39.3701)));
				tbxYards.setText("" + twoDecFormat((meters * 1.09361)));
			}
			
			// check if yards text box has number other than default
			else if (!(tbxYards.getText().equals("0.0"))) {
				
				// retrieve the yards from the text box
				double yards = Double.parseDouble(tbxYards.getText());
				
				// convert
				tbxCentimeters.setText("" + twoDecFormat(yards * 91.44));
				tbxInches.setText("" + twoDecFormat((yards * 36)));
				tbxMeters.setText("" + twoDecFormat((yards * 0.9144)));
			}
		}
	}

	// user clicks the exit button
	private class ExitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Exit Button clicked. Exiting Program.");
			// Exit the program
			System.exit(0);
		}
	}
	
	// private method to format doubles to 2 decimal places
	private static double twoDecFormat(double d){
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.parseDouble(df.format(d));
	}
}
