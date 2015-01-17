package li.angu.firei.luckyblocks;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;

public class createHologram {

	Main plugin = Main.instance;

	public createHologram(String msg, Location loc) {
		final Hologram hologram = HologramsAPI.createHologram(plugin, loc);
		hologram.appendTextLine(msg);
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				hologram.delete();
				
			}
		},20L*5);
	}

}
