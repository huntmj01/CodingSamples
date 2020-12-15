/*
    * Matthew Hunt
    * CS16000 Fall 2015
    * Project 3: Currency Exchange
    *
    * Description: The Currency Exchange class contains the main method.  It
    * retrieves two text files and passes them into the bank class.  The user is
    * asked whether they would like to buy or sell foreign currency. In both
    * cases the, user is asked for the currency string of the foreign currency
    * they wish to exchange.  Depending on whether they wish to buy or sell and
    * if which banks accept the currency, the foreign currency amount is passed
    * to the bank class to retrieve the quote.
 */

package huntmj01_project3;

// in case bank files are not found, the main method can throw the exception
import java.io.FileNotFoundException;
// to retrieve user input
import java.util.Scanner;
// to ask the user if they want to make another transaction
import javax.swing.JOptionPane;

public class CurrencyExchange {

	public static void main(String[] args) throws FileNotFoundException {

		// flag to check if user wishes to make another transaction
		boolean userWantsToMakeTransaction = true;

		// scanner to retrieve user input
		Scanner scan = new Scanner(System.in);

		// loop until user no longer wishes to make a transaction
		while (userWantsToMakeTransaction) {

			// create two bank objects, one for each file
			Bank bank1 = new Bank("bank1.txt");
			Bank bank2 = new Bank("bank2.txt");

			// flag to check if input is valid
			boolean invalidInput = true;

			// string that holds user input
			String buyOrSell = "";

			// ask user if they want to buy or sell
			System.out.print("Do you wish to buy or sell your currency?: ");

			// loop until input is valid
			while (invalidInput) {

				// retrieve from the user whether they want to buy or sell
				buyOrSell = scan.nextLine();

				// check if the input is valid. If it isn't print an error
				// message and continue the loop.
				if (buyOrSell.toLowerCase().equals("buy") || buyOrSell.toLowerCase().equals("sell")) {

					invalidInput = false;
				} else {
					// let user know they have failed
					System.out.println("Invalid input.");
					// ask user if they want to buy or sell
					System.out.print("Do you wish to buy or sell your " + "currency?: ");
					continue;
				}
			}

			// flag to check if currency input is valid
			boolean invalidCurrency = true;

			// flag to check if bank 1 supports the currency
			boolean bank1SupportsCurrency = false;

			// flag to check if bank 2 supports currency
			boolean bank2SupportsCurrency = false;

			// string that holds user input
			String currencyCode = "";

			// loop until currency input is valid
			while (invalidCurrency) {

				// retrieve from the user for the currency
				System.out.print("Please enter 3 letter currency string: ");
				currencyCode = scan.nextLine();

				// check if bank 1 supports currency
				// if so notify user and set flags accordingly
				if (bank1.supportCurrency(currencyCode)) {
					bank1SupportsCurrency = true;
					System.out.println(bank1.getBankName() + " supports " + currencyCode + ".");
					invalidCurrency = false;
				}

				// check if bank 1 supports currency
				// if so notify user and set flags accordingly
				if (bank2.supportCurrency(currencyCode)) {
					bank2SupportsCurrency = true;
					System.out.println(bank2.getBankName() + " supports " + currencyCode + ".");
					invalidCurrency = false;
				}

				// if neither bank supports the currency notify the user
				// and then continue the loop
				if (bank1SupportsCurrency == false && bank2SupportsCurrency == false) {
					System.out.println("Invalid currency.");
					continue;
				}
			}

			// retrieve the amount of foreign currency from the user
			System.out.print("Enter the amount of " + currencyCode + " you would like to exchange: ");

			double foreignCurrency = scan.nextDouble();

			// check to see if bank 1 supports the currency
			if (bank1SupportsCurrency) {

				// check to see if the user wants to buy or sell
				if (buyOrSell.equals("buy")) {

					// retrieve the quote and then print it to the console
					Quote q = bank1.quoteBuy(foreignCurrency, currencyCode);
					System.out.println(q.toString());

				} else if (buyOrSell.equals("sell")) {

					// retrieve the quote and then print it to the console
					Quote q = bank1.quoteSell(foreignCurrency, currencyCode);
					System.out.println(q.toString());

				}
			}

			// check to see if bank 2 supports the currency
			if (bank2SupportsCurrency) {

				// check to see if the user wants to buy or sell
				if (buyOrSell.equals("buy")) {

					// retrieve the quote and then print it to the console
					Quote q = bank2.quoteBuy(foreignCurrency, currencyCode);
					System.out.println(q.toString());

				} else {

					// retrieve the quote and then print it to the console
					Quote q = bank2.quoteSell(foreignCurrency, currencyCode);
					System.out.println(q.toString());

				}
			}

			// ask user if they would like to make another transaction
			int reply = JOptionPane.showConfirmDialog(null, "Would you like to make another transaction?", "Yes/No",
					JOptionPane.YES_NO_OPTION);

			// if user answers no then exit then set flag to false to end loop
			if (reply == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Goodbye!");
				userWantsToMakeTransaction = false;
			}

		}
		// close the scanner
		scan.close();
	}
}
