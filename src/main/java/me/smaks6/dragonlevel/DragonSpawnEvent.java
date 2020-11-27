package me.smaks6.dragonlevel;

import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class DragonSpawnEvent implements Listener {

    @EventHandler
    public void DragonSpawn(EntitySpawnEvent event){
        if(event.getEntity() instanceof EnderDragon){
            Entity dragon = event.getEntity();
            int lvl = Main.getInstance().getConfig().getInt("DragonLevel");
            lvl = lvl * 10 + 200;
            ((Attributable) dragon).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(lvl);
            dragon.setCustomName("Ender Dragon LVL " + Main.getInstance().getConfig().getString("DragonLevel"));
            ((Damageable) dragon).setHealth(lvl);
            Main.getInstance().getServer().broadcastMessage("hp smoka to: " + ((Damageable) dragon).getHealth());
        }
    }
}
