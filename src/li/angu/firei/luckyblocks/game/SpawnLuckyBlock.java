package li.angu.firei.luckyblocks.game;

import java.util.Random;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.api.PlatformManager;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SpawnLuckyBlock {

	Main plugin = Main.instance;

	public SpawnLuckyBlock(Player p) {

		p.sendMessage("ok");
		int x;
		int y;
		int z;

		Location loc;

		p.sendMessage("ok");
		Random r = new Random();
		x = r.nextInt(GameManager.size * 2);
		z = r.nextInt(GameManager.size * 2);
		y = plugin.getServer().getWorld("world").getHighestBlockYAt(x, z);

		y++;

		x = x + PlatformManager.mitte.getBlockX() - GameManager.size;
		z = z + PlatformManager.mitte.getBlockZ() - GameManager.size;
		
		loc = new Location(plugin.getServer().getWorld("world"), x, y, z);

		while(loc.distance(PlatformManager.mitte) > GameManager.size){

			p.sendMessage("ok");
			x = r.nextInt(GameManager.size * 2);
			z = r.nextInt(GameManager.size * 2);
			y = plugin.getServer().getWorld("world").getHighestBlockYAt(x, z);

			y++;

			loc = new Location(plugin.getServer().getWorld("world"), x, y, z);
		}

		p.sendMessage("ende");
		loc.getBlock().setType(Material.SEA_LANTERN);
		System.out.println(x + ":" + y + ":" + z);
		p.teleport(loc);
		p.sendMessage("ende");
	}

}
