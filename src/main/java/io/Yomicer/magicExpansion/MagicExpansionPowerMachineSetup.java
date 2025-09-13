package io.Yomicer.magicExpansion;

import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.Yomicer.magicExpansion.items.generators.FishEnergyGenerator;
import io.Yomicer.magicExpansion.items.generators.FishOutputMachine;
import io.Yomicer.magicExpansion.items.generators.NumberEnergyGenerator;
import io.Yomicer.magicExpansion.items.generators.TypeEnergyGenerator;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

import static io.Yomicer.magicExpansion.MagicExpansionItemSetup.magicexpansionpower;
import static io.Yomicer.magicExpansion.MagicExpansionItemSetup.magicexpansionresourcegenerator;
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

        new TypeEnergyGenerator(magicexpansionpower, MagicExpansionItems.POWER_FIRE_STABILITY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.PURE_ELEMENT_FIRE, MagicExpansionItems.PURE_ELEMENT_FIRE,MagicExpansionItems.PURE_ELEMENT_FIRE,
                MagicExpansionItems.POWER_FIRE_UNSTABLE,MagicExpansionItems.POWER_FIRE_UNSTABLE,MagicExpansionItems.POWER_FIRE_UNSTABLE,
                MagicExpansionItems.PURE_ELEMENT_INGOT,MagicExpansionItems.SPEED_ELEMENT_64,MagicExpansionItems.PURE_ELEMENT_INGOT
        }, Material.FIRE, BlockFace.DOWN, 1314520,260 ,65726)
                .setPowerType("终极火力发电机")
                .register(plugin);

        new TypeEnergyGenerator(magicexpansionpower, MagicExpansionItems.POWER_COLOR_EGG_BLOCK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.GOLD_ELEMENT, MagicExpansionItems.WOOD_ELEMENT,MagicExpansionItems.WATER_ELEMENT,
                MagicExpansionItems.FIRE_ELEMENT,MagicExpansionItems.POWER_CORE,MagicExpansionItems.EARTH_ELEMENT,
                MagicExpansionItems.FIVE_ELEMENT,MagicExpansionItems.FIVE_ELEMENT,MagicExpansionItems.FIVE_ELEMENT
        }, Material.GLOWSTONE, BlockFace.UP, 1314520,1 ,2000000000)
                .setPowerType("方块·彩蛋发电机")
                .register(plugin);

        new NumberEnergyGenerator(magicexpansionpower, MagicExpansionItems.POWER_COLOR_EGG_KEY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.GOLD_ELEMENT, MagicExpansionItems.WOOD_ELEMENT,MagicExpansionItems.WATER_ELEMENT,
                MagicExpansionItems.FIRE_ELEMENT, SlimefunItems.ENERGIZED_CAPACITOR,MagicExpansionItems.EARTH_ELEMENT,
                MagicExpansionItems.FIVE_ELEMENT,MagicExpansionItems.FIVE_ELEMENT,MagicExpansionItems.FIVE_ELEMENT
        }, Material.SNOW,1314520,2600 ,65726,"110011111","111011011")
                .setPowerType("密钥·彩蛋发电机")
                .register(plugin);

        new FishEnergyGenerator(magicexpansionpower, MagicExpansionItems.POWER_FISH_ELECTRIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT, SlimefunItems.ADVANCED_CIRCUIT_BOARD,MagicExpansionItems.ELEMENT_INGOT,
                SlimefunItems.WITHER_PROOF_GLASS, new ItemStack(Material.WATER_BUCKET),SlimefunItems.WITHER_PROOF_GLASS,
                MagicExpansionItems.ELEMENT_INGOT,SlimefunItems.ELECTRIC_MOTOR,MagicExpansionItems.ELEMENT_INGOT
        },25000000)
                .setPowerType("生物发电机")
                .register(plugin);
        new FishOutputMachine(magicexpansionresourcegenerator, MagicExpansionItems.FISH_VIVARIUM, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT, MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.ELEMENT_INGOT,
                new ItemStack(Material.WATER_BUCKET), MagicExpansionItems.POWER_FISH_ELECTRIC,new ItemStack(Material.WATER_BUCKET),
                MagicExpansionItems.ELEMENT_INGOT,new ItemStack(Material.BUCKET),MagicExpansionItems.ELEMENT_INGOT
        },131452)
                .setPowerType("生态缸")
                .register(plugin);


    }






}
