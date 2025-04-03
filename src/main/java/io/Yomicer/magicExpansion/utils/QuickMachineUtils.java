package io.Yomicer.magicExpansion.utils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import net.guizhanss.guizhanlib.minecraft.helper.inventory.ItemStackHelper;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.Yomicer.magicExpansion.utils.GiveItem.giveOrDropItem;

public class QuickMachineUtils {

    /**
     * 消耗指定数量的材料    带有key
     * 玩家，配方，倍率
     */
    public static void consumeMaterials(Player player, Map<String, Integer> recipe, int amount) {
        PlayerInventory inventory = player.getInventory();

        for (Map.Entry<String, Integer> requiredEntry : recipe.entrySet()) {
            String requiredKey = requiredEntry.getKey();
            int requiredAmountPerCraft = requiredEntry.getValue();
            int totalRequiredAmount = requiredAmountPerCraft * amount;

            if (requiredKey.startsWith("mc:")) {
                // 原版物品
                Material material = Material.matchMaterial(requiredKey.substring(3));
                if (material != null) {
                    inventory.removeItem(new ItemStack(material, totalRequiredAmount));
                }
            } else if (requiredKey.startsWith("sf:")) {
                // Slimefun 物品
                String slimefunId = requiredKey.substring(3);
                SlimefunItem slimefunItem = SlimefunItem.getById(slimefunId);
                if (slimefunItem != null) {
                    ItemStack item = slimefunItem.getItem().clone();
                    item.setAmount(totalRequiredAmount);
                    inventory.removeItem(item);
                }
            }
        }

    }


    /**
     * 判断最终可以合成的产物
     * 根据配方和指定的 RecipeType 查找对应的产物。
     *
     * @param recipe     配方（以 Map 形式表示）
     * @param recipeType 指定的 RecipeType
     * @return 匹配的产物 ItemStack，如果未找到则返回 null
     */
    public static ItemStack getRecipeResult(Map<String, Integer> recipe, RecipeType recipeType) {
        // 遍历所有已注册的 Slimefun 物品
        for (SlimefunItem item : Slimefun.getRegistry().getAllSlimefunItems()) {
            // 检查物品的 RecipeType 是否匹配指定的类型
            if (item.getRecipeType() == recipeType) {
                // 将物品的配方转换为 Map 形式
                Map<String, Integer> recipeMap = convertRecipeToMap(item.getRecipe());
                // 比较配方是否一致
                if (recipeMap.equals(recipe)) {
                    return item.getItem(); // 返回匹配的产物
                }
            }
        }
        return null; // 如果未找到匹配的物品，返回 null
    }


    /**
     * 整合配方材料，合并相同物品
     * 将配方数组转换为 Map
     *
     * @param recipe 配方数组
     * @return 配方 Map
     */
    public static Map<String, Integer> convertRecipeToMap(ItemStack[] recipe) {
        Map<String, Integer> recipeMap = new HashMap<>();
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
        return recipeMap;
    }


    /**
     * 输出粘液物品名字
     * 根据物品类型获取显示名称
     *
     * @param item 物品
     * @return 显示名称
     */
    public static String getDisplayName(ItemStack item) {
        Material material = item.getType();
        SlimefunItem slimefunItem = SlimefunItem.getByItem(item);

        if (slimefunItem != null) {
            // 如果是 SlimefunItem，返回其 ID
            return slimefunItem.getItemName();
        } else {
            // 如果是原版物品，返回其英文名称
            return material.name();
        }
    }

    /**
     * 输出所需配方材料名称，汉化原本物品+粘液名称
     * 获取配方材料显示名称
     * 根据物品键获取显示名称
     *
     * @param itemKey 物品键
     * @return 显示名称
     */
    public static String getIngredientDisplayName(String itemKey) {
        if (itemKey.startsWith("mc:")) {
            // 如果是原版物品，提取 Material 名称并返回
            String materialName = itemKey.substring(3); // 去掉前缀 "mc:"
            Material material = Material.matchMaterial(materialName);
            if (material != null) {
                // 创建一个临时的 ItemStack
                ItemStack itemStack = new ItemStack(material);
                return ItemStackHelper.getName(itemStack);
            }
            return "未知原版物品 (" + materialName + ")";
        } else if (itemKey.startsWith("sf:")) {
            // 如果是 Slimefun 物品，提取 ID 并查找对应的 SlimefunItem
            String slimefunId = itemKey.substring(3); // 去掉前缀 "sf:"
            SlimefunItem slimefunItem = SlimefunItem.getById(slimefunId);
            if (slimefunItem != null) {
                return slimefunItem.getItemName(); // 返回 Slimefun 物品的显示名称
            }
            return "未知 Slimefun 物品 (" + slimefunId + ")";
        } else {
            return "未知物品类型 (" + itemKey + ")";
        }
    }



    /**
     * 计算玩家最多可以合成的数量
     */
    public static int calculateMaxCraftableAmount(Map<String, Integer> playerItems, Map<String, Integer> recipe) {
        int maxCraftableAmount = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> requiredEntry : recipe.entrySet()) {
            String requiredKey = requiredEntry.getKey();
            int requiredAmount = requiredEntry.getValue();

            int availableAmount = playerItems.getOrDefault(requiredKey, 0);
            maxCraftableAmount = Math.min(maxCraftableAmount, availableAmount / requiredAmount);
        }

        return maxCraftableAmount;
    }


    /**
     * 获取玩家背包中的所有物品及其数量
     * 并且给一个键
     *
     * @param player 玩家对象
     * @return 一个 Map，键为物品类型或 SlimefunItem ID，值为该物品的数量
     */
    public static Map<String, Integer> getPlayerInventoryItems(Player player) {
        PlayerInventory inventory = player.getInventory();
        Map<String, Integer> itemCounts = new HashMap<>();

        for (ItemStack item : inventory.getContents()) {
            if (item != null && item.getType() != Material.AIR) {
                // 判断是否为 SlimefunItem
                String itemKey;
                SlimefunItem slimefunItem = SlimefunItem.getByItem(item);
                if (slimefunItem != null) {
                    // 如果是 SlimefunItem，使用其 ID 作为键
                    itemKey = "sf:" + slimefunItem.getId();
                } else {
                    // 如果不是 SlimefunItem，则默认为原版物品
                    itemKey = "mc:" + item.getType().name();
                }

                // 整合玩家背包中的物品数量
                itemCounts.put(itemKey, itemCounts.getOrDefault(itemKey, 0) + item.getAmount());
            }
        }

        return itemCounts;
    }



    /**
     * 检查玩家是否有足够的物品来制作配方
     *
     * @param playerItems 玩家背包中的所有物品及其数量
     * @param recipe      配方
     * @param amount      合成数量
     * @return 如果玩家有足够的物品，则返回 true，否则返回 false
     */
    public static boolean hasEnoughMaterials(Map<String, Integer> playerItems, Map<String, Integer> recipe, int amount) {
        // 检查玩家是否有足够的物品
        for (Map.Entry<String, Integer> requiredEntry : recipe.entrySet()) {
            String requiredKey = requiredEntry.getKey();
            int requiredAmount = requiredEntry.getValue() * amount; // 根据合成数量调整所需材料

            int availableAmount = playerItems.getOrDefault(requiredKey, 0);
            if (availableAmount < requiredAmount) {
                return false;
            }
        }
        return true;
    }

    // 默认 amount=1 的重载方法
    public static boolean hasEnoughMaterials(Map<String, Integer> playerItems, Map<String, Integer> recipe) {
        return hasEnoughMaterials(playerItems, recipe, 1); // 调用带 amount 参数的方法，默认值为 1
    }




    /**
     * 将符合条件的配方添加到菜单中，并支持分页
     * 刷新逻辑
     *
     * @param player 玩家对象
     * @param menu   菜单对象
     * @param page   当前页码（从 0 开始）
     */
    public static void addAvailableRecipesToMenu(Player player, ChestMenu menu, int page, List<Map<String, Integer>> ReceivedRecipes) {
        // 获取玩家背包中的所有物品及其数量
        Map<String, Integer> playerItems = getPlayerInventoryItems(player);

        // 清空菜单内容
        for (int i = 0; i < menu.getSize(); i++) {
            menu.addItem(i, null);
        }

        // 筛选出玩家可以制作的配方
        List<Map<String, Integer>> availableRecipes = ReceivedRecipes.stream()
                .filter(recipe -> hasEnoughMaterials(playerItems, recipe))
                .toList();

        // 分页逻辑
        int itemsPerPage = 45; // 每页显示的最大数量
        int totalPages = (int) Math.ceil((double) availableRecipes.size() / itemsPerPage);
        page = Math.max(0, Math.min(page, totalPages - 1)); // 确保页码在有效范围内

        // 当前页的配方
        List<Map<String, Integer>> currentPageRecipes = availableRecipes.stream()
                .skip((long) page * itemsPerPage)
                .limit(itemsPerPage)
                .toList();

        // 添加配方到菜单中
        int slot = 0;
        for (Map<String, Integer> recipe : currentPageRecipes) {
            ItemStack resultItem = getRecipeResult(recipe, RecipeType.SMELTERY); // 根据配方获取结果物品
            if (resultItem == null) continue;

            // 创建一个局部变量 currentSlot 来存储当前槽位
            int currentSlot = slot++;
            menu.addItem(currentSlot, resultItem, (p, s, item, action) -> {
                if (action.isRightClicked()&&!action.isShiftClicked()) {
                    // 右键点击：显示制作一份所需的材料
                    p.sendMessage("§a配方: §b" + getDisplayName(resultItem));
                    p.sendMessage("§a所需材料:");
                    for (Map.Entry<String, Integer> ingredient : recipe.entrySet()) {
                        String itemKey = ingredient.getKey(); // 材料键值（如 "mc:COBBLESTONE" 或 "sf:some_item_id"）
                        int requiredAmount = ingredient.getValue(); // 所需数量

                        // 获取材料的显示名称
                        String displayName = getIngredientDisplayName(itemKey);

                        // 发送消息
                        p.sendMessage(" - §e" + displayName + " x " + requiredAmount);
                    }
                } else if (!action.isRightClicked() && !action.isShiftClicked()) {
                    // 左键点击：消耗一份材料并给予一份产品
                    Map<String, Integer> currentPlayerItems = getPlayerInventoryItems(p);
                    if (!hasEnoughMaterials(currentPlayerItems, recipe)) {
                        p.sendMessage("§c材料不足，无法合成！");
                        return false;
                    }

                    // 双重检查材料是否足够
                    currentPlayerItems = getPlayerInventoryItems(p); // 重新获取最新物品状态
                    if (!hasEnoughMaterials(currentPlayerItems, recipe)) {
                        p.sendMessage("§c材料不足，无法合成！");
                        return false;
                    }

                    // 消耗材料
                    consumeMaterials(p, recipe, 1);

                    // 给予产品
                    ItemStack product = getRecipeResult(recipe,RecipeType.SMELTERY);
                    if (product != null) {
                        // 检查是否为 SlimefunItemStack
                        if (product instanceof SlimefunItemStack) {
                            // 克隆 SlimefunItemStack 以避免修改原始对象
                            product = product.clone();
                        }

                        // 设置数量
                        product.setAmount(1);

                        // 使用 giveOrDropItem 方法给予玩家物品或掉落
                        giveOrDropItem(p, product);

                        // 获取产物名称
                        String productName = getDisplayName(product);

                        // 提示信息
                        p.sendMessage("§a你成功合成了 §b1 §a个 §b" + productName + "§a。");
                    }

                    // 刷新菜单
                    addAvailableRecipesToMenu(p, menu, 0,ReceivedRecipes);
                } else if (!action.isRightClicked() && action.isShiftClicked()) {
                    // Shift + 右键点击：批量合成
                    Map<String, Integer> currentPlayerItems = getPlayerInventoryItems(p);
                    int maxCraftableAmount = calculateMaxCraftableAmount(currentPlayerItems, recipe);

                    if (maxCraftableAmount <= 0) {
                        p.sendMessage("§c材料不足，无法合成！");
                        return false;
                    }

                    // 双重检查材料是否足够
                    currentPlayerItems = getPlayerInventoryItems(p); // 重新获取最新物品状态
                    int finalCraftableAmount = Math.min(maxCraftableAmount, calculateMaxCraftableAmount(currentPlayerItems, recipe));
                    if (finalCraftableAmount <= 0) {
                        p.sendMessage("§c材料不足，无法合成！");
                        return false;
                    }

                    // 消耗材料
                    consumeMaterials(p, recipe, finalCraftableAmount);

                    // 给予产品
                    ItemStack product = getRecipeResult(recipe,RecipeType.SMELTERY);
                    if (product != null) {
                        // 检查是否为 SlimefunItemStack
                        if (product instanceof SlimefunItemStack) {
                            // 克隆 SlimefunItemStack 以避免修改原始对象
                            product = product.clone();
                        }

                        // 设置数量
                        product.setAmount(maxCraftableAmount);

                        // 使用 giveOrDropItem 方法给予玩家物品或掉落
                        giveOrDropItem(p, product);
                        // 获取产物名称
                        String productName = getDisplayName(product);

                        // 提示信息
                        p.sendMessage("§a你成功合成了 §b" + maxCraftableAmount + " §a个 §b" + productName + "§a。");
                    }

                    // 刷新菜单
                    addAvailableRecipesToMenu(p, menu, 0,ReceivedRecipes);
                }else // 按住 Shift 并右键点击冶炼炉内的物品，查看最大可冶炼数量
                    if (action.isRightClicked() && action.isShiftClicked()) {
                        // 获取玩家背包中的所有物品
                        Map<String, Integer> currentPlayerItems = getPlayerInventoryItems(p);

                        // 固定合成数量为 32
                        int requiredAmount = 32;

                        // 检查是否可以合成 32 个产物
                        if (!hasEnoughMaterials(currentPlayerItems, recipe, requiredAmount)) {
                            p.sendMessage("§c材料不足，无法合成 32 个产物！");
                            return false;
                        }

                        // 双重检查材料是否足够（重新获取最新物品状态）
                        currentPlayerItems = getPlayerInventoryItems(p);
                        if (!hasEnoughMaterials(currentPlayerItems, recipe, requiredAmount)) {
                            p.sendMessage("§c材料不足，无法合成 32 个产物！");
                            return false;
                        }

                        // 消耗材料
                        consumeMaterials(p, recipe, requiredAmount);

                        // 给予产品
                        ItemStack product = getRecipeResult(recipe,RecipeType.SMELTERY);
                        if (product != null) {
                            // 检查是否为 SlimefunItemStack
                            if (product instanceof SlimefunItemStack) {
                                // 克隆 SlimefunItemStack 以避免修改原始对象
                                product = product.clone();
                            }

                            // 设置数量为 32
                            product.setAmount(requiredAmount);

                            // 使用 giveOrDropItem 方法给予玩家物品或掉落
                            giveOrDropItem(p, product);

                            // 获取产物名称
                            String productName = getDisplayName(product);

                            // 提示信息
                            p.sendMessage("§a你成功合成了 §b32 §a个 §b" + productName + "§a。");
                        }

                        // 刷新菜单
                        addAvailableRecipesToMenu(p, menu, 0,ReceivedRecipes);
                    }
                return false; // 不消耗物品
            });
        }

        // 添加分页按钮
        if (page > 0) {
            // 上一页按钮
            final int previousPage = page - 1; // 使用局部变量存储上一页的页码
            menu.addItem(45, CreateItem.createItem(Material.ARROW, "§a上一页"), (p, s, item, action) -> {
                addAvailableRecipesToMenu(p, menu, previousPage,ReceivedRecipes); // 切换到上一页
                return false;
            });
        }

        if (page < totalPages - 1) {
            // 下一页按钮
            final int nextPage = page + 1; // 使用局部变量存储下一页的页码
            menu.addItem(53, CreateItem.createItem(Material.ARROW, "§a下一页"), (p, s, item, action) -> {
                addAvailableRecipesToMenu(p, menu, nextPage,ReceivedRecipes); // 切换到下一页
                return false;
            });
        }

        // 如果没有符合条件的配方，显示提示
        if (availableRecipes.isEmpty()) {
            menu.addItem(0, CreateItem.createItem(Material.BARRIER, "§c没有可制作的配方"), (p, s, item, action) -> {
                p.sendMessage("§c你的背包中没有足够的材料！");
                return false;
            });
        }
    }


}
