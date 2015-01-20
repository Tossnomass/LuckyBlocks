package li.angu.firei.luckyblocks.events;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EFFECTRandomItem {

	public EFFECTRandomItem(Player p) {

		int anzahl = new Random().nextInt(20) + 1;
		for (int i = 0; i < anzahl; i++) {
			int pick = new Random().nextInt(Material.values().length);
			Material material = Material.values()[pick];
			ItemStack is = new ItemStack(material, 1);
			p.getWorld().dropItemNaturally(p.getLocation(), is);
		}
		
	}

}
