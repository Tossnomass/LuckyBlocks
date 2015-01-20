package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.api.PlatformManager;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class LISTENERClick implements Listener {

	Main plugin;

	public LISTENERClick(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	private void onClick(PlayerInteractEvent e) {

		if (!e.getPlayer().isOp()) {
			return;
		}

		Player p = e.getPlayer();

		if (p.getInventory().getItemInHand().getType() != Material.BLAZE_POWDER) {
			return;
		}
		e.setCancelled(true);
		if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
			Location pos = e.getClickedBlock().getLocation();
			plugin.getConfig().set("von.x", pos.getBlockX());
			plugin.getConfig().set("von.y", pos.getBlockY());
			plugin.getConfig().set("von.z", pos.getBlockZ());
			plugin.saveConfig();
			p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast Punkt " + ChatColor.YELLOW + "1 " + ChatColor.GREEN + "gesetzt!");
			return;
		}
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Location pos = e.getClickedBlock().getLocation();
			plugin.getConfig().set("bis.x", pos.getBlockX());
			plugin.getConfig().set("bis.y", pos.getBlockY());
			plugin.getConfig().set("bis.z", pos.getBlockZ());
			plugin.saveConfig();
			p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast Punkt " + ChatColor.YELLOW + "2 " + ChatColor.GREEN + "gesetzt!");
			return;
		}

	}

}
