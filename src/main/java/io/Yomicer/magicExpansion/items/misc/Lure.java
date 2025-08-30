package io.Yomicer.magicExpansion.items.misc;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public abstract class Lure {

    public abstract boolean hasLure(Player player);
    public abstract List<WeightedItem> getLootPool();
    public abstract String getKey(); // 新增
    public abstract ItemStack getItem();
}

