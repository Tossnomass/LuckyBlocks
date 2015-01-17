package li.angu.firei.listener;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.events.EventManager;

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
		if (e.getBlock().getType() == Material.SEA_LANTERN) {
			e.setCancelled(true);
			e.getBlock().setType(Material.AIR);
			EventManager.playEffect(e.getBlock().getLocation());
		}
	}

}
