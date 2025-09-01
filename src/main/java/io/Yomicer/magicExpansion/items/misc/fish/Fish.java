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
            ColorGradient.getGradientName("鳕鱼体重大多都在 2 - 96 kg之间。"),
            ColorGradient.getGradientName("[特殊作用]可生产：萤石粉")
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

    TestFish(Rarity.RARE.colorCode+"测试鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("闪烁着金属光泽的小鱼，游动时会洒下细碎的铜色光点。"),
            ColorGradient.getGradientName("传说它由古老的铜矿渗水孕育而成，只在富含矿物质的水域存活。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("铜粉鱼体重大多都在 1 - 64 kg之间。")
    ),


    /**
     * 矿粉鱼-稀有
     */

    CopperDustFish(Rarity.RARE.colorCode+"赤鳞鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("闪烁着金属光泽的小鱼，游动时会洒下细碎的铜色光点。"),
            ColorGradient.getGradientName("传说它由古老的铜矿渗水孕育而成，只在富含矿物质的水域存活。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("铜粉鱼体重大多都在 1 - 64 kg之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：铜粉")
    ),

    GoldDustFish(Rarity.RARE.colorCode + "金砂鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("通体金黄，鳞片如熔金般流动，游动时留下淡淡光痕。"),
            ColorGradient.getGradientName("被认为是地脉金脉的化身，只在高温岩层附近的水域出没。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("金砂鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：金粉")
    ),

    IronDustFish(Rarity.RARE.colorCode + "铁鳞鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("银灰色的鳞片坚硬如铁，游动时发出轻微的金属摩擦声。"),
            ColorGradient.getGradientName("常出现在沉船残骸附近，以锈蚀的金属为食，生命力极强。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("铁鳞鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：铁粉")
    ),

    TinDustFish(Rarity.RARE.colorCode + "锡斑鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体表布满银白色斑点，游动时如水银滚动，反射幽蓝光泽。"),
            ColorGradient.getGradientName("偏好酸性水域，常在废弃冶炼厂排水口附近成群出现。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("锡斑鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：锡粉")
    ),

    SilverDustFish(Rarity.RARE.colorCode + "银光鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("通体如镜面般光滑，月光下会反射出梦幻般的银白色光辉。"),
            ColorGradient.getGradientName("传说是在满月之夜由银矿结晶化而成，极其惧怕阳光。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("银光鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：银粉")
    ),

    AluminumDustFish(Rarity.RARE.colorCode + "铝影鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("轻盈如影，通体呈淡银白色，几乎不扰动水面。"),
            ColorGradient.getGradientName("现代工业的意外产物，能在高碱性废水中存活并繁衍。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("铝影鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：铝粉")
    ),

    LeadDustFish(Rarity.RARE.colorCode + "铅毒鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体色暗沉如铅，周身散发微弱的紫色毒雾，令其他生物避之不及。"),
            ColorGradient.getGradientName("诞生于被严重污染的水域，体内富集大量重金属毒素。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("铅毒鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：铅粉")
    ),

    ZincDustFish(Rarity.RARE.colorCode + "锌花鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体表覆盖着蓝绿色氧化层花纹，游动时会析出微小晶体。"),
            ColorGradient.getGradientName("常见于老旧镀锌管道附近，以腐蚀产物为食。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("锌花鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：锌粉")
    ),

    MagnesiumDustFish(Rarity.RARE.colorCode + "镁光鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体内富含易燃物质，受惊时会瞬间爆发出刺眼白光。"),
            ColorGradient.getGradientName("极其活跃，常在雷雨天跃出水面，仿佛在吸收电能。"),
            ColorGradient.getGradientName("可在生态缸中进行稳定生产。"),
            ColorGradient.getGradientName("镁光鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：镁粉")
    ),


    /**
     * 矿物鱼-稀有
     */

    // 【CoalFish】用于生产：煤炭（Coal）
    CoalFish(Rarity.RARE.colorCode + "煤晶鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体内凝结着微型煤炭晶体，受压时会迸发火花。"),
            ColorGradient.getGradientName("常在地底暗河中穿梭，喜好靠近熔岩区域取暖。"),
            ColorGradient.getGradientName("其代谢产物可直接用于燃料生产。"),
            ColorGradient.getGradientName("煤晶鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：煤炭")
    ),
    // 【EmeraldFish】用于生产：绿宝石（Emerald）
    EmeraldFish(Rarity.RARE.colorCode + "翠宝鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("鳞片如绿宝石般通透，映出丛林深处的光影。"),
            ColorGradient.getGradientName("只在附魔台附近水源中偶有出没。"),
            ColorGradient.getGradientName("据说能提升周围物品的附魔概率。"),
            ColorGradient.getGradientName("翠宝鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：绿宝石")
    ),
    // 【LapisFish】用于生产：青金石（Lapis Lazuli）
    LapisFish(Rarity.RARE.colorCode + "靛灵鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体内流淌着深蓝色的矿物流体，静谧如夜空。"),
            ColorGradient.getGradientName("游动时会释放微弱的魔法波动，干扰红石信号。"),
            ColorGradient.getGradientName("其分泌物是顶级附魔染料的核心成分。"),
            ColorGradient.getGradientName("靛灵鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：青金石")
    ),
    // 【DiamondFish】用于生产：钻石（Diamond）
    DiamondFish(Rarity.RARE.colorCode + "晶耀鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("全身覆盖类钻石结晶鳞片，硬度接近地核矿物。"),
            ColorGradient.getGradientName("仅在高压水晶洞穴中稳定存活。"),
            ColorGradient.getGradientName("可通过生态缸模拟深层地壳环境进行培育。"),
            ColorGradient.getGradientName("晶耀鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：钻石")
    ),
    // 【QuartzFish】用于生产：下界石英（Nether Quartz）
    QuartzFish(Rarity.RARE.colorCode + "焰晶鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体内燃烧着不灭的红色石英核心，持续释放热量。"),
            ColorGradient.getGradientName("常在下界传送门附近游弋，似能感知维度波动。"),
            ColorGradient.getGradientName("是红石精密仪器所需石英的稳定生产源。"),
            ColorGradient.getGradientName("焰晶鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：下界石英")
    ),
    // 【AmethystFish】用于生产：紫水晶碎片（Amethyst Shard）
    AmethystFish(Rarity.RARE.colorCode + "震颤鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("头部生长天然紫水晶簇，对雷暴频率极为敏感。"),
            ColorGradient.getGradientName("在雷雨天会集体共振，发出清脆鸣响。"),
            ColorGradient.getGradientName("可用于自动化系统中的信号触发与计时模块。"),
            ColorGradient.getGradientName("震颤鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：紫水晶碎片")
    ),
    // 【IronFish】用于生产：铁锭（Iron Ingot）
    IronFish(Rarity.RARE.colorCode + "铁核鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体内富含磁性铁矿，可自然聚集成铁块结构。"),
            ColorGradient.getGradientName("常成群活动，形成移动的微型磁场。"),
            ColorGradient.getGradientName("是生态冶金系统中最稳定的铁资源供应者。"),
            ColorGradient.getGradientName("铁核鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：铁锭")
    ),
    // 【GoldFish】用于生产：金锭（Gold Ingot）
    GoldFish(Rarity.RARE.colorCode + "鎏核鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体内流淌液态黄金，在阳光下反射帝王光辉。"),
            ColorGradient.getGradientName("对红石能量高度敏感，常用于自动交易系统。"),
            ColorGradient.getGradientName("可通过喂食南瓜饼提升金锭产出效率。"),
            ColorGradient.getGradientName("鎏核鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：金锭")
    ),
    // 【CopperFish】用于生产：铜锭（Copper Ingot）
    CopperFish(Rarity.RARE.colorCode + "铜脉鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体内有天然铜脉网络，能传导微弱电流。"),
            ColorGradient.getGradientName("鳞片随环境氧化，颜色从赤红渐变为青绿。"),
            ColorGradient.getGradientName("是红石电路与避雷针材料的可持续来源。"),
            ColorGradient.getGradientName("铜脉鱼体重大多都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：铜锭")
    ),
    // 【NetheriteFish】用于生产：下界合金锭（Netherite Ingot）
    NetheriteFish(Rarity.RARE.colorCode + "狱铸鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("由下界烈焰与远古合金融合而成，周身缠绕黑焰。"),
            ColorGradient.getGradientName("可在改良型生态熔炉缸中稳定生成下界合金锭。"),
            ColorGradient.getGradientName("免疫火焰与爆炸，是顶级装备材料的唯一活体来源。"),
            ColorGradient.getGradientName("传说中狱铸鱼体重恒定为 64 kg，因其已超越凡俗衡量。"),
            ColorGradient.getGradientName("但是绝大多数狱铸鱼体重都在 1 - 64 kg 之间。"),
            ColorGradient.getGradientName("「特殊作用」可生产：下界合金锭")
    ),
    // 【GlowStoneFish】用于生产：萤石粉（Glowstone Dust）
    GlowStoneDustFish(Rarity.RARE.colorCode + "灯笼鱼", 1.0, 64.0, Rarity.RARE,
            ColorGradient.getGradientName("体内悬浮着微型发光菌群，如深海中的移动星辰。"),
            ColorGradient.getGradientName("只在完全黑暗的洞穴水体中出没，惧怕任何光源。"),
            ColorGradient.getGradientName("其分泌物是高级照明装置与魔法增幅器的核心材料。"),
            ColorGradient.getGradientName("灯笼鱼体重大多在 1 - 64 kg 之间，轻盈如雾。"),
            ColorGradient.getGradientName("「特殊作用」可生产：萤石粉"),
            ColorGradient.getGradientName("「特殊作用」可用于发电")
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
            ColorGradient.getGradientName("裸背电鳗体重大多都在 2 - 21 kg之间。"),
            ColorGradient.getGradientName("[特殊作用]可用于发电")
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



    public static Fish fromString(String name) {
        try {
            return Fish.valueOf(name);
        } catch (IllegalArgumentException e) {
            return null; // 或抛出异常
        }
    }


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

    public double rollWeightNew() {
        Random random = new Random();
        double unit = random.nextDouble();
        double skewed = Math.pow(unit, 6.9);
        return minWeight + (skewed * (maxWeight - minWeight));
    }
    public double rollWeightAdvanced() {
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
                return 1; // 默认倍率
            }
            try {
                WeightRarity rarity = WeightRarity.valueOf(name);
                return rarity.getMultiplier();
            } catch (IllegalArgumentException e) {
                return 1; // 名称无效，默认普通
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
        RARE_POOL_DUST("§b稀有-POOL-矿粉", "§b"),
        RARE_POOL_ORE("§b稀有-POOL-矿物", "§b"),
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
