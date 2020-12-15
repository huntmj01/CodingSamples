package huntmj.datastructures.project1;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		Project 1
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	10/08/2016
 * 
 * DESCRIPTION: A Rectangle is a shape that consists of
 * a length and a width.
 * 
 * CONSTRUCTOR METHODS:
 * 		Rectangle
 * 			Constructs a Rectangle and sets the 
 * 			Rectangle's length and width.
 * 
 * INSTANCE VARIABLES:
 * 		length
 * 			Holds the length of the Rectangle.
 * 		width
 * 			Holds the width of the Rectangle.
 * 
 * INSTANCE METHODS:
 *		toString()
 *			Constructs a string representation
 *			of this Rectangle.
 *		equals(Rectangle otherRectangle)
 *			Finds whether or not this Rectangle and
 *			another Rectangle are equal.
 *
 **/
public class Rectangle {
	
	//
	// declare instance variables to hold the 
	// length and width of the rectangle
	//
	private int length;		// holds the length of the Rectangle
	private int width;		// holds the width of the Rectangle
	
	/**
	 * 
	 * Constructs a Rectangle with the length 
	 * and width specified.
	 * 
	 **/
	public Rectangle(
			int length,	// length of Rectangle
			int width	// width of Rectangle
			){
		
		this.length = length;
		this.width = width;
		
	}
	
	/**
	 * 
	 * toString() concatenates the length 
	 * and the width of the rectangle to 
	 * a readable string.
	 * 
	 */
	public String toString(){
		return "length: " + length + ", width: " + width;
	}
	
	/**
	 * 
	 * equals() compares another Rectangle's 
	 * length/width to this Rectangle's 
	 * length/width and then returns
	 * whether or not they are the same.
	 * 
	 */
	public boolean equals(
			Rectangle otherRectangle	// the other Rectangle to compare
			){
		
		// check if this Rectangles length and width equals
		// the other Rectangles width
		if (length == otherRectangle.length && width == otherRectangle.width){
			return true;
		}else{
			return false;
		}
		
	}
	
	// Getters and Setters

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
