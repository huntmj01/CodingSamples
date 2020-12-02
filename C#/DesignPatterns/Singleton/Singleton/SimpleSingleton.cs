namespace Singleton
{
	// When applied to a class, the sealed modifier prevents other classes from inheriting from it.
	// see: https://docs.microsoft.com/en-us/dotnet/csharp/language-reference/keywords/sealed
	public sealed class SimpleSingleton
	{
		private static SimpleSingleton _instance = null;

		public static SimpleSingleton Instance
		{
			get
			{
				// Available in C# 8.0 and later, the null-coalescing assignment operator ??= assigns 
				// the value of its right-hand operand to its left-hand operand only if the left-hand 
				// operand evaluates to null. The ??= operator doesn't evaluate its right-hand operand 
				// if the left-hand operand evaluates to non-null.
				// see: https://docs.microsoft.com/en-us/dotnet/csharp/language-reference/operators/null-coalescing-operator
				return _instance ??= new SimpleSingleton();
			}
		}

		// A private constructor is a special instance constructor. It is generally used in classes 
		// that contain static members only. If a class has one or more private constructors and 
		// no public constructors, other classes (except nested classes) cannot create instances of this class.
		// see: https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/classes-and-structs/private-constructors
		private SimpleSingleton()
		{

		}
	}
}
