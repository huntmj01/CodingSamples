namespace Prototype
{
	public class RoomWithABomb : Room
	{
		public RoomWithABomb()
		{

		}

		public RoomWithABomb(Room other) : base(other)
		{

		}

		public override Room Clone()
		{
			return new RoomWithABomb(this);
		}
	}
}