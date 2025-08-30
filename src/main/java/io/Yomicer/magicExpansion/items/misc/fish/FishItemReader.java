package io.Yomicer.magicExpansion.items.misc.fish;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class FishItemReader {

    public static boolean isFishItem(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer().has(FishKeys.FISH_TYPE, PersistentDataType.STRING);
    }

    public static Fish getFishType(ItemStack item) {
        if (!isFishItem(item)) return null;
        String typeName = item.getItemMeta().getPersistentDataContainer()
                .get(FishKeys.FISH_TYPE, PersistentDataType.STRING);
        return Fish.valueOf(typeName);
    }

    public static double getFishWeight(ItemStack item) {
        if (!isFishItem(item)) return 0.0;
        return item.getItemMeta().getPersistentDataContainer()
                .get(FishKeys.FISH_WEIGHT, PersistentDataType.DOUBLE);
    }

    public static Fish.WeightRarity getWeightRarity(ItemStack item) {
        if (!isFishItem(item)) return null;
        String wrName = item.getItemMeta().getPersistentDataContainer()
                .get(FishKeys.FISH_WEIGHT_RARITY, PersistentDataType.STRING);
        return Fish.WeightRarity.valueOf(wrName);
    }

}
