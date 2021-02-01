namespace Composite
{
	public class Card : EquipmentComposite
	{

		public Card(string name) : base(name)
		{

		}

		public override Watt Power()
		{
			return null;
		}

		public override decimal NetPrice()
		{
			decimal total = 3;
			return total;
		}

		public override decimal DiscountPrice()
		{
			return 0.0m;
		}
	}
}
