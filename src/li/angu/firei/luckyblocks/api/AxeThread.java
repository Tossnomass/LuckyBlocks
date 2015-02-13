package li.angu.firei.luckyblocks.api;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class AxeThread implements Runnable {

	private Thread thread;
	private Player p;
	private double radius;
	private boolean running;
	private Item item;

	public AxeThread(Player p, double radius, Item item) {
		this.p = p;
		this.radius = radius;
		this.item = item;
		this.thread = new Thread(this);
	}

	public void start() {
		this.running = true;
		if (running) {
			this.thread.start();
		}
	}

	@SuppressWarnings("deprecation")
	public void stop() {
		this.running = false;
		this.thread.stop();
	}

	@Override
	public void run() {
		while(running){
			for(Entity e : item.getNearbyEntities(radius, radius, radius)){
				if(e instanceof Player){
					Player target = (Player) e;
					if(target != p){
						target.setHealth(target.getHealth() - 7D);
						item.remove();
						this.stop();
						break;
					}
				}
			}
			if(item.isOnGround()){
				this.stop();
			}
			try {
				Thread.sleep(25);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

}
