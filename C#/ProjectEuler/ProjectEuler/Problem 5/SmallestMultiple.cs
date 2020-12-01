using System;

namespace ProjectEuler.Problem_5
{
	public class SmallestMultiple
	{
		public int GetSmallestMultipleDivisibleByAllNumbersBetween(int start, int end)
		{

			FailIfLessThanOne(start, end);

			if (start == end)
				return start + end;
			else if (start == 1)
				return end * 2;
			else if (end - start == 1 || end - start == 2)
				if ((end * start) % 2 == 0)
					return (end * start) / 2;
				else
					return end * start;
			else
				return 0;


			//int smallestMultiple = 0;
			//bool isMultiple = false;

			//for (int number = end + 1; isMultiple == false; number++)
			//{
			//	isMultiple = true;
			//	for (int j = start; j < end + 1; j++)
			//	{
			//		if (!IsMultiple(number, j))
			//		{
			//			isMultiple = false;
			//			break;
			//		}
			//	}
			//	if (isMultiple)
			//	{
			//		smallestMultiple = number;
			//		break;
			//	}
			//}
			//return smallestMultiple;

		}

		public bool IsMultiple(int number, int divisor)
		{
			FailIfLessThanOne(number, divisor);

			return number % divisor == 0;
		}

		private static void FailIfLessThanOne(int param1, int param2)
		{
			if (param1 < 1 || param2 < 1)
				throw new IntParamCanNotBeLessThanOneException();
		}

		public class IntParamCanNotBeLessThanOneException : Exception { }
	}
}
