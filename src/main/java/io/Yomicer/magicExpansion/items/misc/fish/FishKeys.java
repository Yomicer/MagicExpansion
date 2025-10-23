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

import static io.Yomicer.magicExpansion.items.misc.fish.Fish.*;

public class FishKeys {

    public static final NamespacedKey FISH_TYPE = new NamespacedKey(JavaPlugin.getPlugin(MagicExpansion.class), "fish_type");
    public static final NamespacedKey FISH_WEIGHT = new NamespacedKey(JavaPlugin.getPlugin(MagicExpansion.class), "fish_weight");
    // 可选：存储重量稀有度（字符串）
    public static final NamespacedKey FISH_WEIGHT_RARITY = new NamespacedKey(JavaPlugin.getPlugin(MagicExpansion.class), "fish_weight_rarity");


    // ✅ 定义：物品 → 对应的稀有度（集中管理，易扩展）
    private static final Map<ItemStack, Fish.Rarity> RARITY_ITEM_MAP = new HashMap<>() {{
        put(MagicExpansionItems.RANDOM_FISH_COMMON,           Fish.Rarity.COMMON);
        put(MagicExpansionItems.RANDOM_FISH_UNCOMMON,         Fish.Rarity.UNCOMMON);
        put(MagicExpansionItems.RANDOM_FISH_RARE,             Fish.Rarity.RARE);
        put(MagicExpansionItems.RANDOM_FISH_RARE_POOL_DUST,   Fish.Rarity.RARE_POOL_DUST);
        put(MagicExpansionItems.RANDOM_FISH_RARE_POOL_ORE,    Fish.Rarity.RARE_POOL_ORE);
        put(MagicExpansionItems.RANDOM_FISH_RARE_POOL_INDUSTRY,    Fish.Rarity.RARE_POOL_INDUSTRY);
        put(MagicExpansionItems.RANDOM_FISH_EPIC_POOL_INDUSTRY,    Fish.Rarity.EPIC_POOL_INDUSTRY);
        put(MagicExpansionItems.RANDOM_FISH_EPIC_POOL_ALLOY_INGOT,    Fish.Rarity.EPIC_POOL_ALLOY_INGOT);
        put(MagicExpansionItems.RANDOM_FISH_EPIC,             Fish.Rarity.EPIC);
        put(MagicExpansionItems.RANDOM_FISH_LEGENDARY,        Fish.Rarity.LEGENDARY);
        put(MagicExpansionItems.FISH_LEGENDARY_EEL_POWER,        Fish.Rarity.LEGENDARY_EEL);
        // 👉 想加新稀有度？直接 put 一行即可！
    }};

    private static final Set<ItemStack> MAGIC_FISHING_RODS_NEW = new HashSet<>(Arrays.asList(

            MagicExpansionItems.FISHING_ROD_NEW_PLAYER

    ));
    private static final Set<ItemStack> MAGIC_FISHING_RODS_ADVANCED = new HashSet<>(Arrays.asList(

            MagicExpansionItems.FISHING_ROD_WIND_SPEAKER

    ));
    private static final Set<ItemStack> MAGIC_FISHING_RODS_ULTRA = new HashSet<>(Arrays.asList(

            MagicExpansionItems.FISHING_ROD_FINAL_STICK

    ));
    public static ItemStack enchantDropWithFishData(Player player, ItemStack drop, ItemStack rod) {
        Fish.Rarity targetRarity = null;


        for (Map.Entry<ItemStack, Fish.Rarity> entry : RARITY_ITEM_MAP.entrySet()) {
            if (SlimefunUtils.isItemSimilar(drop, entry.getKey(), true)) {
                targetRarity = entry.getValue();
                break; // 找到就退出
            }
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

        double weight = 0.0;
        if (isMagicFishingRod(rod, MAGIC_FISHING_RODS_NEW)) {
            weight = chosenFish.rollWeightNew();
        }else if (isMagicFishingRod(rod, MAGIC_FISHING_RODS_ADVANCED)) {
            weight = chosenFish.rollWeightAdvanced();
        }else if (isMagicFishingRod(rod, MAGIC_FISHING_RODS_ULTRA)) {
            weight = chosenFish.rollWeightUltra();
        }

//        double weight = chosenFish.rollWeight();

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
        meta.setDisplayName(chosenFish.getDisplayName() + " " +weightRareThis);

        // --- 修改 Lore ---
        List<String> lore = new ArrayList<>();
        lore.add(""); // 空行分隔
        lore.add(ColorGradient.getGradientName("鱼种稀有度: ")+ "§r§f" + chosenFish.getRarity().getDisplayName());
        lore.add(ColorGradient.getGradientName("重量: ")+ "§r§f" + String.format("%.3f", weight) + " kg");
        lore.add(ColorGradient.getGradientName("稀有度: ")+ "§r" + weightRarity.getDisplayName() +" "+ weightRareThis);
        if (chosenFish.getLoreLines() != null && chosenFish.getLoreLines().length > 0) {
            lore.add(""); // 空行分隔
            lore.addAll(Arrays.asList(chosenFish.getLoreLines()));
        }

        meta.setLore(lore);

        drop.setItemMeta(meta);

        return drop;
    }

    private static boolean isMagicFishingRod(ItemStack item, Set<ItemStack> s) {
        if (item == null || item.getType().isAir()) return false;

        return s.stream()
                .anyMatch(rod -> SlimefunUtils.isItemSimilar(item, rod, true));
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
            case RARE_POOL_ORE:
                // 稀有矿物鱼池：包含所有可产出矿物资源的稀有鱼种
                return Arrays.asList(Fish.CoalFish,
                        Fish.EmeraldFish, Fish.LapisFish,
                        Fish.DiamondFish, Fish.QuartzFish,
                        Fish.AmethystFish, Fish.IronFish,
                        Fish.GoldFish, Fish.CopperFish,
                        Fish.NetheriteFish,Fish.GlowStoneDustFish,
                        Fish.RedstoneFish);
            case RARE_POOL_DUST:
                // 稀有矿粉鱼池：包含所有可产出矿粉资源的稀有鱼种
                return Arrays.asList(Fish.ReDaiFish,
                        Fish.CopperDustFish, Fish.AluminumDustFish,
                        Fish.GoldDustFish, Fish.IronDustFish,
                        Fish.LeadDustFish, Fish.TinDustFish,
                        Fish.MagnesiumDustFish, Fish.SilverDustFish,
                        Fish.ZincDustFish);
            case RARE_POOL_INDUSTRY:
                // 稀有矿粉鱼池：包含所有可产出矿粉资源的稀有鱼种
                return Arrays.asList(Fish.ShuLingYu,
                        Fish.UraniumFish,Fish.OilRockFish,
                        Fish.SiliconFish,Fish.SulfateFish

                        );
            case EPIC_POOL_INDUSTRY:
                // 稀有矿粉鱼池：包含所有可产出矿粉资源的稀有鱼种
                return Arrays.asList(Fish.FoamCrystalFish,
                        Fish.BlackDiamondFish,Fish.EnchantedBottleFish

                        );
            case EPIC_POOL_ALLOY_INGOT:
                return Arrays.asList(ReinforcedAlloyFish,
                        HardenedMetalFish, DamascusSoulFish,SteelSoulFish,
                        BronzeAncientFish, HardlightAluFish, SilverCopperFish,
                        BrassResonanceFish, AluminumBrassFish, AluminumBronzeFish,
                        CorinthianBronzeFish, SolderFlowFish, NickelSpiritFish,
                        CobaltFlameFish, SiliconIronFish, CarbonSoulFish,
                        GildedIronFish, RedstoneAlloyFish, NeptuniumShadowFish,
                        PlutoniumCoreFish
                );
            case EPIC:
                return Arrays.asList(Fish.MYSTIC_EEL);
            case LEGENDARY:
                return Arrays.asList(Fish.LegendaryLuFish);
            case LEGENDARY_EEL:
                return Arrays.asList(LegendaryEelFish);
            default:
                return Collections.singletonList(Fish.SanWenFish);
        }
    }


}


