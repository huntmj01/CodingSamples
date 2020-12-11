using System.Drawing;

namespace Bridge
{
	public class WindowImplementation
	{
		protected WindowImplementation()
		{

		}

		public virtual void ImplementationTop() { }
		public virtual void ImplementationBottom() { }
		public virtual void ImplementationSetOrigin(Point at) { }
		public virtual void ImplementationSetExtent(Point extent) { }
			   
		public virtual void DeviceRect(Coordinate coordinate1, Coordinate coordinate2, Coordinate coordinate3, Coordinate coordinate4) { }
		public virtual void DeviceChar(char character, Coordinate coordinate1, Coordinate coordinate2) { }
		public virtual void DeviceBitmap(string name, Coordinate coordinate1, Coordinate coordinate2) { }
	}
}