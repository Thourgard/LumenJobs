package me.thour.jobs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Drop {
    private final int dropChance;
    private final ItemStack item;
    private final int level;
    private final Material source;
    private final Job job;
    public Drop(Job job, int dropChance, int level,ItemStack item, Material source) {
        this.job = job;
        this.dropChance = dropChance;
        this.level = level;
        this.item = item;
        this.source = source;
    }
    public Drop(Job job, int dropChance, int level, ItemStack item) {
        this.job = job;
        this.dropChance = dropChance;
        this.level = level;
        this.item = item;
        this.source = null;
    }
    public void drop(Player player, Location location) {
        if (Jobs.getPlayerData(player).getLevel(job) < level) return;
        Random rng = new Random();
        if (rng.nextInt(100) < dropChance) return;
        player.getWorld().dropItem(location, item);
    }

    public Material getSource() {
        return source;
    }
}
