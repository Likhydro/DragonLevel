package me.smaks6.dragonlevel;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DragonDeath implements Listener {

    @EventHandler
    public void deathdragon(EntityDeathEvent event){
        if(event.getEntity() instanceof EnderDragon){
            Entity dragon = event.getEntity();
            int lvl = Main.getInstance().getConfig().getInt("DragonLevel");
            lvl++;
            Main.getInstance().getConfig().set("DragonLevel", lvl);
            Main.getInstance().saveConfig();
            Main.getInstance().reloadConfig();
            Location dragondeathlocation = dragon.getLocation();
            World world = dragon.getWorld();
            ItemStack item = new ItemStack(Material.ELYTRA);
            world.dropItem(dragondeathlocation, item);
        }
    }
}
