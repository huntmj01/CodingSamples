namespace Bridge
{
	public class ApplicationWindow : WindowAbstraction
	{
		private static View _view = new View();

		public ApplicationWindow(string windowType) : base(windowType, _view)
		{
			
		}

		public override void DrawContents()
		{
			GetView().DrawOn(this);
		}
	}
}
