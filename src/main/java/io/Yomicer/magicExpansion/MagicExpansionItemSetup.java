package io.Yomicer.magicExpansion;

import io.Yomicer.magicExpansion.items.electric.entitykillMachinee.EntityKillMachine;
import io.Yomicer.magicExpansion.items.electric.geoMachine.FiveElementsMiner;
import io.Yomicer.magicExpansion.items.electric.geoMachine.RSCMagicMiner;
import io.Yomicer.magicExpansion.items.electric.recipeMachine.RandomBoxMachine;
import io.Yomicer.magicExpansion.items.electric.recipeMachine.RecipeMachine;
import io.Yomicer.magicExpansion.items.electric.recipeMachine.RecipeRandomMachine;
import io.Yomicer.magicExpansion.items.electric.resourceGenerator.ResourceMachine;
import io.Yomicer.magicExpansion.items.electric.resourceGenerator.ResourceRandomOneMachine;
import io.Yomicer.magicExpansion.items.enchantMachine.EnchantingTable;
import io.Yomicer.magicExpansion.items.misc.*;
import io.Yomicer.magicExpansion.items.misc.fish.CommonFish;
import io.Yomicer.magicExpansion.items.misc.fish.CommonFishHidden;
import io.Yomicer.magicExpansion.items.preBuildings.PreBuildingTree;
import io.Yomicer.magicExpansion.items.quickMachine.*;
import io.Yomicer.magicExpansion.items.skyBlock.SingleCubeOre;
import io.Yomicer.magicExpansion.items.skyBlock.SingleCubeOrigin;
import io.Yomicer.magicExpansion.items.summonBossItem.FireZombie;
import io.Yomicer.magicExpansion.items.summonBossItem.WindElf;
import io.Yomicer.magicExpansion.items.tools.*;
import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.Yomicer.magicExpansion.utils.ColorGradient;
import io.Yomicer.magicExpansion.utils.CustomHeadUtils.CustomHead;
import io.Yomicer.magicExpansion.utils.itemUtils.NamedTagBuilder;
import io.Yomicer.magicExpansion.utils.itemUtils.newItem;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.HiddenItem;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.Capacitor;
import io.github.thebusybiscuit.slimefun4.implementation.items.geo.GEOMiner;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.Yomicer.magicExpansion.core.MagicExpansionItems.*;
import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;
import static io.Yomicer.magicExpansion.utils.ColorGradient.getRandomGradientName;
import static io.Yomicer.magicExpansion.utils.ConvertItem.*;
import static io.Yomicer.magicExpansion.utils.Language.get;
import static io.Yomicer.magicExpansion.utils.Language.getList;
import static io.Yomicer.magicExpansion.utils.Utils.doGlow;
import static io.Yomicer.magicExpansion.utils.itemUtils.sfItemUtils.sfItemAmount;


public final class MagicExpansionItemSetup {


    // ItemGroups
    public static final NestedItemGroup magicexpansion = new NestedItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "magicexpansion"),
            new CustomItemStack(doGlow(Material.LIGHT),"§x§F§D§B§7§D§4§kll§x§F§D§B§7§D§4魔§x§F§A§7§E§B§3法§x§F§F§6§9§B§42.§x§F§F§6§9§B§40§x§F§D§B§7§D§4§kll"),0
    );

    private static final ItemGroup magicexpansioncontribution = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "contribution"), magicexpansion,
            new CustomItemStack(doGlow(Material.COMMAND_BLOCK), getRandomGradientName("贡献")), 0
    );

    private static final ItemGroup magicexpansionresource = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "resource"), magicexpansion,
            new CustomItemStack(doGlow(Material.SNOWBALL), ColorGradient.getGradientName("资源")), 1
    );

    private static final ItemGroup magicexpansionresourcedlc = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "resourcedlc"), magicexpansion,
            new CustomItemStack(doGlow(Material.TOTEM_OF_UNDYING), getGradientName("补丁材料")), 2
    );

    private static final ItemGroup magicexpansionspecialitem = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "specialitem"), magicexpansion,
            new CustomItemStack(doGlow(Material.SHEARS), getGradientName("特殊道具")), 3
    );

    public static final ItemGroup magicexpansionquickmachine = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "quickmachine"), magicexpansion,
            new CustomItemStack(doGlow(Material.MAGENTA_GLAZED_TERRACOTTA), getGradientName("快捷机器")), 4
    );

    public static final ItemGroup magicexpansionresourcegenerator = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "resourcegenerator"), magicexpansion,
            new CustomItemStack(doGlow(Material.LANTERN), ColorGradient.getGradientName("资源生成器")), 5
    );
    public static final ItemGroup magicexpansionrecipemachine = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "recipemachine"), magicexpansion,
            new CustomItemStack(doGlow(Material.SOUL_CAMPFIRE), ColorGradient.getGradientName("消耗型生产机器")), 5
    );

    public static final ItemGroup magicexpansionenergy = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "energy"), magicexpansion,
            new CustomItemStack(doGlow(Material.SOUL_LANTERN), ColorGradient.getGradientName("特殊机器")), 6
    );

    public static final ItemGroup magicexpansionpower = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "power"), magicexpansion,
            new CustomItemStack(CustomHead.getHead("24378b986e358555ee73f09b210d49ec13719de5ea88d75523770d31163f3aef"), ColorGradient.getGradientName("发电机")), 6
    );

    private static final ItemGroup magicexpansionelectricbot = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "electric_bot"), magicexpansion,
            new CustomItemStack(CustomHead.BOT_PINK.getItem(), ColorGradient.getGradientName("电力机器人")), 6
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
            new CustomItemStack(doGlow(Material.PRISMARINE_CRYSTALS), ColorGradient.getGradientName("建筑材料")), 9
    );

    private static final ItemGroup magicexpansionprebuilding = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "prebuilding"), magicexpansion,
            new CustomItemStack(doGlow(Material.BRICKS), ColorGradient.getGradientName("预制菜（建筑）")), 10
    );

    public static final ItemGroup magicexpansionhonkai = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "honkai"), magicexpansion,
            new CustomItemStack(CustomHead.SILVER_WOLF.getItem(), ColorGradient.getRandomGradientName("Honkai: Star Rail")), 10
    );

    public static final ItemGroup magicexpansionskyblock = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "skyblock"), magicexpansion,
            new CustomItemStack(CustomHead.getHead("7948942fed672ded57f8cdb169a5076062586e77002ee30e07693c025e6f0db5"), ColorGradient.getGradientName("魔法-SkyBlock")), 10
    );

    public static final ItemGroup magicexpansionrscmagic = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "rscmagic"), magicexpansion,
            new CustomItemStack(CustomHead.MAGICSOLO.getItem(), ColorGradient.getRandomGradientName("魔法-1.21修复/优化~物品/机器")), 10
    );

    public static final ItemGroup magicexpansionfishing = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "fishing"), magicexpansion,
            new CustomItemStack(doGlow(Material.FISHING_ROD), ColorGradient.getGradientName("钓鱼佬")), 10
    );

    public static final ItemGroup magicexpansionnonsensical = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "nonsensical"), magicexpansion,
            new CustomItemStack(doGlow(Material.DRAGON_EGG), ColorGradient.getRandomGradientName("无厘头-打发时间")), 10
    );


    private static final ItemGroup magicexpansionupdateinfo = new SubItemGroup(
            new NamespacedKey(MagicExpansion.getInstance(), "updateinfo"), magicexpansion,
            new CustomItemStack(doGlow(Material.PAPER), ColorGradient.getRandomGradientName("魔法-更新日志")), 11
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

    // 五行资源采集器
    public static final RecipeType FIVE_ELEMENT_MINER = new RecipeType(
            new NamespacedKey(MagicExpansion.getInstance(), "magicexpansion_five_element_miner"),
            new CustomItemStack(new CustomItemStack(CustomHead.getHead("846472b7bd8de52a101584ea2dd7db190d417ca548bb6568379acebdd02b1799"),
                    getGradientName("五行元素资源开采机"),getGradientName(" "),getGradientName("一种特殊的资源开采机"),
                    getGradientName("从区块中开采出五行资源"),getGradientName("可以开采出不能被矿镐挖出的资源"),getGradientName(" ")
                    ,getGradientName("确保你已经进行了 GEO 地形扫描"))),
            (input, output) -> {});

    // 五行资源采集器
    public static final RecipeType INGOT_PURE_MACHINE = new RecipeType(
            new NamespacedKey(MagicExpansion.getInstance(), "magicexpansion_ingot_pure_machine"),
            new CustomItemStack(new CustomItemStack(Material.SMOKER,
                    getGradientName("魔法元素提纯机"),getGradientName("去除掉绝大部分杂质以及小部分纯净物质？"))),
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

        registerUIBlockInContribution(MagicExpansionItems.UI_3,plugin);
        registerUIBlockInContribution(MagicExpansionItems.UI_4,plugin);
        registerUIBlockInContribution(MagicExpansionItems.UI_5,plugin);
        registerUIBlockInContribution(MagicExpansionItems.UI_6,plugin);
        registerUIBlockInContribution(MagicExpansionItems.UI_7,plugin);
        registerUIBlockInContribution(MagicExpansionItems.UI_8,plugin);
        registerUIBlockInContribution(MagicExpansionItems.UI_9,plugin);
        //UI
        new UnplaceableBlock(magicexpansioncontribution, MagicExpansionItems.UI_THX, RecipeType.NULL, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        new UnplaceableBlock(magicexpansioncontribution, MagicExpansionItems.NAZUKICYL_TEST, RecipeType.NULL, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        new UnplaceableBlock(magicexpansioncontribution, MagicExpansionItems.HAIMAN_TEST, RecipeType.NULL, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);





        //更新日志
        new UnplaceableBlock(magicexpansionupdateinfo, MagicExpansionItems.UPDATE_LOG_2025_06_23, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //更新日志
        new UnplaceableBlock(magicexpansionupdateinfo, MagicExpansionItems.UPDATE_LOG_2025_06_29, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //更新日志
        new UnplaceableBlock(magicexpansionupdateinfo, MagicExpansionItems.UPDATE_LOG_2025_07_12, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //更新日志
        new UnplaceableBlock(magicexpansionupdateinfo, MagicExpansionItems.UPDATE_LOG_2025_07_23, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //更新日志
        new UnplaceableBlock(magicexpansionupdateinfo, MagicExpansionItems.UPDATE_LOG_2025_07_25, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //更新日志
        new UnplaceableBlock(magicexpansionupdateinfo, MagicExpansionItems.UPDATE_LOG_2025_07_26, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //更新日志
        new UnplaceableBlock(magicexpansionupdateinfo, MagicExpansionItems.UPDATE_LOG_2025_08_01, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //更新日志
        new UnplaceableBlock(magicexpansionupdateinfo, MagicExpansionItems.UPDATE_LOG_2025_08_27, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //更新日志
        new UnplaceableBlock(magicexpansionupdateinfo, MagicExpansionItems.UPDATE_LOG_2025_08_29, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //更新日志
        new UnplaceableBlock(magicexpansionupdateinfo, MagicExpansionItems.UPDATE_LOG_2025_08_30, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //更新日志
        new UnplaceableBlock(magicexpansionupdateinfo, UPDATE_LOG_2025_09_02, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //更新日志
        new UnplaceableBlock(magicexpansionupdateinfo, UPDATE_LOG_2025_09_05, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //更新日志
        new UnplaceableBlock(magicexpansionupdateinfo, UPDATE_LOG_2025_09_09, SPECIAL_RECIPE_TYPE, new ItemStack[] {
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
                MagicExpansionItems.QUARTZ, SlimefunItems.POWER_CRYSTAL, MagicExpansionItems.QUARTZ,
                SlimefunItems.ADVANCED_CIRCUIT_BOARD, MagicExpansionItems.ELEMENT_INGOT, SlimefunItems.ADVANCED_CIRCUIT_BOARD,
                MagicExpansionItems.QUARTZ, MagicExpansionItems.AMETHYST_SHARD, MagicExpansionItems.QUARTZ
        }).register(plugin);


        // Tools
        //镰刀
        new Scythe(magicexpansionspecialitem, MagicExpansionItems.SCYTHE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null, new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
                null, new ItemStack(Material.IRON_INGOT), null,
                null, new ItemStack(Material.STICK), null
        }).register(plugin);
        //无尽打火石
        new InfiniteTool(magicexpansionspecialitem, MagicExpansionItems.INFINITY_FLINT_AND_STEEL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.IRON_INGOT,MagicExpansionItems.IRON_INGOT, MagicExpansionItems.IRON_INGOT,
                MagicExpansionItems.IRON_INGOT,new ItemStack(Material.FLINT),MagicExpansionItems.IRON_INGOT,
                MagicExpansionItems.IRON_INGOT,MagicExpansionItems.IRON_INGOT,MagicExpansionItems.IRON_INGOT
        }).register(plugin);
        // 随机实体蛋
        new MagicExpansionRandomSummon(magicexpansionspecialitem, MagicExpansionItems.MAGIC_EXPANSION_RANDOM_SPAWNER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_3, SlimefunItems.ENDER_LUMP_3, SlimefunItems.MAGIC_LUMP_3,
                SlimefunItems.ENDER_LUMP_3, BasicCreateItem("MAGIC_REDSTONE"), SlimefunItems.ENDER_LUMP_3,
                SlimefunItems.MAGIC_LUMP_3, SlimefunItems.ENDER_LUMP_3, SlimefunItems.MAGIC_LUMP_3
        }).register(plugin);

        //虚空之触
        new VoidTouch(magicexpansionspecialitem, MagicExpansionItems.VOID_TOUCH, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.AMETHYST_SHARD, MagicExpansionItems.PURE_ELEMENT_INGOT, MagicExpansionItems.AMETHYST_SHARD,
                MagicExpansionItems.AMETHYST_SHARD, MagicExpansionItems.MAGIC_EXPANSION_RANDOM_SPAWNER, MagicExpansionItems.AMETHYST_SHARD,
                MagicExpansionItems.AMETHYST_SHARD, MagicExpansionItems.BASIC_ENCHANT_STONE, MagicExpansionItems.AMETHYST_SHARD
        }).register(plugin);
        //五行之触
        new FiveElementTouch(magicexpansionspecialitem, MagicExpansionItems.FIVE_ELEMENT_TOUCH, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.PURE_ELEMENT_INGOT, MagicExpansionItems.PURE_ELEMENT_INGOT, MagicExpansionItems.PURE_ELEMENT_INGOT,
                MagicExpansionItems.VOID_TOUCH, MagicExpansionItems.PURE_FIVE_ELEMENT, MagicExpansionItems.VOID_TOUCH,
                MagicExpansionItems.PURE_ELEMENT_INGOT, MagicExpansionItems.PURE_ELEMENT_INGOT, MagicExpansionItems.PURE_ELEMENT_INGOT
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

        // 无厘头魔法糖
        new UnplaceableBlock(magicexpansionnonsensical, MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_1, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.MAGIC_SUGAR, SlimefunItems.MAGIC_SUGAR, SlimefunItems.MAGIC_SUGAR,
                SlimefunItems.MAGIC_SUGAR, SlimefunItems.MAGIC_SUGAR, SlimefunItems.MAGIC_SUGAR,
                SlimefunItems.MAGIC_SUGAR, SlimefunItems.MAGIC_SUGAR, SlimefunItems.MAGIC_SUGAR
        }).register(plugin);
        // 1. 先创建一个数组，按顺序存放所有魔法糖常量
        SlimefunItemStack[] sugarLevels = {
                null, // 占位：让索引从 1 开始
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_1,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_2,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_3,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_4,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_5,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_6,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_7,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_8,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_9,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_10,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_11,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_12,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_13,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_14,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_15,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_16,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_17,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_18,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_19,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_20,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_21,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_22,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_23,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_24,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_25,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_26,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_27,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_28,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_29,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_30,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_31,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_32,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_33,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_34,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_35,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_36,
                MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_37,
        };
        // 2. 用 for 循环注册所有升级配方
        for (int n = 1; n <= 2; n++) {
            ItemStack[] recipe = {
                    sugarLevels[n], sugarLevels[n], sugarLevels[n],
                    sugarLevels[n], sugarLevels[n], sugarLevels[n],
                    sugarLevels[n], sugarLevels[n], sugarLevels[n]
            };

            new UnplaceableBlock(
                    magicexpansionnonsensical,
                    sugarLevels[n + 1],
                    RecipeType.ENHANCED_CRAFTING_TABLE,
                    recipe
            ).register(plugin);
        }
        // 2. 用 for 循环注册所有升级配方
        for (int n = 3; n <= 34; n++) {
            ItemStack[] recipe = {
                    sugarLevels[n], sugarLevels[n], sugarLevels[n],
                    sugarLevels[n], sugarLevels[n], sugarLevels[n],
                    sugarLevels[n], sugarLevels[n], sugarLevels[n]
            };

            new HiddenItem(
                    magicexpansionnonsensical,
                    sugarLevels[n + 1],
                    RecipeType.ENHANCED_CRAFTING_TABLE,
                    recipe
            ).register(plugin);
        }
        // 2. 用 for 循环注册所有升级配方
        for (int n = 35; n <= 36; n++) {
            ItemStack[] recipe = {
                    sugarLevels[n], sugarLevels[n], sugarLevels[n],
                    sugarLevels[n], sugarLevels[n], sugarLevels[n],
                    sugarLevels[n], sugarLevels[n], sugarLevels[n]
            };

            new UnplaceableBlock(
                    magicexpansionnonsensical,
                    sugarLevels[n + 1],
                    RecipeType.ENHANCED_CRAFTING_TABLE,
                    recipe
            ).register(plugin);
        }

        // 量子纠缠态·甘蔗
        new UnplaceableBlock(magicexpansionnonsensical, MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_CANE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.SUGAR_CANE),new ItemStack(Material.SUGAR_CANE),new ItemStack(Material.SUGAR_CANE),
                new ItemStack(Material.SUGAR_CANE),MAGIC_EXPANSION_MAGIC_SUGAR_37,new ItemStack(Material.SUGAR_CANE),
                new ItemStack(Material.SUGAR_CANE),new ItemStack(Material.SUGAR_CANE),new ItemStack(Material.SUGAR_CANE)
        }).register(plugin);

        // 递归记忆纤维
        new UnplaceableBlock(magicexpansionnonsensical, MagicExpansionItems.MAGIC_EXPANSION_FINAL_STRING_1, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MAGIC_EXPANSION_MAGIC_SUGAR_21,MAGIC_EXPANSION_MAGIC_SUGAR_21,MAGIC_EXPANSION_MAGIC_SUGAR_21,
                MAGIC_EXPANSION_MAGIC_SUGAR_21,new ItemStack(Material.STRING),MAGIC_EXPANSION_MAGIC_SUGAR_21,
                MAGIC_EXPANSION_MAGIC_SUGAR_21,MAGIC_EXPANSION_MAGIC_SUGAR_21,MAGIC_EXPANSION_MAGIC_SUGAR_21
        }).register(plugin);

        // 1. 先创建一个数组，按顺序存放所有魔法糖常量
        SlimefunItemStack[] stringLevels = {
                null, // 占位：让索引从 1 开始
                MAGIC_EXPANSION_FINAL_STRING_1,
                MAGIC_EXPANSION_FINAL_STRING_2,
                MAGIC_EXPANSION_FINAL_STRING_3,
                MAGIC_EXPANSION_FINAL_STRING_4,
                MAGIC_EXPANSION_FINAL_STRING_5,
                MAGIC_EXPANSION_FINAL_STRING_6,
                MAGIC_EXPANSION_FINAL_STRING_7,
                MAGIC_EXPANSION_FINAL_STRING_8,
                MAGIC_EXPANSION_FINAL_STRING_9,
                MAGIC_EXPANSION_FINAL_STRING_10,
                MAGIC_EXPANSION_FINAL_STRING_11,
                MAGIC_EXPANSION_FINAL_STRING_12,
                MAGIC_EXPANSION_FINAL_STRING_13,
                MAGIC_EXPANSION_FINAL_STRING_14,
                MAGIC_EXPANSION_FINAL_STRING_15,
                MAGIC_EXPANSION_FINAL_STRING_16,
                MAGIC_EXPANSION_FINAL_STRING_17,
                MAGIC_EXPANSION_FINAL_STRING_18,
                MAGIC_EXPANSION_FINAL_STRING_19,
                MAGIC_EXPANSION_FINAL_STRING_20,
                MAGIC_EXPANSION_FINAL_STRING_21

        };
        // 2. 用 for 循环注册所有升级配方
        for (int n = 1; n <= 2; n++) {
            ItemStack[] recipe = {
                    stringLevels[n], stringLevels[n], stringLevels[n],
                    stringLevels[n], stringLevels[n], stringLevels[n],
                    stringLevels[n], stringLevels[n], stringLevels[n]
            };

            new UnplaceableBlock(
                    magicexpansionnonsensical,
                    stringLevels[n + 1],
                    RecipeType.ENHANCED_CRAFTING_TABLE,
                    recipe
            ).register(plugin);
        }
        // 2. 用 for 循环注册所有升级配方
        for (int n = 3; n <= 18; n++) {
            ItemStack[] recipe = {
                    stringLevels[n], stringLevels[n], stringLevels[n],
                    stringLevels[n], stringLevels[n], stringLevels[n],
                    stringLevels[n], stringLevels[n], stringLevels[n]
            };

            new HiddenItem(
                    magicexpansionnonsensical,
                    stringLevels[n + 1],
                    RecipeType.ENHANCED_CRAFTING_TABLE,
                    recipe
            ).register(plugin);
        }
        // 2. 用 for 循环注册所有升级配方
        for (int n = 19; n <= 20; n++) {
            ItemStack[] recipe = {
                    stringLevels[n], stringLevels[n], stringLevels[n],
                    stringLevels[n], stringLevels[n], stringLevels[n],
                    stringLevels[n], stringLevels[n], stringLevels[n]
            };

            new UnplaceableBlock(
                    magicexpansionnonsensical,
                    stringLevels[n + 1],
                    RecipeType.ENHANCED_CRAFTING_TABLE,
                    recipe
            ).register(plugin);
        }

        // 终焉之丝
        new UnplaceableBlock(magicexpansionnonsensical, MagicExpansionItems.FISHING_ROD_FINAL_STRING, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MAGIC_EXPANSION_FINAL_STRING_21,MAGIC_EXPANSION_FINAL_STRING_21,MAGIC_EXPANSION_FINAL_STRING_21,
                MAGIC_EXPANSION_FINAL_STRING_21,new ItemStack(Material.STRING),MAGIC_EXPANSION_FINAL_STRING_21,
                MAGIC_EXPANSION_FINAL_STRING_21,MAGIC_EXPANSION_FINAL_STRING_21,MAGIC_EXPANSION_FINAL_STRING_21
        }).register(plugin);
        // 终焉之丝
        new UnplaceableBlock(magicexpansionnonsensical, MagicExpansionItems.FISHING_ROD_FINAL_HOOK, RecipeType.NULL, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(Material.FISHING_ROD),"§b可被任意高阶鱼杆钓取",getGradientName("钓起他不需要任何鱼饵~")),null,
                null,null,null
        }).register(plugin);

        // 终焉之钩
        new HiddenItem(magicexpansionnonsensical, MagicExpansionItems.FISHING_ROD_FISH_ANYTHING, RecipeType.NULL, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(Material.FISHING_ROD),"§b可以被魔法系列鱼杆钓起",getGradientName("图片仅供参考")),null,
                null,null,null
        }).register(plugin);



        // 自定义
        new FishingRod(magicexpansionfishing, MagicExpansionItems.FISHING_ROD_LOG, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null,null,new ItemStack(Material.OAK_LOG),
                null,new ItemStack(Material.CHERRY_LOG),new ItemStack(Material.STRING),
                new ItemStack(Material.BIRCH_LOG),null, AMETHYST_SHARD
        }, new HashMap<>() {{
            put(Enchantment.LUCK, 1);
            put(Enchantment.LURE, 5);
        }}, false,
                Map.of(
                        "default", List.of(
                                new WeightedItem(new ItemStack(Material.OAK_LOG), 3),
                                new WeightedItem(new ItemStack(Material.ACACIA_LOG), 3),
                                new WeightedItem(new ItemStack(Material.JUNGLE_LOG), 3),
                                new WeightedItem(new ItemStack(Material.BIRCH_LOG), 3),
                                new WeightedItem(new ItemStack(Material.CHERRY_LOG), 3),
                                new WeightedItem(new ItemStack(Material.SPRUCE_LOG), 3),
                                new WeightedItem(new ItemStack(Material.DARK_OAK_LOG), 3),
                                new WeightedItem(new ItemStack(Material.MANGROVE_LOG), 3),
                                new WeightedItem(new ItemStack(Material.CRIMSON_STEM), 3),
                                new WeightedItem(new ItemStack(Material.WARPED_STEM), 3),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD,1),getGradientName("鱼饵·记忆碎片"),getGradientName("这个鱼饵可以钓到任何物品"),getGradientName("他存在于过去或者是未来"),getGradientName("你现在看到的他并非真正的他")
                                ), 1)
                        )
                ), List.of()).register(plugin);

        // 萌新钓竿
        new FishingRod(magicexpansionfishing, MagicExpansionItems.FISHING_ROD_NEW_PLAYER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null,null,STICK,
                null,STICK,new ItemStack(Material.STRING),
                STICK,null,SlimefunItems.MAGIC_SUGAR
        }, new HashMap<>() {{
            put(Enchantment.LUCK, 1);
            put(Enchantment.LURE, 2);
        }}, false,
                Map.of(
                        "magic_sugar", List.of(
                                new WeightedItem(MAGIC_EXPANSION_MAGIC_SUGAR_1, 5),
                                new WeightedItem(SlimefunItems.MAGIC_LUMP_1, 70),
                                new WeightedItem(SlimefunItems.MAGIC_LUMP_2, 10),
                                new WeightedItem(SlimefunItems.MAGIC_LUMP_3, 2),
                                new WeightedItem(SlimefunItems.ENDER_LUMP_1, 70),
                                new WeightedItem(SlimefunItems.ENDER_LUMP_2, 10),
                                new WeightedItem(SlimefunItems.ENDER_LUMP_3, 2),
                                new WeightedItem(SlimefunItems.MAGICAL_GLASS, 8),
                                new WeightedItem(SlimefunItems.MAGICAL_BOOK_COVER, 8),
                                new WeightedItem(SlimefunItems.LAVA_CRYSTAL, 1),
                                new WeightedItem(SlimefunItems.COMMON_TALISMAN, 3),
                                new WeightedItem(SlimefunItems.NECROTIC_SKULL, 1),
                                new WeightedItem(SlimefunItems.ESSENCE_OF_AFTERLIFE, 1),
                                new WeightedItem(SlimefunItems.SYNTHETIC_SHULKER_SHELL, 1),
                                new WeightedItem(SlimefunItems.BLANK_RUNE, 22),
                                new WeightedItem(SlimefunItems.AIR_RUNE, 2),
                                new WeightedItem(SlimefunItems.EARTH_RUNE, 2),
                                new WeightedItem(SlimefunItems.FIRE_RUNE, 2),
                                new WeightedItem(SlimefunItems.WATER_RUNE, 2),
                                new WeightedItem(SlimefunItems.ENDER_RUNE, 2),
                                new WeightedItem(SlimefunItems.LIGHTNING_RUNE, 1),
                                new WeightedItem(SlimefunItems.RAINBOW_RUNE, 1),
                                new WeightedItem(SlimefunItems.SOULBOUND_RUNE, 1),
                                new WeightedItem(SlimefunItems.ENCHANTMENT_RUNE, 1),
                                new WeightedItem(SlimefunItems.VILLAGER_RUNE, 1),
                                new WeightedItem(SlimefunItems.STRANGE_NETHER_GOO, 1),
                                new WeightedItem(SlimefunItems.RAINBOW_LEATHER, 1),
                                new WeightedItem(RANDOM_FISH_COMMON, 1),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 1),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD,1),getGradientName("鱼饵·记忆碎片"),getGradientName("这个鱼饵可以钓到任何物品"),getGradientName("他存在于过去或者是未来"),getGradientName("你现在看到的他并非真正的他")
                                ), 18)
                        ),
                        "bread", List.of(
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.COD),"§b迷路的生鳕鱼",getGradientName("这是谁家的鳕鱼？")
                                ), 200),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.SALMON),"§b晕头转向的生鲑鱼",getGradientName("有没有听过洄鲑阵法？")
                                ), 200),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.TROPICAL_FISH),"§b有1.4的热带鱼",getGradientName("热带鱼是怎么跑到中远河里的？")
                                ), 50),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.PUFFERFISH),"§b发绿的河豚",getGradientName("这东西可不能乱吃哦~")
                                ), 90),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.POTION),"§b神秘的药剂",getGradientName("也许能喝吧？")
                                ), 40),
                                new WeightedItem(new ItemStack(Material.HONEY_BOTTLE,15), 30),
                                new WeightedItem(RANDOM_FISH_COMMON, 400),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 100),
                                new WeightedItem(RANDOM_FISH_EPIC, 6),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_DUST, 27),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_ORE, 27)
                        ),
                        "fishLureBasic", List.of(
                                new WeightedItem(new CustomItemStack(Material.GLOW_BERRIES, "§a萤火草穗", getGradientName("夜间会发出微光，传说能引诱好奇的鱼")
                                ), 80),
                                new WeightedItem(new CustomItemStack(Material.MOSS_CARPET, "§a水苔绒", getGradientName("柔软湿润，是小鱼最爱藏身之处")
                                ), 60),
                                new WeightedItem(new CustomItemStack(Material.SLIME_BALL, "§a蛙鸣壳", getGradientName("轻轻一捏就会发出‘咕呱’声，鱼儿以为是同类")
                                ), 40),
                                new WeightedItem(new CustomItemStack(Material.POPPY, "§a露珠莲瓣", getGradientName("带着晨露的清香，能净化水域的浊气")
                                ), 80),
                                new WeightedItem(new CustomItemStack(Material.PRISMARINE_SHARD, "§a鱼鳞尘", getGradientName("在阳光下闪烁微光，是鱼群身份的信号")
                                ), 50),
                                new WeightedItem(RANDOM_FISH_COMMON, 160),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 140),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_DUST, 60),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_ORE, 60),
                                new WeightedItem(RANDOM_FISH_EPIC, 5)
                        ),
                        "fishLureDust", List.of(
                                new WeightedItem(new CustomItemStack(Material.RED_SAND, "§6磨碎的铜砂", getGradientName("带有微弱金属光泽，是铜脉鱼的气息信标")
                                ), 30),
                                new WeightedItem(new CustomItemStack(Material.RED_DYE, "§6铁锈粉末", getGradientName("从废弃矿械上刮下的锈尘，鱼儿能感知到‘同类’的存在")
                                ), 30),
                                new WeightedItem(new CustomItemStack(Material.GLOW_INK_SAC, "§6金粉残渣", getGradientName("淘金后的尾料，仍残留着‘富矿区’的魔力波动")
                                ), 70),
                                new WeightedItem(new CustomItemStack(Material.QUARTZ, "§6石英碎屑", getGradientName("来自下界矿脉的晶体碎片，能稳定矿粉的能量场")
                                ), 60),
                                new WeightedItem(new CustomItemStack(Material.COAL, "§6碳晶颗粒", getGradientName("深埋地壳的古老植物遗骸，为矿粉提供能量基底")
                                ), 30),
                                new WeightedItem(new CustomItemStack(Material.NETHER_STAR, "§d星辰铁微尘", getGradientName("极其稀有，传说来自陨星核心，能大幅提升引诱力")
                                ), 6),
                                new WeightedItem(RANDOM_FISH_COMMON, 90),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 50),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_DUST, 110),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_ORE, 10),
                                new WeightedItem(RANDOM_FISH_EPIC, 1)
                        ),
                        "fishLureOre", List.of(
                                new WeightedItem(new CustomItemStack(Material.COPPER_INGOT, "§b原生铜脉碎片", getGradientName("并非冶炼所得，而是从岩层中直接剥离的天然导电矿络")
                                ), 20),
                                new WeightedItem(new CustomItemStack(Material.IRON_INGOT, "§b赤铁矿核", getGradientName("保留了完整晶体结构的高纯度铁核，能散发‘金属心跳’般的信号")
                                ), 30),
                                new WeightedItem(new CustomItemStack(Material.GOLD_INGOT, "§b金脉结晶", getGradientName("在高压下自然形成的网状金晶，是‘富矿区’的活体信标")
                                ), 70),
                                new WeightedItem(new CustomItemStack(Material.AMETHYST_SHARD, "§b深岩晶核", getGradientName("来自地壳深处的共振晶体，能放大矿石信号的传播范围")
                                ), 60),
                                new WeightedItem(new CustomItemStack(Material.COAL_BLOCK, "§b熔岩碳心", getGradientName("在岩浆旁碳化千年的木心，蕴含地热能量，稳定矿核活性")
                                ), 30),
                                new WeightedItem(new CustomItemStack(Material.NETHER_STAR, "§5星核残片", getGradientName("传说来自坠落恒星的核心碎片，能模拟‘地核级’矿脉信号")
                                ), 6),
                                new WeightedItem(RANDOM_FISH_COMMON, 90),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 50),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_DUST, 10),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_ORE, 110),
                                new WeightedItem(RANDOM_FISH_EPIC, 1)
                        ),
                        "default", List.of(
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.SUGAR_CANE,2),"§b腐烂的甘蔗",getGradientName("河里怎么会有甘蔗呢？")), 8),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.STICK,2),"§b锟斤拷",getGradientName("这是什么东西呢？")), 8),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.INK_SAC,2),"§b新鲜的墨囊",getGradientName("谁家好人把墨囊丢在河里啊？")), 8),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.CAKE,2),"§b隔夜的蛋糕",getGradientName("蛋糕吃不完了？")), 8),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.REDSTONE,8),"§b8-bit 红石",getGradientName("一把刚好8个？")), 8),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.DISPENSER,2),"§b粘液科技要用到的发射器",getGradientName("放地上就好了？")), 8),
                                new WeightedItem(RANDOM_FISH_COMMON, 2),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 1)
                        )
                ),Arrays.asList(SlimefunItems.MAGIC_SUGAR,new ItemStack(Material.BREAD),
                FISH_LURE_BASIC,FISH_LURE_DUST,FISH_LURE_ORE)).register(plugin);


        // 风语者之竿
        new FishingRod(magicexpansionfishing, MagicExpansionItems.FISHING_ROD_WIND_SPEAKER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null,null,WATER_ELEMENT,
                null,FISHING_ROD_NEW_PLAYER,WIND_SPIRIT,
                FISHING_STICK_STAR_IRON,null,AMETHYST_SHARD
        }, new HashMap<>() {{
            put(Enchantment.LUCK, 5);
            put(Enchantment.LURE, 5);
        }}, false,
                Map.of(
                        "magic_sugar", List.of(
                                new WeightedItem(MAGIC_EXPANSION_MAGIC_SUGAR_1, 10),
                                new WeightedItem(SlimefunItems.MAGIC_LUMP_1, 1),
                                new WeightedItem(SlimefunItems.MAGIC_LUMP_2, 1),
                                new WeightedItem(SlimefunItems.MAGIC_LUMP_3, 8),
                                new WeightedItem(SlimefunItems.ENDER_LUMP_1, 1),
                                new WeightedItem(SlimefunItems.ENDER_LUMP_2, 1),
                                new WeightedItem(SlimefunItems.ENDER_LUMP_3, 8),
                                new WeightedItem(SlimefunItems.MAGICAL_GLASS, 2),
                                new WeightedItem(SlimefunItems.MAGICAL_BOOK_COVER, 2),
                                new WeightedItem(SlimefunItems.LAVA_CRYSTAL, 1),
                                new WeightedItem(SlimefunItems.COMMON_TALISMAN, 3),
                                new WeightedItem(SlimefunItems.NECROTIC_SKULL, 1),
                                new WeightedItem(SlimefunItems.ESSENCE_OF_AFTERLIFE, 1),
                                new WeightedItem(SlimefunItems.SYNTHETIC_SHULKER_SHELL, 1),
                                new WeightedItem(SlimefunItems.BLANK_RUNE, 1),
                                new WeightedItem(SlimefunItems.AIR_RUNE, 1),
                                new WeightedItem(SlimefunItems.EARTH_RUNE, 1),
                                new WeightedItem(SlimefunItems.FIRE_RUNE, 1),
                                new WeightedItem(SlimefunItems.WATER_RUNE, 1),
                                new WeightedItem(SlimefunItems.ENDER_RUNE, 1),
                                new WeightedItem(SlimefunItems.LIGHTNING_RUNE, 2),
                                new WeightedItem(SlimefunItems.RAINBOW_RUNE, 2),
                                new WeightedItem(SlimefunItems.SOULBOUND_RUNE, 2),
                                new WeightedItem(SlimefunItems.ENCHANTMENT_RUNE, 2),
                                new WeightedItem(SlimefunItems.VILLAGER_RUNE, 2),
                                new WeightedItem(SlimefunItems.STRANGE_NETHER_GOO, 2),
                                new WeightedItem(SlimefunItems.RAINBOW_LEATHER, 2),
                                new WeightedItem(RANDOM_FISH_COMMON, 15),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 10),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_DUST, 13),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_ORE, 13),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD,1),getGradientName("鱼饵·记忆碎片"),getGradientName("这个鱼饵可以钓到任何物品"),getGradientName("他存在于过去或者是未来"),getGradientName("你现在看到的他并非真正的他")
                                ), 18)
                        ),
                        "bread", List.of(
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.COD,3),"§b迷路的生鳕鱼",getGradientName("这是谁家的鳕鱼？")
                                ), 20),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.SALMON,3),"§b晕头转向的生鲑鱼",getGradientName("有没有听过洄鲑阵法？")
                                ), 20),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.TROPICAL_FISH,3),"§b有1.4的热带鱼",getGradientName("热带鱼是怎么跑到中远河里的？")
                                ), 5),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.PUFFERFISH,3),"§b发绿的河豚",getGradientName("这东西可不能乱吃哦~")
                                ), 9),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.POTION,3),"§b神秘的药剂",getGradientName("也许能喝吧？")
                                ), 4),
                                new WeightedItem(new ItemStack(Material.HONEY_BOTTLE,256), 30),
                                new WeightedItem(RANDOM_FISH_COMMON, 10),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 10),
                                new WeightedItem(RANDOM_FISH_EPIC, 5),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_DUST, 18),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_ORE, 18),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD,1),getGradientName("鱼饵·记忆碎片"),getGradientName("这个鱼饵可以钓到任何物品"),getGradientName("他存在于过去或者是未来"),getGradientName("你现在看到的他并非真正的他")
                                ), 1)
                        ),
                        "fishLureBasic", List.of(
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.GLOW_BERRIES,3), "§a萤火草穗", getGradientName("夜间会发出微光，传说能引诱好奇的鱼")
                                ), 8),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.MOSS_CARPET,3), "§a水苔绒", getGradientName("柔软湿润，是小鱼最爱藏身之处")
                                ), 6),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.SLIME_BALL,3), "§a蛙鸣壳", getGradientName("轻轻一捏就会发出‘咕呱’声，鱼儿以为是同类")
                                ), 4),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.POPPY,3), "§a露珠莲瓣", getGradientName("带着晨露的清香，能净化水域的浊气")
                                ), 8),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD,3), "§a鱼鳞尘", getGradientName("在阳光下闪烁微光，是鱼群身份的信号")
                                ), 5),
                                new WeightedItem(RANDOM_FISH_COMMON, 20),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 18),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_DUST, 15),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_ORE, 15),
                                new WeightedItem(RANDOM_FISH_EPIC, 8),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD,1),getGradientName("鱼饵·记忆碎片"),getGradientName("这个鱼饵可以钓到任何物品"),getGradientName("他存在于过去或者是未来"),getGradientName("你现在看到的他并非真正的他")
                                ), 1)
                        ),
                        "fishLureDust", List.of(
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.RED_SAND,3), "§6磨碎的铜砂", getGradientName("带有微弱金属光泽，是铜脉鱼的气息信标")
                                ), 3),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.RED_DYE,3), "§6铁锈粉末", getGradientName("从废弃矿械上刮下的锈尘，鱼儿能感知到‘同类’的存在")
                                ), 3),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.GLOW_INK_SAC,3), "§6金粉残渣", getGradientName("淘金后的尾料，仍残留着‘富矿区’的魔力波动")
                                ), 7),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.QUARTZ,3), "§6石英碎屑", getGradientName("来自下界矿脉的晶体碎片，能稳定矿粉的能量场")
                                ), 6),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.COAL,3), "§6碳晶颗粒", getGradientName("深埋地壳的古老植物遗骸，为矿粉提供能量基底")
                                ), 3),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.NETHER_STAR,3), "§d星辰铁微尘", getGradientName("极其稀有，传说来自陨星核心，能大幅提升引诱力")
                                ), 5),
                                new WeightedItem(RANDOM_FISH_COMMON, 12),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 3),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_DUST, 31),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_ORE, 1),
                                new WeightedItem(RANDOM_FISH_EPIC, 3),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD,1),getGradientName("鱼饵·记忆碎片"),getGradientName("这个鱼饵可以钓到任何物品"),getGradientName("他存在于过去或者是未来"),getGradientName("你现在看到的他并非真正的他")
                                ), 1)
                        ),
                        "fishLureOre", List.of(
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.COPPER_INGOT,3), "§b原生铜脉碎片", getGradientName("并非冶炼所得，而是从岩层中直接剥离的天然导电矿络")
                                ), 2),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.IRON_INGOT,3), "§b赤铁矿核", getGradientName("保留了完整晶体结构的高纯度铁核，能散发‘金属心跳’般的信号")
                                ), 3),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.GOLD_INGOT,3), "§b金脉结晶", getGradientName("在高压下自然形成的网状金晶，是‘富矿区’的活体信标")
                                ), 7),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.AMETHYST_SHARD,3), "§b深岩晶核", getGradientName("来自地壳深处的共振晶体，能放大矿石信号的传播范围")
                                ), 6),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.COAL_BLOCK,3), "§b熔岩碳心", getGradientName("在岩浆旁碳化千年的木心，蕴含地热能量，稳定矿核活性")
                                ), 3),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.NETHER_STAR,3), "§5星核残片", getGradientName("传说来自坠落恒星的核心碎片，能模拟‘地核级’矿脉信号")
                                ), 5),
                                new WeightedItem(RANDOM_FISH_COMMON, 12),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 3),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_DUST, 1),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_ORE, 31),
                                new WeightedItem(RANDOM_FISH_EPIC, 3),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD,1),getGradientName("鱼饵·记忆碎片"),getGradientName("这个鱼饵可以钓到任何物品"),getGradientName("他存在于过去或者是未来"),getGradientName("你现在看到的他并非真正的他")
                                ), 1)
                        ),
                        "default", List.of(
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.SUGAR_CANE,8),"§b腐烂的甘蔗",getGradientName("河里怎么会有甘蔗呢？")
                                ), 6),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.STICK,8),"§b锟斤拷",getGradientName("这是什么东西呢？")
                                ), 6),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.INK_SAC,8),"§b新鲜的墨囊",getGradientName("谁家好人把墨囊丢在河里啊？")
                                ), 6),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.CAKE,8),"§b隔夜的蛋糕",getGradientName("蛋糕吃不完了？")
                                ), 6),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.REDSTONE,8),"§b8-bit 红石",getGradientName("一把刚好8个？")
                                ), 6),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.DISPENSER,8),"§b粘液科技要用到的发射器",getGradientName("放地上就好了？")
                                ), 6),
                                new WeightedItem(RANDOM_FISH_COMMON, 8),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 8),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_DUST, 3),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_ORE, 3),
                                new WeightedItem(RANDOM_FISH_EPIC, 3),
                                new WeightedItem(FISHING_ROD_FINAL_HOOK, 1),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD,1),getGradientName("鱼饵·记忆碎片"),getGradientName("这个鱼饵可以钓到任何物品"),getGradientName("他存在于过去或者是未来"),getGradientName("你现在看到的他并非真正的他")
                                ), 1)
                        )
                ),Arrays.asList(SlimefunItems.MAGIC_SUGAR,new ItemStack(Material.BREAD),
                FISH_LURE_BASIC,FISH_LURE_DUST,FISH_LURE_ORE)).register(plugin);


        // 终焉鱼杆
        new FishingRod(magicexpansionfishing, MagicExpansionItems.FISHING_ROD_FINAL_STICK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null,null,MAGIC_EXPANSION_MAGIC_SUGAR_CANE,
                null,MAGIC_EXPANSION_MAGIC_SUGAR_CANE,FISHING_ROD_FINAL_STRING,
                MAGIC_EXPANSION_MAGIC_SUGAR_CANE,null, FISHING_ROD_FINAL_HOOK
        }, new HashMap<>() {{
            put(Enchantment.LUCK, 25);
            put(Enchantment.LURE, 5);
        }}, false,
                Map.of(
                        "fishLureFinal", List.of(
                                new WeightedItem(FISHING_ROD_FISH_ANYTHING, 12),
                                new WeightedItem(RANDOM_FISH_COMMON, 1),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 1),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_DUST, 1),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_ORE, 1),
                                new WeightedItem(RANDOM_FISH_EPIC, 1),
                                new WeightedItem(RANDOM_FISH_LEGENDARY, 1),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD,8),getGradientName("鱼饵·记忆碎片"),getGradientName("这个鱼饵可以钓到任何物品"),getGradientName("他存在于过去或者是未来"),getGradientName("你现在看到的他并非真正的他")
                                ), 1)
                        ),
                        "default", List.of(
                                new WeightedItem(RANDOM_FISH_COMMON, 8),
                                new WeightedItem(RANDOM_FISH_UNCOMMON, 6),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_DUST, 3),
                                new WeightedItem(RANDOM_FISH_RARE_POOL_ORE, 3),
                                new WeightedItem(RANDOM_FISH_EPIC, 3),
                                new WeightedItem(RANDOM_FISH_LEGENDARY, 3),
                                new WeightedItem(FISHING_ROD_FINAL_HOOK, 1),
                                new WeightedItem(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD,5),getGradientName("鱼饵·记忆碎片"),getGradientName("这个鱼饵可以钓到任何物品"),getGradientName("他存在于过去或者是未来"),getGradientName("你现在看到的他并非真正的他")
                                ), 3)
                        )
                ), List.of(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD,1),getGradientName("鱼饵·记忆碎片"),getGradientName("这个鱼饵可以钓到任何物品"),getGradientName("他存在于过去或者是未来"),getGradientName("你现在看到的他并非真正的他")
                )
        )).register(plugin);


        //星辰木
        new UnplaceableBlock(magicexpansionresource, FISHING_STICK_STAR_IRON, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null, STICK, new CustomItemStack(Material.PRISMARINE_SHARD, "§a鱼鳞尘", getGradientName("在阳光下闪烁微光，是鱼群身份的信号")),
                STICK, new CustomItemStack(Material.NETHER_STAR, "§d星辰铁微尘", getGradientName("极其稀有，传说来自陨星核心，能大幅提升引诱力")),STICK,
                new CustomItemStack(Material.IRON_INGOT, "§b赤铁矿核", getGradientName("保留了完整晶体结构的高纯度铁核，能散发‘金属心跳’般的信号")), STICK, null
        }).register(plugin);




        //钓鱼说明
        new UnplaceableBlock(magicexpansionfishing, FISHING_INFO, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //鱼类说明
        new UnplaceableBlock(magicexpansionfishing, FISH_CATEGORY_INFO, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);

        // 普通鱼
        new CommonFish(magicexpansionfishing, RANDOM_FISH_COMMON, RecipeType.NULL, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(doGlow(Material.FISHING_ROD)),getGradientName("钓鱼有概率获取"), ColorGradient.getGradientName("通过魔法2.0系列鱼杆钓取"),getGradientName("很常见的鱼")),null,
                null,null,null
        }).register(plugin);
        // 罕见鱼
        new CommonFish(magicexpansionfishing, RANDOM_FISH_UNCOMMON, RecipeType.NULL, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(doGlow(Material.FISHING_ROD)),getGradientName("钓鱼有概率获取"), ColorGradient.getGradientName("通过魔法2.0系列鱼杆钓取"),getGradientName("比较罕见的鱼")),null,
                null,null,null
        }).register(plugin);
        // 稀有鱼
        new CommonFish(magicexpansionfishing, RANDOM_FISH_RARE, RecipeType.NULL, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(doGlow(Material.FISHING_ROD)),getGradientName("钓鱼有概率获取"), ColorGradient.getGradientName("通过魔法2.0系列鱼杆钓取"),getGradientName("出没地点隐秘，且停留时间极短，可能对某些鱼饵有一定兴趣")),null,
                null,null,null
        }).register(plugin);

        new CommonFishHidden(magicexpansionfishing, RANDOM_FISH_RARE_POOL_DUST, RecipeType.NULL, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(doGlow(Material.FISHING_ROD)),getGradientName("钓鱼有概率获取"), ColorGradient.getGradientName("通过魔法2.0系列鱼杆钓取"),getGradientName("出没地点隐秘，且停留时间极短，可能对某些鱼饵有一定兴趣")),null,
                null,null,null
        }).register(plugin);
        new CommonFishHidden(magicexpansionfishing, RANDOM_FISH_RARE_POOL_ORE, RecipeType.NULL, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(doGlow(Material.FISHING_ROD)),getGradientName("钓鱼有概率获取"), ColorGradient.getGradientName("通过魔法2.0系列鱼杆钓取"),getGradientName("出没地点隐秘，且停留时间极短，可能对某些鱼饵有一定兴趣")),null,
                null,null,null
        }).register(plugin);






        // 史诗鱼
        new CommonFish(magicexpansionfishing, RANDOM_FISH_EPIC, RecipeType.NULL, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(doGlow(Material.FISHING_ROD)),getGradientName("钓鱼有概率获取"), ColorGradient.getGradientName("通过魔法2.0系列鱼杆钓取"),getGradientName("极少有人能证明它真的存在，不使用特殊鱼饵几乎无法碰见")),null,
                null,null,null
        }).register(plugin);
        // 传说鱼
        new CommonFish(magicexpansionfishing, RANDOM_FISH_LEGENDARY, RecipeType.NULL, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(doGlow(Material.FISHING_ROD)),getGradientName("钓鱼有概率获取"), ColorGradient.getGradientName("通过魔法2.0系列鱼杆钓取"),getGradientName("只存在于古老传说中，现实是否存疑，只有传说中的鱼饵才有些许概率能够遇到")),null,
                null,null,null
        }).register(plugin);
        // 基础饵料
        new UnplaceableBlock(magicexpansionfishing, FISH_LURE_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.SWEET_BERRIES),BONE_MEAL,new ItemStack(Material.CARROT),
                BONE_MEAL,new ItemStack(Material.APPLE),BONE_MEAL,
                new ItemStack(Material.POTATO),BONE_MEAL,new ItemStack(Material.MELON_SLICE)
        }).register(plugin);
        // 混合矿粉饵料
        new UnplaceableBlock(magicexpansionfishing, FISH_LURE_DUST, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.COPPER_DUST,SlimefunItems.IRON_DUST,SlimefunItems.GOLD_DUST,
                SlimefunItems.SILVER_DUST,FISH_LURE_BASIC,SlimefunItems.MAGNESIUM_DUST,
                SlimefunItems.ZINC_DUST,SlimefunItems.TIN_DUST,SlimefunItems.ALUMINUM_DUST
        },sfItemAmount(FISH_LURE_DUST,16)).register(plugin);
        // 混合矿物饵料
        new UnplaceableBlock(magicexpansionfishing, FISH_LURE_ORE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.DIAMOND),new ItemStack(Material.GOLD_INGOT),new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.EMERALD),FISH_LURE_BASIC,new ItemStack(Material.QUARTZ),
                new ItemStack(Material.AMETHYST_SHARD),new ItemStack(Material.LAPIS_LAZULI),new ItemStack(Material.GLOWSTONE_DUST)
        },sfItemAmount(FISH_LURE_ORE,16)).register(plugin);










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


        // 风灵BOSS
        new WindElf(magicexpansionboss, MagicExpansionItems.WIND_ELF_SPAWN, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null,null,null,
                null,null,null,
                null,null,null
        }).register(plugin);

        // 僵尸类BOSS身体
        new SlimefunItem(magicexpansionboss, MagicExpansionItems.WIND_ELF_BODY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.WATER_ELEMENT,new ItemStack(Material.STRING),MagicExpansionItems.WATER_ELEMENT,
                new ItemStack(Material.STRING),SlimefunItems.BLANK_RUNE,new ItemStack(Material.STRING),
                MagicExpansionItems.WATER_ELEMENT,new ItemStack(Material.STRING),MagicExpansionItems.WATER_ELEMENT
        }).register(plugin);

        // 烈火僵尸头颅
        new SlimefunItem(magicexpansionboss, MagicExpansionItems.WIND_ELF_HEAD, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.LIGHT_BLUE_DYE),new ItemStack(Material.STRING),new ItemStack(Material.LIGHT_BLUE_DYE),
                new ItemStack(Material.STRING),new ItemStack(Material.LIGHT_BLUE_DYE),new ItemStack(Material.STRING),
                new ItemStack(Material.LIGHT_BLUE_DYE),new ItemStack(Material.STRING),new ItemStack(Material.LIGHT_BLUE_DYE)
        }).register(plugin);

        new WindElfMB(magicexpansionboss, MagicExpansionItems.WIND_ELF_MB).register(plugin);

        //风灵技能
        new UnplaceableBlock(magicexpansionboss, MagicExpansionItems.WIND_ELF_SKILL, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);
        //风灵防御
        new UnplaceableBlock(magicexpansionboss, MagicExpansionItems.WIND_ELF_DEFENSE, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null, null, null,
                null, null, null,
                null, null, null
        }).register(plugin);



        // 星辰铁   1级青金石
        new UnplaceableBlock(magicexpansionforge, MagicExpansionItems.BASIC_ENCHANT_STONE, MAGICEXPANSION_MOB_DROP, new ItemStack[] {
                null, null, null,
                null, newItem.themed(Material.ZOMBIE_SPAWN_EGG, get("Items.BASIC_ENCHANT_STONE_DROP.Name"), getList("Items.BASIC_ENCHANT_STONE_DROP.Lore")),null,
                null, null,null
        }).register(plugin);
        // 风灵之息
        new UnplaceableBlock(magicexpansionforge, MagicExpansionItems.WIND_SPIRIT, MAGICEXPANSION_MOB_DROP, new ItemStack[] {
                null, null, null,
                null, newItem.themed(Material.ALLAY_SPAWN_EGG, get("Items.WIND_SPIRIT_DROP.Name"), getList("Items.WIND_SPIRIT_DROP.Lore")),null,
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
        registerVanResource(plugin,MagicExpansionItems.COBBLESTONE, new ItemStack(Material.COBBLESTONE));
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

        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.JIN_KE_LA, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.EGG,1),new ItemStack(Material.APPLE,1), new ItemStack(Material.MELON_SLICE,1),
                new ItemStack(Material.SWEET_BERRIES,1),MagicExpansionItems.BONE_MEAL,new ItemStack(Material.GLOW_BERRIES,1),
                new ItemStack(Material.CARROT,1),new ItemStack(Material.WHEAT,1),new ItemStack(Material.ROTTEN_FLESH,1),
        }).register(plugin);

        //石英核心
        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.QUARTZ_CORE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.ELEMENT_INGOT, MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.QUARTZ,MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.ELEMENT_INGOT,
        }).register(plugin);


        //紊乱的发电机核心
        new Capacitor(magicexpansionpower,1314520, MagicExpansionItems.POWER_CORE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT,SlimefunItems.ENERGIZED_CAPACITOR, MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.COPPER_INGOT,AdvancedCreateItem("MAGIC_COSMIC_DUST"),MagicExpansionItems.ZINC_INGOT,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.ELEMENT_INGOT,
        }).register(plugin);


        //无尽空间魔法
        new UnplaceableBlock(magicexpansionprebuildingresource, MagicExpansionItems.SPACE_INFINITY_MAGIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.LIGHT_CORE, MagicExpansionItems.AMETHYST_SHARD,
                MagicExpansionItems.LIGHT_CORE,BasicCreateItem("MAGIC_REDSTONE"),MagicExpansionItems.LIGHT_CORE,
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
        new UnplaceableBlock(
                magicexpansionprebuildingresource,
                MagicExpansionItems.COLOR_LEAVES_1,
                PRE_BUILDINGS_MACHINE_RESOURCE_ADVANCED,
                new ItemStack[] {
                        null, new ItemStack(Material.WHITE_DYE,64), null,
                        new ItemStack(Material.RED_DYE,64), new ItemStack(Material.CHERRY_LEAVES,64), new ItemStack(Material.YELLOW_DYE,64),
                        null, new ItemStack(Material.BLUE_DYE,64), null
                }
        ).register(plugin);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.COLOR_LEAVES_2, MagicExpansionItems.COLOR_LEAVES_1);
        new UnplaceableBlock(
                magicexpansionprebuildingresource,
                MagicExpansionItems.COLOR_LOG_1,
                PRE_BUILDINGS_MACHINE_RESOURCE_ADVANCED,
                new ItemStack[] {
                        null, new ItemStack(Material.WHITE_DYE,64), null,
                        new ItemStack(Material.RED_DYE,64), MagicExpansionItems.OAK_LOG_1, new ItemStack(Material.YELLOW_DYE,64),
                        null, new ItemStack(Material.BLUE_DYE,64), null
                }
        ).register(plugin);
        registerBuildingsResourceSf(plugin,MagicExpansionItems.COLOR_LOG_2, MagicExpansionItems.COLOR_LOG_1);


        //GEO资源

        new MagicGeoResourceDefault(magicexpansionresource, MagicExpansionItems.GOLD_ELEMENT, FIVE_ELEMENT_MINER, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(Material.NETHER_STAR), "&c&l注意：&c&l原版资源采集器无法开采此资源","需要使用五行资源开采机"),null,
                null,null,null
        },"金元素",false,1314,520)
                .register(plugin);

        new MagicGeoResourceDefault(magicexpansionresource, MagicExpansionItems.WOOD_ELEMENT, FIVE_ELEMENT_MINER, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(Material.NETHER_STAR), "&c&l注意：&c&l原版资源采集器无法开采此资源","需要使用五行资源开采机"),null,
                null,null,null
        },"木元素",false,1314,520)
                .register(plugin);

        new MagicGeoResourceDefault(magicexpansionresource, MagicExpansionItems.WATER_ELEMENT, FIVE_ELEMENT_MINER, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(Material.NETHER_STAR), "&c&l注意：&c&l原版资源采集器无法开采此资源","需要使用五行资源开采机"),null,
                null,null,null
        },"水元素",false,1314,520)
                .register(plugin);

        new MagicGeoResourceDefault(magicexpansionresource, MagicExpansionItems.FIRE_ELEMENT, FIVE_ELEMENT_MINER, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(Material.NETHER_STAR), "&c&l注意：&c&l原版资源采集器无法开采此资源","需要使用五行资源开采机"),null,
                null,null,null
        },"火元素",false,1314,520)
                .register(plugin);

        new MagicGeoResourceDefault(magicexpansionresource, MagicExpansionItems.EARTH_ELEMENT, FIVE_ELEMENT_MINER, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(new ItemStack(Material.NETHER_STAR), "&c&l注意：&c&l原版资源采集器无法开采此资源","需要使用五行资源开采机"),null,
                null,null,null
        },"土元素",false,1314,520)
                .register(plugin);

        new UnplaceableBlock(magicexpansionresource, MagicExpansionItems.FIVE_ELEMENT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null,MagicExpansionItems.WOOD_ELEMENT,null,
                MagicExpansionItems.WATER_ELEMENT,MagicExpansionItems.GOLD_ELEMENT,MagicExpansionItems.FIRE_ELEMENT,
                null,MagicExpansionItems.EARTH_ELEMENT,null
        }).register(plugin);



        //纯净元素
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_IRON,
                INGOT_PURE_MACHINE,
                new ItemStack[] {
                        sfItemAmount(MagicExpansionItems.IRON_INGOT,64), sfItemAmount(MagicExpansionItems.ELEMENT_INGOT,8), null,
                        null, null, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_GOLD,
                INGOT_PURE_MACHINE,
                new ItemStack[] {
                        sfItemAmount(MagicExpansionItems.GOLD_INGOT,64), sfItemAmount(MagicExpansionItems.ELEMENT_INGOT,8), null,
                        null, null, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_COPPER,
                INGOT_PURE_MACHINE,
                new ItemStack[] {
                        sfItemAmount(MagicExpansionItems.COPPER_INGOT,64), sfItemAmount(MagicExpansionItems.ELEMENT_INGOT,8), null,
                        null, null, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_MAGNESIUM,
                INGOT_PURE_MACHINE,
                new ItemStack[] {
                        sfItemAmount(MagicExpansionItems.MAGNESIUM_INGOT,64), sfItemAmount(MagicExpansionItems.ELEMENT_INGOT,8), null,
                        null, null, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_TIN,
                INGOT_PURE_MACHINE,
                new ItemStack[] {
                        sfItemAmount(MagicExpansionItems.TIN_INGOT,64), sfItemAmount(MagicExpansionItems.ELEMENT_INGOT,8), null,
                        null, null, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_SILVER,
                INGOT_PURE_MACHINE,
                new ItemStack[] {
                        sfItemAmount(MagicExpansionItems.SILVER_INGOT,64), sfItemAmount(MagicExpansionItems.ELEMENT_INGOT,8), null,
                        null, null, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_LEAD,
                INGOT_PURE_MACHINE,
                new ItemStack[] {
                        sfItemAmount(MagicExpansionItems.LEAD_INGOT,64), sfItemAmount(MagicExpansionItems.ELEMENT_INGOT,8), null,
                        null, null, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_ALUMINUM,
                INGOT_PURE_MACHINE,
                new ItemStack[] {
                        sfItemAmount(MagicExpansionItems.ALUMINUM_INGOT,64), sfItemAmount(MagicExpansionItems.ELEMENT_INGOT,8), null,
                        null, null, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_ZINC,
                INGOT_PURE_MACHINE,
                new ItemStack[] {
                        sfItemAmount(MagicExpansionItems.ZINC_INGOT,64), sfItemAmount(MagicExpansionItems.ELEMENT_INGOT,8), null,
                        null, null, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_ELEMENT_INGOT,
                RecipeType.SMELTERY,
                new ItemStack[] {
                        MagicExpansionItems.IRON_INGOT,MagicExpansionItems.GOLD_INGOT, MagicExpansionItems.COPPER_INGOT,
                        MagicExpansionItems.MAGNESIUM_INGOT, MagicExpansionItems.TIN_INGOT, MagicExpansionItems.SILVER_INGOT, MagicExpansionItems.SILVER_INGOT,
                        MagicExpansionItems.LEAD_INGOT, MagicExpansionItems.ALUMINUM_INGOT, MagicExpansionItems.ZINC_INGOT,
                }
        ).register(plugin);

        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_ELEMENT_GOLD,
                RecipeType.SMELTERY,
                new ItemStack[] {
                        MagicExpansionItems.GOLD_ELEMENT,MagicExpansionItems.FIVE_ELEMENT,MagicExpansionItems.PURE_ELEMENT_INGOT,
                        MagicExpansionItems.PURE_GOLD, MagicExpansionItems.PURE_IRON, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_ELEMENT_WOOD,
                RecipeType.SMELTERY,
                new ItemStack[] {
                        WOOD_ELEMENT,MagicExpansionItems.FIVE_ELEMENT,MagicExpansionItems.PURE_ELEMENT_INGOT,
                        MagicExpansionItems.PURE_COPPER, MagicExpansionItems.PURE_MAGNESIUM, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_ELEMENT_WATER,
                RecipeType.SMELTERY,
                new ItemStack[] {
                        WATER_ELEMENT,MagicExpansionItems.FIVE_ELEMENT,MagicExpansionItems.PURE_ELEMENT_INGOT,
                        MagicExpansionItems.PURE_LEAD, MagicExpansionItems.PURE_ALUMINUM, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_ELEMENT_FIRE,
                RecipeType.SMELTERY,
                new ItemStack[] {
                        FIRE_ELEMENT,MagicExpansionItems.FIVE_ELEMENT,MagicExpansionItems.PURE_ELEMENT_INGOT,
                        MagicExpansionItems.PURE_TIN, MagicExpansionItems.PURE_ZINC, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_ELEMENT_EARTH,
                RecipeType.SMELTERY,
                new ItemStack[] {
                        EARTH_ELEMENT,MagicExpansionItems.FIVE_ELEMENT,MagicExpansionItems.PURE_ELEMENT_INGOT,
                        MagicExpansionItems.PURE_COPPER, MagicExpansionItems.PURE_SILVER, null,
                        null, null, null
                }
        ).register(plugin);
        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.PURE_FIVE_ELEMENT,
                RecipeType.SMELTERY,
                new ItemStack[] {
                        MagicExpansionItems.PURE_ELEMENT_GOLD,MagicExpansionItems.PURE_ELEMENT_WOOD,MagicExpansionItems.PURE_ELEMENT_WATER,
                        MagicExpansionItems.PURE_ELEMENT_FIRE, MagicExpansionItems.PURE_ELEMENT_EARTH, null,
                        null, null, null
                }
        ).register(plugin);

        new UnplaceableBlock(
                magicexpansionresource,
                MagicExpansionItems.SPEED_ELEMENT_64,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        MagicExpansionItems.PURE_ELEMENT_INGOT,MagicExpansionItems.POWER_CORE,MagicExpansionItems.PURE_ELEMENT_INGOT,
                        SlimefunItems.TALISMAN_MAGICIAN, MagicExpansionItems.PURE_FIVE_ELEMENT, SlimefunItems.TALISMAN_MAGICIAN,
                        MagicExpansionItems.PURE_ELEMENT_INGOT, SlimefunItems.TALISMAN_WIZARD, MagicExpansionItems.PURE_ELEMENT_INGOT
                }
        ).register(plugin);



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

        //木头发生器
        new ResourceMachine(magicexpansionresourcegenerator, MagicExpansionItems.RESOURCE_MACHINE_WOOD_ULTRA, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.AMETHYST_SHARD,SlimefunItems.AIR_RUNE,MagicExpansionItems.AMETHYST_SHARD,
                MagicExpansionItems.RESOURCE_MACHINE_WOOD_BASIC,MagicExpansionItems.PURE_ELEMENT_WOOD,MagicExpansionItems.RESOURCE_MACHINE_WOOD_BASIC,
                MagicExpansionItems.PURE_ELEMENT_INGOT,MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.PURE_ELEMENT_INGOT
        })
                .setCraftSecond(3)
                .setCapacity(131452)
                .setConsumption(2600)
                .setProcessingSpeed(1)
                .setItemStackOutputs(new ItemStack[] {new ItemStack(Material.OAK_LOG,64),new ItemStack(Material.SPRUCE_LOG,64),new ItemStack(Material.BIRCH_LOG,64),
                        new ItemStack(Material.JUNGLE_LOG,64),new ItemStack(Material.ACACIA_LOG,64),new ItemStack(Material.DARK_OAK_LOG,64),
                        new ItemStack(Material.MANGROVE_LOG,64),new ItemStack(Material.CHERRY_LOG,64),
                        new ItemStack(Material.OAK_LEAVES,64),new ItemStack(Material.SPRUCE_LEAVES,64),new ItemStack(Material.BIRCH_LEAVES,64),
                        new ItemStack(Material.JUNGLE_LEAVES,64),new ItemStack(Material.ACACIA_LEAVES,64),new ItemStack(Material.DARK_OAK_LEAVES,64),
                        new ItemStack(Material.MANGROVE_LEAVES,64),new ItemStack(Material.CHERRY_LEAVES,64)})
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

        //刷线机
        new ResourceMachine(magicexpansionresourcegenerator, MagicExpansionItems.STRING_GEN_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.OAK_TRAPDOOR),new ItemStack(Material.WATER_BUCKET),new ItemStack(Material.LEVER),
                new ItemStack(Material.TRIPWIRE_HOOK),new ItemStack(Material.STRING),new ItemStack(Material.TRIPWIRE_HOOK),
                new ItemStack(Material.CHEST),new ItemStack(Material.HOPPER),new ItemStack(Material.OAK_PLANKS)
        })
                .setCraftSecond(1)
                .setCapacity(1314)
                .setConsumption(3)
                .setProcessingSpeed(1)
                .setItemStackOutputs(new ItemStack[] {new ItemStack(Material.STRING,2)
                })
                .register(plugin);
        //刷线机
        new ResourceMachine(magicexpansionresourcegenerator, MagicExpansionItems.STRING_GEN_ULTRA, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.AMETHYST_SHARD,SlimefunItems.WATER_RUNE,MagicExpansionItems.AMETHYST_SHARD,
                MagicExpansionItems.STRING_GEN_BASIC,MagicExpansionItems.WATER_ELEMENT,MagicExpansionItems.STRING_GEN_BASIC,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.ELEMENT_INGOT
        })
                .setCraftSecond(1)
                .setCapacity(1314)
                .setConsumption(26)
                .setProcessingSpeed(1)
                .setItemStackOutputs(new ItemStack[] {new ItemStack(Material.STRING,64),new ItemStack(Material.STRING,64)
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

        //矿脉机器人
        new ResourceRandomOneMachine(magicexpansionelectricbot, MagicExpansionItems.MINE_MAN_MINERAL_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.PROGRAMMABLE_ANDROID_3,new ItemStack(Material.NETHERITE_PICKAXE),MagicExpansionItems.SINGLE_CUBE_ORE,
                null,null,null,
                null,null,null
        })
                .setCraftSecond(6)
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .setItemStackOutputs(new ItemStack[] {new ItemStack(Material.COAL_ORE,1),new ItemStack(Material.DEEPSLATE_COAL_ORE,1)
                        ,new ItemStack(Material.IRON_ORE,1),new ItemStack(Material.DEEPSLATE_IRON_ORE,1),new ItemStack(Material.COPPER_ORE,1),
                        new ItemStack(Material.DEEPSLATE_IRON_ORE,1),new ItemStack(Material.GOLD_ORE,1),new ItemStack(Material.DEEPSLATE_GOLD_ORE,1),
                        new ItemStack(Material.REDSTONE_ORE,1),new ItemStack(Material.DEEPSLATE_REDSTONE_ORE,1),new ItemStack(Material.EMERALD_ORE,1),
                        new ItemStack(Material.DEEPSLATE_EMERALD_ORE,1),new ItemStack(Material.LAPIS_ORE,1),new ItemStack(Material.DEEPSLATE_LAPIS_ORE,1),
                        new ItemStack(Material.DIAMOND_ORE,1),new ItemStack(Material.DEEPSLATE_DIAMOND_ORE,1),new ItemStack(Material.NETHER_GOLD_ORE,1),
                        new ItemStack(Material.NETHER_QUARTZ_ORE,1),new ItemStack(Material.ANCIENT_DEBRIS,1),})
                .register(plugin);
        //矿脉机器人
        new ResourceRandomOneMachine(magicexpansionelectricbot, MagicExpansionItems.MINE_MAN_MINERAL_ULTRA, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.PURE_ELEMENT_GOLD,MagicExpansionItems.PURE_ELEMENT_GOLD,MagicExpansionItems.PURE_ELEMENT_GOLD,
                MagicExpansionItems.MINE_MAN_MINERAL_BASIC,MagicExpansionItems.PURE_FIVE_ELEMENT,MagicExpansionItems.MINE_MAN_MINERAL_BASIC,
                MagicExpansionItems.PURE_ELEMENT_INGOT,MagicExpansionItems.PURE_ELEMENT_INGOT,MagicExpansionItems.PURE_ELEMENT_INGOT
        })
                .setCraftSecond(2)
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .setItemStackOutputs(new ItemStack[] {new ItemStack(Material.COAL_ORE,64),new ItemStack(Material.DEEPSLATE_COAL_ORE,64)
                        ,new ItemStack(Material.IRON_ORE,64),new ItemStack(Material.DEEPSLATE_IRON_ORE,64),new ItemStack(Material.COPPER_ORE,64),
                        new ItemStack(Material.DEEPSLATE_IRON_ORE,64),new ItemStack(Material.GOLD_ORE,64),new ItemStack(Material.DEEPSLATE_GOLD_ORE,64),
                        new ItemStack(Material.REDSTONE_ORE,64),new ItemStack(Material.DEEPSLATE_REDSTONE_ORE,64),new ItemStack(Material.EMERALD_ORE,64),
                        new ItemStack(Material.DEEPSLATE_EMERALD_ORE,64),new ItemStack(Material.LAPIS_ORE,64),new ItemStack(Material.DEEPSLATE_LAPIS_ORE,64),
                        new ItemStack(Material.DIAMOND_ORE,64),new ItemStack(Material.DEEPSLATE_DIAMOND_ORE,64),new ItemStack(Material.NETHER_GOLD_ORE,64),
                        new ItemStack(Material.NETHER_QUARTZ_ORE,64),new ItemStack(Material.ANCIENT_DEBRIS,64),})
                .register(plugin);

        //矿脉机器人
        new RightClickMan(magicexpansionenergy, MagicExpansionItems.RIGHT_CLICK_MAN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.REDSTONE_TORCH,MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.REDSTONE_TORCH,
                MagicExpansionItems.LEVER,SlimefunItems.PROGRAMMABLE_ANDROID,MagicExpansionItems.LEVER,
                MagicExpansionItems.OAK_PLANKS,MagicExpansionItems.OAK_PLANKS,MagicExpansionItems.OAK_PLANKS
        }).register(plugin);




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

        //终极翠木转换机
        new RecipeMachine(magicexpansionrecipemachine, MagicExpansionItems.WOOD_TRANSFORM_ULTRA, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.AMETHYST_SHARD,SlimefunItems.AIR_RUNE,MagicExpansionItems.AMETHYST_SHARD,
                MagicExpansionItems.WOOD_TRANSFORM_BASIC,MagicExpansionItems.WOOD_ELEMENT,MagicExpansionItems.WOOD_TRANSFORM_BASIC,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.ELEMENT_INGOT
        })
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.OAK_LOG,64)},
                        new ItemStack[] {new ItemStack(Material.SPRUCE_LOG,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.SPRUCE_LOG,64)},
                        new ItemStack[] {new ItemStack(Material.BIRCH_LOG,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.BIRCH_LOG,64)},
                        new ItemStack[] {new ItemStack(Material.JUNGLE_LOG,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.JUNGLE_LOG,64)},
                        new ItemStack[] {new ItemStack(Material.ACACIA_LOG,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.ACACIA_LOG,64)},
                        new ItemStack[] {new ItemStack(Material.DARK_OAK_LOG,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.DARK_OAK_LOG,64)},
                        new ItemStack[] {new ItemStack(Material.MANGROVE_LOG,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.MANGROVE_LOG,64)},
                        new ItemStack[] {new ItemStack(Material.CHERRY_LOG,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.CHERRY_LOG,64)},
                        new ItemStack[] {new ItemStack(Material.OAK_LOG,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.OAK_LEAVES,64)},
                        new ItemStack[] {new ItemStack(Material.SPRUCE_LEAVES,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.SPRUCE_LEAVES,64)},
                        new ItemStack[] {new ItemStack(Material.BIRCH_LEAVES,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.BIRCH_LEAVES,64)},
                        new ItemStack[] {new ItemStack(Material.JUNGLE_LEAVES,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.JUNGLE_LEAVES,64)},
                        new ItemStack[] {new ItemStack(Material.ACACIA_LEAVES,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.ACACIA_LEAVES,64)},
                        new ItemStack[] {new ItemStack(Material.DARK_OAK_LEAVES,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.DARK_OAK_LEAVES,64)},
                        new ItemStack[] {new ItemStack(Material.MANGROVE_LEAVES,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.MANGROVE_LEAVES,64)},
                        new ItemStack[] {new ItemStack(Material.CHERRY_LEAVES,64)}).addRecipe(1,
                        new ItemStack[] {new ItemStack(Material.CHERRY_LEAVES,64)},
                        new ItemStack[] {new ItemStack(Material.OAK_LEAVES,64)})
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
                .addRecipe(5, new ItemStack[] {
                                new ItemStack(Material.PINK_CONCRETE,64),new ItemStack(Material.BLACK_CONCRETE,64),new ItemStack(Material.SNOW_BLOCK,64),
                                new ItemStack(Material.SMOOTH_QUARTZ,64),new ItemStack(Material.PINK_CONCRETE_POWDER,64),new ItemStack(Material.PURPLE_CONCRETE_POWDER,64),
                                new ItemStack(Material.CHERRY_PLANKS,64),new ItemStack(Material.PURPLE_CONCRETE,64)},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_DORA_PICTURE})
                .addRecipe(5, new ItemStack[] {
                        MagicExpansionItems.REDSTONE_1,sfItemAmount(MagicExpansionItems.IRON_INGOT_1,2),MagicExpansionItems.OAK_LOG_1,
                        MagicExpansionItems.LIGHT_1,MagicExpansionItems.COLOR_TERRACOTTA_1,MagicExpansionItems.COLOR_CONCRETE_1,
                        new ItemStack(Material.RED_WOOL)},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_WISH_DALE})
                .addRecipe(5, new ItemStack[] {
                                sfItemAmount(MagicExpansionItems.COLOR_LEAVES_1,15),sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,2),MagicExpansionItems.OAK_LOG_1,
                                MagicExpansionItems.COLOR_WOOL_1,MagicExpansionItems.STONE_1,MagicExpansionItems.GLASS_1,
                                NamedTagBuilder.nameTag("anon")},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_ANON})
                .addRecipe(5, new ItemStack[] {
                        sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,7),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),
                        MagicExpansionItems.LIGHT_1,MagicExpansionItems.COBBLESTONE_1,new ItemStack(Material.OAK_LEAVES,32)},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_HOUSE_OAK})
                .addRecipe(5, new ItemStack[] {
                                sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,7),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),
                                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COBBLESTONE_1,new ItemStack(Material.SPRUCE_LEAVES,32)},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_HOUSE_SPRUCE})
                .addRecipe(5, new ItemStack[] {
                                sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,7),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),
                                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COBBLESTONE_1,new ItemStack(Material.CHERRY_LEAVES,32)},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_HOUSE_CHERRY})
                .addRecipe(5, new ItemStack[] {
                                sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,7),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),
                                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COBBLESTONE_1,new ItemStack(Material.MANGROVE_LEAVES,32)},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_HOUSE_MANGROVE})
                .addRecipe(5, new ItemStack[] {
                                sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,7),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),
                                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COBBLESTONE_1,new ItemStack(Material.MOSS_BLOCK,32)},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_HOUSE_MOSS})
                .addRecipe(5, new ItemStack[] {
                                sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,7),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),
                                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COBBLESTONE_1,new ItemStack(Material.WHITE_WOOL,32)},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_HOUSE_WIND_CAR})

                .addRecipe(5,new ItemStack[] {
                        sfItemAmount(MagicExpansionItems.COLOR_LOG_1,21),sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,7),sfItemAmount(MagicExpansionItems.GLASS_1,2),
                        sfItemAmount(MagicExpansionItems.OAK_LOG_1,2),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,2),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,1),
                        NamedTagBuilder.nameTag("WineBar")},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_WINE_BAR})
                .addRecipe(5,new ItemStack[] {
                                sfItemAmount(MagicExpansionItems.COLOR_LOG_1,2),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,2),sfItemAmount(MagicExpansionItems.LIGHT_1,1),
                                sfItemAmount(MagicExpansionItems.OAK_LOG_1,1),sfItemAmount(MagicExpansionItems.COLOR_LEAVES_1,1),NamedTagBuilder.nameTag("FishingPort")},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_FISHING_PORT})
                .addRecipe(5,new ItemStack[] {
                                sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,2),sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,3),
                                sfItemAmount(MagicExpansionItems.OAK_LOG_1,1),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,1),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,1),
                                NamedTagBuilder.nameTag("Bakery")},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_BAKERY})
                .addRecipe(5,new ItemStack[] {
                                sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,10),sfItemAmount(MagicExpansionItems.GLASS_1,2),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,6),
                                sfItemAmount(MagicExpansionItems.COLOR_LEAVES_1,1),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,1),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,1),
                                NamedTagBuilder.nameTag("KFCSmall")},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_KFC_SMALL})
                .addRecipe(5,new ItemStack[] {
                                sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,6),sfItemAmount(MagicExpansionItems.GLASS_1,1),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,2),
                                sfItemAmount(MagicExpansionItems.OAK_LOG_1,1),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,1),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,1),
                                NamedTagBuilder.nameTag("MiXueBingCheng")},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_LITTLE_MI_XUE})
                .addRecipe(5,new ItemStack[] {
                                sfItemAmount(MagicExpansionItems.COBBLESTONE_1,5),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,4),sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,2),
                                sfItemAmount(MagicExpansionItems.IRON_INGOT_1,2),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,1),NamedTagBuilder.nameTag("JapanHouse")},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_JAPAN_HOUSE})
                .addRecipe(5,new ItemStack[] {
                                sfItemAmount(MagicExpansionItems.COLOR_LOG_1,6),sfItemAmount(MagicExpansionItems.GLASS_1,1),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,2),
                                sfItemAmount(MagicExpansionItems.COLOR_LEAVES_1,1),new ItemStack(Material.IRON_INGOT,31),NamedTagBuilder.nameTag("FarmBarn")},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_FARM_BARN})
                .addRecipe(5,new ItemStack[] {
                                sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,3),sfItemAmount(MagicExpansionItems.GLASS_1,3),sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,1),
                                sfItemAmount(MagicExpansionItems.OAK_LOG_1,2),new ItemStack(Material.QUARTZ_BLOCK,64),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,1),
                                NamedTagBuilder.nameTag("FruitShop")},
                        new ItemStack[] {MagicExpansionItems.PRE_BUILDING_FRUIT_SHOP})

                .register(plugin);


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

        //终极纯净硅源机
        new RecipeMachine(magicexpansionrecipemachine, MagicExpansionItems.QUARTZ_PURE_MACHINE_ULTRA, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.QUARTZ,MagicExpansionItems.AMETHYST_SHARD,
                MagicExpansionItems.QUARTZ_PURE_MACHINE_BAISC,MagicExpansionItems.FIVE_ELEMENT,MagicExpansionItems.QUARTZ_PURE_MACHINE_BAISC,
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.ELEMENT_INGOT
        })
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .addRecipe(1, new ItemStack[] {sfItemAmount(MagicExpansionItems.GOLD_INGOT,32)}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64), sfItemAmount(SlimefunItems.SILICON,64)})
                .addRecipe(1, new ItemStack[] {sfItemAmount(MagicExpansionItems.IRON_INGOT,32)}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64), sfItemAmount(SlimefunItems.SILICON,64)})
                .addRecipe(1, new ItemStack[] {sfItemAmount(MagicExpansionItems.COPPER_INGOT,32)}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64), sfItemAmount(SlimefunItems.SILICON,64)})
                .addRecipe(1, new ItemStack[] {sfItemAmount(MagicExpansionItems.LEAD_INGOT,32)}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64), sfItemAmount(SlimefunItems.SILICON,64)})
                .addRecipe(1, new ItemStack[] {sfItemAmount(MagicExpansionItems.TIN_INGOT,32)}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64), sfItemAmount(SlimefunItems.SILICON,64)})
                .addRecipe(1, new ItemStack[] {sfItemAmount(MagicExpansionItems.SILVER_INGOT,32)}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64), sfItemAmount(SlimefunItems.SILICON,64)})
                .addRecipe(1, new ItemStack[] {sfItemAmount(MagicExpansionItems.ZINC_INGOT,32)}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64), sfItemAmount(SlimefunItems.SILICON,64)})
                .addRecipe(1, new ItemStack[] {sfItemAmount(MagicExpansionItems.ALUMINUM_INGOT,32)}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64), sfItemAmount(SlimefunItems.SILICON,64)})
                .addRecipe(1, new ItemStack[] {sfItemAmount(MagicExpansionItems.MAGNESIUM_INGOT,32)}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64), sfItemAmount(SlimefunItems.SILICON,64)})
                .addRecipe(1, new ItemStack[] {sfItemAmount(MagicExpansionItems.ELEMENT_INGOT,4)}, new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64), sfItemAmount(SlimefunItems.SILICON,64)})
                .addRecipe(3, new ItemStack[] {sfItemAmount(SlimefunItems.GOLD_4K,64)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64)}).addRecipe(3, new ItemStack[] {new ItemStack(Material.GOLD_INGOT,64)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64)}).addRecipe(3, new ItemStack[] {new ItemStack(Material.IRON_INGOT,64)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64)}).addRecipe(3, new ItemStack[] {new ItemStack(Material.COPPER_INGOT,64)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64)}).addRecipe(3, new ItemStack[] {sfItemAmount(SlimefunItems.COPPER_INGOT,64)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64)}).addRecipe(3, new ItemStack[] {sfItemAmount(SlimefunItems.LEAD_INGOT,64)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64)}).addRecipe(3, new ItemStack[] {sfItemAmount(SlimefunItems.TIN_INGOT,64)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64)}).addRecipe(3, new ItemStack[] {sfItemAmount(SlimefunItems.SILVER_INGOT,64)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64)}).addRecipe(3, new ItemStack[] {sfItemAmount(SlimefunItems.ZINC_INGOT,64)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64)}).addRecipe(3, new ItemStack[] {sfItemAmount(SlimefunItems.ALUMINUM_INGOT,64)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64)}).addRecipe(3, new ItemStack[] {sfItemAmount(SlimefunItems.MAGNESIUM_INGOT,64)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ_BLOCK,64)})
                .register(plugin);

        //一体化·矿粉产线
        new RecipeRandomMachine(magicexpansionrecipemachine, MagicExpansionItems.INTEGRATION_ORIGIN_SLIME_MINERAL_POWDER_LINE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.OAK_PLANKS,SlimefunItems.ELECTRIC_GOLD_PAN_3,MagicExpansionItems.OAK_PLANKS,
                SlimefunItems.ELECTRIC_DUST_WASHER_3,MagicExpansionItems.AMETHYST_SHARD,SlimefunItems.ELECTRIC_ORE_GRINDER_3,
                MagicExpansionItems.IRON_INGOT,MagicExpansionItems.IRON_INGOT,MagicExpansionItems.IRON_INGOT
        })
                .setCapacity(1314)
                .setConsumption(26)
                .setProcessingSpeed(1)
                .addRecipe(1, new ItemStack[] {sfItemAmount(SlimefunItems.SIFTED_ORE,1)},
                        new ItemStack[] {SlimefunItems.IRON_DUST,SlimefunItems.GOLD_DUST,SlimefunItems.LEAD_DUST,
                                SlimefunItems.SILVER_DUST,SlimefunItems.COPPER_DUST,SlimefunItems.ALUMINUM_DUST,
                                SlimefunItems.MAGNESIUM_DUST,SlimefunItems.TIN_DUST,SlimefunItems.ZINC_DUST,SlimefunItems.STONE_CHUNK})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.GRAVEL)},
                        new ItemStack[] {new ItemStack(Material.IRON_NUGGET,2),new ItemStack(Material.CLAY_BALL,2),
                                new ItemStack(Material.FLINT,2),sfItemAmount(SlimefunItems.SIFTED_ORE,2)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.COBBLESTONE)},
                        new ItemStack[] {new ItemStack(Material.GRAVEL)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.BONE)},
                        new ItemStack[] {new ItemStack(Material.BONE_MEAL,4)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.BLAZE_ROD)},
                        new ItemStack[] {new ItemStack(Material.BLAZE_POWDER,4)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.DIRT)},
                        new ItemStack[] {SlimefunItems.STONE_CHUNK})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.DIAMOND)},
                        new ItemStack[] {sfItemAmount(SlimefunItems.CARBON,4)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.NETHER_WART)},
                        new ItemStack[] {sfItemAmount(SlimefunItems.MAGIC_LUMP_1,4)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.ENDER_EYE)},
                        new ItemStack[] {sfItemAmount(SlimefunItems.ENDER_LUMP_1,4)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.SOUL_SAND,1)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ),new ItemStack(Material.NETHER_WART),
                                new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.GOLD_NUGGET),
                                new ItemStack(Material.GLOWSTONE_DUST),new ItemStack(Material.GHAST_TEAR)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.SOUL_SOIL,4)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ),new ItemStack(Material.NETHER_WART),
                                new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.GOLD_NUGGET),
                                new ItemStack(Material.GLOWSTONE_DUST),new ItemStack(Material.GHAST_TEAR)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.SAND)},
                        new ItemStack[] {SlimefunItems.SALT})
                .register(plugin);

        //一体化·矿粉产线·ULTRA
        new RecipeRandomMachine(magicexpansionrecipemachine, MagicExpansionItems.INTEGRATION_ORIGIN_SLIME_MINERAL_POWDER_LINE_ULTRA, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT,MagicExpansionItems.INTEGRATION_ORIGIN_SLIME_MINERAL_POWDER_LINE,MagicExpansionItems.ELEMENT_INGOT,
                MagicExpansionItems.INTEGRATION_ORIGIN_SLIME_MINERAL_POWDER_LINE,MagicExpansionItems.SPEED_ELEMENT_64,MagicExpansionItems.INTEGRATION_ORIGIN_SLIME_MINERAL_POWDER_LINE,
                MagicExpansionItems.AMETHYST_SHARD,MagicExpansionItems.INTEGRATION_ORIGIN_SLIME_MINERAL_POWDER_LINE,MagicExpansionItems.AMETHYST_SHARD
        })
                .setCapacity(1314)
                .setConsumption(260)
                .setProcessingSpeed(1)
                .addRecipe(1, new ItemStack[] {sfItemAmount(SlimefunItems.SIFTED_ORE,64)},
                        new ItemStack[] {sfItemAmount(SlimefunItems.IRON_DUST,64),sfItemAmount(SlimefunItems.GOLD_DUST,64),sfItemAmount(SlimefunItems.LEAD_DUST,64),
                                sfItemAmount(SlimefunItems.SILVER_DUST,64),sfItemAmount(SlimefunItems.COPPER_DUST,64),sfItemAmount(SlimefunItems.ALUMINUM_DUST,64),
                                sfItemAmount(SlimefunItems.MAGNESIUM_DUST,64),sfItemAmount(SlimefunItems.TIN_DUST,64),sfItemAmount(SlimefunItems.ZINC_DUST,64),sfItemAmount(SlimefunItems.STONE_CHUNK,64)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.GRAVEL,32)},
                        new ItemStack[] {new ItemStack(Material.IRON_NUGGET,64),new ItemStack(Material.CLAY_BALL,64),
                                new ItemStack(Material.FLINT,64),sfItemAmount(SlimefunItems.SIFTED_ORE,64)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.COBBLESTONE,64)},
                        new ItemStack[] {new ItemStack(Material.GRAVEL,48)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.BONE,16)},
                        new ItemStack[] {new ItemStack(Material.BONE_MEAL,64)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.BLAZE_ROD,16)},
                        new ItemStack[] {new ItemStack(Material.BLAZE_POWDER,64)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.DIRT,64)},
                        new ItemStack[] {sfItemAmount(SlimefunItems.STONE_CHUNK,64)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.DIAMOND,16)},
                        new ItemStack[] {sfItemAmount(SlimefunItems.CARBON,64)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.NETHER_WART,16)},
                        new ItemStack[] {sfItemAmount(SlimefunItems.MAGIC_LUMP_1,64)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.ENDER_EYE,16)},
                        new ItemStack[] {sfItemAmount(SlimefunItems.ENDER_LUMP_1,64)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.SOUL_SAND,64)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ,64),new ItemStack(Material.NETHER_WART,64),
                                new ItemStack(Material.BLAZE_POWDER,64),new ItemStack(Material.GOLD_NUGGET,64),
                                new ItemStack(Material.GLOWSTONE_DUST,64),new ItemStack(Material.GHAST_TEAR,64)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.SOUL_SOIL,64)},
                        new ItemStack[] {new ItemStack(Material.QUARTZ,64),new ItemStack(Material.NETHER_WART,64),
                                new ItemStack(Material.BLAZE_POWDER,64),new ItemStack(Material.GOLD_NUGGET,64),
                                new ItemStack(Material.GLOWSTONE_DUST,64),new ItemStack(Material.GHAST_TEAR,64)})
                .addRecipe(1, new ItemStack[] {new ItemStack(Material.SAND,64)},
                        new ItemStack[] {sfItemAmount(SlimefunItems.SALT,64)})
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

        // 预制建筑-永雏塔菲
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_TAFEI, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                MagicExpansionItems.REDSTONE_1,sfItemAmount(MagicExpansionItems.IRON_INGOT_1,2),MagicExpansionItems.OAK_LOG_1,
                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COLOR_WOOL_1,MagicExpansionItems.COLOR_CONCRETE_1,
                MagicExpansionItems.COLOR_TERRACOTTA_1,null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"tafei",60).register(plugin);
        // 预制建筑-维什戴尔
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_WISH_DALE, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                MagicExpansionItems.REDSTONE_1,sfItemAmount(MagicExpansionItems.IRON_INGOT_1,2),MagicExpansionItems.OAK_LOG_1,
                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COLOR_TERRACOTTA_1,MagicExpansionItems.COLOR_CONCRETE_1,
                new ItemStack(Material.RED_WOOL),null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"wish_dale",60).register(plugin);
        // 预制建筑-千岛爱音
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_ANON, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_LEAVES_1,15),sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,2),MagicExpansionItems.OAK_LOG_1,
                MagicExpansionItems.COLOR_WOOL_1,MagicExpansionItems.STONE_1,MagicExpansionItems.GLASS_1,
                NamedTagBuilder.nameTag("anon"),null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"anon",60).register(plugin);


        // 预制建筑-dora像素画
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_DORA_PICTURE, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                new ItemStack(Material.PINK_CONCRETE,64),new ItemStack(Material.BLACK_CONCRETE,64),new ItemStack(Material.SNOW_BLOCK,64),
                new ItemStack(Material.SMOOTH_QUARTZ,64),new ItemStack(Material.PINK_CONCRETE_POWDER,64),new ItemStack(Material.PURPLE_CONCRETE_POWDER,64),
                new ItemStack(Material.CHERRY_PLANKS,64),new ItemStack(Material.PURPLE_CONCRETE,64),new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"dora_picture",60).register(plugin);

        // 预制建筑-橡木小屋
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_HOUSE_OAK, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,7),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),
                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COBBLESTONE_1,new ItemStack(Material.OAK_LEAVES,32),
                null,null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"oak_house",60).register(plugin);
        // 预制建筑-云杉小屋
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_HOUSE_SPRUCE, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,7),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),
                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COBBLESTONE_1,new ItemStack(Material.SPRUCE_LEAVES,32),
                null,null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"spruce_house",60).register(plugin);
        // 预制建筑-樱花小屋
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_HOUSE_CHERRY, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,7),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),
                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COBBLESTONE_1,new ItemStack(Material.CHERRY_LEAVES,32),
                null,null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"cherry_house",60).register(plugin);
        // 预制建筑-红树小屋
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_HOUSE_MANGROVE, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,7),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),
                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COBBLESTONE_1,new ItemStack(Material.MANGROVE_LEAVES,32),
                null,null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"mangrove_house",60).register(plugin);
        // 预制建筑-苔藓小屋
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_HOUSE_MOSS, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,7),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),
                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COBBLESTONE_1,new ItemStack(Material.MOSS_BLOCK,32),
                null,null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"moss_house",60).register(plugin);
        // 预制建筑-风车小屋
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_HOUSE_WIND_CAR, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,7),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),
                MagicExpansionItems.LIGHT_1,MagicExpansionItems.COBBLESTONE_1,new ItemStack(Material.WHITE_WOOL,32),
                null,null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"wind_car_house",60).register(plugin);


        // 预制建筑-小酒吧
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_WINE_BAR, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_LOG_1,21),sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,7),sfItemAmount(MagicExpansionItems.GLASS_1,2),
                sfItemAmount(MagicExpansionItems.OAK_LOG_1,2),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,2),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,1),
                NamedTagBuilder.nameTag("WineBar"),null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"wine_bar",60).register(plugin);
        // 预制建筑-钓鱼港口
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_FISHING_PORT, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_LOG_1,2),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,2),sfItemAmount(MagicExpansionItems.LIGHT_1,1),
                sfItemAmount(MagicExpansionItems.OAK_LOG_1,1),sfItemAmount(MagicExpansionItems.COLOR_LEAVES_1,1),NamedTagBuilder.nameTag("FishingPort"),
                null,null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"fishing_port",60).register(plugin);
        // 预制建筑-烘焙房
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_BAKERY, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,2),sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,3),
                sfItemAmount(MagicExpansionItems.OAK_LOG_1,1),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,1),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,1),
                NamedTagBuilder.nameTag("Bakery"),null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"bakery",60).register(plugin);
        // 预制建筑-kfc-small
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_KFC_SMALL, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,10),sfItemAmount(MagicExpansionItems.GLASS_1,2),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,6),
                sfItemAmount(MagicExpansionItems.COLOR_LEAVES_1,1),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,1),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,1),
                NamedTagBuilder.nameTag("KFCSmall"),null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"kfc_little",60).register(plugin);
        // 预制建筑-蜜雪冰城
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_LITTLE_MI_XUE, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,6),sfItemAmount(MagicExpansionItems.GLASS_1,1),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,2),
                sfItemAmount(MagicExpansionItems.OAK_LOG_1,1),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,1),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,1),
                NamedTagBuilder.nameTag("MiXueBingCheng"),null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"little_mi_xue",60).register(plugin);
        // 预制建筑-日式町屋
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_JAPAN_HOUSE, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COBBLESTONE_1,5),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,4),sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,2),
                sfItemAmount(MagicExpansionItems.IRON_INGOT_1,2),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,1),NamedTagBuilder.nameTag("JapanHouse"),
                null,null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"japan_house_1",60).register(plugin);
        // 预制建筑-农场谷仓
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_FARM_BARN, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_LOG_1,6),sfItemAmount(MagicExpansionItems.GLASS_1,1),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,2),
                sfItemAmount(MagicExpansionItems.COLOR_LEAVES_1,1),new ItemStack(Material.IRON_INGOT,31),NamedTagBuilder.nameTag("FarmBarn"),
                null,null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"farm_barn",60).register(plugin);
        // 预制建筑-水果店
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_FRUIT_SHOP, PRE_BUILDINGS_MACHINE, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,3),sfItemAmount(MagicExpansionItems.GLASS_1,3),sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,1),
                sfItemAmount(MagicExpansionItems.OAK_LOG_1,2),new ItemStack(Material.QUARTZ_BLOCK,64),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,1),
                NamedTagBuilder.nameTag("FruitShop"),null,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"fruit_shop",60).register(plugin);










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
        // 预制建筑-麦当劳
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_MCDONALDS, PRE_BUILDINGS_MACHINE_ADVANCED, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,48),sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,6),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,6),
                sfItemAmount(MagicExpansionItems.IRON_INGOT_1,8),sfItemAmount(MagicExpansionItems.COLOR_LOG_2,1),sfItemAmount(MagicExpansionItems.REDSTONE_2,1),
                NamedTagBuilder.nameTag("Mcdonalds"),MagicExpansionItems.SPACE_INFINITY_MAGIC,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"mcdonalds",60*60*12).register(plugin);

        //先写大型的
        // 预制建筑-月兔商店
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_MOON_RABBIT_SHOP, PRE_BUILDINGS_MACHINE_ADVANCED, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,4),sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,36),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,2),
                sfItemAmount(MagicExpansionItems.STONE_2,2),sfItemAmount(MagicExpansionItems.OAK_LOG_1,1),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,2),
                NamedTagBuilder.nameTag("MoonRabbitShop"),MagicExpansionItems.SPACE_INFINITY_MAGIC,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"moon_rabbit_shop",60*60*12).register(plugin);
        // 预制建筑-中型马厩
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_MIDDLE_HORSE_HOUSE, PRE_BUILDINGS_MACHINE_ADVANCED, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_LOG_1,10),sfItemAmount(MagicExpansionItems.COLOR_LEAVES_1,2),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,2),
                sfItemAmount(MagicExpansionItems.STONE_2,2),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,1),sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,2),
                NamedTagBuilder.nameTag("MiddleHorseHouse"),MagicExpansionItems.SPACE_INFINITY_MAGIC,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"middle_horse_house",60*60*12).register(plugin);
        // 预制建筑-四合院
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_SI_HE_YUAN, PRE_BUILDINGS_MACHINE_ADVANCED, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,14),sfItemAmount(MagicExpansionItems.COLOR_LEAVES_1,6),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),
                sfItemAmount(MagicExpansionItems.COBBLESTONE_1,5),sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,8),sfItemAmount(MagicExpansionItems.OAK_LOG_1,5),
                NamedTagBuilder.nameTag("SiHeYuan"),MagicExpansionItems.SPACE_INFINITY_MAGIC,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"si_he_yuan",60*60*12).register(plugin);
        // 预制建筑-KFC中型
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_KFC_MIDDLE, PRE_BUILDINGS_MACHINE_ADVANCED, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,23),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,9),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,19),
                sfItemAmount(MagicExpansionItems.COLOR_LOG_1,5),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,3),sfItemAmount(MagicExpansionItems.STONE_1,2),
                NamedTagBuilder.nameTag("KFCMiddle"),MagicExpansionItems.SPACE_INFINITY_MAGIC,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"kfc_middle",60*60*12).register(plugin);
        // 预制建筑-大雪王
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_LARGE_SNOW_KING, PRE_BUILDINGS_MACHINE_ADVANCED, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,25),sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,21),sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,18),
                sfItemAmount(MagicExpansionItems.COLOR_LOG_1,3),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,2),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,2),
                NamedTagBuilder.nameTag("LargeSnowKing"),MagicExpansionItems.SPACE_INFINITY_MAGIC,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"large_snow_king",60*60*12).register(plugin);
        // 预制建筑-中型别墅
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_MIDDLE_VILLA, PRE_BUILDINGS_MACHINE_ADVANCED, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_LOG_2,1),sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_2,1),sfItemAmount(MagicExpansionItems.STONE_BRICKS_1,7),
                sfItemAmount(MagicExpansionItems.OAK_LOG_1,8),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,2),new ItemStack(Material.DRAGON_EGG),
                NamedTagBuilder.nameTag("MiddleVilla"),MagicExpansionItems.SPACE_INFINITY_MAGIC,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"middle_villa_1",60*60*12).register(plugin);
        // 预制建筑-樱花商店
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_SAKURA_SHOP, PRE_BUILDINGS_MACHINE_ADVANCED, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.COLOR_CONCRETE_1,1),sfItemAmount(MagicExpansionItems.COLOR_TERRACOTTA_1,4),sfItemAmount(MagicExpansionItems.COLOR_LOG_1,6),
                sfItemAmount(MagicExpansionItems.GLASS_1,4),sfItemAmount(MagicExpansionItems.COLOR_LEAVES_1,5),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,7),
                NamedTagBuilder.nameTag("SakuraShop"),MagicExpansionItems.SPACE_INFINITY_MAGIC,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"sakura_shop",60*60*12).register(plugin);
        // 预制建筑-蟹堡王
        new PreBuildingTree(magicexpansionprebuilding, MagicExpansionItems.PRE_BUILDING_KRUSTY_KRAB, PRE_BUILDINGS_MACHINE_ADVANCED, new ItemStack[] {
                sfItemAmount(MagicExpansionItems.OAK_LOG_1,35),sfItemAmount(MagicExpansionItems.COBBLESTONE_1,16),sfItemAmount(MagicExpansionItems.COLOR_WOOL_1,3),
                sfItemAmount(MagicExpansionItems.GLASS_1,7),sfItemAmount(MagicExpansionItems.IRON_INGOT_1,3),sfItemAmount(MagicExpansionItems.LIGHT_1,3),
                NamedTagBuilder.nameTag("KrustyKrab"),MagicExpansionItems.SPACE_INFINITY_MAGIC,new CustomItemStack(CustomHead.getHead("a92974681687689da7dda3f19b7e4a53fe0dd09befd7fa8838744384c9d1ac71"),getGradientName("此配方为无序配方"))
        },"krusty_krab",60*60*12).register(plugin);





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






        //MIHOYO角色，要放在激光扫描仪下面
        //星光扫描仪-盲盒拆解器
        new RandomBoxMachine(magicexpansionenergy, MagicExpansionItems.MIHOYO_STAR_RAY_MACHINE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.IRON_INGOT),MagicExpansionItems.LIGHT_CORE,new ItemStack(Material.IRON_INGOT),
                MagicExpansionItems.LIGHT_CORE,new ItemStack(Material.LIGHT),MagicExpansionItems.LIGHT_CORE,
                new ItemStack(Material.IRON_INGOT),MagicExpansionItems.LIGHT_CORE,new ItemStack(Material.IRON_INGOT)
        })
                .addRecipe(0, new ItemStack[]{MagicExpansionItems.HONKAI_STAR_RAIL_BOX}, new ItemStack[]{MagicExpansionItems.JING_LIU})
                .addRecipe(0, new ItemStack[]{MagicExpansionItems.HONKAI_STAR_RAIL_BOX}, new ItemStack[]{MagicExpansionItems.SILVER_WOLF})
                .addRecipe(0, new ItemStack[]{MagicExpansionItems.HONKAI_STAR_RAIL_BOX}, new ItemStack[]{MagicExpansionItems.KAFKA})
                .addRecipe(0, new ItemStack[]{MagicExpansionItems.HONKAI_STAR_RAIL_BOX}, new ItemStack[]{MagicExpansionItems.SUNDAY})
                .addRecipe(0, new ItemStack[]{MagicExpansionItems.HONKAI_STAR_RAIL_BOX}, new ItemStack[]{MagicExpansionItems.HUOHUO})
                .addRecipe(0, new ItemStack[]{MagicExpansionItems.HONKAI_STAR_RAIL_BOX}, new ItemStack[]{MagicExpansionItems.LUNAE})
                .register(plugin);
        //崩铁
        new HonkaiStarRailBox(magicexpansionhonkai, MagicExpansionItems.HONKAI_STAR_RAIL_BOX, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.IRON_INGOT),new ItemStack(Material.GUNPOWDER),new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.GUNPOWDER),SlimefunItems.MAGIC_SUGAR,new ItemStack(Material.GUNPOWDER),
                new ItemStack(Material.IRON_INGOT),new ItemStack(Material.GUNPOWDER),new ItemStack(Material.IRON_INGOT)
        }).register(plugin);

        new SlimefunItem(magicexpansionhonkai, MagicExpansionItems.JING_LIU, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(CustomHead.BLUE_GIFT_BOX.getItem(), "&c&l注意：&c&l该物品可从崩铁盲盒中抽取"),null,
                null,null,null
        }).register(plugin);

        new SlimefunItem(magicexpansionhonkai, MagicExpansionItems.SILVER_WOLF, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(CustomHead.BLUE_GIFT_BOX.getItem(), "&c&l注意：&c&l该物品可从崩铁盲盒中抽取"),null,
                null,null,null
        }).register(plugin);

        new SlimefunItem(magicexpansionhonkai, MagicExpansionItems.KAFKA, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(CustomHead.BLUE_GIFT_BOX.getItem(), "&c&l注意：&c&l该物品可从崩铁盲盒中抽取"),null,
                null,null,null
        }).register(plugin);

        new SlimefunItem(magicexpansionhonkai, MagicExpansionItems.SUNDAY, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(CustomHead.BLUE_GIFT_BOX.getItem(), "&c&l注意：&c&l该物品可从崩铁盲盒中抽取"),null,
                null,null,null
        }).register(plugin);

        new SlimefunItem(magicexpansionhonkai, MagicExpansionItems.LUNAE, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(CustomHead.BLUE_GIFT_BOX.getItem(), "&c&l注意：&c&l该物品可从崩铁盲盒中抽取"),null,
                null,null,null
        }).register(plugin);

        new SlimefunItem(magicexpansionhonkai, MagicExpansionItems.HUOHUO, SPECIAL_RECIPE_TYPE, new ItemStack[] {
                null,null,null,
                null,new CustomItemStack(CustomHead.BLUE_GIFT_BOX.getItem(), "&c&l注意：&c&l该物品可从崩铁盲盒中抽取"),null,
                null,null,null
        }).register(plugin);



        //空岛系列
        new SingleCubeOrigin(magicexpansionskyblock, MagicExpansionItems.SINGLE_CUBE_ORIGIN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.TIN_INGOT,MagicExpansionItems.GOLD_INGOT, MagicExpansionItems.COPPER_INGOT,
                MagicExpansionItems.ALUMINUM_INGOT,new ItemStack(Material.DIRT),MagicExpansionItems.LEAD_INGOT,
                MagicExpansionItems.ZINC_INGOT,MagicExpansionItems.SILVER_INGOT,MagicExpansionItems.MAGNESIUM_INGOT,
        }).register(plugin);

        new SingleCubeOre(magicexpansionskyblock, MagicExpansionItems.SINGLE_CUBE_ORE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.IRON_ORE),new ItemStack(Material.COPPER_ORE), new ItemStack(Material.GOLD_ORE),
                new ItemStack(Material.EMERALD_ORE),MagicExpansionItems.SINGLE_CUBE_ORIGIN,new ItemStack(Material.DIAMOND_ORE),
                new ItemStack(Material.COAL_ORE),new ItemStack(Material.NETHER_QUARTZ_ORE),new ItemStack(Material.REDSTONE_ORE),
        }).register(plugin);




        //空岛系列-钻石工具
        new InfiniteTool(magicexpansionskyblock, MagicExpansionItems.SINGLE_DIAMOND_PICKAXE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.DIAMOND,MagicExpansionItems.DIAMOND, MagicExpansionItems.DIAMOND,
                null,MagicExpansionItems.STICK,null,
                null,MagicExpansionItems.STICK,null,
        }).register(plugin);
        //空岛系列-钻石工具
        new InfiniteTool(magicexpansionskyblock, MagicExpansionItems.SINGLE_DIAMOND_AXE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null,MagicExpansionItems.DIAMOND, MagicExpansionItems.DIAMOND,
                null,MagicExpansionItems.STICK,MagicExpansionItems.DIAMOND,
                null,MagicExpansionItems.STICK,null,
        }).register(plugin);
        //空岛系列-钻石工具
        new InfiniteTool(magicexpansionskyblock, MagicExpansionItems.SINGLE_DIAMOND_SHOVEL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null,MagicExpansionItems.DIAMOND,null,
                null,MagicExpansionItems.STICK,null,
                null,MagicExpansionItems.STICK,null,
        }).register(plugin);
        //空岛系列-钻石工具
        new InfiniteTool(magicexpansionskyblock, MagicExpansionItems.SINGLE_DIAMOND_HOE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null,MagicExpansionItems.DIAMOND, MagicExpansionItems.DIAMOND,
                null,MagicExpansionItems.STICK,null,
                null,MagicExpansionItems.STICK,null,
        }).register(plugin);













        //GEO资源挖掘机，要放在GEO资源下面

        new GEOMiner(magicexpansionenergy, MagicExpansionItems.GEO_MINER_PLUS, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT, SlimefunItems.GEO_MINER, MagicExpansionItems.ELEMENT_INGOT,
                SlimefunItems.GEO_MINER, AMETHYST_SHARD, SlimefunItems.GEO_MINER,
                SlimefunItems.GPS_TRANSMITTER_4, SlimefunItems.GEO_MINER, SlimefunItems.GPS_TRANSMITTER_4
        })
                .setCapacity(1314)
                .setEnergyConsumption(260)
                .setProcessingSpeed(1314)
                .register(plugin);


        new FiveElementsMiner(magicexpansionenergy, MagicExpansionItems.FIVE_ELEMENT_MINER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MagicExpansionItems.ELEMENT_INGOT, SlimefunItems.PORTABLE_GEO_SCANNER, MagicExpansionItems.ELEMENT_INGOT,
                SlimefunItems.GPS_TELEPORTER_PYLON, ELEMENT_INGOT, SlimefunItems.GPS_TELEPORTER_PYLON,
                MagicExpansionItems.AMETHYST_SHARD, SlimefunItems.GEO_MINER, MagicExpansionItems.NETHERITE_INGOT
        })
                .setCapacity(1314)
                .setEnergyConsumption(260)
                .setProcessingSpeed(1)
                .register(plugin);

        //条件注册，1.21魔法兼容问题
        if(IfItemXist("MAGIC_REDSTONE")&&IfItemXist("MAGIC_COSMIC_DUST")){
            new RSCMagicMiner(magicexpansionrscmagic, MagicExpansionItems.RSC_MAGIC_MINER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                    null,SlimefunItems.GEO_MINER, null,
                    null, SlimefunItems.OUTPUT_CHEST, null,
                    new ItemStack(Material.REDSTONE), REDSTONE, new ItemStack(Material.REDSTONE)
            })
                    .setCapacity(1314)
                    .setEnergyConsumption(260)
                    .setProcessingSpeed(1)
                    .register(plugin);
        }


    }




    private static void registerUIBlockInContribution(SlimefunItemStack itemStack, MagicExpansion plugin) {
        new UnplaceableBlock(
                magicexpansioncontribution, // 假设这是某个已定义的贡献对象
                itemStack,
                RecipeType.NULL,
                new ItemStack[] {
                        null, null, null,
                        null, null, null,
                        null, null, null
                }
        ).register(plugin);
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
