package me.thour.jobs;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LumenCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) return false;
         Job.getFromString(args[0]).addDrop(new Drop(Job.getFromString(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), ((Player) commandSender).getInventory().getItemInMainHand(), Material.getMaterial(args[3])));

        return false;
    }
}
