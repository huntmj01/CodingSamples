namespace ProjectEuler.Problem_2_Strategy_Pattern
{
	public class FibonacciCalculator
	{

		private IFibonacciStrategy fibonacciStrategy;

		public FibonacciCalculator (string strategy)
		{
			switch (strategy)
			{
				case "stack":
					fibonacciStrategy = new StackStrategy();
					break;
				case "recursion":
					fibonacciStrategy = new RecursionStrategy();
					break;
				default:
					throw new StrategyNotSpecifiedException();
			}
		}

		public int GetSumOfEvenValuedTerms(int n)
		{
			int sum = 0;

			for (int i = 0; i < n + 1; i++)
			{
				int result = fibonacciStrategy.GetFibonacci(i);
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
				int result = fibonacciStrategy.GetFibonacci(i);
				stringResult += "X" + i + " = " + result.ToString("#,##0");
				if (result % 2 == 0)
				{
					sum += result;
				}
				stringResult += "; Sum of even valued terms = " + sum.ToString("#,##0") + "\n";
			}
			return stringResult;
		}
	}
}
