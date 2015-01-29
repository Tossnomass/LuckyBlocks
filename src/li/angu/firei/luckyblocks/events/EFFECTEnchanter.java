package li.angu.firei.luckyblocks.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.inventory.ItemStack;

public class EFFECTEnchanter {

	public EFFECTEnchanter(Location loc) {
		loc.getBlock().setType(Material.ENCHANTMENT_TABLE);

		int anzahl = new Random().nextInt(10) + 100;
		for (int i = 0; i < anzahl; i++) {
			ExperienceOrb xp = (ExperienceOrb) loc.getWorld().spawnEntity(loc,
					EntityType.EXPERIENCE_ORB);
			xp.setExperience(10);
		}
		loc.getWorld().dropItemNaturally(loc,
				new ItemStack(Material.LAPIS_BLOCK));
	}

}
