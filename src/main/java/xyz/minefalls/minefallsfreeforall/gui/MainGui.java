package xyz.minefalls.minefallsfreeforall.gui;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.minefalls.minefallsfreeforall.items.*;

public class MainGui {

    public static void displayItemShopGui(Player player){

        ItemStack lightningHammerStack = new LightningHammer().lightningHammer();
        ItemStack aoteStack = new AspectOfTheEnd().aspectoftheend();
        ItemStack grapplingHookStack = new GrapplingHook().grapplingHook();
        ItemStack beltStack = new Belt().belt();
        ItemStack machineGunStack = new MachineGun().machineGun();

        Gui gui = Gui.gui()
                .title(Component.text("Buy Items"))
                .rows(6)
                .create();

        gui.setDefaultClickAction(event -> event.setCancelled(true));

        GuiItem lightningHammer = ItemBuilder.from(lightningHammerStack).asGuiItem(event ->
            player.getInventory().addItem(lightningHammerStack)
        );
        GuiItem aote = ItemBuilder.from(aoteStack).asGuiItem(event ->
                player.getInventory().addItem(aoteStack)
        );
        GuiItem grapplingHook = ItemBuilder.from(grapplingHookStack).asGuiItem(event ->
                player.getInventory().addItem(grapplingHookStack)
        );
        GuiItem belt = ItemBuilder.from(beltStack).asGuiItem(event ->
                player.getInventory().addItem(beltStack)
        );
        GuiItem machineGun = ItemBuilder.from(machineGunStack).asGuiItem(event ->
                player.getInventory().addItem(machineGunStack)
        );

        gui.setItem(0, lightningHammer);
        gui.setItem(1, aote);
        gui.setItem(2, grapplingHook);
        gui.setItem(3, belt);
        gui.setItem(4, machineGun);

        gui.open(player);
    }
}
