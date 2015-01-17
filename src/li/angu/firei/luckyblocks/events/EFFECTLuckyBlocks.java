package li.angu.firei.luckyblocks.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTLuckyBlocks {

	public EFFECTLuckyBlocks(Location loc){
		int anzahl = new Random().nextInt(3) + 1;
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.SEA_LANTERN, anzahl));
	}
	
	
}
