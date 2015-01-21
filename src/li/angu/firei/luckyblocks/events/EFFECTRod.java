package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTRod {

	public EFFECTRod(Location loc) {

		loc.getWorld().dropItemNaturally(loc,
				new ItemStack(Material.FISHING_ROD));

	}

}
