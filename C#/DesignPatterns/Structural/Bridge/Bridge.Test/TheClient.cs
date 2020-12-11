using NUnit.Framework;

namespace Bridge.Test
{
	public class ClientTestSetup
	{
		public Client Client;
		public App App;

		public ClientTestSetup()
		{
			SetOrReset();
		}

		public void SetOrReset()
		{
			Client = null;
			App = null;
		}
	}

	public class TheClient : ClientTestSetup
	{

		[SetUp]
		public void Setup()
		{
			SetOrReset();
			Client = new Client();
		}

		[Test]
		public void ShouldExist()
		{
			Assert.IsNotNull(Client);
		}

		public class WhenCreatingPMWindowApp : ClientTestSetup
		{
			[SetUp]
			public void Setup()
			{
				SetOrReset();
				Client = new Client();
				App = Client.CreateApp("PM");
			}

			[Test]
			public void ReturnsApp()
			{
				Assert.IsInstanceOf<App>(App);
			}

			[Test]
			public void FirstAddsApplicationWindow()
			{
				Assert.IsInstanceOf<ApplicationWindow>(App.WindowAt(0));
			}

			[Test]
			public void SecondAddsIconWindow()
			{
				Assert.IsInstanceOf<IconWindow>(App.WindowAt(1));
			}

			[Test]
			public void LastAddsTransientWindow()
			{
				Assert.IsInstanceOf<TransientWindow>(App.WindowAt(2));
			}

			[Test]
			public void WindowsAreImplmentedAsPMWindows()
			{
				Assert.IsInstanceOf<PMWindow>(App.WindowAt(0).GetWindowImp());
				Assert.IsInstanceOf<PMWindow>(App.WindowAt(1).GetWindowImp());
				Assert.IsInstanceOf<PMWindow>(App.WindowAt(2).GetWindowImp());
			}
		}

		public class WhenCreatingXWindowApp : ClientTestSetup
		{
			[SetUp]
			public void Setup()
			{
				SetOrReset();
				Client = new Client();
				App = Client.CreateApp("X");
			}

			[Test]
			public void ReturnsApp()
			{
				Assert.IsInstanceOf<App>(App);
			}

			[Test]
			public void FirstAddsApplicationWindow()
			{
				Assert.IsInstanceOf<ApplicationWindow>(App.WindowAt(0));
			}

			[Test]
			public void SecondAddsIconWindow()
			{
				Assert.IsInstanceOf<IconWindow>(App.WindowAt(1));
			}

			[Test]
			public void LastAddsTransientWindow()
			{
				Assert.IsInstanceOf<TransientWindow>(App.WindowAt(2));
			}

			[Test]
			public void WindowsAreImplmentedAsXWindows()
			{
				Assert.IsInstanceOf<XWindow>(App.WindowAt(0).GetWindowImp());
				Assert.IsInstanceOf<XWindow>(App.WindowAt(1).GetWindowImp());
				Assert.IsInstanceOf<XWindow>(App.WindowAt(2).GetWindowImp());
			}
		}
	}
}