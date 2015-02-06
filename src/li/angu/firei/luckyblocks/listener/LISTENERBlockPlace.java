package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.game.GameManager;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class LISTENERBlockPlace implements Listener {

	Main plugin;

	public LISTENERBlockPlace(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	private void onPlace(BlockPlaceEvent e) {
		Location loc = e.getBlock().getLocation();
		if(loc.getWorld().equals(plugin.getServer().getWorld("lobby"))){
			e.getPlayer().sendMessage(Main.prefix + ChatColor.RED + "Du darfst in der Lobby nicht bauen!");
			e.setCancelled(true);
			return;
		}
		String sloc = loc.getBlockX() + ":" + loc.getBlockY() + ":"
				+ loc.getBlockZ();
		if (GameManager.protectedblocks.contains(sloc)) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(
					Main.prefix + ChatColor.RED
							+ "Du darfst die Plattform nicht bebauen!");
			return;
		}

	}

}
