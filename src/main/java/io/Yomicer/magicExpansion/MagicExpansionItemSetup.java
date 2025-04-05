package io.Yomicer.magicExpansion;

import io.Yomicer.magicExpansion.items.quickMachine.*;
import io.Yomicer.magicExpansion.items.tools.*;
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
import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;
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
            new CustomItemStack(Material.TOTEM_OF_UNDYING,"§x§F§D§B§7§D§4无§x§F§A§7§E§B§3法§x§F§F§6§9§B§4合§x§F§F§6§9§B§4成",getGradientName("痴情的人啊"),getGradientName("请再等一世吧")), // 图标
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


        //魔法交互核心
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.WITHER_PROOF_GLASS, SlimefunItems.POWER_CRYSTAL, SlimefunItems.WITHER_PROOF_GLASS,
                SlimefunItems.ADVANCED_CIRCUIT_BOARD, SlimefunItems.CARGO_MANAGER, SlimefunItems.ADVANCED_CIRCUIT_BOARD,
                SlimefunItems.WITHER_PROOF_GLASS, SlimefunItems.ANDROID_INTERFACE_ITEMS, SlimefunItems.WITHER_PROOF_GLASS
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
                SlimefunItems.MAGIC_LUMP_3, SlimefunItems.ENDER_LUMP_3, SlimefunItems.MAGIC_LUMP_3,
                SlimefunItems.ENDER_LUMP_3, BasicCreateItem("MAGIC_REDSTONE"), SlimefunItems.ENDER_LUMP_3,
                SlimefunItems.MAGIC_LUMP_3, SlimefunItems.ENDER_LUMP_3, SlimefunItems.MAGIC_LUMP_3
        }).register(plugin);
        // 魔法矿洞
        new MagicExpansionMineralCave(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_MINERAL_CAVE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_EXPANSION_INTERACTIVE_CORE"), new ItemStack(Material.ENDER_EYE),
                BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.SMOOTH_STONE), BasicCreateItem("MAGIC_REDSTONE"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);

        // 魔法工作台
        new MagicExpansionQuickEnhancedCraftingTable(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_ENHANCED_CRAFTING_TABLE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_EXPANSION_INTERACTIVE_CORE"), new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.CRAFTING_TABLE), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法冶炼炉
        new MagicExpansionQuickSmeltery(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_SMELTERY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_EXPANSION_INTERACTIVE_CORE"), new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.FURNACE), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        /*
        // 魔法冶炼炉2
        new UnplaceableBlock(quickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_SMELTERY2, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                BasicCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC"), AdvancedCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED"), BasicCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC"),
                AdvancedCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED"), new ItemStack(Material.FURNACE), AdvancedCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED"),
                BasicCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC"), AdvancedCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED"), BasicCreateItem("MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC")
        },MagicExpansionItems.MAGIC_EXPANSION_QUICK_SMELTERY).register(plugin);
        */
        // 魔法磨石
        new MagicExpansionQuickGrindStone(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_GRIND_STONE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_EXPANSION_INTERACTIVE_CORE"), new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.DISPENSER), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法粉碎机
        new MagicExpansionQuickOreCrusher(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_ORE_CRUSHER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_EXPANSION_INTERACTIVE_CORE"), new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.IRON_BARS), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);

        // 魔法盔甲锻造台
        new MagicExpansionQuickArmorForge(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_ARMOR_FORGE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_EXPANSION_INTERACTIVE_CORE"), new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.ANVIL), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法压缩机
        new MagicExpansionQuickCompressor(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_COMPRESSOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_EXPANSION_INTERACTIVE_CORE"), new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.PISTON), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法压力机
        new MagicExpansionQuickPressureChamber(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_PRESSURE_CHAMBER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_EXPANSION_INTERACTIVE_CORE"), new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.GLASS), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法工作台
        new MagicExpansionQuickMagicWorkbench(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_MAGIC_WORKBENCH, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_EXPANSION_INTERACTIVE_CORE"), new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.BOOKSHELF), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法淘金机
        new MagicExpansionQuickAutomatedPanningMachine(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_AUTOMATED_PANNING_MACHINE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_EXPANSION_INTERACTIVE_CORE"), new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), SlimefunItems.GOLD_PAN, AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法远古祭坛
        new MagicExpansionQuickAncientAltar(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_AUTOMATED_ANCIENT_ALTAR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_EXPANSION_INTERACTIVE_CORE"), new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.ENCHANTING_TABLE), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);


    }




}
