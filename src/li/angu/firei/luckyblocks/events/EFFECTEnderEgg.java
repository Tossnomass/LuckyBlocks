package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;

public class EFFECTEnderEgg {

	public EFFECTEnderEgg(Location loc) {
		loc.getBlock().setType(Material.DRAGON_EGG);
	}

}
