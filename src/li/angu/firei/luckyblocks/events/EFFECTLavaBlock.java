package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;

public class EFFECTLavaBlock {

	public EFFECTLavaBlock(Location loc) {
		loc.getBlock().setType(Material.LAVA);
	}

}
