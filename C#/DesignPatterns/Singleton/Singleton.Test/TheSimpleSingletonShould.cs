using NUnit.Framework;

namespace Singleton.Test
{
	public class TheSimpleSingletonShould
	{
		SimpleSingleton simpleSingleton;

		[SetUp]
		public void Setup()
		{
			simpleSingleton = SimpleSingleton.Instance;
		}

		[Test]
		public void Initialize()
		{
			Assert.IsInstanceOf<SimpleSingleton>(simpleSingleton);
		}

		[Test]
		public void NotInitializeMoreThanOnce()
		{
			var simpleSingleton2 = SimpleSingleton.Instance;
			Assert.AreSame(simpleSingleton, simpleSingleton2);
		}
	}
}