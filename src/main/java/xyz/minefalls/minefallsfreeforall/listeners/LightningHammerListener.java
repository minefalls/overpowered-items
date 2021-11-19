package xyz.minefalls.minefallsfreeforall.listeners;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.minefalls.minefallsfreeforall.MineFallsFreeForAll;
import xyz.minefalls.minefallsfreeforall.items.LightningHammer;
import xyz.minefalls.minefallsfreeforall.util.CooldownManager;
import xyz.minefalls.minefallsfreeforall.util.CooldownTypes;

public class LightningHammerListener implements Listener {

    private final MineFallsFreeForAll mainInstance = MineFallsFreeForAll.getInstance();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){

        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        ItemStack lightningHammer = new LightningHammer().lightningHammer();

        if (item == null) return;

        ItemMeta meta = item.getItemMeta();
        String name = meta.getDisplayName();

        if (lightningHammer.getType().equals(item.getType()) && lightningHammer.getItemMeta().getDisplayName().equals(name)){
            Block block = player.getTargetBlockExact(200);

            if (block != null) {
                if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                    if (true)
                    player.getWorld().strikeLightning(block.getLocation());
                    event.setCancelled(true);
                    return;
                }

                if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
                    if (CooldownManager.checkCooldown(player, CooldownTypes.LIGHTNING_AXE)) {
                        CooldownManager.setCooldown(player, 15, CooldownTypes.LIGHTNING_AXE);

                        player.getWorld().createExplosion(block.getLocation(), 5f, false, true);
                        player.getWorld().strikeLightning(block.getLocation());
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "You need to wait " + CooldownManager.getCooldown(player, CooldownTypes.LIGHTNING_AXE) + " seconds");
                    }
                }
            }
            event.setCancelled(true);
        }
    }
}
