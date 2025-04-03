package io.Yomicer.magicExpansion.specialActions;

import io.Yomicer.magicExpansion.utils.ColorGradient;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import java.util.Random;
import org.bukkit.Location;

public class EntitySpawner {


    private final Random random = new Random();

    /**
     * 在玩家附近随机生成一个生物。
     *
     * @param player 玩家对象
     */
    public void spawnRandomEntityNearPlayer(Player player) {
        // 获取玩家位置
        Location playerLocation = player.getLocation();

        // 计算随机偏移（3 格范围内，包括斜向）
        double x = random.nextDouble(-3, 3); // 随机 X 偏移
        double y = random.nextDouble(-1, 1); // 随机 Y 偏移（避免过高或过低）
        double z = random.nextDouble(-3, 3); // 随机 Z 偏移

        // 创建目标位置
        Location spawnLocation = playerLocation.clone().add(x, y, z);

        // 随机选择一个生物类型
        EntityType[] entityTypes = EntityType.values();
        EntityType randomEntityType = entityTypes[random.nextInt(entityTypes.length)];

        // 确保选择的是可生成的实体
        if (randomEntityType.isSpawnable()) {
            Entity spawnedEntity = player.getWorld().spawnEntity(spawnLocation, randomEntityType);
            // 检查生成的实体是否是生物（LivingEntity）
            if (spawnedEntity instanceof org.bukkit.entity.LivingEntity) {
                org.bukkit.entity.LivingEntity livingEntity = (org.bukkit.entity.LivingEntity) spawnedEntity;

                // 设置自定义名称
                String entityName = "魔法实体·" + randomEntityType.name(); // 使用随机实体类型的名字作为基础
                livingEntity.setCustomName(ColorGradient.getGradientName(entityName)); // 应用渐变颜色
                livingEntity.setCustomNameVisible(true); // 让名字在游戏中可见
            }
            player.sendMessage(ColorGradient.getGradientName("已召唤魔法实体· " + randomEntityType.name()));
        } else {
            player.sendMessage(ColorGradient.getGradientName("召唤实体失败了~"));
        }
    }

}
