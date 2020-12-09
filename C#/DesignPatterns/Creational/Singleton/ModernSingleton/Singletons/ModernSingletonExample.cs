namespace ModernSingleton
{
	public class ModernSingletonExample : IModernSingletonExample
	{
		public string Prop1 { get; set; }

		public ModernSingletonExample()
		{
			Prop1 = "Prop1";
		}
	}
}
