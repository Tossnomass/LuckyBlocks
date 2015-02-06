package li.angu.firei.luckyblocks.commands;

import java.util.ArrayList;

import li.angu.firei.luckyblocks.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDsave implements CommandExecutor {

	Main plugin;

	public CMDsave(Main main) {
		plugin = main;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		Player p = (Player) sender;
		if (!p.isOp()) {
			p.sendMessage(Main.prefix + ChatColor.RED
					+ "Du darfst diesen Befehl nicht ausführen!");
			return true;
		}

		if (!plugin.getConfig().contains("von.x")
				|| !plugin.getConfig().contains("bis.x")) {
			p.sendMessage(Main.prefix + ChatColor.RED
					+ "Du musst erst zwei Punkte setzen!");
			return true;
		}

		int vonx = plugin.getConfig().getInt("von.x");
		int vony = plugin.getConfig().getInt("von.y");
		int vonz = plugin.getConfig().getInt("von.z");

		int bisx = plugin.getConfig().getInt("bis.x");
		int bisy = plugin.getConfig().getInt("bis.y");
		int bisz = plugin.getConfig().getInt("bis.z");

		if (vonx > bisx) {
			int v = vonx;
			vonx = bisx;
			bisx = v;
		}
		if (vony > bisy) {
			int v = vony;
			vony = bisy;
			bisy = v;
		}
		if (vonz > bisz) {
			int v = vonz;
			vonz = bisz;
			bisz = v;
		}

		int x = vonx;
		int y = vony;
		int z = vonz;

		ArrayList<String> l = new ArrayList<>();

		while (y <= bisy) {
			while (z <= bisz) {
				while (x <= bisx) {
					Location loc = new Location(Bukkit.getWorld("world"), x, y,
							z);
					Block b = loc.getBlock();
					l.add(b.getType().name() + ":" + b.getData());
					x++;
				}
				l.add("z");
				x = vonx;
				z++;
			}
			l.add("y");
			z = vonz;
			y++;
		}
		if(plugin.getConfig().contains("start")){
			plugin.getConfig().set("start", null);
		}
		plugin.getConfig().set("start", l);
		plugin.saveConfig();

		p.sendMessage(Main.prefix + ChatColor.GREEN + "Neue Plattform gesetzt!");
		
		return true;
	}

}
