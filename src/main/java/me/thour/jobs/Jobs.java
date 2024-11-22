package me.thour.jobs;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

import java.util.HashMap;
import java.util.UUID;

public final class Jobs extends JavaPlugin {
    public static Jobs instance;
    private static HashMap<UUID, PlayerData> players;
    private static Economy eco;
    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new Logic(), this);
        this.getCommand("lumen").setExecutor(new LumenCommand());
        loadPlayerData();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static Jobs getInstance() {
        return instance;
    }
    private void loadPlayerData() {
        players = new HashMap<>();
        for(Player player : getServer().getOnlinePlayers()) {
            players.put(player.getUniqueId(), new PlayerData(player));
        }
    }
    public static void loadPlayerData(Player player) {
        players.put(player.getUniqueId(), new PlayerData(player));
    }
    public static PlayerData getPlayerData(Player player) {
        return players.get(player.getUniqueId());
    }
    public static void setPlayerData(Player player, PlayerData playerData) {
        players.put(player.getUniqueId(), playerData);
    }
    public static Economy getEconomy() {
        return eco;
    }
}
