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
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
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

import static io.Yomicer.magicExpansion.core.MagicExpansionItems.CARGO_FRAGMENT;

public class CargoFragmentExtract extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable {

    // 等待输入的玩家列表
    private static final Map<UUID, ExtractOperation> pendingExtracts = new HashMap<>();
    private static Listener chatListener;

    public CargoFragmentExtract(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
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

            ItemStack extractItem = e.getItem(); // 主手的CargoFragmentExtract
            ItemStack offhandItem = player.getInventory().getItemInOffHand(); // 副手物品

            // 1. 检查主手和副手物品数量必须为1
            if (extractItem.getAmount() != 1 || offhandItem.getAmount() != 1) {
                if (extractItem.getAmount() != 1) {
                    player.sendMessage(ChatColor.RED + "主手提取器的数量必须为1！");
                    player.sendMessage(ChatColor.GRAY + "请确保只使用一个提取器。");
                }
                if (offhandItem.getAmount() != 1) {
                    player.sendMessage(ChatColor.RED + "副手量子存储物品的数量必须为1！");
                    player.sendMessage(ChatColor.GRAY + "请确保只持有一个存储容器。");
                }
                playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f);
                return;
            }

            // 2. 检查副手物品
            if (offhandItem == null || offhandItem.getType().isAir()) {
                sendError(player, "请将量子存储物品放在副手！");
                return;
            }

            // 3. 从副手物品获取QuantumCache
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

            // 4. 获取量子存储中的物品和数量
            ItemStack storedItem = quantumCache.getItemStack();
            long storedAmount = quantumCache.getAmount();

            if (storedItem == null || storedAmount <= 1) {
                // 存储中数量≤1时不能提取（需要至少保留1个）
                sendError(player, "量子存储中的物品数量不足！至少需要2个物品才能提取。");
                return;
            }

            // 5. 计算最大可提取数量（当前数量-1）
            long maxExtract = storedAmount - 1;

            // 6. 创建等待输入状态
            ExtractOperation operation = new ExtractOperation(
                    player.getUniqueId(),
                    extractItem,
                    offhandItem,
                    storedItem,
                    storedAmount,
                    quantumCache,
                    maxExtract
            );

            pendingExtracts.put(player.getUniqueId(), operation);

            // 7. 显示提取提示
            showExtractPrompt(player, storedItem, storedAmount, maxExtract);

            // 8. 注册聊天监听器
            registerChatListener();

            // 9. 设置超时
            scheduleTimeout(player.getUniqueId());
        };
    }

    /**
     * 显示提取提示信息
     */
    private void showExtractPrompt(Player player, ItemStack storedItem, long storedAmount, long maxExtract) {
        player.sendMessage("");
        player.sendMessage(ChatColor.GOLD + "══════ " + ChatColor.BOLD + "物品提取" +
                ChatColor.RESET + ChatColor.GOLD + " ══════");
        player.sendMessage(ChatColor.YELLOW + "物品类型: " + ChatColor.WHITE +
                ItemStackHelper.getDisplayName(storedItem));
        player.sendMessage(ChatColor.YELLOW + "存储总量: " + ChatColor.AQUA + storedAmount + " 个");
        player.sendMessage(ChatColor.YELLOW + "最大可提: " + ChatColor.GOLD + maxExtract + " 个");
        player.sendMessage(ChatColor.YELLOW + "最小保留: " + ChatColor.GREEN + "1 个");
        player.sendMessage("");
        player.sendMessage(ChatColor.YELLOW + "请输入要提取的数量 (" + ChatColor.GREEN + "1-" +
                maxExtract + ChatColor.YELLOW + ")");
        player.sendMessage(ChatColor.GRAY + "输入 " + ChatColor.RED + "'cancel'" +
                ChatColor.GRAY + " 取消操作 (30秒超时)");
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
                ExtractOperation operation = pendingExtracts.get(player.getUniqueId());

                if (operation == null) return;

                event.setCancelled(true);

                String input = event.getMessage().trim();

                Bukkit.getScheduler().runTask(MagicExpansion.getInstance(), () -> {
                    processExtractInput(player, operation, input);
                });
            }

            @EventHandler
            public void onPlayerQuit(PlayerQuitEvent event) {
                pendingExtracts.remove(event.getPlayer().getUniqueId());
                cleanupListenerIfNeeded();
            }
        };

        Bukkit.getPluginManager().registerEvents(chatListener, MagicExpansion.getInstance());
    }

    /**
     * 处理玩家提取输入
     */
    private void processExtractInput(Player player, ExtractOperation operation, String input) {
        try {
            // 处理取消
            if (input.equalsIgnoreCase("cancel")) {
                player.sendMessage(ChatColor.YELLOW + "已取消提取操作。");
                pendingExtracts.remove(player.getUniqueId());
                cleanupListenerIfNeeded();
                return;
            }

            long extractAmount;

            // 解析数字
            try {
                extractAmount = Long.parseLong(input);
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED + "请输入有效的数字或 'cancel'！");
                return;
            }

            // 验证范围
            if (extractAmount <= 0) {
                player.sendMessage(ChatColor.RED + "请输入大于0的数字！");
                return;
            }

            if (extractAmount > operation.maxExtract) {
                player.sendMessage(ChatColor.RED + "超过最大可提取数量 (" + operation.maxExtract + ")！");
                return;
            }

            // 确保提取后至少保留1个
            if (operation.storedAmount - extractAmount < 1) {
                player.sendMessage(ChatColor.RED + "提取后量子存储中至少需要保留1个物品！");
                return;
            }

            // 确保不超过int最大值（因为CargoFragment使用int存储数量）
            if (extractAmount > Integer.MAX_VALUE) {
                player.sendMessage(ChatColor.RED + "提取数量超过最大限制 (" + Integer.MAX_VALUE + ")！");
                return;
            }

            // === 新增：验证物品是否发生变化 ===
            if (!validateItemsUnchanged(player, operation)) {
                player.sendMessage(ChatColor.RED + "操作失败：物品已发生变化！");
                pendingExtracts.remove(player.getUniqueId());
                cleanupListenerIfNeeded();
                return;
            }

            // 执行提取
            executeExtract(player, operation, extractAmount);

        } finally {
            pendingExtracts.remove(player.getUniqueId());
            cleanupListenerIfNeeded();
        }
    }

    /**
     * 验证物品在等待输入期间是否发生变化
     */
    private boolean validateItemsUnchanged(Player player, ExtractOperation operation) {
        // 1. 检查玩家是否在线
        if (!player.isOnline()) {
            return false;
        }

        // 2. 检查主手物品是否还是提取器
        ItemStack currentMainHand = player.getInventory().getItemInMainHand();
        if (currentMainHand == null || currentMainHand.getType().isAir()) {
            player.sendMessage(ChatColor.RED + "主手物品已消失！");
            return false;
        }

        // 检查是否是同一个物品（根据类型、名称等）
        if (!isSameExtractorItem(currentMainHand, operation.extractItem)) {
            player.sendMessage(ChatColor.RED + "主手物品已更换！");
            return false;
        }

        // 检查数量是否为1
        if (currentMainHand.getAmount() != 1) {
            player.sendMessage(ChatColor.RED + "主手物品数量已发生变化！");
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

        // 检查是否是同一个量子存储物品（通过PDC中的唯一标识）
        if (!isSameQuantumStorageItem(currentOffhand, operation.offhandItem)) {
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
        ItemStack currentStoredItem = currentCache.getItemStack();
        long currentStoredAmount = currentCache.getAmount();

        if (currentStoredItem == null) {
            player.sendMessage(ChatColor.RED + "量子存储中的物品已消失！");
            return false;
        }

        // 使用SameItemJudge比较物品是否相同
        if (!SameItemJudge.isSimilarSafe(currentStoredItem, operation.storedItem)) {
            player.sendMessage(ChatColor.RED + "量子存储中的物品已发生变化！");
            return false;
        }

        // 检查数量是否相同（不能少于之前记录的数量）
        if (currentStoredAmount < operation.storedAmount) {
            player.sendMessage(ChatColor.RED + "量子存储中的物品数量已减少！");
            return false;
        }

        // 如果数量增加了，使用新的数量进行计算
        if (currentStoredAmount > operation.storedAmount) {
            // 更新操作中的数量信息
            operation.storedAmount = currentStoredAmount;
            operation.maxExtract = currentStoredAmount - 1;

            // 通知玩家数量已更新
            player.sendMessage(ChatColor.GREEN + "检测到数量增加，已更新可提取数量！");
            player.sendMessage(ChatColor.YELLOW + "新的存储总量: " + ChatColor.AQUA + currentStoredAmount + " 个");
            player.sendMessage(ChatColor.YELLOW + "新的最大可提: " + ChatColor.GOLD + operation.maxExtract + " 个");

            // 更新缓存引用
            operation.quantumCache = currentCache;
        }

        return true;
    }

    /**
     * 检查是否同一个提取器物品
     */
    private boolean isSameExtractorItem(ItemStack item1, ItemStack item2) {
        // 简单比较：类型和自定义名称
        if (item1.getType() != item2.getType()) {
            return false;
        }

        ItemMeta meta1 = item1.getItemMeta();
        ItemMeta meta2 = item2.getItemMeta();

        if (meta1 == null || meta2 == null) {
            return meta1 == meta2;
        }

        // 比较显示名称
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

        // 比较缓存ID或其他唯一标识（如果QuantumCache有getId方法）
        try {
            // 如果有getId方法
            if (cache1.getItemStack()!= null && cache2.getItemStack() != null) {
                return cache1.getItemStack().equals(cache2.getItemStack());
            }
        } catch (Exception e) {
            // 如果QuantumCache没有getId方法，使用hashCode作为备用
            return cache1.hashCode() == cache2.hashCode();
        }

        return false;
    }


    /**
     * 执行提取操作
     */
    private void executeExtract(Player player, ExtractOperation operation, long extractAmount) {
        try {
            // 1. 减少量子存储的数量
            long newStoredAmount = operation.storedAmount - extractAmount;
            operation.quantumCache.setAmount((int) newStoredAmount);

            // 2. 更新副手物品的QuantumCache数据
            updateQuantumCacheInItem(operation.offhandItem, operation.quantumCache);

            // 3. 创建以太秘匣
            ItemStack cargoFragment = createCargoFragment(operation.storedItem, (int) extractAmount);
            if (cargoFragment == null) {
                player.sendMessage(ChatColor.RED + "创建以太秘匣失败！");
                return;
            }

            // 4. 给予玩家以太秘匣
            giveCargoFragmentToPlayer(player, cargoFragment, operation.storedItem, extractAmount, newStoredAmount);

            // 5. 播放成功音效
            playSound(player, Sound.ENTITY_ITEM_PICKUP, 1.2f);

        } catch (Exception e) {
            player.sendMessage(ChatColor.RED + "提取失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 创建一个 CargoFragment 物品，代表某个物品的"存储碎片"
     */
    private ItemStack createCargoFragment(ItemStack original, int amount) {
        ItemStack fragment = CARGO_FRAGMENT.clone();
        fragment.setType(original.getType());
        ItemMeta meta = fragment.getItemMeta();
        if (meta == null) return null;

        // === 显示名：存储碎片: 原物品名 ===
        String itemName = ItemStackHelper.getDisplayName(original);
        if (original.hasItemMeta() && original.getItemMeta().hasDisplayName()) {
            itemName = original.getItemMeta().getDisplayName();
        }
        meta.setDisplayName("§b「以太秘匣」");

        // === Lore：原物品 Lore + 数量 ===
        List<String> lore = new ArrayList<>();

        lore.add(itemName);

        if (original.hasItemMeta() && original.getItemMeta().hasLore()) {
            lore.addAll(original.getItemMeta().getLore());
            lore.add("");
        }

        lore.add("§f数量: §a" + amount);
        meta.setLore(lore);

        // === 写入 PDC：原物品（JSON）+ 数量 ===
        PersistentDataContainer container = meta.getPersistentDataContainer();

        // 存储原物品 JSON（便于还原）
        String json = itemToBase64(original.clone());
        if (json != null) {
            NamespacedKey keyItem = new NamespacedKey(MagicExpansion.getInstance(), "cargo_item_json");
            container.set(keyItem, PersistentDataType.STRING, json);
        }

        // 存储数量
        NamespacedKey keyAmount = new NamespacedKey(MagicExpansion.getInstance(), "cargo_amount");
        container.set(keyAmount, PersistentDataType.INTEGER, amount);

        fragment.setItemMeta(meta);
        return fragment;
    }

    /**
     * 将物品序列化为Base64字符串
     */
    private String itemToBase64(ItemStack item) {
        try {
            return SameItemJudge.itemToBase64(item);
        } catch (Exception e) {
            return null;
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
     * 给予玩家以太秘匣
     */
    private void giveCargoFragmentToPlayer(Player player, ItemStack cargoFragment, ItemStack storedItem,
                                           long extractedAmount, long remainingAmount) {
        // 尝试添加到玩家背包
        HashMap<Integer, ItemStack> leftover = player.getInventory().addItem(cargoFragment);

        // 如果有剩余物品（背包满了）
        if (!leftover.isEmpty()) {
            // 掉落在地上
            for (ItemStack item : leftover.values()) {
                player.getWorld().dropItem(player.getLocation(), item);
            }

            player.sendMessage(ChatColor.GREEN + "✓ 成功提取 " + ChatColor.YELLOW + extractedAmount +
                    ChatColor.GREEN + " 个 " + ItemStackHelper.getDisplayName(storedItem));
            player.sendMessage(ChatColor.GRAY + "背包已满，以太秘匣已掉落在地面上！");
        } else {
            player.sendMessage(ChatColor.GREEN + "✓ 成功提取 " + ChatColor.YELLOW + extractedAmount +
                    ChatColor.GREEN + " 个 " + ItemStackHelper.getDisplayName(storedItem));
            player.sendMessage(ChatColor.GRAY + "已获得以太秘匣！");
        }

        // 显示量子存储剩余数量
        player.sendMessage(ChatColor.GRAY + "量子存储剩余: " + remainingAmount + " 个");

        // 更新副手物品显示
        player.getInventory().setItemInOffHand(player.getInventory().getItemInOffHand());
    }

    /**
     * 设置超时任务
     */
    private void scheduleTimeout(UUID playerId) {
        Bukkit.getScheduler().runTaskLater(MagicExpansion.getInstance(), () -> {
            ExtractOperation operation = pendingExtracts.remove(playerId);
            if (operation != null) {
                Player player = Bukkit.getPlayer(playerId);
                if (player != null && player.isOnline()) {
                    player.sendMessage(ChatColor.RED + "提取操作超时，已自动取消。");
                }
                cleanupListenerIfNeeded();
            }
        }, 20 * 30); // 30秒
    }

    /**
     * 清理监听器
     */
    private void cleanupListenerIfNeeded() {
        if (pendingExtracts.isEmpty() && chatListener != null) {
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

    /**
     * 提取操作信息类
     */
    private static class ExtractOperation {
        final UUID playerId;
        final ItemStack extractItem;
        final ItemStack offhandItem;
        ItemStack storedItem; // 改为非final，可能更新
        long storedAmount; // 改为非final，可能更新
        QuantumCache quantumCache; // 改为非final，可能更新
        long maxExtract; // 改为非final，可能更新

        ExtractOperation(UUID playerId, ItemStack extractItem, ItemStack offhandItem,
                         ItemStack storedItem, long storedAmount,
                         QuantumCache quantumCache, long maxExtract) {
            this.playerId = playerId;
            this.extractItem = extractItem;
            this.offhandItem = offhandItem;
            this.storedItem = storedItem;
            this.storedAmount = storedAmount;
            this.quantumCache = quantumCache;
            this.maxExtract = maxExtract;
        }
    }
}