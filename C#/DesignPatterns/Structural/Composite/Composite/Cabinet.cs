namespace Composite
{
	public class Cabinet : EquipmentComposite
	{

		public Cabinet(string name) : base(name)
		{
			SetName(name);
		}

		public override Watt Power()
		{
			return null;
		}

		public override decimal NetPrice()
		{
			decimal total = 2;
			return total;
		}

		public override decimal DiscountPrice()
		{
			return 0.0m;
		}
	}
}
