package huntmj.datastructures.hw4;

/**
 * NAME:		Matthew Hunt
 * PROJECT:		HW4
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	10/03/2016
 *
 * DESCRIPTION: The Application class contains the main method.
 *
 * CLASS METHODS:
 * 	main
 *  	the main method that runs the program
 **/
public class Application {

	public static void main(String[] args) {
		
		// create a head and tail node
		Node<String> head = new Node<String>("Paul", null);
		Node<String> tail = head.addNodeAfter("Saul");
		
		System.out.println("---Discovery 1---");
		
		// print the toString() of head
		System.out.println(head.toString() + "\n");
		
		System.out.println("---Discovery 1.1---");
		
		head = new Node<String>("Paul", null);
		tail = head.addNodeAfter("Raul");
		
		// call addNodeAfter several times on head
		head.addNodeAfter("mauls");
		head.addNodeAfter("Saul");
		head.addNodeAfter("Saul");
		head.addNodeAfter("mauls");
		
		// print the toString() of head
		System.out.println(head.toString());
			
		System.out.println("\n---Discovery 2---");
		
		head = new Node<String>("mauls", null);
		tail = head.addNodeAfter("Raul");
		
		// create a dummy node
		Node<String> dummy = new Node<String>(null, head);
		
		// call addNodeAfter several times on dummy
		// and assign the node to head
		head = dummy.addNodeAfter("Saul");
		head = dummy.addNodeAfter("Saul");
		head = dummy.addNodeAfter("mauls");
		head = dummy.addNodeAfter("Paul");
		head = dummy.addNodeAfter("Paul");
		head = dummy.addNodeAfter("mauls");
		head = dummy.addNodeAfter("Raul");
		head = dummy.addNodeAfter(null);
		
		// print the toString() of head
		System.out.println(head.toString());
	}

}

