package io.Yomicer.magicExpansion;

import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.Yomicer.magicExpansion.items.electric.recipeMachine.RecipeMachinePreBuilding;
import io.Yomicer.magicExpansion.items.electric.templateMachine.TemplateMachine;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

import static io.Yomicer.magicExpansion.MagicExpansionItemSetup.magicexpansionenergy;
import static io.Yomicer.magicExpansion.MagicExpansionItemSetup.magicexpansionrecipemachine;
import static io.Yomicer.magicExpansion.utils.ConvertItem.AdvancedCreateItem;
import static io.Yomicer.magicExpansion.utils.itemUtils.sfItemUtils.sfItemAmount;

public class MagicExpansionRecipeMachineSetup {


    public static void setup(@Nonnull MagicExpansion plugin) {


        //魔法材料工坊
        new RecipeMachinePreBuilding(magicexpansionenergy, MagicExpansionItems.PRE_BUILDINGS_MACHINE_RESOURCE_ADVANCED, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.ELECTRIC_PRESS_2, SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.ELECTRIC_PRESS_2,
                AdvancedCreateItem("MAGIC_COSMIC_DUST"),MagicExpansionItems.PRE_BUILDINGS_MACHINE,MagicExpansionItems.ELEMENT_INGOT,
                SlimefunItems.CARBON_PRESS_3,SlimefunItems.PROGRAMMABLE_ANDROID_3,SlimefunItems.CARBON_PRESS_3
        })
                .setCapacity(131452)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.COBBLESTONE,64)}, new ItemStack[] {MagicExpansionItems.COBBLESTONE_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.COBBLESTONE_1}, new ItemStack[] {new ItemStack(Material.COBBLESTONE,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.COBBLESTONE_1,64)}, new ItemStack[] {MagicExpansionItems.COBBLESTONE_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.COBBLESTONE_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.COBBLESTONE_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.STONE,64)}, new ItemStack[] {MagicExpansionItems.STONE_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.STONE_1}, new ItemStack[] {new ItemStack(Material.STONE,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.STONE_1,64)}, new ItemStack[] {MagicExpansionItems.STONE_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.STONE_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.STONE_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.OAK_LOG,64)}, new ItemStack[] {MagicExpansionItems.OAK_LOG_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.OAK_LOG_1}, new ItemStack[] {new ItemStack(Material.OAK_LOG,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.OAK_LOG_1,64)}, new ItemStack[] {MagicExpansionItems.OAK_LOG_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.OAK_LOG_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.OAK_LOG_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.STONE_BRICKS,64)}, new ItemStack[] {MagicExpansionItems.STONE_BRICKS_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.STONE_BRICKS_1}, new ItemStack[] {new ItemStack(Material.STONE_BRICKS,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,64)}, new ItemStack[] {MagicExpansionItems.STONE_BRICKS_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.STONE_BRICKS_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.BRICKS,64)}, new ItemStack[] {MagicExpansionItems.BRICKS_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.BRICKS_1}, new ItemStack[] {new ItemStack(Material.BRICKS,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.BRICKS_1,64)}, new ItemStack[] {MagicExpansionItems.BRICKS_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.BRICKS_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.BRICKS_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.REDSTONE,64)}, new ItemStack[] {MagicExpansionItems.REDSTONE_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.REDSTONE_1}, new ItemStack[] {new ItemStack(Material.REDSTONE,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.REDSTONE_1,64)}, new ItemStack[] {MagicExpansionItems.REDSTONE_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.REDSTONE_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.REDSTONE_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.REDSTONE_TORCH,64)}, new ItemStack[] {MagicExpansionItems.REDSTONE_TORCH_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.REDSTONE_TORCH_1}, new ItemStack[] {new ItemStack(Material.REDSTONE_TORCH,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.REDSTONE_TORCH_1,64)}, new ItemStack[] {MagicExpansionItems.REDSTONE_TORCH_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.REDSTONE_TORCH_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.REDSTONE_TORCH_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.REPEATER,64)}, new ItemStack[] {MagicExpansionItems.REPEATER_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.REPEATER_1}, new ItemStack[] {new ItemStack(Material.REPEATER,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.REPEATER_1,64)}, new ItemStack[] {MagicExpansionItems.REPEATER_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.REPEATER_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.REPEATER_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.COMPARATOR,64)}, new ItemStack[] {MagicExpansionItems.COMPARATOR_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.COMPARATOR_1}, new ItemStack[] {new ItemStack(Material.COMPARATOR,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.COMPARATOR_1,64)}, new ItemStack[] {MagicExpansionItems.COMPARATOR_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.COMPARATOR_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.COMPARATOR_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.HOPPER,64)}, new ItemStack[] {MagicExpansionItems.HOPPER_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.HOPPER_1}, new ItemStack[] {new ItemStack(Material.HOPPER,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.HOPPER_1,64)}, new ItemStack[] {MagicExpansionItems.HOPPER_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.HOPPER_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.HOPPER_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.STRING,64)}, new ItemStack[] {MagicExpansionItems.STRING_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.STRING_1}, new ItemStack[] {new ItemStack(Material.STRING,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.STRING_1,64)}, new ItemStack[] {MagicExpansionItems.STRING_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.STRING_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.STRING_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.TRIPWIRE_HOOK,64)}, new ItemStack[] {MagicExpansionItems.TRIPWIRE_HOOK_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.TRIPWIRE_HOOK_1}, new ItemStack[] {new ItemStack(Material.TRIPWIRE_HOOK,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.TRIPWIRE_HOOK_1,64)}, new ItemStack[] {MagicExpansionItems.TRIPWIRE_HOOK_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.TRIPWIRE_HOOK_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.TRIPWIRE_HOOK_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.FURNACE,64)}, new ItemStack[] {MagicExpansionItems.FURNACE_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.FURNACE_1}, new ItemStack[] {new ItemStack(Material.FURNACE,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.FURNACE_1,64)}, new ItemStack[] {MagicExpansionItems.FURNACE_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.FURNACE_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.FURNACE_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.IRON_INGOT,64)}, new ItemStack[] {MagicExpansionItems.IRON_INGOT_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.IRON_INGOT_1}, new ItemStack[] {new ItemStack(Material.IRON_INGOT,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.IRON_INGOT_1,64)}, new ItemStack[] {MagicExpansionItems.IRON_INGOT_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.IRON_INGOT_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.IRON_INGOT_1,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.IRON_INGOT_2,64)}, new ItemStack[] {MagicExpansionItems.IRON_INGOT_3})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.IRON_INGOT_3}, new ItemStack[] {sfItemAmount(MagicExpansionItems.IRON_INGOT_2,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.LIGHT,64)}, new ItemStack[] {MagicExpansionItems.LIGHT_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.LIGHT_1}, new ItemStack[] {new ItemStack(Material.LIGHT,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.LIGHT_1,64)}, new ItemStack[] {MagicExpansionItems.LIGHT_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.LIGHT_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.LIGHT_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64)}, new ItemStack[] {MagicExpansionItems.QUARTZ_BLOCK_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.QUARTZ_BLOCK_1}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.QUARTZ_BLOCK_1,64)}, new ItemStack[] {MagicExpansionItems.QUARTZ_BLOCK_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.QUARTZ_BLOCK_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.QUARTZ_BLOCK_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.WHITE_WOOL,64),new ItemStack(Material.WHITE_DYE,64),
                        new ItemStack(Material.RED_DYE,64),new ItemStack(Material.YELLOW_DYE,64),new ItemStack(Material.BLUE_DYE,64)},
                        new ItemStack[] {MagicExpansionItems.COLOR_WOOL_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.COLOR_WOOL_1}, new ItemStack[] {new ItemStack(Material.WHITE_WOOL,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,64)}, new ItemStack[] {MagicExpansionItems.COLOR_WOOL_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.COLOR_WOOL_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.WHITE_TERRACOTTA,64),new ItemStack(Material.WHITE_DYE,64),
                                new ItemStack(Material.RED_DYE,64),new ItemStack(Material.YELLOW_DYE,64),new ItemStack(Material.BLUE_DYE,64)},
                        new ItemStack[] {MagicExpansionItems.COLOR_TERRACOTTA_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.COLOR_TERRACOTTA_1}, new ItemStack[] {new ItemStack(Material.WHITE_TERRACOTTA,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,64)}, new ItemStack[] {MagicExpansionItems.COLOR_TERRACOTTA_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.COLOR_TERRACOTTA_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.WHITE_CONCRETE,64),new ItemStack(Material.WHITE_DYE,64),
                                new ItemStack(Material.RED_DYE,64),new ItemStack(Material.YELLOW_DYE,64),new ItemStack(Material.BLUE_DYE,64)},
                        new ItemStack[] {MagicExpansionItems.COLOR_CONCRETE_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.COLOR_CONCRETE_1}, new ItemStack[] {new ItemStack(Material.WHITE_CONCRETE,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,64)}, new ItemStack[] {MagicExpansionItems.COLOR_CONCRETE_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.COLOR_CONCRETE_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,64)})
                .addRecipe(2, new ItemStack[] {new ItemStack(Material.WHITE_GLAZED_TERRACOTTA,64),new ItemStack(Material.WHITE_DYE,64),
                                new ItemStack(Material.RED_DYE,64),new ItemStack(Material.YELLOW_DYE,64),new ItemStack(Material.BLUE_DYE,64)},
                        new ItemStack[] {MagicExpansionItems.COLOR_GLAZED_TERRACOTTA_1})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.COLOR_GLAZED_TERRACOTTA_1}, new ItemStack[] {new ItemStack(Material.WHITE_GLAZED_TERRACOTTA,64)})
                .addRecipe(2, new ItemStack[] {sfItemAmount(MagicExpansionItems.COLOR_GLAZED_TERRACOTTA_1,64)}, new ItemStack[] {MagicExpansionItems.COLOR_GLAZED_TERRACOTTA_2})
                .addRecipe(2, new ItemStack[] {MagicExpansionItems.COLOR_GLAZED_TERRACOTTA_2}, new ItemStack[] {sfItemAmount(MagicExpansionItems.COLOR_GLAZED_TERRACOTTA_1,64)})
                .register(plugin);

        //终极魔法建筑工坊
        new RecipeMachinePreBuilding(magicexpansionenergy, MagicExpansionItems.PRE_BUILDINGS_MACHINE_ADVANCED, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.BRICKS_2, SlimefunItems.ENERGIZED_CAPACITOR,MagicExpansionItems.STONE_BRICKS_2,
                MagicExpansionItems.REDSTONE_TORCH_1,MagicExpansionItems.PRE_BUILDINGS_MACHINE_RESOURCE_ADVANCED,MagicExpansionItems.REPEATER_1,
                MagicExpansionItems.COMPARATOR_1,MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.HOPPER_1
        })
                .setCapacity(131452)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .addRecipe(20,new ItemStack[] {MagicExpansionItems.STONE_2,MagicExpansionItems.IRON_INGOT_2,sfItemAmount(MagicExpansionItems.OAK_LOG_1,16),
                        sfItemAmount(MagicExpansionItems.REDSTONE_1,5),MagicExpansionItems.GLASS_1,MagicExpansionItems.COLOR_WOOL_1,
                                MagicExpansionItems.SPACE_INFINITY_MAGIC},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_VILLAGE_LOVE_AND_TRADE_HOUSE})
                .addRecipe(20,new ItemStack[] { MagicExpansionItems.STONE_2,MagicExpansionItems.IRON_INGOT_1,sfItemAmount(MagicExpansionItems.OAK_LOG_1,16),
                        MagicExpansionItems.REDSTONE_1,MagicExpansionItems.COBBLESTONE_1,MagicExpansionItems.HOPPER_1,
                        new ItemStack(Material.STRING,15),MagicExpansionItems.SPACE_INFINITY_MAGIC},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_SHULKER_FARM})
                .register(plugin);

        //泥土园
        new TemplateMachine(magicexpansionrecipemachine, MagicExpansionItems.DIRT_MEAL_MACHINE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.DIRT, MagicExpansionItems.CORE_ORIGIN,MagicExpansionItems.DIRT,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.JIN_KE_LA,MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.ELEMENT_INGOT
        })
                .setCapacity(1314)
                .setConsumption(26)
                .setProcessingSpeed(1)
                .addRecipe(3,new ItemStack[] {new ItemStack(Material.GRASS_BLOCK),
                                new ItemStack(Material.DIRT,16),new ItemStack(Material.BONE_MEAL,16)},
                        new ItemStack[] {new ItemStack(Material.GRASS_BLOCK,16)})
                .addRecipe(0,new ItemStack[] {new ItemStack(Material.GRASS_BLOCK),
                                new ItemStack(Material.DIRT,64),MagicExpansionItems.JIN_KE_LA},
                        new ItemStack[] {new ItemStack(Material.GRASS_BLOCK,64)})
                .addRecipe(3,new ItemStack[] {new ItemStack(Material.PODZOL),
                                new ItemStack(Material.DIRT,16),new ItemStack(Material.BONE_MEAL,16)},
                        new ItemStack[] {new ItemStack(Material.PODZOL,16)})
                .addRecipe(0,new ItemStack[] {new ItemStack(Material.PODZOL),
                                new ItemStack(Material.DIRT,64),MagicExpansionItems.JIN_KE_LA},
                        new ItemStack[] {new ItemStack(Material.PODZOL,64)})
                .addRecipe(3,new ItemStack[] {new ItemStack(Material.MYCELIUM),
                                new ItemStack(Material.DIRT,16),new ItemStack(Material.BONE_MEAL,16)},
                        new ItemStack[] {new ItemStack(Material.MYCELIUM,16)})
                .addRecipe(0,new ItemStack[] {new ItemStack(Material.MYCELIUM),
                                new ItemStack(Material.DIRT,64),MagicExpansionItems.JIN_KE_LA},
                        new ItemStack[] {new ItemStack(Material.MYCELIUM,64)})
                .addRecipe(3,new ItemStack[] {new ItemStack(Material.DIRT_PATH),
                                new ItemStack(Material.DIRT,16),new ItemStack(Material.BONE_MEAL,16)},
                        new ItemStack[] {new ItemStack(Material.DIRT_PATH,16)})
                .addRecipe(0,new ItemStack[] {new ItemStack(Material.DIRT_PATH),
                                new ItemStack(Material.DIRT,64),MagicExpansionItems.JIN_KE_LA},
                        new ItemStack[] {new ItemStack(Material.DIRT_PATH,64)})
                .addRecipe(3,new ItemStack[] {new ItemStack(Material.COARSE_DIRT),
                                new ItemStack(Material.DIRT,16),new ItemStack(Material.BONE_MEAL,16)},
                        new ItemStack[] {new ItemStack(Material.COARSE_DIRT,16)})
                .addRecipe(0,new ItemStack[] {new ItemStack(Material.COARSE_DIRT),
                                new ItemStack(Material.DIRT,64),MagicExpansionItems.JIN_KE_LA},
                        new ItemStack[] {new ItemStack(Material.COARSE_DIRT,64)})
                .addRecipe(3,new ItemStack[] {new ItemStack(Material.ROOTED_DIRT),
                                new ItemStack(Material.DIRT,16),new ItemStack(Material.BONE_MEAL,16)},
                        new ItemStack[] {new ItemStack(Material.ROOTED_DIRT,16)})
                .addRecipe(0,new ItemStack[] {new ItemStack(Material.ROOTED_DIRT),
                                new ItemStack(Material.DIRT,64),MagicExpansionItems.JIN_KE_LA},
                        new ItemStack[] {new ItemStack(Material.ROOTED_DIRT,64)})
                .addRecipe(3,new ItemStack[] {new ItemStack(Material.FARMLAND),
                                new ItemStack(Material.DIRT,16),new ItemStack(Material.BONE_MEAL,16)},
                        new ItemStack[] {new ItemStack(Material.FARMLAND,16)})
                .addRecipe(0,new ItemStack[] {new ItemStack(Material.FARMLAND),
                                new ItemStack(Material.DIRT,64),MagicExpansionItems.JIN_KE_LA},
                        new ItemStack[] {new ItemStack(Material.FARMLAND,64)})
                .addRecipe(3,new ItemStack[] {new ItemStack(Material.CLAY),
                                new ItemStack(Material.DIRT,16),new ItemStack(Material.BONE_MEAL,16)},
                        new ItemStack[] {new ItemStack(Material.CLAY,16)})
                .addRecipe(0,new ItemStack[] {new ItemStack(Material.CLAY),
                                new ItemStack(Material.DIRT,64),MagicExpansionItems.JIN_KE_LA},
                        new ItemStack[] {new ItemStack(Material.CLAY,64)})
                .addRecipe(3,new ItemStack[] {new ItemStack(Material.WHITE_CONCRETE),
                                new ItemStack(Material.DIRT,16),new ItemStack(Material.BONE_MEAL,16)},
                        new ItemStack[] {new ItemStack(Material.WHITE_CONCRETE,16)})
                .addRecipe(0,new ItemStack[] {new ItemStack(Material.WHITE_CONCRETE),
                                new ItemStack(Material.DIRT,64),MagicExpansionItems.JIN_KE_LA},
                        new ItemStack[] {new ItemStack(Material.WHITE_CONCRETE,64)})
                .addRecipe(3,new ItemStack[] {new ItemStack(Material.CRIMSON_NYLIUM),
                                new ItemStack(Material.NETHERRACK,16),new ItemStack(Material.BONE_MEAL,16)},
                        new ItemStack[] {new ItemStack(Material.CRIMSON_NYLIUM,16)})
                .addRecipe(0,new ItemStack[] {new ItemStack(Material.CRIMSON_NYLIUM),
                                new ItemStack(Material.NETHERRACK,64),MagicExpansionItems.JIN_KE_LA},
                        new ItemStack[] {new ItemStack(Material.CRIMSON_NYLIUM,64)})
                .addRecipe(3,new ItemStack[] {new ItemStack(Material.WARPED_NYLIUM),
                                new ItemStack(Material.NETHERRACK,16),new ItemStack(Material.BONE_MEAL,16)},
                        new ItemStack[] {new ItemStack(Material.WARPED_NYLIUM,16)})
                .addRecipe(0,new ItemStack[] {new ItemStack(Material.WARPED_NYLIUM),
                                new ItemStack(Material.NETHERRACK,64),MagicExpansionItems.JIN_KE_LA},
                        new ItemStack[] {new ItemStack(Material.WARPED_NYLIUM,64)})
                .addRecipe(3,new ItemStack[] {new ItemStack(Material.SOUL_SOIL),
                                new ItemStack(Material.NETHERRACK,16),new ItemStack(Material.BONE_MEAL,16)},
                        new ItemStack[] {new ItemStack(Material.SOUL_SOIL,16)})
                .addRecipe(0,new ItemStack[] {new ItemStack(Material.SOUL_SOIL),
                                new ItemStack(Material.NETHERRACK,64),MagicExpansionItems.JIN_KE_LA},
                        new ItemStack[] {new ItemStack(Material.SOUL_SOIL,64)})
                .register(plugin);


        //泥土园
        new TemplateMachine(magicexpansionrecipemachine, MagicExpansionItems.FISHING_MACHINE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.PROGRAMMABLE_ANDROID_FISHERMAN, MagicExpansionItems.CORE_ORIGIN,SlimefunItems.PROGRAMMABLE_ANDROID_FISHERMAN,
                MagicExpansionItems.ELEMENT_INGOT,new ItemStack(Material.COD),MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.ELEMENT_INGOT
        })
                .setCapacity(1314)
                .setConsumption(26)
                .setProcessingSpeed(1)
                .addRecipe(16,new ItemStack[] {new ItemStack(Material.FISHING_ROD),
                                new ItemStack(Material.APPLE,1)},
                        new ItemStack[] {new ItemStack(Material.COD,16)})
                .addRecipe(16,new ItemStack[] {new ItemStack(Material.FISHING_ROD),
                                new ItemStack(Material.CARROT,1)},
                        new ItemStack[] {new ItemStack(Material.SALMON,16)})
                .addRecipe(16,new ItemStack[] {new ItemStack(Material.FISHING_ROD),
                                new ItemStack(Material.SWEET_BERRIES,1)},
                        new ItemStack[] {new ItemStack(Material.TROPICAL_FISH,16)})
                .addRecipe(16,new ItemStack[] {new ItemStack(Material.FISHING_ROD),
                                new ItemStack(Material.SPIDER_EYE,1)},
                        new ItemStack[] {new ItemStack(Material.PUFFERFISH,16)})
                .addRecipe(8,new ItemStack[] {new ItemStack(Material.FISHING_ROD),
                                MagicExpansionItems.JIN_KE_LA},
                        new ItemStack[] {new ItemStack(Material.COD,8),new ItemStack(Material.SALMON,6),
                                new ItemStack(Material.TROPICAL_FISH,4),new ItemStack(Material.PUFFERFISH,2),
                                new ItemStack(Material.INK_SAC,1),new ItemStack(Material.GLOW_INK_SAC,1),
                                new ItemStack(Material.BONE,1),new ItemStack(Material.ENCHANTED_BOOK,1),
                                new ItemStack(Material.SPIDER_EYE,1),new ItemStack(Material.BLAZE_ROD,1)})
                .register(plugin);




    }


}
