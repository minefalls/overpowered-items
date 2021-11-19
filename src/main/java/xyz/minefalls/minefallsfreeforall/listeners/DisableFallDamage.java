package xyz.minefalls.minefallsfreeforall.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import xyz.minefalls.minefallsfreeforall.util.CooldownManager;

public class DisableFallDamage implements Listener {

    @EventHandler
    public void disableFallDamageWhileUsingTools(EntityDamageEvent event){
        if (!event.getEntityType().equals(EntityType.PLAYER)) return;

        Player player = (Player) event.getEntity();

        if (event.getCause() == EntityDamageEvent.DamageCause.FALL){
            if (CooldownManager.fallDamageDisable.contains(player.getUniqueId())){
                player.setFallDistance(-1000000);
                CooldownManager.fallDamageDisable.remove(player.getUniqueId());
                event.setCancelled(true);
            }
        }
    }

}
