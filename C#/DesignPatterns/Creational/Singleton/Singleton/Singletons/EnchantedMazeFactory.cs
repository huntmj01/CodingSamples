﻿namespace Singleton.Singletons
{
	public class EnchantedMazeFactory : MazeFactorySingleton
	{
		public override Door MakeDoor(Room room1, Room room2)
		{
			return new DoorNeedingSpell(room1, room2);
		}

		public override Room MakeRoom(int roomNumber)
		{
			return new EnchantedRoom(roomNumber, CastSpell());
		}

		private Spell CastSpell()
		{
			return new Spell();
		}
	}
}
