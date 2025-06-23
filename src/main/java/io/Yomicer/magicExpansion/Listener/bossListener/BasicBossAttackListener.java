package io.Yomicer.magicExpansion.Listener.bossListener;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class BasicBossAttackListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {


        if (event.getEntity() instanceof LivingEntity mob && mob.getType() == EntityType.ZOMBIE) {

            if (mob.hasMetadata("isInvincibleFireZombie")) {
                boolean isInvincibleFireZombie = mob.getMetadata("isInvincibleFireZombie").get(0).asBoolean();

                if (isInvincibleFireZombie) {
                    event.setDamage(0.01);
                }else{
                    double damage = event.getDamage();
                    double maxHealth = mob.getMaxHealth();
                    double threshold = maxHealth * 0.05;
                    if (damage > threshold) {
                        event.setDamage(threshold);
                    }
                }

            }
        }
    }


}
