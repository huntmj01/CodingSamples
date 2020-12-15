package huntmj01_lab4;

import javax.swing.JOptionPane;

public class InputValidation {

	public static void main(String[] args) {
		
		//string to hold the word ostrich
		String ostrich = "ostrich";
		
		//ask user for first passphrase
		String passphrase = JOptionPane.showInputDialog(null,
				"Enter your word, completley legitimate human",
				"Legitimate Human Program", 
				JOptionPane.QUESTION_MESSAGE);
		
		
		//validate passphrase to make sure it is not null or empty
		if (passphrase == null || passphrase.equals("")){
			JOptionPane.showMessageDialog(null, "Passphrase was null or empty", "That's a null pointer ghost rider.",
					JOptionPane.ERROR_MESSAGE, null);
			//exit the program
			System.exit(0);
		}
		
		
		/*
		if (passphrase == null){
			JOptionPane.showMessageDialog(null, "Passphrase was null", "That's a null pointer ghost rider.",
					JOptionPane.ERROR_MESSAGE, null);
			System.exit(0);
		}
		
		if (passphrase.equals("")){
			JOptionPane.showMessageDialog(null, "Passphrase was empty", "That's a null pointer ghost rider.",
					JOptionPane.ERROR_MESSAGE, null);
			System.exit(0);
		}
		*/
		
		
		//ask user for second passphrase 
		String passphrase2 = JOptionPane.showInputDialog(null,
				"Enter your word, completley legitimate human",
				"Legitimate Human Program", 
				JOptionPane.QUESTION_MESSAGE);
		
		
		//validate second passphrase to make sure it is not empty or null
		if (passphrase2 == null || passphrase2.equals("")){
			JOptionPane.showMessageDialog(null, "2nd Passphrase was null or empty", 
					"That's a null pointer ghost rider.",
					JOptionPane.ERROR_MESSAGE, null);
			//exit the program
			System.exit(0);
			
		//both passphrases equal eachother
		}else if (passphrase.equals(passphrase2)){
			JOptionPane.showMessageDialog(null, "2nd passphrase is equal to 1st passphrase", 
					"Equality",
					JOptionPane.INFORMATION_MESSAGE, null);
			
		//passphrases do not equal eachother
		}else {
			JOptionPane.showMessageDialog(null, "2nd passphrase is not equal to 1st passphrase", 
					"Non-Equality",
					JOptionPane.INFORMATION_MESSAGE, null);
		}
		
		
		//check to see if 1st passphrase equals banana bread and  
		//2nd passphrase length is greater than ostrich length
		//is a spy
		if (passphrase.equals("Banana Bread") && passphrase2.length() > ostrich.length()){
			JOptionPane.showMessageDialog(null, "Spy has been validated. Stand by to be debriefed.", 
					"Success!",
					JOptionPane.INFORMATION_MESSAGE, null);
			
		//is not a spy
		}else{
			//first passpharase length is greater than second passphrase length
			if (passphrase.length() > passphrase2.length()){
				JOptionPane.showMessageDialog(null, "2nd passphrase length is less than 1st passphrase", 
						"passphrase.length() > passphrase2.length()",
						JOptionPane.INFORMATION_MESSAGE, null);
				
			//first passpharase length is less than second passphrase length
			}else{
				JOptionPane.showMessageDialog(null, "2nd passphrase length is greater than 1st passphrase", 
						"passphrase.length() < passphrase2.length()",
						JOptionPane.INFORMATION_MESSAGE, null);
			}
		}
	}
}
