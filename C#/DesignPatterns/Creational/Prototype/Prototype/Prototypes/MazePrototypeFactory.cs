using System;
using System.Collections.Generic;
using System.Text;

namespace Prototype.Prototypes
{
	public class MazePrototypeFactory : MazeFactory
	{
		private Maze _prototypeMaze;
		private Room _prototypeRoom;
		private Wall _prototypeWall;
		private Door _prototypeDoor;

		public MazePrototypeFactory(Maze maze, Wall wall, Room room, Door door)
		{
			_prototypeMaze = maze;
			_prototypeWall = wall;
			_prototypeRoom = room;
			_prototypeDoor = door;
		}

		public override Maze MakeMaze()
		{
			Maze maze = _prototypeMaze.Clone();
			maze.Initialize(new List<Room>());
			return maze;
		}

		public override Wall MakeWall()
		{
			Wall wall = _prototypeWall.Clone();
			wall.Initialize();
			return wall;
		}

		public override Room MakeRoom(int roomNumber)
		{
			Room room = _prototypeRoom.Clone();
			room.Initialize(new MapSite[4], roomNumber);
			return room;
		}

		public override Door MakeDoor(Room room1, Room room2)
		{
			Door door = _prototypeDoor.Clone();
			door.Initialize(room1, room2);
			return door;
		}
	}
}
