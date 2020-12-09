using NUnit.Framework;

namespace AbstractFactory.Test
{
	public class TheMazeGame
	{
		MazeGame mazeGame;

		[SetUp]
		public void Setup()
		{
			mazeGame = new MazeGame();
		}

		[Test]
		public void ShouldExist()
		{
			Assert.IsNotNull(mazeGame);
		}

		[Test]
		public void WhenCreatingMaze_ReturnsMaze()
		{
			var maze = mazeGame.CreateMaze();
			Assert.IsInstanceOf<Maze>(maze);
		}

		[Test]
		public void WhenCreatingMaze_Adds2RoomsToMaze()
		{
			var maze = mazeGame.CreateMaze();
			var room1 = maze.GetRoomNumber(1);
			var room2 = maze.GetRoomNumber(2);

			Assert.IsInstanceOf<Room>(room1);
			Assert.IsInstanceOf<Room>(room2);
			Assert.AreEqual(1, room1.roomNumber);
			Assert.AreEqual(2, room2.roomNumber);
		}

		[Test]
		public void WhenCreatingMaze_SetsSidesOfRoom1()
		{
			var maze = mazeGame.CreateMaze();
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
		public void WhenCreatingMaze_SetsSidesOfRoom2()
		{
			var maze = mazeGame.CreateMaze();
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
}