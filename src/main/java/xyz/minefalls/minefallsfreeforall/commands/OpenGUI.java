package xyz.minefalls.minefallsfreeforall.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.minefalls.minefallsfreeforall.gui.MainGui;

public class OpenGUI implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player)sender;

        MainGui.displayItemShopGui(player);

        return true;
    }
}
