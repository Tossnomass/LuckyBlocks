package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.game.Spectator;
import net.md_5.bungee.api.ChatColor;

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
		if(Spectator.spectator.contains(e.getPlayer().getName())){
			return;
		}
		e.setQuitMessage(ChatColor.DARK_GRAY + "> " + ChatColor.GREEN + e.getPlayer().getDisplayName() + ChatColor.DARK_AQUA + " hat das Spiel verlassen");
	}

}
