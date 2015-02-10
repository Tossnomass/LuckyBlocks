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

	public static Effekt playEffect(Location loc) {
		int pick = new Random().nextInt(Effekt.values().length);
		Effekt e = Effekt.values()[pick];
		return playEffect(e, loc);
	}

	public static Effekt playEffect(Effekt effect, Location loc) {
		loc.getWorld().playSound(loc, Sound.ANVIL_USE, 1, 1);
		if (effect == Effekt.Diamond) {
			new EFFECTDiamond(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Diamanten für dich!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.LuckyBlocks) {
			new EFFECTLuckyBlocks(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " LuckyBlocks für dich!", loc.add(0, 1,
					0));
			return effect;
		}
		if (effect == Effekt.Explosion) {
			new EFFECTExplosion(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " BOOOM!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.Redstoner) {
			new EFFECTRedstoner(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Kennst du dich damit aus?", loc.add(0,
					1, 0));
			return effect;
		}
		if (effect == Effekt.Enchanter) {
			new EFFECTEnchanter(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Dann aber los!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.LavaBlock) {
			new EFFECTLavaBlock(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " RENN!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.SilverFish) {
			new EFFECTSilverFish(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " Töten oder Rennen?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.GoldArmor) {
			new EFFECTGoldArmor(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Anziehen!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.Stadtmusikanten) {
			new EFFECTStadtmusikanten(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Kennst du sie?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.Loch) {
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " Guten Flug!", loc.add(0, 1, 0));
			new EFFECTLoch(loc);
			return effect;
		}
		if (effect == Effekt.Tower) {
			new EFFECTTower(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Schön oder?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.Jump) {
			new EFFECTJump(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Spring!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.Zombie) {
			new EFFECTZombie(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.DARK_RED + "-"
					+ ChatColor.RED + " Die Zombie Invasion!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.Music) {
			new EFFECTMusic(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Bock auf Musik?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.LeatherArmor) {
			new EFFECTLeatherArmor(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Lederhose gefällig?", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.GoldSword) {
			new EFFECTGoldSword(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Brauchst du ein Schwert?", loc.add(0,
					1, 0));
			return effect;
		}
		if (effect == Effekt.Iron) {
			new EFFECTIron(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Rostgefahr!", loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.Workbench) {
			new EFFECTworkbench(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Das Craften beginnt!",
					loc.add(0, 1, 0));
			return effect;
		}
		if (effect == Effekt.WoodTools) {
			new EFFECTWoodTools(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Wenigstens ein Anfang!", loc);
		}
		if (effect == Effekt.StoneTools) {
			new EFFECTStoneTools(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Wenigstens ein Anfang!", loc);
		}
		if (effect == Effekt.Dirt) {
			new EFFECTDirt(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Was ein Dreck!", loc);
		}
		if (effect == Effekt.IronBlock) {
			new EFFECTIronBlock(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Lass es nicht rosten!", loc);
		}
		if (effect == Effekt.Rod) {
			new EFFECTRod(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Schwing die Angel!", loc);
		}
		if (effect == Effekt.Archer) {
			new EFFECTArcher(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Triff!", loc);
		}
		if (effect == Effekt.Bedrock) {
			new EFFECTBedrock(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "-"
					+ ChatColor.RED + " Na toll!", loc);
		}
		if (effect == Effekt.Cake) {
			new EFFECTCake(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Guten Hunger!", loc);
		}
		if (effect == Effekt.Anvil) {
			new EFFECTAnvil(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " An die Eisen!", loc);
		}
		if (effect == Effekt.SpiderInvasion) {
			new EFFECTSpiderInvasion(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "-"
					+ ChatColor.RED + " Das sieht gefährlich aus!", loc);
		}
		if (effect == Effekt.Giant) {
			new EFFECTGiant(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "-"
					+ ChatColor.RED + " Der ist aber gross!", loc);
		}
		if (effect == Effekt.RandomBlock) {
			new EFFECTRandomBlock(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Ein schöner Block!", loc);
		}
		if (effect == Effekt.ColoredWool) {
			new EFFECTColoredWool(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Wolle gefällig?", loc);
		}
		if (effect == Effekt.Fische) {
			new EFFECTFische(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Guten Hunger!", loc);
		}
		if (effect == Effekt.EggThrower) {
			new EFFECTEggThrower(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Damit kannst du Eier werfen", loc);
		}
		if (effect == Effekt.Steak) {
			new EFFECTSteak(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Guten Hunger!", loc);
		}
		if (effect == Effekt.Chicken) {
			new EFFECTChicken(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Guten Hunger!", loc);
		}
		if (effect == Effekt.Bread) {
			new EFFECTBread(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Guten Hunger!", loc);
		}
		if (effect == Effekt.Compass) {
			new EFFECTCompass(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Damit kannst du deine Gegner finden!",
					loc);
		}
		if (effect == Effekt.Battleaxe) {
			new EFFECTBattleAxe(loc);
			new createHologram(ChatColor.BOLD + "" + ChatColor.GOLD + "+"
					+ ChatColor.AQUA + " Die kannst du werfen!", loc);
		}
		return effect;
	}

}
