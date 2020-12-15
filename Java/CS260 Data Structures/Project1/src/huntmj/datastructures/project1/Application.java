package huntmj.datastructures.project1;

import java.util.Random;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		Project 1
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	10/08/2016
 *
 * DESCRIPTION: The Application class contains the main method.
 *
 * CLASS METHODS:
 * 		main(String[] args)
 *  		The main method that runs the program.
 *  	createRectangles(int howMany, boolean doRandom)
 *  		Creates the amount of Rectangles specified.
 *  	testLinkedSequence()
 *  		Runs a series of tests on the LinkedSequence
 *  		class and then prints the results to the console.
 * 
 * INSTANCE VARIABLES:
 * 		squares
 * 			Holds the number of squares in the Linked Sequence.
 * 		occurrences
 * 			Holds the number of occurrences in the Linked Sequence
 * 			
 **/
public class Application {

	//
	// Declare two static fields of type
	// long to the application class named squares
	// and occurrences
	//
	private static long squares;		// holds the number of squares in the Linked Sequence
	private static long occurrences;	// holds the number of occurrences in the Linked Sequence
	
	public static void main(String[] args) {
		

		
		System.out.println("\n\n----BEGIN TEST NODE CLASS----\n");
		
		// call the test() from TestNode class
		TestNode.test();
		
		System.out.println("\n\n----BEGIN TEST LINKED SEQUENCE CLASS----\n");
		
		// call the testLinkedSequence()
		testLinkedSequence();
		
		System.out.println("\n\n----BEGIN RECTANGLE CREATION----\n");
		
		//
		// declare local variables to hold
		// information for the timer
		//
		long startTime, stopTime, elapsedTime;
		
		System.out.println("---100 000 Rectangles---");
		startTime = System.currentTimeMillis();
		createRectangles(100000, true);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Time (miliseconds): " + elapsedTime);
		
		// Step 6: Repeat Steps 1- 5 for 1 000 000 Rectangle objects
		System.out.println("\n---1 000 000 Rectangles---");
		startTime = System.currentTimeMillis();
		createRectangles(1000000, true);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Time (miliseconds): " + elapsedTime);
		
		// Step 7: Repeat Steps 1 – 5. 10 000 000 Rectangle objects
		System.out.println("\n---10 000 000 Rectangles---");
		startTime = System.currentTimeMillis();
		createRectangles(10000000, true);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Time (miliseconds): " + elapsedTime);
		
		// Step 8: Repeat Step 7 by adding the non-random target rectangle of step
		// 4 to the empty list 10 000 000 times. Check out if the random selection in
		// step 7 is a significant overhead for the running time of the algorithm or not
		System.out.println("\n---10 000 000 Rectangles-No Random---");
		startTime = System.currentTimeMillis();
		createRectangles(10000000, false);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Time (miliseconds): " + elapsedTime);
		
		// Analyze your running time observations, deduce Big-Oh estimates and
		// advise about the expected time for the case of 100 000 000
		// rectangles.
		// Attach your report as a comment to the source code following the
		// application class
		
		/**
		 * 
		 * Response: By analyzing the runtime of the various amounts
		 * of Rectangle creations, it appears to me that the time taken
		 * increase in a linear fashion to the amount of items being created.
		 * When running 30 million as compared to 10 million, it takes about
		 * 3 times as long.  Therefore, I conclude that by looking at the
		 * times alone this Rectangle creation is Big O(N).  Running 100 million
		 * will probably cause a memory overflow, but if not should take 10x
		 * as long as 10 million.
		 * 
		 */
		
		System.out.println("\n---30 000 000 Rectangles-No Random---");
		startTime = System.currentTimeMillis();
		createRectangles(30000000, false);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Time (miliseconds): " + elapsedTime);
		
		System.out.println("\nend");

	}

	public static void createRectangles(
			int howMany, 		// number of rectangles to create
			boolean doRandom	// whether or not to create random lengths and widths
			) {
		
		// Step 1: Create a LinkedSequence of 100 000 Rectangle objects each
		// having integer dimensions randomly selected between 1 and 30

		LinkedSequence<Rectangle> lsRectangle = new LinkedSequence<Rectangle>();

		Random randomNumbers = new Random();
		for (long i = 0; i < howMany; i++) {
			int randomLength = 0;
			int randomWidth = 0;
			Rectangle rect;
			
			if (doRandom){
				randomLength = randomNumbers.nextInt(30 - 1) + 1;
				randomWidth = randomNumbers.nextInt(30 - 1) + 1;

				rect = new Rectangle(randomLength, randomWidth);
			}else{
				rect = new Rectangle(15, 15);
			}
			

			lsRectangle.addAfter(rect);
		}

		// Step 2: Verify that the listPosition() method returns the tail
		// reference for
		// position number 100 000

		System.out.println("Step 2: " + Node.listPosition(lsRectangle.getHead(), howMany));

		// Step 3: instantiate a Rectangle array to the list length (do not use
		// literals)
		// and load the Rectangles from the list to the array
		
		int len = lsRectangle.getManyNodes();
		Rectangle[] rectArray = new Rectangle[len];
		lsRectangle.start();

		int amt = lsRectangle.getManyNodes();
		for (int i = 0; i < amt; i++) {
			rectArray[i] = new Rectangle(lsRectangle.getCursor().getData().getLength(),
					lsRectangle.getCursor().getData().getWidth());
			lsRectangle.advance();
		}

		// Step 4: Create a target Rectangle with side 15, 15 and call the
		// counting
		// method passing your array and target as parameters.

		Rectangle target = new Rectangle(15, 15);
		counting(rectArray, target);
		System.out.println("Step 4: " + squares + " squares, " + occurrences + " occurences");
		
		// Step 5: Measure the running time of each step above as well as the
				// combined time and record the results. Hint: use the method call
				// System.nanoTime() to record the current real time in nanoseconds (the
				// return type of the method is long); note that 109 nanos make one
				// second.
	}

	@SuppressWarnings("unchecked")
	public static void testLinkedSequence() {
		
		// Create short three to five long String
		// type linked list to test all the methods
		// create a head, tail, and dummy node
		Node<String> head = new Node<String>("Alpha", null);
		Node<String> tail = head.addNodeAfter("Bravo");
		Node<String> dummy = new Node<String>(null, head);

		head = dummy.addNodeAfter("Charlie");
		head = dummy.addNodeAfter("Delta");
		head = dummy.addNodeAfter("Echo");
		head = dummy.addNodeAfter("Foxtrot");

		// System.out.println(head.toString());

		LinkedSequence<String> ls1 = new LinkedSequence<String>();

		System.out.println("\n---Test start()---");
		ls1.start();

		System.out.println("\n---Test addAfter()---");
		ls1.addAfter("Gama");
		ls1.addAfter("India");
		ls1.addAfter("Juliett");
		ls1.displayList();

		System.out.println("\n---Test addBefore()---");
		ls1.addBefore("Hotel");
		ls1.displayList();
		
		System.out.println("\n---Test addAll()---");
		LinkedSequence<String> ls2 = new LinkedSequence<String>();
		ls2.addAfter("Kilo");
		ls2.addAfter("Lima");
		ls1.addAll(ls2);
		ls1.displayList();
		
		System.out.println("\n---Test advance()---");
		System.out.println(ls1.getCurrent());
		ls1.advance();
		System.out.println(ls1.getCurrent());
		
		System.out.println("\n---Test clone()---");
		ls2 = (LinkedSequence<String>) ls1.clone();
		ls2.displayList();
		
		System.out.println("\n---Test concatenate()");
		LinkedSequence<String> ls3 = new LinkedSequence<String>();
		// ls3 = LinkedSequence.concatenate(ls1, ls2);
		// ls3.displayList();
		
		System.out.println("\n---Test removeCurrent()---");
		ls1.displayList();
		ls1.start();
		ls1.removeCurrent();
		ls1.displayList();
		
		System.out.println("\n---Test isCurrent()---");
		System.out.println(ls1.isCurrent());
		
	}

	/*
	 * 
	 * Add a static void method named counting to the applications class. The
	 * method takes a Rectangle array named boxes and a Rectangle object named
	 * target for parameters.
	 * 
	 * The method counts the number of squares among the array element, and
	 * stores the value in the squares field, and it also counts the number of
	 * array elements that are equal to the target and stores the result in the
	 * occurrences field
	 */
	public static void counting(Rectangle[] boxes, Rectangle target) {
		long squr = 0;
		long ocur = 0;

		for (Rectangle r : boxes) {
			if (r.getLength() == r.getWidth()) {
				squr++;
			}
			if (r.equals(target)) {
				ocur++;
			}
		}

		squares = squr;
		occurrences = ocur;
	}

}

/**
 * 
 * Response: By analyzing the runtime of the various amounts
 * of Rectangle creations, it appears to me that the time taken
 * increase in a linear fashion to the amount of items being created.
 * When running 30 million as compared to 10 million, it takes about
 * 3 times as long.  Therefore, I conclude that by looking at the
 * times alone this Rectangle creation is Big O(N).  Running 100 million
 * will probably cause a memory overflow, but if not should take 10x
 * as long as 10 million.
 * 
 */
