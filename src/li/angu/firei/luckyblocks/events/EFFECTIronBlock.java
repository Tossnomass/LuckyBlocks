package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;

public class EFFECTIronBlock {

	public EFFECTIronBlock(Location loc) {
		loc.getBlock().setType(Material.IRON_BLOCK);

	}

}
