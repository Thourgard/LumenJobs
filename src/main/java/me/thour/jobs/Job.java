package me.thour.jobs;

import java.util.ArrayList;

public enum Job {
    WARRIOR(new ArrayList<>()),
    MINER(new ArrayList<>()),
    FARMER(new ArrayList<>()),
    FISHER(new ArrayList<>()),
    WOODCUTTER(new ArrayList<>());

    private ArrayList<Drop> drops;
    Job(ArrayList<Drop> drops) {
        this.drops = drops;
    }
    public void addDrop(Drop drop) {
        drops.add(drop);
    }
    public static Job getFromString(String str) {
        for(Job j : Job.values()) {
            if (j.toString().toLowerCase().equals(str)) return j;
        }
        return null;
    }
    public ArrayList<Drop> getDrops() {
        return this.drops;
    }
}
