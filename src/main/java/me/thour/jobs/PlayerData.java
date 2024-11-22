package me.thour.jobs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerData {
    private Player player;
    private final HashMap<Job, Integer> jobExp;
    private final HashMap<Job, Integer> jobLvl;
    private final HashMap<Job, Integer> jobNextLevel;

    public int getExp(Job job) {
        return jobExp.get(job);
    }
    public void setExp(Job job, int exp) {
        jobExp.put(job, exp);
    }
    public void setJobNextLevelExp(Job job, int exp) {
        jobNextLevel.put(job, exp);
    }
    public int getJobNextLevelExp(Job job) {
        return jobNextLevel.get(job);
    }
    public int getLevel(Job job) {
        return jobLvl.get(job);
    }
    public void setLevel(Job job, int lvl) {
        jobLvl.put(job, lvl);
    }
    public void incrementLevel(Job job) {
         jobLvl.put(job, (jobLvl.get(job))+1);
    }
    public void incrementExp(Job job) {
        jobExp.put(job, ((jobExp.get(job))+1));
        levelUp(job);
    }
    public void incrementExp(Job job, int amount) {
        jobExp.put(job, ((jobExp.get(job))+amount));
        levelUp(job);
    }
    public void printData() {
        jobExp.forEach((key, value) -> {
            System.out.println("INFO: " + key.toString() + " exp = " + value);
        });
    }
    public boolean levelUp(Job job) {
        if (getExp(job) >= getJobNextLevelExp(job)) {
            incrementLevel(job);
            this.player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Congratulations! You have reached level " + getLevel(job) + " in the " + job.toString() + " job.");
            setJobNextLevelExp(job, (int)(getJobNextLevelExp(job)*1.5));
            setExp(job, 0);
            return true;
        }
        return false;
    }

    public PlayerData(Player player) {
        this.player = player;
        jobNextLevel = new HashMap<>();
        jobExp = new HashMap<>();
        jobLvl = new HashMap<>();
        for (Job job : Job.values()) {
            setExp(job, 0);
            setLevel(job, 0);
            setJobNextLevelExp(job, 100);
        }
    }
    public ArrayList<Drop> getDrops(Job job) {
        return job.getDrops();
    }
}
