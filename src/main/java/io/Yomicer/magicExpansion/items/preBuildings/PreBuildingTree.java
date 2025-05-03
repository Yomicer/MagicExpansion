package io.Yomicer.magicExpansion.items.preBuildings;

import io.Yomicer.magicExpansion.utils.preBuildingUtils.PreBuildingsTreeUtils;
import io.Yomicer.magicExpansion.utils.ItemPermissionUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;
import static org.bukkit.inventory.EquipmentSlot.HAND;

public class PreBuildingTree extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable {


    private final String buildingName;
    private final String originName;
    private final String replaceName;

    private static final Map<UUID, Long> cooldowns = new HashMap<>();

    private final long COOLDOWN_MS;

    public PreBuildingTree(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,String buildingName,long timeCd) {
        super(category, item, recipeType, recipe);
        this.buildingName = buildingName;
        this.originName = null;
        this.replaceName = null;
        this.COOLDOWN_MS = timeCd*1000;

    }

    public PreBuildingTree(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,String buildingName, String originName,String replaceName,long timeCd) {
        super(category, item, recipeType, recipe);
        this.buildingName = buildingName;
        this.originName = originName;
        this.replaceName = replaceName;
        this.COOLDOWN_MS = timeCd*1000;

    }


    @Override
    public @NotNull ItemUseHandler getItemHandler() {
        return e -> {
            e.setUseItem(Event.Result.DENY);
            e.setUseBlock(Event.Result.DENY);
            Player player = e.getPlayer();
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            // 检查玩家手上是否有物品
            if (e.getHand()!= HAND) {
                player.sendMessage(getGradientName("请使用主手使用~"));
                return;
            }

            if(!ItemPermissionUtils.hasPermissionRe(player)){
                return;
            }

            UUID playerId = player.getUniqueId();
            long now = System.currentTimeMillis();
            // 每次使用时清理过期的冷却记录
            cooldowns.entrySet().removeIf(entry -> now - entry.getValue() >= COOLDOWN_MS);
            // 检查冷却
            if (cooldowns.containsKey(playerId)) {
                long lastUsed = cooldowns.get(playerId);
                if (now - lastUsed < COOLDOWN_MS) {
                    long remaining = (COOLDOWN_MS - (now - lastUsed)) / 1000 + 1;
                    player.sendMessage("§c该道具冷却中，请等待 " + remaining + " 秒后再使用。");
                    return;
                }
            }


            if(!PreBuildingsTreeUtils.pasteMap(player,buildingName, originName, replaceName)){
                return;
            }
            // ✅ 使用成功，更新冷却时间
            cooldowns.put(playerId, now);

            // 减少手上的物品数量
            if (itemInHand.getAmount() > 1) {
                itemInHand.setAmount(itemInHand.getAmount() - 1);
            } else {
                player.getInventory().setItemInMainHand(null); // 如果数量为 1，则直接移除
            }
        };
    }


}
