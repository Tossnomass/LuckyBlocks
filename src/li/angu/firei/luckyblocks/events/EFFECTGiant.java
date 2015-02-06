package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class EFFECTGiant {

	@SuppressWarnings("deprecation")
	public EFFECTGiant(Location loc) {

		loc.getWorld().spawnCreature(loc, EntityType.GIANT);
	}

}
