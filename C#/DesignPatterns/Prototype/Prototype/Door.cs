namespace Prototype
{
	public class Door : MapSite
	{
		private Room _room1;
		private Room _room2;
		private bool _isOpen;

		public Door()
		{

		}

		public Door(Door other)
		{
			_room1 = other._room1;
			_room2 = other._room2;
		}

		public virtual void Initialize(Room room1, Room room2)
		{
			_room1 = room1;
			_room2 = room2;
		}

		public virtual Door Clone()
		{
			return new Door(this);
		}

		public override void Enter()
		{
			
		}

		public Room OtherSideFrom(Room room)
		{
			return null;
		}
	}
}
