package li.angu.firei.luckyblocks.game;

import java.util.ArrayList;
import java.util.HashMap;

import li.angu.firei.luckyblocks.Main;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class GameManager {

	static Main plugin = Main.instance;
	
	public static HashMap<Player, Location> starts = new HashMap<>();
	
	public static ArrayList<String> protectedblocks = new ArrayList<>();
	
	public static boolean status = false;
	
	public static int size = 800;
	
}
