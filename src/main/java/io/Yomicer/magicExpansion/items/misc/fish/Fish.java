package io.Yomicer.magicExpansion.items.misc.fish;

import io.Yomicer.magicExpansion.utils.ColorGradient;

import java.util.Random;

public enum Fish {
    SanWenFish(Rarity.COMMON.colorCode+"三文鱼", 5.0, 31.0, Rarity.COMMON,
            ColorGradient.getGradientName("河流与海洋的常客。"),
            ColorGradient.getGradientName("肉质鲜美，广受欢迎。"),
            ColorGradient.getGradientName("三文鱼体重大多都在 5 - 31 kg之间。")
    ),
    XueFish(Rarity.COMMON.colorCode+"鳕鱼", 2.0, 96.0, Rarity.COMMON,
            ColorGradient.getGradientName("寒冷水域的居民。"),
            ColorGradient.getGradientName("适合制作鱼条。"),
            ColorGradient.getGradientName("鳕鱼体重大多都在 2 - 96 kg之间。")
    ),
    HeTun(Rarity.UNCOMMON.colorCode+"河豚", 0.2, 1.5, Rarity.UNCOMMON,
            ColorGradient.getGradientName("小心！它会膨胀！"),
            ColorGradient.getGradientName("据说美味但有剧毒……"),
            ColorGradient.getGradientName("河豚体重大多都在 0.2 - 1.5 kg之间。")
    ),
    ReDaiFish(Rarity.RARE.colorCode+"热带鱼", 0.1, 4, Rarity.RARE,
            ColorGradient.getGradientName("色彩斑斓的小家伙。"),
            ColorGradient.getGradientName("只在温暖的水域出现。"),
            ColorGradient.getGradientName("热带鱼体重大多都在 0.1 - 4 kg之间。")
    ),



    CopperDustFish(Rarity.RARE.colorCode+"铜粉鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("闪烁着金属光泽的小鱼，游动时会洒下细碎的铜色光点。"),
            ColorGradient.getGradientName("传说它由古老的铜矿渗水孕育而成，只在富含矿物质的水域存活。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("铜粉鱼体重大多都在 1 - 64 kg之间。")
    ),

    GoldDustFish(Rarity.RARE.colorCode + "金砂鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("通体金黄，鳞片如熔金般流动，游动时留下淡淡光痕。"),
            ColorGradient.getGradientName("被认为是地脉金脉的化身，只在高温岩层附近的水域出没。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("金砂鱼体重大多都在 1 - 64 kg 之间。")
    ),

    IronDustFish(Rarity.RARE.colorCode + "铁鳞鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("银灰色的鳞片坚硬如铁，游动时发出轻微的金属摩擦声。"),
            ColorGradient.getGradientName("常出现在沉船残骸附近，以锈蚀的金属为食，生命力极强。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("铁鳞鱼体重大多都在 1 - 64 kg 之间。")
    ),

    TinDustFish(Rarity.RARE.colorCode + "锡斑鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体表布满银白色斑点，游动时如水银滚动，反射幽蓝光泽。"),
            ColorGradient.getGradientName("偏好酸性水域，常在废弃冶炼厂排水口附近成群出现。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("锡斑鱼体重大多都在 1 - 64 kg 之间。")
    ),

    SilverDustFish(Rarity.RARE.colorCode + "银光鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("通体如镜面般光滑，月光下会反射出梦幻般的银白色光辉。"),
            ColorGradient.getGradientName("传说是在满月之夜由银矿结晶化而成，极其惧怕阳光。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("银光鱼体重大多都在 1 - 64 kg 之间。")
    ),

    AluminumDustFish(Rarity.RARE.colorCode + "铝影鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("轻盈如影，通体呈淡银白色，几乎不扰动水面。"),
            ColorGradient.getGradientName("现代工业的意外产物，能在高碱性废水中存活并繁衍。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("铝影鱼体重大多都在 1 - 64 kg 之间。")
    ),

    LeadDustFish(Rarity.RARE.colorCode + "铅毒鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体色暗沉如铅，周身散发微弱的紫色毒雾，令其他生物避之不及。"),
            ColorGradient.getGradientName("诞生于被严重污染的水域，体内富集大量重金属毒素。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("铅毒鱼体重大多都在 1 - 64 kg 之间。")
    ),

    ZincDustFish(Rarity.RARE.colorCode + "锌花鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体表覆盖着蓝绿色氧化层花纹，游动时会析出微小晶体。"),
            ColorGradient.getGradientName("常见于老旧镀锌管道附近，以腐蚀产物为食。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("锌花鱼体重大多都在 1 - 64 kg 之间。")
    ),

    MagnesiumDustFish(Rarity.RARE.colorCode + "镁光鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体内富含易燃物质，受惊时会瞬间爆发出刺眼白光。"),
            ColorGradient.getGradientName("极其活跃，常在雷雨天跃出水面，仿佛在吸收电能。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("镁光鱼体重大多都在 1 - 64 kg 之间。")
    ),








    LegendaryLuFish(Rarity.LEGENDARY.colorCode+"传奇鲈鱼", 2.0, 31.0, Rarity.LEGENDARY,
            ColorGradient.getGradientName("传说中的巨物！"),
            ColorGradient.getGradientName("每个钓手的梦想。"),
            ColorGradient.getGradientName("据说能带来好运。"),
            ColorGradient.getGradientName("传奇鲈鱼体重大多都在 2 - 31 kg之间。")
    ),
    MYSTIC_EEL(Rarity.EPIC.colorCode+"裸背电鳗", 2.0, 21.0, Rarity.EPIC,
            ColorGradient.getGradientName("深海中的幽影。"),
            ColorGradient.getGradientName("散发着微弱的蓝光。"),
            ColorGradient.getGradientName("没人知道它来自何方。"),
            ColorGradient.getGradientName("可产生高达600伏的电压和1安培的电流。"),
            ColorGradient.getGradientName("裸背电鳗体重大多都在 2 - 21 kg之间。")
    );

    private final String displayName;
    private final double minWeight;
    private final double maxWeight;
    private final Rarity rarity;
    private final String[] loreLines;

    Fish(String displayName, double minWeight, double maxWeight, Rarity rarity, String... loreLines) {
        this.displayName = displayName;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.rarity = rarity;
        this.loreLines = loreLines;
    }

    // Getter 省略（同上）
    public String getDisplayName() { return displayName; }
    public double getMinWeight() { return minWeight; }
    public double getMaxWeight() { return maxWeight; }
    public Rarity getRarity() { return rarity; }
    public String[] getLoreLines() { return loreLines.clone(); }

    /**
     * 按“越轻越稀有”原则生成重量
     * 使用偏态分布：更大概率生成接近 minWeight 的小重量
     */
    public double rollWeight() {
        Random random = new Random();
        double unit = random.nextDouble();
        double skewed = Math.pow(unit, 3.9);
        return minWeight + (skewed * (maxWeight - minWeight));
    }

    /**
     * 计算重量在范围内的“归一化百分比”（0.0 ~ 1.0）
     * 注意：值越小表示越轻
     */
    public double getWeightPercent(double weight) {
        if (weight <= minWeight) return 0.0;
        if (weight >= maxWeight) return 1.0;
        return (weight - minWeight) / (maxWeight - minWeight);
    }

    /**
     * 根据重量判断“重量稀有度”
     */
    public WeightRarity getWeightRarity(double weight) {
        double percent = getWeightPercent(weight);
        return WeightRarity.fromPercent(percent);
    }

    // ======================
    // 内部枚举：重量稀有度（独立于基础稀有度）
    // ======================
    public enum WeightRarity {
        COMMON_FISH("§f普通鱼", "§f",1),
        RARE_FISH("§e稀有鱼", "§e",4),
        SUPER_RARE_FISH("§b超级稀有鱼", "§b",11);

        private final String displayName;
        private final String colorCode;
        private final int multiplier;

        WeightRarity(String displayName, String colorCode, int multiplier) {
            this.displayName = displayName;
            this.colorCode = colorCode;
            this.multiplier = multiplier;
        }

        public String getDisplayName() { return displayName; }
        public String getColorCode() { return colorCode; }
        public int getMultiplier() {
            return multiplier;
        }

        public static int getMultiplierByName(String name) {
            if (name == null) {
                return 0; // 默认倍率
            }
            try {
                WeightRarity rarity = WeightRarity.valueOf(name);
                return rarity.getMultiplier();
            } catch (IllegalArgumentException e) {
                return 0; // 名称无效，默认普通
            }
        }

        /**
         * 根据归一化百分比（0.0~1.0）判断重量稀有度
         * 注意：越轻越稀有 → 百分比越小越稀有
         */
        public static WeightRarity fromPercent(double percent) {
            if (percent > 0.95) {
                return SUPER_RARE_FISH;  // 最轻的 5% → 超级稀有
            } else if (percent > 0.9) {
                return RARE_FISH;        // 中间的 5% → 稀有鱼
            } else {
                return COMMON_FISH;      // 最重的 90% → 普通鱼
            }
        }
    }

    // ======================
    // 基础稀有度（原系统）
    // ======================
    public enum Rarity {
        COMMON("§f普通", "§f"),
        UNCOMMON("§a罕见", "§a"),
        RARE("§b稀有", "§b"),
        EPIC("§d史诗", "§d"),
        LEGENDARY("§c传说", "§c");

        private final String displayName;
        private final String colorCode;

        Rarity(String displayName, String colorCode) {
            this.displayName = displayName;
            this.colorCode = colorCode;
        }

        public String getDisplayName() { return displayName; }
        public String getColorCode() { return colorCode; }
    }
}
