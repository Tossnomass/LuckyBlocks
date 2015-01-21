package li.angu.firei.luckyblocks.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EFFECTArcher {

	public EFFECTArcher(Location loc) {

		loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.BOW));
		int anzahl = new Random().nextInt(5) + 5;
		loc.getWorld().dropItemNaturally(loc,
				new ItemStack(Material.ARROW, anzahl));

	}

}
