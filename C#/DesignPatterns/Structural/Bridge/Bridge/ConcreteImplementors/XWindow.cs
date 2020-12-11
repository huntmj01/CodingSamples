using System;

namespace Bridge
{
	public class XWindow : WindowImplementation
	{
		private Display _dpy;
		private Drawable _windowId;
		private GraphicComp _gc;

		public override void DeviceRect(Coordinate x0, Coordinate y0, Coordinate x1, Coordinate y1)
		{
			double x = Math.Round(Math.Min(x0.Value, x1.Value));
			double y = Math.Round(Math.Min(y0.Value, y1.Value));
			double w = Math.Round(Math.Abs(x0.Value - x1.Value));
			double h = Math.Round(Math.Abs(y0.Value - y1.Value));
			XDrawRectangle(_dpy, _windowId, _gc, x, y, w, h);
		}

		private void XDrawRectangle(Display dpy, Drawable windowId, GraphicComp gc, double x, double y, double w, double h)
		{
			
		}
	}
}
