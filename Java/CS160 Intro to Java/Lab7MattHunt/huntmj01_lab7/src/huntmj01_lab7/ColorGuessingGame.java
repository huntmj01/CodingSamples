package huntmj01_lab7;

//JOptionPane
import javax.swing.*;
//access the Color class
import java.awt.Color;
//access the Random class
import java.util.Random;

public class ColorGuessingGame {

	// used to store the color for later comparisons
	public static String globalColor;

	public static void main(String[] args) {

		// generate random to create a random number later
		Random rand = new Random();

		// ask user if they want to play
		int confirm = JOptionPane.showConfirmDialog(null, "Would you like to play the color guessing game?", "YES/NO",
				JOptionPane.YES_NO_OPTION);

		// user chose yes
		if (confirm == JOptionPane.YES_OPTION) {

			//loop until the user no longer wants to play
			while (confirm == JOptionPane.YES_OPTION) {
				
				//create the random number (0-5)
				int randomNum = rand.nextInt(6);
				
				// pass the randomNum into chooseColor() and set the color to colorPicked
				Color colorPicked = chooseColor(randomNum);
				
				// pass colorPicked into guessColor() to determine who won
				guessColor(colorPicked);
				
				// ask user if they want to play again
				confirm = JOptionPane.showConfirmDialog(null, "Would you like to play the color guessing game again?",
						"YES/NO", JOptionPane.YES_NO_OPTION);

			}

			//end the program
			System.exit(0);

		//user chose no
		} else {

			//end the program
			System.exit(0);

		}
	}

	/* 
	 * A method that trades a number for a color.
	 * 
	 * @param int colorNumber, a number between 0-5 that will be used to determine 
	 * which color is returned 
	 * 
	 * @return Color colorToReturn, a Color that is blue, yellow, red, green, 
	 * orange, or cyan based on colorNumber
	 * 
	 */
	public static Color chooseColor(int colorNumber) {

		// color variable that will be returned
		Color colorToReturn = null;

		// switch statement to set colorToReturn to the color based on whether colorNumber is 0-5

		
		switch (colorNumber) {
		case 0:
			colorToReturn = Color.BLUE;
			globalColor = "blue";
			break;
		case 1:
			colorToReturn = Color.YELLOW;
			globalColor = "yellow";
			break;
		case 2:
			colorToReturn = Color.RED;
			globalColor = "red";
			break;
		case 3:
			colorToReturn = Color.GREEN;
			globalColor = "green";
			break;
		case 4:
			colorToReturn = Color.ORANGE;
			globalColor = "orange";
			break;
		case 5:
			colorToReturn = Color.CYAN;
			globalColor = "cyan";
			break;
		default:
			//if any other number is found end the program
			System.out.println("Error while choosing a random color.");
			System.exit(0);
			break;
		}

		//return color
		return colorToReturn;

	}

	/*
	 * A method that creates a JFrame and sets it to the color of the random color.
	 * 
	 * @param Color colorArg, any valid Color. used to set the color of the JFrame.
	 * 
	 */
	
	public static void showColor(Color colorArg) {

		//bellow code is given
		
		JFrame frame = new JFrame("Guess this color");
		frame.setSize(200, 200);
		frame.setLocation(300, 300);
		JPanel panel = new JPanel();
		panel.setBackground(colorArg);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	/* 
	 * A method that passes colorArg into showColor(), retrieves the users guess
	 * from a JOptionPane, and finally passes the userGuess into confirmGuess().
	 * 
	 * @param Color colorArg, a valid Color that is to be passed into showColor();
	 * 
	 */
	
	public static void guessColor(Color colorArg) {
		
		//pass colorArg into showColor()
		showColor(colorArg);

		//retrieve userGuess
		String userGuess = (JOptionPane.showInputDialog("Guess one of the following colors." + "\nBlue" + "\nYellow"
				+ "\nRed" + "\nGreen" + "\nOrange" + "\nCyan"));

		//pass userGuess into confirmGuess()
		confirmGuess(userGuess);

	}

	/* 
	 * A method that compares the globalColor to the userGuess and then tells the user
	 * if they won or lost.
	 * 
	 * @param String userGuess, a string that will be compared to globalColor to 
	 * determine whether the user has won or lost
	 * 
	 */
	
	public static void confirmGuess(String guess) {

		//for debug purposes
		System.out.println("User guess is " + guess + " and the correct answer is " + globalColor);

		//userGuess equals globalColor
		if ((guess.toLowerCase()).equals(globalColor.toLowerCase())) {
			//notify the user that they have won
			JOptionPane.showMessageDialog(null, "Your guess is correct!!!");
			
		//userGuess does not equal globalColor
		} else {
			//notify the user that they have lost
			JOptionPane.showMessageDialog(null, "Your guess is incorrect. Try again.");
		}
	}

}
