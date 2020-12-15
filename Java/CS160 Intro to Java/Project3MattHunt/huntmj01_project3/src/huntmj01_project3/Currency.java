/*
    * Matthew Hunt
    * CS16000 Fall 2015
    * Project 3: Currency Exchange
    *
    * Description: The currency class holds the currency code and exchange rate
    * of a particular currency.
 */

package huntmj01_project3;

public class Currency {

    // Two private data fields, one to hold the currency code and one to hold the
    //exchange rate. 
    private String currencyCode;
    private double exchangeRate;

    // constructor that takes two arguments: the currency code and exchange rate
    // assigns the private members from the values of the arguments
    public Currency(String currencyCode, double exchangeRate) {
        this.currencyCode = currencyCode.toUpperCase();
        this.exchangeRate = exchangeRate;
    }

    // getters for each data field
    public String getCurrencyCode() {
        return currencyCode;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

}
