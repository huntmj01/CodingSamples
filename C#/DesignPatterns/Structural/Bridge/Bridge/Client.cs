using System;
using System.Collections.Generic;
using System.Text;

namespace Bridge
{
	public class Client
	{
		public Client()
		{
			
		}

		public App CreateApp(string windowType)
		{
			App app = new App(windowType);

			app.AddApplicationWindow();
			app.AddIconWindow();
			app.AddTransientWindow();

			return app;
		}
	}
}
