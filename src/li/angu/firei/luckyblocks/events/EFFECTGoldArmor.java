package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTGoldArmor {

	public EFFECTGoldArmor(Location loc) {
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.GOLD_HELMET, 1));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.GOLD_CHESTPLATE, 1));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.GOLD_LEGGINGS, 1));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.GOLD_BOOTS, 1));
	}

}
