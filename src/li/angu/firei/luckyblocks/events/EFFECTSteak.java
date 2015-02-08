package li.angu.firei.luckyblocks.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTSteak {

	public EFFECTSteak(Location loc){
		int anzahl = new Random().nextInt(7) + 3;
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.COOKED_BEEF, anzahl));
	}
	
	
}
