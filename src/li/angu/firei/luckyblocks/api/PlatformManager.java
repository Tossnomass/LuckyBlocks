package li.angu.firei.luckyblocks.api;

import java.util.ArrayList;
import java.util.Random;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.game.GameManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;

public class PlatformManager {

	public static Location mitte;

	public static ArrayList<Location> locs = new ArrayList<>();

	static Main plugin = Main.instance;

	public static void createPlatform() {
		if (mitte == null) {
			setMitte();
		}
		Location bl = mitte;

		int vonx = bl.getBlockX();
		int vony = bl.getBlockY();
		int vonz = bl.getBlockZ();

		int x = vonx;
		int y = vony;
		int z = vonz;

		ArrayList<String> l = (ArrayList<String>) plugin.getConfig()
				.getStringList("start");

		for (String s : l) {
			if (s.equalsIgnoreCase("y")) {
				y++;
				z = vonz;
				continue;
			}
			if (s.equalsIgnoreCase("z")) {
				z++;
				x = vonx;
				continue;
			}
			String material = s.split(":")[0];
			String subid = s.split(":")[1];
			int data = Integer.parseInt(subid);
			Material mat = Material.getMaterial(material);
			Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
			loc.getBlock().setType(mat);
			GameManager.protectedblocks.add(loc.getBlockX() + ":"
					+ loc.getBlockY() + ":" + loc.getBlockZ());
			if (mat == Material.BEACON) {
				locs.add(loc);
			}
			if (data != 0) {
				loc.getBlock().setData((byte) data);
			}
			x++;
		}

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

		while (mitte.getWorld().getBiome(x, z) == Biome.OCEAN
				|| mitte.getWorld().getBiome(x, z) == Biome.DEEP_OCEAN) {

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
