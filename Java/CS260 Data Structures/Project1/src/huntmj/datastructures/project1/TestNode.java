package huntmj.datastructures.project1;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		Project 1
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	10/08/2016
 *
 * DESCRIPTION: The TestNode class runs a series of tests
 * on the Node class.
 *
 * CLASS METHODS:
 * 		test()
 *  		Runs a series of tests on the Node class 
 *  		and then prints the results.
 *  
 **/
public class TestNode {
	
	/**
	 * 
	 * test() calls all the methods in the 
 	 * Node class and then prints the results.
	 * 
	 */
	public static void test(){
		
		System.out.println("---Test Constructor---");
		
		// create a head, tail, and dummy node
		Node<String> head = new Node<String>("1", null);
		Node<String> tail = head.addNodeAfter("2");
		Node<String> dummy = new Node<String>(null, head);
		
		// print toString() of head
		System.out.println(head.toString());
		
		System.out.println("\n---Test addNodeAfter()---");
		
		// uses dummy node to add Node after head
		head = dummy.addNodeAfter("3");
		// print toString() of head
		System.out.println(head.toString());
		
		System.out.println("\n---Test removeNodeAfter()---");
		
		head.removeNodeAfter();
		// print toString() of head
		System.out.println(head.toString());
		
		System.out.println("\n---Test listCopy()---");
		
		// reset dummy and copy the linked list into it
		dummy = null;
		dummy = Node.listCopy(head);
		
		// print toString() of head
		System.out.println(head.toString());
		// print toString() of dummy
		System.out.println(dummy.toString());
		
		System.out.println("\n---Test listPosition()---");
		
		// prints the element at position one in the linked list
		System.out.println(Node.listPosition(head, 1).getData());
		// prints the element at position two in the linked list
		System.out.println(Node.listPosition(head, 2).getData());
		
		System.out.println("\n---Test listLength()---");
		
		// print list length of the linked list
		System.out.println(Node.listLength(head));
		
		System.out.println("\n---Test getTail()---");
		
		// prints the tail of the linked list
		System.out.println(Node.getTail(head).getData());
		
	}
}
