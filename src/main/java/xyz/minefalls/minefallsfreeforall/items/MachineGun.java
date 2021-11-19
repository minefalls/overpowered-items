package xyz.minefalls.minefallsfreeforall.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MachineGun {
    public ItemStack machineGun() {

        ItemStack sniperBow = new ItemStack(Material.BOW);
        ItemMeta sniperBowMeta = sniperBow.getItemMeta();
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&', "&lLeft click it to use it like a machine gun!"));
        sniperBowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4Machine Gun"));
        sniperBowMeta.setLore(lore);
        sniperBowMeta.setUnbreakable(true);

        sniperBow.setItemMeta(sniperBowMeta);

        return sniperBow;
    }
}
