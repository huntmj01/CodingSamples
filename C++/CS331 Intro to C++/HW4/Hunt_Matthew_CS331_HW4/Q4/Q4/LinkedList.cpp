/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			08/03/2018
* ASSIGNMENT:	HW4_Q4
*/

#include "stdafx.h"
#include "LinkedList.h"

template <typename Type>
LinkedList<Type>::LinkedList()
{
	
}

template <typename Type>
LinkedList<Type>::~LinkedList()
{
	
}

// When a list is not full, inserts the item into a list. 
template <typename Type>
void LinkedList<Type>::insert(const Type& item, int i)
{
	// If the list is empty, inserts the item as the first element in
	// the list.The head and cursor pointer should be initialized
	// properly after the insert operation.
	if (empty())
	{
	//	head = item;
	}

	// If the list is not empty and the second integer argument has
	// the value of 0, inserts the item immediately after the cursor
	// element.
	if (!empty() && i == 0)
	{
//		cursor->next = item;
	}

	// If the list is not empty and the second integer argument has
	// the value of - 1, inserts the item immediately before the cursor
	// element
	if (!empty() && i == -1)
	{
		
	}

	// In all case, properly move the cursor to designate inserted
	// item as the current element
//	cursor = item;

}

template <typename Type>
void LinkedList<Type>::remove()
{
	ListElement* tempPtr{ cursor };
	ListElement* nextPtr{ cursor->next };

	// When a list is not empty, removes the current element from
	// the list.After deleting the cursor pointing element, set the
	// cursor to the following element
	if (!empty())
	{
		delete tempPtr;
		cursor = nextPtr;
	}

	// If the cursor is pointing to an element that is the only
	// element in the list, you should properly set the head and
	// cursor pointer after deleting the node
	if (tempPtr == head)
	{
		delete tempPtr;
	}

	// If the cursor is pointing to the last element of the list, the
	// link field of the previous node of the last node should be set to
	// null after deleting the node.Set the cursor to the head
	// pointing element
	if (nextPtr->next == nullptr)
	{
		delete tempPtr;
		tempPtr->next = nullptr;
		cursor = tempPtr;
	}
}

template <typename Type>
Type LinkedList<Type>::retrieve() const
{
	// When a list is not empty, return a copy of the cursor pointing
	//	element.
	if (!empty())
	{
		return NULL;
	}

	return NULL;
}

template <typename Type>
int LinkedList<Type>::gotoPrior()
{
	// If a list is not empty and the cursor is not pointing the first
	// element of the list, then designates the element immediately
	// before the current element as the current element and returns
	// 1. Otherwise, returns 0.

	ListElement* tempPtr{ head };

	if (!empty() && cursor != head)
	{

		return 1;
	}

	return 0;
}

template <typename Type>
int LinkedList<Type>::gotoNext()
{
	// If the current element is not at the end of the list, then
	// designates the element immediately after the current element
	// as the current element and returns 1. Otherwise, returns 0
	if (cursor->next != nullptr)
	{

		return 1;
	}

	return 0;
}

template <typename Type>
int LinkedList<Type>::gotoBeginning()
{
	// If a list is not empty, then designates the element at the
	// beginning of the list as the current element and returns 1.
	// Otherwise, returns 0.
	if (!empty())
	{
		head = cursor;
		return 1;
	}

	return 0;
	
}

template <typename Type>
void LinkedList<Type>::clear()
{
	// Removes all the elements in a list and deallocates associated
	// dynamic memory
	ListElement* tempPtr{ head };

	while(tempPtr!=nullptr)
	{
		ListElement* nextPtr{ tempPtr->next };
		delete tempPtr;
		tempPtr = nextPtr;
	}
}


template <typename Type>
int LinkedList<Type>::empty() const
{
	return head == nullptr;
}

template <typename Type>
LinkedList<Type>::LinkedList(const LinkedList& src)
{
	
}