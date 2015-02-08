package li.angu.firei.luckyblocks.listener;

import java.util.ArrayList;
import java.util.List;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.api.PlatformManager;
import li.angu.firei.luckyblocks.game.GameManager;
import li.angu.firei.luckyblocks.game.Status;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class LISTENERMove implements Listener {

	Main plugin;

	private List<String> list = new ArrayList<>();
	
	public LISTENERMove(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	private void onMove(final PlayerMoveEvent e) {
		if(e.getPlayer().getWorld().getName().equalsIgnoreCase("lobby")){
			return;
		}
		if(GameManager.status == Status.WARTEN){
			if(GameManager.starts.get(e.getPlayer()).distance(e.getTo()) >= 1){
				e.getPlayer().teleport(GameManager.starts.get(e.getPlayer()));
				return;
			}
		}
		if(PlatformManager.mitte.distanceSquared(e.getTo()) > GameManager.size){
			int x = PlatformManager.mitte.getBlockX() - e.getPlayer().getLocation().getBlockX();
			int y = PlatformManager.mitte.getBlockY() - e.getPlayer().getLocation().getBlockY();
			int z = PlatformManager.mitte.getBlockZ() - e.getPlayer().getLocation().getBlockZ();
			
			Vector v = new Vector(x, y, z).normalize();
			v.multiply(0.8D);
			v.setY(0.5D);
			e.getPlayer().setVelocity(v);
			e.getPlayer().getWorld().playEffect(e.getPlayer().getLocation(), Effect.MOBSPAWNER_FLAMES, 3);
			
			
			if(!list.contains(e.getPlayer().getName())){
				e.getPlayer().sendMessage(ChatColor.RED + "Du hast das Ende der Welt erreicht!");
				list.add(e.getPlayer().getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					
					@Override
					public void run() {
						list.remove(e.getPlayer().getName());
					}
				}, 20);
			}
			
		}
	}

}
