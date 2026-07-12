package io.Yomicer.magicExpansion.utils.shop;

import io.Yomicer.magicExpansion.MagicExpansion;
import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.*;

import static io.Yomicer.magicExpansion.core.MagicExpansionItems.*;

public class BlackMarketManager {

    private static List<BlackMarketTrade> todayTrades = new ArrayList<>();
    private static long lastRefreshTime = 0;
    private static final long REFRESH_INTERVAL = 4 * 60 * 60 * 1000L; // 4小时(毫秒)

    // 简单奖励池 (80%概率)
    private static List<ItemStack> simpleRewardPool = new ArrayList<>();

    // 困难奖励池及权重 (20%概率)
    private static Map<ItemStack, Integer> hardRewardPool = new LinkedHashMap<>();

    // 消耗物池
    private static List<ItemStack> costItemPool = new ArrayList<>();

    private static Map<UUID, Set<Integer>> dailyPurchases = new HashMap<>();
    private static Map<UUID, Set<Integer>> revealedSlots = new HashMap<>();

    public static class BlackMarketTrade {
        public ItemStack result;
        public List<ItemStack> costs;
        public boolean isFree;
        public boolean isHard;
    }

    public static void init() {
        simpleRewardPool.clear();
        hardRewardPool.clear();
        costItemPool.clear();

        MagicExpansion.getInstance().getLogger().info("正在初始化黑市物品池...");

        simpleRewardPool.add(new ItemStack(Material.IRON_BLOCK));
        simpleRewardPool.add(new ItemStack(Material.GOLD_BLOCK));
        simpleRewardPool.add(new ItemStack(Material.COPPER_BLOCK));
        simpleRewardPool.add(new ItemStack(Material.EMERALD_BLOCK));
        simpleRewardPool.add(new ItemStack(Material.DIAMOND_BLOCK));
        simpleRewardPool.add(new ItemStack(Material.NETHERITE_BLOCK));

        hardRewardPool.put(new ItemStack(Material.DRAGON_EGG), 5);

        costItemPool.add(new ItemStack(Material.IRON_INGOT));
        costItemPool.add(new ItemStack(Material.GOLD_INGOT));
        costItemPool.add(new ItemStack(Material.EMERALD));
        costItemPool.add(new ItemStack(Material.DIAMOND));
        costItemPool.add(new ItemStack(Material.DIRT));
        costItemPool.add(new ItemStack(Material.ROTTEN_FLESH));
        costItemPool.add(new ItemStack(Material.TORCH));
        costItemPool.add(new ItemStack(Material.NETHER_STAR));
        costItemPool.add(new ItemStack(Material.WITHER_SKELETON_SKULL));
        costItemPool.add(MAGIC_EXPANSION_MAGIC_SUGAR_1);
        costItemPool.add(MAGIC_EXPANSION_MAGIC_SUGAR_2);
        costItemPool.add(MAGIC_EXPANSION_MAGIC_SUGAR_3);
        costItemPool.add(MAGIC_EXPANSION_FINAL_STRING_1);
        costItemPool.add(GOLD_ELEMENT);
        costItemPool.add(WOOD_ELEMENT);
        costItemPool.add(WATER_ELEMENT);
        costItemPool.add(FIRE_ELEMENT);
        costItemPool.add(EARTH_ELEMENT);
        costItemPool.add(PURE_ELEMENT_GOLD);
        costItemPool.add(PURE_ELEMENT_WOOD);
        costItemPool.add(PURE_ELEMENT_WATER);
        costItemPool.add(PURE_ELEMENT_FIRE);
        costItemPool.add(PURE_ELEMENT_EARTH);
        costItemPool.add(PURE_ELEMENT_INGOT);
        costItemPool.add(PURE_FIVE_ELEMENT);

        try {

            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_1, 500);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_2, 500);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_3, 500);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_4, 400);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_5, 400);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_11, 180);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_12, 180);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_13, 180);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_14, 180);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_15, 180);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_16, 130);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_17, 130);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_18, 130);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_25, 8);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_26, 8);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_27, 8);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_28, 8);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_29, 8);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_30, 8);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_31, 8);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_35, 8);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_36, 8);
            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_37, 8);


            hardRewardPool.put(MAGIC_EXPANSION_MAGIC_SUGAR_CANE, 3);

            hardRewardPool.put(MAGIC_EXPANSION_FINAL_STRING_1, 4);
            hardRewardPool.put(MAGIC_EXPANSION_FINAL_STRING_2, 4);
            hardRewardPool.put(MAGIC_EXPANSION_FINAL_STRING_3, 4);
            hardRewardPool.put(MAGIC_EXPANSION_FINAL_STRING_4, 4);
            hardRewardPool.put(MAGIC_EXPANSION_FINAL_STRING_5, 4);
            hardRewardPool.put(MAGIC_EXPANSION_FINAL_STRING_6, 4);
            hardRewardPool.put(MAGIC_EXPANSION_FINAL_STRING_11, 3);
            hardRewardPool.put(MAGIC_EXPANSION_FINAL_STRING_12, 3);
            hardRewardPool.put(MAGIC_EXPANSION_FINAL_STRING_13, 1);
            hardRewardPool.put(MAGIC_EXPANSION_FINAL_STRING_14, 1);
            hardRewardPool.put(MAGIC_EXPANSION_FINAL_STRING_15, 1);



            hardRewardPool.put(INFINITY_FLINT_AND_STEEL, 90);
            hardRewardPool.put(MAGIC_EXPANSION_RANDOM_SPAWNER, 90);
            hardRewardPool.put(VOID_TOUCH, 90);
            hardRewardPool.put(FIVE_ELEMENT_TOUCH, 90);
            hardRewardPool.put(MAGIC_EXPANSION_ENCHANTING_TABLE, 90);
            hardRewardPool.put(DEATH_LIFE_BOOK, 90);
            hardRewardPool.put(ITEM_NAME_TAG, 90);
            hardRewardPool.put(ENCHANTMENT_ERASER, 90);
            hardRewardPool.put(FISH_WEIGHT_ENHANCER, 90);
            hardRewardPool.put(RESEARCH_UNLOCKER_PAPER, 90);
            hardRewardPool.put(WORD_CLEAR, 90);
            hardRewardPool.put(PORTABLE_SHOP, 90);
            hardRewardPool.put(DOUBLE_SIDED_TAPE, 90);
            hardRewardPool.put(PORTABLE_CARGO_TRANSPORTER, 90);
            hardRewardPool.put(CUSTOM_SEQUENCE_TOOL, 90);
            hardRewardPool.put(CARGO_FRAGMENT_EXTRACT, 90);
            hardRewardPool.put(MUSIC_TEST, 90);
            hardRewardPool.put(MAGIC_WAND, 90);
            hardRewardPool.put(RESOURCE_MACHINE_WOOD_BASIC, 90);
            hardRewardPool.put(RESOURCE_MACHINE_WOOD_ULTRA, 90);
            hardRewardPool.put(LIGHT_GEN_BASIC, 90);
            hardRewardPool.put(STRING_GEN_BASIC, 90);
            hardRewardPool.put(STRING_GEN_ULTRA, 90);
            hardRewardPool.put(FIVE_ELEMENT_GEN_BASIC, 30);
            hardRewardPool.put(SLIME_BOOK_GEN_ADVANCE, 20);
            hardRewardPool.put(ORIGIN_MATERIAL_GEN, 10);
            hardRewardPool.put(FISH_VIVARIUM_EASY, 90);
            hardRewardPool.put(FISH_VIVARIUM, 90);
            hardRewardPool.put(FISH_VIVARIUM_STACK, 90);
            hardRewardPool.put(WOOD_TRANSFORM_BASIC, 90);
            hardRewardPool.put(WOOD_TRANSFORM_ULTRA, 90);
            hardRewardPool.put(LIGHT_TRANSFORM_BASIC, 90);
            hardRewardPool.put(LIGHT_EXTRACT_BASIC, 90);
            hardRewardPool.put(QUARTZ_PURE_MACHINE_BAISC, 90);
            hardRewardPool.put(QUARTZ_PURE_MACHINE_ULTRA, 90);
            hardRewardPool.put(INTEGRATION_ORIGIN_SLIME_MINERAL_POWDER_LINE, 90);
            hardRewardPool.put(INTEGRATION_ORIGIN_SLIME_MINERAL_POWDER_LINE_DEFAULT, 90);
            hardRewardPool.put(INTEGRATION_ORIGIN_SLIME_MINERAL_POWDER_LINE_ULTRA, 90);
            hardRewardPool.put(DIRT_MEAL_MACHINE, 90);
            hardRewardPool.put(FISHING_MACHINE, 90);
            hardRewardPool.put(INGOT_PURE_MACHINE, 90);
            hardRewardPool.put(CHINESE_CHARACTER_CONSTRUCTOR, 90);
            hardRewardPool.put(SEND_ITEMS_TO_PLAYER_MACHINE, 90);
            hardRewardPool.put(SEND_ITEMS_TO_PLAYER_MACHINE_SF, 90);
            hardRewardPool.put(WHITE_SLOTS_CHEST_53, 90);
            hardRewardPool.put(PHANTON_SUPPRESSION, 90);
            hardRewardPool.put(RIGHT_CLICK_MAN, 90);
            hardRewardPool.put(SF_TIMINGS_HOLOGRAM, 90);
            hardRewardPool.put(MIHOYO_STAR_RAY_MACHINE, 90);
            hardRewardPool.put(CARGO_TERMINAL_RENEW, 90);
            hardRewardPool.put(DRAW_MACHINE, 90);
            hardRewardPool.put(GEO_MINER_PLUS, 90);
            hardRewardPool.put(FIVE_ELEMENT_MINER, 90);
            hardRewardPool.put(ITEM_ORIGIN_BACK_TRACK, 1);
            hardRewardPool.put(ENERGY_CONNECTOR_GLASS_INFO, 90);
            hardRewardPool.put(POWER_CORE, 90);
            hardRewardPool.put(PURE_INGOT_POWER_CORE, 90);
            hardRewardPool.put(BAD_LUCK_CAPACITY, 90);
            hardRewardPool.put(PANDORA_CAPACITY, 90);
            hardRewardPool.put(POWER_FIRE_STABILITY, 90);
            hardRewardPool.put(POWER_COLOR_EGG_BLOCK, 90);
            hardRewardPool.put(POWER_COLOR_EGG_KEY, 90);
            hardRewardPool.put(POWER_FISH_ELECTRIC, 90);
            hardRewardPool.put(MINE_MAN_NETHERITE_INGOT_BASIC, 90);
            hardRewardPool.put(MINE_MAN_MINERAL_BASIC, 90);
            hardRewardPool.put(MINE_MAN_MINERAL_ULTRA, 90);
            hardRewardPool.put(MINE_MAN_MAGNESIUM_INGOT_BASIC, 90);
            hardRewardPool.put(MINE_MAN_ZINC_INGOT_BASIC, 90);
            hardRewardPool.put(MINE_MAN_ALUMINUM_INGOT_BASIC, 90);
            hardRewardPool.put(MINE_MAN_LEAD_INGOT_BASIC, 90);
            hardRewardPool.put(MINE_MAN_SILVER_INGOT_BASIC, 90);
            hardRewardPool.put(MINE_MAN_TIN_INGOT_BASIC, 90);
            hardRewardPool.put(MINE_MAN_COPPER_INGOT_BASIC, 90);
            hardRewardPool.put(MINE_MAN_GOLD_INGOT_BASIC, 90);
            hardRewardPool.put(MINE_MAN_IRON_INGOT_BASIC, 90);
            hardRewardPool.put(FIRE_ZOMBIE, 90);
            hardRewardPool.put(WIND_ELF_SPAWN, 90);
//            hardRewardPool.put(WEAPON_STAR_SHARDS_SWORD, 1);
            hardRewardPool.put(PRE_BUILDING_OAK_TREE, 90);
            hardRewardPool.put(PRE_BUILDING_MANGROVE_TREE, 90);
            hardRewardPool.put(PRE_BUILDING_FISHING_PORT, 90);
            hardRewardPool.put(PRE_BUILDING_KFC_SMALL, 90);
            hardRewardPool.put(PRE_BUILDING_LARGE_SNOW_KING, 90);
            hardRewardPool.put(PRE_BUILDING_KRUSTY_KRAB, 90);





        } catch (Throwable e) {
            MagicExpansion.getInstance().getLogger().warning("黑市物品池加载自定义物品时发生严重错误，仅加载原版兜底物品: ");
            e.printStackTrace();
        }

        // 再次兜底
        if (simpleRewardPool.isEmpty()) simpleRewardPool.add(new ItemStack(Material.DIRT));
        if (hardRewardPool.isEmpty()) hardRewardPool.put(new ItemStack(Material.BEDROCK), 1);
        if (costItemPool.isEmpty()) costItemPool.add(new ItemStack(Material.STONE));

        MagicExpansion.getInstance().getLogger().info("黑市物品池初始化完成。简单物品: " + simpleRewardPool.size() + " 困难物品: " + hardRewardPool.size());

        if (lastRefreshTime == 0) {
            lastRefreshTime = System.currentTimeMillis();
            generateDailyTrades();
        } else {
            checkAndRefresh();
        }
    }







    public static void checkAndRefresh() {
        if (System.currentTimeMillis() - lastRefreshTime >= REFRESH_INTERVAL) {
            forceRefresh();
        }
    }

    public static void forceRefresh() {
        generateDailyTrades();
        lastRefreshTime = System.currentTimeMillis();
        dailyPurchases.clear();
        revealedSlots.clear();
    }

    public static String getTimeRemaining() {
        long elapsed = System.currentTimeMillis() - lastRefreshTime;
        long remaining = REFRESH_INTERVAL - elapsed;
        if (remaining < 0) remaining = 0;

        long hours = remaining / (60 * 60 * 1000);
        long minutes = (remaining % (60 * 60 * 1000)) / (60 * 1000);
        long seconds = (remaining % (60 * 1000)) / 1000;

        return hours + "小时" + minutes + "分" + seconds + "秒";
    }

    private static void generateDailyTrades() {
        // 每次生成前检查，确保池子绝对不为空
        if (simpleRewardPool.isEmpty()) simpleRewardPool.add(new ItemStack(Material.DIRT));
        if (hardRewardPool.isEmpty()) hardRewardPool.put(new ItemStack(Material.BEDROCK), 1);
        if (costItemPool.isEmpty()) costItemPool.add(new ItemStack(Material.STONE));

        todayTrades.clear();
        Random random = new Random();

        // 过滤掉可能混入的 null 物品
        List<ItemStack> hardItems = new ArrayList<>();
        List<Integer> weights = new ArrayList<>();
        for (Map.Entry<ItemStack, Integer> entry : hardRewardPool.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                hardItems.add(entry.getKey());
                weights.add(entry.getValue());
            }
        }

        int totalWeight = weights.stream().mapToInt(Integer::intValue).sum();
        if (totalWeight <= 0) totalWeight = 1;

        for (int i = 0; i < 10; i++) {
            BlackMarketTrade trade = new BlackMarketTrade();
            trade.isHard = random.nextDouble() < 0.30;

            if (trade.isHard) {
                if (hardItems.isEmpty()) {
                    trade.isHard = false;
                } else {
                    int randomWeight = random.nextInt(totalWeight);
                    int currentWeight = 0;
                    for (int j = 0; j < hardItems.size(); j++) {
                        currentWeight += weights.get(j);
                        if (randomWeight < currentWeight) {
                            trade.result = hardItems.get(j).clone();
                            break;
                        }
                    }
                    if (trade.result == null) {
                        trade.result = hardItems.get(0).clone();
                    }
                    trade.result.setAmount(random.nextInt(2) + 1);
                }
            }

            if (!trade.isHard) {
                if (simpleRewardPool.isEmpty()) {
                    trade.result = new ItemStack(Material.AIR);
                } else {
                    trade.result = simpleRewardPool.get(random.nextInt(simpleRewardPool.size())).clone();
                    trade.result.setAmount(random.nextInt(16) + 4);
                }
            }

            if (trade.isHard) {
                trade.isFree = random.nextDouble() < 0.10;
            } else {
                trade.isFree = random.nextDouble() < 0.70;
            }

            if (!trade.isFree) {
                trade.costs = new ArrayList<>();
                if (!costItemPool.isEmpty()) {
                    int costTypeCount = random.nextInt(2) + 1;
                    for (int c = 0; c < costTypeCount; c++) {
                        ItemStack costItem = costItemPool.get(random.nextInt(costItemPool.size())).clone();
                        if (costItem != null) {
                            // 简单物品 1~5，困难物品 3~17
                            if (trade.isHard) {
                                costItem.setAmount(random.nextInt(15) + 3); // 0~14 + 3 = 3~17
                            } else {
                                costItem.setAmount(random.nextInt(5) + 1); // 0~4 + 1 = 1~5
                            }
                            trade.costs.add(costItem);
                        }
                    }
                }
                if (trade.costs.isEmpty()) {
                    trade.isFree = true;
                }
            }


            todayTrades.add(trade);
        }
    }



    public static List<BlackMarketTrade> getTodayTrades() {
        checkAndRefresh();
        return todayTrades;
    }

    public static boolean hasPurchased(UUID uuid, int index) {
        return dailyPurchases.containsKey(uuid) && dailyPurchases.get(uuid).contains(index);
    }

    public static void recordPurchase(UUID uuid, int index) {
        dailyPurchases.computeIfAbsent(uuid, k -> new HashSet<>()).add(index);
    }

    public static boolean isRevealed(UUID uuid, int index) {
        return revealedSlots.containsKey(uuid) && revealedSlots.get(uuid).contains(index);
    }

    public static void reveal(UUID uuid, int index) {
        revealedSlots.computeIfAbsent(uuid, k -> new HashSet<>()).add(index);
    }
}
