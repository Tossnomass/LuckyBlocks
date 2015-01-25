package li.angu.firei.luckyblocks.listener;

import java.util.Random;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.api.PlatformManager;
import li.angu.firei.luckyblocks.game.GameManager;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
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

		if (GameManager.status) {
			e.getPlayer().kickPlayer(
					ChatColor.RED + "Die Runde hat bereits begonnen!");
			return;
		}

		Random r = new Random();

		int size = PlatformManager.locs.size();

		int random = r.nextInt(size);

		Location spawn = PlatformManager.locs.get(random);
		PlatformManager.locs.remove(random);

		e.getPlayer().teleport(spawn.add(0.5, 1, 0.5));

		e.setJoinMessage(ChatColor.DARK_GRAY + "> " + ChatColor.GREEN
				+ e.getPlayer().getDisplayName() + ChatColor.DARK_AQUA
				+ " hat das Spiel betreten");
	}

}
