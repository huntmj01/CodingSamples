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
#include <math.h>
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
	int i = 0, j=0, n = 0, hopNum = 0;                  // incrementers
	int maxHops = 0;                               // holds the max amount of hops from the file
	int totalNumOfTerms[50];
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
  i = 0;
  
  // index each link
  while(dummy!=NULL){
    // store the current nodes address
    char* temp =dummy->addr;

    // call index page and store the returned triedatastructure
    root[numOfRootNodes] = allocNewNode('\0');
    int *pTotalNumOfTerms = &totalNumOfTerms[i];
    // index the current url
    int res = indexPage(temp, root[numOfRootNodes], pTotalNumOfTerms);
    
    // printf("\n%d\n", *pTotalNumOfTerms);
    
    // increment i
    numOfRootNodes++;
    i++;
  
    // go to the next node in the list
    dummy = dummy->next;
    
  }
	
		// retrieve text from user
	printf("Enter a web query: ");
	
	// get user input
	char input[100];
	fgets(input, sizeof(input), stdin);
	input[100] = '\0';
	char *pTemp = strtok(input, "\n"); 
	printf("Query is \"%s\".\n", pTemp);
	char wordList[50][50];
	int letterNum = 0;
	int flag = 0;
	int wordNum = 0;
	
	for(i = 0; i<100; i++){         
    // check if current letter is between a and z
    if(input[i] >= 'a' && input[i] <= 'z'){
      letterNum++;
      flag = 0;
    }      
    else{
      char word[50];
      if(flag == 0){
        flag = 1;
        int k;
        for(k=0;k<(letterNum+1);k++){
          if(k<letterNum){
            word[k] = input[i-letterNum+k];
          }else{
            word[k] = '\0';
          }
        }
        // copy it to the word list
        strncpy(wordList[wordNum],word, 50);
        wordNum++;
        letterNum = 0;
      }
    }
  }

  // calculate idf of each word
	double idf[wordNum];
	double tf[wordNum];
	double sdt[wordNum];
	
	printf("IDF scores are: \n");
	
	for (i=0; i < wordNum; i++){
	  idf[i] = 0;
	}
	
	// loop through each word
  for (i = 0; i < wordNum; i++){
    int hasWord = 0;
    
    // loop through each page
    for (j = 0; j < numOfRootNodes; j++){
      if (containsStr(root[j], wordList[i])){
        hasWord++;
      }
    }
    
    if (hasWord!=0){
      double temp = (1.0 + numOfRootNodes)/(1.0 + hasWord);
      double temp2 =  (1.0*hasWord) / (1.0*totalNumOfTerms[i]);
      idf[i] = log(temp);
      tf[i] = temp2;
    }else{
      idf[i] = 0;
      tf[i] = 0;
    }
    
    for (j = 0; j < numOfRootNodes; j++){
      if (containsStr(root[j], wordList[i])){
        hasWord++;
      }
    }
    
    printf("IDF (%s): %f\n", wordList[i], idf[i]);
    // printf("TF (%s): %f\n", wordList[i], tf[i]);
  }	
  
  // loop through each page
  i = 0;
  j = 0;
  for (i = 0; i < wordNum; i++){
    // loop through each page
    for (j = 0; j < numOfRootNodes; j++){
      if (containsStr(root[j], wordList[i])){
          sdt[i] = sdt[i] + (idf[i] * tf[j]);
      }
    }
  }
  
  printf("Web pages: \n");
  
  int top = 0;
  int topIndex = 0;
  for (i=0; i < wordNum; i++){
    if (sdt[i] > top){
      top = sdt[i];
      topIndex = i;
    }
  }
  
  
  int middle = -1;
  int middleIndex = -1;
  for (i=0; i < wordNum; i++){
    if (sdt[i] > middle && i != topIndex){
      middle = sdt[i];
      middleIndex = i;
    }
  }
  
  int bottom = -1;
  int bottomIndex = -1;
  for (i=0; i < wordNum; i++){
    if (sdt[i] > bottom && i != topIndex && i != middleIndex){
      bottom = sdt[i];
      bottomIndex = i;
    }
  }
  
  // print results
  // index each link
  i = 0;
  int count = 1;
  dummy = pListStart;
  while(dummy!=NULL){
    // store the current nodes address
    char* temp =dummy->addr;
    if (i==topIndex){
      printf("%d. %s %f\n", count, temp, sdt[i]);
      count++;
    }else if (i==middleIndex){
      printf("%d. %s %f\n", count, temp, sdt[i]);
      count++;
    }else if (i==bottomIndex){
      printf("%d. %s %f\n", count, temp, sdt[i]);
      count++;
    }
    i++;
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

