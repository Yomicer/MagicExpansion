package io.Yomicer.magicExpansion.core;

import io.Yomicer.magicExpansion.utils.CustomHeadUtils.CustomHead;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.Material;

import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;
import static io.Yomicer.magicExpansion.utils.Utils.doGlow;
import static io.Yomicer.magicExpansion.utils.itemUtils.newItem.themed;
import static io.Yomicer.magicExpansion.utils.Language.get;
import static io.Yomicer.magicExpansion.utils.Language.getList;


public class MagicExpansionItems {




    private MagicExpansionItems(){
    }
    //INFO
    public static final SlimefunItemStack MAGIC_EXPANSION_INFO = new SlimefunItemStack(
            "MAGIC_EXPANSION_INFO",
            Material.PAPER,
            getGradientName("信息"),
            "",
            getGradientName("Version: Build 2"),
            getGradientName("您在提issues的时候需要展示这个")
    );
    //AUTHOR
    public static final SlimefunItemStack MAGIC_EXPANSION_AUTHOR = new SlimefunItemStack(
            "MAGIC_EXPANSION_AUTHOR",
            "8adb25ab9976d89d0bd8118d72c1c06bb907060c1e02a729b652d1e86b1ebbbc",
            getGradientName("开发者：magicsolo"),
            "",
            getGradientName("Github: Yomicer"),
            getGradientName("Author of MagicExpansion")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_MACHINE_INFO = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_MACHINE_INFO",
            Material.PAPER,
            getGradientName("快捷机器提示"),
            "",
            getGradientName("支持几乎所有的配方"),
            getGradientName("对原版配方进行了合理化修改"),
            getGradientName("修改后的配方将作为机器彩蛋呈现")
    );


    //材料
    public static final SlimefunItemStack MAGIC_EXPANSION_TO_MAGIC_ITEM_BASIC = new SlimefunItemStack(
            "MAGIC_EXPANSION_TO_MAGIC_ITEM_ITEM_BASIC",
            Material.BARRIER,
            getGradientName("初级万能魔法合成材料"),
            "",
            getGradientName("用来修补没有安装魔法附属的问题")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED = new SlimefunItemStack(
            "MAGIC_EXPANSION_TO_MAGIC_ITEM_ADVANCED",
            Material.STRUCTURE_VOID,
            getGradientName("进阶万能魔法合成材料"),
            "",
            getGradientName("用来修补没有安装魔法附属的问题")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_INTERACTIVE_CORE = new SlimefunItemStack(
            "MAGIC_EXPANSION_INTERACTIVE_CORE",
            Material.CHAIN_COMMAND_BLOCK,
            getGradientName("魔法交互核心"),
            "",
            getGradientName("负责快捷机器的交互")
    );


    // 工具
    public static final SlimefunItemStack SCYTHE = new SlimefunItemStack(
            "MAGIC_EXPANSION_SCYTHE",
            "8adb25ab9976d89d0bd8118d72c1c06bb907060c1e02a729b652d1e86b1ebbbc",
            getGradientName("改良版镰刀"),
            "",
            "&7Test Skull_Hash",
            "&7一次性打破5个成熟的农作物",
            "&7由Fluffy Machine的镰刀改良而来",
            "&7不再会连锁破坏未成熟的农作物"
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_RANDOM_SPAWNER = new SlimefunItemStack(
            "MAGIC_EXPANSION_RANDOM_SPAWNER",
            doGlow(Material.ENDER_PEARL),
            getGradientName("随机实体蛋"),
            "",
            getGradientName("右键召唤一个随机实体")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_MINERAL_CAVE = new SlimefunItemStack(
            "MAGIC_EXPANSION_MINERAL_CAVE",
            doGlow(Material.SMOOTH_STONE),
            getGradientName("魔法矿洞"),
            "",
            getGradientName("右键打开魔法矿洞"),
            getGradientName("点击石头处，即可挖掘")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_ENHANCED_CRAFTING_TABLE = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_ENHANCED_CRAFTING_TABLE",
            doGlow(Material.CRAFTING_TABLE),
            getGradientName("魔法工作台（增强型工作台）"),
            "",
            getGradientName("右键打开魔法工作台"),
            getGradientName("可以对背包内的材料进行快速合成")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_SMELTERY = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_SMELTERY",
            doGlow(Material.BLAST_FURNACE),
            getGradientName("魔法冶炼炉"),
            "",
            getGradientName("右键打开魔法冶炼炉"),
            getGradientName("可以对背包内的材料进行快速冶炼")
    );
    /*
    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_SMELTERY2 = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_SMELTERY2",
            doGlow(Material.FURNACE),
            getGradientName("魔法冶炼炉-备用配方"),
            "",
            getGradientName("右键打开魔法冶炼炉"),
            getGradientName("可以对背包内的材料进行快速冶炼"),
            getGradientName("右键点击冶炼炉内的物品，查看单次合成所需的材料"),
            getGradientName("左键点击冶炼一次"),
            getGradientName("按住 Shift 并右键点击冶炼炉内的物品，可以一次冶炼32个产物"),
            getGradientName("按住 Shift 并左键点击冶炼炉内的物品，冶炼所有可制作的产物")
    );
    */

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_GRIND_STONE = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_GRIND_STONE",
            doGlow(Material.DISPENSER),
            getGradientName("魔法磨石"),
            "",
            getGradientName("右键打开魔法磨石"),
            getGradientName("可以对背包内的材料进行快速研磨"),
            getGradientName("特殊效果："),
            getGradientName("取消了圆石磨为砂砾，改为磨成石头")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_ORE_CRUSHER = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_ORE_CRUSHER",
            doGlow(Material.IRON_BARS),
            getGradientName("魔法粉碎机"),
            "",
            getGradientName("右键打开魔法粉碎机"),
            getGradientName("可以对背包内的材料进行快速粉碎")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_ARMOR_FORGE = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_ARMOR_FORGE",
            doGlow(Material.ANVIL),
            getGradientName("魔法装备锻造台"),
            "",
            getGradientName("右键打开魔法锻造台"),
            getGradientName("可以对背包内的材料进行快速锻造")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_COMPRESSOR = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_COMPRESSOR",
            doGlow(Material.PISTON),
            getGradientName("魔法压缩机"),
            "",
            getGradientName("右键打开魔法压缩机"),
            getGradientName("可以对背包内的材料进行快速压缩")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_PRESSURE_CHAMBER = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_PRESSURE_CHAMBER",
            doGlow(Material.GLASS),
            getGradientName("魔法压力机"),
            "",
            getGradientName("右键打开魔法压力机"),
            getGradientName("可以对背包内的材料进行快速合成")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_MAGIC_WORKBENCH = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_MAGIC_WORKBENCH",
            doGlow(Material.BOOKSHELF),
            getGradientName("魔法工作台（魔法工作台）"),
            "",
            getGradientName("右键打开魔法工作台"),
            getGradientName("可以对背包内的材料进行快速合成")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_AUTOMATED_PANNING_MACHINE = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_AUTOMATED_PANNING_MACHINE",
            doGlow(Material.BOWL),
            getGradientName("魔法淘金盘"),
            "",
            getGradientName("右键打开魔法淘金盘"),
            getGradientName("可以对背包内的材料进行快速淘金")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_AUTOMATED_ANCIENT_ALTAR = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_AUTOMATED_ANCIENT_ALTAR",
            doGlow(Material.ENCHANTING_TABLE),
            getGradientName("魔法祭坛"),
            "",
            getGradientName("右键打开魔法祭坛"),
            getGradientName("可以对背包内的材料进行快速合成")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_ELECTRIC_ORE_GRINDER = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_ELECTRIC_ORE_GRINDER",
            doGlow(Material.OBSERVER),
            getGradientName("破损的魔法碎矿机"),
            "",
            getGradientName("右键打开魔法碎矿机"),
            getGradientName("可以对背包内的材料进行快速研磨"),
            getGradientName("目前支持的配方：铁矿，金矿，下界岩，筛矿，已粉碎的矿石，纯矿簇，煤")
    );

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_HEATED_PRESSURE_CHAMBER = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_HEATED_PRESSURE_CHAMBER",
            doGlow(Material.LIGHT_GRAY_STAINED_GLASS),
            getGradientName("魔法压力舱"),
            "",
            getGradientName("右键打开魔法压力舱"),
            getGradientName("可以对背包内的材料进行快速合成")
    );


    public static final SlimefunItemStack QUICK_MACHINE_BV_INFO = themed("QUICK_MACHINE_BV_INFO",doGlow(Material.PAPER),
            get("Items.QUICK_MACHINE_BV_INFO.Name"),getList("Items.QUICK_MACHINE_BV_INFO.Lore"));

    public static final SlimefunItemStack QUICK_ENHANCED_CRAFTING_TABLE_BV = themed("QUICK_ENHANCED_CRAFTING_TABLE_BV",doGlow(Material.CRAFTING_TABLE),
            get("Items.QUICK_ENHANCED_CRAFTING_TABLE_BV.Name"),getList("Items.QUICK_ENHANCED_CRAFTING_TABLE_BV.Lore"));

    public static final SlimefunItemStack QUICK_SMELTERY_BV = themed("QUICK_SMELTERY_BV",doGlow(Material.BLAST_FURNACE),
            get("Items.QUICK_SMELTERY_BV.Name"),getList("Items.QUICK_SMELTERY_BV.Lore"));

    public static final SlimefunItemStack QUICK_GRIND_STONE_BV = themed("QUICK_GRIND_STONE_BV",doGlow(Material.DISPENSER),
            get("Items.QUICK_GRIND_STONE_BV.Name"),getList("Items.QUICK_GRIND_STONE_BV.Lore"));

    public static final SlimefunItemStack QUICK_ORE_CRUSHER_BV = themed("QUICK_ORE_CRUSHER_BV",doGlow(Material.IRON_BARS),
            get("Items.QUICK_ORE_CRUSHER_BV.Name"),getList("Items.QUICK_ORE_CRUSHER_BV.Lore"));

    public static final SlimefunItemStack QUICK_ARMOR_FORGE_BV = themed("QUICK_ARMOR_FORGE_BV",doGlow(Material.ANVIL),
            get("Items.QUICK_ARMOR_FORGE_BV.Name"),getList("Items.QUICK_ARMOR_FORGE_BV.Lore"));

    public static final SlimefunItemStack QUICK_COMPRESSOR_BV = themed("QUICK_COMPRESSOR_BV",doGlow(Material.PISTON),
            get("Items.QUICK_COMPRESSOR_BV.Name"),getList("Items.QUICK_COMPRESSOR_BV.Lore"));

    public static final SlimefunItemStack QUICK_PRESSURE_CHAMBER_BV = themed("QUICK_PRESSURE_CHAMBER_BV",doGlow(Material.GLASS),
            get("Items.QUICK_PRESSURE_CHAMBER_BV.Name"),getList("Items.QUICK_PRESSURE_CHAMBER_BV.Lore"));

    public static final SlimefunItemStack QUICK_MAGIC_WORKBENCH_BV = themed("QUICK_MAGIC_WORKBENCH_BV",doGlow(Material.BOOKSHELF),
            get("Items.QUICK_MAGIC_WORKBENCH_BV.Name"),getList("Items.QUICK_MAGIC_WORKBENCH_BV.Lore"));

    public static final SlimefunItemStack QUICK_AUTOMATED_PANNING_MACHINE_BV = themed("QUICK_AUTOMATED_PANNING_MACHINE_BV",doGlow(Material.GOLD_BLOCK),
            get("Items.QUICK_AUTOMATED_PANNING_MACHINE_BV.Name"),getList("Items.QUICK_AUTOMATED_PANNING_MACHINE_BV.Lore"));

    public static final SlimefunItemStack QUICK_AUTOMATED_ANCIENT_ALTAR_BV = themed("QUICK_AUTOMATED_ANCIENT_ALTAR_BV",doGlow(Material.ENCHANTING_TABLE),
            get("Items.QUICK_AUTOMATED_ANCIENT_ALTAR_BV.Name"),getList("Items.QUICK_AUTOMATED_ANCIENT_ALTAR_BV.Lore"));

    public static final SlimefunItemStack QUICK_ELECTRIC_ORE_GRINDER_BV = themed("QUICK_ELECTRIC_ORE_GRINDER_BV",doGlow(Material.OBSERVER),
            get("Items.QUICK_ELECTRIC_ORE_GRINDER_BV.Name"),getList("Items.QUICK_ELECTRIC_ORE_GRINDER_BV.Lore"));

    public static final SlimefunItemStack QUICK_HEATED_PRESSURE_CHAMBER_BV = themed("QUICK_HEATED_PRESSURE_CHAMBER_BV",doGlow(Material.LIGHT_GRAY_STAINED_GLASS),
            get("Items.QUICK_HEATED_PRESSURE_CHAMBER_BV.Name"),getList("Items.QUICK_HEATED_PRESSURE_CHAMBER_BV.Lore"));







    public static final SlimefunItemStack MAGIC_EXPANSION_ENCHANTING_TABLE = themed("ENCHANTING_TABLE",doGlow(Material.ENCHANTING_TABLE),
            get("Items.ENCHANTING_TABLE.Name"),getList("Items.ENCHANTING_TABLE.Lore"));

    public static final SlimefunItemStack FIRE_ZOMBIE = new SlimefunItemStack(
            "MAGIC_EXPANSION_FIRE_ZOMBIE",
            doGlow(Material.ZOMBIE_SPAWN_EGG),
            getGradientName("烈焰僵尸"),
            "",
            getGradientName("右键召唤烈焰僵尸")
    );

    public static final SlimefunItemStack FIRE_ZOMBIE_MB = new SlimefunItemStack(
            "MAGIC_EXPANSION_FIRE_ZOMBIE_MB",
            doGlow(CustomHead.getHead("b15f3517f28740470e8f51b4d755be159ee65861c05e2f744fb61bfdccd5c0e1")),
            getGradientName("烈焰僵尸[召唤]"),
            "",
            getGradientName("右键点击中心的方块召唤烈焰僵尸")
    );

    public static final SlimefunItemStack BASIC_ENCHANT_STONE = themed("BASIC_ENCHANT_STONE",doGlow(Material.IRON_INGOT),
            get("Items.BASIC_ENCHANT_STONE.Name"),getList("Items.BASIC_ENCHANT_STONE.Lore"));

    public static final SlimefunItemStack MAGIC_EXPANSION_ENCHANTING_TABLE_INFO = themed("ENCHANTING_TABLE_INFO",doGlow(Material.PAPER),
            get("Items.ENCHANTING_TABLE_INFO.Name"),getList("Items.ENCHANTING_TABLE_INFO.Lore"));

    public static final SlimefunItemStack MAGIC_EXPANSION_ENCHANTING_TABLE_LIST = themed("ENCHANTING_TABLE_LIST",doGlow(Material.PAPER),
            get("Items.ENCHANTING_TABLE_LIST.Name"),getList("Items.ENCHANTING_TABLE_LIST.Lore"));

    public static final SlimefunItemStack FIREZOMBIE_HEAD = themed("FIREZOMBIE_HEAD", CustomHead.getHead("b15f3517f28740470e8f51b4d755be159ee65861c05e2f744fb61bfdccd5c0e1"),
            get("Items.FIREZOMBIE_HEAD.Name"),getList("Items.FIREZOMBIE_HEAD.Lore"));

    public static final SlimefunItemStack FIREZOMBIE_BODY = themed("FIREZOMBIE_BODY",Material.MOSS_BLOCK,
            get("Items.FIREZOMBIE_BODY.Name"),getList("Items.FIREZOMBIE_BODY.Lore"));

    public static final SlimefunItemStack PRE_BUILDING_TREE_INFO = themed("PRE_BUILDING_TREE_INFO",Material.PAPER,
            get("Items.PRE_BUILDING_TREE_INFO.Name"),getList("Items.PRE_BUILDING_TREE_INFO.Lore"));

    public static SlimefunItemStack createPreBuildingTreeItem(String treeType, Material saplingMaterial) {
        return themed(
                "PRE_BUILDING_" + treeType.toUpperCase() + "_TREE",
                saplingMaterial,
                get("Items.PRE_BUILDING_" + treeType.toUpperCase() + "_TREE.Name"),
                getList("Items.PRE_BUILDING_" + treeType.toUpperCase() + "_TREE.Lore")
        );
    }
    public static final SlimefunItemStack PRE_BUILDING_OAK_TREE = createPreBuildingTreeItem("oak", Material.OAK_SAPLING);
    public static final SlimefunItemStack PRE_BUILDING_SPRUCE_TREE = createPreBuildingTreeItem("spruce", Material.SPRUCE_SAPLING);
    public static final SlimefunItemStack PRE_BUILDING_BIRCH_TREE = createPreBuildingTreeItem("birch", Material.BIRCH_SAPLING);
    public static final SlimefunItemStack PRE_BUILDING_DARK_OAK_TREE = createPreBuildingTreeItem("dark_oak", Material.DARK_OAK_SAPLING);
    public static final SlimefunItemStack PRE_BUILDING_ACACIA_TREE = createPreBuildingTreeItem("acacia", Material.ACACIA_SAPLING);
    public static final SlimefunItemStack PRE_BUILDING_JUNGLE_TREE = createPreBuildingTreeItem("jungle", Material.JUNGLE_SAPLING);
    public static final SlimefunItemStack PRE_BUILDING_MANGROVE_TREE = createPreBuildingTreeItem("mangrove", Material.MANGROVE_PROPAGULE);
    public static final SlimefunItemStack PRE_BUILDING_CHERRY_TREE = createPreBuildingTreeItem("cherry", Material.CHERRY_SAPLING);


//    public static final SlimefunItemStack PRE_BUILDING_OAK_TREE = themed("PRE_BUILDING_OAK_TREE",Material.OAK_SAPLING,
//            get("Items.PRE_BUILDING_OAK_TREE.Name"),getList("Items.PRE_BUILDING_OAK_TREE.Lore"));
//
//    public static final SlimefunItemStack PRE_BUILDING_CHERRY_TREE = themed("PRE_BUILDING_CHERRY_TREE",Material.CHERRY_SAPLING,
//            get("Items.PRE_BUILDING_CHERRY_TREE.Name"),getList("Items.PRE_BUILDING_CHERRY_TREE.Lore"));

    public static final SlimefunItemStack IRON_INGOT = themed("IRON_INGOT",Material.WHITE_WOOL,
            get("Resource.IRON_INGOT.Name"),getList("Resource.IRON_INGOT.Lore"));
    public static final SlimefunItemStack GOLD_INGOT = themed("GOLD_INGOT",Material.YELLOW_WOOL,
            get("Resource.GOLD_INGOT.Name"),getList("Resource.GOLD_INGOT.Lore"));
    public static final SlimefunItemStack COPPER_INGOT = themed("COPPER_INGOT",Material.ORANGE_WOOL,
            get("Resource.COPPER_INGOT.Name"),getList("Resource.COPPER_INGOT.Lore"));
    public static final SlimefunItemStack TIN_INGOT = themed("TIN_INGOT",Material.CYAN_WOOL,
            get("Resource.TIN_INGOT.Name"),getList("Resource.TIN_INGOT.Lore"));
    public static final SlimefunItemStack SILVER_INGOT = themed("SILVER_INGOT",Material.LIGHT_GRAY_WOOL,
            get("Resource.SILVER_INGOT.Name"),getList("Resource.SILVER_INGOT.Lore"));
    public static final SlimefunItemStack LEAD_INGOT = themed("LEAD_INGOT",Material.BLUE_WOOL,
            get("Resource.LEAD_INGOT.Name"),getList("Resource.LEAD_INGOT.Lore"));
    public static final SlimefunItemStack ALUMINUM_INGOT = themed("ALUMINUM_INGOT",Material.GRAY_WOOL,
            get("Resource.ALUMINUM_INGOT.Name"),getList("Resource.ALUMINUM_INGOT.Lore"));
    public static final SlimefunItemStack ZINC_INGOT = themed("ZINC_INGOT",Material.LIME_WOOL,
            get("Resource.ZINC_INGOT.Name"),getList("Resource.ZINC_INGOT.Lore"));
    public static final SlimefunItemStack MAGNESIUM_INGOT = themed("MAGNESIUM_INGOT",Material.PINK_WOOL,
            get("Resource.MAGNESIUM_INGOT.Name"),getList("Resource.MAGNESIUM_INGOT.Lore"));
    public static final SlimefunItemStack ELEMENT_INGOT = themed("ELEMENT_INGOT",Material.IRON_INGOT,
            get("Resource.ELEMENT_INGOT.Name"),getList("Resource.ELEMENT_INGOT.Lore"));

    public static final SlimefunItemStack REDSTONE = themed("REDSTONE",Material.REDSTONE,
            get("Resource.REDSTONE.Name"),getList("Resource.REDSTONE.Lore"));
    public static final SlimefunItemStack DIAMOND = themed("DIAMOND",Material.DIAMOND,
            get("Resource.DIAMOND.Name"),getList("Resource.DIAMOND.Lore"));
    public static final SlimefunItemStack LAPIS_LAZULI = themed("LAPIS_LAZULI",Material.LAPIS_LAZULI,
            get("Resource.LAPIS_LAZULI.Name"),getList("Resource.LAPIS_LAZULI.Lore"));
    public static final SlimefunItemStack EMERALD = themed("EMERALD",Material.EMERALD,
            get("Resource.EMERALD.Name"),getList("Resource.EMERALD.Lore"));
    public static final SlimefunItemStack COAL = themed("COAL",Material.COAL,
            get("Resource.COAL.Name"),getList("Resource.COAL.Lore"));
    public static final SlimefunItemStack QUARTZ = themed("QUARTZ",Material.QUARTZ,
            get("Resource.QUARTZ.Name"),getList("Resource.QUARTZ.Lore"));
    public static final SlimefunItemStack AMETHYST_SHARD = themed("AMETHYST_SHARD",Material.AMETHYST_SHARD,
            get("Resource.AMETHYST_SHARD.Name"),getList("Resource.AMETHYST_SHARD.Lore"));
    public static final SlimefunItemStack NETHERITE_INGOT = themed("NETHERITE_INGOT",Material.NETHERITE_INGOT,
            get("Resource.NETHERITE_INGOT.Name"),getList("Resource.NETHERITE_INGOT.Lore"));
    public static final SlimefunItemStack BONE = themed("BONE",Material.BONE,
            get("Resource.BONE.Name"),getList("Resource.BONE.Lore"));
    public static final SlimefunItemStack BONE_MEAL = themed("BONE_MEAL",Material.BONE_MEAL,
            get("Resource.BONE_MEAL.Name"),getList("Resource.BONE_MEAL.Lore"));
    public static final SlimefunItemStack STICK = themed("STICK",Material.STICK,
            get("Resource.STICK.Name"),getList("Resource.STICK.Lore"));
    public static final SlimefunItemStack REDSTONE_TORCH = themed("REDSTONE_TORCH",Material.REDSTONE_TORCH,
            get("Resource.REDSTONE_TORCH.Name"),getList("Resource.REDSTONE_TORCH.Lore"));
    public static final SlimefunItemStack COBBLESTONE = themed("COBBLESTONE",Material.COBBLESTONE,
            get("Resource.COBBLESTONE.Name"),getList("Resource.COBBLESTONE.Lore"));
    public static final SlimefunItemStack DIRT = themed("DIRT",Material.DIRT,
            get("Resource.DIRT.Name"),getList("Resource.DIRT.Lore"));
    public static final SlimefunItemStack LEVER = themed("LEVER",Material.LEVER,
            get("Resource.LEVER.Name"),getList("Resource.LEVER.Lore"));
    public static final SlimefunItemStack BUTTON = themed("BUTTON",Material.STONE_BUTTON,
            get("Resource.BUTTON.Name"),getList("Resource.BUTTON.Lore"));
    public static final SlimefunItemStack OAK_PLANKS = themed("OAK_PLANKS",Material.OAK_PLANKS,
            get("Resource.OAK_PLANKS.Name"),getList("Resource.OAK_PLANKS.Lore"));
    public static final SlimefunItemStack REDSTONE_EXECUTE_ELEMENT = themed("REDSTONE_EXECUTE_ELEMENT",Material.NOTE_BLOCK,
            get("Resource.REDSTONE_EXECUTE_ELEMENT.Name"),getList("Resource.REDSTONE_EXECUTE_ELEMENT.Lore"));
    public static final SlimefunItemStack CORE_ORIGIN = themed("CORE_ORIGIN",Material.HEART_OF_THE_SEA,
            get("Resource.CORE_ORIGIN.Name"),getList("Resource.CORE_ORIGIN.Lore"));
    public static final SlimefunItemStack LOG_MIX = themed("LOG_MIX",Material.GREEN_GLAZED_TERRACOTTA,
            get("Resource.LOG_MIX.Name"),getList("Resource.LOG_MIX.Lore"));



    //资源生成器
    public static final SlimefunItemStack RESOURCE_MACHINE_WOOD_BASIC = themed("RESOURCE_MACHINE_WOOD_BASIC",Material.BAMBOO_BLOCK,
            get("GENERATOR.RESOURCE_MACHINE_WOOD_BASIC.Name"),getList("GENERATOR.RESOURCE_MACHINE_WOOD_BASIC.Lore"));


    //配方机器
    public static final SlimefunItemStack WOOD_TRANSFORM_BASIC = themed("WOOD_TRANSFORM_BASIC",Material.STRIPPED_BAMBOO_BLOCK,
            get("RECIPE_MACHINE.WOOD_TRANSFORM_BASIC.Name"),getList("RECIPE_MACHINE.WOOD_TRANSFORM_BASIC.Lore"));










}
