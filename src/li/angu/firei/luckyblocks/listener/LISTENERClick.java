package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class LISTENERClick implements Listener {

	Main plugin;

	public LISTENERClick(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	private void onClick(PlayerInteractEvent e) {

		if (!e.getPlayer().isOp()) {
			return;
		}

		Player p = e.getPlayer();

		if (p.getItemInHand().getType() == Material.DIAMOND_SPADE
				&& p.getItemInHand().getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "EggThrower")) {
			p.throwEgg();
			p.getItemInHand().setDurability(
					(short) (p.getItemInHand().getDurability() + 30));
			if (p.getItemInHand().getDurability() > 1561) {
				p.getInventory().remove(p.getItemInHand());
			}
			e.setCancelled(true);
			return;
		}
		if (p.getItemInHand().getType() == Material.COMPASS
				&& p.getItemInHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase(ChatColor.GOLD + "Kompass")) {
			Player target = getNearest(p);
			if (target == null) {
				p.sendMessage(Main.prefix + ChatColor.RED
						+ "Es wurde kein Spieler in deiner Nähe gefunden!");
				return;
			}
			int blocks = (int) p.getLocation().distance(target.getLocation());
			p.sendMessage(Main.prefix + ChatColor.AQUA + "Spieler "
					+ ChatColor.YELLOW + target.getDisplayName()
					+ ChatColor.AQUA + " ist " + ChatColor.YELLOW + blocks
					+ ((blocks == 1) ? " Block" : " Blöcke") + ChatColor.AQUA
					+ " entfernt!");
			p.setCompassTarget(target.getLocation());
		}

		if (p.getItemInHand().getType() != Material.BLAZE_POWDER) {
			return;
		}
		e.setCancelled(true);
		if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
			Location pos = e.getClickedBlock().getLocation();
			plugin.getConfig().set("von.x", pos.getBlockX());
			plugin.getConfig().set("von.y", pos.getBlockY());
			plugin.getConfig().set("von.z", pos.getBlockZ());
			plugin.saveConfig();
			p.sendMessage(Main.prefix + ChatColor.GREEN + "Du hast Punkt "
					+ ChatColor.YELLOW + "1 " + ChatColor.GREEN + "gesetzt!");
			return;
		}
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Location pos = e.getClickedBlock().getLocation();
			plugin.getConfig().set("bis.x", pos.getBlockX());
			plugin.getConfig().set("bis.y", pos.getBlockY());
			plugin.getConfig().set("bis.z", pos.getBlockZ());
			plugin.saveConfig();
			p.sendMessage(Main.prefix + ChatColor.GREEN + "Du hast Punkt "
					+ ChatColor.YELLOW + "2 " + ChatColor.GREEN + "gesetzt!");
			return;
		}

	}

	private Player getNearest(Player p) {
		double distance = Double.MAX_VALUE;

		Player target = null;

		for (Entity e : p.getNearbyEntities(400, 400, 400)) {
			if (e instanceof Player) {
				double dis = p.getLocation().distance(e.getLocation());
				if (dis < distance) {
					distance = dis;
					target = (Player) e;
				}
			}
		}

		return target;
	}

}
