package io.Yomicer.magicExpansion.items.electric.geoMachine;

import com.xzavier0722.mc.plugin.slimefun4.storage.callback.IAsyncReadCallback;
import com.xzavier0722.mc.plugin.slimefun4.storage.controller.SlimefunBlockData;
import com.xzavier0722.mc.plugin.slimefun4.storage.controller.SlimefunChunkData;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.Yomicer.magicExpansion.MagicExpansion;
import io.github.thebusybiscuit.slimefun4.api.geo.GEOResource;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.HologramOwner;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.machines.MachineProcessor;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.operations.CraftingOperation;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

import static io.Yomicer.magicExpansion.core.MagicExpansionItems.*;
import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;

public class FiveElementsMiner extends AContainer implements RecipeDisplayItem , HologramOwner{

    private static final int[] INPUT_SLOTS = new int[] { 0,1,2,3, 9,10,11,12, 18,19,20,21, 27,28,29,30, 36,37,38,39, 45,46,47,48  };
    private static final int[] OUTPUT_SLOTS = new int[] { 5,6,7,8, 14,15,16,17, 23,24,25,26, 32,33,34,35, 41,42,43,44, 50,51,52,53 };

    private static final int[] INPUT_BORDER_SLOTS = new int[] { 13 };
    private static final int[] OUTPUT_BORDER_SLOTS = new int[] { 40 };
    private static final int[] BACKGROUND_SLOTS = new int[] { 4, 49 };

    private static final ItemStack PROGRESS_ITEM = new ItemStack(Material.SOUL_LANTERN);
    private static final ItemStack PROGRESS_STACK = new CustomItemStack(Material.SOUL_CAMPFIRE, getGradientName("信息"), getGradientName("类型：五行资源采集器"), getGradientName("所属附属：魔法"));

    private final MachineProcessor<CraftingOperation> processor = new MachineProcessor<>(this);


    private final GEOResource gold;
    private final GEOResource wood;
    private final GEOResource water;
    private final GEOResource fire;
    private final GEOResource earth;

    private final ItemStack gold_input = new ItemStack(Material.ROTTEN_FLESH);
    private final ItemStack wood_input = new ItemStack(Material.BONE);
    private final ItemStack water_input = new ItemStack(Material.WHEAT);
    private final ItemStack fire_input = new ItemStack(Material.BLAZE_ROD);
    private final ItemStack earth_input = new ItemStack(Material.DIRT);


    @ParametersAreNonnullByDefault
    public FiveElementsMiner(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        processor.setProgressBar(getProgressBar());

        gold = Slimefun.getRegistry()
                .getGEOResources()
                .get(new NamespacedKey(MagicExpansion.getInstance(), "magic_expansion_gold_element"))
                .orElse(null);
        wood = Slimefun.getRegistry()
                .getGEOResources()
                .get(new NamespacedKey(MagicExpansion.getInstance(), "magic_expansion_wood_element"))
                .orElse(null);
        water = Slimefun.getRegistry()
                .getGEOResources()
                .get(new NamespacedKey(MagicExpansion.getInstance(), "magic_expansion_water_element"))
                .orElse(null);
        fire = Slimefun.getRegistry()
                .getGEOResources()
                .get(new NamespacedKey(MagicExpansion.getInstance(), "magic_expansion_fire_element"))
                .orElse(null);
        earth = Slimefun.getRegistry()
                .getGEOResources()
                .get(new NamespacedKey(MagicExpansion.getInstance(), "magic_expansion_earth_element"))
                .orElse(null);


        addItemHandler(onBlockPlace(), onBlockBreak());


        new BlockMenuPreset(getId(), getInventoryTitle()) {

            @Override
            public void init() {
                setupMenu(this);
            }

            @Override
            public boolean canOpen(Block b, Player p) {
                if (!(p.hasPermission("slimefun.inventory.bypass")
                        || Slimefun.getProtectionManager()
                        .hasPermission(p, b.getLocation(), Interaction.INTERACT_BLOCK))) {
                    return false;
                }

                return true;
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                if (flow == ItemTransportFlow.INSERT) {
                    return getInputSlots();
                } else {
                    return getOutputSlots();
                }
            }
        };
    }

    @Override
    public void preRegister() {
        addItemHandler(new BlockTicker() {

            @Override
            public void tick(Block b, SlimefunItem sf, SlimefunBlockData data) {
                FiveElementsMiner.this.tick(b);
            }

            @Override
            public boolean isSynchronized() {
                return false;
            }
        });
    }

    @Nonnull
    private BlockPlaceHandler onBlockPlace() {
        return new BlockPlaceHandler(false) {

            @Override
            public void onPlayerPlace(BlockPlaceEvent e) {
                updateHologram(e.getBlock(), "&7待机中...");
            }
        };
    }

    @Nonnull
    protected BlockBreakHandler onBlockBreak() {
        return new SimpleBlockBreakHandler() {
            public void onBlockBreak(Block b) {
                removeHologram(b);
                BlockMenu inv = StorageCacheUtils.getMenu(b.getLocation());
                if (inv != null) {
                    inv.dropItems(b.getLocation(), getInputSlots());
                    inv.dropItems(b.getLocation(), getOutputSlots());
                }

                processor.endOperation(b);
            }
        };
    }


    protected void tick(Block b) {

        Slimefun.getDatabaseManager()
                .getBlockDataController()
                .getChunkDataAsync(b.getChunk(), new IAsyncReadCallback<>() {
                    @Override
                    public void onResult(SlimefunChunkData result) {
                        if (result.getAllData().isEmpty()) {
                            updateHologram(b, "&4需要先进行地形扫描!");
                        }else{
                            startTick(b);
                        }
                    }
                });
    }

    private void startTick(Block b){
        BlockMenu inv = StorageCacheUtils.getMenu(b.getLocation());
        CraftingOperation currentOperation = processor.getOperation(b);

        if (currentOperation != null) {
            if (takeCharge(b.getLocation())) {

                if (!currentOperation.isFinished()) {
                    processor.updateProgressBar(inv, 31, currentOperation);
                    currentOperation.addProgress(1);
                } else {
                    inv.replaceExistingItem(31, PROGRESS_ITEM);

                    for (ItemStack output : currentOperation.getResults()) {
                        inv.pushItem(output.clone(), getOutputSlots());
                    }

                    processor.endOperation(b);
                }
            }
        }else {
            MachineRecipe next = findNextRecipe(inv);

            if (next != null) {
                currentOperation = new CraftingOperation(next);
                processor.startOperation(b, currentOperation);

                // Fixes #3534 - Update indicator immediately
                processor.updateProgressBar(inv, 31, currentOperation);
            }
        }
    }

    @Override
    protected MachineRecipe findNextRecipe(BlockMenu inv) {

        MachineRecipe recipe;

        recipe = tryProcessEarthLikeRecipe(inv, gold_input, GOLD_ELEMENT, gold, 5);
        if (recipe != null) {
            return recipe;
        }
        recipe = tryProcessEarthLikeRecipe(inv, wood_input, WOOD_ELEMENT, wood, 5);
        if (recipe != null) {
            return recipe;
        }
        recipe = tryProcessEarthLikeRecipe(inv, water_input, WATER_ELEMENT, water, 5);
        if (recipe != null) {
            return recipe;
        }
        recipe = tryProcessEarthLikeRecipe(inv, fire_input, FIRE_ELEMENT, fire, 5);
        if (recipe != null) {
            return recipe;
        }
        recipe = tryProcessEarthLikeRecipe(inv, earth_input, EARTH_ELEMENT, earth, 5);
        return recipe;

    }


    private MachineRecipe tryProcessEarthLikeRecipe(BlockMenu inv, ItemStack inputItem, SlimefunItemStack outputItem, GEOResource resourceType, int seconds) {
        Block b = inv.getBlock();

        // 检查输出槽是否能容纳结果
        if (!inv.fits(outputItem, getOutputSlots())) {
            return null;
        }

        for (int slot : getInputSlots()) {
            ItemStack itemInSlot = inv.getItemInSlot(slot);

            // 检查输入槽是否有匹配的物品
            if (SlimefunUtils.isItemSimilar(itemInSlot, inputItem, true, false)) {
                OptionalInt supplies = Slimefun.getGPSNetwork()
                        .getResourceManager()
                        .getSupplies(resourceType, b.getWorld(), b.getX() >> 4, b.getZ() >> 4);


                if (supplies.isPresent() && supplies.getAsInt() > 0) {
                    // 创建配方并消耗输入物品
                    MachineRecipe recipe = new MachineRecipe(seconds, new ItemStack[] {inputItem}, new ItemStack[] {outputItem});
                    inv.consumeItem(slot);

                    // 扣除资源
                    Slimefun.getGPSNetwork()
                            .getResourceManager()
                            .setSupplies(resourceType, b.getWorld(), b.getX() >> 4, b.getZ() >> 4, supplies.getAsInt() - 1);
                    this.updateHologram(b, "&7开采中: &r" + resourceType.getName());

                    return recipe;
                } else {
                    // 资源不足，把空桶之类的东西移到输出槽，避免重复尝试（防卡顿）
                    ItemStack item = itemInSlot.clone();
                    inv.replaceExistingItem(slot, null);
                    inv.pushItem(item, getOutputSlots());
                    this.updateHologram(b, resourceType.getName()+ "&7 开采完成");
                    return null;
                }
            }

        }

        return null; // 没有匹配的物品或资源不足
    }

    @Override
    public void updateHologram(@NotNull Block block, @NotNull String text) {
        HologramOwner.super.updateHologram(block, text);
    }


    protected void setupMenu(BlockMenuPreset preset) {

        preset.drawBackground(new CustomItemStack(Material.PINK_STAINED_GLASS_PANE," "), BACKGROUND_SLOTS);
        preset.drawBackground(new CustomItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE," "), INPUT_BORDER_SLOTS);
        preset.drawBackground(new CustomItemStack(Material.LIME_STAINED_GLASS_PANE," "), OUTPUT_BORDER_SLOTS);

        preset.addItem(getProgressSlot(), new CustomItemStack(Material.PINK_STAINED_GLASS_PANE, " "), ChestMenuUtils.getEmptyClickHandler());

        preset.addItem(22, PROGRESS_STACK, ChestMenuUtils.getEmptyClickHandler());

        for (int slot : getOutputSlots()) {
            preset.addMenuClickHandler(slot,new ChestMenu.AdvancedMenuClickHandler() {
                @Override
                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action) {
                    return cursor.getType().isAir();
                }

                @Override
                public boolean onClick(Player p, int slot, ItemStack item, ClickAction action) {
                    return false;
                }
            });
        }
    }

    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> display = new ArrayList<>();
        display.add(new CustomItemStack(Material.KNOWLEDGE_BOOK, getGradientName("材料⇨")));
        display.add(new CustomItemStack(Material.KNOWLEDGE_BOOK, getGradientName("产物(开采时间：5秒)⇨")));
        display.add(gold_input);
        display.add(GOLD_ELEMENT);
        display.add(wood_input);
        display.add(WOOD_ELEMENT);
        display.add(water_input);
        display.add(WATER_ELEMENT);
        display.add(fire_input);
        display.add(FIRE_ELEMENT);
        display.add(earth_input);
        display.add(EARTH_ELEMENT);





        return display;
    }



    protected int getProgressSlot() {
        return 31;
    }

    @Override
    public int[] getInputSlots() {
        return INPUT_SLOTS;
    }

    @Override
    public int[] getOutputSlots() {
        return OUTPUT_SLOTS;
    }


    @Override
    public ItemStack getProgressBar() {
        return PROGRESS_ITEM;
    }


    @Override
    public @NotNull String getMachineIdentifier() {
        return "MAGIC_EXPANSION_FIVE_ELEMENT_MINER";
    }
}
