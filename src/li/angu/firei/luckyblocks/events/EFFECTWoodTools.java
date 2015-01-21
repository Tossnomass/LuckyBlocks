package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTWoodTools {

	public EFFECTWoodTools(Location loc){

		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.WOOD_AXE));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.WOOD_SPADE));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.WOOD_SWORD));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.WOOD_PICKAXE));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.WOOD_HOE));
	}
	
	
}
