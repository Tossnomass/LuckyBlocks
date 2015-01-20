package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.api.PlatformManager;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LISTENERJoin implements Listener {

	Main plugin;

	public LISTENERJoin(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	private void onJoin(PlayerJoinEvent e) {
		e.getPlayer().teleport(PlatformManager.mitte);
		e.setJoinMessage(ChatColor.DARK_GRAY + "> " + ChatColor.GREEN + e.getPlayer().getDisplayName() + ChatColor.DARK_AQUA + " hat das Spiel betreten");
	}

}
