#ifndef INDEXPAGE_H_
#define INDEXPAGE_H_

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define NUM_OF_LETTERS 26   // the number of letters in the alphabet
#define MAX_BUFF_SIZE 300000  // the max allowed size of the buffer

struct trieNode {
  int wordCount;                          // Count the number of occurrences of the word for this node.
  char letter;                            // Indicate the letter that will represent this node.
  struct trieNode *child[NUM_OF_LETTERS]; // Each node can have up to NUM_OF_LETTERS children.
  struct trieNode *prev;                  // Refer to the previous node in the trie structure.
};

int indexPage(const char *url, struct trieNode *root, int *pTotalNumTerms);
int addWordOccurrence(const char* word, const int wordLength,  struct trieNode *root);
struct trieNode* insertLetter(char letter, struct trieNode *root);
int printTrieContents(struct trieNode *root);
int traverseUpTrie(struct trieNode *root);
int freeTrieMemory(struct trieNode *root);
struct trieNode *allocNewNode(char newChar);
int containsStr(struct trieNode *root, const char *str);
int getText(const char* srcAddr, char* buffer);

#endif
