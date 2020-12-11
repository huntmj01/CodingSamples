using System.Collections.Generic;
using System.Linq;

namespace Bridge
{
	public class App
	{
		private List<WindowAbstraction> _windows;
		private string _windowType;

		public App(string windowType)
		{
			_windows = new List<WindowAbstraction>();
			_windowType = windowType;
		}

		public void AddApplicationWindow()
		{
			_windows.Add(new ApplicationWindow(_windowType));
		}

		public void AddIconWindow()
		{
			_windows.Add(new IconWindow(_windowType));
		}

		public void AddTransientWindow()
		{
			_windows.Add(new TransientWindow(_windowType));
		}

		public WindowAbstraction WindowAt(int index)
		{
			return _windows.ElementAt(index);
		}
	}
}
