using NUnit.Framework;
using ProjectEuler.Problem_2_Strategy_Pattern;

namespace ProjectEuler.Test.Problem_2_Strategy_Pattern
{
	public class StackStrategyShould
	{
		[TestFixture]
		public class OnGetFibonacci
		{
			StackStrategy stackStrategy;

			[SetUp]
			public void Setup()
			{
				stackStrategy = new StackStrategy();
			}

			[Test]
			public void Returns0_GivenX0()
			{
				var expected = 0;
				var result = stackStrategy.GetFibonacci(0);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns1_GivenX1()
			{
				var expected = 1;
				var result = stackStrategy.GetFibonacci(1);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns1_GivenX2()
			{
				var expected = 1;
				var result = stackStrategy.GetFibonacci(2);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns2_GivenX3()
			{
				var expected = 2;
				var result = stackStrategy.GetFibonacci(3);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns3_GivenX4()
			{
				var expected = 3;
				var result = stackStrategy.GetFibonacci(4);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns5_GivenX5()
			{
				var expected = 5;
				var result = stackStrategy.GetFibonacci(5);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns8_GivenX6()
			{
				var expected = 8;
				var result = stackStrategy.GetFibonacci(6);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns8_GivenX7()
			{
				var expected = 13;
				var result = stackStrategy.GetFibonacci(7);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns21_GivenX8()
			{
				var expected = 21;
				var result = stackStrategy.GetFibonacci(8);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns34_GivenX9()
			{
				var expected = 34;
				var result = stackStrategy.GetFibonacci(9);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns55_GivenX10()
			{
				var expected = 55;
				var result = stackStrategy.GetFibonacci(10);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns89_GivenX11()
			{
				var expected = 89;
				var result = stackStrategy.GetFibonacci(11);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void ThrowsFibonacciOverflowException_OnTooLargeOfCalculation()
			{
				Assert.Throws<FibonacciOverflowException>(() => stackStrategy.GetFibonacci(9999));
			}
		}
	}
}
