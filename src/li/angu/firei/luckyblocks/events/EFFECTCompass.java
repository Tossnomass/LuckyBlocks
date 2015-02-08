package li.angu.firei.luckyblocks.events;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EFFECTCompass {

	public EFFECTCompass(Location loc) {

		ItemStack stack = new ItemStack(Material.COMPASS);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Kompass");
		stack.setItemMeta(meta);

		loc.getWorld().dropItemNaturally(loc, stack);

	}

}
