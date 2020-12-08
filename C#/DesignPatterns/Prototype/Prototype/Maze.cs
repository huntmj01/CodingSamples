using System.Collections.Generic;

namespace Prototype
{
	public class Maze
	{
		private List<Room> _rooms;

		public Maze()
		{
			_rooms = new List<Room>();
		}

		private Maze(Maze other)
		{
			_rooms = other._rooms;
		}

		public virtual void Initialize(List<Room> rooms)
		{
			_rooms = rooms;
		}

		public virtual Maze Clone()
		{
			return new Maze(this);
		}

		public void AddRoom(Room room)
		{
			_rooms.Add(room);
		}

		public Room GetRoomNumber(int roomNumber)
		{
			return _rooms.Find(room => room._roomNumber == roomNumber);
		}
	}
}
