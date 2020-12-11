using System.Drawing;

namespace Bridge
{
	public class WindowAbstraction
	{
		private WindowImplementation _imp;
		private string _windowType;
		private View _contents;

		public WindowAbstraction(string windowType, View contents)
		{
			_windowType = windowType;
		}

		public virtual void DrawContents(){ }
		public virtual void Open(){ }
		public virtual void Close(){ }
		public virtual void Iconify(){ }
		public virtual void Deiconify(){ }
			   
		public virtual void SetOrigin(Point at){ }
		public virtual void SetExtent(Point extent){ }
		public virtual void Raise(){ }
		public virtual void Lower(){ }
			   
		public virtual void DrawLine(Point point1, Point point2){ }

		public virtual void DrawRect(Point point1, Point point2){
			WindowImplementation imp = GetWindowImp();
			imp.DeviceRect(new Coordinate(point1.X), new Coordinate(point1.Y), new Coordinate(point2.X), new Coordinate(point2.Y));
		}

		public virtual void DrawPolygon(Point[] points, int n){ }
		public virtual void DrawText(char character, Point point){ }

		public WindowImplementation GetWindowImp()
		{
			if (_imp == null)
			{
				if (_windowType == "PM")
				{
					_imp = new PMWindow();
				}
				else
				{
					_imp = new XWindow();
				}
			}
			return _imp;
		}

		protected View GetView()
		{
			return _contents;
		}
	}
}
