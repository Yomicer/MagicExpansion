package io.Yomicer.magicExpansion.Listener.magicItemEffectManager;

import io.Yomicer.magicExpansion.utils.GiveItem;
import io.Yomicer.magicExpansion.utils.entity.EntityEgg;
import io.Yomicer.magicExpansion.utils.log.Debug;
import net.guizhanss.guizhanlib.minecraft.helper.entity.EntityHelper;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Random;

import static io.Yomicer.magicExpansion.items.enchantMachine.EnchantingTable.ATTRIBUTE_POOL;

public class ItemEffectKillListener implements Listener {


    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        // 获取导致死亡的实体（即杀手）
        Entity killer = event.getEntity().getKiller();

        // 检查杀手是否是玩家
        if (killer instanceof Player) {
            Player player = (Player) killer;
            ItemStack item = player.getInventory().getItemInMainHand().clone();
            // 获取被击杀的实体
            LivingEntity entity = event.getEntity();
            // 获取物品的 PDC
            ItemMeta meta = item.getItemMeta();
            if (meta != null && meta.getPersistentDataContainer() != null) {
                PersistentDataContainer pdc = meta.getPersistentDataContainer();

                // 遍历所有属性
                for (String attribute : ATTRIBUTE_POOL.keySet()) {
                    NamespacedKey key = new NamespacedKey("magicexpansion", attribute.toLowerCase().replace(".", "_"));

                    if (pdc.has(key, PersistentDataType.INTEGER)) {
                        int value = pdc.get(key, PersistentDataType.INTEGER);
                        applyEffect(attribute, value, event.getEntity(), player, item);
                    } else if (pdc.has(key, PersistentDataType.BOOLEAN)) {
                        boolean value = pdc.get(key, PersistentDataType.BOOLEAN);
                        applyEffect(attribute, value, event.getEntity(), player, item);
                    }
                }
            }

        }
    }


    private void applyEffect(String attribute, Object value, Entity target, Player player, ItemStack item) {
        switch (attribute) {
            case "MagicExpansion.EntitySpawn": // 击退效果
                if (value instanceof Integer EntitySpawn) {

                    EntityType entityType = target.getType();

                    Material spawnEggMaterial = EntityEgg.hasSpawnEgg(entityType);

                    if (spawnEggMaterial != null) {

                        Random random = new Random();
                        double eggRandom = EntitySpawn * 0.05 * 0.01;
                        double randomValue = random.nextDouble(); // 生成一个 [0, 1) 的随机数

                        if(eggRandom>randomValue) {
                            // 创建刷怪蛋物品
                            ItemStack spawnEgg = new ItemStack(spawnEggMaterial);
                            // 打印信息到控制台或发送消息给玩家
                            player.sendMessage("§b在0.00001秒前，你击杀了 §d" + EntityHelper.getName(target));
                            player.sendMessage("§b你的武器 §e[" + item.getItemMeta().getDisplayName() + "§e] §b对 §d"+ EntityHelper.getName(target) +" §b进行了§c生命重构");
                            player.sendMessage("§b你获得了 §e" + EntityHelper.getName(target) + " §b生物蛋");

                            GiveItem.giveOrDropItem(player, spawnEgg);
                        }
                    }
                }
                break;


        }


    }


}