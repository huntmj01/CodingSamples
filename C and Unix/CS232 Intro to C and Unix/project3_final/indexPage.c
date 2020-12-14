/**
 * 
 * NAME:		    Matthew Hunt and Isaac Harter
 * PROJECT:	    P2
 * COURSE:		  CS 232
 * INSTRUCTOR:	Chen
 * DUE DATE:	  March 28, 2017 at 11:59pm
 * 
 **/

/* This program indexes a web page, printing out the counts of words on that page */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#define NUM_OF_LETTERS 26   // the number of letters in the alphabet
#define MAX_BUFF_SIZE 300000  // the max allowed size of the buffer

struct trieNode {
  int wordCount;                          // Count the number of occurrences of the word for this node.
  char letter;                            // Indicate the letter that will represent this node.
  struct trieNode *child[NUM_OF_LETTERS]; // Each node can have up to NUM_OF_LETTERS children.
  struct trieNode *prev;                  // Refer to the previous node in the trie structure.
};

// definitions
int indexPage(const char *url, struct trieNode *root, int *pTotalNumTerms);
int addWordOccurrence(const char* word, const int wordLength,  struct trieNode *root);
struct trieNode* insertLetter(char letter, struct trieNode *root);
int printTrieContents(struct trieNode *root);
int traverseUpTrie(struct trieNode *root);
int freeTrieMemory(struct trieNode *root);
struct trieNode *allocNewNode(char newChar);
int containsStr(struct trieNode *root, const char *str);
int getText(const char* srcAddr, char* buffer);

/**
 * 
 * indexPage() calls getText() to retrieve text from webpage,
 * loops through the buffer, adds each word to a matrix,
 * passes each word to the addWordOccurrence method, and
 * then prints each word to the console.
 * 
 **/ 
int indexPage(const char *url, struct trieNode *root, int *pTotalNumTerms) {
  
  char buffer[MAX_BUFF_SIZE];
  int bytesRead = 0;
  int i;
  int wordNum = 0;
  int letterNum = 0;
  int flag = 0;
  // call get text to store text from url page in buffer
  // then store the amount of bytesRead
  bytesRead = getText(url, buffer);
  
  // print the url
  printf("%s\n", url);

  // loop through the important part of the buffer 
  // and change any uppercase characters to lowercase characters
  for(i = 0; i<bytesRead; i++){
    if(buffer[i] >= 'A' && buffer[i] <= 'Z'){
      buffer[i] = buffer[i] + 32;
    }
  }

  // loop through each byte read
  for(i = 0; i<bytesRead; i++){         
    // check if current letter is between a and z
    if(buffer[i] >= 'a' && buffer[i] <= 'z'){
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
            word[k] = buffer[i-letterNum+k];
          }else{
            word[k] = '\0';
          }
        }
        // print the current word
        printf("\t%s\n", word);
        // add it to the trie
        addWordOccurrence(word, strlen(word), root);
        wordNum++;
        letterNum = 0;
      }
    }
  }
  *pTotalNumTerms = wordNum;
  return 0;
}

/**
 * 
 * addWordOccurrence() adds a word to the trie data structure.
 * 
 **/ 
int addWordOccurrence(const char* word, const int wordLength, struct trieNode *root)
{
  
  // declare local variables
  int i = 0;                    
  char temp;                      // stores a char
  struct trieNode *dummy = root;  // holds link to the newly created node
  
  // loop through each letter in the word
  while(word[i]!='\0'){
    
    // store the current letter in temp
    temp = word[i];
    
    // insert the letter into the trie data strucutre
    // then have dummy point to the new node
    dummy = insertLetter(temp, dummy);
    
    // check to make sure dummy was added
    if (dummy == NULL){
      // print error message
      fprintf(stderr,"ERR: NODE WITH LETTER %c NOT ADDED. DUMMY IS NULL.\n", temp);
      // return error
      return -1;   
    } 
    
    // increase i by one
    i++;
  } 
  
  //increase the bottom letters word count by one
  dummy->wordCount = dummy->wordCount+1;
  
  // return success
  return 0;
}

/**
 *
 * insertLetter() adds a letter to the trie data structure.
 * 
 **/
struct trieNode* insertLetter(char letterToInsert, struct trieNode *root){
  
  // declare local variables
  int i = 0;
  struct trieNode *newNode; // points to the newly created node
  
  // loop through each child node
  for(i = 0; i < NUM_OF_LETTERS; i++) {
    // check if a child node exists
    if (root->child[i] != NULL){
      // check to see if the child's letter is the same
      // as the letter passes
      if(root -> child[i]->letter == letterToInsert) {
        // return the child node
        return root->child[i];
      }
    }
  } 

  // call the allocateNewNode to allocate the new node in memory
  // a have newNode point to the new node
  newNode = allocNewNode(letterToInsert);
  
  // check to make sure new node is not null
  if (newNode == NULL){
    // print error message
    fprintf(stderr,"ERR: NEW NODE WITH LETTER %c NOT INSERTED TO TRIE.\n", letterToInsert);
    // return error
    return NULL;
  }
  
  // set i to the letterToInsert minus the int value of a
  i = letterToInsert - 'a';
  // set the child of the root to the new node
  root -> child[i] = newNode;
  // set the back link to the root
  root -> child[i] -> prev = root;
  
  // return the new node
  return newNode;
}

/**
 *
 * printTrieContents() prints the words in the trie.
 * 
 **/
int printTrieContents(struct trieNode *root){
  
  int i = 0;
  
  // check to see if root is null
  if(root == NULL) {
    // We assume 'root' has reached the end of the list,
    // and we are done.
    return;
  }
  
  // check to see if the roots wordCount is 0
  if (root->wordCount >0){
      // call the traverseUpTrie to print the current word
      traverseUpTrie(root);
      // print the word count
      printf(": %d\n", root->wordCount);
  }
  
  // loop through each child node
  for (i = 0; i < NUM_OF_LETTERS; i++){
    // traverse down trie
    printTrieContents(root->child[i]);
  }
  
  // return success
  return 0;
}

/**
 * 
 * traverseUpTrie() moves up the Trie recursively until
 * it hits the root and then prints the letters.
 * 
 **/
int traverseUpTrie(struct trieNode* root){
  
  // check to see if next node up is the root
  if (root->prev != '\0'){
    // move up
    traverseUpTrie(root->prev);
  } 
  
  // create pointer to point to the letter
  // at the current node
  char *temp = &(root->letter);
  // print the letter
  printf("%s", temp);
  
  // return success
  return 0;
}

/**
 * 
 * freTrieMemory() destroys the Trie and frees it
 * from memory.
 * 
 **/
int freeTrieMemory(struct trieNode *root)
{
  
  int i = 0;
  
  // check to see if root is null
  if(root == NULL) {
    /* Either the structure itself is empty or the 
      root node has reached a leaf. */
      return 0;
  }
  
  // loops through each child node
  for(i = 0; i < NUM_OF_LETTERS; i++) {
    // check if child exists
    if (root->child[i] != NULL){
      // move to next child  
      freeTrieMemory(root->child[i]);
    }
  }
  
  // free the node
  free(root);
  
  // return success
  return 0;
}

/* Allocate a new child of struct trieNode into memory.
  Note that this function may need to be called before
  using the 'insert' function. */
struct trieNode *allocNewNode(char newChar) {

  int i = 0;
  struct trieNode *newTrie = malloc(sizeof(struct trieNode));
  
  // check to make sure trie was allocated in memory
  if (newTrie == NULL){
    // print error message
    fprintf(stderr,"ERR: NEW NODE NOT ALLOCATED IN MEMORY.\n");
    // return error
    return NULL;
  }
  
  /* Copy the character stored in 'newChar' to the first 'n'
    characters of the string (where n is specified by the size of
    a trieNode). */
  memset(newTrie, 0, sizeof(struct trieNode));
  
  /* The new trieNode will be passed the character stored 
   inside 'newChar'. */
  newTrie -> letter = newChar;
  newTrie -> wordCount = 0;
  for (i=0; i < NUM_OF_LETTERS; i++){
    newTrie->child[i] = NULL;
  }
  return newTrie;
}

/*
 * returns 1 if the list starting at pNode contains the address addr,
 *    and returns 0 otherwise
 */
int containsStr(struct trieNode *root, const char *str){
  
  int i = 0;
  int val;
  struct trieNode *dummy = root;
  
  while(*(str+i)!='\0'){
    val = *(str+i) - 'a';
    
    // compare the current nodes addr to the addr
    // specifed to see if they are the same
    if (dummy->child[val] == NULL){
      return 0;
    }
    dummy = dummy->child[val];
    i++;
  }
  
  return 1;
  
}


/* You should not need to modify this function */
int getText(const char* srcAddr, char* buffer){
  FILE *pipe;
  int bytesRead;

  snprintf(buffer, MAX_BUFF_SIZE, "curl -s \"%s\" | python getText.py", srcAddr);

  pipe = popen(buffer, "r");
  if(pipe == NULL){
    fprintf(stderr, "ERROR: could not open the pipe for command %s\n",
	    buffer);
    return 0;
  }

  bytesRead = fread(buffer, sizeof(char), MAX_BUFF_SIZE-1, pipe);
  buffer[bytesRead] = '\0';

  pclose(pipe);

  return bytesRead;
}