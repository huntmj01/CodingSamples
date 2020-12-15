package lab5B;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Lab5BGUI extends JFrame {

	// JPanel fields

	private JPanel radioPanel, inputPanel, leftPanel, rightPanel, masterPanel;
	private JRadioButton rbnIp, rbnId, rbnEmail;
	private ButtonGroup parseBGroup;
	private JTextField tbxInput, tbxParseMessage, tbxParse1, tbxParse2, tbxParse3, tbxParse4;
	private JButton btnTokenize;

	public Lab5BGUI() {

		// set the title and size of JPanel
		setTitle("Parser");
		setSize(500, 500);

		// build the GUI
		buildGUI();

		// set the default close operation to exit on close
		// because java and set the JPanel visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	// private method to build the gui
	private void buildGUI() {

		// Initialize radio buttons
		rbnIp = new JRadioButton("IP Address", true);
		rbnId = new JRadioButton("ID Number");
		rbnEmail = new JRadioButton("Email");

		// initialize radio button group and
		// add the radio buttons to it
		parseBGroup = new ButtonGroup();
		parseBGroup.add(rbnIp);
		parseBGroup.add(rbnId);
		parseBGroup.add(rbnEmail);

		// Initialize radio panel with 1 col and 3 rows
		radioPanel = new JPanel(new GridLayout(3, 1));

		// add the radio buttons to the radio panel
		radioPanel.add(rbnIp);
		radioPanel.add(rbnId);
		radioPanel.add(rbnEmail);

		// initialize input text field and button
		tbxInput = new JTextField();
		btnTokenize = new JButton("Tokenize");

		// add an action listener to the button
		btnTokenize.addActionListener(new ButtonListener());

		// initialize the input panel with 1 col and 2 rows
		inputPanel = new JPanel(new GridLayout(2, 1));

		// add the text field and button to the input panel
		inputPanel.add(tbxInput);
		inputPanel.add(btnTokenize);

		// initialize the left panel with 2 cols and 1 row
		leftPanel = new JPanel(new GridLayout(1, 2));

		// add the radio panel and input panel to the
		// left panel
		leftPanel.add(radioPanel);
		leftPanel.add(inputPanel);

		// initialize parse text fields
		tbxParseMessage = new JTextField("");
		tbxParse1 = new JTextField("---");
		tbxParse2 = new JTextField("---");
		tbxParse3 = new JTextField("---");
		tbxParse4 = new JTextField("---");

		// set all the parse text fields to disabled
		tbxParseMessage.setEnabled(false);
		tbxParse1.setEnabled(false);
		tbxParse2.setEnabled(false);
		tbxParse3.setEnabled(false);
		tbxParse4.setEnabled(false);

		// initialize the right panel with 1 col and 5 rows
		rightPanel = new JPanel(new GridLayout(5, 1));

		// add the parse text fields to the right panel
		rightPanel.add(tbxParseMessage);
		rightPanel.add(tbxParse1);
		rightPanel.add(tbxParse2);
		rightPanel.add(tbxParse3);
		rightPanel.add(tbxParse4);

		// initialize the master panel with 2 col and 1 row
		masterPanel = new JPanel(new GridLayout(1, 2));

		// add both the left and right panel to the master panel
		masterPanel.add(leftPanel);
		masterPanel.add(rightPanel);

		// add the master panel to the JFrame
		add(masterPanel);

	}

	// method called when user clicks the tokenize button
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// user has the IP radio button selected
			if (rbnIp.isSelected()) {

				// create a tokenizer that delimits by periods
				StringTokenizer ipTokenizer = new StringTokenizer(tbxInput.getText(), ".");

				// flag to mark if format is invalid
				boolean invalid = false;

				// strings to hold the 4 different IPs
				String ip1 = "";
				String ip2 = "";
				String ip3 = "";
				String ip4 = "";

				// loop through the ip tokenizer
				while (ipTokenizer.hasMoreTokens()) {
					// check which ip is null and fill it with
					// the current token
					if (ip1 == "") {
						ip1 = ipTokenizer.nextToken();
					} else if (ip2 == "") {
						ip2 = ipTokenizer.nextToken();
					} else if (ip3 == "") {
						ip3 = ipTokenizer.nextToken();
					} else if (ip4 == "") {
						ip4 = ipTokenizer.nextToken();

						// break if to many tokens
					} else {
						invalid = true;
						break;
					}
				}

				// check if the length of the first token is 3, second 2, third
				// 2, fourth 3 and if invalid flag is false
				if (ip1.length() == 3 && ip2.length() == 2 && ip3.length() == 2 && ip4.length() == 3
						&& invalid == false) {

					// notify the user that the parse was successful
					// and output the data
					tbxParseMessage.setText("Parse was successful!");
					tbxParse1.setText(ip1);
					tbxParse2.setText(ip2);
					tbxParse3.setText(ip3);
					tbxParse4.setText(ip4);

				} else {

					// notify the user that there was an error
					tbxParseMessage.setText("Parse error!");
					tbxParse1.setText("---");
					tbxParse2.setText("Please follow correct format for IP:");
					tbxParse3.setText("###.##.##.###");
					tbxParse4.setText("---");
				}

				// user has the ID radio button selected
			} else if (rbnId.isSelected()) {

				// create a tokenizer that delimits by dashes
				StringTokenizer idTokenizer = new StringTokenizer(tbxInput.getText(), "-");

				// flag to mark if format is invalid
				boolean invalid = false;

				// strings to hold the 3 different IDs
				String id1 = "";
				String id2 = "";
				String id3 = "";

				// loop through the id tokenizer
				while (idTokenizer.hasMoreTokens()) {

					// check which id is null and fill it with
					// the current token
					if (id1 == "") {
						id1 = idTokenizer.nextToken();
					} else if (id2 == "") {
						id2 = idTokenizer.nextToken();
					} else if (id3 == "") {
						id3 = idTokenizer.nextToken();

						// break if to many tokens
					} else {
						invalid = true;
						break;
					}

				}

				// check if the length of the first token is 3, second 3,
				// third 4, and if invalid flag is false
				if (id1.length() == 3 && id2.length() == 3 && id3.length() == 4 && invalid == false) {

					// notify the user that the parse was successful
					// and output the data
					tbxParseMessage.setText("Parse was successful!");
					tbxParse1.setText(id1);
					tbxParse2.setText(id2);
					tbxParse3.setText(id3);
					tbxParse4.setText("---");

				} else {

					// notify the user that there was an error
					tbxParseMessage.setText("Parse error!");
					tbxParse1.setText("---");
					tbxParse2.setText("Please follow correct format for ID:");
					tbxParse3.setText("###-###-####");
					tbxParse4.setText("---");
				}

				// check if user has the email radio button selected
			} else if (rbnEmail.isSelected()) {

				// create a tokenizer that delimits by at symbol and period
				StringTokenizer emailTokenizer = new StringTokenizer(tbxInput.getText(), "@.");

				// flag to mark if format is invalid
				boolean invalid = false;

				// strings to hold the 3 different emails
				String email1 = "";
				String email2 = "";
				String email3 = "";

				// loop through the email tokenizer
				while (emailTokenizer.hasMoreTokens()) {

					// check which email string is null and
					// fill it with the current token
					if (email1 == "") {
						email1 = emailTokenizer.nextToken();
					} else if (email2 == "") {
						email2 = emailTokenizer.nextToken();
					} else if (email3 == "") {
						email3 = emailTokenizer.nextToken();

						// break if to many tokens
					} else {
						invalid = true;
						break;
					}
				}

				if (!email1.equals("") && !email2.equals("") && !email3.equals("") && invalid == false) {
					// notify the user that the parse was successful
					// and output the data
					tbxParseMessage.setText("Parse was successful!");
					tbxParse1.setText(email1);
					tbxParse2.setText(email2);
					tbxParse3.setText(email3);
					tbxParse4.setText("---");

				} else {
					// notify user that they messed up
					tbxParseMessage.setText("Parse error!");
					tbxParse1.setText("---");
					tbxParse2.setText("Please follow correct format for Email:");
					tbxParse3.setText("name@provider.type");
					tbxParse4.setText("---");
				}

			}
		}
	}
}
