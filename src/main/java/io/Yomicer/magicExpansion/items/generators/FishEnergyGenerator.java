package io.Yomicer.magicExpansion.items.generators;

import com.xzavier0722.mc.plugin.slimefun4.storage.controller.SlimefunBlockData;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.Yomicer.magicExpansion.items.abstracts.MenuBlock;
import io.Yomicer.magicExpansion.items.misc.fish.Fish;
import io.Yomicer.magicExpansion.items.misc.fish.FishKeys;
import io.Yomicer.magicExpansion.utils.CustomHeadUtils.CustomHead;
import io.Yomicer.magicExpansion.utils.machineLore.ChargeLore;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetProvider;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.DirtyChestMenu;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.xml.stream.events.Namespace;

import java.util.*;

import static io.Yomicer.magicExpansion.items.misc.fish.Fish.MYSTIC_EEL;
import static io.Yomicer.magicExpansion.items.misc.fish.Fish.XueFish;
import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;


public class FishEnergyGenerator extends MenuBlock implements EnergyNetProvider, RecipeDisplayItem {


    private final int Capacity;
    private final int power = 50000;
    private final String fishTypeTarget = "MYSTIC_EEL";
    private final int power2 = 200;
    private final String fishTypeTarget2 = "XueFish";

    // 1. 定义可扩展的鱼能量产出表（集中管理，易扩展）
    private final Map<String, Integer> FISH_POWER_MAP = new HashMap<>() {{
        put("MYSTIC_EEL",     50000);  // 神秘鳗鱼：高能量
        put("XueFish",        200);    // 雪鱼：低能量
        put("GlowStoneDustFish",      3000);    // 雪鱼：低能量

    }};
    // ✅ 鱼类型 -> 显示用的桶材质
    private final Map<String, Material> FISH_BUCKET_MAP = new HashMap<>() {{
        put("MYSTIC_EEL",   Material.TROPICAL_FISH_BUCKET);
        put("XueFish",      Material.COD_BUCKET);
        put("GlowStoneDustFish",      Material.PUFFERFISH_BUCKET);
        // 👉 新增鱼？直接加：put("GlowStoneFish", Material.SALMON_BUCKET);
    }};


    public FishEnergyGenerator(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int Capacity) {
        super(category, item, recipeType, recipe);
        this.Capacity = Capacity;
    }

    @Override
    protected void setup(BlockMenuPreset blockMenuPreset) {
        blockMenuPreset.drawBackground(new CustomItemStack(Material.PINK_STAINED_GLASS_PANE," "),new int[] {

                0,1,2,3        ,5,6,7,8,
                9,10,11,         15,16,17,
                18,19,20,21,  23,24,25,26,
                27,28,29,30,  32,33,34,35,
                36,37,38,39,  41,42,43,44,
                45,46,47,48,49,50,51,52,53
        });
        blockMenuPreset.drawBackground(new CustomItemStack(CustomHead.getHead("7aa17a1abe18d3830391e970a582553ffe0b8afe36ea3c74b5eb521f9c5a54c0") ,getGradientName("⇧这里放电鳗⇧")),
                new int[] {
                22,   31
        });
        blockMenuPreset.drawBackground(new CustomItemStack(CustomHead.getHead("26314d31b095e4d421760497be6a156f459d8c9957b7e6b1c12deb4e47860d71") ,getGradientName("⇨这里放电鳗⇨")),
                new int[] {
                        12
                });
        blockMenuPreset.drawBackground(new CustomItemStack(CustomHead.getHead("5fa22cc6ddd569a6ce894aab906b73db8ba89f6a2bb071bab22e57a4f0885abf") ,getGradientName("⇦这里放电鳗⇦")),
                new int[] {
                        14
                });
        blockMenuPreset.drawBackground(new CustomItemStack(CustomHead.getHead("ab93edba42c7bbfa94b12f89bd55d95862259cdb6293c83b90b931ae4d139088") ,getGradientName("⇩这里放电鳗⇩")),
                new int[] {
                        4
                });
        blockMenuPreset.drawBackground(new CustomItemStack(new ItemStack(Material.RED_STAINED_GLASS_PANE),"§c未发电"),
                new int[] {
                        40
                });

    }

    @Nonnull
    @Override
    protected int[] getInputSlots(DirtyChestMenu dirtyChestMenu, ItemStack itemStack) {
        return new int[]{13};
    }

    @Override
    protected int[] getInputSlots() {
        return new int[]{13};
    }

    @Override
    protected int[] getOutputSlots() {
        return new int[]{13};
    }

    @Override
    public int getGeneratedOutput(Location l, SlimefunBlockData data) {

        BlockMenu inv = StorageCacheUtils.getMenu(l);

        int gen = 0;
        ItemStack fish = null;
        ItemMeta meta = null;
        if (inv != null) {
            fish = inv.getItemInSlot(13);
            if (fish != null && !fish.getType().isAir()) {
                fish = fish.clone();
            }
        }
        if(fish != null) {
            meta = fish.getItemMeta();
        }
        if(meta != null) {

            PersistentDataContainer pdc = meta.getPersistentDataContainer();

            String fishType = null;
            double weight = 0.0;
            String weightRarityName = null;

            if (pdc.has(FishKeys.FISH_TYPE, PersistentDataType.STRING)) {
                fishType = pdc.get(FishKeys.FISH_TYPE, PersistentDataType.STRING);
            }

            if (pdc.has(FishKeys.FISH_WEIGHT, PersistentDataType.DOUBLE)) {
                weight = pdc.get(FishKeys.FISH_WEIGHT, PersistentDataType.DOUBLE);
            }

            if (pdc.has(FishKeys.FISH_WEIGHT_RARITY, PersistentDataType.STRING)) {
                weightRarityName = pdc.get(FishKeys.FISH_WEIGHT_RARITY, PersistentDataType.STRING);
            }

            // ✅ 核心逻辑：从映射表中查找该鱼的能量基础值
            if (fishType != null && weight != 0.0 && weightRarityName != null) {
                Integer basePower = FISH_POWER_MAP.get(fishType);
                if (basePower != null) {
                    double multiplier = Fish.WeightRarity.getMultiplierByName(weightRarityName);
                    gen = (int) (basePower * weight * multiplier);
                }
            }
        }
        if (inv != null && inv.hasViewer()) {
            if (gen == 0) {
                inv.replaceExistingItem(40, new CustomItemStack(
                        Material.LANTERN,
                        getGradientName("未发电"),
                        getGradientName("已储存: " + ChargeLore.format(getCharge(l)) + " J")
                ));
            } else if (gen > 0) {
                inv.replaceExistingItem(40, new CustomItemStack(
                        Material.SOUL_LANTERN,
                        getGradientName("发电中"),
                        getGradientName("类型: " + getPowerType()),
                        getGradientName("发电速度: " + ChargeLore.formatEnergy(gen) + " J/s "),
                        getGradientName("已储存: " + ChargeLore.format(getCharge(l)) + " J")
                ));
            }
        }
        return gen;
    }

    @Override
    public int getCapacity() {
        return this.Capacity;
    }

    @Nonnull
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.GENERATOR;
    }

    @Override
    public @NotNull List<ItemStack> getDisplayRecipes() {

        List<ItemStack> display = new ArrayList<>();
        display.add(new CustomItemStack(Material.KNOWLEDGE_BOOK, getGradientName("使用说明⇩"),getGradientName("请务必仔细阅读")));
        display.add(new CustomItemStack(Material.BOOK, getGradientName("使用方法："),getGradientName("将电鳗放入到机器槽位中可进行发电")
                ,getGradientName("电鳗的大小会影响发电量")
                ,getGradientName("电鳗的稀有度也会影响发电量")));
        display.add(new CustomItemStack(Material.KNOWLEDGE_BOOK, getGradientName("使用说明⇩"),getGradientName("请务必仔细阅读")));
        display.add(new CustomItemStack(Material.BOOK, getGradientName("发电量算法："),getGradientName("每个机器只能放置一条电鳗")
                ,getGradientName("发电量 = 电鳗重量 * "+"电鳗单位重量发电量"+" * 电鳗稀有程度")
                ,getGradientName("普通/稀有/超级稀有 : 1/4/11")));
        display.add(new CustomItemStack(Material.KNOWLEDGE_BOOK, getGradientName("使用说明⇩"),getGradientName("请务必仔细阅读")));
        display.add(new CustomItemStack(Material.BOOK, getGradientName("发电机更新说明："),getGradientName("任何特殊魔法鱼都有可能能够发电")
                ,getGradientName("发电量 = 鱼类重量*"+ " 鱼单位重量发电量 " +"*重量稀有等级")
                ,getGradientName("普通/稀有/超级稀有 : 1/4/11")));
        display.add(new CustomItemStack(CustomHead.getHead("26314d31b095e4d421760497be6a156f459d8c9957b7e6b1c12deb4e47860d71"),getGradientName("支持的鱼类 ⇨")));
        display.add(new CustomItemStack(CustomHead.getHead("26314d31b095e4d421760497be6a156f459d8c9957b7e6b1c12deb4e47860d71"),getGradientName("支持的鱼类 ⇨")));
//        display.add(new CustomItemStack(Material.TROPICAL_FISH_BUCKET,MYSTIC_EEL.getDisplayName(),getGradientName("每kg每秒发电量："+ChargeLore.formatEnergy(power)+" J")));
//        display.add(new CustomItemStack(Material.COD_BUCKET,XueFish.getDisplayName(),getGradientName("每kg每秒发电量："+ChargeLore.formatEnergy(power2)+" J")));
        // ✅ 自动为所有在 FISH_POWER_MAP 中注册的鱼生成展示项
        for (String fishType : FISH_POWER_MAP.keySet()) {
            Material bucketMat = FISH_BUCKET_MAP.getOrDefault(fishType, Material.BUCKET);
            Fish fish = Fish.fromString(fishType);
            if (fish == null) {
                continue; // 跳过无效类型
            }
            String displayName = fish.getDisplayName();
            int power = FISH_POWER_MAP.get(fishType);
            display.add(new CustomItemStack(
                    bucketMat,
                    displayName,
                    getGradientName("每kg每秒发电量：" + ChargeLore.formatEnergy(power) + " J")
            ));
        }

        return display;
    }

}
