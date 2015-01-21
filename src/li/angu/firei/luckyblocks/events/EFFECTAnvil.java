package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;

public class EFFECTAnvil {

	public EFFECTAnvil(Location loc) {
		loc.getBlock().setType(Material.ANVIL);
	}

}
