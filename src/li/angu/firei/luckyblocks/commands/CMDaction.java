package li.angu.firei.luckyblocks.commands;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.events.Effekt;
import li.angu.firei.luckyblocks.events.EventManager;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDaction implements CommandExecutor {

	Main plugin;

	public CMDaction(Main main) {
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
		
		
		if (args.length == 1) {
			Effekt e = Effekt.valueOf(args[0]);
			EventManager.playEffect(e, p.getLocation());
			p.sendMessage(Main.prefix + ChatColor.AQUA + "Effekt: " + e.name());
			return true;
		}
		Effekt e = EventManager.playEffect(p.getLocation());
		p.sendMessage(Main.prefix + ChatColor.AQUA + "Effekt: " + e.name());
		return true;
	}

}
