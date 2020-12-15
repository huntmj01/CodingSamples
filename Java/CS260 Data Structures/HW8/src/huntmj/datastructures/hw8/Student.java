package huntmj.datastructures.hw8;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		HW8 
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	12/01/2016
 * 
 * DESCRIPTION: A Student consists of an ID
 * and name.
 * 
 * CONSTRUCTOR METHODS:
 * 		Student(String name, ID id)
 * 			Constructs a Student using the
 * 			given name and id.
 * 		Student(String name)
 * 			Constructs a Student using the 
 * 			given name and randomly generated
 * 			ID.
 * 
 * INSTANCE VARIABLES:
 * 		name
 * 			The name of the Student.
 * 		id
 * 			The id of the Student.
 * 
 * INSTANCE METHODS:
 * 		equals() 
 * 			compares the given Student to 
 * 			this Student and returns whether
 * 			or not they are the same.
 * 			
 **/
public class Student {

	//
	// declare fields to hold the 
	// name and id of the Student
	//
	String name;			// the name of the Student
	ID id;					// the id of the Student
	
	// Constructor given the name and id of Student
	public Student(
			String name,	// the name of the Student 
			ID id			// the id of the Student
			){
		
		// assign this Students name and id to the
		// name and id specified
		this.name = name;
		this.id = id;
		
	}
	
	// Constructor given just the name of the Student
	public Student(
			String name		// the name of the Student
			){
		
		// assign this Students name to the name
		// specified and then generate a random ID
		this.name = name;
		id = new ID();
		
	}
	
	/**
	 * 
	 * equals() compares this Student to the 
	 * given Student and returns whether or
	 * not they are equal.
	 * 
	 */
	public boolean equals(
			Student student	// the Student to compare to this Student
			){
		
		// check if this Student's name/id equals that 
		// of the name/id of the Student specified
		if (this.name.equals(student.name)  && this.id == student.id){
			return true;
		}
		// else they are not the same so return false
		return false;
		
	}
	
}
