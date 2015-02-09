package li.angu.firei.luckyblocks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Fix {

	static Main plugin = Main.instance;

	public static void fix(final Player p) {

		for (final Player target : plugin.getServer().getOnlinePlayers()) {
			if (target.equals(p)) {
				continue;
			}
			target.hidePlayer(p);
			p.hidePlayer(target);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin,
					new Runnable() {

						@Override
						public void run() {
							target.showPlayer(p);
							p.showPlayer(target);
						}
					}, 10L);
		}

	}

}
