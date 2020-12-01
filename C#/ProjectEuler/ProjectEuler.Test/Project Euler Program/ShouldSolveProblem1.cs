using NUnit.Framework;
using ProjectEuler.Problem_1;
using ProjectEuler.Problem_2_Strategy_Pattern;

namespace ProjectEuler.Test.Project_Euler_Program
{
	public class ShouldSolveProblemOne
	{

		private Multiples multiples;

		[SetUp]
		public void Setup()
		{
			multiples = new Multiples();
		}

		[Test]
		public void ReturnCorrectAnswerForProblem1()
		{
			/*
			 * If we list all the natural numbers below 10 that are multiples 
			 * of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
			 * 
			 * Find the sum of all the multiples of 3 or 5 below 1000.
			 */

			var correctAnswer = 233168;
			var result = multiples.GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(1000);
			Assert.AreEqual(correctAnswer, result);
		}
	}
}
