using NUnit.Framework;
using ProjectEuler.Problem_2_Strategy_Pattern;

namespace ProjectEuler.Test.Problem_2_Strategy_Pattern
{
	public class FibonacciCalculatorShould
	{

		[TestFixture]
		public class OnInit
		{

			[Test]
			public void HaveAbilityToSetStackStrategy()
			{
				Assert.DoesNotThrow(() => new FibonacciCalculator("stack"));
			}

			[Test]
			public void HaveAbilityToSetRecursionStrategy()
			{
				Assert.DoesNotThrow(() => new FibonacciCalculator("recursion"));
			}

			[Test]
			public void ThrowStrategyNotSpecifiedException_GivenInvalidStrageyName()
			{
				Assert.Throws<StrategyNotSpecifiedException>(() => new FibonacciCalculator("Matt's Strategy"));
			}
		}

			[TestFixture]
		public class OnGetSumOfEvenValuedTerms
		{
			FibonacciCalculator fibonacciCalculator;

			[SetUp]
			public void Setup()
			{
				fibonacciCalculator = new FibonacciCalculator("stack");
			}

			[Test]
			public void Returns0_GivenX0()
			{
				var expected = 0;
				var result = fibonacciCalculator.GetSumOfEvenValuedTerms(0);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns0_GivenX1()
			{
				var expected = 0;
				var result = fibonacciCalculator.GetSumOfEvenValuedTerms(1);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns0_GivenX2()
			{
				var expected = 0;
				var result = fibonacciCalculator.GetSumOfEvenValuedTerms(2);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns2_GivenX3()
			{
				var expected = 2;
				var result = fibonacciCalculator.GetSumOfEvenValuedTerms(3);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns2_GivenX4()
			{
				var expected = 2;
				var result = fibonacciCalculator.GetSumOfEvenValuedTerms(4);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns2_GivenX5()
			{
				var expected = 2;
				var result = fibonacciCalculator.GetSumOfEvenValuedTerms(5);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns10_GivenX6()
			{
				var expected = 10;
				var result = fibonacciCalculator.GetSumOfEvenValuedTerms(6);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns10_GivenX7()
			{
				var expected = 10;
				var result = fibonacciCalculator.GetSumOfEvenValuedTerms(7);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns10_GivenX8()
			{
				var expected = 10;
				var result = fibonacciCalculator.GetSumOfEvenValuedTerms(8);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns44_GivenX9()
			{
				var expected = 44;
				var result = fibonacciCalculator.GetSumOfEvenValuedTerms(9);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void Returns44_GivenX10()
			{
				var expected = 44;
				var result = fibonacciCalculator.GetSumOfEvenValuedTerms(10);
				Assert.AreEqual(expected, result);
			}

			[Test]
			public void ThrowsFibonacciOverflowException_OnTooLargeOfCalculation()
			{
				Assert.Throws<FibonacciOverflowException>(() => fibonacciCalculator.GetSumOfEvenValuedTerms(9999));
			}
		}

		[TestFixture]
		public class OnToString
		{
			FibonacciCalculator problem2;

			[SetUp]
			public void Setup()
			{
				problem2 = new FibonacciCalculator("stack");
			}

			[Test]
			public void ReturnsCorrectString_GivenX45()
			{
				var expected = "X0 = 0; Sum of even valued terms = 0\nX1 = 1; Sum of even valued terms = 0\nX2 = 1; Sum of even valued terms = 0\nX3 = 2; Sum of even valued terms = 2\nX4 = 3; Sum of even valued terms = 2\nX5 = 5; Sum of even valued terms = 2\nX6 = 8; Sum of even valued terms = 10\nX7 = 13; Sum of even valued terms = 10\nX8 = 21; Sum of even valued terms = 10\nX9 = 34; Sum of even valued terms = 44\nX10 = 55; Sum of even valued terms = 44\nX11 = 89; Sum of even valued terms = 44\nX12 = 144; Sum of even valued terms = 188\nX13 = 233; Sum of even valued terms = 188\nX14 = 377; Sum of even valued terms = 188\nX15 = 610; Sum of even valued terms = 798\nX16 = 987; Sum of even valued terms = 798\nX17 = 1,597; Sum of even valued terms = 798\nX18 = 2,584; Sum of even valued terms = 3,382\nX19 = 4,181; Sum of even valued terms = 3,382\nX20 = 6,765; Sum of even valued terms = 3,382\nX21 = 10,946; Sum of even valued terms = 14,328\nX22 = 17,711; Sum of even valued terms = 14,328\nX23 = 28,657; Sum of even valued terms = 14,328\nX24 = 46,368; Sum of even valued terms = 60,696\nX25 = 75,025; Sum of even valued terms = 60,696\nX26 = 121,393; Sum of even valued terms = 60,696\nX27 = 196,418; Sum of even valued terms = 257,114\nX28 = 317,811; Sum of even valued terms = 257,114\nX29 = 514,229; Sum of even valued terms = 257,114\nX30 = 832,040; Sum of even valued terms = 1,089,154\nX31 = 1,346,269; Sum of even valued terms = 1,089,154\nX32 = 2,178,309; Sum of even valued terms = 1,089,154\nX33 = 3,524,578; Sum of even valued terms = 4,613,732\nX34 = 5,702,887; Sum of even valued terms = 4,613,732\nX35 = 9,227,465; Sum of even valued terms = 4,613,732\nX36 = 14,930,352; Sum of even valued terms = 19,544,084\nX37 = 24,157,817; Sum of even valued terms = 19,544,084\nX38 = 39,088,169; Sum of even valued terms = 19,544,084\nX39 = 63,245,986; Sum of even valued terms = 82,790,070\nX40 = 102,334,155; Sum of even valued terms = 82,790,070\nX41 = 165,580,141; Sum of even valued terms = 82,790,070\nX42 = 267,914,296; Sum of even valued terms = 350,704,366\nX43 = 433,494,437; Sum of even valued terms = 350,704,366\nX44 = 701,408,733; Sum of even valued terms = 350,704,366\nX45 = 1,134,903,170; Sum of even valued terms = 1,485,607,536\n";
				var result = problem2.ToString(45);
				Assert.AreEqual(expected, result);
			}
		}
	}
}
