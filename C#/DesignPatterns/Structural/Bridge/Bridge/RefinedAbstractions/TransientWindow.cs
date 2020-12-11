using System;
using System.Drawing;

namespace Bridge
{
	public class TransientWindow : WindowAbstraction
	{
		public TransientWindow(string windowType) : base(windowType, new View())
		{

		}
	}
}
