package li.angu.firei.luckyblocks.api;

import java.io.File;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;

public class WorldManager {

	public static void loadChunk(Location loc){
		Chunk ch = loc.getChunk();
		if(!ch.isLoaded()){
			ch.load();
		}
		Bat bat = (Bat) loc.getWorld().spawnEntity(loc, EntityType.BAT);
		bat.setCustomName(ChatColor.AQUA + "LuckyBlocks");
		bat.setCustomNameVisible(true);
		bat.setNoDamageTicks(1000000);
	}
	
	
	public static void unloadWorld(World world) {
	    if(!world.equals(null)) {
	        Bukkit.getServer().unloadWorld(world, true);
	    }
	}
	
	public static boolean deleteWorld(File path) {
	      if(path.exists()) {
	          File files[] = path.listFiles();
	          for(int i=0; i<files.length; i++) {
	              if(files[i].isDirectory()) {
	                  deleteWorld(files[i]);
	              } else {
	                  files[i].delete();
	              }
	          }
	      }
	      return(path.delete());
	}
	
	
}
