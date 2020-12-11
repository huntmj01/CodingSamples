using Adapter.DrawingEditorComponents;

namespace Adapter
{
	public class DrawingEditorClient
	{
		public DrawingEditorClient()
		{

		}

		public DrawingEditor CreateDrawingEditor()
		{
			// Notice how TextShape adapts TextView to the Shape interface so that 
			// TextView can be added to the editor as a Shape. An adapter focuses on
			// resolving incompatibilities between two interfaces and therefore makes
			// things work after they are designed where as Bridge makes them work 
			// before they are designed.

			DrawingEditor editor = new DrawingEditor();
			ShapeTarget shape1 = new Line();
			TextViewAdaptee textView = new TextViewAdaptee();
			ShapeTarget shape2 = new TextShapeAdapter(textView);

			editor.AddShape(shape1);
			editor.AddShape(shape2);

			return editor;
		}
	}
}
