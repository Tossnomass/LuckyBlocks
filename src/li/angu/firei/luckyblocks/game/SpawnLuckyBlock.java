package li.angu.firei.luckyblocks.game;

import java.util.Random;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.api.PlatformManager;

import org.bukkit.Location;
import org.bukkit.Material;

public class SpawnLuckyBlock {

	Main plugin = Main.instance;

	public static int blocks = 0;

	@SuppressWarnings("deprecation")
	public SpawnLuckyBlock() {
		int x;
		int y = 250;
		int z;

		Location loc;

		Random r = new Random();
		x = r.nextInt(GameManager.size * 2);
		z = r.nextInt(GameManager.size * 2);

		x = x + PlatformManager.mitte.getBlockX() - GameManager.size;
		z = z + PlatformManager.mitte.getBlockZ() - GameManager.size;

		loc = new Location(plugin.getServer().getWorld("world"), x, y, z);

		blocks++;
		loc.getWorld().spawnFallingBlock(loc, Material.SEA_LANTERN, (byte) 0x0);
	}

}
