package io.Yomicer.magicExpansion.items.tools;

import io.Yomicer.magicExpansion.utils.CreateItem;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.Yomicer.magicExpansion.utils.GiveItem.giveOrDropItem;
import static io.Yomicer.magicExpansion.utils.QuickMachineUtils.*;

public class MagicExpansionQuickSmeltery extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable {

    public MagicExpansionQuickSmeltery(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }


    // 预加载的 SMELTERY 配方列表（静态常量）
    private static final List<Map<String, Integer>> SMELTERY_RECIPES = new ArrayList<>();

    static {
        // 在类加载时预加载所有 SMELTERY 类型的配方
        List<SlimefunItem> smelteryItems = Slimefun.getRegistry().getAllSlimefunItems().stream()
                .filter(item -> item.getRecipeType() == RecipeType.SMELTERY)
                .toList();

        for (SlimefunItem item : smelteryItems) {
            ItemStack[] recipe = item.getRecipe();
            Map<String, Integer> recipeMap = new HashMap<>();

            // 遍历配方中的每个物品
            for (ItemStack requiredItem : recipe) {
                if (requiredItem == null || requiredItem.getType() == Material.AIR) {
                    continue; // 忽略空槽位
                }

                int requiredAmount = requiredItem.getAmount();

                // 判断是否为 SlimefunItem
                String itemKey;
                SlimefunItem slimefunItem = SlimefunItem.getByItem(requiredItem);
                if (slimefunItem != null) {
                    // 如果是 SlimefunItem，使用其 ID 作为键
                    itemKey = "sf:" + slimefunItem.getId();
                } else {
                    // 如果不是 SlimefunItem，则默认为原版物品
                    itemKey = "mc:" + requiredItem.getType().name();
                }

                // 整合相同物品的数量
                recipeMap.put(itemKey, recipeMap.getOrDefault(itemKey, 0) + requiredAmount);
            }

            // 将整合后的配方存入列表
            SMELTERY_RECIPES.add(recipeMap);
        }
    }

    @Nonnull
    @Override
    public ItemUseHandler getItemHandler() {
        return e->{
            // 阻止默认行为（放置方块或使用物品）
            e.setUseItem(Event.Result.DENY);
            e.setUseBlock(Event.Result.DENY);

            // 获取玩家
            Player player = e.getPlayer();
            // 打开菜单并动态加载配方
            ChestMenu menu = new ChestMenu("可用冶炼炉配方");
            addAvailableRecipesToMenu(player, menu,0, SMELTERY_RECIPES);

            // 设置空槽位是否可点击
            menu.setEmptySlotsClickable(true);
            menu.setPlayerInventoryClickable(true);
            // 显示菜单给玩家
            menu.open(player);


        };
    }
}
