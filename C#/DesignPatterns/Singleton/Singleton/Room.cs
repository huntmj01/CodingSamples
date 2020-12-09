namespace Singleton
{
	public class Room : MapSite
	{
		private MapSite[] mapSites;
		public int roomNumber { get; private set; }

		public Room(int number)
		{
			mapSites = new MapSite[4];
			roomNumber = number;
		}

		public MapSite GetSide(Direction direction)
		{
			return mapSites[(int)direction];
		}

		public void SetSide(Direction direction, MapSite mapSite)
		{
			mapSites[(int)direction] = mapSite;
		}

		public override void Enter()
		{

		}
	}
}
