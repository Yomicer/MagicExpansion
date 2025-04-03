package io.Yomicer.magicExpansion.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CreateItem {
    public static ItemStack createItem(Material material, String displayName) {
        ItemStack item = new ItemStack(material);

        //如果需要设置显示名称或其他元数据，可以使用 ItemMeta：
        var meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack createItem(Material material) {
        return createItem(material, null); // 调用原始方法，不命名
    }

}
