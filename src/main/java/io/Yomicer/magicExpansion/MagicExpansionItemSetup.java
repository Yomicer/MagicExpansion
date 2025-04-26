package io.Yomicer.magicExpansion;

import io.Yomicer.magicExpansion.Listener.SlimefunRegistryFinalized;
import io.Yomicer.magicExpansion.items.electric.recipeMachine.RecipeMachine;
import io.Yomicer.magicExpansion.items.electric.resourceGenerator.ResourceMachine;
import io.Yomicer.magicExpansion.items.enchantMachine.EnchantingTable;
import io.Yomicer.magicExpansion.items.misc.FireZombieMB;
import io.Yomicer.magicExpansion.items.preBuildings.PreBuildingTree;
import io.Yomicer.magicExpansion.items.quickMachine.*;
import io.Yomicer.magicExpansion.items.quickMachineBlockVersion.QuickMachineBV;
import io.Yomicer.magicExpansion.items.quickMachineBlockVersion.QuickMachineMBBV;
import io.Yomicer.magicExpansion.items.summonBossItem.FireZombie;
import io.Yomicer.magicExpansion.items.tools.*;
import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.Yomicer.magicExpansion.utils.ColorGradient;
import io.Yomicer.magicExpansion.utils.itemUtils.newItem;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
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
import static io.Yomicer.magicExpansion.utils.Language.get;
import static io.Yomicer.magicExpansion.utils.Language.getList;
import static io.Yomicer.magicExpansion.utils.Utils.doGlow;


public final class MagicExpansionItemSetup {


    // ItemGroups
    private static final NestedItemGroup magicexpansion = new NestedItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "magicexpansion"),
            new CustomItemStack(doGlow(Material.LIGHT),"§x§F§D§B§7§D§4§kll§x§F§D§B§7§D§4魔§x§F§A§7§E§B§3法§x§F§F§6§9§B§4拓§x§F§F§6§9§B§4展§x§F§D§B§7§D§4§kll"),0
    );

    private static final ItemGroup magicexpansioncontribution = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "contribution"), magicexpansion,
            new CustomItemStack(doGlow(Material.COMMAND_BLOCK), "§x§F§D§B§7§D§4§kll§x§F§A§7§E§B§3贡§x§F§F§6§9§B§4献§x§F§F§6§9§B§4§kll"), 0
    );

    private static final ItemGroup magicexpansionresource = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "resource"), magicexpansion,
            new CustomItemStack(doGlow(Material.SNOWBALL), ColorGradient.getGradientName("魔法-资源")), 1
    );

    private static final ItemGroup magicexpansionresourcedlc = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "resourcedlc"), magicexpansion,
            new CustomItemStack(doGlow(Material.TOTEM_OF_UNDYING), "§x§F§D§B§7§D§4补§x§F§A§7§E§B§3丁§x§F§F§6§9§B§4材§x§F§F§6§9§B§4料"), 2
    );

    private static final ItemGroup magicexpansionspecialitem = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "specialitem"), magicexpansion,
            new CustomItemStack(doGlow(Material.SHEARS), "§x§F§D§B§7§D§4特§x§F§A§7§E§B§3殊§x§F§F§6§9§B§4道§x§F§F§6§9§B§4具"), 3
    );

    private static final ItemGroup magicexpansionquickmachine = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "quickmachine"), magicexpansion,
            new CustomItemStack(doGlow(Material.MAGENTA_GLAZED_TERRACOTTA), "§x§F§D§B§7§D§4快§x§F§A§7§E§B§3捷§x§F§F§6§9§B§4机§x§F§F§6§9§B§4器"), 4
    );

    private static final ItemGroup magicexpansionresourcegenerator = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "resourcegenerator"), magicexpansion,
            new CustomItemStack(doGlow(Material.LANTERN), ColorGradient.getGradientName("魔法-生成器")), 5
    );
    private static final ItemGroup magicexpansionrecipemachine = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "recipemachine"), magicexpansion,
            new CustomItemStack(doGlow(Material.SOUL_CAMPFIRE), ColorGradient.getGradientName("魔法-机器")), 5
    );

    private static final ItemGroup magicexpansionenergy = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "energy"), magicexpansion,
            new CustomItemStack(doGlow(Material.SOUL_LANTERN), ColorGradient.getGradientName("魔法-特殊机器")), 6
    );

    private static final ItemGroup magicexpansionboss = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "boss"), magicexpansion,
            new CustomItemStack(doGlow(Material.ENDER_DRAGON_SPAWN_EGG), ColorGradient.getGradientName("魔法BOSS")), 7
    );

    private static final ItemGroup magicexpansionforge = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "forge"), magicexpansion,
            new CustomItemStack(doGlow(Material.ANVIL), ColorGradient.getGradientName("魔法锻造")), 8
    );

    private static final ItemGroup magicexpansionprebuilding = new SubItemGroup(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "prebuilding"), magicexpansion,
            new CustomItemStack(doGlow(Material.BRICKS), ColorGradient.getGradientName("魔法-预制菜（建筑）")), 9
    );


    // 定义一个新的配方类型
    public static final RecipeType SPECIAL_RECIPE_TYPE = new RecipeType(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "magicexpansion_special_recipe_type"),
            new CustomItemStack(Material.TOTEM_OF_UNDYING,"§x§F§D§B§7§D§4无§x§F§A§7§E§B§3法§x§F§F§6§9§B§4合§x§F§F§6§9§B§4成",getGradientName("痴情的人啊"),getGradientName("请再等一世吧")), // 图标
            (input, output) -> {});

    // 定义一个新的配方类型
    public static final RecipeType MAGICEXPANSION_MOB_DROP = new RecipeType(
            new NamespacedKey(MagicExpansionMachines.getInstance(), "magicexpansion_mob_drop"),
            new CustomItemStack(Material.TOTEM_OF_UNDYING,ColorGradient.getGradientName("魔法生物掉落"),getGradientName("通过召唤魔法生物"),getGradientName("并将其击败"),getGradientName("有概率获取")), // 图标
            (input, output) -> {});

    private MagicExpansionItemSetup() {
    }


    public static void setup(@Nonnull MagicExpansionMachines plugin) {


        //版本信息
        new UnplaceableBlock(magicexpansioncontribution, MagicExpansionItems.MAGIC_EXPANSION_INFO, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);

        //magicsolo头颅
        new UnplaceableBlock(magicexpansioncontribution, MagicExpansionItems.MAGIC_EXPANSION_AUTHOR, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);

        //快捷机器提示
        new UnplaceableBlock(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_MACHINE_INFO, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);

        //初级万能魔法合成材料
        new UnplaceableBlock(magicexpansionresourcedlc, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.RAINBOW_GLAZED_TERRACOTTA, SlimefunItems.ANCIENT_PEDESTAL, SlimefunItems.RAINBOW_CONCRETE,
                SlimefunItems.RAINBOW_GLASS_PANE, SlimefunItems.MAGIC_EYE_OF_ENDER, SlimefunItems.RAINBOW_GLASS,
                SlimefunItems.RAINBOW_CLAY, SlimefunItems.ANCIENT_ALTAR, SlimefunItems.RAINBOW_WOOL
        }).register(plugin);

        //进阶万能魔法合成材料
        new UnplaceableBlock(magicexpansionresourcedlc, MagicExpansionItems.MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC,
                MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC,
                MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC
        }).register(plugin);


        //魔法交互核心
        new UnplaceableBlock(magicexpansionresourcedlc, MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
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

        //Quick Machine
        // 魔法矿洞
        new MagicExpansionMineralCave(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_MINERAL_CAVE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.SMOOTH_STONE), BasicCreateItem("MAGIC_REDSTONE"),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), BasicCreateItem("MAGIC_REDSTONE"), AdvancedCreateItem("MAGIC_COSMIC_DUST")
        }).register(plugin);

        // 魔法工作台
        new MagicExpansionQuickEnhancedCraftingTable(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_ENHANCED_CRAFTING_TABLE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.CRAFTING_TABLE), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法冶炼炉
        new MagicExpansionQuickSmeltery(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_SMELTERY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, new ItemStack(Material.ENDER_EYE),
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
                new ItemStack(Material.ENDER_EYE), MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.DISPENSER), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法粉碎机
        new MagicExpansionQuickOreCrusher(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_ORE_CRUSHER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.IRON_BARS), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);

        // 魔法盔甲锻造台
        new MagicExpansionQuickArmorForge(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_ARMOR_FORGE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.ANVIL), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法压缩机
        new MagicExpansionQuickCompressor(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_COMPRESSOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.PISTON), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法压力机
        new MagicExpansionQuickPressureChamber(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_PRESSURE_CHAMBER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.GLASS), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法工作台
        new MagicExpansionQuickMagicWorkbench(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_MAGIC_WORKBENCH, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.BOOKSHELF), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法淘金机
        new MagicExpansionQuickAutomatedPanningMachine(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_AUTOMATED_PANNING_MACHINE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), SlimefunItems.GOLD_PAN, AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法远古祭坛
        new MagicExpansionQuickAncientAltar(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_AUTOMATED_ANCIENT_ALTAR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.ANCIENT_ALTAR, MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, SlimefunItems.ANCIENT_ALTAR,
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.ENCHANTING_TABLE), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                SlimefunItems.ANCIENT_ALTAR, BasicCreateItem("MAGIC_REDSTONE"), SlimefunItems.ANCIENT_ALTAR
        }).register(plugin);
        // 破损的魔法碎矿机
        new MagicExpansionQuickOreGrinder(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_ELECTRIC_ORE_GRINDER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.OBSERVER), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);
        // 魔法压力舱
        new MagicExpansionQuickHeatedPressureChamber(magicexpansionquickmachine, MagicExpansionItems.MAGIC_EXPANSION_QUICK_HEATED_PRESSURE_CHAMBER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), MagicExpansionItems.MAGIC_EXPANSION_INTERACTIVE_CORE, new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), BasicCreateItem("MAGIC_REDSTONE"), new ItemStack(Material.ENDER_EYE)
        }).register(plugin);





        // 附魔信息
        new UnplaceableBlock(magicexpansionenergy, MagicExpansionItems.MAGIC_EXPANSION_ENCHANTING_TABLE_INFO, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null,null,null,
                null,null,null,
                null,null,null
        }).register(plugin);

        // 附魔列表
        new UnplaceableBlock(magicexpansionenergy, MagicExpansionItems.MAGIC_EXPANSION_ENCHANTING_TABLE_LIST, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null,null,null,
                null,null,null,
                null,null,null
        }).register(plugin);

        // 魔法附魔台
        new EnchantingTable(magicexpansionenergy, MagicExpansionItems.MAGIC_EXPANSION_ENCHANTING_TABLE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.ENDER_EYE), AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.ENDER_EYE),
                AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.ENCHANTING_TABLE), AdvancedCreateItem("MAGIC_COSMIC_DUST"),
                new ItemStack(Material.ENDER_EYE), AdvancedCreateItem("MAGIC_COSMIC_DUST"), new ItemStack(Material.ENDER_EYE)
        }, getGradientName( "魔法附魔台"),getGradientName("魔法附魔台")).register(plugin);







        //快捷机器放置版
        new UnplaceableBlock(magicexpansionquickmachine, MagicExpansionItems.QUICK_MACHINE_BV_INFO, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null,null
        }).register(plugin);

        // 魔法增强型工作台 放置版
        new QuickMachineBV(magicexpansionquickmachine, MagicExpansionItems.QUICK_ENHANCED_CRAFTING_TABLE_BV, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), MagicExpansionItems.MAGIC_EXPANSION_QUICK_ENHANCED_CRAFTING_TABLE,new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS) ,new ItemStack(Material.OAK_PLANKS)
        },"魔法工作台（增强型工作台）", MagicExpansionQuickEnhancedCraftingTable.ENHANCED_CRAFTING_TABLE_RECIPES,RecipeType.ENHANCED_CRAFTING_TABLE).register(plugin);
        // 魔法冶炼炉 放置版
        new QuickMachineMBBV(magicexpansionquickmachine, MagicExpansionItems.QUICK_SMELTERY_BV, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), MagicExpansionItems.MAGIC_EXPANSION_QUICK_SMELTERY,new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS) ,new ItemStack(Material.OAK_PLANKS)
        },"魔法冶炼炉", SlimefunRegistryFinalized.SMELTERY_RECIPES).register(plugin);
        // 魔法磨石 放置版
        new QuickMachineMBBV(magicexpansionquickmachine, MagicExpansionItems.QUICK_GRIND_STONE_BV, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), MagicExpansionItems.MAGIC_EXPANSION_QUICK_GRIND_STONE,new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS) ,new ItemStack(Material.OAK_PLANKS)
        },"魔法磨石", SlimefunRegistryFinalized.GRIND_STONE_RECIPES).register(plugin);
        // 魔法粉碎机 放置版
        new QuickMachineMBBV(magicexpansionquickmachine, MagicExpansionItems.QUICK_ORE_CRUSHER_BV, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), MagicExpansionItems.MAGIC_EXPANSION_QUICK_ORE_CRUSHER,new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS) ,new ItemStack(Material.OAK_PLANKS)
        },"魔法碎矿机", SlimefunRegistryFinalized.ORE_CRUSHER_RECIPES).register(plugin);
        // 魔法锻造台 放置版
        new QuickMachineBV(magicexpansionquickmachine, MagicExpansionItems.QUICK_ARMOR_FORGE_BV, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), MagicExpansionItems.MAGIC_EXPANSION_QUICK_ARMOR_FORGE,new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS) ,new ItemStack(Material.OAK_PLANKS)
        },"魔法锻造台", MagicExpansionQuickArmorForge.ARMOR_FORGE_RECIPES,RecipeType.ARMOR_FORGE).register(plugin);
        // 魔法压缩机 放置版
        new QuickMachineMBBV(magicexpansionquickmachine, MagicExpansionItems.QUICK_COMPRESSOR_BV, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), MagicExpansionItems.MAGIC_EXPANSION_QUICK_COMPRESSOR,new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS) ,new ItemStack(Material.OAK_PLANKS)
        },"魔法压缩机", SlimefunRegistryFinalized.COMPRESSOR_RECIPES).register(plugin);
        // 魔法压力机 放置版
        new QuickMachineMBBV(magicexpansionquickmachine, MagicExpansionItems.QUICK_PRESSURE_CHAMBER_BV, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), MagicExpansionItems.MAGIC_EXPANSION_QUICK_PRESSURE_CHAMBER,new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS) ,new ItemStack(Material.OAK_PLANKS)
        },"魔法压力机", SlimefunRegistryFinalized.PRESSURE_CHAMBER_RECIPES).register(plugin);
        // 魔法工作台[魔法工作台] 放置版
        new QuickMachineBV(magicexpansionquickmachine, MagicExpansionItems.QUICK_MAGIC_WORKBENCH_BV, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), MagicExpansionItems.MAGIC_EXPANSION_QUICK_MAGIC_WORKBENCH,new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS) ,new ItemStack(Material.OAK_PLANKS)
        },"魔法工作台（魔法工作台）", MagicExpansionQuickMagicWorkbench.MAGIC_WORKBENCH_RECIPES,RecipeType.MAGIC_WORKBENCH).register(plugin);
        // 魔法淘金机 放置版
        new QuickMachineBV(magicexpansionquickmachine, MagicExpansionItems.QUICK_AUTOMATED_PANNING_MACHINE_BV, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), MagicExpansionItems.MAGIC_EXPANSION_QUICK_AUTOMATED_PANNING_MACHINE,new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS) ,new ItemStack(Material.OAK_PLANKS)
        },"魔法淘金机", MagicExpansionQuickAutomatedPanningMachine.GOLD_PAN_RECIPES,RecipeType.GOLD_PAN).register(plugin);
        // 魔法远古祭坛 放置版
        new QuickMachineBV(magicexpansionquickmachine, MagicExpansionItems.QUICK_AUTOMATED_ANCIENT_ALTAR_BV, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), MagicExpansionItems.MAGIC_EXPANSION_QUICK_AUTOMATED_ANCIENT_ALTAR,new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS) ,new ItemStack(Material.OAK_PLANKS)
        },"魔法远古祭坛", MagicExpansionQuickAncientAltar.ANCIENT_ALTAR_RECIPES,RecipeType.ANCIENT_ALTAR).register(plugin);
        // 魔法远古祭坛 放置版
        new QuickMachineBV(magicexpansionquickmachine, MagicExpansionItems.QUICK_ELECTRIC_ORE_GRINDER_BV, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), MagicExpansionItems.MAGIC_EXPANSION_QUICK_ELECTRIC_ORE_GRINDER,new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS) ,new ItemStack(Material.OAK_PLANKS)
        },"破损的魔法碎矿机", MagicExpansionQuickOreGrinder.ORE_CRUSHER_RECIPES,RecipeType.ORE_CRUSHER).register(plugin);
        // 魔法远古祭坛 放置版
        new QuickMachineBV(magicexpansionquickmachine, MagicExpansionItems.QUICK_HEATED_PRESSURE_CHAMBER_BV, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), MagicExpansionItems.MAGIC_EXPANSION_QUICK_HEATED_PRESSURE_CHAMBER,new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS) ,new ItemStack(Material.OAK_PLANKS)
        },"魔法压力舱", MagicExpansionQuickHeatedPressureChamber.HEATED_PRESSURE_CHAMBER_RECIPES,RecipeType.HEATED_PRESSURE_CHAMBER).register(plugin);











        // 烈火僵尸BOSS
        new FireZombie(magicexpansionboss, MagicExpansionItems.FIRE_ZOMBIE, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null,null,null,
                null,null,null,
                null,null,null
        }).register(plugin);

        // 僵尸类BOSS身体
        new SlimefunItem(magicexpansionboss, MagicExpansionItems.FIREZOMBIE_BODY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.ENDER_LUMP_3,SlimefunItems.LAVA_CRYSTAL,SlimefunItems.ENDER_LUMP_3,
                SlimefunItems.MAGIC_LUMP_3,SlimefunItems.NECROTIC_SKULL,SlimefunItems.MAGIC_LUMP_3,
                SlimefunItems.ENDER_LUMP_3,SlimefunItems.ESSENCE_OF_AFTERLIFE,SlimefunItems.ENDER_LUMP_3
        }).register(plugin);

        // 烈火僵尸头颅
        new SlimefunItem(magicexpansionboss, MagicExpansionItems.FIREZOMBIE_HEAD, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.MOSS_BLOCK),new ItemStack(Material.ROTTEN_FLESH),new ItemStack(Material.MOSS_BLOCK),
                new ItemStack(Material.ROTTEN_FLESH),new ItemStack(Material.MOSS_BLOCK),new ItemStack(Material.ROTTEN_FLESH),
                new ItemStack(Material.MOSS_BLOCK),new ItemStack(Material.ROTTEN_FLESH),new ItemStack(Material.MOSS_BLOCK)
        }).register(plugin);




        new FireZombieMB(magicexpansionboss, MagicExpansionItems.FIRE_ZOMBIE_MB).register(plugin);

        // 星辰铁   1级青金石
        new UnplaceableBlock(magicexpansionforge, MagicExpansionItems.BASIC_ENCHANT_STONE, MAGICEXPANSION_MOB_DROP, new ItemStack[] {
                null, null, null,
                null, newItem.themed(Material.ZOMBIE_SPAWN_EGG, get("Items.BASIC_ENCHANT_STONE_DROP.Name"), getList("Items.BASIC_ENCHANT_STONE_DROP.Lore")),null,
                null, null,null
        }).register(plugin);



        // 材料 魔法材料   魔法铁锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.IRON_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.IRON_DUST, new ItemStack(Material.IRON_INGOT),SlimefunItems.IRON_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法金锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.GOLD_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.IRON_DUST, new ItemStack(Material.GOLD_INGOT),SlimefunItems.IRON_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法铜锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.COPPER_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.IRON_DUST, SlimefunItems.COPPER_INGOT,SlimefunItems.IRON_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法锡锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.TIN_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.IRON_DUST, SlimefunItems.TIN_INGOT,SlimefunItems.IRON_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法银锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.SILVER_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.IRON_DUST, SlimefunItems.SILVER_INGOT,SlimefunItems.IRON_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法铅锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.LEAD_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.IRON_DUST, SlimefunItems.LEAD_INGOT,SlimefunItems.IRON_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法铝锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.ALUMINUM_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.IRON_DUST, SlimefunItems.ALUMINUM_INGOT,SlimefunItems.IRON_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法锌锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.ZINC_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.IRON_DUST, SlimefunItems.ZINC_INGOT,SlimefunItems.IRON_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法镁锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.MAGNESIUM_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.IRON_DUST, SlimefunItems.MAGNESIUM_INGOT,SlimefunItems.IRON_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.IRON_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //元素锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.ELEMENT_INGOT, RecipeType.SMELTERY, new ItemStack[] {
                MagicExpansionItems.IRON_INGOT, MagicExpansionItems.GOLD_INGOT, MagicExpansionItems.COPPER_INGOT,
                MagicExpansionItems.TIN_INGOT, MagicExpansionItems.SILVER_INGOT, MagicExpansionItems.LEAD_INGOT,
                MagicExpansionItems.ALUMINUM_INGOT, MagicExpansionItems.ZINC_INGOT, MagicExpansionItems.MAGNESIUM_INGOT
        }).register(plugin);

        //魔法红石
        registerVanResource(plugin,MagicExpansionItems.REDSTONE, new ItemStack(Material.REDSTONE));
        registerVanResource(plugin,MagicExpansionItems.DIAMOND, new ItemStack(Material.DIAMOND));
        registerVanResource(plugin,MagicExpansionItems.LAPIS_LAZULI, new ItemStack(Material.LAPIS_LAZULI));
        registerVanResource(plugin,MagicExpansionItems.EMERALD, new ItemStack(Material.EMERALD));
        registerVanResource(plugin,MagicExpansionItems.COAL, new ItemStack(Material.COAL));
        registerVanResource(plugin,MagicExpansionItems.QUARTZ, new ItemStack(Material.QUARTZ));
        registerVanResource(plugin,MagicExpansionItems.AMETHYST_SHARD, new ItemStack(Material.AMETHYST_SHARD));
        registerVanResource(plugin,MagicExpansionItems.NETHERITE_INGOT, new ItemStack(Material.NETHERITE_INGOT));
        registerVanResource(plugin,MagicExpansionItems.BONE, new ItemStack(Material.BONE));
        registerVanResource(plugin,MagicExpansionItems.BONE_MEAL, new ItemStack(Material.BONE_MEAL));
        registerVanResource(plugin,MagicExpansionItems.STICK, new ItemStack(Material.STICK));
        registerVanResource(plugin,MagicExpansionItems.COBBLESTONE, new ItemStack(Material.NETHERITE_INGOT));
        registerVanResource(plugin,MagicExpansionItems.DIRT, new ItemStack(Material.DIRT));

        // 魔法橡木木板
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.OAK_PLANKS, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.OAK_PLANKS) , null,
                null, null ,null,
                null, null,null
        }).register(plugin);

        // 红石火把
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.REDSTONE_TORCH, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null, MagicExpansionItems.REDSTONE, null,
                null, MagicExpansionItems.STICK ,null,
                null, null,null
        }).register(plugin);
        // 拉杆
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.LEVER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null, MagicExpansionItems.STICK, null,
                null, MagicExpansionItems.COBBLESTONE ,null,
                null, null,null
        }).register(plugin);
        // 按钮
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.BUTTON, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null, null , null,
                null, MagicExpansionItems.COBBLESTONE ,null,
                null, null,null
        }).register(plugin);

        // 翠木核心
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.LOG_MIX, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_LOG), new ItemStack(Material.SPRUCE_LOG) , new ItemStack(Material.BIRCH_LOG),
                new ItemStack(Material.JUNGLE_LOG), MagicExpansionItems.BONE ,new ItemStack(Material.ACACIA_LOG),
                new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.MANGROVE_LOG),new ItemStack(Material.CHERRY_LOG)
        }).register(plugin);

        // 红石处理元件
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.REDSTONE_EXECUTE_ELEMENT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.REDSTONE_TORCH, MagicExpansionItems.LEVER , MagicExpansionItems.REDSTONE_TORCH,
                MagicExpansionItems.OAK_PLANKS, MagicExpansionItems.REDSTONE ,MagicExpansionItems.OAK_PLANKS,
                MagicExpansionItems.ELEMENT_INGOT, MagicExpansionItems.IRON_INGOT,MagicExpansionItems.ELEMENT_INGOT
        }).register(plugin);

        // 原版机器核心
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.CORE_ORIGIN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT, SlimefunItems.MAGICAL_GLASS , MagicExpansionItems.COBBLESTONE,
                SlimefunItems.ENDER_LUMP_3, MagicExpansionItems.REDSTONE_EXECUTE_ELEMENT ,SlimefunItems.ENDER_LUMP_3,
                MagicExpansionItems.COBBLESTONE, SlimefunItems.MAGICAL_GLASS,MagicExpansionItems.ELEMENT_INGOT
        }).register(plugin);








        new ResourceMachine(magicexpansionresourcegenerator, MagicExpansionItems.RESOURCE_MACHINE_WOOD_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT,SlimefunItems.BIG_CAPACITOR,MagicExpansionItems.REDSTONE,
                MagicExpansionItems.ZINC_INGOT,MagicExpansionItems.LOG_MIX,MagicExpansionItems.ZINC_INGOT,
                MagicExpansionItems.REDSTONE,MagicExpansionItems.CORE_ORIGIN,MagicExpansionItems.ELEMENT_INGOT
        })
                .setCraftSecond(4)
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .setItemStackOutputs(new ItemStack[] {new ItemStack(Material.OAK_LOG,2),new ItemStack(Material.SPRUCE_LOG,2),new ItemStack(Material.BIRCH_LOG,2),
                        new ItemStack(Material.JUNGLE_LOG,2),new ItemStack(Material.ACACIA_LOG,2),new ItemStack(Material.DARK_OAK_LOG,2),
                        new ItemStack(Material.MANGROVE_LOG,2),new ItemStack(Material.CHERRY_LOG,2),
                        new ItemStack(Material.OAK_LEAVES,2),new ItemStack(Material.SPRUCE_LEAVES,2),new ItemStack(Material.BIRCH_LEAVES,2),
                        new ItemStack(Material.JUNGLE_LEAVES,2),new ItemStack(Material.ACACIA_LEAVES,2),new ItemStack(Material.DARK_OAK_LEAVES,2),
                        new ItemStack(Material.MANGROVE_LEAVES,2),new ItemStack(Material.CHERRY_LEAVES,2)})
                .register(plugin);

        new RecipeMachine(magicexpansionrecipemachine, MagicExpansionItems.WOOD_TRANSFORM_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT,SlimefunItems.BIG_CAPACITOR,MagicExpansionItems.AMETHYST_SHARD,
                MagicExpansionItems.BONE,MagicExpansionItems.LOG_MIX,MagicExpansionItems.BONE_MEAL,
                MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.CORE_ORIGIN,MagicExpansionItems.ELEMENT_INGOT
        })
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.OAK_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.SPRUCE_LOG,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.SPRUCE_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.BIRCH_LOG,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.BIRCH_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.JUNGLE_LOG,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.JUNGLE_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.ACACIA_LOG,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.ACACIA_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.DARK_OAK_LOG,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.DARK_OAK_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.MANGROVE_LOG,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.MANGROVE_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.CHERRY_LOG,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.CHERRY_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.OAK_LOG,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.OAK_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.SPRUCE_LEAVES,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.SPRUCE_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.BIRCH_LEAVES,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.BIRCH_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.JUNGLE_LEAVES,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.JUNGLE_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.ACACIA_LEAVES,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.ACACIA_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.DARK_OAK_LEAVES,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.DARK_OAK_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.MANGROVE_LEAVES,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.MANGROVE_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.CHERRY_LEAVES,16)})
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.CHERRY_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.OAK_LEAVES,16)})
                .register(plugin);














        // 预制树-说明
        new UnplaceableBlock(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_TREE_INFO, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null,null,null,
                null,null,null,
                null,null,null
        }).register(plugin);

        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_OAK_TREE, "oak_tree", "OAK", "OAK", new ItemStack(Material.OAK_SAPLING));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_SPRUCE_TREE, "oak_tree", "OAK", "SPRUCE", new ItemStack(Material.SPRUCE_SAPLING));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_BIRCH_TREE, "oak_tree", "OAK", "BIRCH", new ItemStack(Material.BIRCH_SAPLING));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_JUNGLE_TREE, "oak_tree", "OAK", "JUNGLE", new ItemStack(Material.JUNGLE_SAPLING));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_ACACIA_TREE, "oak_tree", "OAK", "ACACIA", new ItemStack(Material.ACACIA_SAPLING));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_DARK_OAK_TREE, "oak_tree", "OAK", "DARK_OAK", new ItemStack(Material.DARK_OAK_SAPLING));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_MANGROVE_TREE, "oak_tree", "OAK", "MANGROVE", new ItemStack(Material.MANGROVE_PROPAGULE));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_CHERRY_TREE, "oak_tree", "CHERRY", "CHERRY", new ItemStack(Material.CHERRY_SAPLING));

//        // 预制树-橡木树
//        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_OAK_TREE, SPECIAL_RECIPE_TYPE, new ItemStack[] {
//                null,null,null,
//                null,null,null,
//                null,null,null
//        },"oak_tree").register(plugin);
//        // 预制树-云杉树
//        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_SPRUCE_TREE, SPECIAL_RECIPE_TYPE, new ItemStack[] {
//                null,null,null,
//                null,null,null,
//                null,null,null
//        },"oak_tree","OAK","SPRUCE").register(plugin);
//        // 预制树-樱花树
//        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_CHERRY_TREE, SPECIAL_RECIPE_TYPE, new ItemStack[] {
//                null,null,null,
//                null,null,null,
//                null,null,null
//        },"oak_tree","OAK","CHERRY").register(plugin);








    }

    // 注册预制树General
    private static void registerVanResource(
            MagicExpansionMachines plugin,
            SlimefunItemStack item,
            ItemStack miditem) {

        new UnplaceableBlock(
                magicexpansionresource,
                item,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        SlimefunItems.MAGIC_LUMP_1,new ItemStack(Material.BONE_MEAL),SlimefunItems.MAGIC_LUMP_1,
                        new ItemStack(Material.BONE_MEAL),miditem,new ItemStack(Material.BONE_MEAL),
                        SlimefunItems.MAGIC_LUMP_1,new ItemStack(Material.BONE_MEAL),SlimefunItems.MAGIC_LUMP_1
                }).register(plugin);
    }

    // 注册预制树General
    private static void registerPreBuildingTree(
            MagicExpansionMachines plugin,
            SlimefunItemStack treeItem,
            String baseTreeKey,
            String baseTreeType,
            String treeType,
            ItemStack tree) {

        new PreBuildingTree(
                magicexpansionprebuilding,
                treeItem,
                SPECIAL_RECIPE_TYPE,
                new ItemStack[] {
                        MagicExpansionItems.BONE_MEAL, tree, null,
                        null, null, null,
                        null, null, null
                },
                baseTreeKey,
                baseTreeType,
                treeType.toUpperCase()
        ).register(plugin);
    }


}
