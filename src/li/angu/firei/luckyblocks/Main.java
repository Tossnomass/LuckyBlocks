package li.angu.firei.luckyblocks;

import li.angu.firei.luckyblocks.commands.CMDaction;
import li.angu.firei.luckyblocks.listener.LISTENERBlockBreak;

import org.bukkit.Bukkit;
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
