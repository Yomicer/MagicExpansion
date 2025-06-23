package io.Yomicer.magicExpansion;

import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.Yomicer.magicExpansion.items.generators.TypeEnergyGenerator;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

import static io.Yomicer.magicExpansion.MagicExpansionItemSetup.magicexpansionpower;
import static io.Yomicer.magicExpansion.utils.itemUtils.sfItemUtils.sfItemAmount;

public class MagicExpansionPowerMachineSetup {



    public static void setup(@Nonnull MagicExpansion plugin) {


        new TypeEnergyGenerator(magicexpansionpower, MagicExpansionItems.POWER_FIRE_UNSTABLE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT, new ItemStack(Material.CAMPFIRE),MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.COAL,MagicExpansionItems.POWER_CORE,MagicExpansionItems.COAL,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.MAGNESIUM_INGOT,MagicExpansionItems.ELEMENT_INGOT
        }, Material.FIRE, BlockFace.DOWN, 131452,1 ,26000)
                .setPowerType("火力发电机")
                .register(plugin);



    }






}
