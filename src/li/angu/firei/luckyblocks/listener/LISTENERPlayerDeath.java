package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.game.Spectator;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class LISTENERPlayerDeath implements Listener {

	Main plugin;

	public LISTENERPlayerDeath(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	private void onDeath(PlayerDeathEvent e) {
		Spectator.add(e.getEntity());
		if (e.getEntity().getKiller() != null) {
			e.setDeathMessage(Main.prefix + ChatColor.YELLOW
					+ e.getEntity().getName() + ChatColor.GRAY + " wurde von "
					+ ChatColor.YELLOW
					+ e.getEntity().getKiller().getDisplayName()
					+ ChatColor.GRAY + " getötet!");
			e.getEntity()
					.getKiller()
					.sendMessage(
							Main.prefix + ChatColor.GREEN + "Du hast "
									+ ChatColor.YELLOW
									+ e.getEntity().getName() + ChatColor.GREEN
									+ " getötet!");
		} else {
			e.setDeathMessage(Main.prefix + ChatColor.YELLOW
					+ e.getEntity().getName() + ChatColor.GRAY
					+ " ist gestorben!");
		}
	}

}
