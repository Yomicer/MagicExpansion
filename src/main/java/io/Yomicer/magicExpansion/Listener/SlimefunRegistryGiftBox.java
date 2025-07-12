package io.Yomicer.magicExpansion.Listener;

import io.Yomicer.magicExpansion.utils.log.Debug;
import io.github.thebusybiscuit.slimefun4.api.events.SlimefunItemRegistryFinalizedEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.Yomicer.magicExpansion.MagicExpansionItemSetup.magicexpansionhonkai;

public class SlimefunRegistryGiftBox implements Listener {


    public static final Map<String, SlimefunItem> itemMapMihoyoHonkai = new HashMap<>();

    // 加载物品组内的所有物品到 map 中
    public static void loadItemsFromGroup(@Nonnull ItemGroup group, Map<String, SlimefunItem> itemMap) {
        List<SlimefunItem> items = group.getItems();

        if (items == null || items.isEmpty()) {
            Debug.logInfo("⚠️ 物品组 [" + group.getKey() + "] 中没有可加载的物品。");
            return;
        }

        for (SlimefunItem item : items) {
            if (item != null && item.getItem() != null) {
                itemMap.put(item.getId(), item);
            }
        }

        Debug.logInfo("✅ 成功加载 [" + itemMap.size() + "] 个物品到崩铁奖池中。");
    }

    @EventHandler
    public void onSlimefunRegistryFinalized(SlimefunItemRegistryFinalizedEvent event) {

        loadItemsFromGroup(magicexpansionhonkai,itemMapMihoyoHonkai);
        Debug.logInfo("崩铁盲盒奖励加载完成");


    }

}
