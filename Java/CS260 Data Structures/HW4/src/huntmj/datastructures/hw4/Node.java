package huntmj.datastructures.hw4;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		HW4
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	10/03/2016
 * 
 * DESCRIPTION: A Linked List is a sequence of elements arranged,
 * one after another, with each element connected to the next 
 * element by a link.  Placing each element together with the link
 * to the next element results in a component called a Node. 
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
 * 		toString
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
}
