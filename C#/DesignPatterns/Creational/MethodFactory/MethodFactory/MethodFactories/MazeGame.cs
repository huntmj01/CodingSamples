namespace MethodFactory.MethodFactories
{
	public class MazeGame
	{

		public MazeGame()
		{

		}

		public Maze CreateMaze()
		{
			var maze = MakeMaze();
			var room1 = MakeRoom(1);
			var room2 = MakeRoom(2);
			var door = MakeDoor(room1, room2);

			maze.AddRoom(room1);
			maze.AddRoom(room2);

			room1.SetSide(Direction.North, MakeWall());
			room1.SetSide(Direction.East, door);
			room1.SetSide(Direction.South, MakeWall());
			room1.SetSide(Direction.West, MakeWall());

			room2.SetSide(Direction.North, MakeWall());
			room2.SetSide(Direction.East, MakeWall());
			room2.SetSide(Direction.South, MakeWall());
			room2.SetSide(Direction.West, door);

			return maze;
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
	}
}
