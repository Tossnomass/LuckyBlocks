package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;

public class EFFECTBeacon {

	public EFFECTBeacon(Location loc) {
		loc.getBlock().setType(Material.BEACON);
	}

}
