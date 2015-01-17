package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.Ocelot.Type;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Wolf;

public class EFFECTStadtmusikanten {

	public EFFECTStadtmusikanten(Location loc) {
		Horse horse = (Horse) loc.getWorld().spawnEntity(loc, EntityType.HORSE);
		horse.setVariant(Variant.DONKEY);
		
		Wolf wolf = (Wolf) loc.getWorld().spawnEntity(loc, EntityType.WOLF);
		
		Ocelot cat = (Ocelot) loc.getWorld().spawnEntity(loc, EntityType.OCELOT);
		cat.setCatType(Type.BLACK_CAT);
		
		Chicken chicken = (Chicken) loc.getWorld().spawnEntity(loc, EntityType.CHICKEN);
		
		horse.setPassenger(wolf);
		wolf.setPassenger(cat);
		cat.setPassenger(chicken);
		
		
	}

}
