namespace Prototype
{
	public class BombedWall : Wall
	{
		public BombedWall()
		{

		}

		public BombedWall(BombedWall other) : base(other)
		{

		}

		public override Wall Clone()
		{
			return new BombedWall(this);
		}
	}
}