/**
 * 
 * NAME:		    Matthew Hunt
 * PROJECT:	    P3
 * COURSE:		  CS 232
 * INSTRUCTOR:	Chen
 * DUE DATE:	  April 10, 2017 at 11:59pm
 * 
 **/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "crawler.h"
#include "indexPage.h"

int main(int argc, char** argv){
  
  // check command line args
 	if(argc != 4){
	  // print error message
		fprintf(stderr, "USAGE: %s file max seed\n", argv[0]);
  
  	// exit program
  	return -1;
  }

  // store args
	const char* fileName = argv[1];
	const int maxNumOfPages = atoi(argv[2]);
	const long seed = strtol(argv[3], NULL,10);
	
	// declare local variables
	char buffer[MAX_BUFF_SIZE];                    // buffer to pass to indexPage
	char url[MAX_ADDR_LENGTH];                     // holds the url
	char startAddr[MAX_ADDR_LENGTH];               // 
  char destAddr[MAX_ADDR_LENGTH];
	struct trieNode *root[maxNumOfPages];          // the roots of the trie data strucutres of the indexed pages
	struct listNode *pListStart = NULL;            // the list of urls retrieved by the crawler
	struct listNode *dummy;
	int i = 0, n = 0, hopNum = 0;                  // incrementers
	int maxHops = 0;                               // holds the max amount of hops from the file
	int numOfRootNodes = 0;                        // holds the amount of root nodes created
	FILE *fp = fopen(fileName, "r");               // holds file with urls
	
	// check to make sure file was found
	if(fp == NULL){
		fprintf(stderr, "Could not open file (%s)\n", fileName);
		return -1;
	}
	
	// randomize the seed
	srand(seed);
  
  startAddr[MAX_ADDR_LENGTH - 1] = '\0';

	printf("Indexing...\n");
	
	// loop through urls in text file
	while (fscanf(fp, "%s %d\n", url, &maxHops)!=EOF && n < maxNumOfPages) {
	    
	    if (pListStart == NULL) {
	      // allocate memory for the linked list
        pListStart = malloc(sizeof(struct listNode));
        
        // check to make sure memory was allocated
        if(pListStart == NULL){
          fprintf(stderr, "ERROR: could not allocate memory\n");
          return -2;
        }
        
        // copy the addr specified to the new nodes addr
        strncpy(pListStart->addr, url, MAX_ADDR_LENGTH);
        pListStart->next = NULL;
	    }
	    else {
	      // insert the current url into the linked urls
	      insertBack(pListStart, url);
	    }

      /* start the crawling */
      for(hopNum=1; hopNum <= maxHops; hopNum++){
        
        // retrieve the link
        int res = getLink(url, destAddr, MAX_ADDR_LENGTH);
      
        // check to see if dead end
        if(!res){
          break;
        }
      
        // check to make sure link is not already in list
        if(!contains(pListStart, destAddr)) {
          // add link to list
          insertBack(pListStart, destAddr);
          // copy the dest address to the start address
          strncpy(startAddr, destAddr, MAX_ADDR_LENGTH);
        }
      }
      
	}
	
	// have the dummy point to the start of the list
	dummy = pListStart;

  // index each link
  while(dummy!=NULL){
    // store the current nodes address
    char* temp =dummy->addr;

    // call index page and store the returned triedatastructure
    root[numOfRootNodes] = allocNewNode('\0');
    
    // index the current url
    int res = indexPage(temp, root[numOfRootNodes]);
    
    // increment i
    numOfRootNodes++;
  
    // go to the next node in the list
    dummy = dummy->next;
    
  }
	
	// close the file
	fclose(fp);
  
	// free the trieDataStructures
	for (i=0; i < numOfRootNodes; i++){
	  freeTrieMemory(root[i]); 
	}
	
	// destroy the linked list
	destroyList(pListStart);
	
	return 0;
}

