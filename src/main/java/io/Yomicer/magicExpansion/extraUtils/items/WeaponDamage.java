package io.Yomicer.magicExpansion.extraUtils.items;

import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WeaponDamage {

    /**
     * 根据伤害值获取对应的武器物品
     * @param p 玩家 (用于获取位置或世界，如果不需要可去掉)
     * @param damage 伤害值
     * @return 对应的武器 ItemStack
     */
    public static ItemStack getWeaponByDamage(Player p, double damage) {
        ItemStack resultItem;

        // 逻辑示例：根据 damage 大小决定返回什么物品
        if (damage > 100) {
            // 高伤害：使用预设的神器 (克隆以防修改原单例)
            if (MagicExpansionItems.FISHING_ROD_FINAL_HOOK != null) {
                resultItem = MagicExpansionItems.FISHING_ROD_FINAL_HOOK.clone();

                // 可选：修改物品名称显示伤害值
                ItemMeta meta = resultItem.getItemMeta();
                if (meta != null) {
                    meta.setDisplayName("§c终极鱼钩 (伤害: " + (int)damage + ")");
                    resultItem.setItemMeta(meta);
                }
            } else {
                resultItem = new ItemStack(Material.DIAMOND_SWORD);
            }
        } else {
            // 低伤害：返回普通钻石剑
            resultItem = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta meta = resultItem.getItemMeta();
            if (meta != null) {
                meta.setDisplayName("§7普通铁剑 (伤害: " + (int)damage + ")");
                resultItem.setItemMeta(meta);
            }
        }

        return resultItem;
    }

}
