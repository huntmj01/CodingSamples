package datastructures.homework.huntmj;

import java.util.EmptyStackException;

/**
 * 
 * NAME: 		Matthew Hunt
 * PROJECT: 	Project 1 
 * COURSE: 		CS260 
 * INSTRUCTOR: 	Petruska 
 * DUE DATE: 	10/19/2016
 * 
 * DESCRIPTION: A LinkedStack uses a linked list
 * to create a stack.
 * 
 * CONSTRUCTOR METHODS: 
 * 		LinkedStack()
 * 			Constructs and empty Linked Stack.
 * 
 * INSTANCE VARIABLES: 
 * 		top
 * 			Holds the top element of the stack.
 * 
 * INSTANCE METHODS: 
 * 		clone()
 * 			Copies this Linked Stack.
 * 		isEmpty()
 * 			Determines whether Stack is empty or not.
 * 		peek() 
 * 			Retrieves the top element on the Stack.
 * 		pop()
 * 			Removes the top element on the Stack.
 * 		push()
 * 			Places an element on the top of a Stack.
 * 		size()
 * 			Calculates the size of the Stack.
 * 
 **/
public class LinkedStack<E> implements Cloneable {
	
	//
	// declare instance variables to hold
	// the top of the stack
	//
	private Node<E> top;	// holds the top of the stack
	
	/**
	 * 
	 * Constructs an empty Linked Stack.
	 * 
	 **/
	public LinkedStack(){
		// set the top of the stack to null
		top = null;
	}
	 
	/**
	 * 
	 * clone() generates a copy of this Stack.
	 * 
	 **/
	@SuppressWarnings("unchecked")
	public LinkedStack<E> clone(){
		
		//
		// declare local variable to hold
		// the copy of the Linked Stack
		//
		LinkedStack<E> answer;	// holds copy of Linked Stack
		
		// try to clone the LinkedStack
		try{
			answer = (LinkedStack<E>) super.clone();
		}catch (CloneNotSupportedException e){
			throw new RuntimeException("This class does not implement Cloneable.");
		}
		
		// set the top of the stack to the top of
		// this stack
		answer.top = Node.listCopy(top);
		
		// return the copied Stack
		return answer;
		
	}
	
	/**
	 * 
	 * isEmpty() returns whether or not the
	 * Stack is empty.
	 * 
	 **/
	public boolean isEmpty(){
		
		// return whether or not the top is null
		return (top == null);
		
	}
	
	/**
	 * 
	 * peek() retrieves the top of the Stack
	 * and returns its data.
	 * 
	 */
	public E peek(){
		
		// check to see if the top of the 
		// Stack is null
		if (top == null){
			// throw exception
			throw new EmptyStackException();
		}
		
		// return the top of the Stacks data
		return top.getData();
		
	}
	
	/**
	 * 
	 * pop() removes the top element from
	 * the Stack.
	 * 
	 **/
	public E pop(){
		
		//
		// declare local variable to hold
		// the top element of the stack
		//
		E answer;
		
		// check to see if the top of the 
		// Stack is null
		if (top == null){
			throw new EmptyStackException();
		}
		
		// retrieve the tops data and store
		// it in answer
		answer = top.getData();
		
		// move to the next element in the Stack
		top = top.getLink();
		
		// return the top of the Stack
		return answer;
		
	}
	
	/**
	 * 
	 * push() adds an item to the top 
	 * of the list.
	 * 
	 **/
	public void push(
			E item	// the item to be added to the top of the stack
			){
		
		// creates a new Node and adds it before the top
		// making it the new top
		top = new Node<E>(item, top);
		
	}
	
	/**
	 * 
	 * size() retrieves the the size of the Stack.
	 * 
	 **/
	public int size(){
		// return the size of the Stack
		return Node.listLength(top);
	}
}
