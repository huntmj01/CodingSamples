package lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		// initialize employee array list and scanner for user input
		ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
		Scanner scan = new Scanner(System.in);
		
		// loop until user exits
		while (true){
			
			// print menu
			System.out.println("Please select an option: \n1) Add an employee.\n"
					+ "2) List Employees \n3) List Benefit Status \n4) Quit");
			
			// retrieve user input
			int input = scan.nextInt();
			
			// user selects option 1) Add an employee
			if (input == 1){
				
				// print out employee types menu
				System.out.println("What type of employee? \n1) Contract \n2)"
						+ " Hourly \n3) Salary");
				
				// retrieve user input
				int typeOfEmployee = scan.nextInt();
					
				// user selects option 1) Contract
				if (typeOfEmployee == 1){
					
					// create a contract employee
					ContractEmployee contractEmployee = new ContractEmployee();
					
					// retrieve first name last name and company of 
					// employee from user
					System.out.println("Enter contractor first name: ");
					String firstName = scan.next();
					System.out.println("Enter contractor last name: ");
					String lastName = scan.next();
					System.out.println("Enter contractor company: ");
					String company = scan.next();
					
					// retrieve contractor fee wage and hours
					System.out.println("Enter contractor fee: ");
					double fee = scan.nextDouble();
					System.out.println("Enter contractor wage: ");
					double wage = scan.nextDouble();
					System.out.println("Enter contractor hours: ");
					int hours = scan.nextInt();
					
					// set the retrieved values to the employee
					contractEmployee.setFirstName(firstName);
					contractEmployee.setLastName(lastName);
					contractEmployee.setCompany(company);
					
					contractEmployee.setContractFee(fee);
					contractEmployee.setHours(hours);
					contractEmployee.setWage(wage);
					
					// add the contract employee to the array list
					employeeArrayList.add(contractEmployee);
					
				// user selects option 2) Hourly
				}else if (typeOfEmployee == 2){
					
					// create an hourly employee
					HourlyEmployee hourlyEmployee = new HourlyEmployee();
					
					// retrieve the first name last name and company 
					// of employee from user
					System.out.println("Enter hourly employee's first name: ");
					String firstName = scan.next();
					System.out.println("Enter hourly employee's last name: ");
					String lastName = scan.next();
					System.out.println("Enter hourly employee's company: ");
					String company = scan.next();

					// retrieve wage and hours of employee from user
					System.out.println("Enter hourly employee's wage: ");
					double wage = scan.nextDouble();
					System.out.println("Enter hourly employee's hours: ");
					int hours = scan.nextInt();
					
					// set the retrieved values to the employee
					hourlyEmployee.setCompany(company);
					hourlyEmployee.setFirstName(firstName);
					hourlyEmployee.setLastName(lastName);
					
					hourlyEmployee.setHours(hours);
					hourlyEmployee.setWage(wage);
					
					// add the hourly employee to the 
					// employee array list
					employeeArrayList.add(hourlyEmployee);
					
				// user selects option 3) Salary
				}else if (typeOfEmployee == 3){
					
					// create a new salary employee
					SalaryEmployee salaryEmployee = new SalaryEmployee();
					
					// retrieve first name last name and company of 
					// employee from user
					System.out.println("Enter salary employee's first name: ");
					String firstName = scan.next();
					System.out.println("Enter salary employee's last name: ");
					String lastName = scan.next();
					System.out.println("Enter salary employee's company: ");
					String company = scan.next();
					
					scan.next();
					
					// retrieve the salary of the employee from the user
					System.out.println("Enter salary employee's salary: ");
					double salary = scan.nextDouble();
					
					// set the retrieved values to the employee
					salaryEmployee.setCompany(company);
					salaryEmployee.setFirstName(firstName);
					salaryEmployee.setLastName(lastName);
					
					salaryEmployee.setSalary(salary);
					
					// add the salary employee to the array list
					employeeArrayList.add(salaryEmployee);
					
				}
				
			// user selects option 2) List employees
			}else if (input == 2){
				
				// loop through employees
				for (int i = 0; i < employeeArrayList.size(); i++){
					// call employees to string methods
					System.out.println(employeeArrayList.get(i).toString());
				}
			
			// List benefits
			}else if(input == 3){
				
				// loop through employees
				for (int i = 0; i < employeeArrayList.size(); i++){
					
					// print out first name and last name of employee and call 
					// its determineBenifits() method
					System.out.println(employeeArrayList.get(i).getFirstName() + " "
							+ employeeArrayList.get(i).getLastName() + ": " 
							+ employeeArrayList.get(i).determineBenifits());
				}
			}
			
			// user selects anything else
			else {
				// notify the user and break the loop
				System.out.println("Exiting program.");
				break;
			}
			
		}
		
		// close the scanner and exit
		scan.close();
		System.exit(0);

	}

}
