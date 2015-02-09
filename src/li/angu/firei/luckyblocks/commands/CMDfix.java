package li.angu.firei.luckyblocks.commands;

import li.angu.firei.luckyblocks.Fix;
import li.angu.firei.luckyblocks.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDfix implements CommandExecutor {

	Main plugin;

	public CMDfix(Main main) {
		plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		Player p = (Player) sender;

		Fix.fix(p);
		p.sendMessage(Main.prefix + ChatColor.GREEN
				+ "Du wurdest neupostitioniert!");
		return true;
	}

}
