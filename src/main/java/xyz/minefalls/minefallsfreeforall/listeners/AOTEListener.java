package xyz.minefalls.minefallsfreeforall.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import xyz.minefalls.minefallsfreeforall.items.AspectOfTheEnd;
import xyz.minefalls.minefallsfreeforall.util.CooldownManager;
import xyz.minefalls.minefallsfreeforall.util.CooldownTypes;

public class AOTEListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack aspect = new AspectOfTheEnd().aspectoftheend();

        if (event.getItem() != null) {
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(aspect.getItemMeta().getDisplayName()) && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
                try {
                    if (CooldownManager.checkCooldown(player, CooldownTypes.ASPECT_OF_THE_END)) {
                        Block block = player.getTargetBlock(null, 8);
                        Location teleportLocation = new Location(block.getWorld(), block.getX(), block.getY(), block.getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());

                        if (!(teleportLocation.getBlock().getType().equals(Material.AIR))) {
                            player.sendRawMessage(ChatColor.translateAlternateColorCodes('&', "&cThere are blocks in your way!"));
                        }

                        player.teleport(teleportLocation);
                        player.playSound(teleportLocation, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.3F, 1.0F);

                        CooldownManager.setCooldown(player, 0.3D, CooldownTypes.ASPECT_OF_THE_END);
                    }
                    else {
                        player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, 1F, 1F);
                        player.sendRawMessage("Cooldown...");
                    }
                }
                catch (Exception ignore) {

                }
            }
        }
    }
}
