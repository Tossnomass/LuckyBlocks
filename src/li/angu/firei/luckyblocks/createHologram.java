package li.angu.firei.luckyblocks;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;

public class createHologram {

	Main plugin = Main.instance;

	public createHologram(String msg, final Location loc) {
		final Hologram hologram = HologramsAPI.createHologram(plugin, loc);
		hologram.appendTextLine(msg);
		final int move = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				hologram.teleport(loc.add(0, 0.02, 0));
				
			}
		}, 1, 1);
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				hologram.delete();
				Bukkit.getScheduler().cancelTask(move);
			}
		},20L*3);
	}

}
