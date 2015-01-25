package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.events.EventManager;
import li.angu.firei.luckyblocks.game.GameManager;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class LISTENERBlockBreak implements Listener {

	Main plugin;

	public LISTENERBlockBreak(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	private void onBreak(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		String sloc = loc.getBlockX() + ":" + loc.getBlockY() + ":"
				+ loc.getBlockZ();

		if (e.getBlock().getType() == Material.SEA_LANTERN) {
			if (!GameManager.status) {
				e.getPlayer().sendMessage(
						plugin.prefix + ChatColor.RED
								+ "Die Runde hat noch nicht angefangen!");
				e.setCancelled(true);
				return;
			}
			e.setCancelled(true);
			e.getBlock().setType(Material.AIR);
			EventManager.playEffect(e.getBlock().getLocation());
			return;
		}
		if (GameManager.protectedblocks.contains(sloc)) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(
					plugin.prefix + ChatColor.RED
							+ "Du darfst die Plattform nicht abbauen!");
			return;
		}
	}

}
