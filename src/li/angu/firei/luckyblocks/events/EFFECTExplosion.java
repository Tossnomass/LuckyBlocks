package li.angu.firei.luckyblocks.events;

import org.bukkit.Location;

public class EFFECTExplosion {

	public EFFECTExplosion(Location loc) {
		
		loc.getWorld().createExplosion(loc, 2);
	
		
	}

}
