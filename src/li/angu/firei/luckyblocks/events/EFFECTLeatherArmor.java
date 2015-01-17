package li.angu.firei.luckyblocks.events;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EFFECTLeatherArmor {

	public EFFECTLeatherArmor(Location loc) {

		ItemStack is = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemMeta meta = is.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Leder Hose");
		is.setItemMeta(meta);
		is.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
		loc.getWorld().dropItemNaturally(loc, is);
		
	}

}
