package io.Yomicer.magicExpansion;

import io.Yomicer.magicExpansion.items.tools.MagicExpansionMineralCave;
import io.Yomicer.magicExpansion.items.tools.MagicExpansionQuickSmeltery;
import io.Yomicer.magicExpansion.items.tools.MagicExpansionRandomSummon;
import io.Yomicer.magicExpansion.items.tools.Scythe;
import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

import static io.Yomicer.magicExpansion.core.MagicExpansionItems.MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC;
import static io.Yomicer.magicExpansion.utils.ConvertItem.AdvancedCreateItem;
import static io.Yomicer.magicExpansion.utils.ConvertItem.BasicCreateItem;
import static io.Yomicer.magicExpansion.utils.Utils.doGlow;


public final class MagicExpansionItemSetup {


    // ItemGroups
    private static final NestedItemGroup magicexpansion = new NestedItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "magicexpansion"),
            new CustomItemStack(doGlow(Material.LIGHT),"§x§F§D§B§7§D§4§kll§x§F§D§B§7§D§4魔§x§F§A§7§E§B§3法§x§F§F§6§9§B§4拓§x§F§F§6§9§B§4展§x§F§D§B§7§D§4§kll"),0
    );

    private static final ItemGroup magicexpansioncontribution = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "specialitem"), magicexpansion,
            new CustomItemStack(doGlow(Material.COMMAND_BLOCK), "§x§F§D§B§7§D§4§kll§x§F§A§7§E§B§3贡§x§F§F§6§9§B§4献§x§F§F§6§9§B§4§kll"), 0
    );

    private static final ItemGroup magicexpansionspecialitem = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "specialitem"), magicexpansion,
            new CustomItemStack(doGlow(Material.SHEARS), "§x§F§D§B§7§D§4特§x§F§A§7§E§B§3殊§x§F§F§6§9§B§4道§x§F§F§6§9§B§4具"), 2
    );

    private static final ItemGroup magicexpansionquickmachine = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "quickmachine"), magicexpansion,
            new CustomItemStack(doGlow(Material.MAGENTA_GLAZED_TERRACOTTA), "§x§F§D§B§7§D§4快§x§F§A§7§E§B§3捷§x§F§F§6§9§B§4机§x§F§F§6§9§B§4器"), 3
    );

    private static final ItemGroup magicexpansionresource = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "magicexpansionresource"), magicexpansion,
            new CustomItemStack(doGlow(Material.TOTEM_OF_UNDYING), "§x§F§D§B§7§D§4补§x§F§A§7§E§B§3丁§x§F§F§6§9§B§4材§x§F§F§6§9§B§4料"), 1
    );

    // 定义一个新的配方类型
    public static final RecipeType SPECIAL_RECIPE_TYPE = new RecipeType(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "magicexpansion_special_recipe_type"),
            new CustomItemStack(Material.TOTEM_OF_UNDYING,"§x§F§D§B§7§D§4§l无§x§F§A§7§E§B§3§l法§x§F§F§6§9§B§4§l合§x§F§F§6§9§B§4§l成","§f§l痴情的人啊","§f§l请再等一世吧"), // 图标
            (input, output) -> {});

    private MagicExpansionItemSetup() {
    }


    public static void setup(@Nonnull MagicExpansionMachines plugin) {


        //magicsolo头颅
        new UnplaceableBlock(magicexpansioncontribution, MagicExpansionItems.MAGIC_EXPANSION_AUTHOR, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);

        //版本信息
        new UnplaceableBlock(magicexpansioncontribution, MagicExpansionItems.MAGIC_EXPANSION_INFO, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);

        //初级万能魔法合成材料
        new UnplaceableBlock(magicexpansionresource, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.RAINBOW_GLAZED_TERRACOTTA, SlimefunItems.ANCIENT_PEDESTAL, SlimefunItems.RAINBOW_CONCRETE,
                SlimefunItems.RAINBOW_GLASS_PANE, SlimefunItems.MAGIC_EYE_OF_ENDER, SlimefunItems.RAINBOW_GLASS,
                SlimefunItems.RAINBOW_CLAY, SlimefunItems.ANCIENT_ALTAR, SlimefunItems.RAINBOW_WOOL
        }).register(plugin);

        //进阶万能魔法合成材料
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC,
                MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC,
                MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC
        }).register(plugin);


        // Tools
        //镰刀
        new Scythe(magicexpansionspecialitem, MagicExpansionItems.SCYTHE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null, new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
                null, new ItemStack(Material.IRON_INGOT), null,
                null, new ItemStack(Material.STICK), null
        }).register(plugin);
        // 随机实体蛋
        new MagicExpansionRandomSummon(magicexpansionspecialitem, MagicExpansionItems.MAGIC_EXPANSION_RANDOM_SPAWNER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                BasicCreateItem("MAGIC_REDSTONE"), BasicCreateItem("MAGIC_REDSTONE"), BasicCreateItem("MAGIC_REDSTONE"),
                BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.EGG), BasicCreateItem("MAGIC_REDSTONE"),
                BasicCreateItem("MAGIC_REDSTONE"), BasicCreateItem("MAGIC_REDSTONE"), BasicCreateItem("MAGIC_REDSTONE")
        }).register(plugin);
        // 魔法刷石机
        new MagicExpansionMineralCave(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_MINERAL_CAVE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                BasicCreateItem("MAGIC_REDSTONE"), BasicCreateItem("MAGIC_REDSTONE"), BasicCreateItem("MAGIC_REDSTONE"),
                BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.SMOOTH_STONE), BasicCreateItem("MAGIC_REDSTONE"),
                BasicCreateItem("MAGIC_REDSTONE"), BasicCreateItem("MAGIC_REDSTONE"), BasicCreateItem("MAGIC_REDSTONE")
        }).register(plugin);
        // 快捷冶炼炉
        new MagicExpansionQuickSmeltery(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_SMELTERY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                BasicCreateItem("MAGIC_REDSTONE"), AdvancedCreateItem("MAGIC_COSMIC_DUST"), BasicCreateItem("MAGIC_REDSTONE"),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.FURNACE), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                BasicCreateItem("MAGIC_REDSTONE"), AdvancedCreateItem("MAGIC_COSMIC_DUST"), BasicCreateItem("MAGIC_REDSTONE")
        }).register(plugin);
        /*
        // 快捷冶炼炉2
        new UnplaceableBlock(quickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_SMELTERY2, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                BasicCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC"), AdvancedCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED"), BasicCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC"),
                AdvancedCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED"), new ItemStack(Material.FURNACE), AdvancedCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED"),
                BasicCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC"), AdvancedCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED"), BasicCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC")
        },MagicExpansionItems.MAGIC_EXPANSION_QUICK_SMELTERY).register(plugin);
        */




    }




}
