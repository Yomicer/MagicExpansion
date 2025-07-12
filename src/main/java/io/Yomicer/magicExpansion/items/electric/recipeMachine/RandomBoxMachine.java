package io.Yomicer.magicExpansion.items.electric.recipeMachine;

import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.Yomicer.magicExpansion.items.abstracts.AbstractElectricRecipeMachine;
import io.Yomicer.magicExpansion.utils.itemUtils.getRandomItemFromGroup;
import io.Yomicer.magicExpansion.utils.log.Debug;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static io.Yomicer.magicExpansion.Listener.SlimefunRegistryGiftBox.itemMapMihoyoHonkai;
import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;

public class RandomBoxMachine extends AbstractElectricRecipeMachine {
    private static final int[] INPUT_SLOTS = new int[] { 0,1,2,3, 9,10,11,12, 18,19,20,21, 27,28,29,30, 36,37,38,39, 45,46,47,48  };
    private static final int[] OUTPUT_SLOTS = new int[] { 5,6,7,8, 14,15,16,17, 23,24,25,26, 32,33,34,35, 41,42,43,44, 50,51,52,53 };

    private static final int[] INPUT_BORDER_SLOTS = new int[] { 13 };
    private static final int[] OUTPUT_BORDER_SLOTS = new int[] { 40 };
    private static final int[] BACKGROUND_SLOTS = new int[] { 4, 49 };

    private static final ItemStack PROGRESS_ITEM = new ItemStack(Material.SOUL_LANTERN);
    private static final ItemStack PROGRESS_STACK = new CustomItemStack(Material.SOUL_CAMPFIRE, getGradientName("信息"), getGradientName("类型：加工机器"), getGradientName("所属附属：魔法"));

    public RandomBoxMachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

    }
    
    @Override
    public void postRegister() {
        registerDefaultRecipes();
    }

    protected void registerDefaultRecipes() {

    }

    @Override
    public void tick(BlockMenu menu, Block b) {

        int slot = containsTargetItem(menu, MagicExpansionItems.HONKAI_STAR_RAIL_BOX);
        int slot2 = containsTargetItem(menu, MagicExpansionItems.HONKAI_STAR_RAIL_BOX);
        if(slot!=-1){
            ItemStack gift = getRandomItemFromGroup.getRandomItemStack(itemMapMihoyoHonkai);
            if (gift != null && menu.fits(gift, getOutputSlots())) {
                craft(gift, menu, slot);
            }
        }else if (slot2 != -1){
            ItemStack gift = getRandomItemFromGroup.getRandomItemStack(itemMapMihoyoHonkai);
            if (gift != null && menu.fits(gift, getOutputSlots())) {
                craft(gift, menu, slot2);
            }
        }


    }

    private void craft(ItemStack output, BlockMenu inv,int slot) {

        ItemStack box = inv.getItemInSlot(slot);

        if (box != null && box.getType() != Material.AIR) {
            inv.consumeItem(slot);
//            Debug.logInfo("已消耗盲盒");
        }

        if (output != null && output.getType() != Material.AIR) {
            inv.pushItem(output, getOutputSlots());
//            Debug.logInfo("已生成礼物");
        }
    }

    /**
     * 检查指定槽位中是否存在与目标物品相似的 ItemStack
     */
    public static int containsTargetItem(BlockMenu menu, ItemStack target) {
        for (int slot : INPUT_SLOTS) {
            ItemStack item = menu.getItemInSlot(slot);

            if (SlimefunUtils.isItemSimilar(item, target, true)) {
                return slot; // 找到了匹配的物品
            }
        }

        return -1; // 没找到
    }



    @Override
	public List<ItemStack> getDisplayRecipes() {
		List<ItemStack> display = new ArrayList<>();
        display.add(new CustomItemStack(Material.KNOWLEDGE_BOOK, getGradientName("材料⇨"),getGradientName("中间分割线用于分割各个配方")));
        display.add(new CustomItemStack(Material.KNOWLEDGE_BOOK, getGradientName("产物⇨"),getGradientName("中间分割线用于分割各个配方")));
        // 遍历所有配方并动态生成展示内容
        for (MachineRecipe recipe : recipes) {
            ItemStack[] inputs = recipe.getInput();
            ItemStack[] outputs = recipe.getOutput();
            int productionTime = recipe.getTicks()/2;

            int maxItems = Math.max(inputs.length, outputs.length); // 获取最大物品数量
            for (int i = 0; i < maxItems; i++) {
                // 添加输入物品（带生产时间）
                if (i < inputs.length) {
                    display.add(addLore(inputs[i], "§7生产时间: §e" + productionTime + " 秒"));
                } else {
                    display.add(new ItemStack(Material.AIR)); // 如果没有更多输入物品，添加 AIR
                }

                // 添加输出物品（带生产时间）
                if (i < outputs.length) {
                    display.add(addLore(outputs[i], "§7生产时间: §e" + productionTime + " 秒"));
                } else {
                    display.add(new ItemStack(Material.AIR)); // 如果没有更多输出物品，添加 AIR
                }
            }
            display.add(new CustomItemStack(Material.PINK_STAINED_GLASS_PANE, getGradientName("<== 配方分割线 =>>"),getGradientName("<== 输入材料 =>>")));
            display.add(new CustomItemStack(Material.PINK_STAINED_GLASS_PANE, getGradientName("<== 配方分割线 =>>"),getGradientName("<== 输出材料 =>>")));
            // 遍历所有配方并动态生成展示内容
        }
        return display;
	}

    /**
     * 为物品添加描述（lore）
     */
    private ItemStack addLore(ItemStack item, String loreText) {
        ItemStack newItem = item.clone(); // 防止直接修改原始物品
        ItemMeta meta = newItem.getItemMeta();
        List<String> lore = meta.hasLore() ? new ArrayList<>(meta.getLore()) : new ArrayList<>();
        lore.add(loreText);
        meta.setLore(lore);
        newItem.setItemMeta(meta);
        return newItem;
    }
    protected int getProgressSlot() {
        return 31;
    }

	@Override
	protected void setupMenu(BlockMenuPreset preset) {

        preset.drawBackground(new CustomItemStack(Material.PINK_STAINED_GLASS_PANE," "), BACKGROUND_SLOTS);
        preset.drawBackground(new CustomItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE,getGradientName("←输入槽")), INPUT_BORDER_SLOTS);
        preset.drawBackground(new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,getGradientName("输出槽→")), OUTPUT_BORDER_SLOTS);
    
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
	protected int[] getInputSlots() {
		return INPUT_SLOTS;
	}

	@Override
	protected int[] getOutputSlots() {
		return OUTPUT_SLOTS;
	}

  
    @Override
    public ItemStack getProgressBar() {
        return PROGRESS_ITEM;
    }
}
