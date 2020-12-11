using System.Collections.Generic;

namespace Adapter.DrawingEditorComponents
{

	public class DrawingEditor
	{
		public List<ShapeTarget> Shapes { get; private set; }

		public DrawingEditor()
		{
			Shapes = new List<ShapeTarget>();
		}

		public void AddShape(ShapeTarget shape)
		{
			Shapes.Add(shape);
		}
	}
}
