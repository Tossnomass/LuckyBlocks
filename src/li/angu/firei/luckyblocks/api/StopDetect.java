package li.angu.firei.luckyblocks.api;

import java.io.File;

import li.angu.firei.luckyblocks.Main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class StopDetect implements Listener {

	Main plugin;

	public StopDetect(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	private void onStop(ServerCommandEvent e) {
		if (e.getCommand().equalsIgnoreCase("stop")
				|| e.getCommand().equalsIgnoreCase("restart")) {
			serverstops();
		}
	}

	@EventHandler
	private void onPlayerStop(PlayerCommandPreprocessEvent e) {
		if (e.getPlayer().isOp()) {
			if (e.getMessage().startsWith("/stop")
					|| e.getMessage().startsWith("/restart")) {
				serverstops();
			}
		}
	}

	public static void serverstops() {

		World w = Bukkit.getWorld("world");

		WorldManager.unloadWorld(w);

		File deleteFolder = w.getWorldFolder();
		WorldManager.deleteWorld(deleteFolder);
	}

}
