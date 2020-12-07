namespace Builder
{
	public class Door : MapSite
	{
		private Room room1;
		private Room room2;
		private bool isOpen;

		public Door(Room room1, Room room2)
		{

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
