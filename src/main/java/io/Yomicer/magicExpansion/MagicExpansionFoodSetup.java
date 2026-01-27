package io.Yomicer.magicExpansion;

import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.Yomicer.magicExpansion.utils.ColorGradient;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

import static io.Yomicer.magicExpansion.MagicExpansionItemSetup.magicexpansionfood;
import static io.Yomicer.magicExpansion.MagicExpansionItemSetup.magicexpansionfoodresource;
import static io.Yomicer.magicExpansion.core.MagicExpansionItems.HARVEST_WHEAT;

public class MagicExpansionFoodSetup {


    public static void setup(@Nonnull MagicExpansion plugin) {


        // 下面是有关食物的
        //丰收面包
        new UnplaceableBlock(magicexpansionfood, MagicExpansionItems.FARM_HARVEST_BREAD, RecipeType.NULL, new ItemStack[] {
                HARVEST_WHEAT, HARVEST_WHEAT, HARVEST_WHEAT,
                null, null ,null,
                null, null,null
        }).register(plugin);
        //丰收小麦
        new UnplaceableBlock(magicexpansionfoodresource, MagicExpansionItems.HARVEST_WHEAT, RecipeType.NULL, new ItemStack[] {
                null, null ,null,
                null, new CustomItemStack(new ItemStack(Material.IRON_HOE), ColorGradient.getGradientNameVer2("通过收割成熟小麦有概率掉落"),
                ColorGradient.getGradientNameVer2("掉落概率为：61.88%"),
                ColorGradient.getGradientNameVer2("暂未开放掉落")), null,
                null, null,null
        }).register(plugin);



    }


}
