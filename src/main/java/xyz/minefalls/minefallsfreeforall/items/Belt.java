package xyz.minefalls.minefallsfreeforall.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Belt {
    public ItemStack belt() {

        ItemStack lead = new ItemStack(Material.LEAD);
        ItemMeta leadMeta = lead.getItemMeta();
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&', "&lBeat a child with it."));
        leadMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&eThe Belt"));
        leadMeta.setLore(lore);
        leadMeta.setUnbreakable(true);

        lead.setItemMeta(leadMeta);
        lead.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);

        return lead;
    }
}
