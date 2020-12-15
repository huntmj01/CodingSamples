package huntmj.datastructures.hw8;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		HW8 
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	12/01/2016
 * 
 * DESCRIPTION: A StudentTable is a hash table
 * of Students.
 * 
 * CONSTRUCTOR METHODS:
 * 		StudentTable(int capacity)
 * 			Constructs a StudentTable with the
 * 			size specified.
 * 
 * INSTANCE VARIABLES:
 * 		manyItems
 * 			Holds the amount of items in the 
 * 			Student table.
 * 		keys
 * 			Holds an array of IDs.
 * 		Student
 * 			Holds an array of Students.
 * 		hasBeenUsed		
 * 			Holds a boolean array to keep track 
 * 			of indexes that have been used in
 * 			the Student array.			
 * 
 * INSTANCE METHODS:
 * 		hash() 
 * 			creates a hash value of the ID specified.
 * 		put()
 * 			adds an element to the StudentTable.
 * 		remove()
 * 			removes an element from the StudentTable.
 *		findIndex()
 *			finds the index in the data
 *          array of the ID specified. 		
 * 		nextIndex() 
 * 			finds the next index of the 
 * 			index specified.
 * 
 **/
public class StudentTable {

	//
	// declare fields to hold the amount
	// of items in the table, an array of 
	// IDs, an array of Students, and a
	// boolean array to keep track of indexes
	// that have been used in the Student array
	//
	private int manyItems;			// holds the amount of items in the table
	private ID[] keys;				// holds an array of IDs
	private Student[] data;			// holds an array of Students
	private boolean[] hasBeenUsed;	// holds a boolean array to keep track of indexes that have been used in the Student array
	
	// Constructs a StudentTable with the capacity specified
	public StudentTable(
			int capacity			// the size of the StudentTable
			){
		
		// check to make sure the programmer that called
		// this constructor isn't a moron
		if (capacity <= 0) throw new IllegalArgumentException("Capacity is negative");
		
		// set the three arrays with the size specified
		keys = new ID[capacity];
		data = new Student[capacity];
		hasBeenUsed = new boolean[capacity];
		
	}
	
	/**
	 * 
	 * hash() uses the hashing algorithm to calculate
	 * the index of the key specified.
	 * 
	 */
	private int hash(
			ID key					// the ID to hash
			){
		
		// calculate the index of the key
		return Math.abs(key.hashCode()) % data.length;
		
	}
	
	/**
	 * 
	 * put() adds a Student to the Student table.
	 * 
	 */
	public Student put(
			String name, 			// the name of the Student
			ID key					// the ID of the Student
			){
		
		// 
		// declare local variables to hold the index 
		// of the Student and the Student found at
		//
		int index = findIndex(key);	// the index of the Student in the Student array
		Student answer;				// the Student
		
		// check to see if student does not already exist
		// in the table
		if (index != -1){
			
			// set the answer to the student
			answer = data[index];
			// create a new student to replace the
			// old student
			data[index] = new Student(name,key);
			// return the old student
			return answer;
			
		// else check to see if the amount of items in the table
		// is less than the length of the data array
		}else if (manyItems < data.length){
			
			// get the hash of the key an store it in index
			index = hash(key);
			// loop from the key at the specified index until
			// a null key is found
			while (keys[index] != null) index = nextIndex(index);
			//set the key 
			keys[index] = key;
			// add the Student to the Student array
			data[index] = new Student(name,key);
			// set the hasBeenUsed for the index to true
			hasBeenUsed[index] = true;
			// increment manyItems
			manyItems++;
			// return null
			return null;
			
		// else the table
		}else{
			// throw exception
			throw new IllegalStateException("Table is full.");
		}
	}
	
	/** 
	 * 
	 * remove() removes a Student from the 
	 * StudentTable.
	 * 
	 */
	public Student remove(ID key){
		int index = findIndex(key);
		Student answer = null;
		
		if (index != -1){
			answer = data[index];
			keys[index] = null;
			data[index] = null;
			manyItems--;
		}
		
		return answer;
		
	}
	
	/**
	 * 
	 * findIndex() finds the index in the data
	 * array of the ID specified.
	 * 
	 */
	private int findIndex(
			ID key							// the key of the Student
			){
		
		//
		// declare local variables to hold a
		// counter and the hash of the key
		//
		int count = 0;						// hold a counter
		int i = hash(key);					// holds the hash of the key specified
		
		// loop through the Student array
		while((count < data.length) && (hasBeenUsed[i])){
			// check to see if the current key equals the
			// key specified
			if (key.equals(keys[i])){
				// return the index
				return i;
			}
			// increase the count
			count++;
			// move to the next index
			i = nextIndex(i);
		}
		
		// else key was not found in Student array
		// so return -1
		return -1;
	}
	
	/**
	 * 
	 * nextIndex() retrieves the next index 
	 * in the Student table.
	 * 
	 */
	private int nextIndex(
			int i							// the current index
			){
		
		// check if adding 1 to the current index
		// is the size of the Student array
		if (i+1 == data.length){
			// return the first index
			return 0;
		}else{
			// return the next index
			return i + 1;
		}
	}

	// getters
	
	public Student[] getData() {
		return data;
	}
	
}
