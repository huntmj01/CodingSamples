package huntmj.datastructures.project1;

/**
 * 
 * NAME: Matthew Hunt
 * PROJECT: Project 1 
 * COURSE: CS260 
 * INSTRUCTOR: Petruska 
 * DUE DATE: 10/08/2016
 * 
 * DESCRIPTION: A LinkedSequence is a sequence of a Linked List.
 * 
 * CLASS METHODS:
 * 		concatenate(LinkedSequence<T> seq1, LinkedSequence<T> seq2)
 * 			Combines two LinkedSequences.
 * 
 * CONSTRUCTOR METHODS: 
 * 		LinkedSequence(Node<T> head)
 * 			Constructs and empty Linked Sequence.
 * 
 * INSTANCE VARIABLES: 
 * 		head
 * 			Holds the first Node of the Linked Sequence.
 * 		tail 
 * 			Holds the last Node of the Linked Sequence.
 * 		cursor 
 * 			Holds the current element of the Linked Sequence.
 * 		manyNodes
 * 			Holds the amount of Nodes in the Linked Sequence.
 * 
 * INSTANCE METHODS: 
 * 		addAfter(T element)
 * 			Adds a Node after the cursor.
 * 		addBefore(T element)
 * 			Adds a Node before the cursor.
 * 		addAll(LinkedSequence<T> other)
 * 			Adds all the Node's in a LinkedSequence to this 
 * 			LinkedSequence.
 * 		advance()
 * 			Moves the cursor one Node forward.
 * 		clone()
 * 			Copies this Linked Sequence.
 * 		removeCurrent()
 * 			Removes the Node at the cursor.
 *		displayList()
 *			Displays the Linked Sequence in the console in a
 *			readable format.
 *		isCurrent()
 *			Returns whether or not the cursor is null.
 *		getCurrent()
 *			Retrieves the data of the cursor Node
 *		start()
 *			Sets the cursor to the first Node.
 *
 **/
public class LinkedSequence<T> implements Cloneable {
	
	//
	// declare instance variables to hold the data 
	// head, tail, and cursor Nodes of the Linked 
	// Sequence as well as how many Nodes are present
	// in the list
	//
	private Node<T> head; 	// holds the head of the Linked Sequence
	private Node<T> tail; 	// holds the tail of the Linked Sequence
	private Node<T> cursor; // holds the current Node of the Linked Sequence
	private int manyNodes; 	// holds the number of Nodes in the Linked Sequence

	/**
	 * 
	 * Constructs an empty Linked Sequence.
	 * 
	 **/
	public LinkedSequence() {
		// set head and tail Node's to null
		head = null;
		tail = null;
		// set the cursor to the first Node
		cursor = head;
		// set the Node count to 0
		manyNodes = 0;
	}

	/**
	 * 
	 * addAfter() first checks to see if the cursor
	 * has a Node. If so a Node with the element is
	 * added after the cursor. If not it checks
	 * to see if the Sequence is empty and if so
	 * sets the head to a new Node with the element.
	 * Else it adds the element in a new Node after
	 * the tail.
	 * 
	 **/
	public void addAfter(
			T element	// the element to add
			) {
		
		// check if cursor has a Node
		if (isCurrent()) {
			
			// add a Node with the given element
			// after the cursor
			cursor.addNodeAfter(element);
			// set the cursor the next element in
			// the list
			cursor = cursor.getLink();
		
		// else cursor does not have a Node
		} else {
			
			// check if Linked Sequence is empty
			if (manyNodes == 0) {
				
				// set the head to a new node with 
				// the specified element
				head = new Node<T>(element, null);
				// set the tail to the head
				tail = head;
			
			// else Linked Sequence is not empty
			} else {
				
				// add a Node with the given element 
				// after the tail
				tail.addNodeAfter(element);
				// set the cursor the next element in
				// the list
				tail = tail.getLink();
			}
			// set the cursor to the tail
			cursor = tail;
		}
		// increase the count of Nodes by 1
		manyNodes++;
	}

	/**
	 * addBefore() first checks to see if the Sequence
	 * is empty and if adds the new Node before the head
	 * and reassigns the head to the tail.  If the Sequence is not
	 * empty but the cursor is, the element is added 
	 * to a new Node and assigned to the head which
	 * is then assigned to the cursor.  Else the element
	 * is added to a new Node and added before the cursor.
	 * 
	 **/
	public void addBefore(
			T element	// the element to add
			) {
		
		// check to see if Sequence is empty
		if (manyNodes == 0) {
			
			// set the head to a new Node with
			// the element given and link null
			head = new Node<T>(element, null);
			// set the tail and the cursor to the head
			tail = head;
			cursor = head;
		
		// check to see if cursor is null or the
		// same as the head
		} else if (!isCurrent() || cursor == head) {
			
			// set the head to a new Node with
			// the element given and link to itself
			head = new Node<T>(element, head);
			// set the cursor to the head
			cursor = head;
		
		// else Sequence is not empty, cursor is not null,
		// and cursor does not equal the head
		} else {
			// set the cursor link to a new Node with the link
			// and data of the cursor
			cursor.setLink(new Node<T>(cursor.getData(), cursor.getLink()));
			// set the data of the cursor to the element given
			cursor.setData(element);
		}
		
		// increase the count of Nodes by 1
		manyNodes++;
	}

	/**
	 *
	 * addAll() connects a LinkedSequence to the
	 * front of this Linked Sequence and then
	 * assigns the tail to the tail of addend.
	 * 
	 **/
	public void addAll(
			LinkedSequence<T> addend	// the linked sequence to add after this linked sequence
			) {
		
		// check to make sure addend is not null
		if (addend == null) {
			// throw and exception
			throw new IllegalArgumentException("addAll: addend is null");
		}
		
		// check to make sure the Sequence is not empty
		if (addend.getManyNodes() > 0) {
			// connect the tail to the head of the addend
			tail.setLink(addend.head);
			// set the tail to the tail of the addend
			tail = addend.tail;
			// increase the count of Nodes by however
			// many Nodes were in the addend
			manyNodes += addend.getManyNodes();
		}
		
	}

	/**
	 * 
	 * advance() sets the cursor to the next Node
	 * in the Linked Sequence.
	 * 
	 **/
	public void advance() {
		
		// check to make sure cursor is not null
		if (!isCurrent()) {
			// end the method
			return;
		}
		
		// set the cursor to the next Node
		// in the Linked Sequence
		cursor = cursor.getLink();
		
	}

	/**
	 * 
	 * clone() generates a copy of this sequence.
	 * 
	 **/
	@SuppressWarnings("unchecked")
	@Override
	public Object clone() {
		
		//
		// declare local variable to hold
		// the copy of the Linked Sequence
		//
		LinkedSequence<T> answer;	// holds the clone of the Linked Sequence
		
		// try to clone the LinkedSequence
		try {
			answer = (LinkedSequence<T>) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("This class does not implement Cloneable.");
		}
		
		// return the new Linked Sequence
		return answer;
	}

	/**
	 * 
	 * concatenate() takes two Linked Sequences and 
	 * then uses the addAll() method to put them together.
	 * 
	 **/
	public static <T> LinkedSequence<T> concatenate(
			LinkedSequence<T> s1,	// the first Linked Sequence to concatenate
			LinkedSequence<T> s2	// the second Linked Sequence to concatenate
			) {
		
		//
		// declare local variable to hold
		// the concatenated version of the Linked Sequences
		//
		LinkedSequence<T> answer = new LinkedSequence<T>();	// holds concatenation of Linked Sequences
		
		// check to make sure both Sequences aren't null
		if ((s1 == null) || (s2 == null)) {
			// throw exception
			throw new IllegalArgumentException("concatenation: one argument is null");
		}
		
		// add all the elements from the first Linked Sequence
		answer.addAll(s1);
		// add all the elements from the second Linked Sequence
		answer.addAll(s2);
		
		// return the concatenated Linked Sequence
		return answer;
		
	}
	
	/**
	 * 
	 * removeCurrent() first checks to see if there is only one
	 * element in the Linked Sequence and if so sets everything 
	 * to null.  If the cursor is the same as the head 
	 * the head is moved to the next element and the
	 * cursor is set to the head.  If the cursor is
	 * the same as the tail both are set to null. Else
	 * a loop is used to find the previous element
	 * in the Linked Sequence before the cursor and
	 * is then removed.
	 * 
	 **/
	public void removeCurrent() {
		
		// check to make sure the cursor is not null
		if (!isCurrent()) {
			// throw excpetion
			throw new IllegalStateException("removeCurrent: isCurrent() is null");
			
		// check to make sure that the LinkedSequence is not null
		} else if (manyNodes == 0) {
			// throw exception
			throw new IllegalStateException("removeCurrent: list is empty");
			
		// check to see if there is only one element in the Linked Sequence
		} else if (manyNodes == 1) {
			
			// set the head, tail, and cursor to null
			head = null;
			tail = null;
			cursor = null;
		
		// check to see if the cursor is the first item
		} else if (cursor == head) {
			
			// set the head to the next item in the list
			head = head.getLink();
			// set the cursor to the head
			cursor = head;
			
		// check to see if the cursor is the last item
		} else if (cursor == tail) {
			
			// set the tail and the cursor to null
			tail = null;
			cursor = null;
		
		// else the cursor is not null and not the first
		// or last item
		} else {
			
			// temporary varriable to hold the head
			Node<T> pre = head;
			
			// loop through the sequence until we hit the cursor
			while (pre.getLink() != cursor) {
				pre = pre.getLink();
			}
			
			// check to see if the cursor is the tail
			if (cursor == tail) {
				pre.setLink(null);
				tail = pre;
				cursor = null;
			} else {
				// link the temporary varriable to the cursor
				// and then set the cursor to the tempoaray variable
				pre.setLink(cursor.getLink());
				cursor = pre;
			}
		}
		
		// decrease the count of Node's in the Linked Sequence by 1
		manyNodes--;
	}
	
	/**
	 * 
	 * displayList() writes a string representation of the 
	 * Linked Sequence to the console.
	 * 
	 **/
	public void displayList(){
		// call the head Node's toString() method
        System.out.println(head.toString());
	}

	/**
	 *
	 * isCurrent() determines whether the cursor 
	 * has a Node or not.
	 *
	 **/
	public boolean isCurrent() {
		// return whether or not the cursor is null
		return cursor != null;
	}
	
	/**
	 *
	 * getCurrent() retrieves the data of the cursor Node.
	 *
	 **/
	public T getCurrent() {
		
		// check to make sure cursor is not null
		if (!isCurrent()) {
			// throw exception
			throw new IllegalStateException("getCurrent: isCurrent() is null");
		}
		
		// return the data of the current Node
		return cursor.getData();
	}
	
	/**
	 * 
	 * start() sets the cursor to the first Node
	 * of the Linked Sequence.
	 * 
	 **/
	public void start() {
		
		// check to see if head is null
		if (head == null) {
			// set the cursor to null
			cursor = null;
		}
		
		// set the cursor to the head
		cursor = head;
	}

	// GETTERS and SETTERS

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	public Node<T> getCursor() {
		return cursor;
	}

	public void setCursor(int index) {
		if (index < 0 || index >= manyNodes) {
			throw new IllegalArgumentException("get: index: " + index + ", is out of bounds for size: " + manyNodes);
		}
		cursor = head;
		int i = 0;
		while (i != index) {
			i++;
			cursor = cursor.getLink();
		}
	}

	public int getManyNodes() {
		return manyNodes;
	}

	public void setManyNodes(int manyNodes) {
		this.manyNodes = manyNodes;
	}

}