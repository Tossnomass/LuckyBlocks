package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.game.GameManager;
import li.angu.firei.luckyblocks.game.Status;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class LISTENERConnect implements Listener {

	Main plugin;

	public LISTENERConnect(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	private void onJoin(AsyncPlayerPreLoginEvent e) {

		if (GameManager.status != Status.LOBBY) {
			e.setKickMessage(ChatColor.RED + "Die Runde hat bereits begonnen!");
			return;
		}

	}

}
