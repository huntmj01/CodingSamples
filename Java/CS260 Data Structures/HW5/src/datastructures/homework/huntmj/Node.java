package datastructures.homework.huntmj;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		Project 1
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	10/19/2016
 * 
 * DESCRIPTION: A Linked List is a sequence of elements arranged,
 * one after another, with each element connected to the next 
 * element by a link.  Placing each element together with the link
 * to the next element results in a component called a Node. 
 * 
 * CLASS METHODS:
 * 		listCopy(Node<T> source)
 * 			Creates and returns a copy of a linked list.
 * 		listPosition(Node<T> head, int position)
 * 			Retrieves a Node at a given position in a
 * 			linked list.
 * 		listLength(Node<T> head)
 * 			Calculates the length of a linked list.
 * 		getTail(Node<T> source)
 * 			Retrieves the tail of a linked list.
 * 
 * CONSTRUCTOR METHODS:
 * 		Node(T initData, Node<T> initLink)
 * 			Constructs a Node and sets the Node's data
 * 			and link with the parameters.
 * 
 * INSTANCE VARIABLES:
 * 		data
 * 			Holds an element of type T.
 * 		link
 * 			Holds another Node.
 * 
 * INSTANCE METHODS:
 *		addNodeAfter(T element)
 *			Adds a new Node after this node.
 *		removeNodeAfter()
 *			Removes the Node that is after this Node.
 * 		toString()
 * 			Returns a string representation of the Node.
 *
 **/
public class Node<T> {
	
	//
	// declare instance variables to hold the data 
	// of this node and the Node that this Node is linked to
	//
	private T data;			// a variable to store the data of this node
	private Node<T> link;	// a variable to store the Node this Node is linked to
	
	/**
	 * 
	 * Constructs a Node with the data and link specified.
	 * 
	 **/
	public Node(
			T initData, 	 // Node data
			Node<T> initLink // link to other Node
			){
		
		data = initData;
		link = initLink;
		
	}
	
	/**
	 * 
	 * addNodeAfter() creates a new Node with
	 * the element specified and link the same as
	 * this Node and then sets this Node's link
	 * to the new Node. The result is that a new
	 * Node is added after this Node.  Finally,
	 * the new Node is returned.
	 * 
	 */
	public Node<T> addNodeAfter(
			T element	// the element to add after this node
			){
		
		// creates a new Node with
		// the element specified and link the same as
		// this Node and then sets this Node's link
		// to the new Node
		link = new Node<T>(element, link);
		
		// return the new node
		return link;
		
	}
	
	/**
	 * 
	 * removeNodeAfter() removes the Node that
	 * is after this Node by setting this Node's
	 * link to the of the Node after this Node.
	 * Then it returns the link created.
	 * 
	 */
	public Node<T> removeNodeAfter(){
		
		// set this nodes link to the link of the Node
		// that is after this Node
		link = link.link;
		
		// return this Node
		return link;
		
	}
	
	
	/**
	 * 
	 * toString() concatenates the elements in the 
	 * Linked List into a readable string.
	 * 
	 */
	public String toString(){
		
		//
		// declare local variable to hold
		// the string representation of
		// the data and link fields of the Node
		//
		String field1 = "";		// holds the string representation of the data field
		String field2 = "";		// holds the string representation of the link field
		
		// check to see if data is null
		if (data == null){
			// we must have a dummy Node being used
			field1 = "data: dummy\n";
		// else data is not null
		}else {
			// call data.toString() 
			// this is recursive
			field1 = "data: " + data.toString() + "\n";
		}
		
		// check to see if link is null
		if (link == null){
			// tail has been reached
			field2 = "link: null in tail!";
		// else data is not null
		}else{
			// call this Node's toString() 
			// this is recursive
			field2 = "link: " + link.toString();
		}
		
		// return concatenated field1 and field2
		return field1 + field2;
		
	}
	
	
	/**
	 *
	 * listCopy() takes the head of a linked list, 
	 * makes sure it is not an empty list, and then 
	 * loops through all the Nodes in the Linked List
	 * while adding them to a a new linked list. Then
	 * the tail Node of the copy is returned.
	 *
	 */
	public static <T> Node<T> listCopy(
			Node<T> source	// the head of the Linked List that is to be copied
			){
		
		//
		// declare local variable to hold
		// the copy of the Head and Tail Nodes
		//
		Node<T> copyHead;	// holds the copy of the head
		Node<T> copyTail;	// holds the copy of the tail
		
		// handle empty list
		if (source == null){
			return null;
		}
		
		// make the first node for the newly created list
		copyHead = new Node<T>(source.data, null);
		// set the copy of the tail to the copy of the head
		copyTail = copyHead;
		
		// make the rest of the nodes for the newly created list
		// by looping through all the links in the source
		while (source.link != null){
			// set the new source to the Node in front of the source
			source = source.link;
			// add the source Node to the copy of the tail
			copyTail = copyTail.addNodeAfter(source.data);
		}
		
		// return the tail reference
		return copyTail;
	
	}
	
	/**
	 *
	 * listPosition() takes the head of a linked list, 
	 * makes sure that the position param is valid, and
	 * loops through the Nodes in the Linked List
	 * until the Node at the specified position is reached.
	 * Then the Node at the specified position is returned.
	 *
	 */
	public static <T> Node<T> listPosition(
			Node<T> head, 	// the head of the Linked List that is to be iterated through
			int position	// the index position of the Node that is to be retrieved
			){
		
		//
		// declare local variable to hold
		// the Node that is currently active 
		// in the loop and a counter for the loop
		//
		Node<T> cursor; // holds the Node that is currently active in the loop
		int i;			// holds the counter for the loop
		
		// check to make sure the position is valid
		if (position <= 0){
			throw new IllegalArgumentException("position is not positive");
		}
		
		// set the cursor Node to the head Node
		cursor = head;
		
		// loop while i is less than the position and the
		// cursor is not null
		for (i = 1; (i < position) && (cursor != null); i ++){
			// set the cursor to the next Node
			cursor = cursor.link;
		}
		
		// return the Node that was at the position specified
		return cursor;
		
	}
	
	/**
	 *
	 * listCopy() takes the head of a linked list, 
	 * loops through the Nodes in the Linked List,
	 * and counts the amount of Node's in the list.
	 * Then the length of the list is returned.
	 *
	 */
	public static <T> int listLength(
			Node<T> head	// the head of the linked list whose length is to be found
			){
		
		//
		// declare local variable to hold
		// the Node that is currently active 
		// in the loop and counter for the 
		// length of the list
		//
		Node<T> cursor;	// holds the Node that is currently active in the loop
		int answer = 0;	// holds the length of the linked list
		
		// loop through the linked list until the tail is reached
		for (cursor = head; cursor != null; cursor = cursor.link){
			// increase counter by 1
			answer++;
		}
		
		// return the length of the list
		return answer;
		
	}
	
	/**
	 * 
	 * getTail() takes the head of a linked list,
	 * makes sure the linked list is not null,
	 * loops through the linked list until the tail
	 * is found, and finally returns the tail.
	 * 
	 */
	public static <T> Node<T> getTail(
			Node<T> source	// the head of the linked list whose tail is to be retrieved
			){
		
		// check to make sure linked list is not empty
		if (source == null){
			return null;
		}
		
		// loop until end of linked list
		while (source.link != null){
			// set the source  to the next Node
			source = source.link;
		}
		
		// return the tail
		return source;
		
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLink() {
		return link;
	}

	public void setLink(Node<T> link) {
		this.link = link;
	}
	
}

