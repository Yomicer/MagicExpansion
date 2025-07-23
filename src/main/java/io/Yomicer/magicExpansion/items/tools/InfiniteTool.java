package io.Yomicer.magicExpansion.items.tools;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InfiniteTool extends SlimefunItem {



    public InfiniteTool(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }


    @Override
    public void preRegister() {
        ItemStack itemStack = getItem();
        ItemMeta meta = itemStack.getItemMeta();

        if (meta != null) {
            meta.setUnbreakable(true); // 设置为无法破坏
            itemStack.setItemMeta(meta);
        }
    }






}
