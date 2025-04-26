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


        // 检查是否是我们的雷霆僵尸
        if (event.getEntity() instanceof LivingEntity mob && mob.getType() == EntityType.ZOMBIE) {

            // 检查僵尸是否有无敌元数据
            if (mob.hasMetadata("isInvincibleFireZombie")) {
                boolean isInvincibleFireZombie = mob.getMetadata("isInvincibleFireZombie").get(0).asBoolean();

                // 如果处于无敌状态，将伤害限制为 0.01
                if (isInvincibleFireZombie) {
                    event.setDamage(0.01); // 设置伤害为极小值
                }else{
                    // 未处于无敌状态时，判断伤害值
                    double damage = event.getDamage();
                    if (damage > 10) {
                        event.setDamage(10); // 将伤害削弱为 5
                    }
                }

            }
        }
    }


}
