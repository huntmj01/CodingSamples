namespace Composite
{
	public class FloppyDisk : EquipmentComponent
	{
		public FloppyDisk(string name) : base(name)
		{
			SetName(name);
		}

		public override Watt Power()
		{
			return null;
		}

		public override decimal NetPrice()
		{
			decimal total = 5;
			return total;
		}

		public override decimal DiscountPrice()
		{
			return 0.0m;
		}
	}
}
