package li.angu.firei.luckyblocks.listener;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.api.PlatformManager;
import li.angu.firei.luckyblocks.api.StopDetect;
import li.angu.firei.luckyblocks.game.Spectator;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class LISTENERPlayerDeath implements Listener {

	Main plugin;

	public LISTENERPlayerDeath(Main main) {
		plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	private void onDeath(final PlayerDeathEvent e) {

		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
				try {
					Object nmsPlayer = e.getEntity().getClass()
							.getMethod("getHandle").invoke(e.getEntity());
					Object packet = Class.forName(
							nmsPlayer.getClass().getPackage().getName()
									+ ".PacketPlayInClientCommand")
							.newInstance();
					Class<?> enumClass = Class.forName(nmsPlayer.getClass()
							.getPackage().getName()
							+ ".EnumClientCommand");

					for (Object ob : enumClass.getEnumConstants()) {
						if (ob.toString().equals("PERFORM_RESPAWN")) {
							packet = packet.getClass()
									.getConstructor(enumClass).newInstance(ob);
						}
					}

					Object con = nmsPlayer.getClass()
							.getField("playerConnection").get(nmsPlayer);
					con.getClass().getMethod("a", packet.getClass())
							.invoke(con, packet);
				} catch (Exception err) {
					err.printStackTrace();
				}
				Spectator.add(e.getEntity());
				e.getEntity().teleport(PlatformManager.mitte);
				if (Spectator.survivors.size() == 1) {
					Player p = plugin.getServer().getPlayer(
							Spectator.survivors.get(0));
					plugin.getServer().getScheduler().cancelAllTasks();
					p.sendMessage(Main.prefix + ChatColor.DARK_PURPLE
							+ "Du hast gewonnen!");
					plugin.getServer().broadcastMessage(
							Main.prefix + ChatColor.YELLOW + p.getName()
									+ ChatColor.GREEN
									+ " hat das Spiel gewonnen!");
					plugin.getServer()
							.broadcastMessage(
									Main.prefix
											+ ChatColor.GRAY
											+ "Du wirst in 10 Sekunden in die Lobby teleportiert.");
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin,
							new Runnable() {

								@Override
								public void run() {
									plugin.getServer()
											.broadcastMessage(
													Main.prefix
															+ ChatColor.RED
															+ "Kehre zur Lobby zurück...");
									StopDetect.stopserver();

								}
							}, 20L * 10);
				} else {
					plugin.getServer().broadcastMessage(
							Main.prefix + ChatColor.GRAY + "Es leben noch "
									+ ChatColor.YELLOW
									+ Spectator.survivors.size() + " Spieler");
				}

			}
		}, 10L);
		if (e.getEntity().getKiller() != null) {
			e.setDeathMessage(Main.prefix + ChatColor.YELLOW
					+ e.getEntity().getName() + ChatColor.GRAY + " wurde von "
					+ ChatColor.YELLOW
					+ e.getEntity().getKiller().getDisplayName()
					+ ChatColor.GRAY + " getötet!");
			e.getEntity()
					.getKiller()
					.sendMessage(
							Main.prefix + ChatColor.GREEN + "Du hast "
									+ ChatColor.YELLOW
									+ e.getEntity().getName() + ChatColor.GREEN
									+ " getötet!");
		} else {
			e.setDeathMessage(Main.prefix + ChatColor.YELLOW
					+ e.getEntity().getName() + ChatColor.GRAY
					+ " ist gestorben!");
		}

	}

}
