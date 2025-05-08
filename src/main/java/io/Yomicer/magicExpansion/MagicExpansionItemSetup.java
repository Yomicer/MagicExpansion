package io.Yomicer.magicExpansion;

import io.Yomicer.magicExpansion.Listener.SlimefunRegistryFinalized;
import io.Yomicer.magicExpansion.items.electric.entitykillMachinee.EntityKillMachine;
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
import io.Yomicer.magicExpansion.utils.CustomHeadUtils.CustomHead;
import io.Yomicer.magicExpansion.utils.itemUtils.newItem;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.Capacitor;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

import static io.Yomicer.magicExpansion.core.MagicExpansionItems.MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC;
import static io.Yomicer.magicExpansion.core.MagicExpansionItems.PRE_BUILDINGS_MACHINE_ADVANCED;
import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;
import static io.Yomicer.magicExpansion.utils.ConvertItem.AdvancedCreateItem;
import static io.Yomicer.magicExpansion.utils.ConvertItem.BasicCreateItem;
import static io.Yomicer.magicExpansion.utils.Language.get;
import static io.Yomicer.magicExpansion.utils.Language.getList;
import static io.Yomicer.magicExpansion.utils.Utils.doGlow;
import static io.Yomicer.magicExpansion.utils.itemUtils.sfItemUtils.sfItemAmount;


public final class MagicExpansionItemSetup {


    // ItemGroups
    private static final NestedItemGroup magicexpansion = new NestedItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "magicexpansion"),
            new CustomItemStack(doGlow(Material.LIGHT),"§x§F§D§B§7§D§4§kll§x§F§D§B§7§D§4魔§x§F§A§7§E§B§3法§x§F§F§6§9§B§4拓§x§F§F§6§9§B§4展§x§F§D§B§7§D§4§kll"),0
    );

    private static final ItemGroup magicexpansioncontribution = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "contribution"), magicexpansion,
            new CustomItemStack(doGlow(Material.COMMAND_BLOCK), "§x§F§D§B§7§D§4§kll§x§F§A§7§E§B§3贡§x§F§F§6§9§B§4献§x§F§F§6§9§B§4§kll"), 0
    );

    private static final ItemGroup magicexpansionresource = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "resource"), magicexpansion,
            new CustomItemStack(doGlow(Material.SNOWBALL), ColorGradient.getGradientName("魔法-资源")), 1
    );

    private static final ItemGroup magicexpansionresourcedlc = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "resourcedlc"), magicexpansion,
            new CustomItemStack(doGlow(Material.TOTEM_OF_UNDYING), "§x§F§D§B§7§D§4补§x§F§A§7§E§B§3丁§x§F§F§6§9§B§4材§x§F§F§6§9§B§4料"), 2
    );

    private static final ItemGroup magicexpansionspecialitem = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "specialitem"), magicexpansion,
            new CustomItemStack(doGlow(Material.SHEARS), "§x§F§D§B§7§D§4特§x§F§A§7§E§B§3殊§x§F§F§6§9§B§4道§x§F§F§6§9§B§4具"), 3
    );

    private static final ItemGroup magicexpansionquickmachine = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "quickmachine"), magicexpansion,
            new CustomItemStack(doGlow(Material.MAGENTA_GLAZED_TERRACOTTA), "§x§F§D§B§7§D§4快§x§F§A§7§E§B§3捷§x§F§F§6§9§B§4机§x§F§F§6§9§B§4器"), 4
    );

    private static final ItemGroup magicexpansionresourcegenerator = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "resourcegenerator"), magicexpansion,
            new CustomItemStack(doGlow(Material.LANTERN), ColorGradient.getGradientName("魔法-资源生成器")), 5
    );
    private static final ItemGroup magicexpansionrecipemachine = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "recipemachine"), magicexpansion,
            new CustomItemStack(doGlow(Material.SOUL_CAMPFIRE), ColorGradient.getGradientName("魔法-消耗型生产机器")), 5
    );

    public static final ItemGroup magicexpansionenergy = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "energy"), magicexpansion,
            new CustomItemStack(doGlow(Material.SOUL_LANTERN), ColorGradient.getGradientName("魔法-特殊机器")), 6
    );

    public static final ItemGroup magicexpansionpower = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "power"), magicexpansion,
            new CustomItemStack(CustomHead.getHead("24378b986e358555ee73f09b210d49ec13719de5ea88d75523770d31163f3aef"), ColorGradient.getGradientName("魔法-发电机")), 6
    );

    private static final ItemGroup magicexpansionelectricbot = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "electric_bot"), magicexpansion,
            new CustomItemStack(CustomHead.BOT_PINK.getItem(), ColorGradient.getGradientName("魔法-电力机器人")), 6
    );

    private static final ItemGroup magicexpansionboss = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "boss"), magicexpansion,
            new CustomItemStack(doGlow(Material.ENDER_DRAGON_SPAWN_EGG), ColorGradient.getGradientName("魔法BOSS")), 7
    );

    private static final ItemGroup magicexpansionforge = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "forge"), magicexpansion,
            new CustomItemStack(doGlow(Material.ANVIL), ColorGradient.getGradientName("魔法锻造")), 8
    );

    private static final ItemGroup magicexpansionprebuildingresource = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "prebuildingresource"), magicexpansion,
            new CustomItemStack(doGlow(Material.PRISMARINE_CRYSTALS), ColorGradient.getGradientName("魔法-建筑材料")), 9
    );

    private static final ItemGroup magicexpansionprebuilding = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "prebuilding"), magicexpansion,
            new CustomItemStack(doGlow(Material.BRICKS), ColorGradient.getGradientName("魔法-预制菜（建筑）")), 9
    );


    // 定义一个新的配方类型
    public static final RecipeType SPECIAL_RECIPE_TYPE = new RecipeType(
            new NamespacedKey(MagicExpansion.getInstance(), "magicexpansion_special_recipe_type"),
            new CustomItemStack(Material.TOTEM_OF_UNDYING,"§x§F§D§B§7§D§4无§x§F§A§7§E§B§3法§x§F§F§6§9§B§4合§x§F§F§6§9§B§4成",getGradientName("痴情的人啊"),getGradientName("请再等一世吧")), // 图标
            (input, output) -> {});

    // 光能激发器
    public static final RecipeType LIGHT_TRANSFORM_BASIC = new RecipeType(
            new NamespacedKey(MagicExpansion.getInstance(), "magicexpansion_light_transform_basic"),
            new CustomItemStack(Material.AMETHYST_BLOCK,getGradientName("光能激发器"),getGradientName("散发着幽异的光芒。"),"",getGradientName("功能: 使用电力激发光能"),
                    getGradientName("能源需求: 每秒钟消耗少量电力从光源中提取光能"),getGradientName(""),getGradientName("“有限光源，有限的能源...”")),
            (input, output) -> {});

    // 魔法建筑工坊
    public static final RecipeType PRE_BUILDINGS_MACHINE = new RecipeType(
            new NamespacedKey(MagicExpansion.getInstance(), "magicexpansion_pre_buildings_machine"),
            new CustomItemStack(Material.PINK_GLAZED_TERRACOTTA,getGradientName("魔法建筑工坊"),getGradientName("一座神秘的工坊，里面藏有许多图纸。"),"",getGradientName("只要你能提供材料，他就能给你建造出来。"),
                    getGradientName(""),getGradientName("功能: 制作预制建筑"),getGradientName("能源需求: 每秒钟消耗少量电力")
                    ,getGradientName(""),getGradientName("是魔法之力？还是远古工匠的智慧结晶？"),getGradientName("无论如何，这座工坊流传着一些未知的秘密。")),
            (input, output) -> {});

    // 魔法建筑工坊
    public static final RecipeType PRE_BUILDINGS_MACHINE_RESOURCE_ADVANCED = new RecipeType(
            new NamespacedKey(MagicExpansion.getInstance(), "magicexpansion_pre_buildings_resource_machine"),
            new CustomItemStack(Material.SEA_LANTERN,getGradientName("魔法材料工坊"),getGradientName("一座神秘的工坊，里面藏有许多高精密仪器。"),"",getGradientName("只要你能提供材料，他就能给你压缩材料。"),
                    getGradientName(""),getGradientName("功能: 制作预制建筑"),getGradientName("能源需求: 每秒钟消耗大量电力")
                    ,getGradientName(""),getGradientName("是魔法之力？还是远古工匠的智慧结晶？"),getGradientName("无论如何，这座工坊流传着一些未知的秘密。")),
            (input, output) -> {});

    // 终极魔法建筑工坊
    public static final RecipeType PRE_BUILDINGS_MACHINE_ADVANCED = new RecipeType(
            new NamespacedKey(MagicExpansion.getInstance(), "magicexpansion_pre_buildings_machine_advance"),
            new CustomItemStack(Material.CARTOGRAPHY_TABLE,getGradientName("终极魔法建筑工坊"),getGradientName("一座神秘的工坊，里面藏有许多图纸。"),"",getGradientName("只要你能提供材料，他就能给你建造出来。"),
                    getGradientName(""),getGradientName("功能: 制作预制建筑"),getGradientName("能源需求: 每秒钟消耗大量电力")
                    ,getGradientName(""),getGradientName("是魔法之力？还是远古工匠的智慧结晶？"),getGradientName("无论如何，这座工坊流传着一些未知的秘密。")),
            (input, output) -> {});


    //  掉落物
    public static final RecipeType MAGICEXPANSION_MOB_DROP = new RecipeType(
            new NamespacedKey(MagicExpansion.getInstance(), "magicexpansion_mob_drop"),
            new CustomItemStack(Material.TOTEM_OF_UNDYING,ColorGradient.getGradientName("魔法生物掉落"),getGradientName("通过召唤魔法生物"),getGradientName("并将其击败"),getGradientName("有概率获取")), // 图标
            (input, output) -> {});

    private MagicExpansionItemSetup() {
    }


    public static void setup(@Nonnull MagicExpansion plugin) {


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
                MagicExpansionItems.AMETHYST_SHARD, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MagicExpansionItems.QUARTZ,
                MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MagicExpansionItems.ELEMENT_INGOT, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC,
                MagicExpansionItems.NETHERITE_INGOT, MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC, MagicExpansionItems.EMERALD
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
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.GOLD_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.GOLD_DUST, new ItemStack(Material.GOLD_INGOT),SlimefunItems.GOLD_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.GOLD_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法铜锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.COPPER_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.COPPER_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.COPPER_DUST, SlimefunItems.COPPER_INGOT,SlimefunItems.COPPER_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.COPPER_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法锡锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.TIN_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.TIN_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.TIN_DUST, SlimefunItems.TIN_INGOT,SlimefunItems.TIN_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.TIN_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法银锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.SILVER_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.SILVER_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.SILVER_DUST, SlimefunItems.SILVER_INGOT,SlimefunItems.SILVER_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.SILVER_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法铅锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.LEAD_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.LEAD_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.LEAD_DUST, SlimefunItems.LEAD_INGOT,SlimefunItems.LEAD_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.LEAD_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法铝锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.ALUMINUM_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.ALUMINUM_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.ALUMINUM_DUST, SlimefunItems.ALUMINUM_INGOT,SlimefunItems.ALUMINUM_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.ALUMINUM_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法锌锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.ZINC_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.ZINC_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.ZINC_DUST, SlimefunItems.ZINC_INGOT,SlimefunItems.ZINC_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.ZINC_DUST,SlimefunItems.MAGIC_LUMP_1
        }).register(plugin);
        //魔法镁锭
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.MAGNESIUM_INGOT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.MAGNESIUM_DUST, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.MAGNESIUM_DUST, SlimefunItems.MAGNESIUM_INGOT,SlimefunItems.MAGNESIUM_DUST,
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.MAGNESIUM_DUST,SlimefunItems.MAGIC_LUMP_1
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
        registerVanResource(plugin,MagicExpansionItems.GLOWSTONE_DUST, new ItemStack(Material.GLOWSTONE_DUST));

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

        //光之核心
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.LIGHT_CORE, RecipeType.SMELTERY, new ItemStack[] {
                MagicExpansionItems.IRON_INGOT, MagicExpansionItems.GOLD_INGOT, MagicExpansionItems.COPPER_INGOT,
                MagicExpansionItems.TIN_INGOT, new ItemStack(Material.GLOWSTONE_DUST), MagicExpansionItems.LEAD_INGOT,
                MagicExpansionItems.ALUMINUM_INGOT, MagicExpansionItems.ZINC_INGOT, MagicExpansionItems.MAGNESIUM_INGOT
        }).register(plugin);

        //光能α
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.LIGHT_ENERGY_ALPHA, LIGHT_TRANSFORM_BASIC, new ItemStack[] {
                new ItemStack(Material.LIGHT,32),MagicExpansionItems.MAGNESIUM_INGOT, null,
                null,null,null,
                null,null,null,
        }).register(plugin);

        //石英核心
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.QUARTZ_CORE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.ELEMENT_INGOT, MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.QUARTZ,MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.ELEMENT_INGOT,
        }).register(plugin);


        //紊乱的发电机核心
        new Capacitor(magicexpansionresource,131452, MagicExpansionItems.POWER_CORE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT,SlimefunItems.ENERGIZED_CAPACITOR, MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.COPPER_INGOT,MagicExpansionItems.MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED,MagicExpansionItems.ZINC_INGOT,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.ELEMENT_INGOT,
        }).register(plugin);


        //无尽打火石
        new InfiniteFlintAndSteel(magicexpansionresource, MagicExpansionItems.INFINITY_FLINT_AND_STEEL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.IRON_INGOT,MagicExpansionItems.IRON_INGOT, MagicExpansionItems.IRON_INGOT,
                MagicExpansionItems.IRON_INGOT,new ItemStack(Material.FLINT),MagicExpansionItems.IRON_INGOT,
                MagicExpansionItems.IRON_INGOT,MagicExpansionItems.IRON_INGOT,MagicExpansionItems.IRON_INGOT
        }).register(plugin);

        //无尽空间魔法
        new UnplaceableBlock(magicexpansionprebuildingresource, MagicExpansionItems.SPACE_INFINITY_MAGIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.LIGHT_CORE, MagicExpansionItems.AMETHYST_SHARD,
                MagicExpansionItems.LIGHT_CORE,MagicExpansionItems.MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC,MagicExpansionItems.LIGHT_CORE,
                MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.LIGHT_CORE,MagicExpansionItems.AMETHYST_SHARD,
        }).register(plugin);

        registerBuildingsResource(plugin,MagicExpansionItems.COBBLESTONE_1, Material.COBBLESTONE);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.COBBLESTONE_2, MagicExpansionItems.COBBLESTONE_1);
        registerBuildingsResource(plugin,MagicExpansionItems.STONE_1, Material.STONE);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.STONE_2, MagicExpansionItems.STONE_1);
        registerBuildingsResource(plugin,MagicExpansionItems.OAK_LOG_1, Material.OAK_LOG);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.OAK_LOG_2, MagicExpansionItems.OAK_LOG_1);
        registerBuildingsResource(plugin,MagicExpansionItems.STONE_BRICKS_1, Material.STONE_BRICKS);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.STONE_BRICKS_2, MagicExpansionItems.STONE_BRICKS_1);
        registerBuildingsResource(plugin,MagicExpansionItems.BRICKS_1, Material.BRICKS);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.BRICKS_2, MagicExpansionItems.BRICKS_1);
        registerBuildingsResource(plugin,MagicExpansionItems.REDSTONE_1, Material.REDSTONE);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.REDSTONE_2, MagicExpansionItems.REDSTONE_1);
        registerBuildingsResource(plugin,MagicExpansionItems.REDSTONE_TORCH_1, Material.REDSTONE_TORCH);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.REDSTONE_TORCH_2, MagicExpansionItems.REDSTONE_TORCH_1);
        registerBuildingsResource(plugin,MagicExpansionItems.REPEATER_1, Material.REPEATER);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.REPEATER_2, MagicExpansionItems.REPEATER_1);
        registerBuildingsResource(plugin,MagicExpansionItems.COMPARATOR_1, Material.COMPARATOR);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.COMPARATOR_2, MagicExpansionItems.COMPARATOR_1);
        registerBuildingsResource(plugin,MagicExpansionItems.HOPPER_1, Material.HOPPER);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.HOPPER_2, MagicExpansionItems.HOPPER_1);
        registerBuildingsResource(plugin,MagicExpansionItems.STRING_1, Material.STRING);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.STRING_2, MagicExpansionItems.STRING_1);
        registerBuildingsResource(plugin,MagicExpansionItems.TRIPWIRE_HOOK_1, Material.TRIPWIRE_HOOK);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.TRIPWIRE_HOOK_2, MagicExpansionItems.TRIPWIRE_HOOK_1);
        registerBuildingsResource(plugin,MagicExpansionItems.FURNACE_1, Material.FURNACE);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.FURNACE_2, MagicExpansionItems.FURNACE_1);
        registerBuildingsResource(plugin,MagicExpansionItems.IRON_INGOT_1, Material.IRON_INGOT);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.IRON_INGOT_2, MagicExpansionItems.IRON_INGOT_1);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.IRON_INGOT_3, MagicExpansionItems.IRON_INGOT_2);
        registerBuildingsResource(plugin,MagicExpansionItems.GLASS_1, Material.GLASS);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.GLASS_2, MagicExpansionItems.GLASS_1);
        registerBuildingsResource(plugin,MagicExpansionItems.LIGHT_1, Material.LIGHT);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.LIGHT_2, MagicExpansionItems.LIGHT_1);
        registerBuildingsResource(plugin,MagicExpansionItems.QUARTZ_BLOCK_1, Material.QUARTZ_BLOCK);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.QUARTZ_BLOCK_2, MagicExpansionItems.QUARTZ_BLOCK_1);
        new UnplaceableBlock(
                magicexpansionprebuildingresource,
                MagicExpansionItems.COLOR_WOOL_1,
                PRE_BUILDINGS_MACHINE_RESOURCE_ADVANCED,
                new ItemStack[] {
                        null, new ItemStack(Material.WHITE_DYE,64), null,
                        new ItemStack(Material.RED_DYE,64), new ItemStack(Material.WHITE_WOOL,64), new ItemStack(Material.YELLOW_DYE,64),
                        null, new ItemStack(Material.BLUE_DYE,64), null
                }
        ).register(plugin);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.COLOR_WOOL_2, MagicExpansionItems.COLOR_WOOL_1);

        new UnplaceableBlock(
                magicexpansionprebuildingresource,
                MagicExpansionItems.COLOR_TERRACOTTA_1,
                PRE_BUILDINGS_MACHINE_RESOURCE_ADVANCED,
                new ItemStack[] {
                        null, new ItemStack(Material.WHITE_DYE,64), null,
                        new ItemStack(Material.RED_DYE,64), new ItemStack(Material.WHITE_TERRACOTTA,64), new ItemStack(Material.YELLOW_DYE,64),
                        null, new ItemStack(Material.BLUE_DYE,64), null
                }
        ).register(plugin);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.COLOR_TERRACOTTA_2, MagicExpansionItems.COLOR_TERRACOTTA_1);

        new UnplaceableBlock(
                magicexpansionprebuildingresource,
                MagicExpansionItems.COLOR_CONCRETE_1,
                PRE_BUILDINGS_MACHINE_RESOURCE_ADVANCED,
                new ItemStack[] {
                        null, new ItemStack(Material.WHITE_DYE,64), null,
                        new ItemStack(Material.RED_DYE,64), new ItemStack(Material.WHITE_CONCRETE,64), new ItemStack(Material.YELLOW_DYE,64),
                        null, new ItemStack(Material.BLUE_DYE,64), null
                }
        ).register(plugin);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.COLOR_CONCRETE_2, MagicExpansionItems.COLOR_CONCRETE_1);

        new UnplaceableBlock(
                magicexpansionprebuildingresource,
                MagicExpansionItems.COLOR_GLAZED_TERRACOTTA_1,
                PRE_BUILDINGS_MACHINE_RESOURCE_ADVANCED,
                new ItemStack[] {
                        null, new ItemStack(Material.WHITE_DYE,64), null,
                        new ItemStack(Material.RED_DYE,64), new ItemStack(Material.WHITE_GLAZED_TERRACOTTA,64), new ItemStack(Material.YELLOW_DYE,64),
                        null, new ItemStack(Material.BLUE_DYE,64), null
                }
        ).register(plugin);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.COLOR_GLAZED_TERRACOTTA_2, MagicExpansionItems.COLOR_GLAZED_TERRACOTTA_1);





        //幻翼抑制器
        new EntityKillMachine(magicexpansionenergy, MagicExpansionItems.PHANTON_SUPPRESSION, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT,new ItemStack(Material.PHANTOM_MEMBRANE), MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.LIGHT_ENERGY_ALPHA,MagicExpansionItems.AMETHYST_SHARD,
                MagicExpansionItems.OAK_PLANKS,MagicExpansionItems.INFINITY_FLINT_AND_STEEL,MagicExpansionItems.OAK_PLANKS
        },1314,260, EntityType.PHANTOM, "幻翼").register(plugin);








        //木头发生器
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


        //光源发生器
        new ResourceMachine(magicexpansionresourcegenerator, MagicExpansionItems.LIGHT_GEN_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT,SlimefunItems.BIG_CAPACITOR,MagicExpansionItems.AMETHYST_SHARD,
                MagicExpansionItems.GOLD_INGOT,MagicExpansionItems.LIGHT_CORE,MagicExpansionItems.GOLD_INGOT,
                MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.CORE_ORIGIN,MagicExpansionItems.ELEMENT_INGOT
        })
                .setCraftSecond(16)
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .setItemStackOutputs(new ItemStack[] {new ItemStack(Material.LIGHT,1),new ItemStack(Material.LIGHT,2),new ItemStack(Material.LIGHT,3),
                        new ItemStack(Material.LIGHT,4),new ItemStack(Material.LIGHT,5),new ItemStack(Material.LIGHT,6),
                        new ItemStack(Material.LIGHT,7),
                })
                .register(plugin);

        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_QUARTZ_BASIC, MagicExpansionItems.QUARTZ, Material.QUARTZ_BLOCK,1);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_AMETHYST_SHARD_BASIC, MagicExpansionItems.AMETHYST_SHARD, Material.AMETHYST_SHARD);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_REDSTONE_BASIC, MagicExpansionItems.REDSTONE, Material.REDSTONE);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_DIAMOND_BASIC, MagicExpansionItems.DIAMOND, Material.DIAMOND);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_LAPIS_LAZULI_BASIC, MagicExpansionItems.LAPIS_LAZULI, Material.LAPIS_LAZULI);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_EMERALD_BASIC, MagicExpansionItems.EMERALD, Material.EMERALD);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_COAL_BASIC, MagicExpansionItems.COAL, Material.COAL);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_NETHERITE_SCRAP_BASIC, MagicExpansionItems.NETHERITE_INGOT, Material.NETHERITE_SCRAP,1);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_IRON_DUST_BASIC, MagicExpansionItems.IRON_INGOT, SlimefunItems.IRON_DUST);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_GOLD_DUST_BASIC, MagicExpansionItems.GOLD_INGOT, SlimefunItems.GOLD_DUST);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_COPPER_DUST_BASIC, MagicExpansionItems.COPPER_INGOT, SlimefunItems.COPPER_DUST);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_TIN_DUST_BASIC, MagicExpansionItems.TIN_INGOT, SlimefunItems.TIN_DUST);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_SILVER_DUST_BASIC, MagicExpansionItems.SILVER_INGOT, SlimefunItems.SILVER_DUST);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_LEAD_DUST_BASIC, MagicExpansionItems.LEAD_INGOT, SlimefunItems.LEAD_DUST);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_ALUMINUM_DUST_BASIC, MagicExpansionItems.ALUMINUM_INGOT, SlimefunItems.ALUMINUM_DUST);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_ZINC_DUST_BASIC, MagicExpansionItems.ZINC_INGOT, SlimefunItems.ZINC_DUST);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_MAGNESIUM_DUST_BASIC, MagicExpansionItems.MAGNESIUM_INGOT, SlimefunItems.MAGNESIUM_DUST);


        //矿锭x9
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_IRON_INGOT_BASIC, MagicExpansionItems.MINE_MAN_IRON_DUST_BASIC, Material.IRON_INGOT,1,1,1);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_GOLD_INGOT_BASIC, MagicExpansionItems.MINE_MAN_GOLD_DUST_BASIC, Material.GOLD_INGOT,1,1,1);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_COPPER_INGOT_BASIC, MagicExpansionItems.MINE_MAN_COPPER_DUST_BASIC, SlimefunItems.COPPER_INGOT,1,1);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_TIN_INGOT_BASIC, MagicExpansionItems.MINE_MAN_TIN_DUST_BASIC, SlimefunItems.TIN_INGOT,1,1);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_SILVER_INGOT_BASIC, MagicExpansionItems.MINE_MAN_SILVER_DUST_BASIC, SlimefunItems.SILVER_INGOT,1,1);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_LEAD_INGOT_BASIC, MagicExpansionItems.MINE_MAN_LEAD_DUST_BASIC, SlimefunItems.LEAD_INGOT,1,1);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_ALUMINUM_INGOT_BASIC, MagicExpansionItems.MINE_MAN_ALUMINUM_DUST_BASIC, SlimefunItems.ALUMINUM_INGOT,1,1);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_ZINC_INGOT_BASIC, MagicExpansionItems.MINE_MAN_ZINC_DUST_BASIC, SlimefunItems.ZINC_INGOT,1,1);
        registerBasicElectricMan(plugin, MagicExpansionItems.MINE_MAN_MAGNESIUM_INGOT_BASIC, MagicExpansionItems.MINE_MAN_MAGNESIUM_DUST_BASIC, SlimefunItems.MAGNESIUM_INGOT,1,1);

        //下界合金锭
        new ResourceMachine(magicexpansionelectricbot, MagicExpansionItems.MINE_MAN_NETHERITE_INGOT_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.MINE_MAN_GOLD_INGOT_BASIC,new ItemStack(Material.CRAFTING_TABLE),MagicExpansionItems.MINE_MAN_NETHERITE_SCRAP_BASIC,
                null,null,null,
                null,null,null
        })
                .setCraftSecond(2)
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .setItemStackOutputs(new ItemStack[] {new ItemStack(Material.NETHERITE_INGOT,2),new ItemStack(Material.NETHERRACK,12)
                        ,new ItemStack(Material.FLINT,2),new ItemStack(Material.BONE_BLOCK),new ItemStack(Material.CLAY,2)})
                .register(plugin);





        //木头转换机
        new RecipeMachine(magicexpansionrecipemachine, MagicExpansionItems.WOOD_TRANSFORM_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT,SlimefunItems.BIG_CAPACITOR,MagicExpansionItems.AMETHYST_SHARD,
                MagicExpansionItems.DIRT,MagicExpansionItems.LOG_MIX,MagicExpansionItems.BONE_MEAL,
                MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.CORE_ORIGIN,MagicExpansionItems.ELEMENT_INGOT
        })
                .setCapacity(1314)
                .setConsumption(26)
                .setProcessingSpeed(1)
                .addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.OAK_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.SPRUCE_LOG,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.SPRUCE_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.BIRCH_LOG,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.BIRCH_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.JUNGLE_LOG,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.JUNGLE_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.ACACIA_LOG,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.ACACIA_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.DARK_OAK_LOG,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.DARK_OAK_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.MANGROVE_LOG,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.MANGROVE_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.CHERRY_LOG,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.CHERRY_LOG,16)},
                        new ItemStack[] {new ItemStack(Material.OAK_LOG,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.OAK_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.SPRUCE_LEAVES,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.SPRUCE_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.BIRCH_LEAVES,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.BIRCH_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.JUNGLE_LEAVES,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.JUNGLE_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.ACACIA_LEAVES,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.ACACIA_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.DARK_OAK_LEAVES,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.DARK_OAK_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.MANGROVE_LEAVES,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.MANGROVE_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.CHERRY_LEAVES,16)}).addRecipe(4,
                        new ItemStack[] {new ItemStack(Material.CHERRY_LEAVES,16)},
                        new ItemStack[] {new ItemStack(Material.OAK_LEAVES,16)})
                .register(plugin);

        //光能激发器
        new RecipeMachine(magicexpansionrecipemachine, MagicExpansionItems.LIGHT_TRANSFORM_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT,SlimefunItems.BIG_CAPACITOR,MagicExpansionItems.QUARTZ,
                MagicExpansionItems.ALUMINUM_INGOT,MagicExpansionItems.LIGHT_CORE,MagicExpansionItems.LEAD_INGOT,
                MagicExpansionItems.QUARTZ,MagicExpansionItems.CORE_ORIGIN,MagicExpansionItems.ELEMENT_INGOT
        })
                .setCapacity(1314)
                .setConsumption(26)
                .setProcessingSpeed(1)
                .addRecipe(5, new ItemStack[] {new ItemStack(Material.LIGHT,32),MagicExpansionItems.MAGNESIUM_INGOT},
                        new ItemStack[] {MagicExpansionItems.LIGHT_ENERGY_ALPHA})
                .register(plugin);

        //光能溯源器
        new RecipeMachine(magicexpansionrecipemachine, MagicExpansionItems.LIGHT_EXTRACT_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.OAK_PLANKS,SlimefunItems.BIG_CAPACITOR,MagicExpansionItems.OAK_PLANKS,
                MagicExpansionItems.GOLD_INGOT,MagicExpansionItems.LIGHT_CORE,MagicExpansionItems.SILVER_INGOT,
                MagicExpansionItems.OAK_PLANKS,MagicExpansionItems.CORE_ORIGIN,MagicExpansionItems.OAK_PLANKS
        })
                .setCapacity(1314)
                .setConsumption(26)
                .setProcessingSpeed(1)
                .addRecipe(4, new ItemStack[] {new ItemStack(Material.GLOWSTONE,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,8)}).addRecipe(1, new ItemStack[] {new ItemStack(Material.SEA_LANTERN,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,12)}).addRecipe(4, new ItemStack[] {new ItemStack(Material.REDSTONE_LAMP,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,10)}).addRecipe(4, new ItemStack[] {new ItemStack(Material.END_ROD,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,4)}).addRecipe(5, new ItemStack[] {new ItemStack(Material.SOUL_LANTERN,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,3)}).addRecipe(5, new ItemStack[] {new ItemStack(Material.LANTERN,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,2)}).addRecipe(8, new ItemStack[] {new ItemStack(Material.REDSTONE_TORCH,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,1)}).addRecipe(8, new ItemStack[] {new ItemStack(Material.TORCH,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,1)}).addRecipe(8, new ItemStack[] {new ItemStack(Material.SOUL_TORCH,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,2)}).addRecipe(4, new ItemStack[] {new ItemStack(Material.SHROOMLIGHT,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,5)}).addRecipe(5, new ItemStack[] {new ItemStack(Material.OCHRE_FROGLIGHT,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,9)}).addRecipe(5, new ItemStack[] {new ItemStack(Material.VERDANT_FROGLIGHT,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,9)}).addRecipe(5, new ItemStack[] {new ItemStack(Material.PEARLESCENT_FROGLIGHT,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,9)}).addRecipe(5, new ItemStack[] {new ItemStack(Material.CRYING_OBSIDIAN,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,1)}).addRecipe(6, new ItemStack[] {new ItemStack(Material.MAGMA_BLOCK,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,1)}).addRecipe(5, new ItemStack[] {new ItemStack(Material.CAMPFIRE,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,3)}).addRecipe(5, new ItemStack[] {new ItemStack(Material.SOUL_CAMPFIRE,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,6)}).addRecipe(5, new ItemStack[] {new ItemStack(Material.END_CRYSTAL,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,6)}).addRecipe(2, new ItemStack[] {new ItemStack(Material.BEACON,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,9)}).addRecipe(5, new ItemStack[] {new ItemStack(Material.REDSTONE_ORE,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,2)}).addRecipe(5, new ItemStack[] {new ItemStack(Material.DEEPSLATE_REDSTONE_ORE,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,2)}).addRecipe(7, new ItemStack[] {new ItemStack(Material.SMALL_AMETHYST_BUD,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,1)}).addRecipe(7, new ItemStack[] {new ItemStack(Material.MEDIUM_AMETHYST_BUD,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,2)}).addRecipe(6, new ItemStack[] {new ItemStack(Material.LARGE_AMETHYST_BUD,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,3)}).addRecipe(5, new ItemStack[] {new ItemStack(Material.AMETHYST_CLUSTER,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,4)}).addRecipe(7, new ItemStack[] {new ItemStack(Material.TORCHFLOWER,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,2)}).addRecipe(7, new ItemStack[] {new ItemStack(Material.SEA_PICKLE,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,2)}).addRecipe(4, new ItemStack[] {new ItemStack(Material.NETHER_STAR,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,7)}).addRecipe(7, new ItemStack[] {new ItemStack(Material.GLISTERING_MELON_SLICE,1)},
                        new ItemStack[] {new ItemStack(Material.LIGHT,2)})
                .register(plugin);


        //魔法建筑工坊
        new RecipeMachine(magicexpansionenergy, MagicExpansionItems.PRE_BUILDINGS_MACHINE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT,SlimefunItems.BIG_CAPACITOR,MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.CORE_ORIGIN,MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.OAK_PLANKS,MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.OAK_PLANKS
        })
                .setCapacity(1314)
                .setConsumption(26)
                .setProcessingSpeed(1)
                .addRecipe(5, new ItemStack[] {new ItemStack(Material.OAK_SAPLING),MagicExpansionItems.BONE_MEAL},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_OAK_TREE})
                .addRecipe(5, new ItemStack[] {new ItemStack(Material.SPRUCE_SAPLING),MagicExpansionItems.BONE_MEAL},
                        new ItemStack[]{MagicExpansionItems.PRE_BUILDING_SPRUCE_TREE})
                .addRecipe(5, new ItemStack[] {new ItemStack(Material.BIRCH_SAPLING),MagicExpansionItems.BONE_MEAL},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_BIRCH_TREE})
                .addRecipe(5, new ItemStack[] {new ItemStack(Material.JUNGLE_SAPLING),MagicExpansionItems.BONE_MEAL},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_JUNGLE_TREE})
                .addRecipe(5, new ItemStack[] {new ItemStack(Material.ACACIA_SAPLING),MagicExpansionItems.BONE_MEAL},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_ACACIA_TREE})
                .addRecipe(5, new ItemStack[] {new ItemStack(Material.DARK_OAK_SAPLING),MagicExpansionItems.BONE_MEAL},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_DARK_OAK_TREE})
                .addRecipe(5, new ItemStack[] {new ItemStack(Material.MANGROVE_PROPAGULE),MagicExpansionItems.BONE_MEAL},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_MANGROVE_TREE})
                .addRecipe(5, new ItemStack[] {new ItemStack(Material.CHERRY_SAPLING),MagicExpansionItems.BONE_MEAL},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_CHERRY_TREE})
                .addRecipe(5, new ItemStack[] {MagicExpansionItems.REDSTONE_1,sfItemAmount(MagicExpansionItems.IRON_INGOT_1,2),MagicExpansionItems.OAK_LOG_1,
                                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COLOR_WOOL_1,MagicExpansionItems.COLOR_CONCRETE_1,
                                MagicExpansionItems.COLOR_TERRACOTTA_1},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_TAFEI})
                .register(plugin);

        var sf1 = SlimefunItem.getByItem(SlimefunItems.SILICON);
        var itemStack1 = new ItemStack(sf1.getItem().getType());
        itemStack1.setItemMeta(sf1.getItem().getItemMeta());
        itemStack1.setAmount(2);


        //纯净硅源机
        new RecipeMachine(magicexpansionrecipemachine, MagicExpansionItems.QUARTZ_PURE_MACHINE_BAISC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT,SlimefunItems.BIG_CAPACITOR,MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.QUARTZ_CORE,MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.AMETHYST_SHARD
        })
                .setCapacity(1314)
                .setConsumption(26)
                .setProcessingSpeed(1)
                .addRecipe(3, new ItemStack[] {MagicExpansionItems.GOLD_INGOT}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,2), sfItemAmount(SlimefunItems.SILICON,2)})
                .addRecipe(3, new ItemStack[] {MagicExpansionItems.IRON_INGOT}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,2), sfItemAmount(SlimefunItems.SILICON,2)})
                .addRecipe(3, new ItemStack[] {MagicExpansionItems.COPPER_INGOT}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,2), sfItemAmount(SlimefunItems.SILICON,2)})
                .addRecipe(3, new ItemStack[] {MagicExpansionItems.LEAD_INGOT}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,2), sfItemAmount(SlimefunItems.SILICON,2)})
                .addRecipe(3, new ItemStack[] {MagicExpansionItems.TIN_INGOT}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,2), sfItemAmount(SlimefunItems.SILICON,2)})
                .addRecipe(3, new ItemStack[] {MagicExpansionItems.SILVER_INGOT}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,2), sfItemAmount(SlimefunItems.SILICON,2)})
                .addRecipe(3, new ItemStack[] {MagicExpansionItems.ZINC_INGOT}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,2), sfItemAmount(SlimefunItems.SILICON,2)})
                .addRecipe(3, new ItemStack[] {MagicExpansionItems.ALUMINUM_INGOT}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,2), sfItemAmount(SlimefunItems.SILICON,2)})
                .addRecipe(3, new ItemStack[] {MagicExpansionItems.MAGNESIUM_INGOT}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,2), sfItemAmount(SlimefunItems.SILICON,2)})
                .addRecipe(3, new ItemStack[] {MagicExpansionItems.ELEMENT_INGOT}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,18), sfItemAmount(SlimefunItems.SILICON,18)})
                .addRecipe(9, new ItemStack[] {SlimefunItems.GOLD_4K},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK)}).addRecipe(9, new ItemStack[] {new ItemStack(Material.GOLD_INGOT)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK)}).addRecipe(9, new ItemStack[] {new ItemStack(Material.IRON_INGOT)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK)}).addRecipe(9, new ItemStack[] {new ItemStack(Material.COPPER_INGOT)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK)}).addRecipe(9, new ItemStack[] {SlimefunItems.COPPER_INGOT},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK)}).addRecipe(9, new ItemStack[] {SlimefunItems.LEAD_INGOT},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK)}).addRecipe(9, new ItemStack[] {SlimefunItems.TIN_INGOT},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK)}).addRecipe(9, new ItemStack[] {SlimefunItems.SILVER_INGOT},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK)}).addRecipe(9, new ItemStack[] {SlimefunItems.ZINC_INGOT},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK)}).addRecipe(9, new ItemStack[] {SlimefunItems.ALUMINUM_INGOT},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK)}).addRecipe(9, new ItemStack[] {SlimefunItems.MAGNESIUM_INGOT},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK)})
                .register(plugin);







        // 预制树-说明
        new UnplaceableBlock(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_TREE_INFO, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null,null,null,
                null,null,null,
                null,null,null
        }).register(plugin);

        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_OAK_TREE, "oak_tree", "OAK", "OAK",1, new ItemStack(Material.OAK_SAPLING));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_SPRUCE_TREE, "oak_tree", "OAK", "SPRUCE", 1, new ItemStack(Material.SPRUCE_SAPLING));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_BIRCH_TREE, "oak_tree", "OAK", "BIRCH", 1, new ItemStack(Material.BIRCH_SAPLING));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_JUNGLE_TREE, "oak_tree", "OAK", "JUNGLE", 1, new ItemStack(Material.JUNGLE_SAPLING));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_ACACIA_TREE, "oak_tree", "OAK", "ACACIA", 1, new ItemStack(Material.ACACIA_SAPLING));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_DARK_OAK_TREE, "oak_tree", "OAK", "DARK_OAK", 1, new ItemStack(Material.DARK_OAK_SAPLING));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_MANGROVE_TREE, "oak_tree", "OAK", "MANGROVE", 1, new ItemStack(Material.MANGROVE_PROPAGULE));
        registerPreBuildingTree(plugin, MagicExpansionItems.PRE_BUILDING_CHERRY_TREE, "oak_tree", "OAK", "CHERRY", 1, new ItemStack(Material.CHERRY_SAPLING));

        // 预制建筑-村民爱与交易所
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_TAFEI, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                MagicExpansionItems.REDSTONE_1,sfItemAmount(MagicExpansionItems.IRON_INGOT_1,2),MagicExpansionItems.OAK_LOG_1,
                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COLOR_WOOL_1,MagicExpansionItems.COLOR_CONCRETE_1,
                MagicExpansionItems.COLOR_TERRACOTTA_1,null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"tafei",60).register(plugin);



        // 预制建筑-村民爱与交易所
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_VILLAGE_LOVE_AND_TRADE_HOUSE, PRE_BUILDINGS_MACHINE_ADVANCED, new ItemStack[] {
                MagicExpansionItems.STONE_2,MagicExpansionItems.IRON_INGOT_2,sfItemAmount(MagicExpansionItems.OAK_LOG_1,16),
                sfItemAmount(MagicExpansionItems.REDSTONE_1,5),MagicExpansionItems.GLASS_1,MagicExpansionItems.COLOR_WOOL_1
                ,MagicExpansionItems.SPACE_INFINITY_MAGIC,null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"village_love_trade_house",60*60*12).register(plugin);
        // 预制建筑-潜影贝农场
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_SHULKER_FARM, PRE_BUILDINGS_MACHINE_ADVANCED, new ItemStack[] {
                MagicExpansionItems.STONE_2,MagicExpansionItems.IRON_INGOT_1,sfItemAmount(MagicExpansionItems.OAK_LOG_1,16),
                MagicExpansionItems.REDSTONE_1,MagicExpansionItems.COBBLESTONE_1,MagicExpansionItems.HOPPER_1,
                new ItemStack(Material.STRING,15),MagicExpansionItems.SPACE_INFINITY_MAGIC,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"shulker_farm",60*60*12).register(plugin);

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

    //粘液物品
    private static void  registerBasicElectricMan(
            MagicExpansion plugin,
            SlimefunItemStack item,
            SlimefunItemStack angle,
            SlimefunItemStack output
    ){


        //电力矿工-输出
        new ResourceMachine(
                magicexpansionelectricbot,
                item,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        angle,SlimefunItems.PROGRAMMABLE_ANDROID_3,angle,
                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER,MagicExpansionItems.MAGIC_EXPANSION_MINERAL_CAVE,SlimefunItems.PROGRAMMABLE_ANDROID_MINER,
                        MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.ELEMENT_INGOT
        })
                .setCraftSecond(2)
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .setItemStackOutputs(new ItemStack[] {sfItemAmount(output,8),new ItemStack(Material.COBBLESTONE,6)
                ,new ItemStack(Material.FLINT,2),new ItemStack(Material.BONE),new ItemStack(Material.CLAY,2)})
                .register(plugin);
    }
    //原版物品
    private static void  registerBasicElectricMan(
            MagicExpansion plugin,
            SlimefunItemStack item,
            SlimefunItemStack angle,
            Material output
    ){


        //电力矿工-输出
        new ResourceMachine(
                magicexpansionelectricbot,
                item,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        angle,SlimefunItems.PROGRAMMABLE_ANDROID_3,angle,
                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER,MagicExpansionItems.MAGIC_EXPANSION_MINERAL_CAVE,SlimefunItems.PROGRAMMABLE_ANDROID_MINER,
                        MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.ELEMENT_INGOT
                })
                .setCraftSecond(2)
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .setItemStackOutputs(new ItemStack[] {new ItemStack(output,6),new ItemStack(Material.COBBLESTONE,6)
                        ,new ItemStack(Material.FLINT,2),new ItemStack(Material.BONE),new ItemStack(Material.CLAY,2)})
                .register(plugin);
    }

    //矿锭-粘液
    private static void  registerBasicElectricMan(
            MagicExpansion plugin,
            SlimefunItemStack item,
            SlimefunItemStack angle,
            SlimefunItemStack output,
            int none,
            int ingotsf
    ){


        //电力矿工-输出
        new ResourceMachine(
                magicexpansionelectricbot,
                item,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        angle,MagicExpansionItems.INFINITY_FLINT_AND_STEEL,null,
                        null,null,null,
                        null,null,null
                })
                .setCraftSecond(2)
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .setItemStackOutputs(new ItemStack[] {sfItemAmount(output,8),new ItemStack(Material.COBBLESTONE,6)
                        ,new ItemStack(Material.FLINT,2),new ItemStack(Material.BONE),new ItemStack(Material.CLAY,2)})
                .register(plugin);
    }
    //矿锭-原版
    private static void  registerBasicElectricMan(
            MagicExpansion plugin,
            SlimefunItemStack item,
            SlimefunItemStack angle,
            Material output,
            int none,
            int none1,
            int ingotVanilla
    ){


        //电力矿工-输出
        new ResourceMachine(
                magicexpansionelectricbot,
                item,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        angle,MagicExpansionItems.INFINITY_FLINT_AND_STEEL,null,
                        null,null,null,
                        null,null,null
                })
                .setCraftSecond(2)
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .setItemStackOutputs(new ItemStack[] {new ItemStack(output,6),new ItemStack(Material.COBBLESTONE,6)
                        ,new ItemStack(Material.FLINT,2),new ItemStack(Material.BONE),new ItemStack(Material.CLAY,2)})
                .register(plugin);
    }

    //下届-原版
    private static void  registerBasicElectricMan(
            MagicExpansion plugin,
            SlimefunItemStack item,
            SlimefunItemStack angle,
            Material output,
            int nether
    ){


        //电力矿工-输出
        new ResourceMachine(
                magicexpansionelectricbot,
                item,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        angle,SlimefunItems.PROGRAMMABLE_ANDROID_3,angle,
                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER,MagicExpansionItems.MAGIC_EXPANSION_MINERAL_CAVE,SlimefunItems.PROGRAMMABLE_ANDROID_MINER,
                        MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.ELEMENT_INGOT
                })
                .setCraftSecond(2)
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .setItemStackOutputs(new ItemStack[] {new ItemStack(output,6),new ItemStack(Material.NETHERRACK,6)
                        ,new ItemStack(Material.SOUL_SAND,2),new ItemStack(Material.BONE_BLOCK),new ItemStack(Material.GOLD_NUGGET,2)})
                .register(plugin);
    }



    // 注册预制树General
    private static void registerVanResource(
            MagicExpansion plugin,
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
            MagicExpansion plugin,
            SlimefunItemStack treeItem,
            String baseTreeKey,
            String baseTreeType,
            String treeType,
            long timeCd,
            ItemStack tree) {

        new PreBuildingTree(
                magicexpansionprebuilding,
                treeItem,
                PRE_BUILDINGS_MACHINE,
                new ItemStack[] {
                        MagicExpansionItems.BONE_MEAL, tree, null,
                        null, null, null,
                        null, null, null
                },
                baseTreeKey,
                baseTreeType,
                treeType.toUpperCase(),
                timeCd
        ).register(plugin);
    }


    private static void registerBuildingsResource(
            MagicExpansion plugin,
            SlimefunItemStack item,
            Material material
    ){
        new UnplaceableBlock(
                magicexpansionprebuildingresource,
                item,
                PRE_BUILDINGS_MACHINE_RESOURCE_ADVANCED,
                new ItemStack[] {
                        new ItemStack(material,64), null, null,
                        null, null, null,
                        null, null, null
                }
        ).register(plugin);
    }
    private static void registerBuildingsResourceSf(
            MagicExpansion plugin,
            SlimefunItemStack item,
            SlimefunItemStack itemInput
    ){
        new UnplaceableBlock(
                magicexpansionprebuildingresource,
                item,
                PRE_BUILDINGS_MACHINE_RESOURCE_ADVANCED,
                new ItemStack[] {
                        new SlimefunItemStack(itemInput,64), null, null,
                        null, null, null,
                        null, null, null
                }
        ).register(plugin);
    }


}
