using NUnit.Framework;
using ProjectEuler.Problem_4;
using System;

namespace ProjectEuler.Test.Problem_4
{
	public class PalindromeProductShould
	{
		[TestFixture]
		public class OnIsPalindrome
		{
			private PalindromeProduct palindromeProduct;

			[SetUp]
			public void Setup()
			{
				palindromeProduct = new PalindromeProduct();
			}

			[Test]
			public void ThrowsNumberCanNotBeNegativeException_GivenNegativeInt()
			{
				Random random = new Random();
				int randomNegativeInt = random.Next(int.MinValue, -1);
				Assert.Throws<PalindromeProduct.IntParamCanNotBeNegativeException>(() => palindromeProduct.IsPalindrome(randomNegativeInt));
			}

			[Test]
			public void ReturnTrue_GivenSingleDigitNumber()
			{
				AssertIsPalindrome(0);
				AssertIsPalindrome(1);
				AssertIsPalindrome(2);
				AssertIsPalindrome(3);
				AssertIsPalindrome(4);
				AssertIsPalindrome(5);
				AssertIsPalindrome(6);
				AssertIsPalindrome(7);
				AssertIsPalindrome(8);
				AssertIsPalindrome(9);
			}

			[Test]
			public void ReturnFalse_GivenDoubleDigitNumber_ThatIsNotAPalindrome()
			{
				AssertIsNotPalindrome(10);
				AssertIsNotPalindrome(12);
				AssertIsNotPalindrome(13);
				AssertIsNotPalindrome(14);
				AssertIsNotPalindrome(15);
				AssertIsNotPalindrome(16);
				AssertIsNotPalindrome(17);
				AssertIsNotPalindrome(18);
				AssertIsNotPalindrome(19);

				AssertIsNotPalindrome(20);
				AssertIsNotPalindrome(21);
				AssertIsNotPalindrome(23);
				AssertIsNotPalindrome(24);
				AssertIsNotPalindrome(25);
				AssertIsNotPalindrome(26);
				AssertIsNotPalindrome(27);
				AssertIsNotPalindrome(28);
				AssertIsNotPalindrome(29);

				AssertIsNotPalindrome(30);
				AssertIsNotPalindrome(31);
				AssertIsNotPalindrome(32);
				AssertIsNotPalindrome(34);
				AssertIsNotPalindrome(35);
				AssertIsNotPalindrome(36);
				AssertIsNotPalindrome(37);
				AssertIsNotPalindrome(38);
				AssertIsNotPalindrome(39);

				AssertIsNotPalindrome(40);
				AssertIsNotPalindrome(41);
				AssertIsNotPalindrome(42);
				AssertIsNotPalindrome(43);
				AssertIsNotPalindrome(45);
				AssertIsNotPalindrome(46);
				AssertIsNotPalindrome(47);
				AssertIsNotPalindrome(48);
				AssertIsNotPalindrome(49);

				AssertIsNotPalindrome(50);
				AssertIsNotPalindrome(51);
				AssertIsNotPalindrome(52);
				AssertIsNotPalindrome(53);
				AssertIsNotPalindrome(54);
				AssertIsNotPalindrome(56);
				AssertIsNotPalindrome(57);
				AssertIsNotPalindrome(58);
				AssertIsNotPalindrome(59);

				AssertIsNotPalindrome(60);
				AssertIsNotPalindrome(61);
				AssertIsNotPalindrome(62);
				AssertIsNotPalindrome(63);
				AssertIsNotPalindrome(64);
				AssertIsNotPalindrome(65);
				AssertIsNotPalindrome(67);
				AssertIsNotPalindrome(68);
				AssertIsNotPalindrome(69);

				AssertIsNotPalindrome(70);
				AssertIsNotPalindrome(71);
				AssertIsNotPalindrome(72);
				AssertIsNotPalindrome(73);
				AssertIsNotPalindrome(74);
				AssertIsNotPalindrome(75);
				AssertIsNotPalindrome(76);
				AssertIsNotPalindrome(78);
				AssertIsNotPalindrome(79);

				AssertIsNotPalindrome(80);
				AssertIsNotPalindrome(81);
				AssertIsNotPalindrome(82);
				AssertIsNotPalindrome(83);
				AssertIsNotPalindrome(84);
				AssertIsNotPalindrome(85);
				AssertIsNotPalindrome(86);
				AssertIsNotPalindrome(87);
				AssertIsNotPalindrome(89);

				AssertIsNotPalindrome(90);
				AssertIsNotPalindrome(91);
				AssertIsNotPalindrome(92);
				AssertIsNotPalindrome(93);
				AssertIsNotPalindrome(94);
				AssertIsNotPalindrome(95);
				AssertIsNotPalindrome(96);
				AssertIsNotPalindrome(97);
				AssertIsNotPalindrome(98);
			}

			[Test]
			public void ReturnTrue_GivenDobuleDigitNumber_ThatIsAPalindrome()
			{
				AssertIsPalindrome(11);
				AssertIsPalindrome(22);
				AssertIsPalindrome(33);
				AssertIsPalindrome(44);
				AssertIsPalindrome(55);
				AssertIsPalindrome(66);
				AssertIsPalindrome(77);
				AssertIsPalindrome(88);
				AssertIsPalindrome(99);
			}

			[Test]
			public void ReturnFalse_GivenTripleDigitNumber_ThatIsNotAPalindrome()
			{
				AssertIsNotPalindrome(190);
				AssertIsNotPalindrome(281);
				AssertIsNotPalindrome(372);
				AssertIsNotPalindrome(463);
				AssertIsNotPalindrome(554);
				AssertIsNotPalindrome(645);
				AssertIsNotPalindrome(736);
				AssertIsNotPalindrome(827);
				AssertIsNotPalindrome(918);
			}

			[Test]
			public void ReturnTrue_GivenTripleDigitNumber_ThatIsAPalindrome()
			{
				AssertIsPalindrome(101);
				AssertIsPalindrome(222);
				AssertIsPalindrome(303);
				AssertIsPalindrome(444);
				AssertIsPalindrome(505);
				AssertIsPalindrome(606);
				AssertIsPalindrome(777);
				AssertIsPalindrome(808);
				AssertIsPalindrome(999);
			}

			[Test]
			public void ReturnFalse_GivenQuadrupleDigitNumber_ThatIsNotAPalindrome()
			{
				AssertIsNotPalindrome(1090);
				AssertIsNotPalindrome(2081);
				AssertIsNotPalindrome(3072);
				AssertIsNotPalindrome(4063);
				AssertIsNotPalindrome(5054);
				AssertIsNotPalindrome(6045);
				AssertIsNotPalindrome(7036);
				AssertIsNotPalindrome(8027);
				AssertIsNotPalindrome(9018);
			}

			[Test]
			public void ReturnTrue_GivenQuadrupleDigitNumber_ThatIsAPalindrome()
			{
				AssertIsPalindrome(1001);
				AssertIsPalindrome(2222);
				AssertIsPalindrome(3003);
				AssertIsPalindrome(4004);
				AssertIsPalindrome(5555);
				AssertIsPalindrome(6666);
				AssertIsPalindrome(7117);
				AssertIsPalindrome(8338);
				AssertIsPalindrome(9009);
			}

			private void AssertIsPalindrome(int number)
			{
				Assert.IsTrue(palindromeProduct.IsPalindrome(number));
			}

			private void AssertIsNotPalindrome(int number)
			{
				Assert.IsFalse(palindromeProduct.IsPalindrome(number));
			}
		}

		[TestFixture]
		public class GetLargestPalindromeProduct
		{
			private PalindromeProduct palindromeProduct;

			[SetUp]
			public void Setup()
			{
				palindromeProduct = new PalindromeProduct();
			}

			[Test]
			public void ThrowsNumberCanNotBeNegativeException_GivenNegativeInt()
			{
				Random random = new Random();
				int randomNegativeInt = random.Next(int.MinValue, -1);
				Assert.Throws<PalindromeProduct.IntParamCanNotBeNegativeException>(() => palindromeProduct.GetLargestPalindromeProduct(randomNegativeInt));
			}

			[Test]
			public void ReturnLargestProduct_GivenSingleDigit()
			{
				AssertIsLargestPalidromeProduct(9, 1);
			}

			[Test]
			public void ReturnLargestProduct_GivenDobuleDigit()
			{
				AssertIsLargestPalidromeProduct(9009, 2);
			}

			[Test]
			public void ReturnLargestProduct_GivenTrippleDigit()
			{
				AssertIsLargestPalidromeProduct(906609, 3);
			}

			[Test]
			[Ignore("Too slow, ignore test.")]
			public void ReturnLargestProduct_GivenQuadrupleDigit()
			{
				AssertIsLargestPalidromeProduct(99000099, 4);
			}

			[Test]
			[Ignore("Too slow, ignore test.")]
			public void ReturnLargestProduct_GivenQuintupleDigit()
			{
				AssertIsLargestPalidromeProduct(2147447412, 5);
			}

			private void AssertIsLargestPalidromeProduct(int expectedPalidromeProduct, int digits)
			{
				Assert.AreEqual(expectedPalidromeProduct, palindromeProduct.GetLargestPalindromeProduct(digits));
			}
		}
	}
}