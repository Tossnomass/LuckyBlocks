package li.angu.firei.luckyblocks.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.api.PlatformManager;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class GameManager {

	static Main plugin = Main.instance;

	public static HashMap<Player, Location> starts = new HashMap<>();

	public static ArrayList<String> protectedblocks = new ArrayList<>();

	public static Status status = Status.LOBBY;

	public static LobbyStatus lobbystatus = LobbyStatus.WAIT;

	public static int size = 800;

	public static int time = 60;

	static int countdown;

	public static void check() {

		if (lobbystatus == LobbyStatus.COUNTDOWN) {
			return;
		}
		if (plugin.getServer().getOnlinePlayers().size() >= 2) {
			startLobbyCountdown();
		}

	}

	private static void startLobbyCountdown() {

		lobbystatus = LobbyStatus.COUNTDOWN;

		plugin.getServer().getWorld("world").setStorm(false);
		plugin.getServer().getWorld("world").setTime(0);

		countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin,
				new Runnable() {

					@Override
					public void run() {
						time--;
						for (Player p : plugin.getServer().getOnlinePlayers()) {
							p.setLevel(time);
						}
						if (time == 60 || time == 45 || time == 30
								|| time == 20 || time == 10 || time <= 5) {
							String n = "n";
							if (time == 1) {
								n = "";
							}
							for (Player p : plugin.getServer()
									.getOnlinePlayers()) {
								p.playSound(p.getLocation(), Sound.NOTE_PLING,
										5, 5);
							}
							plugin.getServer().broadcastMessage(
									Main.prefix + ChatColor.AQUA
											+ "Das Spiel beginnt in "
											+ ChatColor.YELLOW + time
											+ " Sekunde" + n + ChatColor.AQUA
											+ "!");
						}
						if (time == 25) {
							plugin.getServer().broadcastMessage(
									Main.prefix + ChatColor.GRAY
											+ "Idee und Plugin von "
											+ ChatColor.YELLOW + "Firei");
							plugin.getServer().broadcastMessage(
									Main.prefix + ChatColor.GRAY
											+ "Plattform von "
											+ ChatColor.YELLOW + "Dinentix");

						}
						if (time == 0) {
							status = Status.WARTEN;
							Bukkit.getScheduler().cancelTask(countdown);
							startGame();
						}

					}
				}, 20L, 20L);

	}

	private static void startGame() {
		for (Player p : plugin.getServer().getOnlinePlayers()) {

			Random r = new Random();

			int size = PlatformManager.locs.size();

			int random = r.nextInt(size);

			Location spawn = PlatformManager.locs.get(random);
			PlatformManager.locs.remove(random);

			starts.put(p, spawn);
			p.teleport(spawn.add(0.5, 1, 0.5));
			Spectator.survivors.add(p.getName());
		}
		size = plugin.getServer().getOnlinePlayers().size() * 100;
		startGameCountdown();
	}

	private static void startGameCountdown() {
		time = 20;
		countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin,
				new Runnable() {

					@Override
					public void run() {
						time--;
						for (Player p : plugin.getServer().getOnlinePlayers()) {
							p.setLevel(time);
						}
						if (time == 20 || time == 15 || time == 10 || time == 5
								|| time <= 3) {
							for (Player p : plugin.getServer()
									.getOnlinePlayers()) {
								p.playSound(p.getLocation(), Sound.NOTE_PLING,
										5, 5);
							}
							String n = "n";
							if (time == 1) {
								n = "";
							}
							plugin.getServer().broadcastMessage(
									Main.prefix + ChatColor.AQUA
											+ "Es geht in " + ChatColor.YELLOW
											+ time + " Sekunde" + n
											+ ChatColor.AQUA + " los!");
						}
						if (time == 0) {
							int blocks = 0;
							for (int i = 0; i < plugin.getServer()
									.getOnlinePlayers().size() * 20; i++) {
								new SpawnLuckyBlock();
								blocks++;
							}
							Bukkit.getScheduler().cancelTask(countdown);
							plugin.getServer().broadcastMessage(
									Main.prefix + ChatColor.GREEN
											+ "Lasst die Spiele beginnen!");
							plugin.getServer()
									.broadcastMessage(
											Main.prefix
													+ ChatColor.GRAY
													+ "Die Arena hat einen Durchmesser von "
													+ ChatColor.YELLOW + size
													+ " Blöcken");
							plugin.getServer().broadcastMessage(
									Main.prefix + ChatColor.GRAY + "Es wurden "
											+ ChatColor.YELLOW + blocks
											+ " LuckyBlocks " + ChatColor.GRAY
											+ "gespawnt");
							status = Status.SCHUTZ;
							startSchutzCountdown();
							startSpawnCountdown();
						}

					}

				}, 20L, 20L);
	}

	public static int spawnCountdown;

	private static void startSpawnCountdown() {
		spawnCountdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(
				plugin, new Runnable() {

					@Override
					public void run() {
						for (int i = 0; i < Spectator.survivors.size() * 10; i++) {
							new SpawnLuckyBlock();
						}

					}
				}, 20L * 20, 20L * 10);
	}

	private static void startSchutzCountdown() {
		time = 90;
		for (Player target : plugin.getServer().getOnlinePlayers()) {
			target.setLevel(0);
			target.setExp(0);
		}
		countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin,
				new Runnable() {

					@Override
					public void run() {
						time--;
						if (time == 75 || time == 60 || time == 45
								|| time == 30 || time == 15 || time == 10
								|| time <= 5) {
							for (Player p : plugin.getServer()
									.getOnlinePlayers()) {
								p.playSound(p.getLocation(), Sound.NOTE_PLING,
										5, 5);
							}
							String n = "n";
							if (time == 1) {
								n = "";
							}
							plugin.getServer().broadcastMessage(
									Main.prefix + ChatColor.GRAY
											+ "Die Schutzzeit endet in "
											+ ChatColor.YELLOW + time
											+ " Sekunde" + n);
						}
						if (time == 0) {
							Bukkit.getScheduler().cancelTask(countdown);
							plugin.getServer().broadcastMessage(
									Main.prefix + ChatColor.DARK_PURPLE
											+ "Du bist nun verwundbar!");
							status = Status.START;
							PlatformManager.explode();
						}
					}
				}, 20L, 20L);
	}

}
