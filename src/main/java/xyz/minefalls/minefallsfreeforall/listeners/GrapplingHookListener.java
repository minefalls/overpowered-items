package xyz.minefalls.minefallsfreeforall.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.minefalls.minefallsfreeforall.items.GrapplingHook;
import xyz.minefalls.minefallsfreeforall.util.CooldownManager;
import xyz.minefalls.minefallsfreeforall.util.CooldownTypes;

public class GrapplingHookListener implements Listener {

    @EventHandler
    public void onRodEvent(PlayerFishEvent event){
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        ItemStack grapplingHook = new GrapplingHook().grapplingHook();
        ItemMeta hookMeta = grapplingHook.getItemMeta();

        if (meta.getDisplayName().equals(hookMeta.getDisplayName())){
            if (event.getState() == PlayerFishEvent.State.REEL_IN){
                if (CooldownManager.checkCooldown(player, CooldownTypes.GRAPPLING_HOOK)) {
                    Location playerLocation = player.getLocation();
                    Location hookLocation = event.getHook().getLocation();

                    Location change = hookLocation.subtract(playerLocation);

                    player.setVelocity(change.toVector().multiply(0.3D));
                    CooldownManager.setCooldown(player, 1.5, CooldownTypes.GRAPPLING_HOOK);
                }
                else {
                    player.sendMessage(ChatColor.RED + "You need to wait " + CooldownManager.getCooldown(player, CooldownTypes.GRAPPLING_HOOK) + " seconds");
                }
            }
        }
    }
}
