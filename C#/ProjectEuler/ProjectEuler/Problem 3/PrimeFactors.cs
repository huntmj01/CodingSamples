using System;
using System.Collections.Generic;
using System.Linq;

namespace ProjectEuler.Problem_3
{
	public class PrimeFactors
	{
		private const int smallestPrimeNumber = 2;

		public List<long> GetPrimeFactorsOf(long number)
		{
			List<long> primeFactors = new List<long>();

			for (long divisor = smallestPrimeNumber; divisor <= number; divisor++)
				for (; number % divisor == 0; number /= divisor)
					primeFactors.Add(divisor);

			return primeFactors;
		}
		
		public long GetLargestPrimeFactorOf(long number)
		{
			List<long> primeFactors = GetPrimeFactorsOf(number);

			if (primeFactors.Count == 0)
				throw new NumberDoesNotHaveAnyPrimeFactorsException();

			return primeFactors.Max();
		}

		public class NumberDoesNotHaveAnyPrimeFactorsException : Exception { }
	}
}
