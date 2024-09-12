package de.simpmc.siMPGrow;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import de.simpmc.siMPGrow.SiMPGrow;
import org.bukkit.util.Vector;
import org.bukkit.block.Block;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.metadata.FixedMetadataValue;

public final class SiMPGrow extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("SiMPGrow ist eingeschalten SIMPMC.DE!");
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        getLogger().info("SiMPGrow ist ausgeschalten SIMPMC.");
        // Plugin shutdown logic
    }
    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK && event.getHand() != EquipmentSlot.HAND){
            return;
        }
        Block clickedBlock = event.getClickedBlock();
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (clickedBlock != null && clickedBlock.getType() == Material.GRASS_BLOCK && itemInHand.getType() == Material.HONEY_BOTTLE) {
            Block blockAbove = clickedBlock.getRelative(0, 1, 0);

            if (blockAbove.getType() != Material.AIR){
                return;
            }
            blockAbove.setType(Material.TALL_GRASS);

            ItemStack namedPlant = new ItemStack(Material.TALL_GRASS);
            blockAbove.getWorld().spawn(blockAbove.getLocation().add(new Vector(0.5, 0, 0.5)), ItemFrame.class, (itemFrame) -> {
                itemFrame.setItem(namedPlant);
                itemFrame.setCustomName("SiMP-Flower Level 1");
                itemFrame.setCustomNameVisible(true);
            });
            itemInHand.setAmount(itemInHand.getAmount() - 1);
            player.sendMessage("Du hast eine SiMP-Blüte geplanzt!");

            event.setCancelled(true);
        }
    }
}
