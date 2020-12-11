using Adapter.DrawingEditorComponents;
using System.Drawing;

namespace Adapter
{
	// TextShape is an adapter for TextView and Shape
	public class TextShapeAdapter : ShapeTarget
	{
		private TextViewAdaptee _text;

		public TextShapeAdapter(TextViewAdaptee textView)
		{
			_text = textView;
		}

		public override void BoundingBox(Point bottomLeft, Point topRight)
		{
			var bottom = new Coordinate();
			var left = new Coordinate();
			var width = new Coordinate();
			var height = new Coordinate();

			_text.GetOrigin(bottom, left);
			_text.GetExtent(width, height);
		}

		public override Manipulator CreateManipulator()
		{
			return new TextManipulator(this);
		}

		public bool IsEmpty()
		{
			return _text.IsEmpty();
		}
	}
}
