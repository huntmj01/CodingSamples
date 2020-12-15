package datastructures.project.huntmj;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		Project 2
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	10/29/2016
 * 
 * DESCRIPTION: The maze consists of a two-dimensional array 
 * of Cell objects. Each Cell knows which ones of the four
 * neighbors are accessible from it. 
 * 
 * CLASS METHODS:
 *		linked() 
 *			Utility method that takes determines if one
 *			Cell is an accessible neighbor of the other.
 * 
 * CONSTRUCTOR METHODS:
 * 		Cell(int row, int column)
 * 			Constructs a Cell and initializes the Cell's
 * 			Row and Column numbers.
 * 
 * INSTANCE VARIABLES:
 * 		row
 * 			Holds row number of this Cell.
 * 		column
 * 			Holds column number of this Cell.
 * 		nLink
 * 			Holds the Cell above this Cell.
 * 		eLink
 * 			Holds the Cell to the right of this Cell.
 * 		sLink
 * 			Holds the Cell bellow this Cell.
 * 		wLink
 * 			Holds the Cell left of this Cell.
 * 		backLink
 * 			Holds the Cell previous to this Cell.
 * 		visited
 * 			Holds whether this Cell has been enqueued.
 * 
 * INSTANCE METHODS:
 * 		toString()
 * 			Returns a string representation of this Cell.
 * 		sum()
 * 			Convenience method that returns row+column
 * 			to help maximize distance.
 * 			
 **/
public class Cell {
	
	//
	// declare fields to store location coordinates
	// of the Cell in the grid, store other Cell 
	// references, and a flag to mark this Cell as
	// visited
	//
	int row;			// holds row number of this Cell
	int column;			// holds column number of this Cell
	Cell nLink;			// holds the Cell above this Cell
	Cell eLink;			// holds the Cell to the right of this Cell
	Cell sLink;			// holds the Cell bellow this Cell
	Cell wLink;			// holds the Cell left of this Cell
	Cell backLink;		// holds the Cell previous to this Cell
	boolean visited;	// holds whether this Cell has been enqueued
	
	/**
	 * 
	 * Constructs a Cell with array	coordinates.
	 * 
	 */
	public Cell(
			int row, 	// row number of Cell in grid
			int column	// column number of Cell in grid
			){
		
		this.row = row;
		this.column = column;
		visited = false;
		
	}
	
	/**
	 * 
	 * linked() is a static utility method that takes
	 * two Cells and determines if one is an accessible
	 * neighbor of the other, that is if one is a 
	 * directional link of the other.
	 * 
	 */
	public static boolean linked(
			Cell cell1, 	// the first Cell to be compared
			Cell cell2		// the second Cell to be compared
			){
		
		//
		// declare local variables to hold
		// whether or not the two Cells are
		// neighbors
		//
		boolean neighbor = false;	// holds whether or not the two Cells are neighbors
		
		// check to see if any of the links of cell1 or cell2
		// equal that of the other cell
		if (cell1.nLink != null){
			if (cell1.nLink.equals(cell2)){
				neighbor = true;
			}
		}
		
		if (cell1.eLink != null){
			if (cell1.eLink.equals(cell2)){
				neighbor = true;
			}
		}
		
		if (cell1.sLink != null){
			if (cell1.sLink.equals(cell2)){
				neighbor = true;
			}
		}
		
		if (cell1.wLink != null){
			if (cell1.wLink.equals(cell2)){
				neighbor = true;
			}
		}
		
		// return the flag
		return neighbor;
		
	}
	
	/**
	 * 
	 * toString() returns a string representation of
	 * the Cell that shows the row and the column.
	 * 
	 */
	public String toString(){
		
		// return the string representation of
		// the Cell that shows the row and the column
		return "(" + row + ", " + column + ")";
		
	}
	
	/**
	 * 
	 * sum() is a convenience method that returns 
	 * row+column to help maximize distance.
	 * 
	 */
	public int sum(){
		
		// return the row + column
		return row+column;
		
	}
	
}
