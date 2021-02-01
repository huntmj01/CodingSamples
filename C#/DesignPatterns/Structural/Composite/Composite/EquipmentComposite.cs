using System.Collections.Generic;

namespace Composite
{
	public class EquipmentComposite : EquipmentComponent
	{
		private List<EquipmentComponent> _equipment;

		protected EquipmentComposite(string name) : base(name)
		{
			_equipment = new List<EquipmentComponent>();
			SetName(name);
		}

		public override Watt Power()
		{
			return null;
		}

		public override decimal NetPrice()
		{
			IEnumerable<EquipmentComponent> iterator = CreateIterator();
			decimal total = 0;

			foreach (var equipment in iterator)
			{
				total += equipment.NetPrice();
			}

			return total;
		}

		public override decimal DiscountPrice()
		{
			return 0.0m;
		}

		public override void Add(EquipmentComponent equipment)
		{
			_equipment.Add(equipment);
		}

		public override void Remove(EquipmentComponent equipment)
		{
			_equipment.Remove(equipment);
		}

		public override IEnumerable<EquipmentComponent> CreateIterator()
		{
			IEnumerable<EquipmentComponent> iterator = _equipment;
			return iterator;
		}
	}
}
