namespace Prototype.Prototypes
{
	public class DoorNeedingSpell : Door
	{
		public DoorNeedingSpell()
		{

		}

		public DoorNeedingSpell(Door other) : base(other)
		{

		}

		public override Door Clone()
		{
			return new DoorNeedingSpell(this);
		}
	}
}