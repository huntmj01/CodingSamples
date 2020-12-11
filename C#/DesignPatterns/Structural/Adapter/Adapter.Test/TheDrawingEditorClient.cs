using Adapter.DrawingEditorComponents;
using NUnit.Framework;
using System.Linq;

namespace Adapter.Test
{
	public class TheDrawingEditorClient
	{
		private DrawingEditorClient _client;
		private DrawingEditor _editor;

		[SetUp]
		public void Setup()
		{
			_client = new DrawingEditorClient();
			_editor = _client.CreateDrawingEditor();
		}

		[Test]
		public void ShouldExist()
		{
			Assert.IsNotNull(_client);
		}

		[Test]
		public void WhenCreatingDrawingEditor_ReturnsDrawingEditor()
		{
			Assert.IsInstanceOf<DrawingEditor>(_editor);
		}

		[Test]
		public void WhenCreatingDrawingEditor_FirstItAddsALineToTheDrawingEditor()
		{
			var actual = _editor.Shapes.First();
			Assert.IsInstanceOf<Line>(actual);
		}

		[Test]
		public void WhenCreatingDrawingEditor_LastItAddsATextViewToTheDrawingEditor()
		{
			var actual = _editor.Shapes.Last();
			Assert.IsInstanceOf<TextShapeAdapter>(actual);
		}
	}
}