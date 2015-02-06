package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.game.GameManager;
import li.angu.firei.luckyblocks.game.Status;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class LISTENERDamage implements Listener {

	Main plugin;

	public LISTENERDamage(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	private void onDamage(EntityDamageEvent e) {
		if(e.getEntityType() == EntityType.PLAYER){
			if(GameManager.status != Status.START){
				e.setCancelled(true);
			}
		}
	}

}
