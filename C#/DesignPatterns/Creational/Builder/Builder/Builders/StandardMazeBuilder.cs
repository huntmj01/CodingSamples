namespace Builder.Builders
{
	public class StandardMazeBuilder : MazeBuilder
	{
		Maze _currentMaze;

		public StandardMazeBuilder()
		{
			_currentMaze = null;
		}

		public override void BuildMaze()
		{
			_currentMaze = new Maze();
		}

		public override void BuildDoor(int roomFrom, int roomTo)
		{
			Room room1 = _currentMaze.GetRoomNumber(roomFrom);
			Room room2 = _currentMaze.GetRoomNumber(roomTo);
			Door door = new Door(room1, room2);

			room1.SetSide(CommonWall1(room1, room2), door);
			room2.SetSide(CommonWall2(room2, room1), door);
		}

		public override void BuildRoom(int roomNumber)
		{
			if (_currentMaze.GetRoomNumber(roomNumber) == null)
			{
				Room room = new Room(roomNumber);

				room.SetSide(Direction.North, new Wall());
				room.SetSide(Direction.East, new Wall());
				room.SetSide(Direction.South, new Wall());
				room.SetSide(Direction.West, new Wall());

				_currentMaze.AddRoom(room);
			}
		}

		public override Maze GetMaze()
		{
			return _currentMaze;
		}

		// hardcoded direction
		private Direction CommonWall1(Room room1, Room room2)
		{
			return Direction.East;
		}

		// hardcoded direction
		private Direction CommonWall2(Room room1, Room room2)
		{
			return Direction.West;
		}
	}
}
