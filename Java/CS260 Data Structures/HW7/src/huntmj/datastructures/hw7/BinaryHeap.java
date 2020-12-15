package huntmj.datastructures.hw7;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		HW 7
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	11/21/2016
 * 
 * DESCRIPTION: The BinaryHeap supports the
 * array representation of binary max heaps.
 * 
 * CLASS METHODS:
 * 		heapFactory()
 *  		Generates a Heap.
 * 
 * CONSTRUCTOR METHODS:
 * 		BinaryHeap(int length)
 * 			Constructs a Queue and initializes the
 * 			array size of the Queue.
 * 
 * INSTANCE VARIABLES:
 * 		manyItems
 * 			Holds the amount of items in the Heap.
 * 		data
 * 			Holds the data in the Heap.
 * 
 * INSTANCE METHODS:
 * 		add()
 * 			Adds a string to the Heap.
 * 		removeRoot()
 * 			Removes the root from the Heap.
 * 		ensureCapacity()
 * 			Increases the size of the Heap.
 * 		trim()
 * 			Removes the three largest elements
 * 			from the Heap.
 * 		toString()
 * 			Creates a string representation of
 * 			the Heap.
 * 			
 **/
public class BinaryHeap {
	
	//
	// declare fields to hold the amount of items 
	// in the heap and the data in the heap
	//
	int manyItems;		// holds the amount of items in the heap
	String[] data;		// holds the data in the heap
	
	/**
	 * 
	 * Constructs a BinaryHeap with size of the
	 * length specified and sets manyItems to 0
	 * 
	 */
	public BinaryHeap(
			int initLength	// the initial length of the heap
			) {
		
		data = new String[initLength];
		manyItems = 0;
		
	}

	/**
	 * 
	 * add() adds a string to the heap using 
	 * the reheapification upward algorithm.
	 * 
	 */
	public void add(
			String str		// the string to add to the heap
			){
		
		// check if many items is the same as
		// the length of the data array
		if (manyItems == data.length){
			// double the capacity and add one
			ensureCapacity(manyItems*2 + 1);
		}
		
		// check if many items is zero
		if (manyItems == 0){
			// set the root to the string, add
			// one to many items, and return
			data[manyItems] = str;
			manyItems++;
			return;
		}
		
		// set the next item to the string
		data[manyItems] = str;
		
		boolean isAtRoot = data[manyItems].equals(data[0]);
		String parentStr = data[(manyItems-1)/2];
		int strCompareToParentStr = data[manyItems].compareTo(parentStr);
		int index = manyItems;
		
		// While ((new data is not at the root) && (new data > parent’s data))
		//		Swap new data with parent’s data
		while (!isAtRoot && strCompareToParentStr > 0){
			// swap the new element with the parents data
			String dat = data[index];
			data[index] = parentStr;
			data[(index-1)/2] = dat;
			
			// recalculate
			index = (index-1)/2;
			isAtRoot = data[manyItems].equals(data[0]);
			parentStr = data[(index-1)/2];
			strCompareToParentStr = data[index].compareTo(parentStr);			
		}
		
		// increase many items by one
		manyItems++;
			
	}
	
	/**
	 * 
	 * removeRoot() removes the root from the heap using 
	 * the reheapification downward algorithm.
	 * 
	 */
	public void removeRoot(){
		
		// copy the last element in the deepest level to the root
		// and then take this last node out of the tree
		data[0] = data[manyItems-1];
		data[manyItems-1] = null;
		manyItems--;
		
		int index = 0;
		
		// check if many items is the same as
		// the length of the data array
		if (manyItems < 2*index+1){
			// double the capacity and add one
			ensureCapacity(2*index+1);
		}
		
		int parentCompareToRightChild = data[index].compareTo(data[2*index+1]);
		int parentCompareToLeftChild = data[index].compareTo(data[2*index+2]);
		
		// while (the out of place element has a priority that is 
		// lower than one of its children)
		// 		swap the out of place element with its highest 
		//		priority child		
		while (parentCompareToRightChild < 0 || parentCompareToLeftChild < 0){
			
			// check if right child is less than left child
			if (parentCompareToRightChild < parentCompareToLeftChild){
				// swap the parent with the left child
				String temp = data[index];
				data[index] = data[2*index+1];
				data[2*index+1] = temp;
				index = 2*index+1;
			}else{
				// swap the parent with the right child
				String temp = data[index];
				data[index] = data[2*index+2];
				data[2*index+2] = temp;
				index = 2*index+2;
			}
			
			// check if many items is the same as
			// the length of the data array
			if (manyItems <= 2*index+1){
				// double the capacity and add one
				ensureCapacity(index*2+3);
			}
			
			// check if the right child is null
			if (data[2*index+2] == null){
				break;
			}
			
			// recalculate
			parentCompareToRightChild = data[index].compareTo(data[2*index+1]);
			parentCompareToLeftChild = data[index].compareTo(data[2*index+2]);
		}
		
	}
	
	/**
	 * 
	 * ensureCapcity() increases the size of the Array
	 * by copying the Array into a temporary variable
	 * with the new capacity and then data is set to
	 * the new variable.
	 * 
	 **/
	public void ensureCapacity(
			int minimumCapacity		// the new size of the array
			){
		
		//
		// declare local variable to hold
		// the bigger array
		//
		String[] biggerArray;
		
		// check if the length of the data array is less
		// than the minimum capacity
		if (data.length < minimumCapacity){
			// assign bigger array to a new int array with
			// size of minimum capacity
			biggerArray = new String[minimumCapacity];
			// copy data to bigger array
			System.arraycopy(data, 0, biggerArray, 0, manyItems);
			// assign bigger array to data array 
			data = biggerArray;
		}
		
	}
	
	/**
	 * 
	 * heapFactory() instantiates a String array to the length
	 * of the parameter array and constructs a heap on this
	 * array such that calling the add() method repeatedly, adds
	 * all the parameter elements one after each other to the new heap.
	 * 
	 **/
	public static BinaryHeap heapFactory(
			String[] arr	// the string array to create the heap from
			){
		
		// create a new heap with the size of the array
		BinaryHeap heap = new BinaryHeap(arr.length);
		
		// loop through each item in the array
		for (String item : arr){
			// add the item to the heap
			heap.add(item.toLowerCase());
		}
		
		// return the heap
		return heap;
		
	}
	
	/**
	 * 
	 * trim( ) removes the three largest elements from
	 * this heap.
	 *   
	 */
	public void trim(){
		
		// no elements
		if (manyItems == 0){
			return;
		// 1 element
		}else if (manyItems == 1){
			removeRoot();
		// 2 elements
		}else if (manyItems == 2){
			removeRoot();
			removeRoot();
		// more than 2 elements
		}else if (manyItems >= 3){
			removeRoot();
			removeRoot();
			removeRoot();
		}
		
	}
	
	/**
	 * 
	 * toString() creates a string representation
	 * of the heap.
	 * 
	 **/
	public String toString(){
		
		String str = "";
		
		// loop through each item in the array
		for(String item : data){
			// break if item is null
			if (item==null)break;
			// add the item to the return string
			str += item + ", ";
		}
		
		// return the string
		return str;
	}
}
