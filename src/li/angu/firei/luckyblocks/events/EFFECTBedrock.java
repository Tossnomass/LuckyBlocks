package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;

public class EFFECTBedrock {

	public EFFECTBedrock(Location loc) {
		loc.getBlock().setType(Material.BEDROCK);
	}

}
