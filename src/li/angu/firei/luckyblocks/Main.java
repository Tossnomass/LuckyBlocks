package li.angu.firei.luckyblocks;

import li.angu.firei.luckyblocks.api.PlatformManager;
import li.angu.firei.luckyblocks.api.StopDetect;
import li.angu.firei.luckyblocks.commands.CMDaction;
import li.angu.firei.luckyblocks.commands.CMDsave;
import li.angu.firei.luckyblocks.events.Effekte;
import li.angu.firei.luckyblocks.listener.LISTENERBlockBreak;
import li.angu.firei.luckyblocks.listener.LISTENERBlockPlace;
import li.angu.firei.luckyblocks.listener.LISTENERClick;
import li.angu.firei.luckyblocks.listener.LISTENERDamage;
import li.angu.firei.luckyblocks.listener.LISTENERFoodChange;
import li.angu.firei.luckyblocks.listener.LISTENERJoin;
import li.angu.firei.luckyblocks.listener.LISTENERLeave;
import li.angu.firei.luckyblocks.listener.LISTENERMove;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
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
					.severe("*** HolographicDisplays ist nicht installiert oder geladen. ***");
			getLogger().severe("*** Dieses Plugin deaktivert sich. ***");
			this.setEnabled(false);
			return;
		}

		instance = this;

		this.getServer().createWorld(new WorldCreator("world"));

		new LISTENERBlockBreak(this);
		new LISTENERJoin(this);
		new LISTENERLeave(this);
		new LISTENERClick(this);
		new LISTENERBlockPlace(this);
		new LISTENERMove(this);
		new LISTENERDamage(this);
		new LISTENERFoodChange(this);

		new StopDetect(this);

		PlatformManager.createPlatform();

		CMDsave save = new CMDsave(this);
		getCommand("save").setExecutor(save);

		CMDaction action = new CMDaction(this);
		getCommand("action").setExecutor(action);

		System.out.println("Seed: " + getServer().getWorld("world").getSeed());
		System.out.println(Effekte.values().length + " Effekte geladen!");
	}

	@Override
	public void onDisable() {

	}

}
