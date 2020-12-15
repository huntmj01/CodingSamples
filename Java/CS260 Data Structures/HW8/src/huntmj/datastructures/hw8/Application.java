package huntmj.datastructures.hw8;

import java.util.Random;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		HW8
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	12/01/2016
 *
 * DESCRIPTION: The Application class contains the main method.
 *
 * CLASS METHODS:
 * 		main(String[] args)
 *  		The main method that runs the program.
 *  	randomName()
 *  		Generates a random name.
 *  	displayTable()
 *  		Displays the first 50 non null names
 *  		in the StudentTable.
 * 			
 **/
public class Application {

	/**
	 * 
	 * main() where the magic happens.
	 * 
	 */
	public static void main(String[] args) {

		long startTime, stopTime, elapsedTime;
		
		// create a StudentTable of size 30 thousand
		// and add 15 thousand students to it
		StudentTable st = new StudentTable(30000);
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 15000; i++) {
			st.put(randomName(7), new ID());
		}
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("time of executing the 15,000 put( ) calls: " + elapsedTime);
		displayTable(st);
		
		// create a StudentTable of size 1 million
		// and add 500,000 students to it
		st = new StudentTable(1000000);
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			st.put(randomName(7), new ID());
		}
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\ntime of executing the 500,000 put( ) calls: " + elapsedTime);
		displayTable(st);
		
		// test remove method
		ID id = new ID();
		st.put("Matthew", id);
		st.remove(id);
		
	}
	
	/**
	 * 
	 * randomName() generates a randomName with the
	 * size specified.
	 *
	 */
	public static String randomName(
			int length					// the length of the name
			){
		
		Random rand = new Random();
		String str = "";
		char firstLetter = (char)(rand.nextInt(26) + 'A');
		length--;
		str+=firstLetter;
		char[] vowels = {'a', 'e', 'i', 'o', 'u'}; 
		char[] constants = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
		boolean constant = false;
		
		// generate the name
		while (length!=0){
			if (constant){
				str += constants[rand.nextInt(20)];
				constant = false;
			}else{
				str += vowels[rand.nextInt(4)];
				constant = true;
			}
			length--;
		}
		
		// return the final string
		return str;
	}
	
	/**
	 * 
	 * displayTable() displays the first 50 non null
	 * names in the table.
	 * 
	 */
	public static void displayTable(
			StudentTable st					// the Student table
			){
		
		Student[] data = st.getData();
		int i = 0;
		int j = 0;
		
		while ( i < 51){
			if (data[j]!=null){
				System.out.print(data[j].name + "[" + j + "], ");
				i++;
			}
			j++;
		}			
	}

}
