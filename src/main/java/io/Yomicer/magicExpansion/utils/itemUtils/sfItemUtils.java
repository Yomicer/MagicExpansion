package io.Yomicer.magicExpansion.utils.itemUtils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public class sfItemUtils {

    public static ItemStack sfItemAmount(SlimefunItemStack slimefunItem, int amount) {

        return new SlimefunItemStack(slimefunItem,amount);
    }

}
