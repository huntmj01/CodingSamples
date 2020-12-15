package huntmj.datastructures.hw7;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		HW7
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	11/21/16
 *
 * DESCRIPTION: The Application class contains the main method.
 *
 * CLASS METHODS:
 * 		main(String[] args)
 *  		The main method that runs the program.
 * 			
 **/
public class Application {
	
	/**
	 * 
	 * main() where the magic happens.
	 *
	 **/
	public static void main(String args[]){
		
		//
		// declare local variable to hold array
		// of 40 strings
		//
		String[] strArr = {"liquid", "photograph", "box", "proud", "gross", "how", "bliss", "ransom", "alcoholic", "dangerous",
							"farm", "acid", "eyetooth", "mighty", "drugstore", "absence", "expert", "abrasive", "episode", "conceptual",
							"forbidden", "bloody", "family", "drive", "cosmic", "milky", "zebra", "base", "frustration", "chant",
							"creeper", "human", "legend", "gravy", "crocodile", "evil", "charismatic", "serum", "computer", "rastling"};
		
		// use the heap factory to generate a binary heap
		BinaryHeap binaryHeap = BinaryHeap.heapFactory(strArr);
		
		// trim the heap
		binaryHeap.trim();
		
		// print the results
		System.out.println(binaryHeap.toString());
		
	}
	
}
