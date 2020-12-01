using System;

namespace ProjectEuler.Problem_2_Strategy_Pattern
{
	public static class StrategyHelper
	{
		public static int FailIfCheckedAdditionFails(int addend1, int addend2)
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
	}
}