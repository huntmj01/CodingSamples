namespace AbstractFactory.Factories
{
	public class BombedMazeFactory : MazeFactory
	{
		public override Wall MakeWall()
		{
			return new BombedWall();
		}

		public override Room MakeRoom(int roomNumber)
		{
			return new RoomWithABomb(roomNumber);
		}
	}
}
