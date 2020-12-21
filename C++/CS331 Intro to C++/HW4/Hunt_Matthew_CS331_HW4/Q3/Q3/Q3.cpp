/*
* NAME:			Matthew Hunt
* INSTRUCTOR:	Dr. Yoo
* COURSE:		CS 331
* DATE:			7/30/2018
* ASSIGNMENT:	HW4_Q3
*/

// HW4Q3.cpp
// Stack-based Evaluation of Postfix Expressions
// This program uses a stack to evaluate Postfix expressions

#include "stdafx.h"

#include <iostream>
#include <string>
#include <sstream>
#include <stack>

using namespace std;

// skipWhiteSpace for Skiping whitespace in an input stream.                        *

void skipWhiteSpace(istream& in)
{
	while (in.good() && isspace(in.peek()))
	{
		// Read and discard the space character
		in.get();
	}
}

//
// postFixEval                        
// If the next token in the input is an integer, read  
// the integer and push it on the stack; but if it is  
// an operator, pop the last two values from the stack 
// and apply the operator, and push the result onto    
// the stack.  At the end of the string, the lone      
// on the stack is the result.                         
//
int postFixEval(string str)
{
	istringstream in = istringstream(str);
	stack<int> postFixStack;
	skipWhiteSpace(in);

	while (in)
	{
		string next = "";
		in >> next;

		// If the next token in the input is an integer
		if (isdigit(next[0]))
		{
			// read the integer and push it on the stack
			int read = stoi(next);
			postFixStack.push(read);
		}
		else if(next == "+" || next == "-" || next == "*" || next == "/")
		{
			// pop the last two values from the stack 
			int value1 = 0;
			int value2 = 0;

			if (postFixStack.top() > 0)
			{
				value1 = postFixStack.top();
				postFixStack.pop();
			}
			
			if (postFixStack.top() > 0)
			{
				value2 = postFixStack.top();
				postFixStack.pop();
			}
			
			// and apply the operator	
			int result = 0;

			if (next == "+")
			{
				result = value1+ value2;
			}
			else if (next == "-")
			{
				result = value2 - value1;
			}
			else if (next == "*")
			{
				result = value1 * value2;
			}
			else if (next == "/")
			{
				result = value2 / value1;
			}

			// and push the result onto the stack
			postFixStack.push(result);

		}

	}

	return postFixStack.top();
}

int main()
{
	string input;

	while (true)
	{
		cout << "Enter a postfix expression, or press ENTER to quit:\n";
		getline(cin, input);

		if (input.length() == 0)
		{
			break;
		}
		int number = postFixEval(input);
		cout << "The value of " << input << " is " << number << endl;
	}

	return 0;
}