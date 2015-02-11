package li.angu.firei.luckyblocks.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTBottle {

	public EFFECTBottle(Location loc){
		int anzahl = new Random().nextInt(30) + 30;
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.GLASS_BOTTLE, anzahl));
	}
	
	
}
