package li.angu.firei.luckyblocks.events;

import li.angu.firei.luckyblocks.Main;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class EFFECTJump {

	Main plugin = Main.instance;
	
	public EFFECTJump(Location loc) {
		for(Player p : plugin.getServer().getOnlinePlayers()){
			if(p.getLocation().distance(loc) <= 10){
				Vector v = new Vector(0, 1, 0);
				p.setVelocity(v);
			}
		}
	}

}
