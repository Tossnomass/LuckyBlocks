package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
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
		e.getEntity().kickPlayer(ChatColor.RED + "Du bist gestorben!");
	}

}
