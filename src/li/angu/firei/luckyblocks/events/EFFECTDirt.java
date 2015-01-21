package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTDirt {

	public EFFECTDirt(Location loc) {

		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.DIRT));

	}

}
