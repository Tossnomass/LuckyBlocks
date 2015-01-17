package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTMusic {

	public EFFECTMusic(Location loc) {
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.JUKEBOX, 10));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.RECORD_3));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.RECORD_4));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.RECORD_5));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.RECORD_6));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.RECORD_7));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.RECORD_8));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.RECORD_9));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.RECORD_10));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.RECORD_11));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.RECORD_12));
	}

}
