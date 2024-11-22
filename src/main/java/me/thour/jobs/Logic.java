package me.thour.jobs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Level;

public class Logic implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getBlock().getType().equals(Material.STONE)) {
            System.out.println("INFO: Block is STONE");
            Jobs.getPlayerData(e.getPlayer()).incrementExp(Job.MINER, 3);
            Jobs.getEconomy().
            Jobs.getPlayerData(e.getPlayer()).printData();
            for(Drop d : Jobs.getPlayerData(e.getPlayer()).getDrops(Job.MINER)) {
                d.drop(e.getPlayer(), e.getBlock().getLocation());
            }
        }
        if (e.getBlock().getType().toString().toLowerCase().contains("ore"))
            System.out.println("[Jobs] INFO: Block is ORE");
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Jobs.loadPlayerData(e.getPlayer());
    }
}
