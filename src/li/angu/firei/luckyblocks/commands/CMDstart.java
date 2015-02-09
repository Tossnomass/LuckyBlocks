package li.angu.firei.luckyblocks.commands;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.game.GameManager;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDstart implements CommandExecutor {

	Main plugin;

	public CMDstart(Main main) {
		plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		Player p = (Player) sender;

		if(!p.isOp()){
			p.sendMessage(Main.prefix + ChatColor.RED + "Du darfst das nicht tuen!");
			return true;
		}
		GameManager.time = 5;
		return true;
	}

}
