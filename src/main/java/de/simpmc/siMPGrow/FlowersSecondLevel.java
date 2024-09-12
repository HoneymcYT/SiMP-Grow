package de.simpmc.siMPGrow;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.UUID;

public class FlowersSecondLevel {
    private final UUID plantID;
    private final Block plantBlock;
    private int health;
    private int fertilizationCount;
    private BukkitTask plantLifeTask;
    private final JavaPlugin plugin;


    public FlowersSecondLevel(UUID plantID, Block plantBlock, JavaPlugin plugin) {
        this.plantID = plantID;
        this.plantBlock = plantBlock;
        this.plugin = plugin;
        this.health = 16;
        this.fertilizationCount = 0;

        startPlantLifeCycle();
    }
    public UUID getPlantID() {
        return plantID;
    }
    public Block getHealth() {
        return getHealth();
    }

public void fertilizeWithBoneMeal(Player player) {
        if (++fertilizationCount > 300) {
            upgradeToLargeFern(player);
        } else {
            player.sendMessage("SiMP-Flower wurde" + fertilizationCount + "mal mit Knochenmehl bestäubt");
        }
}

    private void upgradeToLargeFern(Player player) {
        plantLifeTask = new BukkitRunnable() {
            @Override
            public void run() {
                if (health > 0) {
                    health--;
                    if (health == 0) {
                        plantBlock.setType(Material.AIR);
                        cancel();
                        Bukkit.broadcastMessage("Deine Flower ist auf Level2 ist verwelkt!");
                    } else {
                        updateHealthDisplay();
                    }
                }
            }

            private void updateHealthDisplay() {
            }
        }.runTaskTimer(plugin, 0L,24 * 60 * 60 * 20L);
    }


    private void startPlantLifeCycle() {
    }
}
