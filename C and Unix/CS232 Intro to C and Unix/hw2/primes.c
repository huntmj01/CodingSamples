/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:	    HW 2
 * COURSE:		CS 232
 * INSTRUCTOR:	Chen
 * DUE DATE:	Jan. 26, 2017 at 1:30pm
 * 
 **/
 
#include <stdlib.h>
#include <stdio.h>
#include <math.h>

// argv: lowerBound and upperBound
int main(int argc, const char** argv){

    // declare fileds to hold the upper and lower bounds
    int lowerBound, upperBound;

    // check to make sure user passed correct parameters
    if(argc != 3){
        fprintf(stderr, "USAGE: %s lowerBound upperBound\n", argv[0]);
        return -1;
    }
    
    // retrieve the lower and upper bounds from the argv array
    lowerBound = atoi(argv[1]);
    upperBound = atoi(argv[2]);
  
    // check to make sure the lower and upper bounds are not less than 1
    if(lowerBound < 1 || upperBound < 1){
        fprintf(stderr, "ERROR: both the lowerBound (%d) and the upperBound (%d)"
	          " must be positive.\n", lowerBound, upperBound);
        return -2;
    }
  
    // loop while the lowerBound is less than or equal to the upperBound
    while(lowerBound <= upperBound){
        
        // set i to one less than the lowerBound
       int i = lowerBound - 1;
       
       // loop while i is not zero
       while (i != 0){
           
           // store whether the lowerBound is divisable by i
           int divisiable = lowerBound % i;
           
           // check if i is one
           if (i == 1){
               // the lowerBound is only divisable by one and itself
               // so print it to the console
               printf("%d\n", lowerBound);
               break;
           }
           
           // check if the lowerBound is divisable
           if (!divisiable){
               break;
           }
           
           // decrease i by one
           i--;
           
       }
       
       // increase the lowerBound by one
       lowerBound++;
        
    }

    // primes were printed successfully to the console so return 0
    return 0;
}