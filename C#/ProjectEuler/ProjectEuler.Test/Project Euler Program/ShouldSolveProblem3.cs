using NUnit.Framework;
using ProjectEuler.Problem_3;

namespace ProjectEuler.Test.Project_Euler_Program
{
	public class ShouldSolveProblem3
	{

		PrimeFactors primeFactors;

		[SetUp]
		public void Setup()
		{
			primeFactors = new PrimeFactors();
		}

		/*
		 * The prime factors of 13195 are 5, 7, 13 and 29.
		 * 
		 * What is the largest prime factor of the number 600851475143 ?
		 */
		[Test]
		public void SuchThatIt_ReturnsTheCorrectAnswer()
		{
			const int correctAnswer = 6857;
			var result = primeFactors.GetLargestPrimeFactorOf(600851475143);
			Assert.AreEqual(correctAnswer, result);
		}
	}
}
