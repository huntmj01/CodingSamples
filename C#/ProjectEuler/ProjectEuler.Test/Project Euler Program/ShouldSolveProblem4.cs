using NUnit.Framework;
using ProjectEuler.Problem_4;

namespace ProjectEuler.Test.Project_Euler_Program
{
	public class ShouldSolveProblem4
	{
		PalindromeProduct palindromeProduct;

		[SetUp]
		public void Setup()
		{
			palindromeProduct = new PalindromeProduct();
		}

		/*
		 * A palindromic number reads the same both ways. The largest palindrome 
		 * made from the product of two 2-digit numbers is 9009 = 91 × 99.
		 * 
		 * Find the largest palindrome made from the product of two 3-digit numbers.
		 */
		[Test]
		public void SuchThatIt_ReturnsTheCorrectAnswer()
		{
			const int correctAnswer = 906609;
			var result = palindromeProduct.GetLargestPalindromeProduct(3);
			Assert.AreEqual(correctAnswer, result);
		}
	}
}
