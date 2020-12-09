namespace Prototype
{
	// The virtual keyword is used to modify a method, property, indexer, or event declaration and 
	// allow for it to be overridden in a derived class
	// see: https://docs.microsoft.com/en-us/dotnet/csharp/language-reference/keywords/virtual
	public abstract class MazeFactory
	{
		public abstract Maze MakeMaze();
		public abstract Wall MakeWall();
		public abstract Room MakeRoom(int roomNumber);
		public abstract Door MakeDoor(Room room1, Room room2);
	}
}
