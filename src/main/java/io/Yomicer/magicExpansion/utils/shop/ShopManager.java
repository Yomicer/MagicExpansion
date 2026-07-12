package io.Yomicer.magicExpansion.utils.shop;

import io.Yomicer.magicExpansion.MagicExpansion;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ShopManager {

    private static final File dir = new File(MagicExpansion.getInstance().getDataFolder(), "portable_shops");

    public static class Trade {
        public ItemStack result;
        public List<ItemStack> costItems = new ArrayList<>();
        public int globalLimit = 0;   // 0 表示无限制
        public int personalLimit = 0; // 0 表示无限制
        public int globalUsed = 0;
        public Map<UUID, Integer> personalUsed = new HashMap<>();
    }

    public static class Shop {
        public String name;
        public List<Trade> trades = new ArrayList<>();
    }

    private static final List<Shop> shops = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public static void load() {
        if (!dir.exists()) {
            dir.mkdirs();
        }
        shops.clear();

        File[] files = dir.listFiles((d, name) -> name.endsWith(".yml"));
        if (files == null) return;

        for (File file : files) {
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            String shopName = file.getName().replace(".yml", "");
            Shop shop = new Shop();
            shop.name = shopName;

            List<Map<?, ?>> tradeList = config.getMapList("trades");
            for (Map<?, ?> tradeMap : tradeList) {
                Trade trade = new Trade();

                Object resultObj = tradeMap.get("result");
                if (resultObj instanceof ItemStack) trade.result = (ItemStack) resultObj;

                Object costObj = tradeMap.get("cost");
                if (costObj instanceof List) trade.costItems = (List<ItemStack>) costObj;

                trade.globalLimit = getInt(tradeMap.get("globalLimit"), 0);
                trade.personalLimit = getInt(tradeMap.get("personalLimit"), 0);
                trade.globalUsed = getInt(tradeMap.get("globalUsed"), 0);

                Object puObj = tradeMap.get("personalUsed");
                if (puObj instanceof Map) {
                    Map<String, Object> pu = (Map<String, Object>) puObj;
                    for (Map.Entry<String, Object> entry : pu.entrySet()) {
                        try {
                            trade.personalUsed.put(UUID.fromString(entry.getKey()), getInt(entry.getValue(), 0));
                        } catch (Exception ignored) {}
                    }
                }
                shop.trades.add(trade);
            }
            shops.add(shop);
        }
    }

    private static int getInt(Object obj, int def) {
        if (obj instanceof Number) return ((Number) obj).intValue();
        return def;
    }

    private static File getShopFile(String shopName) {
        String safeName = shopName.replaceAll("[\\\\/:*?\"<>|]", "_");
        return new File(dir, safeName + ".yml");
    }

    public static void saveShop(Shop shop) {
        File file = getShopFile(shop.name);
        FileConfiguration config = new YamlConfiguration();

        List<Map<String, Object>> tradeList = new ArrayList<>();
        for (Trade trade : shop.trades) {
            Map<String, Object> tradeMap = new HashMap<>();
            tradeMap.put("result", trade.result);
            tradeMap.put("cost", trade.costItems);
            tradeMap.put("globalLimit", trade.globalLimit);
            tradeMap.put("personalLimit", trade.personalLimit);
            tradeMap.put("globalUsed", trade.globalUsed);

            Map<String, Integer> pu = new HashMap<>();
            for (Map.Entry<UUID, Integer> entry : trade.personalUsed.entrySet()) {
                pu.put(entry.getKey().toString(), entry.getValue());
            }
            tradeMap.put("personalUsed", pu);
            tradeList.add(tradeMap);
        }
        config.set("trades", tradeList);

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reload() {
        for (Shop shop : shops) {
            saveShop(shop);
        }
        load();
    }

    public static List<Shop> getShops() {
        return shops;
    }

    public static Shop getShop(String name) {
        for (Shop s : shops) {
            if (s.name.equals(name)) return s;
        }
        return null;
    }

    public static void createShop(String name) {
        if (getShop(name) == null) {
            Shop shop = new Shop();
            shop.name = name;
            shops.add(shop);
            saveShop(shop);
        }
    }

    public static void deleteShop(String name) {
        shops.removeIf(s -> s.name.equals(name));
        File file = getShopFile(name);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean canPurchase(UUID playerId, Trade trade) {
        if (trade.globalLimit > 0 && trade.globalUsed >= trade.globalLimit) return false;
        if (trade.personalLimit > 0) {
            int used = trade.personalUsed.getOrDefault(playerId, 0);
            if (used >= trade.personalLimit) return false;
        }
        return true;
    }

    public static void recordPurchase(UUID playerId, Shop shop, Trade trade) {
        if (trade.globalLimit > 0) {
            trade.globalUsed++;
        }
        if (trade.personalLimit > 0) {
            trade.personalUsed.put(playerId, trade.personalUsed.getOrDefault(playerId, 0) + 1);
        }
        saveShop(shop);
    }

    public static void resetUsage(Shop shop, Trade trade) {
        trade.globalUsed = 0;
        trade.personalUsed.clear();
        saveShop(shop);
    }
    public static void saveAll() {
        for (Shop shop : shops) {
            saveShop(shop);
        }
    }
}
