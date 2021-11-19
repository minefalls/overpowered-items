package xyz.minefalls.minefallsfreeforall;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.minefalls.minefallsfreeforall.commands.OpenGUI;
import xyz.minefalls.minefallsfreeforall.listeners.*;
import xyz.minefalls.minefallsfreeforall.util.CooldownManager;

public final class MineFallsFreeForAll extends JavaPlugin {

    private static MineFallsFreeForAll instance;

    public static MineFallsFreeForAll getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        instance = this;

        // empty cooldown hashmap and reset it every time server restarts
        CooldownManager.setupCooldown();

        // listeners
        pm.registerEvents(new LightningHammerListener(), this);
        pm.registerEvents(new AOTEListener(), this);
        pm.registerEvents(new GrapplingHookListener(), this);
        pm.registerEvents(new DisableFallDamage(), this);
        pm.registerEvents(new MachineGunListener(), this);

        // commands
        getCommand("shop").setExecutor(new OpenGUI());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
