namespace Prototype
{
	public class Room : MapSite
	{
		private MapSite[] _mapSites;
		public int _roomNumber { get; private set; }

		public Room()
		{

		}

		public Room(Room other)
		{
			_mapSites = other._mapSites;
			_roomNumber = other._roomNumber;
		}

		public virtual void Initialize(MapSite[] mapSites, int roomNumber)
		{
			_mapSites = mapSites;
			_roomNumber = roomNumber;
		}

		public virtual Room Clone()
		{
			return new Room(this);
		}

		public MapSite GetSide(Direction direction)
		{
			return _mapSites[(int)direction];
		}

		public void SetSide(Direction direction, MapSite mapSite)
		{
			_mapSites[(int)direction] = mapSite;
		}

		public override void Enter()
		{

		}
	}
}
