package datastructures.homework.huntmj;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		HW6
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	10/27/2016
 *
 * DESCRIPTION: The Application class contains the main method.
 *
 * CLASS METHODS:
 * 		main(String[] args)
 *  		The main method that runs the program.
 * 			
 **/
public class Application {
	
	/**
	 * 
	 * main() where the magic happens.
	 *
	 **/
	public static void main(String args[]) {
		
		//
		// declare variable to hold the root
		// of the binary tree
		//
		BinaryNode<Integer> root;	// root of BinaryTree
		
		// print header
		System.out.println("\n\n-------BSTFactory()------\n");
		
		// test BSTFactory() with depth 0
		System.out.println("\n------Depth 0------");
		root = BinaryNode.BSTFactory(100,0);		
		root.toString();
		
		// test BSTFactory() with depth 1
		System.out.println("\n------Depth 1------");
		root = BinaryNode.BSTFactory(100,1);		
		root.toString();
		
		// test BSTFactory() with depth 2
		System.out.println("\n------Depth 2------");
		root = BinaryNode.BSTFactory(100,2);		
		root.toString();
		
		// test BSTFactory() with depth 3
		System.out.println("\n------Depth 3------");
		root = BinaryNode.BSTFactory(100,3);		
		root.toString();
		
		// test BSTFactory() with depth 4
		System.out.println("\n------Depth 4------");
		root = BinaryNode.BSTFactory(100,4);		
		root.toString();
		
		// test BSTFactory() with depth 5
		System.out.println("\n------Depth 5------");
		root = BinaryNode.BSTFactory(100,5);		
		root.toString();
		
		
		//
		// declare variables to hold the head and tail
		// of the linked list
		//
		SimpleNode<String> head;	// head of linked list
		SimpleNode<String> tail;	// tail of linked list
		
		// print header
		System.out.println("\n\n-------reverse()------\n");
		
		// test reverse() with list size 0
		System.out.println("\n-------list size of 0------\n");
		head = new SimpleNode<String>(null, null);
		System.out.println("---Before: \n" + head.toString());
		System.out.println("---After: \n" + SimpleNode.reverse(head));
		
		// test reverse() with list size 1
		System.out.println("\n-------list size of 1------\n");
		head = new SimpleNode<String>("a", null);
		System.out.println("---Before: \n" + head.toString());
		System.out.println("---After: \n" + SimpleNode.reverse(head));
		
		// test reverse() with list size 5
		System.out.println("\n-------list size of 5------\n");
		tail = new SimpleNode<String>("e", null);
		head = new SimpleNode<String>("a", tail);
		head.addNodeAfter("d");
		head.addNodeAfter("c");
		head.addNodeAfter("b");
		System.out.println("---Before: \n" + head.toString());
		System.out.println("---After: \n" + SimpleNode.reverse(head));
		
		// test reverse() with list size 10
		System.out.println("\n-------list size of 10------\n");
		tail = new SimpleNode<String>("j", null);
		head = new SimpleNode<String>("a", tail);
		head.addNodeAfter("i");
		head.addNodeAfter("h");
		head.addNodeAfter("g");
		head.addNodeAfter("f");
		head.addNodeAfter("e");
		head.addNodeAfter("d");
		head.addNodeAfter("c");
		head.addNodeAfter("b");
		System.out.println("---Before: \n" + head.toString());
		System.out.println("---After: \n" + SimpleNode.reverse(head));
		

	}
}
