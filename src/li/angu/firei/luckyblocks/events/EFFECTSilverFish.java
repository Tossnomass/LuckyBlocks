package li.angu.firei.luckyblocks.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class EFFECTSilverFish {

	public EFFECTSilverFish(Location loc) {
		int anzahl = new Random().nextInt(5) + 1;
		for (int i = 0; i < anzahl; i++) {
			loc.getWorld().spawnCreature(loc, EntityType.SILVERFISH);
		}
	}

}
