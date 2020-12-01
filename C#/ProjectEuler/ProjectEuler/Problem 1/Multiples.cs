using System;
using System.Collections.Generic;
using System.Text;

namespace ProjectEuler.Problem_1
{
	public class Multiples
	{
		public int GetNumbersThatAreMultiplesOf3Or5ThatAreBellow(int naturalNumber)
		{
			int result = 0;

			for (int i = 1; i < naturalNumber; i++)
			{
				if (i % 3 == 0 || i % 5 == 0)
				{
					result += i;
				}
			}

			return result;
		}
	}
}
