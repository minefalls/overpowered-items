package xyz.minefalls.minefallsfreeforall.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class AspectOfTheEnd {

    public ItemStack aspectoftheend(){

        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta swordMeta = diamondSword.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add("Right click somewhere to teleport there!");

        swordMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dAspect of the End"));
        swordMeta.setLore(lore);
        swordMeta.setUnbreakable(true);
        diamondSword.setItemMeta(swordMeta);
        return diamondSword;
    }
}
