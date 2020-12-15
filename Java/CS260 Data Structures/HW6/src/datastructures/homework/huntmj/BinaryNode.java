package datastructures.homework.huntmj;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		HW6
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	10/27/2016
 * 
 * DESCRIPTION: A Linked List is a sequence of elements arranged,
 * one after another, with each element connected to the next 
 * element by a link. Connecting each element with a left and 
 * right node creates a Binary Tree.
 * 
 * CLASS METHODS:
 * 		BSTFactory(int root, int depth) 
 * 			Generates and returns a BinaryTree with the size
 * 			depending on the depth specified.
 * 
 * CONSTRUCTOR METHODS:
 * 		BinaryNode(E initialData, BinaryNode<E> initialLeft, BinaryNode<E> initialRight)
 * 			Constructs a BinaryNode and sets the Node's data,
 * 			left, and right links from the parameters.
 * 
 * INSTANCE VARIABLES:
 * 		data
 * 			Holds an element of type T.
 * 		left
 * 			Holds the left child Node.
 * 		right
 * 			Holds the right child Node.
 * 
 * INSTANCE METHODS:
 * 		toString()
 * 			Returns a string representation of the BinaryNode.
 *
 **/
public class BinaryNode<E> {

	//
	// declare instance variables to hold the
	// BinaryNode's data and two children
	//
	private E data;
	private BinaryNode<E> left, right;

	public BinaryNode(
			E initialData,				// Node data
			BinaryNode<E> initialLeft,	// Left child node
			BinaryNode<E> initialRight  // Right child node
			) {
		
		data = initialData;
		left = initialLeft;
		right = initialRight;
	}

	/**
	 * 
	 * toString() concatenates the elements in the 
	 * Binary Tree into a readable string.
	 * 
	 */
	public String toString() {
		
		// keep going left until you find the left leaf
		if (left != null) {
			// make recursive call
			left.toString();
		}
		
		// print the data
		System.out.println("" + data);
		
		// keep going right until you find the right leaf
		if (right != null) {
			// make recursive call
			right.toString();
		}

		return "";

	}
	
	/**
	 * 
	 * BTSFactory() generates a Binary Search Tree.
	 * 
	 */
	public static BinaryNode<Integer> BSTFactory(
			int root, 	// value of the root
			int depth	// size of the tree
			) {
		
		//
		// declare local variables to hold right
		// and left child
		//
		BinaryNode<Integer> leftChild, rightChild;
		
		// base case depth is 0
	    if (depth==0){
	    	
	    	// return a new binary tree with only a root element
	        return new BinaryNode<Integer>(root, null, null);
	    
	    // general case depth is not zero 
	    } else {
	    	
	    	// use recursion to build the tree from the bottom up
	       leftChild=BSTFactory((int)(root-Math.pow(2,depth-1)),(int)depth-1);
	       rightChild=BSTFactory((int)(root+Math.pow(2,depth-1)),(int)depth-1);
	       
	       // return the binary tree
	       return new BinaryNode<Integer>(root,leftChild,rightChild);
	   }
	}

}




























































//public void print(int depth){
//	int i;
//	
//	// print indentation and the data from the current node:
//	for (i=1; i <= depth; i++){
//		System.out.print("  ");
//	}
//	System.out.println(data);
//	
//	// print the left subtree (or a dash if there is a right child and no left child)
//	if (left != null){
//		left.print(depth+1);
//	}else if (right!= null){
//		for (i=1; i <= depth+1; i++){
//			System.out.print("  ");
//		}
//		System.out.println("--");
//	}
//	
//	// print the right subtree (or a dash if there is a left child and no right child)
//	if (right != null){
//		right.print(depth+1);
//	}else if (left != null){
//		for (i=1; i <= depth+1; i++){
//			System.out.print("  ");
//		}
//		System.out.println("--");
//	}
//}
