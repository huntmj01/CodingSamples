/*
    * Matthew Hunt
    * CS16000 Fall 2015
    * Project 3: Currency Exchange
    *
    * Description: The Quote class retrieves inofrmation about the currency
    * exchange and compiles that information into a string for the user.
 */

package huntmj01_project3;

// to round currency 
import java.text.DecimalFormat;

public class Quote {

    /* Seven private data fields
	 * The name of the bank issuing the quote
	 * The currency code of the currency given to the bank
	 * the currency amount given to the bank
	 * the currency code of the currency received from the bank
	 * the currency amount the user receives from the bank
	 * the commission rate charged by the bank
	 * the dollar amount of the commission
	 * a decimal format object for formating currencies
     */
    private final String bankName;
    private final String codeToBank;
    private final double amtToBank;
    private final String codeFromBank;
    private final double amtFromBank;
    private final double commissionRate;
    private final double commission;
    private final DecimalFormat df;

    /* Constructor that takes 7 arguments that correspond 
	 * to the first 7 data fields.  Constructor also sets 
	 * those fields from the values of the arguments.
	 * Finally, it creates an object and assigns it
	 * to the DecimalFormat.
     */
    public Quote(String nameOfBank, String codeToBank, double amtToBank,
            String codeFromBank, double amtFromBank, double commissionRate,
            double commission) {

        this.bankName = nameOfBank;
        this.codeToBank = codeToBank;
        this.amtToBank = amtToBank;
        this.codeFromBank = codeFromBank;
        this.amtFromBank = amtFromBank;
        this.commissionRate = commissionRate;
        this.commission = commission;

        df = new DecimalFormat("##.##");

    }

    /* 
	 * A method that takes no arguments.  It returns a 
	 * string with a message to the user.
	 * 
	 * @return String, the message to the user
	 * 
     */
    @Override
    public String toString() {

        return bankName
                + " will give you "
                + df.format(amtFromBank) + " "
                + codeToBank.toUpperCase()
                + " for " + df.format(amtToBank) + " "
                + codeFromBank.toUpperCase()
                + ", after collecting a comission of "
                + df.format(commission) + " "
                + codeFromBank.toUpperCase()
                + " (%" + df.format(commissionRate)
                + ").";

    }
};
