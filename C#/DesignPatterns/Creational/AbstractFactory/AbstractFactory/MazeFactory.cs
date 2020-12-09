namespace AbstractFactory
{
	// The virtual keyword is used to modify a method, property, indexer, or event declaration and 
	// allow for it to be overridden in a derived class
	// see: https://docs.microsoft.com/en-us/dotnet/csharp/language-reference/keywords/virtual
	public class MazeFactory
	{
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
