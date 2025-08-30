package io.Yomicer.magicExpansion.items.generators;

import com.xzavier0722.mc.plugin.slimefun4.storage.controller.SlimefunBlockData;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.Yomicer.magicExpansion.items.abstracts.MenuBlock;
import io.Yomicer.magicExpansion.items.misc.fish.Fish;
import io.Yomicer.magicExpansion.items.misc.fish.FishKeys;
import io.Yomicer.magicExpansion.utils.CustomHeadUtils.CustomHead;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetProvider;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.DirtyChestMenu;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static io.Yomicer.magicExpansion.items.misc.fish.Fish.*;
import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;
import static io.Yomicer.magicExpansion.utils.Utils.doGlow;

public class FishOutputMachine extends MenuBlock implements EnergyNetProvider, RecipeDisplayItem {

    private final int Capacity;
    public static final int ENERGY_CONSUMPTION = 500;
    private final String fishTypeCopperDust = "CopperDustFish";
    private final SlimefunItemStack outputCopperDust = SlimefunItems.COPPER_DUST;
    private final String fishTypeGoldDust = "GoldDustFish";
    private final SlimefunItemStack outputGoldDust = SlimefunItems.GOLD_DUST;
    private final String fishTypeIronDust = "IronDustFish";
    private final SlimefunItemStack outputIronDust = SlimefunItems.IRON_DUST;
    private final String fishTypeTinDust = "TinDustFish";
    private final SlimefunItemStack outputTinDust = SlimefunItems.TIN_DUST;
    private final String fishTypeSilverDust = "SilverDustFish";
    private final SlimefunItemStack outputSilverDust = SlimefunItems.SILVER_DUST;
    private final String fishTypeAluminumDust = "AluminumDustFish";
    private final SlimefunItemStack outputAluminumDust = SlimefunItems.ALUMINUM_DUST;
    private final String fishTypeLeadDust = "LeadDustFish";
    private final SlimefunItemStack outputLeadDust = SlimefunItems.LEAD_DUST;
    private final String fishTypeZincDust = "ZincDustFish";
    private final SlimefunItemStack outputZincDust = SlimefunItems.ZINC_DUST;
    private final String fishTypeMagnesiumDust = "MagnesiumDustFish";
    private final SlimefunItemStack outputMagnesiumDust = SlimefunItems.MAGNESIUM_DUST;


    public FishOutputMachine(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int Capacity) {
        super(category, item, recipeType, recipe);
        this.Capacity = Capacity;
    }

    @Override
    public void preRegister() {
        addItemHandler(new BlockTicker() {

            @Override
            public void tick(Block b, SlimefunItem sf, SlimefunBlockData data) {
                FishOutputMachine.this.tick(b);
            }

            @Override
            public boolean isSynchronized() {
                return true;
            }
        });
    }
    protected void tick(Block block) {
        BlockMenu inv = StorageCacheUtils.getMenu(block.getLocation());

        if(inv != null && inv.hasViewer()) {
            if (getCharge(block.getLocation()) < getEnergyConsumption()) {
                inv.addItem(40, new CustomItemStack(doGlow(Material.LANTERN), getGradientName("⚡机器停止运行⚡"),
                                getGradientName("请检查电力供应是否充足或鱼种是否符合")),
                        (player1, slot, item, action) -> false);
                return;
            }
        }

        ItemStack fish = null;
        ItemMeta meta = null;
        if (inv != null) {
            fish = inv.getItemInSlot(49);
            if (fish != null && !fish.getType().isAir()) {
                fish = fish.clone();
            }
        }
        if(fish != null) {
            meta = fish.getItemMeta();
        }
        ItemStack outItems = null;
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

            if (Objects.equals(fishType, fishTypeCopperDust) && weight != 0.0 && weightRarityName != null) {
                int num = (int) weight*Fish.WeightRarity.getMultiplierByName(weightRarityName);
                if(num <=0) num =1;
                outItems = new SlimefunItemStack(outputCopperDust,num);
            } else if (Objects.equals(fishType, fishTypeGoldDust) && weight != 0.0 && weightRarityName != null) {
                int num = (int) weight*Fish.WeightRarity.getMultiplierByName(weightRarityName);
                if(num <=0) num =1;
                outItems = new SlimefunItemStack(outputGoldDust,num);
            }else if (Objects.equals(fishType, fishTypeIronDust) && weight != 0.0 && weightRarityName != null) {
                int num = (int) (weight * Fish.WeightRarity.getMultiplierByName(weightRarityName));
                if (num <= 0) num = 1;
                outItems = new SlimefunItemStack(outputIronDust, num);
            }
            else if (Objects.equals(fishType, fishTypeTinDust) && weight != 0.0 && weightRarityName != null) {
                int num = (int) (weight * Fish.WeightRarity.getMultiplierByName(weightRarityName));
                if (num <= 0) num = 1;
                outItems = new SlimefunItemStack(outputTinDust, num);
            }
            else if (Objects.equals(fishType, fishTypeSilverDust) && weight != 0.0 && weightRarityName != null) {
                int num = (int) (weight * Fish.WeightRarity.getMultiplierByName(weightRarityName));
                if (num <= 0) num = 1;
                outItems = new SlimefunItemStack(outputSilverDust, num);
            }
            else if (Objects.equals(fishType, fishTypeAluminumDust) && weight != 0.0 && weightRarityName != null) {
                int num = (int) (weight * Fish.WeightRarity.getMultiplierByName(weightRarityName));
                if (num <= 0) num = 1;
                outItems = new SlimefunItemStack(outputAluminumDust, num);
            }
            else if (Objects.equals(fishType, fishTypeLeadDust) && weight != 0.0 && weightRarityName != null) {
                int num = (int) (weight * Fish.WeightRarity.getMultiplierByName(weightRarityName));
                if (num <= 0) num = 1;
                outItems = new SlimefunItemStack(outputLeadDust, num);
            }
            else if (Objects.equals(fishType, fishTypeZincDust) && weight != 0.0 && weightRarityName != null) {
                int num = (int) (weight * Fish.WeightRarity.getMultiplierByName(weightRarityName));
                if (num <= 0) num = 1;
                outItems = new SlimefunItemStack(outputZincDust, num);
            }
            else if (Objects.equals(fishType, fishTypeMagnesiumDust) && weight != 0.0 && weightRarityName != null) {
                int num = (int) (weight * Fish.WeightRarity.getMultiplierByName(weightRarityName));
                if (num <= 0) num = 1;
                outItems = new SlimefunItemStack(outputMagnesiumDust, num);
            }

        }
        if (outItems != null && inv != null) {
            removeCharge(block.getLocation(), getEnergyConsumption());
            inv.addItem(40, new CustomItemStack(doGlow(Material.SOUL_LANTERN), getGradientName("⚡机器正在运行⚡"),
                            getGradientName("请时刻注意电力供给及输出槽是否充裕")),
                    (player1, slot, item, action) -> false);
            pushAllItems(inv,outItems, getOutputSlots());
            return;
        }
        if (inv != null) {
            inv.addItem(40, new CustomItemStack(doGlow(Material.LANTERN), getGradientName("⚡机器停止运行⚡"),
                            getGradientName("请检查电力供应是否充足或鱼种是否符合")),
                    (player1, slot, item, action) -> false);
        }

    }

    protected void pushAllItems(BlockMenu menu, ItemStack item, int[] outputSlots) {
        if (item == null || item.getType() == Material.AIR || item.getAmount() <= 0) {
            return;
        }

        int totalAmount = item.getAmount();  // 总共有多少个
        int perPush = 64;                    // 每次塞64个

        while (totalAmount > 0) {
            ItemStack toPush = item.clone();
            toPush.setAmount(Math.min(totalAmount, perPush));  // 最后一次可能不足64

            menu.pushItem(toPush, outputSlots);  // 直接塞！不管有没有被拒绝（暴力！）

            totalAmount -= perPush;  // 每次减64，不管实际推进去多少（简单粗暴）
        }
    }

    public int getEnergyConsumption() {
        return ENERGY_CONSUMPTION;
    }



    @Override
    protected void setup(BlockMenuPreset var1) {
        var1.drawBackground(new CustomItemStack(Material.PINK_STAINED_GLASS_PANE," "),new int[] {

                36,37,38,42,43,44,
                45,46,47,  51,52,53,
        });
        var1.drawBackground(new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,"§b请将鱼放入到该槽位中"),new int[] {

                39,40,41,
                48,   50
        });

    }
    @Nonnull
    @Override
    protected int[] getInputSlots(DirtyChestMenu dirtyChestMenu, ItemStack itemStack) {
        return new int[]{49};
    }

    @Override
    protected int[] getInputSlots() {
        return new int[]{
                49
        };
    }

    @Override
    protected int[] getOutputSlots() {
        return new int[]{
                0,1,2,3,4,5,6,7,8,
                9,10,11,12,13,14,15,16,17,
                18,19,20,21,22,23,24,25,26,
                27,28,29,30,31,32,33,34,35,
        };
    }

    @Override
    public int getCapacity() {
        return Capacity;
    }

    @Override
    public @NotNull List<ItemStack> getDisplayRecipes() {

        List<ItemStack> display = new ArrayList<>();
        display.add(new CustomItemStack(Material.KNOWLEDGE_BOOK, getGradientName("使用说明⇩"),getGradientName("请务必仔细阅读")));
        display.add(new CustomItemStack(Material.BOOK, getGradientName("使用方法："),getGradientName("将魔法鱼放入到机器槽位中可进行生产")
                ,getGradientName("鱼的种类会影响最终产物种类")
                ,getGradientName("鱼的重量会影响最终产物数量")));
        display.add(new CustomItemStack(Material.KNOWLEDGE_BOOK, getGradientName("使用说明⇩"),getGradientName("请务必仔细阅读")));
        display.add(new CustomItemStack(Material.BOOK, getGradientName("产出量算法："),getGradientName("每个机器只能放置一条魔法鱼")
                ,getGradientName("产出量 = 重量(向下取整) * 魔法鱼稀有程度")
                ,getGradientName("普通/稀有/超级稀有 : 1/4/11")));
        display.add(new CustomItemStack(CustomHead.getHead("26314d31b095e4d421760497be6a156f459d8c9957b7e6b1c12deb4e47860d71"),getGradientName("支持的鱼类 ⇨")));
        display.add(new CustomItemStack(CustomHead.getHead("26314d31b095e4d421760497be6a156f459d8c9957b7e6b1c12deb4e47860d71"),getGradientName("产出的产物 ⇨")));

        display.add(new CustomItemStack(Material.PUFFERFISH_BUCKET,CopperDustFish.getDisplayName(),getGradientName("每秒产出个数："+ " 重量 * 魔法鱼稀有程度 ")));
        display.add(outputCopperDust);

        display.add(new CustomItemStack(Material.PUFFERFISH_BUCKET, GoldDustFish.getDisplayName(), getGradientName("每秒产出个数：" + " 重量 * 魔法鱼稀有程度 ")));
        display.add(outputGoldDust);

        display.add(new CustomItemStack(Material.PUFFERFISH_BUCKET, IronDustFish.getDisplayName(), getGradientName("每秒产出个数：" + " 重量 * 魔法鱼稀有程度 ")));
        display.add(outputIronDust);

        display.add(new CustomItemStack(Material.PUFFERFISH_BUCKET, TinDustFish.getDisplayName(), getGradientName("每秒产出个数：" + " 重量 * 魔法鱼稀有程度 ")));
        display.add(outputTinDust);

        display.add(new CustomItemStack(Material.PUFFERFISH_BUCKET, SilverDustFish.getDisplayName(), getGradientName("每秒产出个数：" + " 重量 * 魔法鱼稀有程度 ")));
        display.add(outputSilverDust);

        display.add(new CustomItemStack(Material.PUFFERFISH_BUCKET, AluminumDustFish.getDisplayName(), getGradientName("每秒产出个数：" + " 重量 * 魔法鱼稀有程度 ")));
        display.add(outputAluminumDust);

        display.add(new CustomItemStack(Material.PUFFERFISH_BUCKET, LeadDustFish.getDisplayName(), getGradientName("每秒产出个数：" + " 重量 * 魔法鱼稀有程度 ")));
        display.add(outputLeadDust);

        display.add(new CustomItemStack(Material.PUFFERFISH_BUCKET, ZincDustFish.getDisplayName(), getGradientName("每秒产出个数：" + " 重量 * 魔法鱼稀有程度 ")));
        display.add(outputZincDust);

        display.add(new CustomItemStack(Material.PUFFERFISH_BUCKET, MagnesiumDustFish.getDisplayName(), getGradientName("每秒产出个数：" + " 重量 * 魔法鱼稀有程度 ")));
        display.add(outputMagnesiumDust);
        return display;
    }
}
