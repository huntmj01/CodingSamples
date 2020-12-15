package datastructures.homework.huntmj;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		HW3
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	9/23/2016
 * 
 * DESCRIPTION: An ArrayBag is a collection of elements.
 * 
 * CLASS METHODS:
 * 		union
 * 			Takes two ArrayBags, combines them, and returns
 * 			the combined ArrayBag.
 * 
 * CONSTRUCTOR METHODS:
 * 		ArrayBag(int)
 * 			Constructs an empty ArrayBag with the capacity 
 * 			specified in the parameter.
 * 		ArrayBag(T[])
 * 			Constructs an ArrayBag and sets the ArrayBag's
 * 			data with the elements in the array parameter.
 * 
 * INSTANCE VARIABLES:
 * 		data
 * 			Holds an array of data type T.
 * 		manyItems
 * 			Holds how many slots in the array are in use.
 * 
 * INSTANCE METHODS:
 * 		add
 *   		Adds an element to the ArrayBag.
 * 		addAll
 *   		Adds another ArrayBag's elements to this ArrayBag.
 * 		addMany
 * 			Adds multiple elements to the ArrayBag.
 * 		clone
 * 			Clones this ArrayBag and returns the clone.
 * 		ensureCapacity
 * 			Increases the capacity of the ArrayBag if the
 * 			minimum number passed to the method is equal to or
 * 			above manyItems.
 * 		countOccurences
 * 			Counts how many times a particular element appears in 
 * 			the ArrayBag.
 * 		remove
 * 			Removes a particular element from the ArrayBag the first
 * 			time it appears in the Bag.
 * 		trimToSize
 * 			Removes all null values from the array.
 * 		toString
 * 			Returns a string representation of the ArrayBag.
 * 		removeAll
 * 			Removes a particular element from all the places it appears
 *          in the ArrayBag.
 * 
 **/
@SuppressWarnings("unchecked")
public class ArrayBag<T> implements Cloneable {

	//
	// declare instance variables to hold data array
	// and how much of the array to use
	//
	private T[] data; 		// an array to store the elements in the ArrayBag
	private int manyItems; 	// how much of the array is in use
		
	/**
	 * 
	 * Constructs an ArrayBag with the capacity specified.
	 * 
	 **/
	public ArrayBag(
			int initialCapacity	// the size of the ArrayBag
			) {

		// check if initialCapacity is less than zero
		if (initialCapacity < 0) {
			// throw exception
			throw new IllegalArgumentException("initialCapacity is negative: " + initialCapacity);
		}

		// assign manyItems to zero and data to a new
		// array with the size of initialCapacity
		manyItems = 0;
		data = (T[]) new Object[initialCapacity];
		
	}// end ArrayBag(int)

	/**
	 * 
	 * Constructs an ArrayBag and fills it with 
	 * the elements specified.
	 * 
	 **/
	public ArrayBag(
			T[] init // an array of elements to initialize the array bag with
			) {

		// check if the T[] is null
		if (init == null) {
			// throw exception
			throw new IllegalArgumentException("T[] parameter is null ");
		}

		// assign manyItems to zero and data to the
		// init array 
		manyItems = 0;
		data = (T[]) init;
		
	}// end ArrayBag(int)
	
	/**
	 * 
	 * computeAverage() is a method that adds an element
	 * to the ArrayBag.  The method first ensures that 
	 * there is enough room in the ArrayBag to add an element
	 * and if there is not, calls ensureCapacity(). Once the
	 * capacity has been checked, the element is added to data
	 * at the index of manyItems.  manyItems is then increased
	 * by one.
	 * 
	 **/
	public void add(
			T element	// the element to add to the ArrayBag
			) {

		// check if many items is the same as
		// the length of the data array
		if (manyItems == data.length) {
			// double the capacity and add one
			ensureCapacity(manyItems * 2 + 1);
		}

		// set the element of data at index of
		// many items to element parameter
		data[manyItems] = element;
		// increase many items by one
		manyItems++;

	}// end add()

	/**
	 * 
	 * addAll() checks if the parameter bag is null or
	 * the array field of the parameter is empty and in 
	 * either case sends a message to the console
	 * and returns the method.
	 * 
	 */
	public void addAll(
			ArrayBag<T> addend // the ArrayBag to add to the ArrayBag
			) {

		// check if addend is null or array is empty
		if (addend == null || addend.data.length < 1) {
			System.out.println("NO ELEMENTS ADDED TO ARRAY BAG. PARAMETER WAS NULL OR HAD NO ELEMENTS.");
			return;
		}

		// add manyItems to the parameter intArrayBag's many items
		ensureCapacity(manyItems + addend.manyItems);
		
		// addend.manyItems changes so infinite loop occurs
		// use variable to store addend.manyItems
		int addendManyItems = addend.manyItems;
		
		// loop through the addend
		for (int i = 0; i < addendManyItems; i++) {
			// add the added at index i to the ArrayBag
			add(addend.data[i]);
		}
		
		// add however manyItems in the addend to the ArrayBag
		manyItems += addend.manyItems;

	} // addAll()

	/**
	 * 
	 * addMany() adds several elements to the ArrayBag. It first checks
	 * to make sure the elements are not null of less than 1. If so the
	 * method returns. It then ensures adding the elements to the Array
	 * Bag will not compromise the ArrayBag's size and if it does 
	 * ensureCapacity() is called. Once those checks have been made,
	 * the items in elements are added to the ArrayBag. Finally, the 
	 * amount of elements added to the ArrayBag are added to 
	 * manyItems.
	 * 
	 */
	public void addMany(
			T... elements	// elements to add to the ArrayBag
			) {

		// check if addend is null or array is empty
		if (elements == null || elements.length < 1) {
			System.out.println("NO ELEMENTS ADDED TO ARRAY BAG. PARAMETER WAS NULL OR HAD NO ELEMENTS.");
			return;
		}
		
		// check if the elements length plus manyItems is greater
		// than the length of data
		if (manyItems + elements.length > data.length) {
			// ensure twice as much space as we need
			ensureCapacity((manyItems + elements.length) * 2);
		}

		// use enhanced for loop to loop through item in elements
		for (T item : elements) {
			// add item to the ArrayBag
			add(item);
		}
		
		// add the elements to many items
		manyItems += elements.length;
	
	}// end addMany()

	/**
	 * 
	 * clone() clones the data in the ArrayBag
	 * and returns it.	
	 * 
	 **/
	public ArrayBag<T> clone() {
		
		//
		// declare local variable to hold temporary
		// ArrayBag
		//
		ArrayBag<T> answer;		// temporary ArrayBag to clone this ArrayBag into

		// try to clone this intArrayBag
		try {
			// use the cloneable interface to clone the ArrayBag
			answer = (ArrayBag<T>) super.clone();
		} catch (CloneNotSupportedException e) {
			// throw exception 
			throw new RuntimeException("This class does not implement cloneable.");
		}
		
		// copy the data into the answer variable
		answer.data = data.clone();
		
		// return the temporary ArrayBag
		return answer;

	}// end clone()

	/**
	 * 
	 * ensureCapcity() increases the size of the ArrayBag
	 * by copying the ArrayBag into a temporary variable
	 * with the new capacity and then data is set to
	 * the new variable.
	 * 
	 **/
	public void ensureCapacity(
			int minimumCapacity // the new size of the ArrayBag
			) {
		
		//
		// declare local variable to hold temporary
		// array of type T[]
		//
		T[] biggerArray;	// temporary T[] to hold the new array

		// check if the length of the data array is less
		// than the minimum capacity
		if (data.length < minimumCapacity) {
			// assign bigger array to a new array with
			// size of minimum capacity
			biggerArray = (T[]) new Object[minimumCapacity];
			// copy data to bigger array
			System.arraycopy(data, 0, biggerArray, 0, manyItems);
			// assign bigger array to data array
			data = biggerArray;
		}

	}// end ensureCapacity()

	/**
	 * 
	 * countOccurrences() uses an enhanced for loop to
	 * count how many times a particular element appears
	 * in the ArrayBag.
	 * 
	 **/
	public int countOccurrences(
			T target	// the element to count
			) {
		
		//
		// declare local variable to hold to
		// hold how many occurrences occur in the ArrayBag
		//
		int answer = 0; // to hold how many occurrences occur

		// loop through each item in data
		for (T item : data) {
			// if target equals item
			if (target.equals(item)) {
				// increase answer by one
				answer++;
			}
		}
		
		// return the amount of occurrences
		return answer;
		
	}// end countOccurrences() 

	/**
	*
	* remove() finds what index the element specified is at
	* and then removes it from the ArrayBag.
	* 
	*/
	public boolean remove(
			T target	// the element to remove
			) {
		
		//
		// declare local variable to hold to
		// the location of the element in the array
		//
		int index = 0; // location of target in the data array

		// set index to location target in data array
		// if target is not in array then index will be
		// the same as manyItems
		while ((index < manyItems) && (!target.equals(data[index]))) {
			index++;
		}

		// check if index is the same as manyItems
		if (index == manyItems) {
			// target not found
			return false;
			
		// target found at data[index]	
		} else {
			// decrease manyItems by one
			manyItems--;
			// removes the element from the ArrayBag
			data[index] = data[manyItems];
			return true;
		}

	}// remove()

	/**
	 * 
	 * union() joins two ArrayBags into one ArrayBag.
	 * 
	 **/
	public static <T> ArrayBag<T> union(
			ArrayBag<T> b1,	// 1st bag to join
			ArrayBag<T> b2	// 2nd bag to join
			) {

		//
		// declare local variable to hold to
		// the joined ArrayBag
		//
		ArrayBag<T> answer = new ArrayBag<T>(b1.getCapacity() + b2.getCapacity()); // create an intArrayBag with size of b1 + size of b2

		// copy first array to answer
		System.arraycopy(b1.data, 0, answer.data, 0, b2.manyItems);
		// copy second array to answer
		System.arraycopy(b2.data, 0, answer.data, b1.manyItems, b2.manyItems);
		// set manyItems to that of b1 + b2
		answer.manyItems = b1.manyItems + b2.manyItems;
		
		// return the joined ArrayBag
		return answer;

	}// end union()

	/**
	 * 
	 * trimToSize() copies the elements in the ArrayBag that
	 * are not null into the trimmedArray and then sets the
	 * data array to the new trimmedArray.
	 * 
	 */
	public void trimToSize() {
		
		//
		// declare local variable to hold 
		// the trimmedArray
		//
		Object[] trimmedArray;	// to hold the elements in the ArrayBag that are not null
		
		// check to make sure the length of data does not equal
		// many items
		if (data.length != manyItems) {
			// set the size of the trimmed array to that of manyItems
			trimmedArray = new Object[manyItems];
			// copies the data into the trimmedArray
			System.arraycopy(data, 0, trimmedArray, 0, manyItems);
			// casts the trimmedArray into data
			data = (T[]) trimmedArray;
		}
		
	}// end trimToSize()

	/**
	 * toString() concatenates the ArrayBag into
	 * a readable string.
	 */
	public String toString() {
		
		//
		// declare local variable to hold 
		// the concatenated string
		//
		String concat = "";	// holds the readable string of the ArrayBag

		// loop through each item in the data 
		for (T item : data) {
			// check to make sure the item is not null
			if (!(item == null)){
				// add the item to the string
				concat +=  item + ",";
			}
		}
		
		// return the string 
		return concat;

	}// end toString()
	
	/**
	 * 
	 * removeAll() removes an element in the ArrayBag
	 * every time it occurs in the ArrayBag.
	 * 
	 */
	public boolean removeAll(
			T target // the element to remove
			) {
		
		//
		// declare local variable to hold 
		// the numberOfOccurences
		//
		int numberOfOccurences = countOccurrences(target); // holds the numberOfOccurences of the element in the ArrayBag of the element
		
		// checks if the numberOfOccurences is zero
		if (numberOfOccurences == 0){
			return false;
		}
		
		// loop through each numberOfOccurence
		for (int i = 0; i < numberOfOccurences; i++) {

			int index = 0; // location of target in the data array

			// set index to location target in data array
			// if target is not in array then index will be
			// the same as manyItems
			while ((index < manyItems) && (!target.equals(data[index]))) {
				index++;
			}

			// check if index is the same as manyItems
			if (index == manyItems && i == 0) {
				// target not found
			
			// target found at data[index]
			} else {
				// decrease manyItems by 1
				manyItems--;
				// removes the element from the ArrayBag
				data[index] = data[manyItems];
			}

		}

		return true;

	}// end removeAll()

	// getters and setters
	
	public T[] getData() {
		return data;
	}

	public void setData(T[] data) {
		this.data = data;
	}

	public int getManyItems() {
		return manyItems;
	}

	public void setManyItems(int manyItems) {
		this.manyItems = manyItems;
	}

	public int getCapacity() {
		return data.length;
	}
}
