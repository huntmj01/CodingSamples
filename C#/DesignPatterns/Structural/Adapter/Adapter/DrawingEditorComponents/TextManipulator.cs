namespace Adapter.DrawingEditorComponents
{
	public class TextManipulator : Manipulator
	{
		private TextShapeAdapter _shape { get; set; }

		public TextManipulator(TextShapeAdapter Shape)
		{
			_shape = Shape;
		}
	}
}