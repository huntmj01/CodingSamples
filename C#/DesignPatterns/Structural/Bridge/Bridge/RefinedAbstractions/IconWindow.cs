namespace Bridge
{
	public class IconWindow : WindowAbstraction
	{
		private const string _bitmapName = "name_of_icon_to_display";

		public IconWindow(string windowType) : base(windowType, new View())
		{
			WindowImplementation imp = GetWindowImp();
			if (imp != null)
			{
				imp.DeviceBitmap(_bitmapName, new Coordinate(0.0), new Coordinate(0.0));
			}
		}
	}
}
