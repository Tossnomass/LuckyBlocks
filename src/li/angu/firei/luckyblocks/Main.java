package li.angu.firei.luckyblocks;

import li.angu.firei.luckyblocks.events.EventManager;
import li.angu.firei.luckyblocks.events.EventManager.Effects;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	public static Main instance;
	
	
	
	@Override
	public void onEnable() {
		
		if (!Bukkit.getPluginManager().isPluginEnabled("HolographicDisplays")) {
	        getLogger().severe("*** HolographicDisplays is not installed or not enabled. ***");
	        getLogger().severe("*** This plugin will be disabled. ***");
	        this.setEnabled(false);
	        return;
	    }
		
		instance = this;
		
		getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	@EventHandler
	private void onSpawn(ItemSpawnEvent e){
	}
	
	@EventHandler
	private void onBreak(BlockBreakEvent e){
		if(e.getBlock().getType() == Material.SEA_LANTERN){
			e.setCancelled(true);
			e.getBlock().setType(Material.AIR);
			EventManager.playEffect(e.getBlock().getLocation());
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String label, String[] args) {
		
		Player p = (Player) sender;
		
		
		if(cmd.getName().equalsIgnoreCase("test")){
			if(args.length == 1){
				Effects e = Effects.valueOf(args[0]);
				EventManager.playEffect(e, p.getLocation());
				p.sendMessage(ChatColor.AQUA + "Effekt: " + e.name());
				return true;
			}
			Effects e = EventManager.playEffect(p.getLocation());
			p.sendMessage(ChatColor.AQUA + "Effekt: " + e.name());
		}
		
		return true;
	}
	
	
}
