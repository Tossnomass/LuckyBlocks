package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class EFFECTGhast {

	@SuppressWarnings("deprecation")
	public EFFECTGhast(Location loc) {
		loc.getWorld().spawnCreature(loc, EntityType.GHAST);
	}

}
