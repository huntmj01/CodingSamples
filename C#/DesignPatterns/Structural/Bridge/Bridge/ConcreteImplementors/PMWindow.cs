using System;
using System.Drawing;

namespace Bridge
{
	public class PMWindow : WindowImplementation
	{
		private HPS _hps;

		public override void DeviceRect(Coordinate x0, Coordinate y0, Coordinate x1, Coordinate y1)
		{
			double left = Math.Min(x0.Value, x1.Value);
			double right = Math.Max(x0.Value, x1.Value);
			double bottom = Math.Min(y0.Value, y1.Value);
			double top = Math.Min(y0.Value, y1.Value);

			Point[] points = new Point[4];

			points[0].X = (int)left;
			points[1].X = (int)right;
			points[2].X = (int)right;
			points[3].X = (int)left;

			points[0].Y = (int)top;
			points[1].Y = (int)top;
			points[2].Y = (int)bottom;
			points[3].Y = (int)bottom;

			if (GpiBeginPath(_hps, 1L) == false ||
				GpiSetCurrentPosition(_hps, points[3]) == false ||
				GpiPolyLine(_hps, 4L, points) == false ||
				GpiEndPath(_hps) == false) {

				// report error
			} else
			{
				GpiStrokePath(_hps, 1L, 0L);
			}
		}

		private void GpiStrokePath(HPS hps, long v1, long v2)
		{
			
		}

		private bool GpiBeginPath(HPS hps, long v)
		{
			return true;
		}

		private bool GpiSetCurrentPosition(HPS hps, Point point)
		{
			return true;
		}

		private bool GpiPolyLine(HPS hps, long v, Point[] points)
		{
			return true;
		}

		private bool GpiEndPath(HPS hps)
		{
			return true;
		}
	}
}
