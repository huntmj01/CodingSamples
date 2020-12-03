using NUnit.Framework;

namespace Singleton.Test
{
	[TestFixture]
	public class TheMazeFactory
	{

		[TestFixture]
		public class WhenMazeTypeIsBombed
		{
			MazeFactory MazeFactory;

			[SetUp]
			public void Setup()
			{
				MazeFactory.ResetForNUnit();
				MazeFactory.MazeType = "bombed";
				MazeFactory = MazeFactory.Instance;
			}

			[Test]
			public void ShouldInitializeAsBombedMazeFactory()
			{
				Assert.IsInstanceOf<BombedMazeFactory>(MazeFactory);
			}

			[Test]
			public void ShouldNotInitializeMoreThanOnce()
			{
				var MazeFactory2 = MazeFactory.Instance;
				Assert.AreSame(MazeFactory, MazeFactory2);
			}
		}

		[TestFixture]
		public class WhenMazeTypeIsEnchanted
		{
			MazeFactory MazeFactory;

			[SetUp]
			public void Setup()
			{
				MazeFactory.ResetForNUnit();
				MazeFactory.MazeType = "enchanted";
				MazeFactory = MazeFactory.Instance;
			}

			[Test]
			public void ShouldInitializeAsEnchantedMazeFactory()
			{
				Assert.IsInstanceOf<EnchantedMazeFactory>(MazeFactory);
			}

			[Test]
			public void ShouldNotInitializeMoreThanOnce()
			{
				var MazeFactory2 = MazeFactory.Instance;
				Assert.AreSame(MazeFactory, MazeFactory2);
			}
		}

		[TestFixture]
		public class WhenMazeTypeIsAnythingElse
		{
			MazeFactory MazeFactory;

			[SetUp]
			public void Setup()
			{
				MazeFactory.ResetForNUnit();
				MazeFactory.MazeType = "anything else";
				MazeFactory = MazeFactory.Instance;
			}

			[Test]
			public void ShouldInitializeAsMazeFactory()
			{
				Assert.IsInstanceOf<MazeFactory>(MazeFactory);
			}

			[Test]
			public void ShouldNotInitializeMoreThanOnce()
			{
				var MazeFactory2 = MazeFactory.Instance;
				Assert.AreSame(MazeFactory, MazeFactory2);
			}
		}
	}
}