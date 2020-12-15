package lab7;

public class RecursiveDefinitions {

	// In order to make this lab simple, 
	// all of the methods are static
	
	/**
	 * 
	 * sumDownBy3() uses recursion to 
	 * calculate the sum of an int 
	 * recursively subtracted by 3
	 * 
	 * Example: n = 10, 10 + 7 + 4 + 1
	 * 
	 * @param n, the int to calculate the
	 * sumDownBy3
	 * 
	 * @return sumDownBy3
	 * 
	 */
	public static int sumDownBy3(int n) {
		// base cases
		
		// n is equal to zero or less than 0
		if (n <= 0) {
			// 
			return 0;
		
		// n is equal to one
		} else if (n == 1) {
			// 
			return 1;
			
		// general case
		} else {
			// add n to sumDownBy(n-3) recursively
			return n + sumDownBy3(n - 3);
		}
	}

	/**
	 * 
	 * harmonicSum() uses recursion to find
	 * the harmonic sum of an int
	 * 
	 * Example: n = 3, 1/3 + 1/2 + 1/1 = 1.8333...
	 * 
	 * @param n, the int to find the
	 * harmonic sum of
	 * 
	 * @return harmonicSum
	 */
	public static double harmonicSum(int n) {
		
		// base case
		if (n == 1) {
			return 1.0;
			
		// general case
		} else {
			// add 1/n to the harmonicSum(n-1) recursively
			return (1.0 / n) + harmonicSum(n - 1);
		}
	}
	
	/**
	 * 
	 * geometricSum() uses recursion to find
	 * the geometric sum of an int
	 * 
	 * Example: n = 3, 1/1 + 1/2 + 1/4 + 1/8 = 
	 * 
	 * @param n, the int to find the
	 * geometric sum of
	 * 
	 * @return geometricSum
	 */
	public static double geometricSum(int n) {
		// base case
		if (n == 0) {
			return 1;
			
		// general case
		} else {
			// add 1/2^n + geometricSum(n-1) recursively
			return 1/(Math.pow(2, n)) + geometricSum(n-1);
		}
	}

	/**
	 * 
	 * additibeMult() uses recursion to find j * i
	 * using addition
	 * 
	 * @param i, int that is to be multiplied by j
	 * @param j, int that is to be multiplied by i
	 * 
	 * @return the multiple of i and j
	 * 
	 */
	public static int additiveMult(int i, int j) {
		// base case
		if (j == 0) {
			return 0;
			
		// general case
		} else {
			// add i to additiveMult(i, j-1) recursively
			return i + additiveMult(i, j - 1);
		}
	}

	/**
	 * 
	 * loanLength() uses recursion to find the length of 
	 * the loan in months give the loan amount, annual
	 * intrust rate, and monthly payment
	 * 
	 * @param loanAmt, the total of the loan
	 * @param annualIntrestRate, the annual intrust rate of the loan
	 * @param monthlyPayment, the monthly payment of the loan
	 * 
	 * @return length of loan in months
	 */
	public static int loanLength(double loanAmt, double annualIntrestRate, double monthlyPayment) {
		
		// base case
		if (loanAmt + loanAmt*annualIntrestRate < monthlyPayment) {
			return 0;
			
		// general case
		} else {
			// find the new loan amount by subtracting the current loan amount by the monthly
			// payment and then adding that to (loan amount minus monthly payment) * 
			// the annual intrust rate
			double newAmt = (loanAmt - monthlyPayment) + ((loanAmt - monthlyPayment) * annualIntrestRate);
			// add 1 to the loanLength(newAmt, annualIntrestRate, monthlyPayment) recursively
			return 1 + loanLength(newAmt, annualIntrestRate, monthlyPayment);
		}
	}

}
