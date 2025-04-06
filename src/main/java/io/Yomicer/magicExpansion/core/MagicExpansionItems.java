package io.Yomicer.magicExpansion.core;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.Material;

import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;
import static io.Yomicer.magicExpansion.utils.Utils.doGlow;


public class MagicExpansionItems {




    private MagicExpansionItems(){
    }
    //INFO
    public static final SlimefunItemStack MAGIC_EXPANSION_INFO = new SlimefunItemStack(
            "MAGIC_EXPANSION_INFO",
            Material.PAPER,
            getGradientName("信息"),
            "",
            getGradientName("Version-0.1"),
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
            Material.STRUCTURE_VOID,
            getGradientName("魔法交互核心"),
            "",
            getGradientName("负责快捷机器的交互")
    );


    // 工具
    public static final SlimefunItemStack SCYTHE = new SlimefunItemStack(
            "MAGIC_EXPANSION_SCYTHE",
            "8adb25ab9976d89d0bd8118d72c1c06bb907060c1e02a729b652d1e86b1ebbbc",
            getGradientName("镰刀"),
            "",
            "&7Test Skull_Hash",
            "&7一次性打破5个成熟的农作物",
            "&7Created From FluffyMachines"
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
            doGlow(Material.FURNACE),
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
            getGradientName("可以对背包内的材料进行快速研磨")
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











}
