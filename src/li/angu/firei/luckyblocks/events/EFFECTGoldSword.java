package li.angu.firei.luckyblocks.events;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class EFFECTGoldSword {

	public EFFECTGoldSword(Location loc) {
		ItemStack is = new ItemStack(Material.GOLD_SWORD);
		is.setDurability((short) 32); 
		is.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
		loc.getWorld().dropItemNaturally(loc, is);
	}

}
