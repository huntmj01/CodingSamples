namespace Singleton.Singletons
{
	public class MazeFactorySingleton
	{
		private static MazeFactorySingleton _instance;

		public static MazeFactorySingleton Instance(string mazeStyle)
		{
			if (_instance == null)
			{
				if (mazeStyle == "bombed")
				{
					_instance = new BombedMazeFactory();
				}
				else if (mazeStyle == "enchanted")
				{
					_instance = new EnchantedMazeFactory();
				}
				else
				{
					_instance = new MazeFactorySingleton();
				}
			}

			return _instance;
		}

		protected MazeFactorySingleton()
		{

		}

		public virtual Maze MakeMaze()
		{
			return new Maze();
		}

		public virtual Wall MakeWall()
		{
			return new Wall();
		}

		public virtual Room MakeRoom(int roomNumber)
		{
			return new Room(roomNumber);
		}

		public virtual Door MakeDoor(Room room1, Room room2)
		{
			return new Door(room1, room2);
		}

		// defeats the purpose of a singleton, but needed in order to test in nunuit
		public static void ResetForNUnit()
		{
			_instance = null;
		}
	}
}
