package io.Yomicer.magicExpansion.items.misc.fish;

import io.Yomicer.magicExpansion.MagicExpansion;
import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.Yomicer.magicExpansion.utils.ColorGradient;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class FishKeys {

    public static final NamespacedKey FISH_TYPE = new NamespacedKey(JavaPlugin.getPlugin(MagicExpansion.class), "fish_type");
    public static final NamespacedKey FISH_WEIGHT = new NamespacedKey(JavaPlugin.getPlugin(MagicExpansion.class), "fish_weight");
    // 可选：存储重量稀有度（字符串）
    public static final NamespacedKey FISH_WEIGHT_RARITY = new NamespacedKey(JavaPlugin.getPlugin(MagicExpansion.class), "fish_weight_rarity");

    // 映射：Slimefun 物品 → 对应的 Fish 池（按基础稀有度）
    private static final Map<SlimefunItemStack, List<Fish>> LOOT_TABLE = new HashMap<>();

    static {
        // COMMON 鱼池
        LOOT_TABLE.put(MagicExpansionItems.RANDOM_FISH_COMMON, Arrays.asList(
                Fish.SanWenFish,
                Fish.XueFish
        ));

//        // RARE 鱼池
//        LOOT_TABLE.put(MagicExpansionItems.RANDOM_FISH_RARE, Arrays.asList(
//                Fish.PUFFERFISH,
//                Fish.TROPICAL_FISH
//        ));
//
//        // EPIC 鱼池
//        LOOT_TABLE.put(MagicExpansionItems.RANDOM_FISH_EPIC, Arrays.asList(
//                Fish.MYSTIC_EEL,
//                Fish.LEGENDARY_BASS
//        ));
    }


    public static ItemStack enchantDropWithFishData(Player player, ItemStack drop) {
        Fish.Rarity targetRarity = null;

        // 判断是哪种随机鱼
        if (SlimefunUtils.isItemSimilar(drop, MagicExpansionItems.RANDOM_FISH_COMMON, true)) {
            targetRarity = Fish.Rarity.COMMON;
        }
        else if (SlimefunUtils.isItemSimilar(drop, MagicExpansionItems.RANDOM_FISH_UNCOMMON, true)) {
            targetRarity = Fish.Rarity.UNCOMMON;
        }
        else if (SlimefunUtils.isItemSimilar(drop, MagicExpansionItems.RANDOM_FISH_RARE, true)) {
            targetRarity = Fish.Rarity.RARE;
        }
        else if (SlimefunUtils.isItemSimilar(drop, MagicExpansionItems.RANDOM_FISH_EPIC, true)) {
            targetRarity = Fish.Rarity.EPIC;
        }
        else if (SlimefunUtils.isItemSimilar(drop, MagicExpansionItems.RANDOM_FISH_LEGENDARY, true)) {
            targetRarity = Fish.Rarity.LEGENDARY;
        }

        // 如果不是目标物品，原样返回
        if (targetRarity == null) {
            return drop;
        }

        List<Fish> candidates = getPossibleFishesForRarity(targetRarity); // 确保类名正确
        if (candidates.isEmpty()) {
            // 兜底：返回 COD
            candidates = Collections.singletonList(Fish.XueFish);
        }

        Random random = new Random();
        Fish chosenFish = candidates.get(random.nextInt(candidates.size()));

        double weight = chosenFish.rollWeight();

        ItemMeta meta = drop.getItemMeta();
        if (meta == null) {
            return drop; // 安全返回
        }
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        // --- 设置新的 PDC 数据 ---
        pdc.set(FishKeys.FISH_TYPE, PersistentDataType.STRING, chosenFish.name());
        pdc.set(FishKeys.FISH_WEIGHT, PersistentDataType.DOUBLE, weight);
        Fish.WeightRarity weightRarity = chosenFish.getWeightRarity(weight);
        pdc.set(FishKeys.FISH_WEIGHT_RARITY, PersistentDataType.STRING, weightRarity.name());
        String weightRareThis = "";
        if (weightRarity == Fish.WeightRarity.RARE_FISH) {
            Bukkit.broadcastMessage("§a恭喜玩家 §e"+player.getName()+" §a在 §d"+ player.getWorld().getName() + " §a中垂钓意外捕获了一条§e稀有鱼！");
            Bukkit.broadcastMessage("§a恭喜玩家 §e"+player.getName()+
                    " §a在坐标 §dX: "+ String.format("%.2f",player.getLocation().getX())+
                    " Y: " + String.format("%.2f",player.getLocation().getY())+
                    " Z: " + String.format("%.2f",player.getLocation().getZ()) +
                    " §a附近捕获了 §e稀有鱼 "+chosenFish.getDisplayName());
            weightRareThis = "§e§l⭐";
        }
        if (weightRarity == Fish.WeightRarity.SUPER_RARE_FISH) {
            Bukkit.broadcastMessage("§a恭喜玩家 §e"+player.getName()+" §a在 §d"+ player.getWorld().getName() + " §a中垂钓意外捕获了一条§b超级稀有鱼！");
            Bukkit.broadcastMessage("§a恭喜玩家 §e"+player.getName()+
                    " §a在坐标 §dX: "+ String.format("%.2f",player.getLocation().getX())+
                    " Y: " + String.format("%.2f",player.getLocation().getY())+
                    " Z: " + String.format("%.2f",player.getLocation().getZ()) + " §a附近捕获了 §b超级稀有鱼 "+chosenFish.getDisplayName());
            weightRareThis = "§b§l\uD83D\uDC8E";
        }

        // --- 修改显示名 ---
        meta.setDisplayName(chosenFish.getDisplayName());

        // --- 修改 Lore ---
        List<String> lore = new ArrayList<>();
        lore.add(""); // 空行分隔
        lore.add(ColorGradient.getGradientName("鱼种稀有度: ")+ "§r§f" + chosenFish.getRarity().getDisplayName());
        lore.add(ColorGradient.getGradientName("重量: ")+ "§r§f" + String.format("%.3f", weight) + " kg");
        lore.add(ColorGradient.getGradientName("稀有度: ")+ "§r" + weightRarity.getDisplayName() + weightRareThis);
        if (chosenFish.getLoreLines() != null && chosenFish.getLoreLines().length > 0) {
            lore.add(""); // 空行分隔
            lore.addAll(Arrays.asList(chosenFish.getLoreLines()));
        }

        meta.setLore(lore);

        drop.setItemMeta(meta);

        return drop;
    }

    public static List<Fish> getPossibleFishesForRarity(Fish.Rarity rarity) {
        switch (rarity) {
            case COMMON:
                return Arrays.asList(Fish.SanWenFish, Fish.XueFish);
            case UNCOMMON:
                return Arrays.asList(Fish.HeTun);
            case RARE:
                return Arrays.asList(Fish.ReDaiFish,Fish.CopperDustFish,Fish.AluminumDustFish,
                Fish.GoldDustFish, Fish.IronDustFish, Fish.LeadDustFish, Fish.TinDustFish,
                        Fish.MagnesiumDustFish, Fish.SilverDustFish, Fish.ZincDustFish);
            case EPIC:
                return Arrays.asList(Fish.MYSTIC_EEL);
            case LEGENDARY:
                return Arrays.asList(Fish.LegendaryLuFish);
            default:
                return Collections.singletonList(Fish.SanWenFish);
        }
    }


}


