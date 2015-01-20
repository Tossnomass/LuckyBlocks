package li.angu.firei.luckyblocks.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTDiamond {

	public EFFECTDiamond(Location loc){
		int anzahl = new Random().nextInt(5) + 1;
		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.DIAMOND, anzahl));
	}
	
	
}
