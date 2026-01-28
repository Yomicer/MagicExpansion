package io.Yomicer.magicExpansion.items.misc;

import io.Yomicer.magicExpansion.MagicExpansion;
import io.Yomicer.magicExpansion.utils.SameItemJudge;
import io.Yomicer.magicExpansion.utils.networksUtils.DataTypeMethods;
import io.Yomicer.magicExpansion.utils.networksUtils.NetworksKeys;
import io.Yomicer.magicExpansion.utils.networksUtils.PersistentQuantumStorageType;
import io.Yomicer.magicExpansion.utils.networksUtils.QuantumCache;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.DistinctiveItem;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import net.guizhanss.guizhanlib.minecraft.helper.inventory.ItemStackHelper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import java.util.*;

public class CargoFragment extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable, DistinctiveItem {

    // 等待输入的玩家列表
    private static final Map<UUID, FragmentTransfer> pendingTransfers = new HashMap<>();
    private static Listener chatListener;

    // CargoFragment的PDC键
    private static final NamespacedKey KEY_CARGO_ITEM = new NamespacedKey(MagicExpansion.getInstance(), "cargo_item_json");
    private static final NamespacedKey KEY_CARGO_AMOUNT = new NamespacedKey(MagicExpansion.getInstance(), "cargo_amount");

    public CargoFragment(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public @NotNull ItemUseHandler getItemHandler() {
        return e -> {
            e.setUseItem(Event.Result.DENY);
            e.setUseBlock(Event.Result.DENY);

            Player player = e.getPlayer();

            // 只响应主手
            if (e.getHand() != EquipmentSlot.HAND) {
                return;
            }

            ItemStack fragmentItem = e.getItem(); // 主手的CargoFragment
            ItemStack offhandItem = player.getInventory().getItemInOffHand(); // 副手物品

            // 检查主手和副手物品数量必须为1
            if (fragmentItem.getAmount() != 1 || offhandItem.getAmount() != 1) {
                if (fragmentItem.getAmount() != 1) {
                    player.sendMessage(ChatColor.RED + "主手CargoFragment的数量必须为1！");
                    player.sendMessage(ChatColor.GRAY + "请分离出单个碎片再进行转移操作。");
                }
                if (offhandItem.getAmount() != 1) {
                    player.sendMessage(ChatColor.RED + "副手量子存储物品的数量必须为1！");
                    player.sendMessage(ChatColor.GRAY + "请确保只持有一个存储容器。");
                }
                playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f);
                return;
            }

            // 1. 检查副手物品
            if (offhandItem == null || offhandItem.getType().isAir()) {
                sendError(player, "请将量子存储物品放在副手！");
                return;
            }

            // 2. 从副手物品获取QuantumCache
            ItemMeta offhandMeta = offhandItem.getItemMeta();
            if (offhandMeta == null) {
                sendError(player, "副手物品数据异常！");
                return;
            }

            // 使用你提供的方式获取QuantumCache
            QuantumCache quantumCache = DataTypeMethods.getCustom(offhandMeta,
                    NetworksKeys.QUANTUM_STORAGE_INSTANCE, PersistentQuantumStorageType.TYPE);

            if (quantumCache == null || quantumCache.getItemStack() == null) {
                sendError(player, "副手物品没有有效的量子存储数据！");
                return;
            }

            // 3. 获取CargoFragment数据
            ItemMeta fragmentMeta = fragmentItem.getItemMeta();
            if (fragmentMeta == null) {
                sendError(player, "碎片数据损坏！");
                return;
            }

            PersistentDataContainer fragmentPdc = fragmentMeta.getPersistentDataContainer();
            String itemJson = fragmentPdc.get(KEY_CARGO_ITEM, PersistentDataType.STRING);
            Integer fragmentAmount = fragmentPdc.get(KEY_CARGO_AMOUNT, PersistentDataType.INTEGER);

            if (itemJson == null || fragmentAmount == null || fragmentAmount <= 0) {
                sendError(player, "这个碎片中没有存储物品！");
                return;
            }

            // 4. 解析CargoFragment中的物品
            ItemStack storedItem = SameItemJudge.itemFromBase64(itemJson);
            if (storedItem == null) {
                sendError(player, "碎片中的物品数据损坏！");
                return;
            }

            // 5. 检查物品类型是否匹配
            ItemStack cacheItem = quantumCache.getItemStack();
            if (!SlimefunUtils.isItemSimilar(storedItem, cacheItem, true)) {
                player.sendMessage(ChatColor.RED + "物品类型不匹配！");
                player.sendMessage(ChatColor.GRAY + "碎片: " + ItemStackHelper.getDisplayName(storedItem));
                player.sendMessage(ChatColor.GRAY + "存储: " + ItemStackHelper.getDisplayName(cacheItem));
                playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f);
                return;
            }

            // 6. 计算可转移数量
            long currentAmount = quantumCache.getAmount();
            long maxCapacity = quantumCache.getLimit();
            long remainingSpace = maxCapacity - currentAmount;

            if (remainingSpace <= 0) {
                sendError(player, "§c量子存储已满！");
                return;
            }

            long maxTransfer = Math.min(fragmentAmount, remainingSpace);

            // 7. 创建等待状态
            FragmentTransfer transfer = new FragmentTransfer(
                    player.getUniqueId(),
                    fragmentItem,
                    offhandItem,
                    storedItem,
                    fragmentAmount,
                    quantumCache,
                    maxTransfer
            );

            pendingTransfers.put(player.getUniqueId(), transfer);

            // 8. 显示输入提示
            showTransferPrompt(player, storedItem, fragmentAmount, currentAmount, maxCapacity, maxTransfer);

            // 9. 注册聊天监听器
            registerChatListener();

            // 10. 设置超时
            scheduleTimeout(player.getUniqueId());
        };
    }

    /**
     * 显示转移提示信息
     */
    private void showTransferPrompt(Player player, ItemStack item, long fragmentAmount,
                                    long currentStored, long maxCapacity, long maxTransfer) {
        player.sendMessage("");
        player.sendMessage(ChatColor.GOLD + "══════ " + ChatColor.BOLD + "物品转移" + ChatColor.RESET + ChatColor.GOLD + " ══════");
        player.sendMessage(ChatColor.YELLOW + "物品类型: " + ChatColor.WHITE + ItemStackHelper.getDisplayName(item));
        player.sendMessage(ChatColor.YELLOW + "碎片存量: " + ChatColor.GREEN + fragmentAmount + " 个");
        player.sendMessage(ChatColor.YELLOW + "存储状态: " + ChatColor.AQUA + currentStored + "/" + maxCapacity);
        player.sendMessage(ChatColor.YELLOW + "可转数量: " + ChatColor.GOLD + maxTransfer + " 个");
        player.sendMessage("");
        player.sendMessage(ChatColor.YELLOW + "请输入转移数量 (" + ChatColor.GREEN + "1-" + maxTransfer + ChatColor.YELLOW + ")");
        player.sendMessage(ChatColor.YELLOW + "或输入 " + ChatColor.GREEN + "'all'" + ChatColor.YELLOW + " 转移全部可转数量");
        player.sendMessage(ChatColor.GRAY + "输入 " + ChatColor.RED + "'cancel'" + ChatColor.GRAY + " 取消操作 (30秒超时)");
        player.sendMessage("");

        playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1.5f);
    }

    /**
     * 注册聊天事件监听器
     */
    private void registerChatListener() {
        if (chatListener != null) return;

        chatListener = new Listener() {
            @EventHandler
            public void onPlayerChat(AsyncPlayerChatEvent event) {
                Player player = event.getPlayer();
                FragmentTransfer transfer = pendingTransfers.get(player.getUniqueId());

                if (transfer == null) return;

                event.setCancelled(true);

                String input = event.getMessage().trim();

                Bukkit.getScheduler().runTask(MagicExpansion.getInstance(), () -> {
                    processTransferInput(player, transfer, input);
                });
            }

            @EventHandler
            public void onPlayerQuit(PlayerQuitEvent event) {
                pendingTransfers.remove(event.getPlayer().getUniqueId());
                cleanupListenerIfNeeded();
            }
        };

        Bukkit.getPluginManager().registerEvents(chatListener, MagicExpansion.getInstance());
    }

    /**
     * 处理玩家输入
     */
    private void processTransferInput(Player player, FragmentTransfer transfer, String input) {
        try {
            // 处理取消
            if (input.equalsIgnoreCase("cancel")) {
                player.sendMessage(ChatColor.YELLOW + "已取消转移操作。");
                pendingTransfers.remove(player.getUniqueId());
                cleanupListenerIfNeeded();
                return;
            }

            // === 新增：验证物品是否发生变化 ===
            if (!validateItemsUnchanged(player, transfer)) {
                player.sendMessage(ChatColor.RED + "操作失败：物品已发生变化！");
                pendingTransfers.remove(player.getUniqueId());
                cleanupListenerIfNeeded();
                return;
            }

            int transferAmount;

            // 处理"all"
            if (input.equalsIgnoreCase("all")) {
                transferAmount = (int) transfer.maxTransfer;
            } else {
                // 解析数字
                try {
                    transferAmount = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "请输入有效数字、'all' 或 'cancel'！");
                    return;
                }

                // 验证范围
                if (transferAmount <= 0) {
                    player.sendMessage(ChatColor.RED + "请输入大于0的数字！");
                    return;
                }

                if (transferAmount > transfer.maxTransfer) {
                    player.sendMessage(ChatColor.RED + "超过最大可转数量 (" + transfer.maxTransfer + ")！");
                    return;
                }
            }

            // 执行转移
            executeQuantumTransfer(player, transfer, transferAmount);

        } finally {
            pendingTransfers.remove(player.getUniqueId());
            cleanupListenerIfNeeded();
        }
    }

    /**
     * 验证物品在等待输入期间是否发生变化
     */
    private boolean validateItemsUnchanged(Player player, FragmentTransfer transfer) {
        // 1. 检查玩家是否在线
        if (!player.isOnline()) {
            return false;
        }

        // 2. 检查主手物品是否还是碎片
        ItemStack currentMainHand = player.getInventory().getItemInMainHand();
        if (currentMainHand == null || currentMainHand.getType().isAir()) {
            player.sendMessage(ChatColor.RED + "主手物品已消失！");
            return false;
        }

        // 检查数量是否为1
        if (currentMainHand.getAmount() != 1) {
            player.sendMessage(ChatColor.RED + "主手物品数量已发生变化！");
            return false;
        }

        // 检查是否是同一个碎片物品
        if (!isSameFragmentItem(currentMainHand, transfer.fragmentItem)) {
            player.sendMessage(ChatColor.RED + "主手物品已更换！");
            return false;
        }

        // 3. 检查副手物品是否还是量子存储物品
        ItemStack currentOffhand = player.getInventory().getItemInOffHand();
        if (currentOffhand == null || currentOffhand.getType().isAir()) {
            player.sendMessage(ChatColor.RED + "副手物品已消失！");
            return false;
        }

        // 检查数量是否为1
        if (currentOffhand.getAmount() != 1) {
            player.sendMessage(ChatColor.RED + "副手物品数量已发生变化！");
            return false;
        }

        // 检查是否是同一个量子存储物品
        if (!isSameQuantumStorageItem(currentOffhand, transfer.offhandItem)) {
            player.sendMessage(ChatColor.RED + "副手物品已更换！");
            return false;
        }

        // 4. 检查量子存储数据是否发生变化
        ItemMeta currentOffhandMeta = currentOffhand.getItemMeta();
        if (currentOffhandMeta == null) {
            player.sendMessage(ChatColor.RED + "副手物品数据异常！");
            return false;
        }

        QuantumCache currentCache = DataTypeMethods.getCustom(currentOffhandMeta,
                NetworksKeys.QUANTUM_STORAGE_INSTANCE, PersistentQuantumStorageType.TYPE);

        if (currentCache == null) {
            player.sendMessage(ChatColor.RED + "副手物品的量子存储数据已丢失！");
            return false;
        }

        // 检查存储的物品是否相同
        ItemStack currentCacheItem = currentCache.getItemStack();
        long currentStoredAmount = currentCache.getAmount();
        long currentMaxCapacity = currentCache.getLimit();

        if (currentCacheItem == null) {
            player.sendMessage(ChatColor.RED + "量子存储中的物品已消失！");
            return false;
        }

        // 检查碎片数据是否发生变化
        ItemMeta currentFragmentMeta = currentMainHand.getItemMeta();
        if (currentFragmentMeta == null) {
            player.sendMessage(ChatColor.RED + "碎片数据损坏！");
            return false;
        }

        PersistentDataContainer fragmentPdc = currentFragmentMeta.getPersistentDataContainer();
        String currentItemJson = fragmentPdc.get(KEY_CARGO_ITEM, PersistentDataType.STRING);
        Integer currentFragmentAmount = fragmentPdc.get(KEY_CARGO_AMOUNT, PersistentDataType.INTEGER);

        if (currentItemJson == null || currentFragmentAmount == null) {
            player.sendMessage(ChatColor.RED + "碎片数据不完整！");
            return false;
        }

        // 解析碎片中的物品
        ItemStack currentStoredItem = SameItemJudge.itemFromBase64(currentItemJson);
        if (currentStoredItem == null) {
            player.sendMessage(ChatColor.RED + "碎片中的物品数据损坏！");
            return false;
        }

        // 检查物品类型是否匹配
        if (!SlimefunUtils.isItemSimilar(currentStoredItem, currentCacheItem, true)) {
            player.sendMessage(ChatColor.RED + "物品类型已不匹配！");
            return false;
        }

        // 检查碎片中的物品是否与之前一致
        if (!SlimefunUtils.isItemSimilar(currentStoredItem, transfer.storedItem, true)) {
            player.sendMessage(ChatColor.RED + "碎片中的物品已发生变化！");
            return false;
        }

        // 检查碎片数量是否减少
        if (currentFragmentAmount < transfer.fragmentAmount) {
            player.sendMessage(ChatColor.YELLOW + "碎片数量已减少，更新可转移数量！");
            transfer.fragmentAmount = currentFragmentAmount;
        }

        // 检查存储容量是否变化
        if (currentStoredAmount != transfer.quantumCache.getAmount() ||
                currentMaxCapacity != transfer.quantumCache.getLimit()) {

            long remainingSpace = currentMaxCapacity - currentStoredAmount;
            long newMaxTransfer = Math.min(transfer.fragmentAmount, remainingSpace);

            if (remainingSpace <= 0) {
                player.sendMessage(ChatColor.RED + "量子存储已满！");
                return false;
            }

            if (newMaxTransfer < transfer.maxTransfer) {
                player.sendMessage(ChatColor.YELLOW + "可转移数量已更新为: " + newMaxTransfer);
                transfer.maxTransfer = newMaxTransfer;
            }

            transfer.quantumCache = currentCache;
        }

        return true;
    }

    /**
     * 检查是否同一个碎片物品
     */
    private boolean isSameFragmentItem(ItemStack item1, ItemStack item2) {
        // 简单比较：类型和自定义名称
        if (item1.getType() != item2.getType()) {
            return false;
        }

        ItemMeta meta1 = item1.getItemMeta();
        ItemMeta meta2 = item2.getItemMeta();

        if (meta1 == null || meta2 == null) {
            return meta1 == meta2;
        }

        // 比较显示名称（CargoFragment应该有特殊的显示名）
        String name1 = meta1.getDisplayName();
        String name2 = meta2.getDisplayName();

        if (name1 == null && name2 == null) {
            return true;
        }

        if (name1 == null || name2 == null) {
            return false;
        }

        return name1.equals(name2);
    }

    /**
     * 检查是否同一个量子存储物品
     */
    private boolean isSameQuantumStorageItem(ItemStack item1, ItemStack item2) {
        // 首先比较基础信息
        if (item1.getType() != item2.getType()) {
            return false;
        }

        // 获取两个物品的PDC数据
        ItemMeta meta1 = item1.getItemMeta();
        ItemMeta meta2 = item2.getItemMeta();

        if (meta1 == null || meta2 == null) {
            return meta1 == meta2;
        }

        // 从PDC获取QuantumCache进行比较
        QuantumCache cache1 = DataTypeMethods.getCustom(meta1,
                NetworksKeys.QUANTUM_STORAGE_INSTANCE, PersistentQuantumStorageType.TYPE);

        QuantumCache cache2 = DataTypeMethods.getCustom(meta2,
                NetworksKeys.QUANTUM_STORAGE_INSTANCE, PersistentQuantumStorageType.TYPE);

        // 如果有一个没有量子缓存，则不同
        if (cache1 == null || cache2 == null) {
            return false;
        }

        if (cache1.getAmount() != 0 && cache2.getAmount() != 0){
            return cache1.getAmount() == cache2.getAmount();
        }

        // 比较缓存ID或其他唯一标识（如果QuantumCache有getId方法）
        try {
            // 如果有getId方法
            if (cache1.getItemStack() != null && cache2.getItemStack() != null) {
                return cache1.getItemStack().equals(cache2.getItemStack());
            }
        } catch (Exception e) {
            // 如果QuantumCache没有getId方法，使用hashCode作为备用
            return cache1.hashCode() == cache2.hashCode();
        }

        return false;
    }

    /**
     * 执行量子存储转移
     */
    private void executeQuantumTransfer(Player player, FragmentTransfer transfer, int amount) {
        try {
            // 1. 增加量子存储数量
            transfer.quantumCache.increaseAmount(amount);

            // 2. 更新副手物品的QuantumCache数据
            updateQuantumCacheInItem(transfer.offhandItem, transfer.quantumCache);

            // 3. 更新CargoFragment
            long newFragmentAmount = transfer.fragmentAmount - amount;

            if (newFragmentAmount <= 0) {
                // 删除碎片
                if (transfer.fragmentItem.getAmount() > 1) {
                    transfer.fragmentItem.setAmount(transfer.fragmentItem.getAmount() - 1);
                    player.getInventory().setItemInMainHand(transfer.fragmentItem);
                } else {
                    player.getInventory().setItemInMainHand(null);
                }

                player.sendMessage(ChatColor.GREEN + "✓ 已转移 " + ChatColor.YELLOW + amount +
                        ChatColor.GREEN + " 个物品，碎片已耗尽。");
            } else {
                // 更新碎片数量
                updateFragmentData(transfer.fragmentItem, newFragmentAmount);

                player.sendMessage(ChatColor.GREEN + "✓ 成功转移 " + ChatColor.YELLOW + amount +
                        ChatColor.GREEN + " 个物品。");
                player.sendMessage(ChatColor.GRAY + "碎片剩余: " + newFragmentAmount + " 个");
            }

            // 4. 更新副手物品显示
            player.getInventory().setItemInOffHand(transfer.offhandItem);

            // 5. 播放成功音效
            playSound(player, Sound.ENTITY_ITEM_PICKUP, 1.2f);

        } catch (Exception e) {
            player.sendMessage(ChatColor.RED + "转移失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 更新QuantumCache数据到物品
     */
    private void updateQuantumCacheInItem(ItemStack item, QuantumCache cache) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;

        // 更新QuantumCache到物品的PDC
        DataTypeMethods.setCustom(meta, NetworksKeys.QUANTUM_STORAGE_INSTANCE,
                PersistentQuantumStorageType.TYPE, cache);
        cache.updateMetaLore(meta);
        item.setItemMeta(meta);
    }

    /**
     * 更新CargoFragment数据
     */
    private void updateFragmentData(ItemStack fragment, long newAmount) {
        ItemMeta meta = fragment.getItemMeta();
        if (meta == null) return;

        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        pdc.set(KEY_CARGO_AMOUNT, PersistentDataType.INTEGER, (int) newAmount);

        // 更新Lore中的数量显示
        List<String> lore = meta.hasLore() ? new ArrayList<>(meta.getLore()) : new ArrayList<>();

        for (int i = 0; i < lore.size(); i++) {
            if (lore.get(i).contains("数量: ")) {
                lore.set(i, "§f数量: §a" + newAmount);
                break;
            }
        }

        meta.setLore(lore);
        fragment.setItemMeta(meta);
    }

    /**
     * 设置超时任务
     */
    private void scheduleTimeout(UUID playerId) {
        Bukkit.getScheduler().runTaskLater(MagicExpansion.getInstance(), () -> {
            FragmentTransfer transfer = pendingTransfers.remove(playerId);
            if (transfer != null) {
                Player player = Bukkit.getPlayer(playerId);
                if (player != null && player.isOnline()) {
                    player.sendMessage(ChatColor.RED + "操作超时，已自动取消。");
                }
                cleanupListenerIfNeeded();
            }
        }, 20 * 30); // 30秒
    }

    /**
     * 清理监听器
     */
    private void cleanupListenerIfNeeded() {
        if (pendingTransfers.isEmpty() && chatListener != null) {
            HandlerList.unregisterAll(chatListener);
            chatListener = null;
        }
    }

    /**
     * 发送错误消息
     */
    private void sendError(Player player, String message) {
        player.sendMessage(ChatColor.RED + message);
        playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f);
    }

    /**
     * 播放音效
     */
    private void playSound(Player player, Sound sound, float pitch) {
        player.playSound(player.getLocation(), sound, 0.8f, pitch);
    }

    @Override
    public boolean canStack(@NotNull ItemMeta itemMeta, @NotNull ItemMeta itemMeta1) {
        return false;
    }

    /**
     * 转移任务信息类
     */
    private static class FragmentTransfer {
        final UUID playerId;
        final ItemStack fragmentItem;
        final ItemStack offhandItem;
        final ItemStack storedItem;
        long fragmentAmount; // 改为非final，可能更新
        QuantumCache quantumCache; // 改为非final，可能更新
        long maxTransfer; // 改为非final，可能更新

        FragmentTransfer(UUID playerId, ItemStack fragmentItem, ItemStack offhandItem,
                         ItemStack storedItem, long fragmentAmount,
                         QuantumCache quantumCache, long maxTransfer) {
            this.playerId = playerId;
            this.fragmentItem = fragmentItem;
            this.offhandItem = offhandItem;
            this.storedItem = storedItem;
            this.fragmentAmount = fragmentAmount;
            this.quantumCache = quantumCache;
            this.maxTransfer = maxTransfer;
        }
    }
}