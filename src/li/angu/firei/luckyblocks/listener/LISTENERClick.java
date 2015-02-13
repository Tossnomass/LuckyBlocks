package li.angu.firei.luckyblocks.listener;

import java.util.Random;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.api.AxeThread;
import li.angu.firei.luckyblocks.game.GameManager;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class LISTENERClick implements Listener {

	Main plugin;

	public LISTENERClick(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	private void onClick(PlayerInteractEvent e) {

		Player p = e.getPlayer();

		if (p.getItemInHand().getType() == Material.DIAMOND_AXE
				&& p.getItemInHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase(ChatColor.AQUA + "Wurfaxt")) {
			Item item = p.getWorld().dropItem(p.getLocation(),
					p.getItemInHand());
			item.setVelocity(p.getLocation().getDirection().multiply(2D));

			p.setItemInHand(new ItemStack(Material.AIR));

			new AxeThread(p, 0.6, item).start();
		}

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
			e.setCancelled(true);
			return;
		}

		if (p.getWorld().equals(plugin.getServer().getWorld("lobby"))) {
			if (e.getClickedBlock().getType() == Material.STAINED_CLAY) {
				byte data = e.getClickedBlock().getData();
				data++;
				if (data == 16) {
					data = 0;
				}
				e.getClickedBlock().setData(data);
				int pick = new Random().nextInt(Sound.values().length);
				Sound sound = Sound.values()[pick];
				p.getWorld().playSound(e.getClickedBlock().getLocation(),
						sound, 1, 1);
				e.setCancelled(true);
				return;
			}
		}

		if (!e.getPlayer().isOp()) {
			return;
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

		for (Entity e : p.getNearbyEntities(GameManager.size * 2, 250,
				GameManager.size * 2)) {
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
