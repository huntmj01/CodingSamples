/*
 * Matthew Hunt
 * CS 16000 Fall 2015
 * Project 1: Health Care Calculator
 * 
 * Description: The Health Care Calculator lets a user choose from two plans.  Plan A or Plan B.  Both have
 * a different premium deductible and coinsurance.  The user can also chose to input their own Plan by entering
 * their own premium deductible and coinsurance.  After the plan has been determined, the user enters their
 * total cost of their medical bills for the year.  The computer uses algorithums to calculate and display the users
 * premiums other costs and total costs.
 */

package huntmj01_project1;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class HealthCareCalculator {
	
	public static void main(String args[]){
		
		//variables
		double premium = 0.0;		//how much you pay for a year of insurance
		double deductible = 0.0;	//how much you will have to pay for your doctors bill before insurance will start paying anything
		double coinsurance = 0.0;	//what percentage you will have to pay of your medical bills after you've reached your deductible
		double bills = 0.0;			//the total cost of your medical bills
		
		//plan A constants
		final double PLAN_A_PREMIUM = 5000.00;		//Premium of Plan A is 5000
		final double PLAN_A_DEDUCTIBLE = 1000.00;	//Deductible of Plan A is 1000
		final double PLAN_A_COINSURANCE = 0.20;		//Coinsurance of Plan A is 20%
		
		//plan B constants
		final double PLAN_B_PREMIUM = 3000.00;		//Premium of Plan B is 3000
		final double PLAN_B_DEDUCTIBLE = 4000.00;		//Deductible of Plan B is 4000
		final double PLAN_B_COINSURANCE = 0.25;		//Coinsurance of Plan B is 25%
		
		//scanner for console input
		Scanner keyboard = new Scanner(System.in);
		//ask users which health care plan the wish to select and put in string
		System.out.println("Enter the name of the health care plan: ");
		String planName = keyboard.nextLine();
		
		//search cases of planName
		switch (planName)
		{
			//planName is PlanA
			case "PlanA":
				
				//set premium deductible and coinsurance variables to Plan A's premium deductible and coinsurance amounts
				premium = PLAN_A_PREMIUM;
				deductible = PLAN_A_DEDUCTIBLE;
				coinsurance = PLAN_A_COINSURANCE;
				
				break;
				
			//planName is planA
			case "planA":
				
				//set premium deductible and coinsurance variables to Plan A's premium deductible and coinsurance amounts
				premium = PLAN_A_PREMIUM;
				deductible = PLAN_A_DEDUCTIBLE;
				coinsurance = PLAN_A_COINSURANCE;
				
				break;
				
			//planName is PlanB
			case "PlanB":
				
				//set premium deductible and coinsurance variables to Plan B's premium deductible and coinsurance amounts
				premium = PLAN_B_PREMIUM;
				deductible = PLAN_B_DEDUCTIBLE;
				coinsurance = PLAN_B_COINSURANCE;
				
				break;
				
			//uplanName is planB
			case "planB":
				
				//set premium deductible and coinsurance variables to Plan B's premium deductible and coinsurance amounts
				premium = PLAN_B_PREMIUM;
				deductible = PLAN_B_DEDUCTIBLE;
				coinsurance = PLAN_B_COINSURANCE;
				
				break;
				
			//planName is User
			case "User":
				
				//decalre temp string to hold JOptionPane value that is returned from user
				String str;
				
				//retrieve premium from user and set it to premium variable using JOptionPane input dialog
				str = JOptionPane.showInputDialog("Enter your premium: ");
				premium = Double.parseDouble(str);
				
				//retrieve deductible from user and set it to deductible variable using JOptionPane input dialog
				str = JOptionPane.showInputDialog("Enter your deductible: ");
				deductible = Double.parseDouble(str);
				
				//retrieve coinsurance from user and set it to coinsurance variable using JOptionPane input dialog
				str = JOptionPane.showInputDialog("Enter your coinsurance: ");
				coinsurance = Double.parseDouble(str);
				
				break;
			
			//planName is user
			case "user":
				
				//retrieve premium from user and set it to premium variable using JOptionPane input dialog
				str = JOptionPane.showInputDialog("Enter your premium: ");
				premium = Double.parseDouble(str);
				
				//retrieve deductible from user and set it to deductible variable using JOptionPane input dialog
				str = JOptionPane.showInputDialog("Enter your deductible: ");
				deductible = Double.parseDouble(str);
				
				//retrieve coinsurance from user and set it to coinsurance variable using JOptionPane input dialog
				str = JOptionPane.showInputDialog("Enter your coinsurance: ");
				coinsurance = Double.parseDouble(str);
				
				break;
			
			//planName is something else
			default:
				
				//let user know that they have failed and then shut down the program
				System.out.println("Invalid plan. Exiting the program.");
				System.exit(0);
				
		}
		
		//once we have decided what the premium deductible and coinsurance are then 
		//we can get the total medical bill cost and put it into the bills variable
		System.out.println("Enter the total cost of medical bills: ");
		bills = keyboard.nextDouble();
		
		//if the toatl of the medical bills is greater than the deductible
		if (bills > deductible){
			
			//determine what the other costs the user has to pay by taking the 
			//the total amount of medical bills minus the deductible then multiply that by
			//the coinsurance and finally adding that to the deductible
			double otherCost = deductible+coinsurance*(bills - deductible);
			//the total cost the user has to pay is the premium plus that of the total
			//the total amount of medical bills minus the deductible then multiply that by
			//the coinsurance and finally adding that to the deductible (or otherCost)
			double totalCost = premium  + otherCost;
			//print the premium other costs and total costs  formated to two decimal places to the console
			System.out.printf("Premium: $%,.2f \nOther costs: $%,.2f \nTotal costs: $%,.2f\n", premium, otherCost, totalCost);
			
		//the total medical bill is less than the debuctible
		}else{
			//other costs is just the total cost of medical bills
			double otherCost = bills;
			//total cost is the premium plus total cost of medical bills (or otherCost)
			double totalCost = premium  + otherCost;
			//print the premium other costs and total costs  formated to two decimal places to the console
			System.out.printf("Premium: $%,.2f \nOther costs: $%,.2f \nTotal costs: $%,.2f\n", premium, otherCost, totalCost);
		}
		
		//close the keyboard
		keyboard.close();
	}

}
