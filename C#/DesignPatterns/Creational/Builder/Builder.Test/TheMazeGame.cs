using NUnit.Framework;

namespace Builder.Test
{
	public class MazeGameTestSetup
	{
		public MazeGame mazeGame;
		public MazeBuilder mazeBuilder;
		public Maze maze;

		public MazeGameTestSetup()
		{
			SetOrReset();
		}

		public void SetOrReset()
		{
			mazeGame = new MazeGame();
			mazeBuilder = null;
			maze = null;
		}
	}

	public class TheMazeGame : MazeGameTestSetup
	{
		[SetUp]
		public void Setup()
		{
			SetOrReset();
			mazeBuilder = new StandardMazeBuilder();
		}

		[Test]
		public void ShouldExist()
		{
			Assert.IsNotNull(mazeGame);
		}

		public class WhenCreatingMazeUsingTheStandardMazeBuilder : MazeGameTestSetup {

			[SetUp]
			public void Setup()
			{
				SetOrReset();
				mazeBuilder = new StandardMazeBuilder();
				maze = mazeGame.CreateMaze(mazeBuilder);
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

		public class WhenCreatingMazeUsingTheCountingMazeBuilder : MazeGameTestSetup
		{
			CountingMazeBuilder countingMazeBuilder;

			[SetUp]
			public void Setup()
			{
				SetOrReset();
				countingMazeBuilder = new CountingMazeBuilder();
				maze = mazeGame.CreateMaze(countingMazeBuilder);
			}

			[Test]
			public void ReturnsNullMaze()
			{
				Assert.IsNull(maze);
			}

			[Test]
			public void ReturnsCorrectGetCountsString()
			{
				Assert.AreEqual(countingMazeBuilder.GetCounts(), "The maze has 2 rooms and 1 doors.");
			}
		}
	}
}