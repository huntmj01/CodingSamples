using NUnit.Framework;
using ProjectEuler.Problem_3;
using System;
using System.Collections.Generic;

namespace ProjectEuler.Test.Problem_3
{
	public class PrimeFactorsShould
	{
		[TestFixture]
		public class OnGetPrimeFactorsOf
		{
			private PrimeFactors primeFactors;

			[SetUp]
			public void Setup()
			{
				primeFactors = new PrimeFactors();
			}

			[Test]
			public void ReturnsCorrectListOfFactors_GivenNegativeInt()
			{
				Random random = new Random();
				int randomNegativeInt = random.Next(int.MinValue, -1);
				AssertContainsPrimeFactors(randomNegativeInt, new List<long>() { });
			}

			[Test]
			public void ReturnsCorrectListOfFactors_Given1()
			{
				AssertContainsPrimeFactors(1, new List<long>() { });
			}

			[Test]
			public void ReturnsCorrectListOfFactors_Given2()
			{
				AssertContainsPrimeFactors(2, new List<long>() { 2 });
			}

			[Test]
			public void ReturnsCorrectListOfFactors_Given3()
			{
				AssertContainsPrimeFactors(3, new List<long>() { 3 });
			}

			[Test]
			public void ReturnsCorrectListOfFactors_Given4()
			{
				AssertContainsPrimeFactors(4, new List<long>() { 2, 2 });
			}

			[Test]
			public void ReturnsCorrectListOfFactors_Given5()
			{
				AssertContainsPrimeFactors(5, new List<long>() { 5 });
			}

			[Test]
			public void ReturnsCorrectListOfFactors_Given6()
			{
				AssertContainsPrimeFactors(6, new List<long>() { 2, 3 });
			}


			[Test]
			public void ReturnsCorrectListOfFactors_Given7()
			{
				AssertContainsPrimeFactors(7, new List<long>() { 7 });
			}

			[Test]
			public void ReturnsCorrectListOfFactors_Given8()
			{
				AssertContainsPrimeFactors(8, new List<long>() { 2, 2, 2 });
			}

			[Test]
			public void ReturnsCorrectListOfFactors_Given9()
			{
				AssertContainsPrimeFactors(9, new List<long>() { 3, 3 });
			}


			[Test]
			public void ReturnsCorrectListOfFactors_Given13195()
			{
				AssertContainsPrimeFactors(13195, new List<long>() { 5, 7, 13, 29 });
			}

			[Test]
			public void ReturnsCorrectListOfFactors_Given600851475143()
			{
				AssertContainsPrimeFactors(600851475143, new List<long>() { 71, 839, 1471, 6857 });
			}

			private void AssertContainsPrimeFactors(long number, List<long> containsFactors)
			{
				var result = primeFactors.GetPrimeFactorsOf(number);
				Assert.AreEqual(containsFactors, result);
			}
		}

		[TestFixture]
		public class OnGetLargestPrimeFactorOf
		{
			private PrimeFactors primeFactors;

			[SetUp]
			public void Setup()
			{
				primeFactors = new PrimeFactors();
			}

			[Test]
			public void ThrowsNumberDoesNotHaveAnyPrimeFactorsException_GivenNegativeInt()
			{
				Random random = new Random();
				int randomNegativeInt = random.Next(int.MinValue, -1);
				Assert.Throws<PrimeFactors.NumberDoesNotHaveAnyPrimeFactorsException>(() => primeFactors.GetLargestPrimeFactorOf(randomNegativeInt));
			}

			[Test]
			public void ThrowsNumberDoesNotHaveAnyPrimeFactorsException_Given0()
			{
				Assert.Throws<PrimeFactors.NumberDoesNotHaveAnyPrimeFactorsException>(() => primeFactors.GetLargestPrimeFactorOf(0));
			}

			[Test]
			public void ThrowsNumberDoesNotHaveAnyPrimeFactorsException_Given1()
			{
				Assert.Throws<PrimeFactors.NumberDoesNotHaveAnyPrimeFactorsException>(() => primeFactors.GetLargestPrimeFactorOf(1));
			}

			[Test]
			public void ReturnsCorrectFactor_Given2()
			{
				AssertLargestFactor(2, 2);
			}

			[Test]
			public void ReturnsCorrectFactor_Given3()
			{
				AssertLargestFactor(3, 3);
			}

			[Test]
			public void ReturnsCorrectFactor_Given4()
			{
				AssertLargestFactor(4, 2);
			}

			[Test]
			public void ReturnsCorrectFactor_Given5()
			{
				AssertLargestFactor(5, 5);
			}

			[Test]
			public void ReturnsCorrectFactor_Given6()
			{
				AssertLargestFactor(6, 3);
			}

			[Test]
			public void ReturnsCorrectFactor_Given7()
			{
				AssertLargestFactor(7, 7);
			}

			[Test]
			public void ReturnsCorrectFactor_Given8()
			{
				AssertLargestFactor(8, 2);
			}

			[Test]
			public void ReturnsCorrectFactor_Given9()
			{
				AssertLargestFactor(9, 3);
			}

			[Test]
			public void ReturnsCorrectFactor_Given13195()
			{
				AssertLargestFactor(13195, 29);
			}

			private void AssertLargestFactor(long number, long largestFactor)
			{
				var result = primeFactors.GetLargestPrimeFactorOf(number);
				Assert.AreEqual(largestFactor, result);
			}
		}
	}
}
