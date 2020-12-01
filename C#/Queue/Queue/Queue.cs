using System;
using System.Collections.Generic;
using System.Linq;

namespace Queue
{
	public class Queue

	{
		private int? front;
		private List<int?> buffer;
		private int? rear;

		public Queue()
		{
			buffer = new List<int?> () { };
		}

		public void Enqueue(int thisInt)
		{
			if (FrontIsNull())
			{
				SetFront(thisInt);
			}
			else if (RearIsNull())
			{
				SetRear(thisInt);
			}
			else
			{
				buffer.Add(GetRear());
				SetRear(thisInt);
			}
		}
		public int Dequeue()
		{
			FailIfFrontIsNull();

			int result = (int)GetFront();

			PerformShift();

			return result;
		}

		private void FailIfFrontIsNull()
		{
			if (FrontIsNull())
			{
				throw new EmptyQueueException();
			}
		}

		private void PerformShift()
		{
			if (BufferIsEmpty())
			{
				ShiftRearToFront();
			}
			else
			{
				ShiftFirstItemInBufferToFront();
			}
		}

		private void ShiftRearToFront()
		{
			SetFront(GetRear());
			SetRear(null);
		}


		private void ShiftFirstItemInBufferToFront()
		{
			SetFront(buffer.First());
			buffer.Remove(buffer.First());
		}

		private bool FrontIsNull()
		{
			return GetFront() == null;
		}

		private bool BufferIsEmpty()
		{
			return buffer.Count == 0;
		}

		private bool RearIsNull()
		{
			return GetRear() == null;
		}

		public class EmptyQueueException : Exception { }

		public int? GetFront()
		{
			return front;
		}

		private void SetFront(int? value)
		{
			front = value;
		}

		public int GetBufferSize()
		{
			return buffer.Count();
		}

		public int? GetBufferElementAt(int elementAt)
		{
			return buffer.ElementAt(elementAt);
		}

		public int? GetRear()
		{
			return rear;
		}

		private void SetRear(int? value)
		{
			rear = value;
		}
	}
}
