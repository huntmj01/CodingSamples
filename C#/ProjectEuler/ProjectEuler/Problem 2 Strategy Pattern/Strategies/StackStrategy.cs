using System.Collections.Generic;

namespace ProjectEuler.Problem_2_Strategy_Pattern
{
	public class StackStrategy : IFibonacciStrategy
	{
		public int GetFibonacci(int n)
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
			stack.Push(StrategyHelper.FailIfCheckedAdditionFails(nMinusOne, nMinusTwo));
		}
	}
}
