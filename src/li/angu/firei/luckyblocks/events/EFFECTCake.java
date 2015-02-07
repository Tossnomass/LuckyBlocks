package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;

public class EFFECTCake {

	public EFFECTCake(Location loc) {
		loc.getBlock().setType(Material.CAKE_BLOCK);
	}

}
