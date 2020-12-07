namespace Builder.Builders
{
	public class CountingMazeBuilder : MazeBuilder
	{
		private int _rooms;
		private int _doors;

		public CountingMazeBuilder()
		{
			_rooms = 0;
			_doors = 0;
		}

		public override void BuildMaze()
		{
			
		}

		public override void BuildDoor(int roomFrom, int roomTo)
		{
			_doors++;
		}

		public override void BuildRoom(int roomNum)
		{
			_rooms++;
		}

		public override Maze GetMaze()
		{
			return null;
		}

		public string GetCounts()
		{
			return "The maze has " + _rooms + " rooms and " + _doors + " doors.";
		}
	}
}
