package li.angu.firei.luckyblocks;

import li.angu.firei.listener.LISTENERBlockBreak;
import li.angu.firei.luckyblocks.commands.CMDaction;
import li.angu.firei.luckyblocks.events.EventManager;
import li.angu.firei.luckyblocks.events.EventManager.Effects;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main instance;

	@Override
	public void onEnable() {

		if (!Bukkit.getPluginManager().isPluginEnabled("HolographicDisplays")) {
			getLogger()
					.severe("*** HolographicDisplays is not installed or not enabled. ***");
			getLogger().severe("*** This plugin will be disabled. ***");
			this.setEnabled(false);
			return;
		}

		instance = this;

		new LISTENERBlockBreak(this);

		CMDaction action = new CMDaction(this);
		getCommand("action").setExecutor(action);

	}

}
