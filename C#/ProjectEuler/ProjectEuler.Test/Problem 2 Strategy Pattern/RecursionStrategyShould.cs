using NUnit.Framework;
using ProjectEuler.Problem_2_Strategy_Pattern;

namespace ProjectEuler.Test.Problem_2_Strategy_Pattern
{
	class RecursionStrategyShould
	{
		[TestFixture]
		public class OnGetFibonacci
		{
			RecursionStrategy recursionStrategy;

			[SetUp]
			public void Setup()
			{
				recursionStrategy = new RecursionStrategy();
			}

			[Test]
			public void Return0_GivenX0()
			{
				var expected = 0;
				var result = recursionStrategy.GetFibonacci(0);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Return1_GivenX1()
			{
				var expected = 1;
				var result = recursionStrategy.GetFibonacci(1);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Return1_GivenX2()
			{
				var expected = 1;
				var result = recursionStrategy.GetFibonacci(2);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Return2_GivenX3()
			{
				var expected = 2;
				var result = recursionStrategy.GetFibonacci(3);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Return3_GivenX4()
			{
				var expected = 3;
				var result = recursionStrategy.GetFibonacci(4);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Return5_GivenX5()
			{
				var expected = 5;
				var result = recursionStrategy.GetFibonacci(5);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Return8_GivenX6()
			{
				var expected = 8;
				var result = recursionStrategy.GetFibonacci(6);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Return8_GivenX7()
			{
				var expected = 13;
				var result = recursionStrategy.GetFibonacci(7);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Return21_GivenX8()
			{
				var expected = 21;
				var result = recursionStrategy.GetFibonacci(8);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Return34_GivenX9()
			{
				var expected = 34;
				var result = recursionStrategy.GetFibonacci(9);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Return55_GivenX10()
			{
				var expected = 55;
				var result = recursionStrategy.GetFibonacci(10);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Return89_GivenX11()
			{
				var expected = 89;
				var result = recursionStrategy.GetFibonacci(11);
				Assert.AreEqual(expected, result);
			}

			[Test]
			[Ignore("Recursion is too slow, ignore test.")]
			public void ThrowsFibonacciOverflowException_OnTooLargeOfCalculation()
			{
				Assert.Throws<FibonacciOverflowException>(() => recursionStrategy.GetFibonacci(9999));
			}
		}
	}
}
