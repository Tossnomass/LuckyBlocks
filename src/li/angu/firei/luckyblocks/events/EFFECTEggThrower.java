package li.angu.firei.luckyblocks.events;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EFFECTEggThrower {

	public EFFECTEggThrower(Location loc) {

		ItemStack stack = new ItemStack(Material.DIAMOND_SPADE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_PURPLE + "EggThrower");
		stack.setItemMeta(meta);

		loc.getWorld().dropItemNaturally(loc, stack);

	}

}
