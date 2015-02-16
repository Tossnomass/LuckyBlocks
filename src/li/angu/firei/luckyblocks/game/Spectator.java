package li.angu.firei.luckyblocks.game;

import java.util.ArrayList;
import java.util.List;

import li.angu.firei.luckyblocks.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Spectator {

	private static Main plugin = Main.instance;
	
	public static List<String> spectator = new ArrayList<>();

	public static List<String> survivors = new ArrayList<>();

	public static void add(Player p) {
		if (spectator.contains(p.getName())) {
			return;
		}
		if (survivors.contains(p.getName())) {
			survivors.remove(p.getName());
		}
		spectator.add(p.getName());
		p.setDisplayName(p.getName());
		p.setGameMode(GameMode.ADVENTURE);
		p.setFlying(true);
		p.setFlySpeed(2);

		ItemStack stack = new ItemStack(Material.COMPASS);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Kompass");
		stack.setItemMeta(meta);

		p.getInventory().addItem(stack);
		
		for(Player target : plugin.getServer().getOnlinePlayers()){
			target.hidePlayer(p);
		}
		
		
		p.sendMessage(Main.prefix + ChatColor.GREEN + "Du schaust nun zu!");
		return;
	}

}
