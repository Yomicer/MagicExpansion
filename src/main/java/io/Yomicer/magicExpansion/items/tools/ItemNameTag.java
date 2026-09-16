package io.Yomicer.magicExpansion.items.tools;

import io.Yomicer.magicExpansion.MagicExpansion; // ← 替换为你的主类
import io.Yomicer.magicExpansion.utils.ColorGradient;
import io.Yomicer.magicExpansion.utils.playerMessage.MainHandMessage;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ItemNameTag extends SimpleSlimefunItem<ItemUseHandler> implements Listener {

    private final Map<UUID, Long> renameStartTime = new HashMap<>(); // 存储 System.currentTimeMillis()

    public ItemNameTag(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        Bukkit.getPluginManager().registerEvents(this, MagicExpansion.getInstance());
    }

    @Override
    public @NotNull ItemUseHandler getItemHandler() {
        return e -> {
            e.setUseItem(Event.Result.DENY);
            e.setUseBlock(Event.Result.DENY);
            Player player = e.getPlayer();

            if (e.getHand() != EquipmentSlot.HAND) {
                MainHandMessage.sendMainHandMessage(player);
                return;
            }

            Action action = e.getInteractEvent().getAction();
            if (action != Action.RIGHT_CLICK_AIR && action != Action.RIGHT_CLICK_BLOCK) {
                return;
            }

            if (player.isSneaking()) {
                player.sendMessage(ColorGradient.getGradientNameVer2("请输入新名称（支持 & 颜色代码或渐变前缀，60秒内输入）："));
                player.sendMessage(ColorGradient.getGradientNameVer2("渐变代码前缀："));
                player.sendMessage(ColorGradient.getGradientNameVer2("(使用魔法一代渐变色)"));
                player.sendMessage(ColorGradient.getGradientNameVer2("(使用魔法二代渐变色)"));
                player.sendMessage(ColorGradient.getGradientNameVer2("例如：(使用魔法二代渐变色)物品需要修改的名称"));
                UUID uuid = player.getUniqueId();
                renameStartTime.put(uuid, System.currentTimeMillis()); // 记录开始时间

                // 60秒后自动清理（可选，防止内存泄漏）
                Bukkit.getScheduler().runTaskLater(MagicExpansion.getInstance(), () -> {
                    renameStartTime.remove(uuid);
                }, 20 * 60);
            } else {
                // === 普通右键：直接复制主手 displayName 到副手 ===
                ItemStack nameTag = player.getInventory().getItemInMainHand();

                // 检查副手是否有物品
                ItemStack offHand = player.getInventory().getItemInOffHand();
                if (offHand == null || offHand.getType() == Material.AIR) {
                    player.sendMessage(ColorGradient.getGradientNameVer2("副手没有物品！"));
                    return;
                }

                // 获取主手命名签的 displayName
                String displayName = null;
                if (nameTag.hasItemMeta() && nameTag.getItemMeta().hasDisplayName()) {
                    displayName = nameTag.getItemMeta().getDisplayName();
                }
                if (displayName == null || displayName.trim().isEmpty()) {
                    player.sendMessage(ColorGradient.getGradientNameVer2("命名签没有设置名称，无法复制！"));
                    return;
                }

                // 消耗 1 个命名签
                if (nameTag.getAmount() > 1) {
                    nameTag.setAmount(nameTag.getAmount() - 1);
                } else {
                    player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                }

                // 复制 displayName 到副手（保留原有 NBT，只改名字）
                ItemMeta offMeta = offHand.getItemMeta();
                if (offMeta != null) {
                    offMeta.setDisplayName(displayName); // 直接复制，包括 § 颜色
                    offHand.setItemMeta(offMeta);
                    player.sendMessage(ColorGradient.getGradientNameVer2("已将名称复制到副手物品！"));
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.5f);
                }
            }
        };
    }

    // ===== 仅用于 Shift+右键的聊天重命名 =====
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();

        Long startTime = renameStartTime.get(uuid);
        if (startTime == null) return; // 不在流程中

        // ⏱️ 检查是否超时（60秒 = 60_000 毫秒）
        if (System.currentTimeMillis() - startTime > 60_000L) {
            renameStartTime.remove(uuid);
            player.sendMessage(ColorGradient.getGradientNameVer2("命名操作已超时！"));
            e.setCancelled(true);
            return;
        }

        // ✅ 未超时，继续处理
        renameStartTime.remove(uuid); // 处理完就清除
        e.setCancelled(true);

        String input = e.getMessage().trim();
        if (input.isEmpty()) {
            player.sendMessage(ColorGradient.getGradientNameVer2("名称不能为空！"));
            return;
        }

        String finalName;

        // ===== 渐变色识别 =====
        if (input.startsWith("(使用魔法二代渐变色)")) {
            String text = input.substring("(使用魔法二代渐变色)".length());
            if (text.isEmpty()) {
                player.sendMessage(ColorGradient.getGradientNameVer2("渐变文本不能为空！"));
                return;
            }
            finalName = ColorGradient.getGradientNameVer2(text);
        } else if (input.startsWith("(使用魔法一代渐变色)")) {
            String text = input.substring("(使用魔法一代渐变色)".length());
            if (text.isEmpty()) {
                player.sendMessage(ColorGradient.getGradientNameVer2("渐变文本不能为空！"));
                return;
            }
            finalName = ColorGradient.getGradientName(text); // 确保该方法存在
        } else {
            finalName = ChatColor.translateAlternateColorCodes('&', input);
        }

        // 应用名称
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        if (mainHand != null && mainHand.getType() != Material.AIR) {
            ItemMeta meta = mainHand.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(finalName);
                mainHand.setItemMeta(meta);
                player.sendMessage(ColorGradient.getGradientNameVer2("物品已重命名！"));
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.5f);
            }
        }
    }
}