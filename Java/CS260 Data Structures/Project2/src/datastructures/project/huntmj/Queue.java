package datastructures.project.huntmj;

import java.util.NoSuchElementException;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		Project 2
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	10/29/2016
 * 
 * DESCRIPTION: The Queue servers as the main tool
 * for the algorithm searching for the path of
 * the maze.
 * 
 * CONSTRUCTOR METHODS:
 * 		Cell(int size)
 * 			Constructs a Queue and initializes the
 * 			array size of the Queue.
 * 
 * INSTANCE VARIABLES:
 * 		manyItems
 * 			Holds the amount of items in the Queue.
 * 		front
 * 			Holds the index of the front element 
 * 			in the Queue.
 * 		rear
 * 			Holds the index of the rear element
 * 			in the Queue.
 * 		cellQueue
 * 			Holds a circular array of cell objects.
 * 
 * INSTANCE METHODS:
 * 		nextIndex()
 * 			Returns the index of the next Cell
 * 			in the Queue.
 * 		ensureCapacity()
 * 			Increases the size of the Queue.
 * 		enqueue()
 * 			Adds a Cell to the Queue.
 * 		dequeue()
 * 			Removes a Cell from the Queue.
 * 		isEmpty()
 * 			Returns whether or not the Queue
 * 			is empty.
 * 			
 **/
public class Queue {
	
	//
	// declare fields to hold the amount 
	// of items in the queue, the front
	// and rear items in the queue, and 
	// a circular array of cell objects
	//
	int manyItems;		// holds the amount of items in the Queue
	int front;			// holds the front index in the Queue
	int rear;			// holds the rear index in the Queue
	Cell[] cellQueue;	// holds a circular array of cell objects
	
	/**
	 * 
	 * Constructs a Queue and instantiates the
	 * array the size specified.
	 * 
	 */
	public Queue(
			int size	// initial size of Array
			){
		
		cellQueue = new Cell[size];
		
	}
	
	/**
	 *
	 * nextIndex() returns the next index in the Queue.
	 *
	 */
	private int nextIndex(
			int i	// the current index of the Queue
			){
		
		// check to see if the next index equals the
		// length of the cell queue
		if (++i == cellQueue.length){
			
			// return 0
			return 0;
		
		// else the next index does not equal
		// the length of the cell queue
		}else{
			
			// return the next index
			return i;
			
		}
		
	}
	
	/**
	 *
	 * ensureCapcity() increases the size of the
	 * cellQueue array.
	 *
	 */
	public void ensureCapacity(
			int minimumCapacity	// the minimum size of the array
			){
		
		//
		// declare local variables to hold the
		// new array, the amount of elements
		// between the end and front of the array,
		// and the rear + 1
		//
		Cell[] biggerArray;	// holds the new array with the larger capacity
		int n1;				// holds the amount of elements between the front and the end of the array	
		int n2;				// holds the rear + 1
		
		// check to see if the Queue length is already
		// greater than or equal to the minimum capacity
		if (cellQueue.length >= minimumCapacity){
			
			// no change is needed
			return;
			
		// or if manyItems is zero
		}else if (manyItems == 0){
			
			// increase the size of the array
			// the queue is empty so we don't
			// need to worry about elements 
			// being lost
			cellQueue = new Cell[minimumCapacity];
		
		// or if the front index is less than  
		// or equal to the rear
		}else if (front <= rear){
			
			// create a larger array and copy 
			// cellQueue into it
			biggerArray = new Cell[minimumCapacity];
			System.arraycopy(cellQueue, front, biggerArray, front, manyItems);
			cellQueue = biggerArray;
		
		// else the front index is greater 
		// than the rear index
		}else{
			
			// initialize bigger array with an array
			// size of the minimum capacity
			biggerArray = new Cell[minimumCapacity];
			// calculate the amount of elements between the front
			// index and the end of the queue
			n1 = cellQueue.length - front;
			// add one to the rear and store it in n2
			n2 = rear + 1;
			// copy the elements in cellQueue to the biggerArray
			System.arraycopy(cellQueue, front, biggerArray, 0, n1);
			System.arraycopy(cellQueue, 0, biggerArray, n1, n2);
			// set the new rear
			rear = manyItems-1;
			// set cellQueue to biggerArray
			cellQueue = biggerArray;
			
		}
		
	}
	
	/**
	 * 
	 * enqueue() adds an item to the Queue.
	 * 
	 */
	public void enqueue(
			Cell item	// item to add to the Queue
			){
		
		// check to see if manyItems equals that
		// of the length of the cellQueue array
		if (manyItems == cellQueue.length){
			// double the size of the array
			ensureCapacity(manyItems*2 + 1);
		}
		
		// check to see if Queue is empty
		if (manyItems == 0){
			
			// set the front and rear to zero
			front = 0;
			rear = 0;
		
		// else Queue is not empty
		}else{
			
			// move the rear up one
			rear = nextIndex(rear);
			
		}
		
		// set the new rear to the item specified
		cellQueue[rear] = item;
		
		// increase amount of items by one
		manyItems++;
		
	}
	
	/**
	 * 
	 * dequeue() removes the next element in the Queue.
	 * 
	 */
	public Cell dequeue(){
		
		//
		// declare local variable to 
		// hold the next element in the
		// Queue that is to be removed
		//
		Cell answer;
		
		// check to see if manyItems equals zero
		if (manyItems == 0){
			// throw exception
			throw new NoSuchElementException("Queue underflow.");
		}
		
		// retrieve the cell at the front index
		answer = cellQueue[front];
		// move the front index to the next 
		// index in the array
		front = nextIndex(front);
		// decrease the amount of items by one
		manyItems--;
		
		// return the Cell that was removed
		return answer;
		
	}
	
	/**
	 * 
	 * isEmpty() returns whether or not the Queue
	 * is empty.
	 *
	 */
	public boolean isEmpty(){
		
		// return whether or not there are no
		// items in the Queue
		return (manyItems == 0);
		
	}
}
