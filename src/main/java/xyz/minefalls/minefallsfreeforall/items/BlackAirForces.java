package xyz.minefalls.minefallsfreeforall.items;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class BlackAirForces {
    public ItemStack blackAirForces(){
        ItemStack blackAirForces = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta airForceMeta = (LeatherArmorMeta) blackAirForces.getItemMeta();

        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("");
        lore.add("drippy");
        airForceMeta.setColor(Color.BLACK);
        airForceMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&k|&r &3Black Air Forces&r &k|&r"));
        airForceMeta.setLore(lore);


        return blackAirForces;
    }
}
