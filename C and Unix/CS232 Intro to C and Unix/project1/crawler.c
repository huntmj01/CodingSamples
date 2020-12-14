/**
 * 
 * NAME:		    Matthew Hunt
 * PROJECT:	    P1
 * COURSE:		  CS 232
 * INSTRUCTOR:	Chen
 * DUE DATE:	  March 2, 2017 at 11:59pm
 * 
 **/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ADDR_LENGTH 1000

/*
 * a node in our linked-list of web addresses
 */
struct listNode{
  char addr[MAX_ADDR_LENGTH];

  struct listNode *next;
};

/*
 * returns 1 if the list starting at pNode contains the address addr,
 *    and returns 0 otherwise
 */
int contains(const struct listNode *pNode, const char *addr);

/*
 * inserts the address addr as a new listNode at the end of
 *    the list
 */
void insertBack(struct listNode *pNode, const char *addr);

/*
 * prints the addresses from pNode to the end of the list,
 *   one on each line
 */
void printAddresses(const struct listNode *pNode);

/*
 * frees the memory associated with this node and all subsequent nodes
 */
void destroyList(struct listNode *pNode);
  

/*
 * srcAddr should be a web address (e.g., http://www.yahoo.com).
 * link should point to an array of maxLinkLength characters.
 * getLink returns 1 if a link was found and 0 otherwise.
 * If a link was found, "link" will be filled in with the web address.
 */
int getLink(const char* srcAddr, char* link, const int maxLinkLength);



int main(int argc, char** argv){
  
  long seed;

  char startAddr[MAX_ADDR_LENGTH];
  char destAddr[MAX_ADDR_LENGTH];
  
  int hopNum, numHops;
  
  struct listNode *pListStart;

  if(argc < 3 || argc > 4){
    fprintf(stderr, "USAGE: %s startAddr numHops [rand seed]", argv[0]);
    return -1;
  }
  
  /* initialization */
  if(argc >= 4){
    seed = atol(argv[3]);
  }
  else{
    seed = time(NULL);
  }

  printf("seed = %ld\n", seed);
  srand(seed);

  strncpy(startAddr, argv[1], MAX_ADDR_LENGTH);
  startAddr[MAX_ADDR_LENGTH - 1] = '\0';

  numHops = atoi(argv[2]);

  pListStart = malloc(sizeof(struct listNode));
  if(pListStart == NULL){
    fprintf(stderr, "ERROR: could not allocate memory\n");
    return -2;
  }
  strncpy(pListStart->addr, startAddr, MAX_ADDR_LENGTH);
  pListStart->next = NULL;


  /* start the crawling */
  for(hopNum=1; hopNum <= numHops; hopNum++){
    int res = getLink(startAddr, destAddr, MAX_ADDR_LENGTH);

    if(!res){
      printf("Dead end on hop %d: no outgoing links\n", hopNum);
      break;
    }

    if(contains(pListStart, destAddr)){
      printf("Cycle detected on hop %d: address %s\n", hopNum,
	     destAddr);
      hopNum--; // try again for this hop in the next iteration
    }
    else{
      insertBack(pListStart, destAddr);
      strncpy(startAddr, destAddr, MAX_ADDR_LENGTH);
    }
  }

  printAddresses(pListStart);

  destroyList(pListStart);

  return 0;
}


/*
 * returns 1 if the list starting at pNode contains the address addr,
 *    and returns 0 otherwise
 */
int contains(const struct listNode *pNode, const char *addr){
  
  // check to see if we are at the end of the list
  if (pNode == NULL){
    // the list does not contain the address
    return 0;
  }
  
  // compare the current nodes addr to the addr
  // specifed to see if they are the same
  int result = strcmp(pNode->addr, addr);
  
  // check to see if result is 0
  if (result == 0){
    // addr's are the same so return 1
    return 1;
    
  // else result is not zero
  }else {
    // check the next node
    contains(pNode->next, addr);
  }
  
}

/*
 * inserts the address addr as a new listNode at the end of
 *    the list
 */
void insertBack(struct listNode *pNode, const char *addr){
  
  // check to see if we are at the end node
  if (pNode->next==NULL){
    
    // create a new node
    struct listNode *newNode = malloc(sizeof(struct listNode));
  
    // check to make sure there was enough room in the heap for the node
    if(newNode == NULL){
      fprintf(stderr, "ERROR: could not allocate memory\n");
      return;
    }
    
    // set the new nodes next link to null
    newNode->next = NULL;
    
    // copy the addr specified to the new nodes addr
    strncpy(newNode->addr, addr, MAX_ADDR_LENGTH);
    
    // add the new node to the end of the list
    pNode->next = newNode;    
    
  // else we are not at the end of the list
  }else{
    // go to the next node
    insertBack(pNode->next,addr);
  }
  
}


/*
 * prints the addresses from pNode to the end of the list,
 *   one on each line
 */
void printAddresses(const struct listNode *pNode){
  
  // check to make sure we are not at the end of the list
  if(pNode == NULL){
    return;
  }
  
  // print current node's addr
  printf("%s\n", pNode->addr);
  
  // go to the next node
  printAddresses(pNode->next);
  
}

/*
 * frees the memory associated with this node and all subsequent nodes
 */
void destroyList(struct listNode *pNode){
  
  // check to make sure the list is not null
  if(pNode == NULL){
    return;
  }
  
  // go to the next node and when we reach the end,
  // work our way back using recursion
  destroyList(pNode->next);
  
  // free the current node from memory
  free(pNode);
   
}

int getLink(const char* srcAddr, char* link, const int maxLinkLength){
  const int bufSize = 1000;
  char buffer[bufSize];

  int numLinks = 0;

  FILE *pipe;

  snprintf(buffer, bufSize, "curl -s \"%s\" | python getLinks.py", srcAddr);

  pipe = popen(buffer, "r");
  if(pipe == NULL){
    fprintf(stderr, "ERROR: could not open the pipe for command %s\n",
	    buffer);
    return 0;
  }

  fscanf(pipe, "%d\n", &numLinks);

  if(numLinks > 0){
    int linkNum;
    double r = (double)rand() / ((double)RAND_MAX + 1.0);

    for(linkNum=0; linkNum<numLinks; linkNum++){
      fgets(buffer, bufSize, pipe);
      
      if(r < (linkNum + 1.0) / numLinks){
		break;
      }
    }

    /* copy the address from buffer to link */
    strncpy(link, buffer, maxLinkLength);
    link[maxLinkLength-1] = '\0';
    
    /* get rid of the newline */
    {
      char* pNewline = strchr(link, '\n');
      if(pNewline != NULL){
		*pNewline = '\0';
      }
    }
  }

  pclose(pipe);

  if(numLinks > 0){
    return 1;
  }
  else{
    return 0;
  }
}