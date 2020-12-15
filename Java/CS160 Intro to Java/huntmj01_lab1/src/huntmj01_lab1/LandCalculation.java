/* Error Reporting
a) Delete the keyword void from the main method definition
	Return type is missing
	
b) Change 'main' to 'theBeginning'
	Error: Main method not found in class huntmj01_lab1.LandCalculation, please define the main method as:
   public static void main(String[] args)
   
c) Change the data type of number from int to Integer
	No Error, but technically should be int
	
d) Change 'args' in the main method definition to anything you desire
	No Error, but should technically be args

e) Change all instances of ( ) to { }
	lots of Syntax error on token "{", ( expected and Syntax error on token "}", ) expected errors

f) Replace a semi-colon, ';', with a colon, ':'
	Syntax error on token ":", ; expected

g) Put any two statements on the same line
	No error, but code is harder to read
	
h) Change println to printf
	No error, but everything is printed on the same line.
	
 */


package huntmj01_lab1;

import java.text.DecimalFormat;

/*The purpose of this class is to print the area of land and then print
 the acres which is the area divided by the conversion factor.  The 
 Decimal Formatter "df" rounds acres to 5 decimal places*/

public class LandCalculation {

	public static void main(String[] args) {
		
		int area = 534521;
		double acres;
		final double CONVERSION = 43560;
		acres=area/CONVERSION;
		DecimalFormat df = new DecimalFormat("##.#####");
		
		System.out.println("The area of the land in square feet is: " + area + " square feet.");
		System.out.println("The area of the land in acres is "+ df.format(acres) + " acres.");

	}

}
