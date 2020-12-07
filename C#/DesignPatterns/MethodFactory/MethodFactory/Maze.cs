using System.Collections.Generic;

namespace MethodFactory
{
	public class Maze
	{
		private List<Room> Rooms;

		public Maze()
		{
			Rooms = new List<Room>();
		}

		public void AddRoom(Room room)
		{
			Rooms.Add(room);
		}

		public Room GetRoomNumber(int roomNumber)
		{
			return Rooms.Find(room => room.roomNumber == roomNumber);
		}
	}
}
