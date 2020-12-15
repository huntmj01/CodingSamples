package datastructures.project.huntmj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:		Project 2
 * COURSE:		CS260
 * INSTRUCTOR:	Petruska
 * DUE DATE:	11/10/2016
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
	public static void main(String args[]) throws FileNotFoundException{
		
		// test the small maze
		
		System.out.println("\n--small maze--");
		
		Scanner nsScan = new Scanner(new File("northSouth-small.txt"));
		Scanner ewScan = new Scanner(new File("eastWest-small.txt"));
		Queue q = new Queue(100);
		LinkedMaze lm = new LinkedMaze(ewScan.nextInt(), ewScan.nextInt(), q);
		lm.connectMaze(nsScan, ewScan);
		lm.findPath();
		System.out.println();
		lm.displayPath(lm.exit);
		
		// test the small maze that has no exit
		
		System.out.println("\n--small maze no exit--");
		
		nsScan = new Scanner(new File("northSouth-small-no-exit.txt"));
		ewScan = new Scanner(new File("eastWest-small-no-exit.txt"));
		q = new Queue(100);
		lm = new LinkedMaze(ewScan.nextInt(), ewScan.nextInt(), q);
		lm.connectMaze(nsScan, ewScan);
		lm.findPath();
		System.out.println();
		lm.displayPath(lm.exit);
		
		// test the large maze
		
		System.out.println("\n--large maze--");
		
		nsScan = new Scanner(new File("northSouth.txt"));
		ewScan = new Scanner(new File("eastWest.txt"));
		q = new Queue(100);
		lm = new LinkedMaze(ewScan.nextInt(), ewScan.nextInt(), q);
		lm.connectMaze(nsScan, ewScan);
		lm.findPath();
		System.out.println();
		lm.displayPath(lm.exit);
		
		// test the large maze that has no exit
		
		System.out.println("\n--large maze no exit--");
		
		nsScan = new Scanner(new File("northSouth-no-exit.txt"));
		ewScan = new Scanner(new File("eastWest-no-exit.txt"));
		q = new Queue(100);
		lm = new LinkedMaze(ewScan.nextInt(), ewScan.nextInt(), q);
		lm.connectMaze(nsScan, ewScan);
		lm.findPath();
		System.out.println();
		lm.displayPath(lm.exit);

	}
	
}
