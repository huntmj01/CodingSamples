namespace ProjectEuler.Problem_2_Strategy_Pattern
{
	public class RecursionStrategy : IFibonacciStrategy
	{
		public int GetFibonacci(int n)
		{
			bool baseCase = n == 0 || n == 1;
			if (baseCase) return n;

			return StrategyHelper.FailIfCheckedAdditionFails(GetFibonacci(n - 1), GetFibonacci(n - 2));
		}
	}
}
