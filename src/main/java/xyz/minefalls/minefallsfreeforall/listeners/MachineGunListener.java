package xyz.minefalls.minefallsfreeforall.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import xyz.minefalls.minefallsfreeforall.MineFallsFreeForAll;
import xyz.minefalls.minefallsfreeforall.items.MachineGun;
import xyz.minefalls.minefallsfreeforall.util.CooldownManager;
import xyz.minefalls.minefallsfreeforall.util.CooldownTypes;

public class MachineGunListener implements Listener {

    private final MineFallsFreeForAll mainInstance = MineFallsFreeForAll.getInstance();

    @EventHandler
    public void onGunUse(PlayerInteractEvent event){

        ItemStack machineGun = new MachineGun().machineGun();

        Player player = event.getPlayer();
        Vector arrowVector = player.getLocation().getDirection();
        arrowVector.multiply(3);
        arrowVector.setY(arrowVector.getY() + 0.2D);

        /*
        just a few null checks don't mind them lmao
        */
        if (player.getInventory().getItemInMainHand() == null) return;
        if (player.getInventory().getItemInMainHand().getItemMeta() == null) return;
        if (player.getInventory().getItemInMainHand().getItemMeta().getLore() == null) return;
        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() == null) return;

        ItemMeta playerItemMeta = player.getInventory().getItemInMainHand().getItemMeta();

        if (!(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)) return;
        if (!(playerItemMeta.getDisplayName().equals(machineGun.getItemMeta().getDisplayName()) || playerItemMeta.getLore().equals(machineGun.getItemMeta().getLore()))) return;

        if (CooldownManager.checkCooldown(player, CooldownTypes.MACHINE_GUN)) {
            Arrow arrow = player.launchProjectile(Arrow.class, arrowVector);
            arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
            player.playSound(player.getLocation(), Sound.ENTITY_ARROW_SHOOT, 1, 1);
            CooldownManager.setCooldown(player, 0.3D, CooldownTypes.MACHINE_GUN);
        }
        else {
            player.sendRawMessage(ChatColor.translateAlternateColorCodes('&', "&cA little too fast there..."));
        }
    }
}
