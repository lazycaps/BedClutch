package me.hi12167pies.BedClutch.Commands;

import me.hi12167pies.BedClutch.Main;
import me.hi12167pies.BedClutch.Utils.Arenas;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BedClutch implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (args.length >= 2) {
            if (args[0].equals("join")) {
                Arenas.join(player, args[1]);
            } else sender.sendMessage(command.getUsage());
        } else if (args.length >= 1) {
            if (args[0].equals("leave")) {
                if (!Main.instance.getConfig().getBoolean("bungeecord.enabled")) {
                    Arenas.leave(player);
                } else {
                    player.sendMessage("You cant leave in bungeecord mode, please use a lobby command.");
                }
            } else sender.sendMessage(command.getUsage());
        } else sender.sendMessage(command.getUsage());

        return true;
    }
}
