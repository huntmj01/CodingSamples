using Adapter.DrawingEditorComponents;
using System.Drawing;

namespace Adapter
{
	public abstract class ShapeTarget
	{
		public ShapeTarget() {

		}

		public abstract void BoundingBox(Point bottomLeft, Point topRight);
		public abstract Manipulator CreateManipulator();
	}
}
