package io.Yomicer.magicExpansion.utils;

import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.Yomicer.magicExpansion.items.misc.fish.fishInterface.BaseFish;
import io.Yomicer.magicExpansion.items.misc.fish.fishInterface.FishManager;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import net.guizhanss.guizhanlib.minecraft.helper.inventory.ItemStackHelper;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static io.Yomicer.magicExpansion.utils.CreateItem.createItem;
import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;

public class FishingGuideMenu {

    // 主菜单标题（渐变色）
    private static final String MAIN_TITLE = getGradientName("✨钓鱼图鉴✨");

    // 分类数据
    private static final String[] CATEGORIES = {
            "common_fish", "uncommon_fish", "rare_fish",
            "epic_fish", "legendary_fish", "mythical_fish", "junk",
            "magic_sugar", "bread"
    };
    private static final String[] DISPLAY_NAMES = {
            "§f✦ 常见鱼", "§a✦ 罕见鱼", "§9✦ 稀有鱼",
            "§5✦ 史诗鱼", "§6✦ 传奇鱼", "§e✦ 神话鱼", "§7✦ 杂物",
            "§d✦ 鱼饵·魔法糖", "§b✦ 鱼饵·面包"
    };
    private static final Material[] ICONS = {
            Material.COD, Material.SALMON, Material.PUFFERFISH,
            Material.TROPICAL_FISH, Material.NAUTILUS_SHELL, Material.NETHER_STAR, Material.FISHING_ROD,
            Material.SUGAR, Material.BREAD
    };
    private static final String[] LORES = {
            "§e最常见的鱼类，随手可得",
            "§e比普通鱼少见，但不算稀有",
            "§e深海出没，需要耐心等待",
            "§e传说中的海洋生物，极其罕见",
            "§e神迹显现！只在特殊天气出现",
            "§e只存在于神话里的鱼！",
            "§e钓上来一堆破烂……但也可能有惊喜？",
            "§e—— 仅展示可能的鱼获·图鉴暂不展示强定向鱼饵鱼获 ——",
            "§e—— 仅展示可能的鱼获·图鉴暂不展示强定向鱼饵鱼获 ——"
    };

    // 装饰玻璃
    private static final Material BORDER_GLASS = Material.BLUE_STAINED_GLASS_PANE;
    private static final Material CORNER_GLASS = Material.LIGHT_BLUE_STAINED_GLASS_PANE;

    // 返回按钮
    private static final ItemStack BACK_BUTTON = createItemWithLore(Material.ARROW, "§a← 返回");

    /**
     * 创建带有lore的物品
     */
    private static ItemStack createItemWithLore(Material material, String displayName, String... lore) {
        ItemStack item = createItem(material, displayName);
        if (lore != null && lore.length > 0) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                meta.setLore(Arrays.asList(lore));
                item.setItemMeta(meta);
            }
        }
        return item;
    }

    /**
     * 创建分类物品
     */
    private static ItemStack createCategoryItem(Material material, String name, String lore) {
        List<String> loreList = Arrays.asList("", lore, "", "§a▶ 点击进入");
        return createItemWithLore(material, name, loreList.toArray(new String[0]));
    }

    /**
     * 创建装饰玻璃
     */
    private static ItemStack createDecorItem(Material material, String name) {
        return createItemWithLore(material, name, "§7钓鱼图鉴");
    }

    /**
     * 打开主菜单
     */
    public static void openMainMenu(Player player) {
        ChestMenu menu = new ChestMenu(MAIN_TITLE);

        // 设置边框装饰
        setupMenuBorders(menu);

        // 添加分类按钮（从第一个空位开始）
        int[] categorySlots = getAvailableSlots();
        for (int i = 0; i < CATEGORIES.length && i < categorySlots.length; i++) {
            ItemStack item = createCategoryItem(ICONS[i], DISPLAY_NAMES[i], LORES[i]);
            menu.addItem(categorySlots[i], item);

            final String category = CATEGORIES[i];
            menu.addMenuClickHandler(categorySlots[i], (p, slot, itemStack, click) -> {
                openCategoryPage(p, category);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                return false;
            });
        }

        // 添加关闭按钮（49位置）
        menu.addItem(49, createItemWithLore(Material.BARRIER, "§c关闭菜单"));
        menu.addMenuClickHandler(49, (p, slot, item, click) -> {
            p.closeInventory();
            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
            return false;
        });

        int randomSlot = 21 + new Random().nextInt(24);
        // 50%概率添加物品
        if (new Random().nextBoolean()) {
            int choice = new Random().nextInt(3);

            switch (choice) {
                case 0:
                    menu.addItem(randomSlot,
                            new CustomItemStack(Material.BREAD,
                                    getGradientName("鱼饵·面包"),
                                    getGradientName("点我拾取一个面包")),
                            (player1, slot, item, action) -> {
                                ItemStack drop = new ItemStack(Material.BREAD);
                                player1.getWorld().dropItemNaturally(player1.getLocation(), drop);
                                menu.replaceExistingItem(slot,
                                        new ItemStack(Material.AIR)
                                );
                                return false;
                            });
                    break;
                case 1:
                    menu.addItem(randomSlot,
                            new CustomItemStack(Material.SUGAR,
                                    getGradientName("鱼饵·魔法糖"),
                                    getGradientName("点我拾取一个魔法糖")),
                            (player1, slot, item, action) -> {
                                SlimefunItem sfItem = SlimefunItem.getByItem(SlimefunItems.MAGIC_SUGAR);
                                ItemStack drop = sfItem.getItem().clone();
                                player1.getWorld().dropItemNaturally(player1.getLocation(), drop);
                                menu.replaceExistingItem(slot,
                                        new ItemStack(Material.AIR)
                                );
                                return false;
                            });
                    break;
                case 2:
                    menu.addItem(randomSlot,
                            new CustomItemStack(Material.BONE_MEAL,
                                    getGradientName("鱼饵·基础魔法饵料"),
                                    getGradientName("点我拾取一个基础魔法饵料")),
                            (player1, slot, item, action) -> {
                                SlimefunItem sfItem = SlimefunItem.getByItem(MagicExpansionItems.FISH_LURE_BASIC);
                                ItemStack drop = sfItem.getItem().clone();
                                player1.getWorld().dropItemNaturally(player1.getLocation(), drop);
                                menu.replaceExistingItem(slot,
                                        new ItemStack(Material.AIR)
                                );
                                return false;
                            });
                    break;
            }
        }

        // 设置不可点击空槽和玩家背包
        menu.setEmptySlotsClickable(false);
        menu.setPlayerInventoryClickable(false);

        // 打开菜单
        menu.open(player);
    }

    /**
     * 设置菜单边框装饰
     */
    private static void setupMenuBorders(ChestMenu menu) {
        menu.addItem(0, createDecorItem(CORNER_GLASS, "§b✨"));
        menu.addMenuClickHandler(0, (p, slot, item, click) -> false);
        menu.addItem(8, createDecorItem(CORNER_GLASS, "§b✨"));
        menu.addMenuClickHandler(8, (p, slot, item, click) -> false);
        menu.addItem(45, createDecorItem(CORNER_GLASS, "§b✨"));
        menu.addMenuClickHandler(45, (p, slot, item, click) -> false);
        menu.addItem(53, createDecorItem(CORNER_GLASS, "§b✨"));
        menu.addMenuClickHandler(53, (p, slot, item, click) -> false);

        for (int i = 1; i < 8; i++) {
            menu.addItem(i, createDecorItem(BORDER_GLASS, "§9🌊 海洋图鉴"));
            menu.addMenuClickHandler(i, (p, slot, item, click) -> false);
        }

        for (int i = 46; i < 53; i++) {
            menu.addItem(i, createDecorItem(BORDER_GLASS, "§b潜水探索中..."));
            menu.addMenuClickHandler(i, (p, slot, item, click) -> false);
        }

        // 左边框 (9,18,27,36)
        int[] leftBorder = {9, 18, 27, 36};
        for (int slot : leftBorder) {
            menu.addItem(slot, createDecorItem(BORDER_GLASS, "§9🎣"));
            menu.addMenuClickHandler(slot, (p, slot1, item, click) -> false);
        }

        // 右边框 (17,26,35,44)
        int[] rightBorder = {17, 26, 35, 44};
        for (int slot : rightBorder) {
            menu.addItem(slot, createDecorItem(BORDER_GLASS, "§9🐟"));
            menu.addMenuClickHandler(slot, (p, slot1, item, click) -> false);
        }
    }

    /**
     * 获取可用的槽位（排除边框后的空位）
     */
    private static int[] getAvailableSlots() {
        // 所有被占用的边框槽位
        Set<Integer> occupiedSlots = new HashSet<>();

        // 四个角
        occupiedSlots.add(0);
        occupiedSlots.add(8);
        occupiedSlots.add(45);
        occupiedSlots.add(53);

        // 上下边框
        for (int i = 1; i < 8; i++) occupiedSlots.add(i);
        for (int i = 46; i < 53; i++) occupiedSlots.add(i);

        // 左右边框
        int[] leftRightBorder = {9, 17, 18, 26, 27, 35, 36, 44};
        for (int slot : leftRightBorder) occupiedSlots.add(slot);

        // 收集所有可用槽位
        List<Integer> availableSlots = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            if (!occupiedSlots.contains(i)) {
                availableSlots.add(i);
            }
        }

        return availableSlots.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 打开分类详情页（支持分页）
     */
    public static void openCategoryPage(Player player, String category) {
        openCategoryPage(player, category, 0); // 默认打开第0页
    }

    private static void openCategoryPage(Player player, String category, int page) {
        String title = getCategoryTitle(category);
        ChestMenu menu = new ChestMenu(getGradientName("✦ " + title));

        // 设置边框装饰
        setupCategoryBorders(menu, title);

        // 获取该分类下的所有物品
        List<ItemStack> allItems = getItemsByCategory(category);

        // 分页设置 - 使用实际可用槽位数量
        int[] availableSlots = getAvailableSlots();
        int itemsPerPage = availableSlots.length; // 每页物品数量等于可用槽位数
        int totalPages = (int) Math.ceil((double) allItems.size() / itemsPerPage);

        // 确保页码在有效范围内
        page = Math.max(0, Math.min(page, totalPages - 1));

        // 获取当前页的物品
        int startIndex = page * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, allItems.size());
        List<ItemStack> currentPageItems = allItems.subList(startIndex, endIndex);

        // 填充当前页物品到可用槽位
        for (int i = 0; i < currentPageItems.size() && i < availableSlots.length; i++) {
            ItemStack originalItem = currentPageItems.get(i);

            // 克隆物品并设置渐变名称
            ItemStack display = originalItem.clone();
            ItemMeta meta = display.getItemMeta();
            if (meta != null) {
                String displayName = ItemStackHelper.getDisplayName(display);
                meta.setDisplayName("§r"+(displayName));

                List<String> newLore = getStrings(page, meta, totalPages);
                meta.setLore(newLore);

                display.setItemMeta(meta);
            }

            menu.addItem(availableSlots[i], display);
            menu.addMenuClickHandler(availableSlots[i], (p, s, i1, c) -> false);
        }

        // 添加分页导航按钮
        setupCategoryPagination(menu, category, page, totalPages);

        // 禁用点击和背包交互
        menu.setEmptySlotsClickable(false);
        menu.setPlayerInventoryClickable(false);

        // 打开菜单
        menu.open(player);
    }

    private static @NotNull List<String> getStrings(int page, ItemMeta meta, int totalPages) {
        List<String> originalLore = meta.getLore();
        List<String> newLore = new ArrayList<>();
        // 如果原有Lore不为空，先添加原有Lore
        if (originalLore != null && !originalLore.isEmpty()) {
            newLore.addAll(originalLore);
        }
        newLore.add("");
        newLore.add("§7这是一个仅供展示的图鉴条目");
        newLore.add("§8—— 仅展示用途及获取条件 ——");
        if (totalPages > 1) {
            newLore.add("§6页码: " + (page + 1) + "/" + totalPages); // 多页时才显示页码
        }
        return newLore;
    }

    /**
     * 设置分类页面分页导航
     */
    private static void setupCategoryPagination(ChestMenu menu, String category, int currentPage, int totalPages) {
        // 返回按钮放在49号槽位
        menu.addItem(49, BACK_BUTTON);
        menu.addMenuClickHandler(49, (p, s, i, c) -> {
            openMainMenu(p);
            p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
            return false;
        });

        // 只有一页时不显示分页按钮，用屏障占位
        if (totalPages <= 1) {
            // 上一页位置放屏障
            menu.addItem(48, createItemWithLore(Material.BARRIER, "§8"));
            menu.addMenuClickHandler(48, (p, s, i, c) -> false);

            // 下一页位置放屏障
            menu.addItem(50, createItemWithLore(Material.BARRIER, "§8"));
            menu.addMenuClickHandler(50, (p, s, i, c) -> false);
            return;
        }

        // 上一页按钮 (放在48号槽位)
        if (currentPage > 0) {
            ItemStack prevButton = createItemWithLore(
                    Material.ARROW,
                    "§6← 上一页",
                    "§7点击查看上一页",
                    "§8当前: " + (currentPage + 1) + " / " + totalPages
            );
            menu.addItem(48, prevButton);
            menu.addMenuClickHandler(48, (p, s, i, c) -> {
                openCategoryPage(p, category, currentPage - 1);
                p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                return false;
            });
        } else {
            // 第一页时显示屏障
            menu.addItem(48, createItemWithLore(Material.BARRIER, "§8"));
            menu.addMenuClickHandler(48, (p, s, i, c) -> false);
        }

        // 下一页按钮 (放在50号槽位)
        if (currentPage < totalPages - 1) {
            ItemStack nextButton = createItemWithLore(
                    Material.ARROW,
                    "§6下一页 →",
                    "§7点击查看下一页",
                    "§8当前: " + (currentPage + 1) + " / " + totalPages
            );
            menu.addItem(50, nextButton);
            menu.addMenuClickHandler(50, (p, s, i, c) -> {
                openCategoryPage(p, category, currentPage + 1);
                p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                return false;
            });
        } else {
            // 最后一页时显示屏障
            menu.addItem(50, createItemWithLore(Material.BARRIER, "§8"));
            menu.addMenuClickHandler(50, (p, s, i, c) -> false);
        }
    }

    /**
     * 设置分类页面边框装饰
     */
    private static void setupCategoryBorders(ChestMenu menu, String title) {
        // 四个角
        menu.addItem(0, createDecorItem(CORNER_GLASS, "§b✨"));
        menu.addMenuClickHandler(0, (p, slot, item, click) -> false);
        menu.addItem(8, createDecorItem(CORNER_GLASS, "§b✨"));
        menu.addMenuClickHandler(8, (p, slot, item, click) -> false);
        menu.addItem(45, createDecorItem(CORNER_GLASS, "§b✨"));
        menu.addMenuClickHandler(45, (p, slot, item, click) -> false);
        menu.addItem(53, createDecorItem(CORNER_GLASS, "§b✨"));
        menu.addMenuClickHandler(53, (p, slot, item, click) -> false);


        // 上边框
        for (int i = 1; i < 8; i++) {
            menu.addItem(i, createDecorItem(BORDER_GLASS, "§9" + title));
            menu.addMenuClickHandler(i, (p, slot, item, click) -> false);
        }

        // 下边框 - 跳过48,49,50槽位（用于分页按钮）
        for (int i = 46; i < 53; i++) {
            if (i == 48 || i == 49 || i == 50) continue; // 跳过分页按钮位置
            menu.addItem(i, createDecorItem(BORDER_GLASS, "§b分类：" + title));
            menu.addMenuClickHandler(i, (p, slot, item, click) -> false);
        }

        // 左边框
        int[] leftBorder = {9, 18, 27, 36};
        for (int slot : leftBorder) {
            menu.addItem(slot, createDecorItem(BORDER_GLASS, "§9📖"));
            menu.addMenuClickHandler(slot, (p, slot1, item, click) -> false);
        }

        // 右边框
        int[] rightBorder = {17, 26, 35, 44};
        for (int slot : rightBorder) {
            menu.addItem(slot, createDecorItem(BORDER_GLASS, "§9📚"));
            menu.addMenuClickHandler(slot, (p, slot1, item, click) -> false);
        }
    }

    /**
     * 获取分类标题
     */
    private static String getCategoryTitle(String category) {
        return switch (category) {
            case "common_fish" -> "常见鱼";
            case "uncommon_fish" -> "罕见鱼";
            case "rare_fish" -> "稀有鱼";
            case "epic_fish" -> "史诗鱼";
            case "legendary_fish" -> "传奇鱼";
            case "mythical_fish" -> "神话鱼";
            case "junk" -> "杂物";
            case "magic_sugar" -> "魔法糖·鱼获";
            case "bread" -> "面包·鱼获";
            default -> "未知分类";
        };
    }

    /**
     * 获取分类物品
     */
    private static List<ItemStack> getItemsByCategory(String category) {
        List<ItemStack> items = new ArrayList<>();

        switch (category) {
            case "common_fish":
                // 添加常见鱼类
                items.add(new CustomItemStack(Material.COD,getGradientName("关于鱼群喜好"),getGradientName("喜好只是这种鱼更喜欢这种鱼饵"),getGradientName("其他鱼饵也有一定概率钓到这种鱼"),getGradientName("当然也有可能根本钓不到")));
                items.add(FishManager.getFishItemWithLore(BaseFish.SanWenFish,"",getGradientName("任何鱼饵都可以钓到它")));
                items.add(FishManager.getFishItemWithLore(BaseFish.XueFish,"",getGradientName("任何鱼饵都可以钓到它")));
                break;
            case "uncommon_fish":
                items.add(new CustomItemStack(Material.COD,getGradientName("关于鱼群喜好"),getGradientName("喜好只是这种鱼更喜欢这种鱼饵"),getGradientName("其他鱼饵也有一定概率钓到这种鱼"),getGradientName("当然也有可能根本钓不到")));
                items.add(FishManager.getFishItemWithLore(BaseFish.HeTun,"",getGradientName("任何鱼饵都可以钓到它")));
                break;
            case "rare_fish":
                items.add(new CustomItemStack(Material.COD,getGradientName("关于鱼群喜好"),getGradientName("喜好只是这种鱼更喜欢这种鱼饵"),getGradientName("其他鱼饵也有一定概率钓到这种鱼"),getGradientName("当然也有可能根本钓不到")));
                items.add(FishManager.getFishItemWithLore(BaseFish.ReDaiFish,"",getGradientName("任何鱼饵都可以钓到它")));
                items.add(FishManager.getFishItemWithLore(BaseFish.CopperDustFish,"",getGradientName("喜好：魔法鱼饵·混合矿粉")));
                items.add(FishManager.getFishItemWithLore(BaseFish.GoldDustFish,"",getGradientName("喜好：魔法鱼饵·混合矿粉")));
                items.add(FishManager.getFishItemWithLore(BaseFish.IronDustFish,"",getGradientName("喜好：魔法鱼饵·混合矿粉")));
                items.add(FishManager.getFishItemWithLore(BaseFish.TinDustFish,"",getGradientName("喜好：魔法鱼饵·混合矿粉")));
                items.add(FishManager.getFishItemWithLore(BaseFish.SilverDustFish,"",getGradientName("喜好：魔法鱼饵·混合矿粉")));
                items.add(FishManager.getFishItemWithLore(BaseFish.AluminumDustFish,"",getGradientName("喜好：魔法鱼饵·混合矿粉")));
                items.add(FishManager.getFishItemWithLore(BaseFish.LeadDustFish,"",getGradientName("喜好：魔法鱼饵·混合矿粉")));
                items.add(FishManager.getFishItemWithLore(BaseFish.ZincDustFish,"",getGradientName("喜好：魔法鱼饵·混合矿粉")));
                items.add(FishManager.getFishItemWithLore(BaseFish.MagnesiumDustFish,"",getGradientName("喜好：魔法鱼饵·混合矿粉")));
                items.add(FishManager.getFishItemWithLore(BaseFish.CoalFish,"",getGradientName("喜好：魔法鱼饵·混合矿物质")));
                items.add(FishManager.getFishItemWithLore(BaseFish.EmeraldFish,"",getGradientName("喜好：魔法鱼饵·混合矿物质")));
                items.add(FishManager.getFishItemWithLore(BaseFish.LapisFish,"",getGradientName("喜好：魔法鱼饵·混合矿物质")));
                items.add(FishManager.getFishItemWithLore(BaseFish.DiamondFish,"",getGradientName("喜好：魔法鱼饵·混合矿物质")));
                items.add(FishManager.getFishItemWithLore(BaseFish.QuartzFish,"",getGradientName("喜好：魔法鱼饵·混合矿物质")));
                items.add(FishManager.getFishItemWithLore(BaseFish.AmethystFish,"",getGradientName("喜好：魔法鱼饵·混合矿物质")));
                items.add(FishManager.getFishItemWithLore(BaseFish.IronFish,"",getGradientName("喜好：魔法鱼饵·混合矿物质")));
                items.add(FishManager.getFishItemWithLore(BaseFish.GoldFish,"",getGradientName("喜好：魔法鱼饵·混合矿物质")));
                items.add(FishManager.getFishItemWithLore(BaseFish.CopperFish,"",getGradientName("喜好：魔法鱼饵·混合矿物质")));
                items.add(FishManager.getFishItemWithLore(BaseFish.RedstoneFish,"",getGradientName("喜好：魔法鱼饵·混合矿物质")));
                items.add(FishManager.getFishItemWithLore(BaseFish.NetheriteFish,"",getGradientName("喜好：魔法鱼饵·混合矿物质")));
                items.add(FishManager.getFishItemWithLore(BaseFish.GlowStoneDustFish,"",getGradientName("喜好：魔法鱼饵·混合矿物质")));
                items.add(FishManager.getFishItemWithLore(BaseFish.ShuLingYu,"",getGradientName("喜好：基础魔法饵料"),getGradientName("喜好：拥有强大魔法的鱼竿")));
                items.add(FishManager.getFishItemWithLore(BaseFish.SulfateFish,"",getGradientName("喜好：基础魔法饵料"),getGradientName("喜好：拥有强大魔法的鱼竿")));
                items.add(FishManager.getFishItemWithLore(BaseFish.SiliconFish,"",getGradientName("喜好：基础魔法饵料"),getGradientName("喜好：拥有强大魔法的鱼竿")));
                items.add(FishManager.getFishItemWithLore(BaseFish.UraniumFish,"",getGradientName("喜好：基础魔法饵料"),getGradientName("喜好：拥有强大魔法的鱼竿")));
                items.add(FishManager.getFishItemWithLore(BaseFish.OilRockFish,"",getGradientName("喜好：基础魔法饵料"),getGradientName("喜好：拥有强大魔法的鱼竿")));
                break;
            case "epic_fish":
                items.add(new CustomItemStack(Material.COD,getGradientName("关于鱼群喜好"),getGradientName("喜好只是这种鱼更喜欢这种鱼饵"),getGradientName("其他鱼饵也有一定概率钓到这种鱼"),getGradientName("当然也有可能根本钓不到")));
                items.add(FishManager.getFishItemWithLore(BaseFish.FoamCrystalFish,"",getGradientName("喜好：基础魔法饵料"),getGradientName("喜好：拥有强大魔法的鱼竿")));
                items.add(FishManager.getFishItemWithLore(BaseFish.BlackDiamondFish,"",getGradientName("喜好：基础魔法饵料"),getGradientName("喜好：拥有强大魔法的鱼竿")));
                items.add(FishManager.getFishItemWithLore(BaseFish.EnchantedBottleFish,"",getGradientName("喜好：基础魔法饵料"),getGradientName("喜好：拥有强大魔法的鱼竿")));
                items.add(FishManager.getFishItemWithLore(BaseFish.MYSTIC_EEL,"",getGradientName("喜好：任意鱼饵"),getGradientName("喜好：拥有强大魔法的鱼竿")));
                break;
            case "legendary_fish":
                items.add(new CustomItemStack(Material.COD,getGradientName("关于鱼群喜好"),getGradientName("喜好只是这种鱼更喜欢这种鱼饵"),getGradientName("其他鱼饵也有一定概率钓到这种鱼"),getGradientName("当然也有可能根本钓不到")));
                items.add(FishManager.getFishItemWithLore(BaseFish.LegendaryLuFish,"",getGradientName("喜好：纠缠之节：终焉之丝·悖论为钩")));
                break;
            case "mythical_fish":
                items.add(new CustomItemStack(Material.COD,getGradientName("关于鱼群喜好"),getGradientName("喜好只是这种鱼更喜欢这种鱼饵"),getGradientName("其他鱼饵也有一定概率钓到这种鱼"),getGradientName("当然也有可能根本钓不到")));
                break;
            case "junk":
                items.add(new CustomItemStack(Material.COD,getGradientName("关于鱼群喜好"),getGradientName("喜好只是这种鱼更喜欢这种鱼饵"),getGradientName("其他鱼饵也有一定概率钓到这种鱼"),getGradientName("当然也有可能根本钓不到")));
                items.add(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD,1),getGradientName("鱼饵·记忆碎片"),
                        getGradientName("这个鱼饵可以钓到任何物品"),getGradientName("他存在于过去或者是未来"),getGradientName("你现在看到的他并非真正的他"),
                        "",getGradientName("喜好: 原木鱼竿"),getGradientName("喜好: 风语者之杆"),getGradientName("喜好: 纠缠之节：终焉之丝·悖论为钩")));
                items.add(new CustomItemStack(new ItemStack(Material.COD),"§b迷路的生鳕鱼",getGradientName("这是谁家的鳕鱼？"),
                        "",getGradientName("喜好: 面包")));
                items.add(new CustomItemStack(new ItemStack(Material.SALMON),"§b晕头转向的生鲑鱼",getGradientName("有没有听过洄鲑阵法？"),
                        "",getGradientName("喜好: 面包")));
                items.add(new CustomItemStack(new ItemStack(Material.TROPICAL_FISH),"§b有1.4的热带鱼",getGradientName("热带鱼是怎么跑到中远河里的？"),
                        "",getGradientName("喜好: 面包")));
                items.add(new CustomItemStack(new ItemStack(Material.PUFFERFISH),"§b发绿的河豚",getGradientName("这东西可不能乱吃哦~"),
                        "",getGradientName("喜好: 面包")));
                items.add(new CustomItemStack(new ItemStack(Material.POTION),"§b神秘的药剂",getGradientName("也许能喝吧？"),
                        "",getGradientName("喜好: 面包")));
                items.add(new CustomItemStack(new ItemStack(Material.HONEY_BOTTLE,15),"§e蜂蜜瓶",getGradientName("这是15个原版蜂蜜瓶"),
                        "",getGradientName("喜好: 面包")));

                items.add(new CustomItemStack(Material.GLOW_BERRIES, "§a萤火草穗", getGradientName("夜间会发出微光，传说能引诱好奇的鱼"),
                        "",getGradientName("喜好: 基础魔法饵料")));
                items.add(new CustomItemStack(Material.MOSS_CARPET, "§a水苔绒", getGradientName("柔软湿润，是小鱼最爱藏身之处"),
                        "",getGradientName("喜好: 基础魔法饵料")));
                items.add(new CustomItemStack(Material.SLIME_BALL, "§a蛙鸣壳", getGradientName("轻轻一捏就会发出‘咕呱’声，鱼儿以为是同类"),
                        "",getGradientName("喜好: 基础魔法饵料")));
                items.add(new CustomItemStack(Material.POPPY, "§a露珠莲瓣", getGradientName("带着晨露的清香，能净化水域的浊气"),
                        "",getGradientName("喜好: 基础魔法饵料")));
                items.add(new CustomItemStack(Material.PRISMARINE_SHARD, "§a鱼鳞尘", getGradientName("在阳光下闪烁微光，是鱼群身份的信号"),
                        "",getGradientName("喜好: 基础魔法饵料")));

                items.add(new CustomItemStack(Material.RED_SAND, "§6磨碎的铜砂", getGradientName("带有微弱金属光泽，是铜脉鱼的气息信标"),
                        "",getGradientName("喜好: 魔法鱼饵·混合矿粉")));
                items.add(new CustomItemStack(Material.RED_DYE, "§6铁锈粉末", getGradientName("从废弃矿械上刮下的锈尘，鱼儿能感知到‘同类’的存在"),
                        "",getGradientName("喜好: 魔法鱼饵·混合矿粉")));
                items.add(new CustomItemStack(Material.GLOW_INK_SAC, "§6金粉残渣", getGradientName("淘金后的尾料，仍残留着‘富矿区’的魔力波动"),
                        "",getGradientName("喜好: 魔法鱼饵·混合矿粉")));
                items.add(new CustomItemStack(Material.QUARTZ, "§6石英碎屑", getGradientName("来自下界矿脉的晶体碎片，能稳定矿粉的能量场"),
                        "",getGradientName("喜好: 魔法鱼饵·混合矿粉")));
                items.add(new CustomItemStack(Material.COAL, "§6碳晶颗粒", getGradientName("深埋地壳的古老植物遗骸，为矿粉提供能量基底"),
                        "",getGradientName("喜好: 魔法鱼饵·混合矿粉")));
                items.add(new CustomItemStack(Material.NETHER_STAR, "§d星辰铁微尘", getGradientName("极其稀有，传说来自陨星核心，能大幅提升引诱力"),
                        "",getGradientName("喜好: 魔法鱼饵·混合矿粉")));

                items.add(new CustomItemStack(Material.COPPER_INGOT, "§b原生铜脉碎片", getGradientName("并非冶炼所得，而是从岩层中直接剥离的天然导电矿络"),
                        "",getGradientName("喜好: 魔法鱼饵·混合矿物质")));
                items.add(new CustomItemStack(Material.IRON_INGOT, "§b赤铁矿核", getGradientName("保留了完整晶体结构的高纯度铁核，能散发‘金属心跳’般的信号"),
                        "",getGradientName("喜好: 魔法鱼饵·混合矿物质")));
                items.add(new CustomItemStack(Material.GOLD_INGOT, "§b金脉结晶", getGradientName("在高压下自然形成的网状金晶，是‘富矿区’的活体信标"),
                        "",getGradientName("喜好: 魔法鱼饵·混合矿物质")));
                items.add(new CustomItemStack(Material.AMETHYST_SHARD, "§b深岩晶核", getGradientName("来自地壳深处的共振晶体，能放大矿石信号的传播范围"),
                        "",getGradientName("喜好: 魔法鱼饵·混合矿物质")));
                items.add(new CustomItemStack(Material.COAL_BLOCK, "§b熔岩碳心", getGradientName("在岩浆旁碳化千年的木心，蕴含地热能量，稳定矿核活性"),
                        "",getGradientName("喜好: 魔法鱼饵·混合矿物质")));
                items.add(new CustomItemStack(Material.NETHER_STAR, "§5星核残片", getGradientName("传说来自坠落恒星的核心碎片，能模拟‘地核级’矿脉信号"),
                        "",getGradientName("喜好: 魔法鱼饵·混合矿物质")));

                items.add(new CustomItemStack(new ItemStack(Material.SUGAR_CANE,2),"§b腐烂的甘蔗",getGradientName("河里怎么会有甘蔗呢？"),
                        "",getGradientName("喜好: 姜太公钓鱼")));
                items.add(new CustomItemStack(new ItemStack(Material.STICK,2),"§b锟斤拷",getGradientName("这是什么东西呢？"),
                        "",getGradientName("喜好: 姜太公钓鱼")));
                items.add(new CustomItemStack(new ItemStack(Material.INK_SAC,2),"§b新鲜的墨囊",getGradientName("谁家好人把墨囊丢在河里啊？"),
                        "",getGradientName("喜好: 姜太公钓鱼")));
                items.add(new CustomItemStack(new ItemStack(Material.CAKE,2),"§b隔夜的蛋糕",getGradientName("蛋糕吃不完了？"),
                        "",getGradientName("喜好: 姜太公钓鱼")));
                items.add(new CustomItemStack(new ItemStack(Material.REDSTONE,8),"§b8-bit 红石",getGradientName("一把刚好8个？"),
                        "",getGradientName("喜好: 姜太公钓鱼")));
                items.add(new CustomItemStack(new ItemStack(Material.DISPENSER,2),"§b粘液科技要用到的发射器",getGradientName("放地上就好了？"),
                        "",getGradientName("喜好: 姜太公钓鱼")));

                break;
            case "magic_sugar":
                items.add(new CustomItemStack(Material.SUGAR,("§6魔法糖")," ",("§a§o感受赫尔墨斯的力量！")));
                items.add(MagicExpansionItems.MAGIC_EXPANSION_MAGIC_SUGAR_1);
                items.add(SlimefunItems.MAGIC_LUMP_1);
                items.add(SlimefunItems.MAGIC_LUMP_2);
                items.add(SlimefunItems.MAGIC_LUMP_3);
                items.add(SlimefunItems.ENDER_LUMP_1);
                items.add(SlimefunItems.ENDER_LUMP_2);
                items.add(SlimefunItems.ENDER_LUMP_3);
                items.add(SlimefunItems.MAGICAL_GLASS);
                items.add(SlimefunItems.MAGICAL_BOOK_COVER);
                items.add(SlimefunItems.LAVA_CRYSTAL);
                items.add(SlimefunItems.COMMON_TALISMAN);
                items.add(SlimefunItems.NECROTIC_SKULL);
                items.add(SlimefunItems.ESSENCE_OF_AFTERLIFE);
                items.add(SlimefunItems.SYNTHETIC_SHULKER_SHELL);
                items.add(SlimefunItems.BLANK_RUNE);
                items.add(SlimefunItems.AIR_RUNE);
                items.add(SlimefunItems.EARTH_RUNE);
                items.add(SlimefunItems.FIRE_RUNE);
                items.add(SlimefunItems.WATER_RUNE);
                items.add(SlimefunItems.ENDER_RUNE);
                items.add(SlimefunItems.LIGHTNING_RUNE);
                items.add(SlimefunItems.RAINBOW_RUNE);
                items.add(SlimefunItems.SOULBOUND_RUNE);
                items.add(SlimefunItems.ENCHANTMENT_RUNE);
                items.add(SlimefunItems.VILLAGER_RUNE);
                items.add(SlimefunItems.STRANGE_NETHER_GOO);
                items.add(SlimefunItems.RAINBOW_LEATHER);
                items.add(MagicExpansionItems.RANDOM_FISH_COMMON);
                items.add(MagicExpansionItems.RANDOM_FISH_UNCOMMON);
                items.add(MagicExpansionItems.RANDOM_FISH_RARE_POOL_DUST);
                items.add(MagicExpansionItems.RANDOM_FISH_RARE_POOL_ORE);
                items.add(MagicExpansionItems.RANDOM_FISH_RARE_POOL_INDUSTRY);
                items.add(MagicExpansionItems.RANDOM_FISH_EPIC_POOL_INDUSTRY);
                items.add(MagicExpansionItems.RANDOM_FISH_EPIC);
                items.add(new CustomItemStack(
                        new ItemStack(Material.PRISMARINE_SHARD, 1),
                        getGradientName("鱼饵·记忆碎片"),
                        getGradientName("这个鱼饵可以钓到任何物品"),
                        getGradientName("他存在于过去或者是未来"),
                        getGradientName("你现在看到的他并非真正的他")
                ));
                break;
            case "bread":
                items.add(new CustomItemStack(Material.BREAD,("§b面包")," ",getGradientName("这只是一块普普通通的面包")));
                items.add(new CustomItemStack(new ItemStack(Material.COD, 3), "§b迷路的生鳕鱼", getGradientName("这是谁家的鳕鱼？")));
                items.add(new CustomItemStack(new ItemStack(Material.SALMON, 3), "§b晕头转向的生鲑鱼", getGradientName("有没有听过洄鲑阵法？")));
                items.add(new CustomItemStack(new ItemStack(Material.TROPICAL_FISH, 3), "§b有1.4的热带鱼", getGradientName("热带鱼是怎么跑到中远河里的？")));
                items.add(new CustomItemStack(new ItemStack(Material.PUFFERFISH, 3), "§b发绿的河豚", getGradientName("这东西可不能乱吃哦~")));
                items.add(new CustomItemStack(new ItemStack(Material.POTION, 3), "§b神秘的药剂", getGradientName("也许能喝吧？")));
                items.add(new ItemStack(Material.HONEY_BOTTLE, 256));
                items.add(MagicExpansionItems.RANDOM_FISH_COMMON);
                items.add(MagicExpansionItems.RANDOM_FISH_UNCOMMON);
                items.add(MagicExpansionItems.RANDOM_FISH_EPIC);
                items.add(MagicExpansionItems.RANDOM_FISH_EPIC_POOL_INDUSTRY);
                items.add(MagicExpansionItems.RANDOM_FISH_RARE_POOL_DUST);
                items.add(MagicExpansionItems.RANDOM_FISH_RARE_POOL_ORE);
                items.add(MagicExpansionItems.RANDOM_FISH_RARE_POOL_INDUSTRY);
                items.add(new CustomItemStack(
                        new ItemStack(Material.PRISMARINE_SHARD, 1),
                        getGradientName("鱼饵·记忆碎片"),
                        getGradientName("这个鱼饵可以钓到任何物品"),
                        getGradientName("他存在于过去或者是未来"),
                        getGradientName("你现在看到的他并非真正的他")
                ));
                break;
            default:
                items.add(new ItemStack(Material.BARRIER));
                break;
        }

        return items;
    }
}