package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.game.GameManager;
import li.angu.firei.luckyblocks.game.Status;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class LISTENERFoodChange implements Listener {

	Main plugin;

	public LISTENERFoodChange(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	private void onDamage(FoodLevelChangeEvent e) {
		if(GameManager.status != Status.START){
			e.setCancelled(true);
		}
	}

}
