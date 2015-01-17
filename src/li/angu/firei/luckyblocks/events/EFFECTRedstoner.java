package li.angu.firei.luckyblocks.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTRedstoner {

	public EFFECTRedstoner(Location loc) {
		int anzahl = new Random().nextInt(32) + 1;
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.REDSTONE, anzahl));
		anzahl = new Random().nextInt(32) + 1;
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.REDSTONE_COMPARATOR, anzahl));
		anzahl = new Random().nextInt(32) + 1;
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.DIODE, anzahl));
		anzahl = new Random().nextInt(10) + 1;
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.DAYLIGHT_DETECTOR, anzahl));
	}


}
