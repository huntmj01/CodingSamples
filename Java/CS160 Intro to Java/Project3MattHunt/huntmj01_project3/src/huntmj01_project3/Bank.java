/*
    * Matthew Hunt
    * CS16000 Fall 2015
    * Project 3: Currency Exchange
    *
    * Description: The bank class retrieves a filename that stores the bank
    * information. It contains methods to check if the bank supports a currency,
    * to retreive the currency rate, and to create a quote for the user.
 */

package huntmj01_project3;

// to import the bank file
import java.io.File;
// in case bank files are not found, the main method can throw the exception
import java.io.FileNotFoundException;
// to scan the bank file
import java.util.Scanner;
// to notify the user if the file was not found
import javax.swing.JOptionPane;

public class Bank {

    /* Five private data fields 
	 * The name of the bank 
	 * The commission rate 
	 * Three fields for the three currencies exchanged by the bank
     */
    private final String bankName;
    private final double commissionRate;
    private final Currency c1;
    private final Currency c2;
    private final Currency c3;

    // constructor that takes a file name (String) as an argument
    public Bank(String filename) throws FileNotFoundException {

        // open the file
        File file = new File(filename);

        // file does not exist
        if (!file.exists()) {
            // notify the user
            JOptionPane.showMessageDialog(null, "File not found.");
        }

        // create a scanner for input file
        Scanner inputFile = new Scanner(file);

        // retrieve bank name and commission rate from the file and then 
        // assign private members
        bankName = inputFile.nextLine();
        commissionRate = inputFile.nextDouble();

        // retrieve currency name and rates from the file
        String currencyName1 = inputFile.next();
        double currencyRate1 = inputFile.nextDouble();
        String currencyName2 = inputFile.next();
        double currencyRate2 = inputFile.nextDouble();
        String currencyName3 = inputFile.next();
        double currencyRate3 = inputFile.nextDouble();

        // initialize the currencies
        c1 = new Currency(currencyName1, currencyRate1);
        c2 = new Currency(currencyName2, currencyRate2);
        c3 = new Currency(currencyName3, currencyRate3);

        // close the scanner 
        inputFile.close();

    }

    /* 
	 * A method that takes a currency code (String) as its only argument.  
	 * It compares the currency code to the three different currencies the 
	 * bank has and returns true if the bank has that currency.  
	 * Otherwise it returns false.
         *
	 * @param String currencyCode, a 3 letter string that is used to 
	 * compare to the banks currencies.
	 * 
	 * @return Boolean, whether or not the bank has a currency with 
	 * the same currency code.
     */
    public boolean supportCurrency(String currencyCode) {

        return currencyCode.toUpperCase().equals(c1.getCurrencyCode())
                || currencyCode.toUpperCase().equals(c2.getCurrencyCode())
                || currencyCode.toUpperCase().equals(c3.getCurrencyCode());
    }

    /* 
	 * A method that takes a currency code (String) as its only argument.  
         * It compares the currency 
	 * code to the three different currencies the bank has and returns that 
	 * currencies exchange rate if the bank has that currency. 
         * Otherwise it returns -1.0. 
	 * 
	 * @param String currencyCode, a 3 letter string that is used to 
	 * compare to the banks currencies.
	 * 
	 * @return double, currencies exchange rate. If currency is not found 
         * then -1.0 is returned.
	 * 
     */
    public double getRate(String currencyCode) {

        if (currencyCode.toUpperCase().equals(c1.getCurrencyCode())) {
            return c1.getExchangeRate();

        } else if (currencyCode.toUpperCase().equals(c2.getCurrencyCode())) {
            return c2.getExchangeRate();

        } else if (currencyCode.toUpperCase().equals(c3.getCurrencyCode())) {
            return c3.getExchangeRate();

        } else {
            return -1.0;
        }

    }

    public String getBankName() {
        return bankName;
    }

    /* 
	 * A method that takes the amount the user wants to sell and
	 * a currency code (String) as its arguments.  It uses these 
	 * to calculate the rate, base, and bank commission. Finally,
	 * it returns a quote.  
	 * 
	 * @param double sellingAmt, the amount of foreign currency
	 * the user wants to sell that is used to calculate the base
	 * 
	 * @param String currencyCode, a 3 letter string that is used 
	 * to retrieve the currency rate.
	 * 
	 * @return Quote q, q is a Quote object that can latter be 
	 * used to call toString()
	 * 
     */
    public Quote quoteSell(double sellingAmt, String currencyCode) {

        // retrieve the foreign currency rate
        double rate = getRate(currencyCode);

        // calculate the gross amount the user will receive
        // by dividing the amount they wish to sell by
        // the foreign currency rate
        double base = sellingAmt / rate;

        // calculate the bank commission by multiplying 
        // the gross amount (base) by the bank commission
        // rate
        double commission = base * commissionRate;

        // calculate the net amount the user receives 
        // buy subtracting the base from the bank
        // commission
        double net = base - commission;

        // create a quote object with the previous data
        Quote q = new Quote(bankName, "usd", sellingAmt,
                currencyCode, net,
                commissionRate * 100, commission);

        //return the new quote object
        return q;

    }

    /* 
	 * A method that takes the amount the user wants to buy and
	 * a currency code (String) as its arguments.  It uses these 
	 * to calculate the rate, amount owed, and bank commission. Finally,
	 * it returns a quote.  
	 * 
	 * @param double buyingAmt, the amount of foreign currency
	 * the user wants to buy that is used to calculate the 
	 * amount the user owes.
	 * 
	 * @param String currencyCode, a 3 letter string that is used 
	 * to retrieve the currency rate.
	 * 
	 * @return Quote q, q is a Quote object that can latter be 
	 * used to call toString().
	 * 
     */
    public Quote quoteBuy(double buyingAmt, String currencyCode) {

        // retrieve the foreign currency rate
        double rate = getRate(currencyCode);

        // the number of US dollars the customer will pay is the amount
        // divided by the rate times 1 minus the commission rate
        double dollarsOwed = buyingAmt / (rate * (1 - commissionRate));

        // the commission is dollars owed times the commission rate
        double commission = dollarsOwed * commissionRate;

        // create a quote object with the previous data
        Quote qt = new Quote(bankName, currencyCode, dollarsOwed,
                "usd", buyingAmt,
                commissionRate * 100, commission);

        // return the new quote
        return qt;
    }
}
