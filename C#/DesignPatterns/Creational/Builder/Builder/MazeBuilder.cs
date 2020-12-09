namespace Builder
{
	public abstract class MazeBuilder
	{
		public abstract void BuildMaze();
		public abstract void BuildRoom(int roomNum);
		public abstract void BuildDoor(int roomFrom, int roomTo);
		public abstract Maze GetMaze();
	}
}
