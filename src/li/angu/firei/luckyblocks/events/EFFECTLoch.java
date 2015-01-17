package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;

public class EFFECTLoch {

	public EFFECTLoch(Location loc) {
		while(loc.getBlockY() >= 0){
			loc.getBlock().setType(Material.AIR);
			loc.add(0, -1, 0);
		}
	}

}
