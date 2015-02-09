package li.angu.firei.luckyblocks.game;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.api.PlatformManager;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;

public class SizeManager {

	Main plugin = Main.instance;

	public SizeManager() {
		int distance = 0;
		for (Player p : plugin.getServer().getOnlinePlayers()) {
			int dis = (int) p.getLocation().distance(PlatformManager.mitte);
			if (dis > distance) {
				distance = dis;
			}
		}
		GameManager.size = distance + 10;
		plugin.getServer().broadcastMessage(
				Main.prefix + ChatColor.AQUA + "Die Welt ist nun "
						+ ChatColor.YELLOW + GameManager.size + " Blöcke "
						+ ChatColor.AQUA + "groß!");
	}

}
