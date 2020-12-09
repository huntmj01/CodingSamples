using ModernSingleton;
using NUnit.Framework;

public class TheModernSingletonShould
{
	IModernSingletonExample modernSingleton;

	[SetUp]
	public void Setup()
	{
		modernSingleton = new ModernSingletonExample();
	}

	[Test]
	public void Initialize()
	{
		Assert.IsInstanceOf<ModernSingletonExample>(modernSingleton);
	}

	[Test]
	public void SetProperty()
	{
		Assert.AreSame("Prop1", modernSingleton.Prop1);
	}
}