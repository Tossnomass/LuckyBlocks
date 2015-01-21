package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTStoneTools {

	public EFFECTStoneTools(Location loc){

		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.STONE_AXE));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.STONE_SPADE));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.STONE_SWORD));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.STONE_PICKAXE));
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.STONE_HOE));
	}
	
	
}
