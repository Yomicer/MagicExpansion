package io.Yomicer.magicExpansion.utils;

import io.Yomicer.magicExpansion.MagicExpansion;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

/**
 * 水云间·鱼竿熟练度系统
 * 熟练度绑定鱼竿物品(NBT),不绑定玩家;8 个等级,指数式升级曲线
 */
public class WaterCloudRodProficiency {

    public static final NamespacedKey LV_KEY = new NamespacedKey(MagicExpansion.getInstance(), "watercloud_lv");
    public static final NamespacedKey XP_KEY = new NamespacedKey(MagicExpansion.getInstance(), "watercloud_xp");

    public static final int MAX_LEVEL = 8;
    /** 各等级升到下一级所需熟练度(指数式递增,后期分段加值) */
    public static final int[] REQUIREMENTS = {300, 600, 1200, 2200, 3200, 5200, 7200};
    /** 等级名称(古风意境) */
    public static final String[] LEVEL_NAMES = {
            "初见水云", "临渊而望", "知鱼之乐", "竿起风生",
            "水月在手", "踏浪而行", "山水有灵", "一竿一世界"
    };
    /** 每级固定升级提示(不重复) */
    public static final String[] LEVEL_UP_MESSAGES = {
            "此竿初醒,水云之间多了一丝灵性。",
            "竿身轻鸣,仿佛听见了江河的回应。",
            "收放之间,已渐知鱼之乐。",
            "竿起风生,垂纶再无迟滞。",
            "水月在手,此竿愈发通灵。",
            "踏浪而行,江河皆为坦途。",
            "山水有灵,皆与此竿相映。",
            "一竿一世界,水云间再无敌手。"
    };

    /** 普通钓获熟练度 */
    public static final int XP_COMMON = 1;
    /** 稀有钓获熟练度 */
    public static final int XP_RARE = 2;
    /** 特殊钓物熟练度 */
    public static final int XP_SPECIAL = 5;

    /** 基础 LURE 附魔等级(上钩速度),熟练度在此基础上叠加 */
    public static final int BASE_LURE = 2;
    /** 动作栏进度条格子数(50 个 |) */
    public static final int ACTION_BAR_LENGTH = 50;
    /** 鱼竿 lore 进度条格子数(33 个 |) */
    public static final int LORE_BAR_LENGTH = 33;

    private WaterCloudRodProficiency() {
    }

    public static int getLevel(ItemStack rod) {
        if (rod == null || !rod.hasItemMeta()) return 1;
        Integer lv = rod.getItemMeta().getPersistentDataContainer().get(LV_KEY, PersistentDataType.INTEGER);
        return lv == null ? 1 : Math.max(1, Math.min(MAX_LEVEL, lv));
    }

    public static int getXp(ItemStack rod) {
        if (rod == null || !rod.hasItemMeta()) return 0;
        Integer xp = rod.getItemMeta().getPersistentDataContainer().get(XP_KEY, PersistentDataType.INTEGER);
        return xp == null ? 0 : Math.max(0, xp);
    }

    /** 当前等级升到下一级所需熟练度;满级返回 0 */
    public static int getRequirement(int level) {
        if (level < 1) return REQUIREMENTS[0];
        if (level >= MAX_LEVEL) return 0;
        return REQUIREMENTS[level - 1];
    }

    public static boolean isMaxLevel(int level) {
        return level >= MAX_LEVEL;
    }

    public static String getLevelName(int level) {
        return LEVEL_NAMES[Math.max(1, Math.min(MAX_LEVEL, level)) - 1];
    }

    /** 熟练度百分比(魔法二代渐变色),如 42.86%;满级返回 100.00% */
    public static String getPercent(int level, int xp) {
        int need = getRequirement(level);
        if (need <= 0) return ColorGradient.getGradientNameVer2("100.00%");
        return ColorGradient.getGradientNameVer2(String.format("%.2f%%", Math.min(100.0, xp * 100.0 / need)));
    }

    /** 纯 | 进度条(不带数值):已获取部分使用魔法二代渐变色,未获取部分灰色;满级返回 已臻化境 */
    public static String getPipeBar(int level, int xp) {
        return buildPipeBar(ACTION_BAR_LENGTH, level, xp);
    }

    /** 构建指定长度的 | 进度条:已获取部分使用魔法二代渐变色,未获取部分灰色 */
    private static String buildPipeBar(int length, int level, int xp) {
        int need = getRequirement(level);
        if (need <= 0) return "已臻化境";
        int filled = Math.max(0, Math.min(length, (int) Math.round(xp * (double) length / need)));
        StringBuilder sb = new StringBuilder();
        if (filled >= 2) {
            sb.append(ColorGradient.getGradientNameVer2("|".repeat(filled)));
        } else if (filled == 1) {
            sb.append("§a|");
        }
        for (int i = filled; i < length; i++) sb.append("§7|");
        return sb.toString();
    }

    /** 鱼竿 lore 进度条:渐变 | 展示进度 + 渐变具体数值;满级返回 已臻化境 */
    public static String getProgressBar(int level, int xp) {
        int need = getRequirement(level);
        if (need <= 0) return "已臻化境";
        return buildPipeBar(LORE_BAR_LENGTH, level, xp) + " " + ColorGradient.getGradientNameVer2("(" + xp + "/" + need + ")");
    }

    /**
     * 给鱼竿增加熟练度,返回新等级(可能升级)
     */
    public static int addProficiency(ItemStack rod, int amount) {
        if (rod == null || amount <= 0) return getLevel(rod);
        ItemMeta meta = rod.getItemMeta();
        int level = meta.getPersistentDataContainer().getOrDefault(LV_KEY, PersistentDataType.INTEGER, 1);
        int xp = meta.getPersistentDataContainer().getOrDefault(XP_KEY, PersistentDataType.INTEGER, 0);
        level = Math.max(1, Math.min(MAX_LEVEL, level));
        xp += amount;
        while (level < MAX_LEVEL && xp >= REQUIREMENTS[level - 1]) {
            xp -= REQUIREMENTS[level - 1];
            level++;
        }
        if (level >= MAX_LEVEL) {
            xp = 0;
        }
        meta.getPersistentDataContainer().set(LV_KEY, PersistentDataType.INTEGER, level);
        meta.getPersistentDataContainer().set(XP_KEY, PersistentDataType.INTEGER, xp);
        rod.setItemMeta(meta);
        return level;
    }

    /**
     * 更新鱼竿 lore 中的熟练度行(保留原有 lore)
     */
    public static void updateLore(ItemStack rod) {
        if (rod == null) return;
        ItemMeta meta = rod.getItemMeta();
        List<String> lore = meta.getLore() == null ? new ArrayList<>() : new ArrayList<>(meta.getLore());
        lore.removeIf(line -> line.startsWith("§b熟练度:"));
        lore.add("§b熟练度: §f" + getLevelName(getLevel(rod)) + " §e" + getProgressBar(getLevel(rod), getXp(rod)));
        meta.setLore(lore);
        rod.setItemMeta(meta);
    }

    /**
     * 按当前等级应用 LURE 附魔(基础 + 等级特殊加成),用于提升上钩速度
     * 加成数值来自 WaterCloudRodEffects,后续新增效果时在此一并应用
     */
    public static void applyLureEnchant(ItemStack rod) {
        if (rod == null) return;
        ItemMeta meta = rod.getItemMeta();
        int total = BASE_LURE + WaterCloudRodEffects.getLureBonus(getLevel(rod));
        meta.removeEnchant(Enchantment.LURE);
        if (total > 0) {
            meta.addEnchant(Enchantment.LURE, total, true);
        }
        rod.setItemMeta(meta);
    }
}
