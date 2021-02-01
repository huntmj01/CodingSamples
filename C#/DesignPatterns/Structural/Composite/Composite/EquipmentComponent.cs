using System.Collections.Generic;

namespace Composite
{
	public class EquipmentComponent
	{
		private string _name;

		protected EquipmentComponent(string name)
		{
			SetName(name);
		}

		public string GetName()
		{
			return _name;
		}

		public void SetName(string name)
		{
			_name = name;
		}

		public virtual Watt Power()
		{
			return null;
		}

		public virtual decimal NetPrice()
		{
			decimal total = 0;
			return total;
		}

		public virtual decimal DiscountPrice()
		{
			return 0.0m;
		}

		public virtual void Add(EquipmentComponent equipment)
		{

		}

		public virtual void Remove(EquipmentComponent equipment)
		{

		}

		public virtual IEnumerable<EquipmentComponent> CreateIterator() {
			return null;
		}
	}
}
