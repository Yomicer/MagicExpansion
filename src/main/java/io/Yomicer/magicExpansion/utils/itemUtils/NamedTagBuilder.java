package io.Yomicer.magicExpansion.utils.itemUtils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NamedTagBuilder {
    public static ItemStack nameTag(String name) {
        ItemStack item = new ItemStack(Material.NAME_TAG);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }
}
