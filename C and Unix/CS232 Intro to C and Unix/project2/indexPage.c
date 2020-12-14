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
#define MAX_BUFF_SIZE 1000  // the max allowed size of the buffer

struct trieNode {
  int wordCount;                          // Count the number of occurrences of the word for this node.
  char letter;                            // Indicate the letter that will represent this node.
  struct trieNode *child[NUM_OF_LETTERS]; // Each node can have up to NUM_OF_LETTERS children.
  struct trieNode *prev;                  // Refer to the previous node in the trie structure.
};

// definitions
struct trieNode *indexPage(const char* url, char* buffer);
int addWordOccurrence(const char* word, const int wordLength,  struct trieNode *root);
struct trieNode* insertLetter(char letter, struct trieNode *root);
int printTrieContents(struct trieNode *root);
int traverseUpTrie(struct trieNode *root);
int freeTrieMemory(struct trieNode *root);
struct trieNode *allocNewNode(char newChar);
int getText(const char* srcAddr, char* buffer);

/**
 * 
 * main() where the magic happens. 
 * 
 **/
int main(int argc, char** argv){
  
  // check command line args
  if(argc != 2){
    // print error message
    fprintf(stderr, "USAGE: %s url\n", argv[0]);
    // exit program
    return -1;
  }

  // declare variables
  char buffer[MAX_BUFF_SIZE];     // buffer to hold the the text from the webpage
  struct trieNode* root;          // the root of the trie data structure
  int result = 0;                 // for error handling
  
  // print link to console
  printf("%s\n",argv[1]);
  
  // call index page 
  root = indexPage(argv[1], buffer);
  
  // check to make sure root is not null
  if (root == NULL){
    // exit the program
    return -1;
  }
  
  // print trie
  result = printTrieContents(root);
  
  // check to make sure an error has not occured
  // while trying to print the trie contents
  if (result==-1) {
    // exit the program
    return -1;
  }
  
  // free trie
  result = freeTrieMemory(root);
  
  // check to make sure an error has not occured
  // while trying to free the trie contents
  if (result==-1) {
    // exit the program
    return -1;
  }
  
  // end the program
  return 0;
}

/**
 * 
 * indexPage() calls getText() to retrieve text from webpage,
 * loops through the buffer, adds each word to a matrix,
 * passes each word to the addWordOccurrence method, and
 * then prints each word to the console.
 * 
 **/ 
struct trieNode *indexPage(const char* url, char* buffer)
{
  // create root node
  struct trieNode *root;
  root = allocNewNode('\0');
  
  // check to make sure root was allocated in memory
  if (root == NULL){
    // print error message
    fprintf(stderr, "ERR: ROOT IS NULL.\n");
    // return NULL
    return NULL;
  }
  
  // call getText()
  int numWords = getText(url, buffer);
  
  // check to make sure num of words is not 0
  if(!(numWords > 0)){
    // print error message
    fprintf(stderr, "ERR: NUMBER OF WORDS RETRIEVED FROM PAGE WAS NOT > 0.\n");
    // return error
    return NULL;
  }
  
  int i = 0;
  int j = 0;
  int k = 0;
  int result = 0;               // for error handling
  int inspace;                  // flag that holds whether current char is a space
  char *words[numWords];        // multidimentional array to hold each word in the buffer
  char *arrPtr[MAX_BUFF_SIZE];  // holds an array of pointers
  
  // set first word to first char in buffer
  words[j] = buffer;

  // loop through each element in the buffer
  for(i = 0; i < MAX_BUFF_SIZE; i++) {
    
    // check to see if we are at the end of the buffer
    if(buffer[i] == '\0') {
      // place \0 at the end of the last word
      words[j][k] = '\0';
      // increase j by one
      j++;
      // set the last word to null
      words[j] = NULL;
      // break the loop
      break;
    }
    // check to see if item in buffer is characther
    else if(isalpha(buffer[i])) {
      // set inspace flag to false
      inspace = 0;
      // set the next word to the lower case character in the buffer
      words[j][k] = tolower(buffer[i]);
      // increase k by one
      k++;
    }
    // check to see if current item is a space
    else if (!inspace) {
      // set inspace flag to true
      inspace = 1;
      // place \0 to mark the end of the word
      words[j][k] = '\0';
      // increase j by one
      j++;
      words[j] = &(words[j-1][k+1]);
      // reset k
      k = 0;
      
      // check to see if j is the same as the MAX buffer size
      if(j == MAX_BUFF_SIZE) {
        // set the last word to null
        words[j] = NULL;
        // break the loop
        break;
      }
    }
  }
  
  // find a word
  // reset i and j
  i = 0;
  j = 0;
  
  // loop through each words
  while(words[i] != NULL){

    // check to see if current word is not blank
    if (strcmp(words[i], "")){
      // point to that word
      arrPtr[j] = words[i];
      // increase j
      j++;
    }
    // increase i
    i++;
    
  }
  
  // reset i  
  i = 0;
  
  // loop through the array of pointers
  while(arrPtr[i] != NULL){
    
    // add the current word to the trie
    result = addWordOccurrence(arrPtr[i], strlen(arrPtr[i]), root);
    
    // check to see if word was added to trie data structure
    if (result == -1){
      // print error message
      fprintf(stderr,"ERR: WORD %s NOT ADDED TO TRIE DATA STRUCTURE.\n", arrPtr[i]);
      // return error
      return NULL;
    }
    
    // print the current word
    printf("\t%s\n", arrPtr[i]);
    // increase i by one
    i++;
  }
  
  // return root
  return root;
  
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