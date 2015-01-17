package li.angu.firei.luckyblocks.events;

import java.util.Random;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.createHologram;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;

public class EventManager {

	static int test = 1;
	
	static Main plugin = Main.instance;

	public static Effekte playEffect(Location loc) {
		int pick = new Random().nextInt(Effekte.values().length);
		Effekte e = Effekte.values()[pick];
		return playEffect(e, loc);
	}

	public static Effekte playEffect(Effekte effect, Location loc) {
		loc.getWorld().playSound(loc, Sound.ANVIL_USE, 5, 1);
		if (effect == Effekte.Diamond) {
			new EFFECTDiamond(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Diamanten für dich!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekte.LuckyBlocks) {
			new EFFECTLuckyBlocks(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " LuckyBlocks für dich!", loc.add(0, 1,
					0));
			return effect;
		}
		if (effect == Effekte.Explosion) {
			new EFFECTExplosion(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " BOOOM!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekte.Redstoner) {
			new EFFECTRedstoner(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Kennst du dich damit aus?", loc.add(0,
					1, 0));
			return effect;
		}
		if (effect == Effekte.Enchanter) {
			new EFFECTEnchanter(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Dann aber los!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekte.LavaBlock) {
			new EFFECTLavaBlock(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " RENN!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekte.SilverFish) {
			new EFFECTSilverFish(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " Töten oder Rennen?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekte.GoldArmor) {
			new EFFECTGoldArmor(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Anziehen!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekte.Stadtmusikanten) {
			new EFFECTStadtmusikanten(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Kennst du sie?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekte.Loch) {
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " Guten Flug!", loc.add(0, 1, 0));
			new EFFECTLoch(loc);
			return effect;
		}
		if (effect == Effekte.Tower) {
			new EFFECTTower(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Schön oder?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekte.Jump) {
			new EFFECTJump(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Spring!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekte.Zombie) {
			new EFFECTZombie(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " Die Zombie Invasion!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekte.Music) {
			new EFFECTMusic(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Bock auf Musik?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekte.LeatherArmor) {
			new EFFECTLeatherArmor(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Lederhose gefällig?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekte.GoldSword) {
			new EFFECTGoldSword(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Brauchst du ein Schwert?", loc.add(0,
					1, 0));
			return effect;
		}
		return effect;
	}

	

}
