package io.Yomicer.magicExpansion.items.misc.weapon;

import io.Yomicer.magicExpansion.MagicExpansion;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class StarShardsSword extends SimpleSlimefunItem<ItemUseHandler> implements RecipeDisplayItem, Listener {

    public static final double DAMAGE_MULTIPLIER = 61.8;
    private final Map<UUID, Map<String, Long>> cooldowns = new HashMap<>();
    private final Map<UUID, Long> lastMessageTime = new HashMap<>();

    public StarShardsSword(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        ItemMeta meta = getItem().getItemMeta();
        if (meta != null) {
            meta.setUnbreakable(true);

            String namespace = "star_shards_sword";

            // 💥 攻击力 +1314（固定值）
            UUID atk1Id = UUID.nameUUIDFromBytes((namespace + "_atk_add").getBytes());
            meta.addAttributeModifier(
                    Attribute.GENERIC_ATTACK_DAMAGE,
                    new AttributeModifier(atk1Id, "StarShards_Atk_Add", 1314.0, AttributeModifier.Operation.ADD_NUMBER)
            );

            // 💥 攻击力 +618%（乘法）
            UUID atk2Id = UUID.nameUUIDFromBytes((namespace + "_atk_mult").getBytes());
            meta.addAttributeModifier(
                    Attribute.GENERIC_ATTACK_DAMAGE,
                    new AttributeModifier(atk2Id, "StarShards_Atk_Mult", 6.18, AttributeModifier.Operation.MULTIPLY_SCALAR_1)
            );

            // ⚡ 攻击速度 +2000% → 最终速度 = 原速 × (1 + 20.0) = 21倍！
            UUID atkSpeedId = UUID.nameUUIDFromBytes((namespace + "_atk_speed").getBytes());
            meta.addAttributeModifier(
                    Attribute.GENERIC_ATTACK_SPEED,
                    new AttributeModifier(atkSpeedId, "StarShards_AtkSpeed", 20.0, AttributeModifier.Operation.MULTIPLY_SCALAR_1)
            );

            // ❤️ 生命值 +1314（固定值，单位是“半心”，所以 +1314 = +657 颗心！）
            UUID health1Id = UUID.nameUUIDFromBytes((namespace + "_health_add").getBytes());
            meta.addAttributeModifier(
                    Attribute.GENERIC_MAX_HEALTH,
                    new AttributeModifier(health1Id, "StarShards_Health_Add", 1314.0, AttributeModifier.Operation.ADD_NUMBER)
            );

            // ❤️ 生命值 +618%（乘法）
            UUID health2Id = UUID.nameUUIDFromBytes((namespace + "_health_mult").getBytes());
            meta.addAttributeModifier(
                    Attribute.GENERIC_MAX_HEALTH,
                    new AttributeModifier(health2Id, "StarShards_Health_Mult", 6.18, AttributeModifier.Operation.MULTIPLY_SCALAR_1)
            );

            // 🏃 移动速度 +1314% → 最终速度 = 原速 × (1 + 13.14) = 14.14倍！
            UUID moveSpeedId = UUID.nameUUIDFromBytes((namespace + "_move_speed").getBytes());
            meta.addAttributeModifier(
                    Attribute.GENERIC_MOVEMENT_SPEED,
                    new AttributeModifier(moveSpeedId, "StarShards_MoveSpeed", 13.14, AttributeModifier.Operation.MULTIPLY_SCALAR_1)
            );

            // 🛡️ 护甲值 +200（固定值）
            UUID armorId = UUID.nameUUIDFromBytes((namespace + "_armor").getBytes());
            meta.addAttributeModifier(
                    Attribute.GENERIC_ARMOR,
                    new AttributeModifier(armorId, "StarShards_Armor", 200.0, AttributeModifier.Operation.ADD_NUMBER)
            );

            // 🧱 护甲韧性 +200（固定值）
            UUID toughnessId = UUID.nameUUIDFromBytes((namespace + "_toughness").getBytes());
            meta.addAttributeModifier(
                    Attribute.GENERIC_ARMOR_TOUGHNESS,
                    new AttributeModifier(toughnessId, "StarShards_Toughness", 200.0, AttributeModifier.Operation.ADD_NUMBER)
            );

            // ✈️ 飞行速度 +1314%
            UUID flySpeedId = UUID.nameUUIDFromBytes((namespace + "_fly_speed").getBytes());
            meta.addAttributeModifier(
                    Attribute.GENERIC_FLYING_SPEED,
                    new AttributeModifier(flySpeedId, "StarShards_FlySpeed", 13.14, AttributeModifier.Operation.MULTIPLY_SCALAR_1)
            );


            getItem().setItemMeta(meta);
        }
        Bukkit.getPluginManager().registerEvents(this, MagicExpansion.getInstance());
    }

    @Override
    public @NotNull ItemUseHandler getItemHandler() {
        return e -> {
            e.setUseItem(Event.Result.DENY);
            e.setUseBlock(Event.Result.DENY);

            if (e.getHand() != EquipmentSlot.HAND) return;

            Player player = e.getPlayer();
            boolean isSneaking = player.isSneaking();
            Action action = e.getInteractEvent().getAction();

            if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
                if (isSneaking) {
                    useInstantBlink(player);
                } else {
                    useAstralShield(player);
                }
            }
        };
    }

    // ✅ 攻击事件监听（SF9 唯一方式）
    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player player)) return;
        if (!(event.getEntity() instanceof LivingEntity)) return;

        // 判断玩家主手是否持有本 Slimefun 物品
        ItemStack hand = player.getInventory().getItemInMainHand();
        SlimefunItem handSfItem = getByItem(hand);
        if (!(handSfItem instanceof StarShardsSword)) return;
        // 应用伤害倍率
        event.setDamage(event.getDamage() * DAMAGE_MULTIPLIER);

        // 触发技能
        if (player.isSneaking()) {
            castArcaneBlast(player, event.getEntity().getLocation());
        } else {
            castBlazingSlash(player, event.getEntity().getLocation());
        }
    }

    // ========== 冷却与技能方法（保持不变）==========
    private boolean checkCooldown(Player player, String skill, long seconds) {
        UUID id = player.getUniqueId();
        long now = System.currentTimeMillis();
        cooldowns.putIfAbsent(id, new HashMap<>());
        Map<String, Long> map = cooldowns.get(id);

        if (map.containsKey(skill)) {
            long last = map.get(skill);
            if (now < last + seconds * 1000L) {
                // 防止刷屏：500ms 内不再提示
                Long lastMsg = lastMessageTime.getOrDefault(id, 0L);
                if (now - lastMsg > 500) {
                    long remain = ((last + seconds * 1000L - now) + 999) / 1000;
                    player.sendMessage("§c技能冷卻中，還需 " + remain + " 秒");
                    lastMessageTime.put(id, now);
                }
                return false;
            }
        }
        map.put(skill, now);
        return true;
    }

    private void castBlazingSlash(Player player, Location hitLoc) {
        if (!checkCooldown(player, "blazing_slash", 1)) return;

        player.getWorld().playSound(hitLoc, Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.3f);

        player.getWorld().spawnParticle(Particle.FLAME, hitLoc, 30, 0.5, 0.5, 0.5, 0.1);
        player.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, hitLoc, 8, 0.1, 0.1, 0.1, 0);

        hitLoc.getWorld().createExplosion(hitLoc, 0.3f, false, false);

        for (Entity e : hitLoc.getWorld().getNearbyEntities(hitLoc, 2.8, 2.8, 2.8)) {
            if (e instanceof LivingEntity le && e != player && e.isValid()) {
                // 🔥 点燃
                le.setFireTicks(80);

                // 🧨 安全计算击退方向
                Location entityLoc = e.getLocation();
                Vector toEntity = entityLoc.toVector().subtract(hitLoc.toVector());
                double distance = toEntity.length();

                // 如果距离太近（< 0.1），就用一个随机水平方向代替，避免 NaN
                if (distance < 0.1) {
                    // 随机水平方向（XZ 平面）
                    double angle = Math.random() * 2 * Math.PI;
                    toEntity = new Vector(Math.cos(angle), 0, Math.sin(angle));
                } else {
                    toEntity.normalize();
                }

                // 应用击退：水平方向 + 固定向上
                toEntity.multiply(0.9).setY(0.5);
                le.setVelocity(toEntity); // ✅ 现在安全了！
            }
        }
    }

    private void castArcaneBlast(Player player, Location origin) {
        if (!checkCooldown(player, "arcane_blast", 3)) return;

        Vector playerForward = player.getEyeLocation().getDirection().normalize();
        Location playerOrigin = player.getEyeLocation();

        double coneAngleCos = Math.cos(Math.toRadians(25)); // ±25度锥形
        List<LivingEntity> targets = new ArrayList<>();

        for (LivingEntity entity : player.getWorld().getNearbyLivingEntities(playerOrigin, 8.0)) {
            if (entity == player || !entity.isValid()) continue;

            Vector toEntity = entity.getLocation().toVector().subtract(playerOrigin.toVector());
            double distance = toEntity.length();

            if (distance == 0) continue;

            toEntity.normalize();
            double dot = playerForward.dot(toEntity); // 夹角余弦值

            // 如果在锥形内（角度 ≤ 25°）
            if (dot >= coneAngleCos) {
                targets.add(entity);
            }
        }

        // 🎵 音效：魔法释放 + 冲击波
        player.getWorld().playSound(origin, Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1.0f, 0.7f);
        Bukkit.getScheduler().runTaskLater(getAddon().getJavaPlugin(), () -> {
            player.getWorld().playSound(origin, Sound.BLOCK_BEACON_ACTIVATE, 1.0f, 1.8f);
        }, 2L);

        // ✨ 粒子：沿方向发射光束 + 命中闪光
        for (int i = 1; i <= 20; i++) {
            Location p = origin.clone().add(playerForward.clone().multiply(i * 0.4));
            player.getWorld().spawnParticle(Particle.END_ROD, p, 1, 0.05, 0.05, 0.05, 0);
            player.getWorld().spawnParticle(Particle.SPELL_WITCH, p, 1, 0.05, 0.05, 0.05, 0);
        }

        // 💥 对每个目标：伤害 + 击退 + 弱化 + 缓慢
        for (LivingEntity target : targets) {
            // 造成魔法伤害（可调整）
            target.damage(10.0, player);

            // 击退（沿光束方向）
            Vector knockback = playerForward.clone().multiply(1.1).setY(0.3);
            target.setVelocity(knockback);

            // 状态效果
            target.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 80, 0)); // 4秒
            target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 1));     // 4秒

            // 命中闪光
            target.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, target.getLocation(), 5, 0.1, 0.1, 0.1, 0);
            target.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, target.getLocation(), 10, 0.2, 0.2, 0.2, 0.05);
        }

        if (targets.isEmpty()) {
            // 即使没打中也播放尾音
            player.sendMessage("§7奧爆衝擊釋放，但未命中目標。");
        }
    }

    private void useAstralShield(Player player) {
        if (!checkCooldown(player, "astral_shield", 5)) return;
        player.sendMessage("§b✨ 星界護盾已激活！");
        player.getWorld().playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1.0f, 1.5f);
        player.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, player.getLocation().add(0, 1, 0), 30, 0.5, 0.5, 0.5, 0.1);
        player.setInvulnerable(true);
        Bukkit.getScheduler().runTaskLater(getAddon().getJavaPlugin(), () -> {
            if (player.isOnline()) player.setInvulnerable(false);
        }, 40);
    }

    private void useInstantBlink(Player player) {
        if (!checkCooldown(player, "instant_blink", 5)) return;
        Location eye = player.getEyeLocation();
        Vector dir = eye.getDirection();
        Location target = null;
        for (double d = 1.0; d <= 15; d += 0.5) {
            Location point = eye.clone().add(dir.clone().multiply(d));
            if (point.getBlock().getType().isSolid()) {
                target = point.add(0, 1, 0);
                break;
            }
        }
        if (target == null) {
            player.sendMessage("§c前方無障礙物，無法傳送！");
            return;
        }
        player.teleport(target);
        player.getWorld().playSound(target, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
        player.getWorld().spawnParticle(Particle.PORTAL, target, 50, 0.5, 0.5, 0.5, 0.1);
        for (Entity e : target.getWorld().getNearbyEntities(target, 1.5, 1.5, 1.5)) {
            if (e instanceof LivingEntity le && e != player) {
                le.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20, 0));
            }
        }
    }

    @Override
    public @NotNull List<ItemStack> getDisplayRecipes() {
        return List.of();
    }
}