using MethodFactory.MethodFactories;
using NUnit.Framework;

namespace MethodFactory.Test
{
	public class MazeGameTestSetup
	{
		public MazeGame mazeGame;
		public Maze maze;

		public MazeGameTestSetup()
		{
			SetOrReset();
		}

		public void SetOrReset()
		{
			mazeGame = null;
			maze = null;
		}
	}

	public class TheMazeGame : MazeGameTestSetup
	{
		[SetUp]
		public void Setup()
		{
			SetOrReset();
			mazeGame = new MazeGame();
		}

		[Test]
		public void ShouldExist()
		{
			Assert.IsNotNull(mazeGame);
		}

		public class WhenCreatingMaze : MazeGameTestSetup {

			[SetUp]
			public void Setup()
			{
				SetOrReset();
				mazeGame = new MazeGame();
				maze = mazeGame.CreateMaze();
			}

			[Test]
			public void ReturnsMaze()
			{
				Assert.IsInstanceOf<Maze>(maze);
			}

			[Test]
			public void Adds2RoomsToMaze()
			{
				var room1 = maze.GetRoomNumber(1);
				var room2 = maze.GetRoomNumber(2);

				Assert.IsInstanceOf<Room>(room1);
				Assert.IsInstanceOf<Room>(room2);
				Assert.AreEqual(1, room1.roomNumber);
				Assert.AreEqual(2, room2.roomNumber);
			}

			[Test]
			public void SetsSidesOfRoom1()
			{
				var room1 = maze.GetRoomNumber(1);
				var north = room1.GetSide(Direction.North);
				var east = room1.GetSide(Direction.East);
				var south = room1.GetSide(Direction.South);
				var west = room1.GetSide(Direction.West);

				Assert.IsInstanceOf<Wall>(north);
				Assert.IsInstanceOf<Door>(east);
				Assert.IsInstanceOf<Wall>(south);
				Assert.IsInstanceOf<Wall>(west);
			}

			[Test]
			public void SetsSidesOfRoom2()
			{
				var room2 = maze.GetRoomNumber(2);
				var north = room2.GetSide(Direction.North);
				var east = room2.GetSide(Direction.East);
				var south = room2.GetSide(Direction.South);
				var west = room2.GetSide(Direction.West);

				Assert.IsInstanceOf<Wall>(north);
				Assert.IsInstanceOf<Wall>(east);
				Assert.IsInstanceOf<Wall>(south);
				Assert.IsInstanceOf<Door>(west);
			}
		}
		public class WhenCreatingEnchantedMaze : MazeGameTestSetup
		{

			[SetUp]
			public void Setup()
			{
				SetOrReset();
				mazeGame = new EnchantedMazeGame();
				maze = mazeGame.CreateMaze();
			}

			[Test]
			public void ReturnsMaze()
			{
				Assert.IsInstanceOf<Maze>(maze);
			}

			[Test]
			public void Adds2EnchantedRoomsToMaze()
			{
				var room1 = maze.GetRoomNumber(1);
				var room2 = maze.GetRoomNumber(2);

				Assert.IsInstanceOf<EnchantedRoom>(room1);
				Assert.IsInstanceOf<EnchantedRoom>(room2);
				Assert.AreEqual(1, room1.roomNumber);
				Assert.AreEqual(2, room2.roomNumber);
			}

			[Test]
			public void SetsSidesOfRoom1()
			{
				var room1 = maze.GetRoomNumber(1);
				var north = room1.GetSide(Direction.North);
				var east = room1.GetSide(Direction.East);
				var south = room1.GetSide(Direction.South);
				var west = room1.GetSide(Direction.West);

				Assert.IsInstanceOf<Wall>(north);
				Assert.IsInstanceOf<DoorNeedingSpell>(east);
				Assert.IsInstanceOf<Wall>(south);
				Assert.IsInstanceOf<Wall>(west);
			}

			[Test]
			public void SetsSidesOfRoom2()
			{
				var room2 = maze.GetRoomNumber(2);
				var north = room2.GetSide(Direction.North);
				var east = room2.GetSide(Direction.East);
				var south = room2.GetSide(Direction.South);
				var west = room2.GetSide(Direction.West);

				Assert.IsInstanceOf<Wall>(north);
				Assert.IsInstanceOf<Wall>(east);
				Assert.IsInstanceOf<Wall>(south);
				Assert.IsInstanceOf<DoorNeedingSpell>(west);
			}
		}

		public class WhenCreatingBombedMaze : MazeGameTestSetup
		{

			[SetUp]
			public void Setup()
			{
				SetOrReset();
				mazeGame = new BombedMazeGame();
				maze = mazeGame.CreateMaze();
			}

			[Test]
			public void ReturnsMaze()
			{
				Assert.IsInstanceOf<Maze>(maze);
			}

			[Test]
			public void Adds2EnchantedRoomsToMaze()
			{
				var room1 = maze.GetRoomNumber(1);
				var room2 = maze.GetRoomNumber(2);

				Assert.IsInstanceOf<RoomWithABomb>(room1);
				Assert.IsInstanceOf<RoomWithABomb>(room2);
				Assert.AreEqual(1, room1.roomNumber);
				Assert.AreEqual(2, room2.roomNumber);
			}

			[Test]
			public void SetsSidesOfRoom1()
			{
				var room1 = maze.GetRoomNumber(1);
				var north = room1.GetSide(Direction.North);
				var east = room1.GetSide(Direction.East);
				var south = room1.GetSide(Direction.South);
				var west = room1.GetSide(Direction.West);

				Assert.IsInstanceOf<BombedWall>(north);
				Assert.IsInstanceOf<Door>(east);
				Assert.IsInstanceOf<BombedWall>(south);
				Assert.IsInstanceOf<BombedWall>(west);
			}

			[Test]
			public void SetsSidesOfRoom2()
			{
				var room2 = maze.GetRoomNumber(2);
				var north = room2.GetSide(Direction.North);
				var east = room2.GetSide(Direction.East);
				var south = room2.GetSide(Direction.South);
				var west = room2.GetSide(Direction.West);

				Assert.IsInstanceOf<BombedWall>(north);
				Assert.IsInstanceOf<BombedWall>(east);
				Assert.IsInstanceOf<BombedWall>(south);
				Assert.IsInstanceOf<Door>(west);
			}
		}
	}
}