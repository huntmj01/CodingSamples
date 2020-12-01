﻿using NUnit.Framework;
using ProjectEuler.Problem_2_Strategy_Pattern;

namespace ProjectEuler.Test.Project_Euler_Program
{
	public class ShouldSolveProblem2StrategyPattern
	{

		FibonacciCalculator fibonacciCalculator;
		StackStrategy stackStrategy;

		[SetUp]
		public void Setup()
		{
			fibonacciCalculator = new FibonacciCalculator("stack");
			stackStrategy = new StackStrategy();
		}

		/*
		 * Each new term in the Fibonacci sequence is generated by adding the 
		 * previous two terms. By starting with 1 and 2, the first 10 terms will be:
		 *
		 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
		 * 
		 * By considering the terms in the Fibonacci sequence whose values 
		 * do not exceed four million, find the sum of the even-valued terms.
		 */

		[Test]
		public void SuchThatIt_ReturnsTheCorrectAnswer()
		{
			const int fourMillion = 4000000;
			const int correctAnswer = 4613732;
			long getFibonacciResult = 0;
			var n = 0;
			while (getFibonacciResult < fourMillion)
			{
				n++;
				getFibonacciResult = stackStrategy.GetFibonacci(n);
			}
			var getSumOfEvenResult = fibonacciCalculator.GetSumOfEvenValuedTerms(n);
			Assert.AreEqual(correctAnswer, getSumOfEvenResult);
		}
	}
}