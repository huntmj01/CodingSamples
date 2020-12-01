using NUnit.Framework;
using ProjectEuler.Problem_1;

namespace ProjectEuler.Test.Problem_1
{
	public class MultiplesShould
	{
		private Multiples multiples;

		[SetUp]
		public void Setup()
		{
			multiples = new Multiples();
		}

		[Test]
		public void Return0Given0()
		{
			var result = multiples.GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(0);
			Assert.AreEqual(0, result);
		}

		[Test]
		public void Return0Given1()
		{
			var result = multiples.GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(1);
			Assert.AreEqual(0, result);
		}

		[Test]
		public void Return0Given2()
		{
			var result = multiples.GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(2);
			Assert.AreEqual(0, result);
		}

		[Test]
		public void Return0Given3()
		{
			var result = multiples.GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(3);
			Assert.AreEqual(0, result);
		}

		[Test]
		public void Returns3Given4()
		{
			var result = multiples.GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(4);
			Assert.AreEqual(3, result);
		}

		[Test]
		public void Returns3Given5()
		{
			var result = multiples.GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(5);
			Assert.AreEqual(3, result);
		}

		[Test]
		public void Returns8Given6()
		{
			var result = multiples.GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(6);
			Assert.AreEqual(8, result);
		}

		[Test]
		public void Returns14Given7()
		{
			var result = multiples.GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(7);
			Assert.AreEqual(14, result);
		}

		[Test]
		public void Returns14Given8()
		{
			var result = multiples.GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(8);
			Assert.AreEqual(14, result);
		}

		[Test]
		public void Returns14Given9()
		{
			var result = multiples.GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(9);
			Assert.AreEqual(14, result);
		}

		[Test]
		public void Returns23Given10()
		{
			var result = multiples.GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(10);
			Assert.AreEqual(23, result);
		}

		[Test]
		public void Returns98Given21()
		{
			var result = multiples.GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(21);
			Assert.AreEqual(98, result);
		}
	}
}
