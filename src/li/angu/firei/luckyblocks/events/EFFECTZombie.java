package li.angu.firei.luckyblocks.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class EFFECTZombie {

	@SuppressWarnings("deprecation")
	public EFFECTZombie(Location loc) {
		int anzahl = new Random().nextInt(5) + 3;
		for (int i = 0; i < anzahl; i++) {
			Zombie zombie = (Zombie) loc.getWorld().spawnCreature(loc, EntityType.ZOMBIE);
			ItemStack is = new ItemStack(Material.GOLD_HELMET);
			zombie.getEquipment().setHelmet(is);
		}
	}

}
