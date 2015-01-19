package li.angu.firei.luckyblocks;

import java.io.File;

import li.angu.firei.luckyblocks.api.PlatformManager;
import li.angu.firei.luckyblocks.api.WorldManager;
import li.angu.firei.luckyblocks.commands.CMDaction;
import li.angu.firei.luckyblocks.listener.LISTENERBlockBreak;
import li.angu.firei.luckyblocks.listener.LISTENERJoin;
import li.angu.firei.luckyblocks.listener.LISTENERLeave;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main instance;

	public static String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW
			+ "LuckyBlocks" + ChatColor.DARK_GRAY + "] ";

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
		new LISTENERJoin(this);
		new LISTENERLeave(this);

		
		PlatformManager.createPlatform();
		
		CMDaction action = new CMDaction(this);
		getCommand("action").setExecutor(action);

	}

	@Override
	public void onDisable() {

		World w = getServer().getWorld("world");
		
		WorldManager.unloadWorld(w);

		System.out.println("World entladen!");
		
		File deleteFolder = w.getWorldFolder();
		WorldManager.deleteWorld(deleteFolder);
		
		System.out.println("Welt gelöscht!");
		
		
	}

}
