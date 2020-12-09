namespace Singleton
{
	public class BombedMazeFactory : MazeFactorySingleton
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
