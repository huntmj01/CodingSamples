namespace Prototype
{
	public class Wall : MapSite
	{
		public Wall()
		{

		}

		public Wall(Wall other)
		{

		}

		public virtual void Initialize()
		{

		}

		public virtual Wall Clone()
		{
			return new Wall(this);
		}

		public override void Enter()
		{
			
		}
	}
}
