package io.Yomicer.magicExpansion.Listener.miscListener;
import io.Yomicer.magicExpansion.utils.log.Debug;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import net.guizhanss.guizhanlib.minecraft.helper.inventory.ItemStackHelper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;

import javax.swing.*;

public class ItemFrameListener implements Listener {

    @EventHandler
    public void onItemFrameDamage(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof ItemFrame itemFrame)) return;

        if (!(e.getDamager() instanceof Player p)) return;

        if (hasTapeTag(itemFrame) || hasInfiniteTag(itemFrame)) {

            ItemStack itemInside = itemFrame.getItem();
            SlimefunItem sfItem = SlimefunItem.getByItem(itemInside);
            if (null != sfItem) {
                e.setCancelled(true);
                ItemStack doubleDrop = itemInside.clone();
                itemFrame.getWorld().dropItemNaturally(itemFrame.getLocation(), doubleDrop);
                itemFrame.setItem(null);
                p.sendMessage("请不要将粘液物品放上去");
                return;
            }


            if (null != itemInside && !itemInside.getType().isAir()) {
                e.setCancelled(true);
                float dropChance = itemFrame.getItemDropChance();
                boolean willDrop = Math.random() < dropChance;
                if (willDrop) {
                    ItemStack doubleDrop = itemInside.clone();
                    doubleDrop.setAmount(itemInside.getAmount() * 2);
                    itemFrame.getWorld().dropItemNaturally(itemFrame.getLocation(), doubleDrop);
                    itemFrame.setItem(null);
                    if (!hasInfiniteTag(itemFrame)) {
                        itemFrame.remove();
                    }
                    p.sendMessage("✅ 被薛定谔眷顾的人！恭喜掉落掉落双倍物品：" + ItemStackHelper.getDisplayName(doubleDrop) + " x" + doubleDrop.getAmount());
                } else {
                    itemFrame.setItem(null);
                    if (!hasInfiniteTag(itemFrame)) {
                        itemFrame.remove();
                    }
                    p.sendMessage("❌ 薛定谔没有眷顾于你");
                }
            }
        }

    }





    private boolean hasTapeTag(ItemFrame frame) {
        return (frame.hasMetadata("schrodinger_frame") &&
                frame.getMetadata("schrodinger_frame").get(0).asBoolean());
    }
    private boolean hasInfiniteTag(ItemFrame frame) {
        return frame.hasMetadata("schrodinger_frame_infinite") &&
                frame.getMetadata("schrodinger_frame_infinite").get(0).asBoolean();
    }



}