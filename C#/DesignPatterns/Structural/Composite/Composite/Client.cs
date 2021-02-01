namespace Composite
{
	public class Client
	{
		public string CreateClient()
		{
			Cabinet cabinet = new Cabinet("PC Cabinet");
			Chassis chassis = new Chassis("PC Chassis");

			cabinet.Add(chassis);

			Bus bus = new Bus("MCS Bus");
			bus.Add(new Card("16 Mbs Token Ring"));

			chassis.Add(bus);
			chassis.Add(new FloppyDisk("3.5in Floppy"));

			return "The net price is " + chassis.NetPrice();
		}
	}
}
