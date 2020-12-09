namespace MethodFactory.MethodFactories
{
	public class EnchantedRoom : Room
	{
		private Spell Spell;

		public EnchantedRoom(int number, Spell spell) : base(number)
		{
			Spell = spell;
		}
	}
}
