package li.angu.firei.luckyblocks.game;

import java.util.ArrayList;
import java.util.List;

import li.angu.firei.luckyblocks.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Spectator {

	public static List<String> spectator = new ArrayList<>();

	public static List<String> survivors = new ArrayList<>();
	
	public static void add(Player p) {
		if(spectator.contains(p.getName())){
			return;
		}
		if(survivors.contains(p.getName())){
			survivors.remove(p.getName());
		}
		spectator.add(p.getName());
		p.setDisplayName(p.getName());
		p.setGameMode(GameMode.SPECTATOR);
		p.sendMessage(Main.prefix + ChatColor.GREEN + "Du schaust nun zu!");
		return;
	}

}
