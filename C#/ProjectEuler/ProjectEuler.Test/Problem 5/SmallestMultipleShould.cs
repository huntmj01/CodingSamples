using NUnit.Framework;
using ProjectEuler.Problem_5;
using System;

namespace ProjectEuler.Test.Problem_5
{
	public class SmallestMultipleShould
	{
		[TestFixture]
		public class OnIsMultiple
		{
			private SmallestMultiple smallestMultiple;

			[SetUp]
			public void Setup()
			{
				smallestMultiple = new SmallestMultiple();
			}

			[Test]
			public void ThrowsNumberCanNotBeNegativeException_GivenNegativeInt()
			{
				Random random = new Random();
				int randomNegativeInt = random.Next(int.MinValue, -1);
				Assert.Throws<SmallestMultiple.IntParamCanNotBeLessThanOneException>(() => smallestMultiple.IsMultiple(randomNegativeInt, 1));
				Assert.Throws<SmallestMultiple.IntParamCanNotBeLessThanOneException>(() => smallestMultiple.IsMultiple(1, randomNegativeInt));
			}

			[Test]
			public void ThrowsNumberCanNotBeNegativeException_Given0()
			{
				Assert.Throws<SmallestMultiple.IntParamCanNotBeLessThanOneException>(() => smallestMultiple.IsMultiple(0, 1));
				Assert.Throws<SmallestMultiple.IntParamCanNotBeLessThanOneException>(() => smallestMultiple.IsMultiple(1, 0));
			}

			[Test]
			public void ReturnTrue_GivenDivisorIsMultipleOfNumber()
			{
				AssertIsMultiple(1, 1);
				AssertIsMultiple(2, 1);
				AssertIsMultiple(3, 1);
				AssertIsMultiple(4, 1);
				AssertIsMultiple(5, 1);
				AssertIsMultiple(6, 1);
				AssertIsMultiple(7, 1);
				AssertIsMultiple(8, 1);
				AssertIsMultiple(9, 1);
				AssertIsMultiple(10, 1);

				AssertIsMultiple(2, 2);
				AssertIsMultiple(4, 2);
				AssertIsMultiple(6, 2);
				AssertIsMultiple(8, 2);
				AssertIsMultiple(10, 2);

				AssertIsMultiple(3, 3);
				AssertIsMultiple(6, 3);
				AssertIsMultiple(9, 3);

				AssertIsMultiple(4, 4);
				AssertIsMultiple(8, 4);

				AssertIsMultiple(5, 5);
				AssertIsMultiple(10, 5);

				AssertIsMultiple(2520, 1);
				AssertIsMultiple(2520, 2);
				AssertIsMultiple(2520, 3);
				AssertIsMultiple(2520, 4);
				AssertIsMultiple(2520, 5);
				AssertIsMultiple(2520, 6);
				AssertIsMultiple(2520, 7);
				AssertIsMultiple(2520, 8);
				AssertIsMultiple(2520, 9);
				AssertIsMultiple(2520, 10);
			}

			[Test]
			public void ReturnFalse_GivenDivisorIsNotMultipleOfNumber()
			{
				AssertIsNotMultiple(1, 2);
				AssertIsNotMultiple(3, 2);
				AssertIsNotMultiple(5, 2);
				AssertIsNotMultiple(7, 2);
				AssertIsNotMultiple(9, 2);

				AssertIsNotMultiple(1, 3);
				AssertIsNotMultiple(2, 3);
				AssertIsNotMultiple(4, 3);
				AssertIsNotMultiple(5, 3);
				AssertIsNotMultiple(7, 3);
				AssertIsNotMultiple(8, 3);
				AssertIsNotMultiple(10, 3);

				AssertIsNotMultiple(1, 4);
				AssertIsNotMultiple(2, 4);
				AssertIsNotMultiple(3, 4);
				AssertIsNotMultiple(5, 4);
				AssertIsNotMultiple(6, 4);
				AssertIsNotMultiple(7, 4);
				AssertIsNotMultiple(9, 4);
				AssertIsNotMultiple(10, 4);

				AssertIsNotMultiple(1, 5);
				AssertIsNotMultiple(2, 5);
				AssertIsNotMultiple(3, 5);
				AssertIsNotMultiple(4, 5);
				AssertIsNotMultiple(6, 5);
				AssertIsNotMultiple(7, 5);
				AssertIsNotMultiple(8, 5);
				AssertIsNotMultiple(9, 5);

				AssertIsNotMultiple(6571, 2);
				AssertIsNotMultiple(6571, 3);
				AssertIsNotMultiple(6571, 4);
				AssertIsNotMultiple(6571, 5);
				AssertIsNotMultiple(6571, 6);
				AssertIsNotMultiple(6571, 7);
				AssertIsNotMultiple(6571, 8);
				AssertIsNotMultiple(6571, 9);
				AssertIsNotMultiple(6571, 10);
			}

			private void AssertIsMultiple(int number, int divisor)
			{
				Assert.IsTrue(smallestMultiple.IsMultiple(number, divisor));
			}

			private void AssertIsNotMultiple(int number, int divisor)
			{
				Assert.IsFalse(smallestMultiple.IsMultiple(number, divisor));
			}
		}


		[TestFixture]
		public class OnGetSmallestMultipleDivisibleByAllNumbersBetween
		{
			private SmallestMultiple smallestMultiple;

			[SetUp]
			public void Setup()
			{
				smallestMultiple = new SmallestMultiple();
			}

			[Test]
			public void ThrowsNumberCanNotBeNegativeException_GivenNegativeInt()
			{
				Random random = new Random();
				int randomNegativeInt = random.Next(int.MinValue, -1);
				Assert.Throws<SmallestMultiple.IntParamCanNotBeLessThanOneException>(() => smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(randomNegativeInt, 1));
				Assert.Throws<SmallestMultiple.IntParamCanNotBeLessThanOneException>(() => smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(1, randomNegativeInt));
			}

			[Test]
			public void ThrowsNumberCanNotBeNegativeException_Given0()
			{
				Assert.Throws<SmallestMultiple.IntParamCanNotBeLessThanOneException>(() => smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(0, 1));
				Assert.Throws<SmallestMultiple.IntParamCanNotBeLessThanOneException>(() => smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(1, 0));
			}

			[Test]
			public void Return2_Given_1_1()
			{
				Assert.AreEqual(2, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(1, 1));
			}

			[Test]
			public void Return4_Given_1_2()
			{
				Assert.AreEqual(4, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(1, 2));
			}

			[Test]
			public void Return4_Given_1_3()
			{
				Assert.AreEqual(6, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(1, 3));
			}

			[Test]
			public void Return4_Given_2_2()
			{
				Assert.AreEqual(4, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(2, 2));
			}

			//[Test]
			//public void Return6_Given_2_3()
			//{
			//	Assert.AreEqual(6, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(2, 3));
			//}

			//[Test]
			//public void Return8_Given_2_4()
			//{
			//	Assert.AreEqual(8, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(2, 4));
			//}

			[Test]
			public void Return6_Given_3_3()
			{
				Assert.AreEqual(6, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(3, 3));
			}

			//[Test]
			//public void Return12_Given_3_4()
			//{
			//	Assert.AreEqual(12, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(3, 4));
			//}

			[Test]
			public void Return12_Given_3_5()
			{
				Assert.AreEqual(15, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(3, 5));
			}

			[Test]
			public void Return8_Given_4_4()
			{
				Assert.AreEqual(8, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(4, 4));
			}


			//[Test]
			//public void Return20_Given_4_5()
			//{
			//	Assert.AreEqual(20, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(4, 5));
			//}

			[Test]
			public void Return12_Given_4_6()
			{
				Assert.AreEqual(12, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(4, 6));
			}


			//[Test]
			//public void Return6_Given_1_3()
			//{
			//	Assert.AreEqual(6, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(1, 3));
			//}

			//[Test]
			//public void Return12_Given_1_4()
			//{
			//	Assert.AreEqual(12, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(1, 4));
			//}

			//[Test]
			//public void Return60_Given_1_5()
			//{
			//	Assert.AreEqual(60, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(1, 5));
			//}


			//[Test]
			//public void Return60_Given_1_6()
			//{
			//	Assert.AreEqual(60, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(1, 6));
			//}

			//[Test]
			//public void Return420_Given_1_7()
			//{
			//	Assert.AreEqual(420, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(1, 7));
			//}

			//[Test]
			//public void Return2520_Given_1_10()
			//{
			//	Assert.AreEqual(2520, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(1, 10));
			//}

			//[Test]
			//public void ReturnX_Given_1_20()
			//{
			//	Assert.AreEqual(232792560, smallestMultiple.GetSmallestMultipleDivisibleByAllNumbersBetween(1, 20));
			//}
		}
	}
}