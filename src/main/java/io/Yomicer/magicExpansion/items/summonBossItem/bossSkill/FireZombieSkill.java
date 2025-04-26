package io.Yomicer.magicExpansion.items.summonBossItem.bossSkill;

import io.Yomicer.magicExpansion.utils.log.Debug;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FireZombieSkill {



    // 生成粒子特效
    private static void spawnParticleEffects(Location location,Player player) {
        // 火焰粒子
        location.getWorld().spawnParticle(Particle.FLAME, location, 1000, 10, 8, 10, 0.1);
//        player.sendMessage("FLAME触发");

        // 烟雾粒子
        location.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, location, 1000, 10, 8, 10, 0.1);
//        player.sendMessage("CAMPFIRE_COSY_SMOKE触发");
        // 魔法粒子
        // 定义粒子的颜色（青色）
//        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(0, 255, 255), 1.0f);
        location.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, location, 1000, 10, 8, 10, 0.1);
//        player.sendMessage("ENCHANT触发");
    }

    // 生成粒子特效
    private static void spawnOneParticle(Location location,Player player, Particle particle, int num) {
        // 火焰粒子
        location.getWorld().spawnParticle(particle, location, num, 10, 8, 10, 0.1);
//        player.sendMessage("FLAME触发");
    }
    private static void spawnOneParticle(Location location,Player player, Particle particle, int num, double x, double y, double z) {
        // 火焰粒子
        location.getWorld().spawnParticle(particle, location, num, x, y, z, 0.1);
//        player.sendMessage("FLAME触发");
    }

    private static void spawnOneParticle(Location location, Player player, Particle particle, Particle.DustOptions extraInfo){
        location.getWorld().spawnParticle(particle, location, 1000, 10, 8, 10, 0.1,extraInfo);
    }


    /**
     * 获取附近的玩家
     */
    private static List<Player> getNearbyPlayers(LivingEntity mob) {
        return mob.getWorld().getNearbyEntities(mob.getLocation(), 10, 8, 10).stream()
                .filter(entity -> entity instanceof Player)
                .map(entity -> (Player) entity)
                .collect(Collectors.toList());
    }

    /**
     * 技能：魔法攻击
     */
    public static void magicAttackSkill(LivingEntity mob, Player player) {
        for (Player nearbyPlayer : getNearbyPlayers(mob)) {
            nearbyPlayer.damage(10, mob); // 造成5点伤害
            nearbyPlayer.sendMessage("§d§l烈焰僵尸对你发动了魔法攻击！");
            spawnOneParticle(nearbyPlayer.getLocation(), player, Particle.ENCHANTMENT_TABLE,2500);
        }
    }

    /**
     * 技能：红石粒子攻击
     */
    public static void redstoneParticleAttackSkill(LivingEntity mob, Player player) {
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(0, 255, 255), 1.0f);
        for (Player nearbyPlayer : getNearbyPlayers(mob)) {
            nearbyPlayer.damage(8, mob); // 造成5点伤害
            nearbyPlayer.sendMessage("§b§l烈焰僵尸对你发动了精神攻击！");
            spawnOneParticle(nearbyPlayer.getLocation(), player, Particle.REDSTONE, dustOptions);
            // 添加负面效果（持续2秒，等级10）
            nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 40, 10)); // 攻击缓慢
            nearbyPlayer.sendMessage(ChatColor.RED + "你的手臂变得沉重无比，" + ChatColor.YELLOW + "攻击速度大幅下降！");
            nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 10));         // 移动缓慢
            nearbyPlayer.sendMessage(ChatColor.DARK_BLUE + "你的双腿像灌了铅一样，" + ChatColor.GOLD + "移动变得异常迟缓！");
            nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 10));    // 致盲
            nearbyPlayer.sendMessage(ChatColor.BLACK + "黑暗笼罩了你的视野，" + ChatColor.LIGHT_PURPLE + "你几乎什么都看不见！");
            nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 180, 10));    // 反胃
            nearbyPlayer.sendMessage(ChatColor.GREEN + "一阵强烈的眩晕感袭来，" + ChatColor.DARK_GREEN + "你的世界开始天旋地转！");
            nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 40, 10));       // 饥饿
            nearbyPlayer.sendMessage(ChatColor.DARK_RED + "你的肚子发出痛苦的呻吟，" + ChatColor.GRAY + "饥饿感正在吞噬你的体力！");
            nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 40, 10));     // 失明（1.19+版本支持）
            nearbyPlayer.sendMessage(ChatColor.DARK_GRAY + "深邃的黑暗侵蚀了你的灵魂，" + ChatColor.WHITE + "你完全陷入了无尽的虚无！");
        }
    }

    /**
     * 技能：火焰攻击
     */
    public static void fireParticleAttackSkill(LivingEntity mob, Player player) {

        // 获取附近的玩家
        List<Player> nearbyPlayers = getNearbyPlayers(mob);

        // 如果没有玩家在范围内，直接返回
        if (nearbyPlayers.isEmpty()) {
            return;
        }

        // 随机选择一个目标玩家
        Player targetPlayer = nearbyPlayers.get(new Random().nextInt(nearbyPlayers.size()));

        // 对目标玩家造成伤害
        targetPlayer.damage(88, mob); // 造成88点伤害

        // 发送提示信息给目标玩家
        targetPlayer.sendMessage("§c§l烈焰僵尸锁定了你！");
        targetPlayer.sendMessage("§e§l炙热的火焰吞噬了你的灵魂...");
        targetPlayer.sendMessage("§c§l你受到了" +"§e§l88点伤害§c§l" +"！");

        // 添加链接线效果
        spawnLinkEffect(mob.getLocation(), targetPlayer.getLocation());
        // 在目标玩家位置生成火焰粒子效果
        spawnOneParticle(targetPlayer.getLocation(), player, Particle.FLAME, 200, 1, 1, 1);

        // 广播消息给范围内的其他玩家（非目标玩家）
        for (Player nearbyPlayer : nearbyPlayers) {
            if (!nearbyPlayer.equals(targetPlayer)) {
                nearbyPlayer.sendMessage("§e§l烈焰僵尸刚刚发动了火焰攻击！");
                nearbyPlayer.sendMessage("§e§l它锁定了 §b"+ targetPlayer.getName() + "§e§l！");
            }
        }
    }



    /**
     * 在两个位置之间生成链接线效果
     *
     * @param start 起始位置（例如烈火僵尸的位置）
     * @param end   结束位置（例如目标玩家的位置）
     */
    public static void spawnLinkEffect(Location start, Location end) {
        // 获取起始和结束位置的坐标
        double startX = start.getX();
        double startY = start.getY();
        double startZ = start.getZ();

        double endX = end.getX();
        double endY = end.getY();
        double endZ = end.getZ();

        // 计算两点之间的距离
        double distance = start.distance(end);

        // 设置粒子的数量和间隔
        int particleCount = (int) (distance * 5); // 每单位距离生成 5 个粒子
        double deltaX = (endX - startX) / particleCount;
        double deltaY = (endY - startY) / particleCount;
        double deltaZ = (endZ - startZ) / particleCount;

        // 在两点之间生成粒子
        for (int i = 0; i < particleCount; i++) {
            double x = startX + deltaX * i;
            double y = startY + deltaY * i;
            double z = startZ + deltaZ * i;

            // 创建粒子位置
            Location particleLocation = new Location(start.getWorld(), x, y, z);

            // 生成粒子效果（例如红线或能量线）
            start.getWorld().spawnParticle(Particle.REDSTONE, particleLocation, 1, new Particle.DustOptions(Color.RED, 1.0f));
        }
    }




}
