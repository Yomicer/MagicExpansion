package io.Yomicer.magicExpansion.utils;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.inventory.ItemStack;

/**
 * 水云间钓获品质判定
 * 只区分特殊钓物与普通钓物,不区分稀有度
 */
public class WaterCloudQuality {

    private WaterCloudQuality() {
    }

    public static boolean isSpecial(ItemStack drop, ItemStack specialCatch) {
        return drop != null && specialCatch != null && SlimefunUtils.isItemSimilar(drop, specialCatch, true);
    }
}
