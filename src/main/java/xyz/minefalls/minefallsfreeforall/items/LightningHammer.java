package xyz.minefalls.minefallsfreeforall.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LightningHammer {

    public ItemStack lightningHammer() {

        ItemStack ironAxe = new ItemStack(Material.IRON_AXE);
        ItemMeta axeMeta = ironAxe.getItemMeta();
        List<String> lore = new ArrayList<>();
        ItemFlag flags = ItemFlag.HIDE_ATTRIBUTES;
        ItemFlag flags2 = ItemFlag.HIDE_ENCHANTS;

        lore.add(ChatColor.translateAlternateColorCodes('&', "&lSmite a noob with it"));
        axeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&lLightning Hammer"));
        axeMeta.setLore(lore);
        axeMeta.setUnbreakable(true);
        axeMeta.addItemFlags(flags, flags2);

        ironAxe.setItemMeta(axeMeta);

        return ironAxe;
    }
}
