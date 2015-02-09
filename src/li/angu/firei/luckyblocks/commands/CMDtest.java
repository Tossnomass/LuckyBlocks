package li.angu.firei.luckyblocks.commands;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.game.SpawnLuckyBlock;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDtest implements CommandExecutor {

	Main plugin;

	public CMDtest(Main main) {
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
		p.sendMessage("ok");
		new SpawnLuckyBlock(p);
		
		return true;
	}

}
