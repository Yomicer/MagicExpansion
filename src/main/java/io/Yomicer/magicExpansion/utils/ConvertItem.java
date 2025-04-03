package io.Yomicer.magicExpansion.utils;

import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.inventory.ItemStack;

public class ConvertItem {
    public static ItemStack BasicCreateItem(String selectedItem) {
        // 根据 ID 获取 Slimefun 物品
        SlimefunItem slimefunItem = SlimefunItem.getById(selectedItem);

        // 检查是否成功获取到 Slimefun 物品
        if (slimefunItem == null) {
            System.out.println("无法找到 ID 为 " + selectedItem + " 的 Slimefun 物品！");
            return MagicExpansionItems.MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC; // 返回一个初级
        }

        // 获取物品并创建 ItemStack
        ItemStack itemStack = new ItemStack(slimefunItem.getItem());

        return itemStack;
    }


    public static ItemStack AdvancedCreateItem(String selectedItem) {
        // 根据 ID 获取 Slimefun 物品
        SlimefunItem slimefunItem = SlimefunItem.getById(selectedItem);

        // 检查是否成功获取到 Slimefun 物品
        if (slimefunItem == null) {
            System.out.println("无法找到 ID 为 " + selectedItem + " 的 Slimefun 物品！");
            return MagicExpansionItems.MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED; // 返回一个进阶
        }

        // 获取物品并创建 ItemStack
        ItemStack itemStack = new ItemStack(slimefunItem.getItem());

        return itemStack;
    }


}
