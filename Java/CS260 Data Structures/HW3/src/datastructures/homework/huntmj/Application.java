package datastructures.homework.huntmj;

/**
* NAME:		Matthew Hunt
* PROJECT:	HW 1
* COURSE:		CS 260
* INSTRUCTOR:	Petruska
* DUE DATE:	September 3, 2016
*
* DESCRIPTION: The Application class contains the main method.
*
* CLASS METHODS:
* 	main
*  		the main method that runs the program
**/
public class Application {

	public static void main(String[] args) {
		
		// instantiate two string array bags and one int array bag
		ArrayBag<String> strArrBag1 = new ArrayBag<String>(50);
		ArrayBag<String> strArrBag2 = new ArrayBag<String>(50);
		ArrayBag<Integer> intArrBag1 = new ArrayBag<Integer>(50);
		
		System.out.println("\n---------PART 1---------\n");
		
		// test add()
		strArrBag1.add("Hello");
		strArrBag1.add("my");
		strArrBag1.add("name");
		strArrBag1.add("is");
		strArrBag1.add("Matt");
		
		strArrBag2.add("and");
		strArrBag2.add("I");
		strArrBag2.add("like");
		strArrBag2.add("Computer");
		strArrBag2.add("Science.");
		
		System.out.println("strArrBag1 after add: " + strArrBag1.toString());
		System.out.println("strArrBag1 after add: " +strArrBag2.toString());
		
		// test addAll()
		strArrBag1.addAll(strArrBag1);
		strArrBag2.addAll(strArrBag1);
		
		System.out.println("strArrBag1 after add all: " + strArrBag1.toString());
		System.out.println("strArrBag2 after add all: " + strArrBag2.toString());
		
		// test addMany()
		strArrBag1.addMany(" ", "My", "favorite", "class", "is", "Data", "Structure");
		System.out.println("strArrBag1 after add many: " + strArrBag1.toString());
		
		// test clone()
		strArrBag2 =  strArrBag1.clone();
		
		System.out.println("strArrBag2 after being cloned to strArrBag1: " + strArrBag1.toString());
		
		// test countOccurences()
		System.out.println("Number of occurences of Matt in strArrBag1: " + strArrBag1.countOccurrences("Matt"));
		System.out.println("Number of occurences of is in strArrBag2: " + strArrBag2.countOccurrences("is"));
		
		// test remove()
		strArrBag1.remove("like");
		strArrBag2.remove("Computer");
		
		System.out.println("strArrBag1 after remove like: " + strArrBag1.toString());
		System.out.println("strArrBag2 after remove computer: " + strArrBag2.toString());
		
		// test union()
		System.out.println("strArrBag1 union strArrBag2: " + ArrayBag.union(strArrBag1, strArrBag2).toString());
		System.out.println("strArrBag2 union strArrBag1: " + ArrayBag.union(strArrBag2, strArrBag1).toString());
		
		// test trimToSize()
		System.out.println("strArrBag1 capacity before trim: " + strArrBag1.getCapacity());
		System.out.println("strArrBag2 capacity before trim: " + strArrBag2.getCapacity());
		
		strArrBag1.trimToSize();
		strArrBag2.trimToSize();
		
		System.out.println("strArrBag1 capacity after trim: " + strArrBag1.getCapacity());
		System.out.println("strArrBag2 capacity after trim: " + strArrBag2.getCapacity());
		
		// test removeAll()
		strArrBag1.removeAll("is");
		strArrBag2.removeAll("Computer");
		
		System.out.println("strArrBag1 after remove all like: " + strArrBag1.toString());
		System.out.println("strArrBag2 after remove all computer: " + strArrBag2.toString());
		
		System.out.println("\n---------PART 2---------\n");
		
		/**
		 * 
		 * Using the setters for data and manyItems allow us to manually set the elements
		 * in the ArrayBag to an Array we may have.  manyItems can also be manually adjusted
		 * but should be used with caution.  Also note when you set the data, all the previous elements
		 * in the ArrayBag will be removed.
		 * 
		 **/
		
		// a newly initialized intArrBag has a default capacity of 50 and 0 manyItems
		System.out.println("intArrBag1 Capacity before using setters: " + intArrBag1.getCapacity());
		System.out.println("intArrBag1 manyItems before using setters: " + intArrBag1.getManyItems());
		
		// an integer array with 3 items
		Integer[] intArr = {123, 789, 331};
		
		// using the data setter resets the data array
		intArrBag1.setData(intArr);
		// manually set many items to 2
		intArrBag1.setManyItems(2); // probably a bag idea to set manyItems to something bigger than the ArrayBag or to a null value in the ArrayBag
		
		// the capacity will now be the size of the integer array we passed into the setter and 
		// manyItems will be what we passed into the setter
		System.out.println("intArrBag1 Capacity after using setters: " + intArrBag1.getCapacity());
		System.out.println("intArrBag1 manyItems after using setters: " + intArrBag1.getManyItems());
		

	}
}
