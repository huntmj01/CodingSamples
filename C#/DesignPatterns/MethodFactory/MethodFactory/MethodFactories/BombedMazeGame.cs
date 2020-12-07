namespace MethodFactory.MethodFactories
{
	public class BombedMazeGame : MazeGame
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
