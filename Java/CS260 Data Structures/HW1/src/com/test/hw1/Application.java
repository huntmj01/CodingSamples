package com.test.hw1;

/*
NAME:		Matthew Hunt
PROJECT:	HW 1
COURSE:		CS 260
INSTRUCTOR:	Petruska
DUE DATE:	September 3, 2016

DESCRIPTION:
	The Application class contains the main method.

CLASS METHODS:
  main
  	the main method that runs the program
*/

public class Application {
	
	public static void main(String[] args) {
		
		//
		// declare local variables to hold 
		// the float, integer, long, and 
		// byte arrays and average array objects
		//
		Float floatArray[] = {3.4f,2.1f,3.6f};
		Integer integerArray[] = {2,4,6};
		Long longArray[] = {12313111l,5796416873187l,84135796513549l,87674687965795l};
		Byte byteArray[] = {0b0010_0101, 0b0110_0101, 0b0010_0001};
		
		Average<Float> floatArrayAverage = new Average<Float>(floatArray); 
		Average<Integer> integerArrayAverage = new Average<Integer>(integerArray);
		Average<Long> longArrayAverage = new Average<Long>(longArray);
		Average<Byte> byteArrayAverage = new Average<Byte>(byteArray);
		
		//
		// print headers, compute average of arrays, 
		// and compare averages of each,
		// possible average array objects
		//
		System.out.println("--------------------COMPUTE AVERAGES--------------------\n");
		
		System.out.printf("%-40s%-40s\n", "Float Array Average:", floatArrayAverage.computeAverage());
		System.out.printf("%-40s%-40s\n", "Integer Array Average:", integerArrayAverage.computeAverage());
		System.out.printf("%-40s%-40s\n", "Long Array Average:", longArrayAverage.computeAverage());
		System.out.printf("%-40s%-40s\n", "Byte Array Average:", byteArrayAverage.computeAverage());
	
		System.out.println("\n--------------------COMPARE AVERAGES--------------------\n");
		
		System.out.println("---Float Array Average");
		
		System.out.printf("%-40s%-40s\n", "Equals Float Array Average:", floatArrayAverage.compareAverage(floatArrayAverage));
		System.out.printf("%-40s%-40s\n", "Equals Integer Array Average:", floatArrayAverage.compareAverage(integerArrayAverage));
		System.out.printf("%-40s%-40s\n", "Equals Long Array Average:", floatArrayAverage.compareAverage(longArrayAverage));
		System.out.printf("%-40s%-40s\n", "Equals Byte Array Average:", floatArrayAverage.compareAverage(byteArrayAverage));
		
		System.out.println("\n---Integer Array Average");
		
		System.out.printf("%-40s%-40s\n", "Equals Float Array Average:", integerArrayAverage.compareAverage(floatArrayAverage));
		System.out.printf("%-40s%-40s\n", "Equals Integer Array Average:", integerArrayAverage.compareAverage(integerArrayAverage));
		System.out.printf("%-40s%-40s\n", "Equals Long Array Average:", integerArrayAverage.compareAverage(longArrayAverage));
		System.out.printf("%-40s%-40s\n", "Equals Byte Array Average:", integerArrayAverage.compareAverage(byteArrayAverage));
		
		System.out.println("\n---Long Array Average");
		
		System.out.printf("%-40s%-40s\n", "Equals Float Array Average:", longArrayAverage.compareAverage(floatArrayAverage));
		System.out.printf("%-40s%-40s\n", "Equals Integer Array Average:", longArrayAverage.compareAverage(integerArrayAverage));
		System.out.printf("%-40s%-40s\n", "Equals Long Array Average:", longArrayAverage.compareAverage(longArrayAverage));
		System.out.printf("%-40s%-40s\n", "Equals Byte Array Average:", longArrayAverage.compareAverage(byteArrayAverage));
		
		System.out.println("\n---Byte Array Average");
		
		System.out.printf("%-40s%-40s\n", "Equals Float Array Average:", byteArrayAverage.compareAverage(floatArrayAverage));
		System.out.printf("%-40s%-40s\n", "Equals Integer Array Average:", byteArrayAverage.compareAverage(integerArrayAverage));
		System.out.printf("%-40s%-40s\n", "Equals Long Array Average:", byteArrayAverage.compareAverage(longArrayAverage));
		System.out.printf("%-40s%-40s\n", "Equals Byte Array Average:", byteArrayAverage.compareAverage(byteArrayAverage));
		
	}// end main()
	
}// end class Application
