package fishfix;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {
	@EventHandler
	public void on(PlayerInteractEvent e) {
		Block b = e.getClickedBlock();
		Player p = e.getPlayer();
		ItemStack s1 = p.getInventory().getItemInMainHand();
		ItemStack s2 = p.getInventory().getExtraContents()[0];
		if (b != null) {
			if (b.getType() == Material.NOTE_BLOCK || b.getType() == Material.TRAP_DOOR || b.getType() == Material.LEVER
					|| b.getType() == Material.TRAP_DOOR || b.getType() == Material.STONE_BUTTON
					|| b.getType() == Material.WOOD_BUTTON || b.getType() == Material.WALL_SIGN
					|| b.getType() == Material.SIGN_POST || b.getType() == Material.WOODEN_DOOR
					|| b.getType() == Material.SPRUCE_DOOR || b.getType() == Material.BIRCH_DOOR
					|| b.getType() == Material.JUNGLE_DOOR || b.getType() == Material.ACACIA_DOOR
					|| b.getType() == Material.DARK_OAK_DOOR || b.getType() == Material.FENCE_GATE
					|| b.getType() == Material.SPRUCE_FENCE_GATE || b.getType() == Material.BIRCH_FENCE_GATE
					|| b.getType() == Material.JUNGLE_FENCE_GATE || b.getType() == Material.DARK_OAK_FENCE_GATE
					|| b.getType() == Material.ACACIA_FENCE_GATE) {
				boolean bo = false;
				if (s1 != null) {
					if (s1.getType() == Material.FISHING_ROD) {
						bo = true;
					}
				}
				if (s2 != null) {
					if (s2.getType() == Material.FISHING_ROD) {
						bo = true;
					}
				}
				if (bo) {
					FishingBug(p);
				}
			}
		}
	}

	public void FishingBug(Player p) {
		for (Entity entity : p.getNearbyEntities(16, 16, 16)) {
			if (entity.getType() == EntityType.FISHING_HOOK) {
				FishHook fish = (FishHook) entity;
				if (fish.getShooter() instanceof Player) {
					Player s = (Player) fish.getShooter();
					if (p.equals(s)) {
						fish.remove();
					}
				}
			}
		}
	}
}