package io.Yomicer.magicExpansion.Listener.fishingListener;

import io.Yomicer.magicExpansion.items.tools.FishingRodWaterCloud;
import io.Yomicer.magicExpansion.utils.WaterCloudPoolMenu;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * 指南配方页"查看鱼饵池"按钮注入与点击处理
 * 按钮由 FishingRodWaterCloud.getDisplayRecipes() 生成并渲染进粘液书配方页,
 * 本监听器负责:打开时把按钮摆放到配方页槽 27(青竹竿下方再右一格),点击时打开鱼饵池菜单
 */
public class GuidePoolButtonListener implements Listener {

    /** 按钮最终摆放槽位(配方页青竹竿下方再右一格) */
    private static final int[] BUTTON_SLOTS = {26};

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onOpen(InventoryOpenEvent e) {
        Inventory inv = e.getInventory();
        List<Integer> found = new ArrayList<>();
        for (int i = 0; i < inv.getSize(); i++) {
            ItemStack it = inv.getItem(i);
            if (WaterCloudPoolMenu.isPoolButton(it)) {
                found.add(i);
            }
        }
        if (found.isEmpty()) {
            return;
        }

        int count = Math.min(found.size(), BUTTON_SLOTS.length);
        for (int i = 0; i < count; i++) {
            ItemStack button = inv.getItem(found.get(i));
            // 原位置清空为空气,不留下玻璃板占位
            inv.setItem(found.get(i), new ItemStack(Material.AIR));
            inv.setItem(BUTTON_SLOTS[i], button);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player p)) {
            return;
        }
        ItemStack clicked = e.getCurrentItem();
        if (!WaterCloudPoolMenu.isPoolButton(clicked)) {
            return;
        }

        e.setCancelled(true);
        String rodId = WaterCloudPoolMenu.getButtonRodId(clicked);
        if (rodId != null) {
            SlimefunItem sfItem = SlimefunItem.getById(rodId);
            if (sfItem instanceof FishingRodWaterCloud rod) {
                WaterCloudPoolMenu.openBaitList(p, rod);
            }
        }
    }
}
