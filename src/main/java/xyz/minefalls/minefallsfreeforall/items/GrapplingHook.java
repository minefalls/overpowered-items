package xyz.minefalls.minefallsfreeforall.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GrapplingHook {
    public ItemStack grapplingHook() {

        ItemStack fishingRod = new ItemStack(Material.FISHING_ROD);
        ItemMeta rodMeta = fishingRod.getItemMeta();
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&', "&lRight click to go WHEEE"));
        rodMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&eGrappling Hook"));
        rodMeta.setLore(lore);
        rodMeta.setUnbreakable(true);

        fishingRod.setItemMeta(rodMeta);

        return fishingRod;
    }
}
