package li.angu.firei.luckyblocks.api;

import li.angu.firei.luckyblocks.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class StopDetect implements Listener {

	static Main plugin;

	public StopDetect(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);

		plugin.getServer().getMessenger()
				.registerOutgoingPluginChannel(plugin, "BungeeCord");
	}

	@EventHandler
	private void onStop(ServerCommandEvent e) {
		if (e.getCommand().equalsIgnoreCase("stop")
				|| e.getCommand().equalsIgnoreCase("restart")) {
			stopserver();
			e.setCommand("test");
		}
	}

	@EventHandler
	private void onPlayerStop(PlayerCommandPreprocessEvent e) {
		if (e.getPlayer().isOp()) {
			if (e.getMessage().startsWith("/stop")
					|| e.getMessage().startsWith("/restart")) {
				stopserver();
				e.setCancelled(true);
			}
		}
	}

	public static void stopserver() {
		serverstops();
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
				plugin.getServer().shutdown();
			}
		}, 40L);

	}

	private static void serverstops() {

		PlatformManager.destroy();
		
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Connect");
		out.writeUTF("lobby");
		for (Player target : plugin.getServer().getOnlinePlayers()) {
			target.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
		}

	}

}
