package io.Yomicer.magicExpansion.items.misc;

import org.bukkit.inventory.ItemStack;

public class WeightedItem {

    private final ItemStack item;
    private final int weight;

    public WeightedItem(ItemStack item, int weight) {
        this.item = item;
        this.weight = weight;
    }

    public ItemStack getItem() { return item; }
    public int getWeight() { return weight; }
}
