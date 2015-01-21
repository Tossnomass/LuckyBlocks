package li.angu.firei.luckyblocks.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class EFFECTSpiderInvasion {

	public EFFECTSpiderInvasion(Location loc) {
		int anzahl = new Random().nextInt(5) + 3;
		for (int i = 0; i < anzahl; i++) {
			loc.getWorld().spawnCreature(loc, EntityType.SPIDER);
		}
	}

}
