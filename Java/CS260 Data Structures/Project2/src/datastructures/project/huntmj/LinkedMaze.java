package datastructures.project.huntmj;

import java.util.Scanner;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		Project 2
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	10/29/2016
 * 
 * DESCRIPTION: The maze consists of a two-dimensional array 
 * of Cell objects.
 * 
 * CLASS METHODS:
 *		 reversePath()
 *			Reverses the links of a path.
 * 
 * CONSTRUCTOR METHODS:
 * 		public LinkedMaze(int gridXDim, int gridYDim, Queue queue)
 * 			Constructs a LinkedMaze and initializes the LinkedMaze's
 * 			grid dimensions, queue, two dimensional array, and the
 * 			entry/exit cells.
 * 
 * INSTANCE VARIABLES:
 * 		gridXDimension
 * 			Holds the X dimension of the grid.
 * 		gridYDimension
 * 			Holds the Y dimension of the grid.
 * 		queue
 * 			Holds the Cell's to be checked for passage.
 * 		cells
 * 			Holds two dimensional array of Cells.
 * 		entry
 * 			The entry Cell to the maze.
 * 		exit
 * 			The exit Cell to the maze.
 * 
 * INSTANCE METHODS:
 * 		connectMaze()
 * 			Assigns the correct values to the
 *			directional links of each cell in the grid.
 *		findPath()
 *			Finds the path, if any, out of the maze.
 * 		displayPath()
 * 			Prints a visual representation of the maze
 * 			with the path to the console.
 * 			
 **/
public class LinkedMaze {
	
	//
	// declare fields to hold grid dimensions,
	// queue, grid, and entry/exit cells
	//
	int gridXDimension;		// the x dimension of the grid
	int gridYDimension;		// the y dimension of the grid
	Queue queue;			// queue to hold next cell to be checked
	Cell[][] cells;			// the grid of cells
	Cell entry;				// the entry cell to the maze
	Cell exit;				// the exit cell to the maze
	
	/**
	 * 
	 * constructor that takes the grid dimensions and a Queue 
	 * reference for parameters to initialize those fields. 
	 * Instantiates the cells array to the given dimensions. 
	 * Populates the array with Cell objects. Assigns entry 
	 * the cells[0][0] element and exit the lower right
	 * corner element of the array.
	 * 
	 **/
	public LinkedMaze(
					int gridXDim,	// x-dimension of grid
					int gridYDim, 	// y-dimension of grid
					Queue queue		// queue reference
					){
		
		// init fields
		gridXDimension = gridXDim;
		gridYDimension = gridYDim;
		this.queue = queue;
		
		cells = new Cell[gridXDimension][gridYDimension];
		
		// loop through each item in cell and initialize
		// with a new cell
		for (int i = 0; i < cells.length; i++){
			for (int j = 0; j < cells[i].length; j++){
				cells[i][j] = new Cell(i, j);
			}
		}
		
		// set entry as the first cell and exit as the
		// last cell in the grid
		entry = cells[0][0];
		exit = cells[gridXDimension-1][gridYDimension-1];
		
	}
	
	/**
	 * 
	 *  connectMaze( ) void, takes two Scanner objects to
	 *  read the files characterizing the north-south walls, 
	 *  and the other file having the east-west walls. Runs 
	 *  a nested pair of for loops to assign correct values 
	 *  to the directional links of each cell
	 * 
	 */
	public void connectMaze(
			Scanner nsScan, // the north south file scanner
			Scanner ewScan 	// the east west file scanner
			){
		
		// loop through each Cell
		for (int i = 0; i < cells.length; i++){
			for (int j = 0; j < cells[i].length; j++){
				
				// retrieve the next integers in the north-south
				// and east-west files
				int ns = nsScan.nextInt();
				int ew = ewScan.nextInt();
				
				// set north link of cell
				if (i!=0 && cells[i-1][j].sLink != null){
					if (cells[i-1][j].sLink.equals(cells[i][j])){
						cells[i][j].nLink = cells[i-1][j];
					}
				}
				
				// set south link of cell
				if (ns == 0){
					cells[i][j].sLink = cells[i+1][j];
				}
				
				// set east link of cell
				if (ew == 0){
					cells[i][j].eLink = cells[i][j+1];
				}
				
				// set west link of cell
				if (j!=0 && cells[i][j-1].eLink != null){
					if (cells[i][j-1].eLink.equals(cells[i][j])){
						cells[i][j].wLink = cells[i][j-1];
					}
				}
			}
		}
	}
	
	/**
	 *
	 * findPath()
	 * 
	 * 1. Mark the entry cell visited and enqueue
	 * 2. Repeat:
	 *	• dequeue
	 *	• if exit is a neighbor of the current (dequeued) cell, 
	 *	stop the algorithm and build the output for the successful search
	 *	• otherwise check the four directional links of the current cell
	 *	• for each non-null and non-visited link mark the link visited, 
	 *	add it to the queue and assign the added link’s backlink the current cell
	 * 3. Stop the algorithm if the queue is empty and build the output for the failed search
	 * 
	 */
	public void findPath(){
		
		// 1. Mark the entry cell visited and enqueue
		entry.visited = true;
		queue.enqueue(entry);
		
		// 2. repeat
		while(true){
			
			// dequeue
			Cell c = queue.dequeue();
			
			// if exit is a neighbor of the current (dequeued) cell,
			// stop the algorithm and build the output for the successful search
			if (Cell.linked(c, exit)){
				System.out.println("exit found");
				exit.backLink = c;
				break;
				
			// otherwise check the four directional links of the current cell
			}else{
				
				// for each non-null and non-visited link mark the link visited, 
				// add it to the queue and assign the added link’s backlink the current cell
				if (c.nLink != null && c.nLink.visited == false){
					c.nLink.visited = true;
					queue.enqueue(c.nLink);
					c.nLink.backLink = c;
				}
				if (c.eLink != null && c.eLink.visited == false){
					c.eLink.visited = true;
					queue.enqueue(c.eLink);
					c.eLink.backLink = c;
				}
				if (c.sLink != null && c.sLink.visited == false){
					c.sLink.visited = true;
					queue.enqueue(c.sLink);
					c.sLink.backLink = c;
				}
				if (c.wLink != null && c.wLink.visited == false){
					c.wLink.visited = true;
					queue.enqueue(c.wLink);
					c.wLink.backLink = c;
				}
				
			}
			
			// Stop the algorithm if the queue is empty and build 
			// the output for the failed search
			if (queue.isEmpty()){
				System.out.println("no exit found, max distance: " + c.sum());
				exit = c;
				break;
			}
		}
	}
	
	/**
	 * 
	 * reversePath() given the exit Cell of the maze,
	 * reverses the links and makes entry the head and 
	 * current the tail.
	 * 
	 */
	public static Cell reversePath(
			Cell exit	// the exit cell of the maze
			){
		
		// check to see if the linked list is null
	    if (exit == null) return null; 

	    // check to see if the linked list only has one element
	    if (exit.backLink == null) return exit; 

	    // get the next element in the linked list
	    Cell nextElement = exit.backLink;

	    // unlink the linked list
	    exit.backLink = null;

	    // then we reverse everything from the second element on
	    Cell reverseList = reversePath(nextElement);

	    // join the two lists
	    nextElement.backLink = exit;
	    
	    // return the reversed list
	    return reverseList;
	    
	}
	
	/**
	 * 
	 * displayPath() prints the coordinates of the cells along
	 * a path, starting at the entry cell
	 * 
	 */
	public void displayPath(
			Cell linkedList	// the exit Cell of the maze
			){
		
		// reverse the linked list
		linkedList = LinkedMaze.reversePath(linkedList);
		
		// create a string array to hold the path
		String[][] strArr = new String[gridXDimension][gridYDimension];
		
		// loop through the linked list
		for (Cell cursor = linkedList; cursor != null; cursor = cursor.backLink){
			// store the toString() of the cursor in the string array
			strArr[cursor.row][cursor.column] = cursor.toString();
		}
		
		// loop through the string array
		for (int i = 0; i < strArr.length; i++){
			for (int j = 0; j < strArr[i].length; j++){
				
				// check to see if current string is not null
				if (strArr[i][j] != null){
					// print out the string
					System.out.print(strArr[i][j]);
				}else{
					System.out.print("xxxxxx");
				}
				
			}
			System.out.print("\n");
		}
	}
}
