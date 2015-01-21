package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTFische {

	public EFFECTFische(Location loc) {
		for (int i = 0; i < 3; i++) {
			ItemStack is = new ItemStack(Material.RAW_FISH);
			is.setDurability((short) i);
			loc.getWorld().dropItemNaturally(loc, is);
		}
		
	}

}
