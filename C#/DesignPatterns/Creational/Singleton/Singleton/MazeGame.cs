using Singleton.Singletons;

namespace Singleton
{
	public class MazeGame
	{

		public MazeGame()
		{

		}

		public Maze CreateMaze(MazeFactorySingleton mazeFactory)
		{
			var maze = mazeFactory.MakeMaze();
			var room1 = mazeFactory.MakeRoom(1);
			var room2 = mazeFactory.MakeRoom(2);
			var door = mazeFactory.MakeDoor(room1, room2);

			maze.AddRoom(room1);
			maze.AddRoom(room2);

			room1.SetSide(Direction.North, mazeFactory.MakeWall());
			room1.SetSide(Direction.East, door);
			room1.SetSide(Direction.South, mazeFactory.MakeWall());
			room1.SetSide(Direction.West, mazeFactory.MakeWall());

			room2.SetSide(Direction.North, mazeFactory.MakeWall());
			room2.SetSide(Direction.East, mazeFactory.MakeWall());
			room2.SetSide(Direction.South, mazeFactory.MakeWall());
			room2.SetSide(Direction.West, door);

			return maze;
		}
	}
}
