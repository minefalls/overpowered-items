package xyz.minefalls.minefallsfreeforall.util;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class CooldownManager {

    public static HashMap<UUID, Double> lightningHammerCooldown;
    public static HashMap<UUID, Double> aoteCooldown;
    public static HashMap<UUID, Double> grapplingHookCooldown;
    public static HashMap<UUID, Double> machineGunCooldown;
    public static List<UUID> fallDamageDisable;

    public static void setupCooldown(){
        lightningHammerCooldown = new HashMap<>();
        aoteCooldown = new HashMap<>();
        grapplingHookCooldown = new HashMap<>();
        fallDamageDisable = new ArrayList<>();
        machineGunCooldown = new HashMap<>();
    }

    public static void setCooldown(Player player, double seconds, CooldownTypes types){

        double delay;

        switch (types){
            case LIGHTNING_AXE:
                delay = System.currentTimeMillis() + (seconds * 1000);
                lightningHammerCooldown.put(player.getUniqueId(), delay);
                break;
            case ASPECT_OF_THE_END:
                delay = System.currentTimeMillis() + (seconds * 1000);
                aoteCooldown.put(player.getUniqueId(), delay);
                if (!fallDamageDisable.contains(player.getUniqueId())) fallDamageDisable.add(player.getUniqueId());
                break;
            case GRAPPLING_HOOK:
                delay = System.currentTimeMillis() + (seconds * 1000);
                grapplingHookCooldown.put(player.getUniqueId(), delay);
                if (!fallDamageDisable.contains(player.getUniqueId())) fallDamageDisable.add(player.getUniqueId());
                break;
            case MACHINE_GUN:
                delay = System.currentTimeMillis() + (seconds * 1000);
                machineGunCooldown.put(player.getUniqueId(), delay);
                break;
        }
    }

    public static boolean checkCooldown(Player player, CooldownTypes types){
        switch (types){
            case LIGHTNING_AXE:
                return (!lightningHammerCooldown.containsKey(player.getUniqueId()) || lightningHammerCooldown.get(player.getUniqueId()) <= System.currentTimeMillis());
            case ASPECT_OF_THE_END:
                return (!aoteCooldown.containsKey(player.getUniqueId()) || aoteCooldown.get(player.getUniqueId()) <= System.currentTimeMillis());
            case GRAPPLING_HOOK:
                return (!grapplingHookCooldown.containsKey(player.getUniqueId()) || grapplingHookCooldown.get(player.getUniqueId()) <= System.currentTimeMillis());
            case MACHINE_GUN:
                return (!machineGunCooldown.containsKey(player.getUniqueId()) || machineGunCooldown.get(player.getUniqueId()) <= System.currentTimeMillis());
        }
        return false;
    }

    public static int getCooldown(Player player, CooldownTypes types){
        if (types == CooldownTypes.LIGHTNING_AXE) return (int) Math.round((lightningHammerCooldown.get(player.getUniqueId()) - System.currentTimeMillis()) / 1000);

        else if (types == CooldownTypes.ASPECT_OF_THE_END) return (int) Math.round((aoteCooldown.get(player.getUniqueId()) - System.currentTimeMillis()) / 1000);

        else if (types == CooldownTypes.GRAPPLING_HOOK) return (int) Math.round((grapplingHookCooldown.get(player.getUniqueId()) - System.currentTimeMillis()) / 1000);

        else if (types == CooldownTypes.MACHINE_GUN) return (int) Math.round((machineGunCooldown.get(player.getUniqueId()) - System.currentTimeMillis()) / 1000);

        else return 0;
    }
}
