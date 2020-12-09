using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using ModernSingleton;

namespace ModernSingleton.Controllers
{
	[ApiController]
	[Route("[controller]")]
	public class MyController : ControllerBase
	{
		private readonly ILogger<MyController> _logger;
		private readonly IModernSingletonExample _modernSingleton;

		public MyController(ILogger<MyController> logger, IModernSingletonExample modernSingleton)
		{
			_logger = logger;
			_modernSingleton = modernSingleton;
		}

		[HttpGet]
		public string Get()
		{
			return _modernSingleton.Prop1;
		}
	}
}
