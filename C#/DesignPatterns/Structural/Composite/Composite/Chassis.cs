namespace Composite
{
	public class Chassis : EquipmentComposite
	{
		public Chassis(string name) : base(name)
		{
			SetName(name);
		}

		public override Watt Power()
		{
			return null;
		}

		public override decimal NetPrice()
		{
			return base.NetPrice();
		}

		public override decimal DiscountPrice()
		{
			return 0.0m;
		}
	}
}
