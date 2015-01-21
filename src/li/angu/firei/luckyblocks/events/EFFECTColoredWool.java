package li.angu.firei.luckyblocks.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTColoredWool {

	public EFFECTColoredWool(Location loc) {
		
		for (int i = 0; i < 15; i++) {
			int anzahl = new Random().nextInt(20) + 10;
			ItemStack is = new ItemStack(Material.WOOL, anzahl);
			is.setDurability((short) i); 
			loc.getWorld().dropItemNaturally(loc, is);
		}
		
	}

}
