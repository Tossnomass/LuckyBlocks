package li.angu.firei.luckyblocks.events;

import java.util.Random;

import li.angu.firei.luckyblocks.Main;
import li.angu.firei.luckyblocks.createHologram;

import org.bukkit.ChatColor;
import org.bukkit.Location;

public class EventManager {

	static int test = 1;
	
	static Main plugin = Main.instance;

	public static Effects playEffect(Location loc) {
		int pick = new Random().nextInt(Effects.values().length);
		Effects e = Effects.values()[pick];
		return playEffect(e, loc);
	}

	public static Effects playEffect(Effects effect, Location loc) {

		if (effect == Effects.Diamond) {
			new EFFECTDiamond(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Diamanten für dich!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effects.LuckyBlocks) {
			new EFFECTLuckyBlocks(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " LuckyBlocks für dich!", loc.add(0, 1,
					0));
			return effect;
		}
		if (effect == Effects.Explosion) {
			new EFFECTExplosion(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " BOOOM!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effects.Redstoner) {
			new EFFECTRedstoner(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Kennst du dich damit aus?", loc.add(0,
					1, 0));
			return effect;
		}
		if (effect == Effects.Enchanter) {
			new EFFECTEnchanter(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Dann aber los!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effects.LavaBlock) {
			new EFFECTLavaBlock(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " RENN!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effects.SilverFish) {
			new EFFECTSilverFish(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " Töten oder Rennen?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effects.GoldArmor) {
			new EFFECTGoldArmor(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Anziehen!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effects.Stadtmusikanten) {
			new EFFECTStadtmusikanten(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Kennst du sie?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effects.Loch) {
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " Guten Flug!", loc.add(0, 1, 0));
			new EFFECTLoch(loc);
			return effect;
		}
		if (effect == Effects.Tower) {
			new EFFECTTower(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Schön oder?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effects.Jump) {
			new EFFECTJump(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Spring!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effects.Zombie) {
			new EFFECTZombie(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " Die Zombie Invasion!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effects.Music) {
			new EFFECTMusic(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Bock auf Musik?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effects.LeatherArmor) {
			new EFFECTLeatherArmor(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Lederhose gefällig?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effects.GoldSword) {
			new EFFECTGoldSword(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Brauchst du ein Schwert?", loc.add(0,
					1, 0));
			return effect;
		}
		return effect;
	}

	public enum Effects {
		Diamond, LuckyBlocks, Explosion, Redstoner, Enchanter, LavaBlock, SilverFish, GoldArmor, Stadtmusikanten, Loch, Tower, Jump, Zombie, Music, LeatherArmor, GoldSword;
	}

}
