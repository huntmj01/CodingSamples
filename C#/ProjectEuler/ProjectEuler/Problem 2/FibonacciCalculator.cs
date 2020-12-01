using System;
using System.Collections.Generic;

namespace ProjectEuler.Problem_2
{
	public class FibonacciCalculator
	{
		public int GetFibonacciUsingRecurssion(int n)
		{
			bool baseCase = n == 0 || n == 1;
			if (baseCase) return n;

			return FailIfCheckedAdditionFails(GetFibonacciUsingRecurssion(n - 1), GetFibonacciUsingRecurssion(n - 2));
		}

		public int GetFibonacciUsingAStack(int n)
		{
			Stack<int> stack = new Stack<int>();

			for (int i = 0; i <= n; i++)
			{
				if (i == 0 || i == 1)
				{
					stack.Push(i);
				}
				else
				{
					CalculateAndPushNextTermTo(stack);
				}
			}

			return (stack.Count == 0) ? 0 : stack.Pop();

		}

		private void CalculateAndPushNextTermTo(Stack<int> stack)
		{
			int nMinusOne = stack.Pop();
			int nMinusTwo = stack.Pop();
			stack.Push(nMinusTwo);
			stack.Push(nMinusOne);
			stack.Push(FailIfCheckedAdditionFails(nMinusOne, nMinusTwo));
		}

		private int FailIfCheckedAdditionFails(int addend1, int addend2)
		{
			try
			{
				return checked(addend1 + addend2);
			}
			catch (OverflowException)
			{
				throw new FibonacciOverflowException();
			}
		}

		public int GetSumOfEvenValuedTerms(int n)
		{
			int sum = 0;

			for (int i = 0; i < n + 1; i++)
			{
				int result = GetFibonacciUsingAStack(i);
				if (result % 2 == 0)
				{
					sum += result;
				}
			}
			return sum;
		}

		public string ToString(int n)
		{
			int sum = 0;
			string stringResult = "";
			for (int i = 0; i < n + 1; i++)
			{
				int result = GetFibonacciUsingAStack(i);
				stringResult += "X" + i + " = " + result.ToString("#,##0");
				if (result % 2 == 0)
				{
					sum += result;
				}
				stringResult += "; Sum of even valued terms = " + sum.ToString("#,##0") + "\n";
			}
			return stringResult;
		}

		public class FibonacciOverflowException : Exception { }
	}
}
