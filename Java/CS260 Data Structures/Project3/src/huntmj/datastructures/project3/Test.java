package huntmj.datastructures.project3;

import java.util.Random;
/**
* 
* NAME: 		Matthew Hunt
* PROJECT:		Project 3 
* COURSE: 		CS260 
* INSTRUCTOR:	Petruska 
* DUE DATE:		12/12/2016
* 
* DESCRIPTION: Test tests the algorithms from the sorting class.
* 
* CLASS METHODS:
* 		randomData()
* 			populates the data field with
*	 		random integers with the length 
*			specified.
*	 	displayArray()
*	 		displays the data field array to
*	 		the console.
*		displayList()
*			displays the list field to the 
*			console.
*
* INSTANCE VARIABLES: 
* 		data
* 			holds the numbers in an array
* 		head
* 			holds the reference to the head node of
* 			a linked list
* 		TOP
* 			named constant
* 
* INSTANCE METHODS: 
* 		testSort()
* 			tests all the sorting algorithms.
*
**/
public class Test {

	//
	// declare fields to store the numbers in an array,
	// the reference to the head node of a linked list
	// stores the numbers, and a constant
	//
	int[] data; // holds the numbers in an array
	Node<Integer> head; // holds the reference to the head node of a linked list
						// that stores the numbers
	final int TOP = 12000000; // named constant
	
	/**
	 * 
	 * randomData() populates the data field with
	 * random integers with the length specified.
	 * 
	 */
	private void randomData(int length) {
		// instatiate data array
		data = new int[length];
		head = new Node<Integer>(0, null);

		Random rand = new Random();
		int i, element;
		
		// fill array with integers randomly from 0 <= x < TOP
		for (i = 0; i < length - 1; i++) {
			element = rand.nextInt(TOP);
			data[i] = element;
			head.addNodeAfter(element);
		}

	}
	
	/**
	 * 
	 * displayArray() displays the data field array
	 * to the console.
	 * 
	 */
	private void displayArray(){
		if (data.length < 200){
			for(int i = 0; i < data.length; i++){
				System.out.println("data[" + i + "]" +"= " + data[i]);
			}
		}else{
			int size = data.length/50;
			for(int i = 0; i < data.length; i++){
				if (i % size == 0){
					System.out.println("data[" + i + "]" +"= " + data[i]);
				}
			}
		}
	}
	
	/**
	 * 
	 * displayList() displays the list field
	 * to the console.
	 * 
	 */
	public void displayList(){
		int len = Node.listLength(head);
		if (len < 200){
			System.out.println(head.toString());
		}else{
			int size = Node.listLength(head)/50;
			for(int i = 0; i < data.length; i++){
				if (i % size == 0){
					System.out.println("data: " + head.data);
					System.out.print("link: ");
				}
				head = head.link;
			}
			System.out.println("null in tail!");
		}
	}

	public void testArrayInsertionSort() {

		System.out.println("----TEST ARRAY INSERTION SORT----");

		// phase 1
		
		System.out.println("\nPhase 1\n");

		data = new int[0];
		Sortings.insertionSort(data);
		System.out.println("Array is empty (should display nothing): ");
		displayArray();
		
		data = new int[1];
		data[0] = 1;
		Sortings.insertionSort(data);
		System.out.println("Array has one element (should display data[0] = 1): ");
		displayArray();
		
		data = new int[2];
		data[0] = 1;
		data[1] = 0;
		Sortings.insertionSort(data);
		System.out.println("Array has two elements (should display data[0] = 0 and data[1]): ");
		displayArray();
		
		data = new int[10];
		data[0] = 52;
		data[1] = 21;
		data[2] = 78;
		data[3] = 37;
		data[4] = 96;
		data[5] = 45;
		data[6] = 15;
		data[7] = 3;
		data[8] = 33;
		data[9] = 1;
		Sortings.insertionSort(data);
		System.out.println("Array has 10 elements (numbers should be in order): ");
		displayArray();
		
		System.out.println("\nPhase 2");

		long startTime, stopTime, elapsedTime;

		randomData(20);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 20 (miliseconds): " + elapsedTime);
		displayArray();
		
		randomData(5000);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 5000 (miliseconds): " + elapsedTime);
		displayArray();
		
		randomData(10000);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 10000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(20000);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 20000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(40000);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 40000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(80000);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 80000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(160000);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 160000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(320000);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 320000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(640000);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 640000 (miliseconds): " + elapsedTime);
		displayArray();
//
		// the rest take to long to execute
		
//		randomData(1280000);
//		startTime = System.currentTimeMillis();
//		Sortings.insertionSort(data);
//		stopTime = System.currentTimeMillis();
//		elapsedTime = stopTime - startTime;
//		System.out.println("\nTime for length 1280000 (miliseconds): " + elapsedTime);
//		
//		displayArray();
//
//		randomData(2560000);
//		startTime = System.currentTimeMillis();
//		Sortings.insertionSort(data);
//		stopTime = System.currentTimeMillis();
//		elapsedTime = stopTime - startTime;
//		System.out.println("\nTime for length 2560000 (miliseconds): " + elapsedTime);
//		
//		displayArray();
//
//		randomData(5120000);
//		startTime = System.currentTimeMillis();
//		Sortings.insertionSort(data);
//		stopTime = System.currentTimeMillis();
//		elapsedTime = stopTime - startTime;
//		System.out.println("\nTime for length 5120000 (miliseconds): " + elapsedTime);
//		
//		displayArray();
//
//		randomData(10240000);
//		startTime = System.currentTimeMillis();
//		Sortings.insertionSort(data);
//		stopTime = System.currentTimeMillis();
//		elapsedTime = stopTime - startTime;
//		System.out.println("\nTime for length 10240000 (miliseconds): " + elapsedTime);
//		
//		displayArray();
	}
	
	public void testLinkedListInsertionSort() {

		System.out.println("----TEST LINKED LIST INSERTION SORT----");

		// phase 1
		
		System.out.println("\nPhase 1");

		head = new Node<Integer>(null, null); // test boundry cases
		Sortings.insertionSort(head);
		System.out.println("\nLinked list is empty (should display null in tail): ");
		displayList();

		head = new Node<Integer>(0, null);
		Sortings.insertionSort(head);
		System.out.println("\nLinked list has one Node (should display 0 and null in tail): ");
		displayList();

		head = new Node<Integer>(1, null);
		head.addNodeAfter(0);
		Sortings.insertionSort(head);
		System.out.println("\nLinked list has two Nodes (should display 0, 1, and null in tail): ");
		displayList();

		head = new Node<Integer>(0, null);
		head.addNodeAfter(52);
		head.addNodeAfter(21);
		head.addNodeAfter(78);
		head.addNodeAfter(37);
		head.addNodeAfter(96);
		head.addNodeAfter(45);
		head.addNodeAfter(15);
		head.addNodeAfter(3);
		head.addNodeAfter(33);
		head.addNodeAfter(1);
		Sortings.insertionSort(head);
		System.out.println("\nLinked list with 20 elements (should display list in order): ");
		displayList();

		System.out.println("\nPhase 2\n");

		long startTime, stopTime, elapsedTime;

		randomData(20);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Time for length 20 (miliseconds): " + elapsedTime);
		displayList();
		
		randomData(5000);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 5000 (miliseconds): " + elapsedTime);
		displayList();

		randomData(10000);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 10000 (miliseconds): " + elapsedTime);
		displayList();

		randomData(20000);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 20000 (miliseconds): " + elapsedTime);
		displayList();
		
		randomData(40000);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 40000 (miliseconds): " + elapsedTime);
		displayList();
		
		randomData(80000);
		startTime = System.currentTimeMillis();
		Sortings.insertionSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 80000 (miliseconds): " + elapsedTime);
		displayList();
		
		//
		// the rest take to long to execute
//		randomData(160000);
//		startTime = System.currentTimeMillis();
//		Sortings.insertionSort(head);
//		stopTime = System.currentTimeMillis();
//		elapsedTime = stopTime - startTime;
//		System.out.println("\nTime for length 160000 (miliseconds): " + elapsedTime);
//		displayList();
//		
//		randomData(320000);
//		startTime = System.currentTimeMillis();
//		Sortings.insertionSort(head);
//		stopTime = System.currentTimeMillis();
//		elapsedTime = stopTime - startTime;
//		System.out.println("\nTime for length 320000 (miliseconds): " + elapsedTime);
//		displayList();
//
//		randomData(640000);
//		startTime = System.currentTimeMillis();
//		Sortings.insertionSort(head);
//		stopTime = System.currentTimeMillis();
//		elapsedTime = stopTime - startTime;
//		System.out.println("\nTime for length 640000 (miliseconds): " + elapsedTime);
//		displayList();
//		
//		randomData(1280000);
//		startTime = System.currentTimeMillis();
//		Sortings.insertionSort(head);
//		stopTime = System.currentTimeMillis();
//		elapsedTime = stopTime - startTime;
//		System.out.println("\nTime for length 1280000 (miliseconds): " + elapsedTime);
//		displayList();
//		
//		randomData(2560000);
//		startTime = System.currentTimeMillis();
//		Sortings.insertionSort(head);
//		stopTime = System.currentTimeMillis();
//		elapsedTime = stopTime - startTime;
//		System.out.println("\nTime for length 2560000 (miliseconds): " + elapsedTime);
//		displayList();
//		
//		randomData(5120000);
//		startTime = System.currentTimeMillis();
//		Sortings.insertionSort(head);
//		stopTime = System.currentTimeMillis();
//		elapsedTime = stopTime - startTime;
//		System.out.println("\nTime for length 5120000 (miliseconds): " + elapsedTime);
//		displayList();
//		
//		randomData(10240000);
//		startTime = System.currentTimeMillis();
//		Sortings.insertionSort(head);
//		stopTime = System.currentTimeMillis();
//		elapsedTime = stopTime - startTime;
//		System.out.println("\nTime for length 10240000 (miliseconds): " + elapsedTime);
//		displayList();
			
	}

	public void testArrayMergeSort() {

		System.out.println("----TEST ARRAY MERGE SORT----");

		// phase 1
		System.out.println("\nPhase 1");

		data = new int[0]; 
		Sortings.mergeSort(data, 0, 0);
		System.out.println("\nArray with no elements (should display nothing): ");
		displayArray();
		
		data = new int[1];
		data[0] = 1;
		Sortings.mergeSort(data, 0, 0);
		System.out.println("\nArray with one element (should display data[0] = 0): ");
		displayArray();

		data = new int[2];
		data[0] = 1;
		data[1] = 0;
		Sortings.mergeSort(data, 0, 0);
		System.out.println("\nArray with two elements (should display data[0] = 0 and data[1] = 1): ");
		displayArray();

		data = new int[10];
		data[0] = 52;
		data[1] = 21;
		data[2] = 78;
		data[3] = 37;
		data[4] = 96;
		data[5] = 45;
		data[6] = 15;
		data[7] = 3;
		data[8] = 33;
		data[9] = 1;
		Sortings.mergeSort(data, 0, data.length);
		System.out.println("\nArray with 20 elements (should display numbers in order): ");
		displayArray();

		System.out.println("\nPhase 2");

		long startTime, stopTime, elapsedTime;

		randomData(20);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(data, 0, data.length);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 20 (miliseconds): " + elapsedTime);
		displayArray();
		
		randomData(5000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(data, 0, data.length);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 5000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(10000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(data, 0, data.length);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 10000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(20000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(data, 0, data.length);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 20000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(40000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(data, 0, data.length);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 40000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(80000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(data, 0, data.length);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 80000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(160000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(data, 0, data.length);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 160000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(320000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(data, 0, data.length);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 320000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(640000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(data, 0, data.length);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 640000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(1280000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(data, 0, data.length);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 1280000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(2560000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(data, 0, data.length);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 2560000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(5120000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(data, 0, data.length);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 5120000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(10240000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(data, 0, data.length);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 10240000 (miliseconds): " + elapsedTime);
		displayArray();

	}
	
	public void testLinkedListMergeSort(){
		
		System.out.println("----TEST LINKED LIST MERGE SORT----");
		
		// phase 1
		
		System.out.println("\nPhase 1");

		head = new Node<Integer>(null, null); 
		Sortings.mergeSort(head);
		System.out.println("\nLinked list is empty (should display null in tail): ");
		displayList();

		head = new Node<Integer>(0, null);
		Sortings.mergeSort(head);
		System.out.println("\nLinked list has one Node (should display 0 and null in tail): ");
		displayList();

		head = new Node<Integer>(1, null);
		head.addNodeAfter(0);
		Sortings.mergeSort(head);
		System.out.println("\nLinked list has two Nodes (should display 0, 1, and null in tail): ");
		displayList();

		head = new Node<Integer>(0, null);
		head.addNodeAfter(52);
		head.addNodeAfter(21);
		head.addNodeAfter(78);
		head.addNodeAfter(37);
		head.addNodeAfter(96);
		head.addNodeAfter(45);
		head.addNodeAfter(15);
		head.addNodeAfter(3);
		head.addNodeAfter(33);
		head.addNodeAfter(1);
		Sortings.mergeSort(head);
		System.out.println("\nLinked list with 20 elements (should display list in order): ");
		displayList();
		
		System.out.println("\nPhase 2");

		long startTime, stopTime, elapsedTime;

		randomData(20);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 20 (miliseconds): " + elapsedTime);
		displayList();

		randomData(5000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 5000 (miliseconds): " + elapsedTime);
		displayList();
		
		randomData(10000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 10000 (miliseconds): " + elapsedTime);
		displayList();

		randomData(20000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 20000 (miliseconds): " + elapsedTime);
		displayList();
		
		randomData(40000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 40000 (miliseconds): " + elapsedTime);
		displayList();
		
		randomData(80000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 80000 (miliseconds): " + elapsedTime);
		displayList();
		
		randomData(160000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 160000 (miliseconds): " + elapsedTime);
		displayList();
		
		randomData(320000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 320000 (miliseconds): " + elapsedTime);
		displayList();
		
		randomData(640000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 640000 (miliseconds): " + elapsedTime);
		displayList();
		
		randomData(1280000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 1280000 (miliseconds): " + elapsedTime);
		displayList();

		randomData(2560000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 2560000 (miliseconds): " + elapsedTime);
		displayList();

		randomData(5120000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 5120000 (miliseconds): " + elapsedTime);
		displayList();

		randomData(10240000);
		startTime = System.currentTimeMillis();
		Sortings.mergeSort(head);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 10240000 (miliseconds): " + elapsedTime);
		displayList();
	}
	
	public void testHeapSort(){
		
		System.out.println("----TEST ARRAY HEAP SORT----");

		// phase 1
		
		System.out.println("\nPhase 1\n");

		data = new int[0];
		Sortings.heapsort(data);
		System.out.println("Array is empty (should display nothing): ");
		displayArray();
		
		data = new int[1];
		data[0] = 1;
		Sortings.heapsort(data);
		System.out.println("Array has one element (should display data[0] = 1): ");
		displayArray();
		
		data = new int[2];
		data[0] = 1;
		data[1] = 0;
		Sortings.heapsort(data);
		System.out.println("Array has two elements (should display data[0] = 0 and data[1]): ");
		displayArray();
		
		data = new int[10];
		data[0] = 52;
		data[1] = 21;
		data[2] = 78;
		data[3] = 37;
		data[4] = 96;
		data[5] = 45;
		data[6] = 15;
		data[7] = 3;
		data[8] = 33;
		data[9] = 1;
		Sortings.heapsort(data);
		System.out.println("Array has 10 elements (numbers should be in order): ");
		displayArray();
		
		// phase 2
		
		System.out.println("\nPhase 2");

		long startTime, stopTime, elapsedTime;

		randomData(20);
		startTime = System.currentTimeMillis();
		Sortings.heapsort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 20 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(5000);
		startTime = System.currentTimeMillis();
		Sortings.heapsort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 5000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(10000);
		startTime = System.currentTimeMillis();
		Sortings.heapsort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 10000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(20000);
		startTime = System.currentTimeMillis();
		Sortings.heapsort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 20000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(40000);
		startTime = System.currentTimeMillis();
		Sortings.heapsort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 40000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(80000);
		startTime = System.currentTimeMillis();
		Sortings.heapsort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 80000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(160000);
		startTime = System.currentTimeMillis();
		Sortings.heapsort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 160000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(320000);
		startTime = System.currentTimeMillis();
		Sortings.heapsort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 320000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(640000);
		startTime = System.currentTimeMillis();
		Sortings.heapsort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 640000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(1280000);
		startTime = System.currentTimeMillis();
		Sortings.heapsort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 1280000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(2560000);
		startTime = System.currentTimeMillis();
		Sortings.heapsort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 2560000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(5120000);
		startTime = System.currentTimeMillis();
		Sortings.heapsort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 5120000 (miliseconds): " + elapsedTime);
		displayArray();

		randomData(10240000);
		startTime = System.currentTimeMillis();
		Sortings.heapsort(data);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nTime for length 10240000 (miliseconds): " + elapsedTime);
		displayArray();

		
	}
	
}
