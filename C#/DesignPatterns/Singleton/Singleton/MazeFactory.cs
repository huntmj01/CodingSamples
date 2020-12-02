namespace Singleton
{
	// based off the singleton sample code in Design Patterns Ch 3 Pg 132
	public class MazeFactory
	{
		private static MazeFactory _instance = null;

		public static string MazeType { get; set; }

		public static MazeFactory Instance
		{
			get
			{
				_instance ??= MazeType switch
				{
					"bombed" => new BombedMazeFactory(),
					"enchanted" => new EnchantedMazeFactory(),
					_ => new MazeFactory(),
				};
				return _instance;
			}
		}

		// to allow inheritance but to keep the constructor from being called, 
		// use the protected keyword
		protected MazeFactory()
		{

		}

		// defeats the purpose of a singleton, but in order to test in nunuit
		public static void ResetForNUnit()
		{
			_instance = null;
		}
	}

	public class BombedMazeFactory : MazeFactory
	{

	}

	public class EnchantedMazeFactory : MazeFactory
	{

	}
}
