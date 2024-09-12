package de.simpmc.siMPGrow;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.UUID;

import static org.bukkit.Material.AIR;

public class SiMPFlowersLivebar {
    private UUID plantID;
    private Block plantBlock;
    private int health;
    private BukkitTask plantLifeTask;
    private JavaPlugin plugin;

    public void SimpFlower(UUID plantID, Block plantBlock, JavaPlugin plugin) {
        this.plantID = plantID;
        this.plantBlock = plantBlock;
        this.health = 8;
        this.plugin = plugin;


    }

    public SiMPFlowersLivebar(UUID plantID, Block plantBlock, JavaPlugin plugin) {
        this.plantID = plantID;
        this.plantBlock = plantBlock;
        this.plugin = plugin;
    }

    private void startPlantLifeCycle() {
    }
    public UUID getPlantID() {
        return plantID;
    }
    public Block getPlantBlock() {
        return plantBlock;
    }
    public int getHealth() {
        return health;
    }
    private void startPlantLifeCycle() {
        plantLifeTask = new BukkitRunnable() {
            @Override
            public void run() {
                if (health > 0) {
                    health--;
                    boolean b = health <= 0;
                    if health <=0) {
    plantBlock.setType(Material.AIR);
    cancel();
    Bukkit.broadcastMessage("Deine SiMP-Flower ist verwelkt");


    } else {
                        updateHealthDisplay();
                    }
                    }
                }
        }.runTaskTimer(plugin 0L, 24 * 60 * 60 * 20L);
        private void updateHealthDisplay() {
            hologram.setVisible(false);
            hologram.setCustomName("HP: " + health + " / 8");
            hologram.setCustomNameVisible(true);
            hologram.setMarker(true);
            hologram.setGravity(false);
            hologram.setInvulnerable(true);
            hologram.setSmall(true);


            new BukkitRunnable() {
            @Override
            public void run() {
            hologram.remove();
            }
            }.runTaskLater(plugin, 60L);

        }
        public void stopPlantLifeCycle() {
            if (plantLifeTask != null && !plantLifeTask.isCancelled()) {
            plantLifeTask.cancel();}
        }
        }

        }

