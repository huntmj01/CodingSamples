package lab5A;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lab5ADriver {

	public static void main(String[] args) throws FileNotFoundException {
		
		// create a scanner to read the StringTest file
		File stringTestFile = new File("StringTest.txt");
		Scanner stringTestScanner = new Scanner(stringTestFile);
		
		// create a string builder to build the string from
		// the StringTest File
		StringBuilder stringBuilder = new StringBuilder();
		
		// loop through the StringTest file and 
		// append it to the string builder
		while (stringTestScanner.hasNext()){
			String temp = stringTestScanner.nextLine();
			stringBuilder.append(temp + " ");
		}
		
		// create the string tokenizers for each 
		// token we wish to know the count of
		StringTokenizer sentenceTokenizer = new StringTokenizer(stringBuilder.toString(), ".");
		StringTokenizer wordTokenizer = new StringTokenizer(stringBuilder.toString(), " -");
		StringTokenizer aTokenizer = new StringTokenizer(stringBuilder.toString(), "a");
		StringTokenizer eTokenizer = new StringTokenizer(stringBuilder.toString(), "e");
		StringTokenizer eeTokenizer = new StringTokenizer(stringBuilder.toString(), "e", true);
		StringTokenizer iTokenizer = new StringTokenizer(stringBuilder.toString(), "i");
		StringTokenizer oTokenizer = new StringTokenizer(stringBuilder.toString(), "o");
		StringTokenizer ooTokenizer = new StringTokenizer(stringBuilder.toString(), "o", true);
		StringTokenizer uTokenizer = new StringTokenizer(stringBuilder.toString(), "u");
	
		// print out the amount of tokens for each
		System.out.println("Total number of sentences: " + sentenceTokenizer.countTokens());
		System.out.println("Total number of words: " +  wordTokenizer.countTokens());
		System.out.println("The Frequency of char a: " + aTokenizer.countTokens());
		System.out.println("The Frequency of char e: " + (eeTokenizer.countTokens() - eTokenizer.countTokens()));
		System.out.println("The Frequency of char i: " + iTokenizer.countTokens());
		System.out.println("The Frequency of char o: " + (ooTokenizer.countTokens() - oTokenizer.countTokens()));
		System.out.println("The Frequency of char u: " + uTokenizer.countTokens());
		
		// close the scanner
		stringTestScanner.close();
	}

}
