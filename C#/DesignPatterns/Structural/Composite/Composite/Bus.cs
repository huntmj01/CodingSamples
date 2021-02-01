namespace Composite
{
	public class Bus : EquipmentComposite
	{
		public Bus(string name) : base(name)
		{
			SetName(name);
		}

		public override Watt Power()
		{
			return null;
		}

		public override decimal NetPrice()
		{
			decimal total = 1;
			return total;
		}

		public override decimal DiscountPrice()
		{
			return 0.0m;
		}
	}
}
