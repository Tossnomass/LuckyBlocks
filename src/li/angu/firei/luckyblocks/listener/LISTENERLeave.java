package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.game.GameManager;
import li.angu.firei.luckyblocks.game.Spectator;
import li.angu.firei.luckyblocks.game.Status;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LISTENERLeave implements Listener {

	Main plugin;

	public LISTENERLeave(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	private void onQuit(PlayerQuitEvent e) {
		if (Spectator.spectator.contains(e.getPlayer().getName())) {
			e.setQuitMessage(null);
			return;
		}
		Player p = e.getPlayer();
		if (GameManager.status == Status.SCHUTZ
				|| GameManager.status == Status.START) {
			p.setHealth(0);
		}

		e.setQuitMessage(ChatColor.DARK_GRAY + "> " + ChatColor.GREEN
				+ p.getDisplayName() + ChatColor.DARK_AQUA
				+ " hat das Spiel verlassen");
	}

}
