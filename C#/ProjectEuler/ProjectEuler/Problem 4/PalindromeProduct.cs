using System;

namespace ProjectEuler.Problem_4
{
	public class PalindromeProduct
	{
		public int GetLargestPalindromeProduct(int digits)
		{
			FailIfNegative(digits);

			int largestPalindromeProduct = 0;
			int largestTwoDigitFactor = (int)MathF.Pow(10, digits);

			for (int factor1 = 1; factor1 < largestTwoDigitFactor; factor1++)
			{
				for (int factor2 = 1; factor2 < largestTwoDigitFactor; factor2++)
				{
					var product = factor1 * factor2;
					if (product > largestPalindromeProduct && IsPalindrome(product))
						largestPalindromeProduct = product;
				}
			}
				
			return largestPalindromeProduct;
		}

		public bool IsPalindrome(int number)
		{
			FailIfNegative(number);

			bool isPalindrome = false;
			string numberAsString = number.ToString();
			string reverseOfNumberAsString = Reverse(numberAsString);

			if (numberAsString.Equals(reverseOfNumberAsString))
				isPalindrome = true;

			return isPalindrome;
		}

		private void FailIfNegative(int number)
		{
			if (number < 0)
				throw new IntParamCanNotBeNegativeException();
		}

		private string Reverse(string s)
		{
			char[] charArray = s.ToCharArray();
			Array.Reverse(charArray);
			return new string(charArray);
		}

		public class IntParamCanNotBeNegativeException : Exception { }
	}
}
