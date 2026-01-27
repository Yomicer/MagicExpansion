package io.Yomicer.magicExpansion.items.misc;

import com.xzavier0722.mc.plugin.slimefun4.storage.controller.SlimefunBlockData;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.Yomicer.magicExpansion.MagicExpansion;
import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.Yomicer.magicExpansion.utils.ColorGradient;
import io.Yomicer.magicExpansion.utils.ConvertItem;
import io.Yomicer.magicExpansion.utils.CreateItem;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

import static io.Yomicer.magicExpansion.utils.Utils.doGlow;

public class ForceTwoToRsc extends SlimefunItem implements EnergyNetComponent {


    private final int power;
    private final int craftPerTick;
    private final int[] pinkBorder = {0,1,2,3,4,5,6,7,8, 9,17, 18,26, 27,35, 36,44, 45,46,47,48,49,50,51,52,53,
            13,22,31,40,};
    private final int[] inputSlots = {
            10, 11, 12,
            19, 20, 21,
            28, 29, 30,
            37, 38, 39,
    };
    private final int[] outputSlots = {
            14, 15, 16,
            23, 24, 25,
            32, 33, 34,
            41, 42, 43
    };

    public ForceTwoToRsc(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int power, int craftPerTick) {
        super(category, item, recipeType, recipe);

        this.power = power;
        this.craftPerTick = craftPerTick;
        constructMenu(ColorGradient.getGradientNameVer2("魔法2.0 To Rsc魔法 资源转换器"));
    }



    @Override
    public void preRegister() {
        addItemHandler(new BlockTicker() {

            @Override
            public void tick(Block b, SlimefunItem sf, SlimefunBlockData data) {
                ForceTwoToRsc.this.tick(b);
            }

            @Override
            public boolean isSynchronized() {
                return true;
            }
        });
    }

    protected void tick(Block block) {

        BlockMenu menu = StorageCacheUtils.getMenu(block.getLocation());
        if (menu == null) return;
        Location loc = block.getLocation();
        int energyConsumption = getEnergyConsumption();
        if(menu != null && menu.hasViewer()) {
        if (getCharge(block.getLocation()) < getEnergyConsumption()) {
            //电量不足
            menu.addItem(4, new CustomItemStack(new ItemStack (Material.CAMPFIRE), "§c电量不足"),
                    (p, slot, item, action) -> false);
            return;
        }
            //电量不足
            menu.addItem(4, new CustomItemStack(new ItemStack(Material.SOUL_CAMPFIRE), "§b资源转换器",
                            "§b类型：§e" + "魔法2.0转RSC魔法资源",
                            "§b耗电速度：§e" + getEnergyConsumption() * 2 + " J/s",
                            "§b电量存储：§e" + getCharge(block.getLocation()) + " J"),
                    (p, slot, item, action) -> false);

        }
        // 转换映射
        java.util.Map<ItemStack, String> conversionMap = new java.util.HashMap<>();
        conversionMap.put(MagicExpansionItems.RSC_MAGIC_REDSTONE, "MAGIC_REDSTONE");
        conversionMap.put(MagicExpansionItems.RSC_MAGIC_COSMIC_DUST, "MAGIC_COSMIC_DUST");
        conversionMap.put(MagicExpansionItems.RSC_MAGIC_SOUL, "MAGIC_SOUL");

        // 🔍 先检查 outputSlots 是否有空间（空槽 或 可叠加槽）
        boolean hasOutputSpace = false;
        for (int slot : outputSlots) {
            ItemStack existing = menu.getItemInSlot(slot);
            if (existing == null || existing.getType() == Material.AIR) {
                hasOutputSpace = true;
                break;
            }
        }
        if (!hasOutputSpace) {
            return;
        }
        for (int inputSlot : inputSlots) {
            ItemStack inputItem = menu.getItemInSlot(inputSlot);
            if (inputItem == null || inputItem.getType() == Material.AIR) continue;

            // 检查是否是目标 RSC 物品
            for (ItemStack rscItem : conversionMap.keySet()) {
                if (inputItem.isSimilar(rscItem)) {
                    String targetKey = conversionMap.get(rscItem);
                    ItemStack outputTemplate = ConvertItem.stoneCreateItem(targetKey);
                    if (outputTemplate == null || outputTemplate.getType() == Material.AIR) {
                        break;
                    }

                    int amount = inputItem.getAmount();
                    menu.replaceExistingItem(inputSlot, null);

                    ItemStack toPush = outputTemplate.clone();
                    toPush.setAmount(amount);
                    menu.pushItem(toPush, outputSlots);

                    removeCharge(loc, energyConsumption);

                    return;
                }
            }
        }



    }



    private void constructMenu(String displayName) {
        new BlockMenuPreset(getId(), displayName) {

            @Override
            public void init() {
                constructMenu(this);
            }

            @Override
            public boolean canOpen(@Nonnull Block b, @Nonnull Player p) {
                return p.hasPermission("slimefun.inventory.bypass")
                        || Slimefun.getProtectionManager().hasPermission(p, b.getLocation(),
                        Interaction.INTERACT_BLOCK);
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                if (flow == ItemTransportFlow.INSERT) {
                    return inputSlots;
                } else {
                    return outputSlots;
                }
            }
        };
    }

    protected void constructMenu(BlockMenuPreset preset) {

        for (int i : pinkBorder ) {
            preset.addItem(i, new CustomItemStack(doGlow(new ItemStack (Material.PINK_STAINED_GLASS_PANE)), " "),
                    (p, slot, item, action) -> false);
        }

        preset.addItem(4, new CustomItemStack(new ItemStack (Material.REDSTONE_BLOCK), " "),
                (p, slot, item, action) -> false);

    }


    private int getEnergyConsumption() {
        return craftPerTick;
    }


    @Override
    public @NotNull EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    public int getCapacity() {
        return power;
    }
}
