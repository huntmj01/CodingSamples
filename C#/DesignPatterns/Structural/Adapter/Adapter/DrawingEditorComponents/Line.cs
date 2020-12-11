using System.Drawing;

namespace Adapter.DrawingEditorComponents
{
	public class Line : ShapeTarget
	{
		public Line() 
		{

		}

		public override void BoundingBox(Point bottomLeft, Point topRight)
		{

		}

		public override Manipulator CreateManipulator()
		{
			return new Manipulator();
		}
	}
}
