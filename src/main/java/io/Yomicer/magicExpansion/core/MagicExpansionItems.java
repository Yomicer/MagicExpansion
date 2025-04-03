package io.Yomicer.magicExpansion.core;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.Material;

import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;
import static io.Yomicer.magicExpansion.utils.Utils.doGlow;


public class MagicExpansionItems {




    private MagicExpansionItems(){
    }
    //AUTHOR
    public static final SlimefunItemStack MAGIC_EXPANSION_AUTHOR = new SlimefunItemStack(
            "MAGIC_EXPANSION_AUTHOR",
            "8adb25ab9976d89d0bd8118d72c1c06bb907060c1e02a729b652d1e86b1ebbbc",
            getGradientName("Yomicer"),
            "",
            getGradientName("Another name: magicsolo"),
            getGradientName("Author of MagicExpansion")
    );
    //INFO
    public static final SlimefunItemStack MAGIC_EXPANSION_INFO = new SlimefunItemStack(
            "MAGIC_EXPANSION_AUTHOR",
            Material.PAPER,
            getGradientName("当前魔法拓展版本："),
            "",
            getGradientName("Version-0.1"),
            getGradientName("您在提issues的时候需要展示这个")
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

    public static final SlimefunItemStack MAGIC_EXPANSION_QUICK_SMELTERY = new SlimefunItemStack(
            "MAGIC_EXPANSION_QUICK_SMELTERY",
            doGlow(Material.FURNACE),
            getGradientName("魔法冶炼炉"),
            "",
            getGradientName("右键打开魔法冶炼炉"),
            getGradientName("可以对背包内的材料进行快速冶炼"),
            getGradientName("右键点击冶炼炉内的物品，查看单次合成所需的材料"),
            getGradientName("左键点击冶炼一次"),
            getGradientName("按住 Shift 并右键点击冶炼炉内的物品，可以一次冶炼32个产物"),
            getGradientName("按住 Shift 并左键点击冶炼炉内的物品，冶炼所有可制作的产物")
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








}
