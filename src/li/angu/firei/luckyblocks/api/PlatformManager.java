package li.angu.firei.luckyblocks.api;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;

public class PlatformManager {

	public static Location mitte;

	public static void createPlatform() {
		if (mitte == null) {
			setMitte();
		}
		Location bl = mitte;

	}

	private static void setMitte() {

		Random r = new Random();

		int x = r.nextInt(1000);
		int z = r.nextInt(1000);

		mitte = new Location(Bukkit.getWorld("world"), x, 110, z);

		boolean add = false;
		while (mitte.getBlock().getType() != Material.AIR) {
			add = true;
			mitte.add(0, 1, 0);
		}
		if (add) {
			mitte.add(0, 30, 0);
		}

		while (mitte.getWorld().getBiome(x, z) == Biome.OCEAN) {

			x = r.nextInt(1000);
			z = r.nextInt(1000);

			mitte = new Location(Bukkit.getWorld("world"), x, 110, z);

			add = false;
			while (mitte.getBlock().getType() != Material.AIR) {
				add = true;
				mitte.add(0, 1, 0);
			}
			if (add) {
				mitte.add(0, 30, 0);
			}
		}

	}

}
