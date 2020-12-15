package huntmj01_lab2;

import java.util.Scanner;

public class StringScan {

	public static void main(String[] args) {
		//declare scanner
		Scanner keyboard = new Scanner(System.in);
		
		//Retrieve name from user
		System.out.println("Please enter your name: ");
		String name = keyboard.nextLine();
		
		//print name back to console
		System.out.println("Your name is " + name);
		
		//Retrieve favorite number from user
		System.out.println("Please enter your favorite number: ");
		int favNum = keyboard.nextInt();
		
		//print name length to console
		System.out.println("The length of your name is " + name.length());
		
		//print first and last characters of name
		System.out.println("The first character in your name is " + name.charAt(0));
		System.out.println("The last character in your name is " + name.charAt(name.length()-1));
		
		//print character at index 5
		System.out.println("The last character in your name is " + name.charAt(5));
		
		//print name in upper case
		System.out.println("Your name in upper case is " + name.toUpperCase());
		
		//a little bit of math
		int eq = (name.length() + 2)*favNum;
		System.out.println("The equations result is " + eq);
		
		keyboard.close();
	}

}
