package io.Yomicer.magicExpansion.items.misc;

import io.Yomicer.magicExpansion.MagicExpansion;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;
import static io.Yomicer.magicExpansion.utils.ColorGradient.getRandomGradientName;

public class PowerCard extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable {

    // 定义 NamespacedKey
    private static final NamespacedKey MaxPower = new NamespacedKey(MagicExpansion.getInstance(), "max_power");
    private static final NamespacedKey NowPower = new NamespacedKey(MagicExpansion.getInstance(), "now_power");

    public PowerCard(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public @NotNull ItemUseHandler getItemHandler() {
        return e -> {

            // 阻止默认行为（放置方块或使用物品）
            e.setUseItem(Event.Result.DENY);
            e.setUseBlock(Event.Result.DENY);
            ItemStack item = e.getItem();
            Player player = e.getPlayer();
            // 必须按住 Shift 才能设置
            if (!player.isSneaking()) {
                player.sendMessage("§e提示: 按住 Shift + 右键 来设置最大储能值。");
                return;
            }
            // 开始等待输入
            waitForMaxPowerInput(player, item);

        };
    }



    /**
     * 等待玩家输入最大储能值（正整数，long 范围）
     */
    private void waitForMaxPowerInput(Player player, ItemStack item) {
        player.sendMessage(getRandomGradientName("[魔法2.0] 请输入一个正整数作为最大储能值（ 1 ~ "+ Long.MAX_VALUE +" ）："));
        player.sendMessage(getRandomGradientName("提示：输入 'cancel' 可取消操作。"));

        // <<< 声明任务变量，用于后续取消 >>>
        BukkitTask[] timeoutTask = new BukkitTask[1];
        // 创建临时监听器
        Listener tempListener = new Listener() {
            @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
            public void onPlayerChat(AsyncPlayerChatEvent event) {
                Player p = event.getPlayer();
                if (!p.equals(player)) return;

                event.setCancelled(true); // 拦截消息

                String message = event.getMessage().trim();

                if ("cancel".equalsIgnoreCase(message)) {
                    player.sendMessage(getRandomGradientName("[魔法2.0] 已取消操作。"));
                }else {

                    try {
                        long maxPowerValue = Long.parseLong(message);
                        if (maxPowerValue <= 0) {
                            player.sendMessage(getRandomGradientName("错误：请输入一个大于 0 的正整数。"));
                            return; // 不注销，继续等待
                        }

                        // 成功解析，开始处理物品
                        handlePowerConfiguration(item, maxPowerValue);

                        player.sendMessage(getRandomGradientName("✔ 成功设置最大储能值为: " + maxPowerValue + " J"));
                        player.updateInventory(); // 强制刷新

                    } catch (NumberFormatException ex) {
                        player.sendMessage(getRandomGradientName("错误：'" + message + "' 不是一个有效的整数，请重新输入。"));
                        return; // 继续等待
                    }
                }

                // <<< 输入完成或取消：取消超时任务 >>>
                if (timeoutTask[0] != null && !timeoutTask[0].isCancelled()) {
                    timeoutTask[0].cancel();
                }

                // 完成后注销监听器
                org.bukkit.event.HandlerList.unregisterAll(this);
            }
        };

        // 注册临时监听器
        MagicExpansion.getInstance().getServer().getPluginManager().registerEvents(tempListener, MagicExpansion.getInstance());

        // 设置 15 秒超时
        timeoutTask[0] = MagicExpansion.getInstance().getServer().getScheduler().runTaskLater(MagicExpansion.getInstance(), () -> {
            org.bukkit.event.HandlerList.unregisterAll(tempListener);
            if (player.isOnline()) {
                player.sendMessage(getRandomGradientName("[魔法2.0] ⏰ 输入超时（15秒），已自动取消。"));
            }
        }, 300L); // 15秒 = 300 ticks
    }

    /**
     * 处理物品的储能配置（PDC + Lore 更新）
     */
    private void handlePowerConfiguration(ItemStack item, long maxPowerValue) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;

        PersistentDataContainer pdc = meta.getPersistentDataContainer();

        // 获取当前电量（继承或初始化为0）
        long nowPower = pdc.has(NowPower, PersistentDataType.LONG)
                ? pdc.get(NowPower, PersistentDataType.LONG) : 0L;

        // 设置最大电量
        pdc.set(MaxPower, PersistentDataType.LONG, maxPowerValue);
        pdc.set(NowPower, PersistentDataType.LONG, nowPower); // 显式设置（确保存在）

        // 更新 Lore：保留前11行，添加电量信息
        List<String> lore = new ArrayList<>();
        if (meta.hasLore()) {
            List<String> existingLore = meta.getLore();
            int linesToKeep = Math.min(3, existingLore.size());
            for (int i = 0; i < linesToKeep; i++) {
                lore.add(existingLore.get(i));
            }
        }

        // 添加电量显示
        String powerLine = getGradientName("当前储电量: " + nowPower + "/" + maxPowerValue + " J");
        lore.add(powerLine);

        meta.setLore(lore);
        item.setItemMeta(meta);
    }


}
