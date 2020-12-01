using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Queue.Test
{
	class TheQueueShould
	{
		[TestFixture]
		public class OnOneEnqueue 
		{
			private Queue theQueue;
			private int firstRandomInt;

			[SetUp]
			public void Setup()
			{
				theQueue = new Queue();
				Random random = new Random();
				firstRandomInt = random.Next(1, int.MaxValue);
			}

			[Test]
			public void PlaceFirstIntOnFront()
			{
				theQueue.Enqueue(firstRandomInt);
				Assert.AreEqual(firstRandomInt, theQueue.GetFront());
			}

			[Test]
			public void SetRearAsNull()
			{
				theQueue.Enqueue(firstRandomInt);
				Assert.IsNull(theQueue.GetRear());
			}

			[Test]
			public void FollowedByOneDequeue_ReturnFirstInt()
			{
				theQueue.Enqueue(firstRandomInt);
				int result = theQueue.Dequeue();
				Assert.AreEqual(firstRandomInt, result);
			}

			[Test]
			public void FollowedByOneDequeue_SetFrontAsNull()
			{
				EnqueueThenDequeue();
				Assert.IsNull(theQueue.GetFront());
			}

			[Test]
			public void FollowedByOneDequeue_SetRearAsNull()
			{
				EnqueueThenDequeue();
				Assert.IsNull(theQueue.GetRear());
			}

			private void EnqueueThenDequeue()
			{
				theQueue.Enqueue(firstRandomInt);
				theQueue.Dequeue();
			}
		}

		[TestFixture]
		public class OnTwoEnqueues
		{
			private Queue theQueue;
			private int firstRandomInt;
			private int secondRandomInt;

			[SetUp]
			public void Setup()
			{
				theQueue = new Queue();
				Random random = new Random();
				firstRandomInt = random.Next(1, int.MaxValue);
				secondRandomInt = random.Next(1, int.MaxValue);
			}

			[Test]
			public void PlaceFirstIntOnFront()
			{
				PerformTwoEnqueues();
				Assert.AreEqual(firstRandomInt, theQueue.GetFront());
			}

			[Test]
			public void PlaceSecondIntOnRear()
			{
				PerformTwoEnqueues();
				Assert.AreEqual(secondRandomInt, theQueue.GetRear());
			}

			[Test]
			public void FollowedByOneDequeue_ReturnFirstInt()
			{
				PerformTwoEnqueues();
				int result = theQueue.Dequeue();
				Assert.AreEqual(firstRandomInt, result);
			}

			[Test]
			public void FollowedByTwoDequeues_ReturnIntsInCorrectOrder()
			{
				PerformTwoEnqueues();
				int firstDequeueResult = theQueue.Dequeue();
				int secondDequeueResult = theQueue.Dequeue();
				Assert.AreEqual(firstRandomInt, firstDequeueResult);
				Assert.AreEqual(secondRandomInt, secondDequeueResult);
			}

			[Test]
			public void FollowedByTwoDequeues_SetFrontAsNull()
			{
				PerformTwoEnqueuesThenTwoDequeues();
				Assert.IsNull(theQueue.GetFront());
			}

			[Test]
			public void FollowedByTwoDequeues_SetsRearAsNull()
			{
				PerformTwoEnqueuesThenTwoDequeues();
				Assert.IsNull(theQueue.GetRear());
			}

			private void PerformTwoEnqueues()
			{
				theQueue.Enqueue(firstRandomInt);
				theQueue.Enqueue(secondRandomInt);
			}

			private void PerformTwoDequeues()
			{
				theQueue.Dequeue();
				theQueue.Dequeue();
			}

			private void PerformTwoEnqueuesThenTwoDequeues()
			{
				PerformTwoEnqueues();
				PerformTwoDequeues();
			}
		}

		[TestFixture]
		public class OnThreeEnqueues
		{

			private Queue theQueue;
			private int firstRandomInt;
			private int secondRandomInt;
			private int thirdRandomInt;

			[SetUp]
			public void Setup()
			{
				theQueue = new Queue();
				Random random = new Random();
				firstRandomInt = random.Next(1, int.MaxValue);
				secondRandomInt = random.Next(1, int.MaxValue);
				thirdRandomInt = random.Next(1, int.MaxValue);
			}

			[Test]
			public void PlaceFirstIntOnFront()
			{
				PerformThreeEnqueues();
				Assert.AreEqual(firstRandomInt, theQueue.GetFront());
			}

			[Test]
			public void PlaceSecondIntInBuffer()
			{
				PerformThreeEnqueues();
				Assert.AreEqual(secondRandomInt, theQueue.GetBufferElementAt(0));
			}

			[Test]
			public void PlaceThirdIntOnRear()
			{
				PerformThreeEnqueues();
				Assert.AreEqual(thirdRandomInt, theQueue.GetRear());
			}

			[Test]
			public void FollowedByOneDequeue_ReturnFirstInt()
			{
				PerformThreeEnqueues();
				int result = theQueue.Dequeue();
				Assert.AreEqual(firstRandomInt, result);
			}

			[Test]
			public void FollowedByThreeDequeues_ReturnIntsInCorrectOrder()
			{
				PerformThreeEnqueues();
				int firstDequeueResult = theQueue.Dequeue();
				int secondDequeueResult = theQueue.Dequeue();
				int thirdDequeueResult = theQueue.Dequeue();
				Assert.AreEqual(firstRandomInt, firstDequeueResult);
				Assert.AreEqual(secondRandomInt, secondDequeueResult);
				Assert.AreEqual(thirdRandomInt, thirdDequeueResult);
			}

			[Test]
			public void FollowedByThreeDequeues_SetFrontAsNull()
			{
				PerformThreeEnqueuesThenThreeDequeues();
				Assert.IsNull(theQueue.GetFront());
			}

			[Test]
			public void FollowedByThreeDequeues_SetsBufferAsEmpty()
			{
				PerformThreeEnqueuesThenThreeDequeues();
				Assert.AreEqual(0, theQueue.GetBufferSize());
			}

			[Test]
			public void FollowedByThreeDequeues_SetsRearAsNull()
			{
				PerformThreeEnqueuesThenThreeDequeues();
				Assert.IsNull(theQueue.GetRear());
			}

			private void PerformThreeEnqueues()
			{
				theQueue.Enqueue(firstRandomInt);
				theQueue.Enqueue(secondRandomInt);
				theQueue.Enqueue(thirdRandomInt);
			}

			private void PerformThreeDequeues()
			{
				theQueue.Dequeue();
				theQueue.Dequeue();
				theQueue.Dequeue();
			}

			private void PerformThreeEnqueuesThenThreeDequeues()
			{
				PerformThreeEnqueues();
				PerformThreeDequeues();
			}
		}

		[TestFixture]
		public class OnFourEnqueues
		{

			private Queue theQueue;
			private int firstRandomInt;
			private int secondRandomInt;
			private int thirdRandomInt;
			private int fourthRandomInt;

			[SetUp]
			public void Setup()
			{
				theQueue = new Queue();
				Random random = new Random();
				firstRandomInt = random.Next(1, int.MaxValue);
				secondRandomInt = random.Next(1, int.MaxValue);
				thirdRandomInt = random.Next(1, int.MaxValue);
				fourthRandomInt = random.Next(1, int.MaxValue);
			}

			[Test]
			public void PlaceFirstIntOnFront()
			{
				PerformFourEnqueues();
				Assert.AreEqual(firstRandomInt, theQueue.GetFront());
			}

			[Test]
			public void PlaceSecondIntInBuffer()
			{
				PerformFourEnqueues();
				Assert.AreEqual(secondRandomInt, theQueue.GetBufferElementAt(0));
			}

			[Test]
			public void PlaceThirdIntInBuffer()
			{
				PerformFourEnqueues();
				Assert.AreEqual(thirdRandomInt, theQueue.GetBufferElementAt(1));
			}

			[Test]
			public void PlaceFourthIntOnRear()
			{
				PerformFourEnqueues();
				Assert.AreEqual(fourthRandomInt, theQueue.GetRear());
			}

			[Test]
			public void FollowedByOneDequeue_ReturnFirstInt()
			{
				PerformFourEnqueues();
				int result = theQueue.Dequeue();
				Assert.AreEqual(firstRandomInt, result);
			}

			[Test]
			public void FollowedByFourDequeues_ReturnIntsInCorrectOrder()
			{
				PerformFourEnqueues();
				int firstDequeueResult = theQueue.Dequeue();
				int secondDequeueResult = theQueue.Dequeue();
				int thirdDequeueResult = theQueue.Dequeue();
				int fourthDequeueResult = theQueue.Dequeue();
				Assert.AreEqual(firstRandomInt, firstDequeueResult);
				Assert.AreEqual(secondRandomInt, secondDequeueResult);
				Assert.AreEqual(thirdRandomInt, thirdDequeueResult);
				Assert.AreEqual(fourthDequeueResult, fourthDequeueResult);
			}

			[Test]
			public void FollowedByFourDequeues_SetFrontAsNull()
			{
				PerformFourEnqueuesThenFourDequeues();
				Assert.IsNull(theQueue.GetFront());
			}

			[Test]
			public void FollowedByFourDequeues_SetsBufferAsEmpty()
			{
				PerformFourEnqueuesThenFourDequeues();
				Assert.AreEqual(0, theQueue.GetBufferSize());
			}

			[Test]
			public void FollowedByFourDequeues_SetsRearAsNull()
			{
				PerformFourEnqueuesThenFourDequeues();
				Assert.IsNull(theQueue.GetRear());
			}

			private void PerformFourEnqueues()
			{
				theQueue.Enqueue(firstRandomInt);
				theQueue.Enqueue(secondRandomInt);
				theQueue.Enqueue(thirdRandomInt);
				theQueue.Enqueue(fourthRandomInt);
			}

			private void PerformFourDequeues()
			{
				theQueue.Dequeue();
				theQueue.Dequeue();
				theQueue.Dequeue();
				theQueue.Dequeue();
			}

			private void PerformFourEnqueuesThenFourDequeues()
			{
				PerformFourEnqueues();
				PerformFourDequeues();
			}
		}

		[TestFixture]
		public class OnFiveEnqueues
		{

			private Queue theQueue;
			private int firstRandomInt;
			private int secondRandomInt;
			private int thirdRandomInt;
			private int fourthRandomInt;
			private int fifthRandomInt;

			[SetUp]
			public void Setup()
			{
				theQueue = new Queue();
				Random random = new Random();
				firstRandomInt = random.Next(1, int.MaxValue);
				secondRandomInt = random.Next(1, int.MaxValue);
				thirdRandomInt = random.Next(1, int.MaxValue);
				fourthRandomInt = random.Next(1, int.MaxValue);
				fifthRandomInt = random.Next(1, int.MaxValue);
			}

			[Test]
			public void PlaceFirstIntOnFront()
			{
				PerformFiveEnqueues();
				Assert.AreEqual(firstRandomInt, theQueue.GetFront());
			}

			[Test]
			public void PlaceSecondIntInBuffer()
			{
				PerformFiveEnqueues();
				Assert.AreEqual(secondRandomInt, theQueue.GetBufferElementAt(0));
			}

			[Test]
			public void PlaceThirdIntInBuffer()
			{
				PerformFiveEnqueues();
				Assert.AreEqual(thirdRandomInt, theQueue.GetBufferElementAt(1));
			}

			[Test]
			public void PlaceFourthIntInBuffer()
			{
				PerformFiveEnqueues();
				Assert.AreEqual(fourthRandomInt, theQueue.GetBufferElementAt(2));
			}

			[Test]
			public void PlaceFifthIntOnRear()
			{
				PerformFiveEnqueues();
				Assert.AreEqual(fifthRandomInt, theQueue.GetRear());
			}


			[Test]
			public void FollowedByOneDequeue_ReturnFirstInt()
			{
				PerformFiveEnqueues();
				int result = theQueue.Dequeue();
				Assert.AreEqual(firstRandomInt, result);
			}

			[Test]
			public void FollowedByFiveDequeues_ReturnIntsInCorrectOrder()
			{
				PerformFiveEnqueues();
				int firstDequeueResult = theQueue.Dequeue();
				int secondDequeueResult = theQueue.Dequeue();
				int thirdDequeueResult = theQueue.Dequeue();
				int fourthDequeueResult = theQueue.Dequeue();
				int fifthDequeueResult = theQueue.Dequeue();
				Assert.AreEqual(firstRandomInt, firstDequeueResult);
				Assert.AreEqual(secondRandomInt, secondDequeueResult);
				Assert.AreEqual(thirdRandomInt, thirdDequeueResult);
				Assert.AreEqual(fourthDequeueResult, fourthDequeueResult);
				Assert.AreEqual(fifthDequeueResult, fifthDequeueResult);
			}

			[Test]
			public void FollowedByFiveDequeues_SetFrontAsNull()
			{
				PerformFiveEnqueuesThenFiveDequeues();
				Assert.IsNull(theQueue.GetFront());
			}

			[Test]
			public void FollowedByFiveDequeues_SetsBufferAsEmpty()
			{
				PerformFiveEnqueuesThenFiveDequeues();
				Assert.AreEqual(0, theQueue.GetBufferSize());
			}

			[Test]
			public void FollowedByFiveDequeues_SetsRearAsNull()
			{
				PerformFiveEnqueuesThenFiveDequeues();
				Assert.IsNull(theQueue.GetRear());
			}

			private void PerformFiveEnqueues()
			{
				theQueue.Enqueue(firstRandomInt);
				theQueue.Enqueue(secondRandomInt);
				theQueue.Enqueue(thirdRandomInt);
				theQueue.Enqueue(fourthRandomInt);
				theQueue.Enqueue(fifthRandomInt);
			}

			private void PerformFiveDequeues()
			{
				theQueue.Dequeue();
				theQueue.Dequeue();
				theQueue.Dequeue();
				theQueue.Dequeue();
				theQueue.Dequeue();
			}

			private void PerformFiveEnqueuesThenFiveDequeues()
			{
				PerformFiveEnqueues();
				PerformFiveDequeues();
			}
		}


		[TestFixture]
		public class HandleExceptionsSuchThatIt
		{
			private Queue theQueue;
			private int firstRandomInt;

			private List<int> enqueueList = new List<int>();

			[SetUp]
			public void Setup()
			{
				theQueue = new Queue();
				Random random = new Random();
				firstRandomInt = random.Next(1, int.MaxValue);
			}

			[Test]
			public void ThrowsEmptyQueueException_OnOneDequeueWithNoEnqueues()
			{
				Assert.Throws<Queue.EmptyQueueException>(() => theQueue.Dequeue());
			}

			[Test]
			public void ThrowsEmptyQueueException_OnOneEnqueueFollowedByTwoDequeues()
			{
				theQueue.Enqueue(firstRandomInt);
				theQueue.Dequeue();
				Assert.Throws<Queue.EmptyQueueException>(() => theQueue.Dequeue());
			}

			[Test]
			public void ThrowsEmptyQueueException_OnXEnqueuesFollowedByXPlusOneDequeues()
			{
				// Arrange
				Random random = new Random();
				int xEnqueues = random.Next(1, 9999);
				for (int i = 0; i < xEnqueues; i++)
				{
					enqueueList.Add(random.Next(1, int.MaxValue - 1));
				}

				// Act
				foreach (int item in enqueueList)
				{
					theQueue.Enqueue(item);
				}
				for (int i = 0; i < xEnqueues; i++)
				{
					theQueue.Dequeue();
				}

				// Assert
				Assert.Throws<Queue.EmptyQueueException>(() => theQueue.Dequeue());
			}
		}


		[TestFixture]
		public class PerformSanityCheckSuchThatIt
		{
			private Queue theQueue;
			private int firstRandomInt;
			private int secondRandomInt;

			[SetUp]
			public void Setup()
			{
				theQueue = new Queue();
				Random random = new Random();
				firstRandomInt = random.Next(1, int.MaxValue);
				secondRandomInt = random.Next(1, int.MaxValue);
			}

			[Test]
			public void ReturnsIntsInCorrectOrder_OnEnqueueThenDequeueThenEnqueueThenDequeue()
			{
				theQueue.Enqueue(firstRandomInt);
				int firstDequeueResult = theQueue.Dequeue();
				theQueue.Enqueue(secondRandomInt);
				int secondDequeueResult = theQueue.Dequeue();
				Assert.AreEqual(firstRandomInt, firstDequeueResult);
				Assert.AreEqual(secondRandomInt, secondDequeueResult);
			}
		}
	}
}
