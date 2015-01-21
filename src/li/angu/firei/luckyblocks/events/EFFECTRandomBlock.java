package li.angu.firei.luckyblocks.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;

public class EFFECTRandomBlock {

	public EFFECTRandomBlock(Location loc) {
		int pick = new Random().nextInt(Material.values().length);
		Material mat = Material.values()[pick];
		loc.getBlock().setType(mat);
	}

}
