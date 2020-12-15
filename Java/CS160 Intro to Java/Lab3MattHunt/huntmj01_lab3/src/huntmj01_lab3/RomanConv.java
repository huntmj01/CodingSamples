package huntmj01_lab3;

import javax.swing.JOptionPane;

public class RomanConv {

	public static void main(String[] args) {
		
		//variables
		
		//to hold the 4 possible chars from the input dialog
		char char0 = '0';
		char char1 = '0';
		char char2 = '0';
		char char3 = '0';
		char char4 = '0';
		
		//integer to hold the number
		int number = 0;
		
		//Ask the user for a roman numeral
		String input = JOptionPane.showInputDialog(null, 
				"Enter a capitalized Roman Numeral between\n I and VIII inclusive. (Example VII)"
				,"Input", JOptionPane.QUESTION_MESSAGE);
		
		//a try catch is needed in case not all 4 chars are available
		//for example, if the user enters 'V' the char 1,2,3 will throw an exception
		try{
			
			char0 = input.charAt(0);
			char1 = input.charAt(1);
			char2 = input.charAt(2);
			char3 = input.charAt(3);
			char4 = input.charAt(4);
			
		}catch (Exception e){
			
		}
		
		//first char is I
		if (char0 == 'I'){
			//second char is I
			if (char1 =='I'){
				//third char is I
				if (char2 == 'I'){
					//The roman numeral entered is III
					number = 3;
				//no third char
				}else if (char2 == '0') {
					//The roman numeral entered is II
					number = 2;
				}
			//second char is V
			}else if (char1 == 'V'){
				//The roman numeral entered is VI
				number = 4;
			//no second char
			}else if (char1 == '0'){
				//The roman numeral entered is I
				number = 1;
			}
		//first char is V	
		}else if (char0 == 'V'){
			//second char is I
			if (char1 == 'I'){
				//third char is I
				if (char2 == 'I'){
					//fourth char is I
					if (char3 == 'I'){
						//The roman numeral entered is VIII
						number = 8;
					//no fourth char
					}else if (char3 == '0'){
						//The roman numeral entered is VII
						number = 7;
					}
				//no third char
				}else if (char2 == '0'){
					//The roman numeral entered is VI
					number = 6;
				}
			//no second char
			} else if (char1 == '0') {
				//The roman numeral entered is V
				number = 5;
			}
		//user enters something else	
		}else{
			number = 0;
		}
		
		//in case there is a fifth character in the input string
		if (!(char4 == '0')){
			number = 0;
		}
	
		//invalid input
		if (number == 0){
			//let user know they are a dumb dumb
			JOptionPane.showMessageDialog(null, "Invalid input: " + input, "Warning",
			        JOptionPane.WARNING_MESSAGE);
		//valid input
		}else{
			//output roman numeral conversion
			JOptionPane.showMessageDialog(null, "Roman Numeral " + input + " is equal to " + number + ".", "Info",
			        JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
