namespace Prototype
{
	public class EnchantedRoom : Room
	{
		private Spell _spell;

		public EnchantedRoom()
		{

		}

		public EnchantedRoom(Room room, Spell spell) : base(room)
		{
			_spell = spell;
		}

		public override Room Clone()
		{
			return new EnchantedRoom(this, _spell);
		}
	}
}
