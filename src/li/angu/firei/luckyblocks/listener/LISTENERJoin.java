package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.game.GameManager;
import li.angu.firei.luckyblocks.game.Status;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LISTENERJoin implements Listener {

	Main plugin;

	Location spawn;

	public LISTENERJoin(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		spawn = new Location(plugin.getServer().getWorld("lobby"), 196, 65, 0);
	}

	@EventHandler
	private void onJoin(PlayerJoinEvent e) {

		if (GameManager.status != Status.LOBBY) {
			e.getPlayer().kickPlayer(
					ChatColor.RED + "Die Runde hat bereits begonnen!");
			return;
		}

		e.getPlayer().getInventory().clear();
		e.getPlayer().getInventory().setArmorContents(null);
		e.getPlayer().setHealth(20);
		e.getPlayer().setFoodLevel(20);
		
		e.getPlayer().teleport(spawn);

		e.setJoinMessage(ChatColor.DARK_GRAY + "> " + ChatColor.GREEN
				+ e.getPlayer().getDisplayName() + ChatColor.DARK_AQUA
				+ " hat das Spiel betreten");

		GameManager.check();

	}

}
