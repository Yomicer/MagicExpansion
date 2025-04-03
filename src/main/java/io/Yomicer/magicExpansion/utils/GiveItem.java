package io.Yomicer.magicExpansion.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Map;

public class GiveItem {
    public static void giveOrDropItem(Player player, ItemStack item) {
        PlayerInventory inventory = player.getInventory();
        Location location = player.getLocation();

        // 尝试将物品放入玩家背包
        Map<Integer, ItemStack> remainingItems = inventory.addItem(item);

        // 如果背包已满，掉落剩余的物品到地上
        if (!remainingItems.isEmpty()) {
            for (ItemStack remaining : remainingItems.values()) {
                player.getWorld().dropItemNaturally(location, remaining);
            }
        }
    }

}
