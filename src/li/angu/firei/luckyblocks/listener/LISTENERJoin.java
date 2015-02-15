package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Fix;
import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.api.PlatformManager;
import li.angu.firei.luckyblocks.api.WorldManager;
import li.angu.firei.luckyblocks.game.GameManager;
import li.angu.firei.luckyblocks.game.Spectator;
import li.angu.firei.luckyblocks.game.Status;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.GameMode;
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

		e.getPlayer().getInventory().clear();
		e.getPlayer().getInventory().setArmorContents(null);
		e.getPlayer().setHealth(20);
		e.getPlayer().setFoodLevel(20);
		e.getPlayer().setExp(0);
		e.getPlayer().setLevel(0);
		e.getPlayer().setFireTicks(0);

		Fix.fix(e.getPlayer());

		if (GameManager.status != Status.LOBBY) {
			Spectator.add(e.getPlayer());
			e.setJoinMessage(null);
			return;
		}
		e.getPlayer().setGameMode(GameMode.SURVIVAL);

		WorldManager.loadChunk(PlatformManager.mitte);

		e.getPlayer().teleport(spawn);

		e.setJoinMessage(ChatColor.DARK_GRAY + "> " + ChatColor.GREEN
				+ e.getPlayer().getDisplayName() + ChatColor.DARK_AQUA
				+ " hat das Spiel betreten");

		GameManager.check();

	}

}
