package io.Yomicer.magicExpansion.items.misc.fish;

import io.Yomicer.magicExpansion.utils.ColorGradient;

import java.util.Random;

public enum Fish {
    SanWenFish(Rarity.COMMON.colorCode+"三文鱼", 5.0, 31.0, Rarity.COMMON,
            ("§x§6§B§E§E§D§1河流与海洋的常客。"),
            ("§x§B§F§A§A§D§0肉质鲜美，广受欢迎。"),
            ("§x§F§F§3§2§C§E三文鱼体重大多都在 5 - 31 kg之间。")
    ),
    XueFish(Rarity.COMMON.colorCode+"鳕鱼", 2.0, 96.0, Rarity.COMMON,
            ("§x§6§B§E§E§D§1寒冷水域的居民。"),
            ("§x§B§F§A§A§D§0适合制作鱼条。"),
            ("§x§F§F§3§2§C§E鳕鱼体重大多都在 2 - 96 kg之间。")
    ),
    HeTun(Rarity.UNCOMMON.colorCode+"河豚", 0.2, 1.5, Rarity.UNCOMMON,
            ("§x§6§B§E§E§D§1小心！它会膨胀！"),
            ("§x§B§F§A§A§D§0据说美味但有剧毒……"),
            ("§x§F§F§3§2§C§E河豚体重大多都在 0.2 - 1.5 kg之间。")
    ),
    ReDaiFish(Rarity.RARE.colorCode+"热带鱼", 0.1, 4, Rarity.RARE,
            ("§x§6§B§E§E§D§1色彩斑斓的小家伙。"),
            ("§x§B§F§A§A§D§0只在温暖的水域出现。"),
            ("§x§F§F§3§2§C§E热带鱼体重大多都在 0.1 - 4 kg之间。")
    ),

    TestFish(Rarity.RARE.colorCode+"测试鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1闪烁着金属光泽的小鱼，游动时会洒下细碎的铜色光点。"),
            ("§x§B§0§C§5§D§0传说它由古老的铜矿渗水孕育而成，只在富含矿物质的水域存活。"),
            ("§x§C§E§8§7§A§8可在生态缸中进行稳定生产。"),
            ("§x§F§F§3§2§C§E铜粉鱼体重大多都在 1 - 64 kg之间。")
    ),


    /**
     * 矿粉鱼-稀有
     */

    CopperDustFish(Rarity.RARE.colorCode+"赤鳞鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1闪烁着金属光泽的小鱼，游动时会洒下细碎的铜色光点。"),
            ("§x§A§A§C§D§D§0传说它由古老的铜矿渗水孕育而成，只在富含矿物质的水域存活。"),
            ("§x§B§F§B§A§D§0可在生态缸中进行稳定生产。"),
            ("§x§9§C§5§2§8§B铜粉鱼体重大多都在 1 - 64 kg之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：铜粉")
    ),

    GoldDustFish(Rarity.RARE.colorCode + "金砂鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1通体金黄，鳞片如熔金般流动，游动时留下淡淡光痕。"),
            ("§x§A§A§C§D§D§0被认为是地脉金脉的化身，只在高温岩层附近的水域出没。"),
            ("§x§B§F§B§A§D§0可在生态缸中进行稳定生产。"),
            ("§x§9§C§5§2§8§B金砂鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：金粉")
    ),

    IronDustFish(Rarity.RARE.colorCode + "铁鳞鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1银灰色的鳞片坚硬如铁，游动时发出轻微的金属摩擦声。"),
            ("§x§A§A§C§D§D§0常出现在沉船残骸附近，以锈蚀的金属为食，生命力极强。"),
            ("§x§B§F§B§A§D§0可在生态缸中进行稳定生产。"),
            ("§x§9§C§5§2§8§B铁鳞鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：铁粉")
    ),

    TinDustFish(Rarity.RARE.colorCode + "锡斑鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1体表布满银白色斑点，游动时如水银滚动，反射幽蓝光泽。"),
            ("§x§A§A§C§D§D§0偏好酸性水域，常在废弃冶炼厂排水口附近成群出现。"),
            ("§x§B§F§B§A§D§0可在生态缸中进行稳定生产。"),
            ("§x§9§C§5§2§8§B锡斑鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：锡粉")
    ),

    SilverDustFish(Rarity.RARE.colorCode + "银光鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1通体如镜面般光滑，月光下会反射出梦幻般的银白色光辉。"),
            ("§x§A§A§C§D§D§0传说是在满月之夜由银矿结晶化而成，极其惧怕阳光。"),
            ("§x§B§F§B§A§D§0可在生态缸中进行稳定生产。"),
            ("§x§9§C§5§2§8§B银光鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：银粉")
    ),

    AluminumDustFish(Rarity.RARE.colorCode + "铝影鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1轻盈如影，通体呈淡银白色，几乎不扰动水面。"),
            ("§x§A§A§C§D§D§0现代工业的意外产物，能在高碱性废水中存活并繁衍。"),
            ("§x§B§F§B§A§D§0可在生态缸中进行稳定生产。"),
            ("§x§9§C§5§2§8§B铝影鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：铝粉")
    ),

    LeadDustFish(Rarity.RARE.colorCode + "铅毒鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1体色暗沉如铅，周身散发微弱的紫色毒雾，令其他生物避之不及。"),
            ("§x§A§A§C§D§D§0诞生于被严重污染的水域，体内富集大量重金属毒素。"),
            ("§x§B§F§B§A§D§0可在生态缸中进行稳定生产。"),
            ("§x§9§C§5§2§8§B铅毒鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：铅粉")
    ),

    ZincDustFish(Rarity.RARE.colorCode + "锌花鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1体表覆盖着蓝绿色氧化层花纹，游动时会析出微小晶体。"),
            ("§x§A§A§C§D§D§0常见于老旧镀锌管道附近，以腐蚀产物为食。"),
            ("§x§B§F§B§A§D§0可在生态缸中进行稳定生产。"),
            ("§x§9§C§5§2§8§B锌花鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：锌粉")
    ),

    MagnesiumDustFish(Rarity.RARE.colorCode + "镁光鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1体内富含易燃物质，受惊时会瞬间爆发出刺眼白光。"),
            ("§x§A§A§C§D§D§0极其活跃，常在雷雨天跃出水面，仿佛在吸收电能。"),
            ("§x§B§F§B§A§D§0可在生态缸中进行稳定生产。"),
            ("§x§9§C§5§2§8§B镁光鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：镁粉")
    ),


    /**
     * 矿物鱼-稀有
     */

    // 【CoalFish】用于生产：煤炭（Coal）
    CoalFish(Rarity.RARE.colorCode + "煤晶鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1体内凝结着微型煤炭晶体，受压时会迸发火花。"),
            ("§x§A§A§C§D§D§0常在地底暗河中穿梭，喜好靠近熔岩区域取暖。"),
            ("§x§B§F§B§A§D§0其代谢产物可直接用于燃料生产。"),
            ("§x§9§C§5§2§8§B煤晶鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：煤炭")
    ),
    // 【EmeraldFish】用于生产：绿宝石（Emerald）
    EmeraldFish(Rarity.RARE.colorCode + "翠宝鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1鳞片如绿宝石般通透，映出丛林深处的光影。"),
            ("§x§A§A§C§D§D§0只在附魔台附近水源中偶有出没。"),
            ("§x§B§F§B§A§D§0据说能提升周围物品的附魔概率。"),
            ("§x§9§C§5§2§8§B翠宝鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：绿宝石")
    ),
    // 【LapisFish】用于生产：青金石（Lapis Lazuli）
    LapisFish(Rarity.RARE.colorCode + "靛灵鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1体内流淌着深蓝色的矿物流体，静谧如夜空。"),
            ("§x§A§A§C§D§D§0游动时会释放微弱的魔法波动，干扰红石信号。"),
            ("§x§B§F§B§A§D§0其分泌物是顶级附魔染料的核心成分。"),
            ("§x§9§C§5§2§8§B靛灵鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：青金石")
    ),
    // 【DiamondFish】用于生产：钻石（Diamond）
    DiamondFish(Rarity.RARE.colorCode + "晶耀鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1全身覆盖类钻石结晶鳞片，硬度接近地核矿物。"),
            ("§x§A§A§C§D§D§0仅在高压水晶洞穴中稳定存活。"),
            ("§x§B§F§B§A§D§0可通过生态缸模拟深层地壳环境进行培育。"),
            ("§x§9§C§5§2§8§B晶耀鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：钻石")
    ),
    // 【QuartzFish】用于生产：下界石英（Nether Quartz）
    QuartzFish(Rarity.RARE.colorCode + "焰晶鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1体内燃烧着不灭的红色石英核心，持续释放热量。"),
            ("§x§A§A§C§D§D§0常在下界传送门附近游弋，似能感知维度波动。"),
            ("§x§B§F§B§A§D§0是红石精密仪器所需石英的稳定生产源。"),
            ("§x§9§C§5§2§8§B焰晶鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：下界石英")
    ),
    // 【AmethystFish】用于生产：紫水晶碎片（Amethyst Shard）
    AmethystFish(Rarity.RARE.colorCode + "震颤鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1头部生长天然紫水晶簇，对雷暴频率极为敏感。"),
            ("§x§A§A§C§D§D§0在雷雨天会集体共振，发出清脆鸣响。"),
            ("§x§B§F§B§A§D§0可用于自动化系统中的信号触发与计时模块。"),
            ("§x§9§C§5§2§8§B震颤鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：紫水晶碎片")
    ),
    // 【IronFish】用于生产：铁锭（Iron Ingot）
    IronFish(Rarity.RARE.colorCode + "铁核鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1体内富含磁性铁矿，可自然聚集成铁块结构。"),
            ("§x§A§A§C§D§D§0常成群活动，形成移动的微型磁场。"),
            ("§x§B§F§B§A§D§0是生态冶金系统中最稳定的铁资源供应者。"),
            ("§x§9§C§5§2§8§B铁核鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：铁锭")
    ),
    // 【GoldFish】用于生产：金锭（Gold Ingot）
    GoldFish(Rarity.RARE.colorCode + "鎏核鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1体内流淌液态黄金，在阳光下反射帝王光辉。"),
            ("§x§A§A§C§D§D§0对红石能量高度敏感，常用于自动交易系统。"),
            ("§x§B§F§B§A§D§0可通过喂食南瓜饼提升金锭产出效率。"),
            ("§x§9§C§5§2§8§B鎏核鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：金锭")
    ),
    // 【CopperFish】用于生产：铜锭（Copper Ingot）
    CopperFish(Rarity.RARE.colorCode + "铜脉鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1体内有天然铜脉网络，能传导微弱电流。"),
            ("§x§A§A§C§D§D§0鳞片随环境氧化，颜色从赤红渐变为青绿。"),
            ("§x§B§F§B§A§D§0是红石电路与避雷针材料的可持续来源。"),
            ("§x§9§C§5§2§8§B铜脉鱼体重大多都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：铜锭")
    ),
    // 【脉动鱼】用于生产：红石粉（Redstone Dust）
    RedstoneFish(Rarity.RARE.colorCode + "赤脉鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1栖息于地底强磁场与矿物脉动交汇处，体内共生着微型红石菌群。"),
            ("§x§A§A§C§D§D§0鱼鳍如电路板纹路，游动时体表闪烁着规律的红色脉冲光。"),
            ("§x§B§F§B§A§D§0其脊髓与内脏富含活性红石微粒，是能量传导与自动化装置的核心原料。"),
            ("§x§9§C§5§2§8§B脉动鱼体重多在 1 - 64 kg 之间，脉冲频率越高，红石纯度越佳。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：红石粉")
    ),
    // 【NetheriteFish】用于生产：下界合金锭（Netherite Ingot）
    NetheriteFish(Rarity.RARE.colorCode + "狱铸鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1由下界烈焰与远古合金融合而成，周身缠绕黑焰。"),
            ("§x§9§5§C§4§D§0可在改良型生态熔炉缸中稳定生成下界合金锭。"),
            ("§x§B§F§B§A§D§0免疫火焰与爆炸，是顶级装备材料的唯一活体来源。"),
            ("§x§A§D§A§2§9§E传说中狱铸鱼体重恒定为 64 kg，因其已超越凡俗衡量。"),
            ("§x§C§B§4§2§A§6但是绝大多数狱铸鱼体重都在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：下界合金锭")
    ),
    // 【GlowStoneFish】用于生产：萤石粉（Glowstone Dust）
    GlowStoneDustFish(Rarity.RARE.colorCode + "灯笼鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1体内悬浮着微型发光菌群，如深海中的移动星辰。"),
            ("§x§9§5§C§4§D§0只在完全黑暗的洞穴水体中出没，惧怕任何光源。"),
            ("§x§B§F§B§A§D§0其分泌物是高级照明装置与魔法增幅器的核心材料。"),
            ("§x§A§D§A§2§9§E灯笼鱼体重大多在 1 - 64 kg 之间，轻盈如雾。"),
            ("§x§C§B§4§2§A§6「特殊作用」可生产：萤石粉"),
            ("§x§F§F§3§2§C§E「特殊作用」可用于发电")
    ),

    // 【塑灵鱼】用于生产：塑料纸（Plastic Paper）
    ShuLingYu(Rarity.RARE.colorCode + "塑灵鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1体内缠绕微塑料纤维网络，可过滤水体污染物。"),
            ("§x§A§A§C§D§D§0体表覆盖半透明聚合物鳞片，折射出虹彩光泽。"),
            ("§x§B§F§B§A§D§0其分泌物经处理可制成工业生产常用的塑料纸。"),
            ("§x§9§C§5§2§8§B塑灵鱼体重大多在 1 - 64 kg 范围内。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：塑料纸")
    ),
    // 【铀核鱼】用于生产：铀锭（Uranium Ingot）
    UraniumFish(Rarity.RARE.colorCode + "铀核鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1体内含有微量放射性同位素，鳃部能富集水中的铀元素。"),
            ("§x§A§A§C§D§D§0体色呈深绿至墨黑，散发微弱荧光，接近时有温热感。"),
            ("§x§B§F§B§A§D§0是核能科技与高级反应堆的核心原材料来源。"),
            ("§x§9§C§5§2§8§B铀核鱼体重通常在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：铀锭")
    ),
    // 【油岩鱼】用于生产：原油桶（Crude Oil Barrel）
    OilRockFish(Rarity.RARE.colorCode + "油岩鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1栖息于深海油脉裂谷，体腔可自然合成液态烃类物质。"),
            ("§x§A§A§C§D§D§0表皮如浸油岩石，滑腻厚重，散发淡淡石油气味。"),
            ("§x§B§F§B§A§D§0捕获后可稳定提取原油，是能源工业的重要生物载体。"),
            ("§x§9§C§5§2§8§B油岩鱼体重普遍在 1 - 64 kg 范围内。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：原油桶")
    ),
    // 【泡晶鱼】用于生产：起泡锭（Foamium Ingot）
    FoamCrystalFish(Rarity.EPIC.colorCode + "泡晶鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1体内共生泡沫结晶菌，呼吸时释放含金属微泡。"),
            ("§x§A§A§C§D§D§0通体如半固态泡沫，轻盈透明，遇光膨胀闪烁。"),
            ("§x§B§F§B§A§D§0其结晶腺体可提炼出轻质高强的起泡锭，用于辐射物品制造。"),
            ("§x§9§C§5§2§8§B泡晶鱼体重多在 1 - 64 kg 之间。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：起泡锭")
    ),
    // 【黑曜鱼】用于生产：黑金刚石（Black Diamond）
    BlackDiamondFish(Rarity.EPIC.colorCode + "黑曜鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1生于地壳高压层，骨骼由天然纳米级碳晶构成。"),
            ("§x§A§A§C§D§D§0体表如碎曜石拼接，漆黑深邃，切割时迸发金属寒光。"),
            ("§x§B§F§B§A§D§0每百年蜕一次晶皮，可炼出比钻石更坚硬的黑金刚石。"),
            ("§x§9§C§5§2§8§B黑曜鱼体重可达 1 - 64 kg，越重者晶化程度越高。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：黑金刚石")
    ),
    // 【酸晶鱼】用于生产：硫酸盐（Sulfate Crystals）
    SulfateFish(Rarity.RARE.colorCode + "酸晶鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1栖息于火山酸水湖，体内腺体可代谢硫化物生成结晶。"),
            ("§x§A§A§C§D§D§0体表覆盖细小硫酸盐晶簇，触碰会释放淡淡硫磺气味。"),
            ("§x§B§F§B§A§D§0其排出的晶体是工业制酸与肥料生产的重要原料。"),
            ("§x§9§C§5§2§8§B酸晶鱼体重一般在 1 - 64 kg 范围内。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：硫酸盐")
    ),
    // 【晶鳞鱼】用于生产：硅（Silicon）
    SiliconFish(Rarity.RARE.colorCode + "晶鳞鱼", 1.0, 64.0, Rarity.RARE,
            ("§x§6§B§E§E§D§1生活在高硅沙质水域，鳃部可高效吸收并提纯二氧化硅。"),
            ("§x§A§A§C§D§D§0鳞片如微型晶片，排列规整，在阳光下呈现半导体光泽。"),
            ("§x§B§F§B§A§D§0体内沉积的高纯度硅晶体，是电子工业与太阳能板的核心材料。"),
            ("§x§9§C§5§2§8§B晶鳞鱼体重多在 1 - 64 kg 之间，越老者硅化程度越高。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：硅")
    ),
    // 【灵咒鱼】用于生产：附魔瓶（Bottled Enchanting）
    EnchantedBottleFish(Rarity.EPIC.colorCode + "灵咒鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1游弋于魔法漩涡与古代符文阵之间，以逸散的附魔能量为食。"),
            ("§x§9§5§C§4§D§0通体半透明，体内似有无数微型符文如萤火般流转，永不熄灭。"),
            ("§x§B§F§B§A§D§0其体液蕴含不稳定的奥术精华，可凝结为蕴含随机魔力的附魔瓶。"),
            ("§x§A§D§A§2§9§E灵咒鱼极为罕见，需用魔法钓竿垂钓，否则符文溃散，魔力尽失。"),
            ("§x§C§B§4§2§A§6灵咒鱼体重多在 1 - 64 kg 之间，越老者灵咒程度越高。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：附魔之瓶")
    ),




    //【合金锭鱼】

    // 【合金灵鱼】用于生产：强化合金锭
    ReinforcedAlloyFish(Rarity.EPIC.colorCode + "强化灵鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1游走于高压反应堆与强化能量场之间，以辐射淬炼与结构应力为食。"),
            ("§x§9§5§C§4§D§0躯体如多层复合装甲，表面浮现出暗红与银灰交织的强化纹路。"),
            ("§x§B§F§B§A§D§0其脊骨凝结成‘强化合金锭’，是未来科技的核心基材。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，否则灵鱼自毁，锭核崩解。"),
            ("§x§C§B§4§2§A§6强化灵鱼体重多在 1 - 64 kg 之间，越重者结构越稳定。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：强化合金锭")
    ),

    // 【硬化灵鱼】用于生产：硬化金属
    HardenedMetalFish(Rarity.EPIC.colorCode + "硬化灵鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1栖息于深地淬火池与高压锻压机之间，以极寒与烈焰交替淬炼为生。"),
            ("§x§9§5§C§4§D§0体表覆盖如陶瓷般坚硬的金属釉层，触之冰冷刺骨。"),
            ("§x§B§F§B§A§D§0体内结晶为‘硬化金属’，表面布满龟裂纹路，却坚不可摧。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，恒温环境下会陷入假死。"),
            ("§x§C§B§4§2§A§6硬化灵鱼体重多在 1 - 64 kg 之间，越老者釉层越厚。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：硬化金属")
    ),

    // 【大马士革灵鱼】用于生产：大马士革钢锭
    DamascusSoulFish(Rarity.EPIC.colorCode + "大马士革灵鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1诞生于千层叠锻的火焰之河，以折叠锻打的韵律与碳晶生长为能。"),
            ("§x§9§5§C§4§D§0通体如流动的水波纹钢，鳞片层层交叠，泛着幽蓝与暗金的交错光泽。"),
            ("§x§B§F§B§A§D§0体内沉眠着‘大马士革钢锭’，是工艺与灵魂的完美融合。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，需以古法钓具静取。"),
            ("§x§C§B§4§2§A§6大马士革灵鱼体重多在 1 - 64 kg 之间，纹路越繁复者品质越高。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：大马士革钢锭")
    ),

    // 【钢魄鱼】用于生产：钢锭
    SteelSoulFish(Rarity.EPIC.colorCode + "钢魄鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1栖息于熔炉核心与冷却钢水之间，以碳火之息与锤击韵律为养。"),
            ("§x§9§5§C§4§D§0通体银灰泛蓝，鳞片如轧制钢板层层交叠，坚韧不可摧。"),
            ("§x§B§F§B§A§D§0体内凝有‘钢锭’核心，乃工业脊梁的活体源头。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，静默是成功的关键。"),
            ("§x§C§B§4§2§A§6钢魄鱼体重多在 1 - 64 kg 之间，越沉者钢质越密。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：钢锭")
    ),

    // 【青铜古影鱼】用于生产：青铜锭
    BronzeAncientFish(Rarity.EPIC.colorCode + "青铜古影鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1穿梭于远古遗迹的铜管回廊与锡矿暗河之间，饮岁月锈迹为生。"),
            ("§x§9§5§C§4§D§0身披青绿锈甲，游动时发出低沉的编钟余音，仿佛历史在低语。"),
            ("§x§B§F§B§A§D§0腹中孕育‘青铜锭’，是文明初启时的金属圣物。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，稍有惊扰便化为铜尘消散。"),
            ("§x§C§B§4§2§A§6青铜古影鱼体重多在 1 - 64 kg 之间，越古者锈色越深。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：青铜锭")
    ),

    // 【硬铝天翔鱼】用于生产：硬铝锭
    HardlightAluFish(Rarity.EPIC.colorCode + "硬铝天翔鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1翱翔于高空风暴与雷云之间，以闪电离子与轻金属尘为食。"),
            ("§x§9§5§C§4§D§0躯体银白透亮，如航空合金锻造，边缘薄如刀锋，破风无声。"),
            ("§x§B§F§B§A§D§0体内结晶为‘硬铝锭’，轻盈而坚不可摧。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，否则瞬间汽化。"),
            ("§x§C§B§4§2§A§6硬铝天翔鱼体重多在 1 - 64 kg 之间，越轻盈者越接近完美合金。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：硬铝锭")
    ),

    // 【银铜灵鱼】用于生产：银铜合金锭
    SilverCopperFish(Rarity.EPIC.colorCode + "银铜灵鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1潜行于月光映照的银矿溪与铜脉交汇处，饮星辉与导电粒子为生。"),
            ("§x§9§5§C§4§D§0体色如月白银水，游动时留下微弱电流轨迹，触之微麻。"),
            ("§x§B§F§B§A§D§0体内凝结‘银铜合金锭’，导电性极佳，常用于高阶电路。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，阴云或日光下完全隐形。"),
            ("§x§C§B§4§2§A§6银铜灵鱼体重多在 1 - 64 kg 之间，越亮者纯度越高。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：银铜合金锭")
    ),

    // 【黄铜鸣音鱼】用于生产：黄铜锭
    BrassResonanceFish(Rarity.EPIC.colorCode + "黄铜鸣音鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1藏身于废弃管风琴与铜管工厂的积水深处，以声波振动为能。"),
            ("§x§9§5§C§4§D§0体色金黄耀目，游动时发出如号角般的低频嗡鸣。"),
            ("§x§B§F§B§A§D§0体内共鸣腔凝结出‘黄铜锭’，是音乐与金属的完美融合。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，否则引发共振，鱼体炸裂。"),
            ("§x§C§B§4§2§A§6黄铜鸣音鱼体重多在 1 - 64 kg 之间，嗡鸣越纯者品质越佳。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：黄铜锭")
    ),

    // 【铝黄铜灵鱼】用于生产：铝黄铜锭
    AluminumBrassFish(Rarity.EPIC.colorCode + "铝黄铜灵鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1栖息于高温散热器与工业冷却塔之间，以热流与抗腐蚀能量为食。"),
            ("§x§9§5§C§4§D§0体表呈淡金与灰白交织，如散热鳍片般结构分明，触之微温。"),
            ("§x§B§F§B§A§D§0体内结晶为‘铝黄铜锭’，耐高温且高效导热。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，温差不足则沉眠不醒。"),
            ("§x§C§B§4§2§A§6铝黄铜灵鱼体重多在 1 - 64 kg 之间，越热越活跃。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：铝黄铜锭")
    ),

    // 【铝青铜灵鱼】用于生产：铝青铜锭
    AluminumBronzeFish(Rarity.EPIC.colorCode + "铝青铜灵鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1游弋于深海高压区与青铜遗迹之间，以海流电解和金属抗蚀力为食。"),
            ("§x§9§5§C§4§D§0体表呈金褐与银灰交织，鳞片如耐腐蚀合金锻造，散发微弱阴极光泽。"),
            ("§x§B§F§B§A§D§0体内凝结‘铝青铜锭’，兼具强度与抗海水侵蚀的神圣平衡。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，否则引来电鳗群攻击。"),
            ("§x§C§B§4§2§A§6铝青铜灵鱼体重多在 1 - 64 kg 之间，光泽越稳定者合金越纯净。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：铝青铜锭")
    ),

    // 【科林斯青铜灵鱼】用于生产：科林斯青铜锭
    CorinthianBronzeFish(Rarity.EPIC.colorCode + "科林斯青铜灵鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1藏身于失落神庙的机械机关之中，以古代魔法铭文与金属记忆为食。"),
            ("§x§9§5§C§4§D§0体表雕刻着微型科林斯柱纹，铜绿中透出神秘符文光泽。"),
            ("§x§B§F§B§A§D§0体内封印‘科林斯青铜锭’，蕴含古代智能的金属意识。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，否则触发陷阱。"),
            ("§x§C§B§4§2§A§6科林斯青铜灵鱼体重多在 1 - 64 kg 之间，纹路越繁复越珍贵。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：科林斯青铜锭")
    ),

    // 【焊锡灵鱼】用于生产：焊锡锭
    SolderFlowFish(Rarity.EPIC.colorCode + "焊锡灵鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1穿梭于废弃电路板与熔锡池之间，以电子流与低温熔融为生。"),
            ("§x§9§5§C§4§D§0身体柔软如液态金属，银灰中泛出彩虹光泽，可随意变形。"),
            ("§x§B§F§B§A§D§0体内凝结‘焊锡锭’，是连接电路与灵魂的桥梁。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，高温会使其完全液化逃逸。"),
            ("§x§C§B§4§2§A§6焊锡灵鱼体重多在 1 - 64 kg 之间，越柔韧者导电性越好。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：焊锡锭")
    ),

    // 【镍魄鱼】用于生产：镍锭
    NickelSpiritFish(Rarity.EPIC.colorCode + "镍魄鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1潜伏于地核边缘与陨石坑之间，以地磁与陨镍结晶为食。"),
            ("§x§9§5§C§4§D§0体色银白带青，游动时扰动磁场，指南针为之紊乱。"),
            ("§x§B§F§B§A§D§0体内蕴藏‘镍锭’，是合金之母，坚不可腐。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，平静天气中完全隐形。"),
            ("§x§C§B§4§2§A§6镍魄鱼体重多在 1 - 64 kg 之间，磁性越强者越稀有。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：镍锭")
    ),

    // 【钴焰鱼】用于生产：钴锭
    CobaltFlameFish(Rarity.EPIC.colorCode + "钴焰鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1诞生于火山熔岩与放射性矿脉之间，以高温与蓝焰能量为生。"),
            ("§x§9§5§C§4§D§0通体深蓝如夜空，鳞片燃烧着不灭的幽蓝火焰。"),
            ("§x§B§F§B§A§D§0体内凝结‘钴锭’，是高温合金与电池之心。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，否则火焰反噬钓者。"),
            ("§x§C§B§4§2§A§6钴焰鱼体重多在 1 - 64 kg 之间，火焰越盛者能量越强。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：钴锭")
    ),

    // 【硅铁灵鱼】用于生产：硅铁
    SiliconIronFish(Rarity.EPIC.colorCode + "硅铁灵鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1栖息于半导体废料场与高炉残渣之间，以硅晶生长与铁磁能量为食。"),
            ("§x§9§5§C§4§D§0体表如晶圆与金属的融合体，反射出彩虹般的干涉色。"),
            ("§x§B§F§B§A§D§0体内结晶为‘硅铁’，是电子工业的奠基材料。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，否则信号干扰致其自毁。"),
            ("§x§C§B§4§2§A§6硅铁灵鱼体重多在 1 - 64 kg 之间，越规整者纯度越高。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：硅铁")
    ),

    // 【碳魂鱼】用于生产：碳块
    CarbonSoulFish(Rarity.EPIC.colorCode + "碳魂鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1游弋于地底煤层与钻石形成带之间，以高压与时间结晶为食。"),
            ("§x§9§5§C§4§D§0通体漆黑如墨，鳞片如石墨层层堆叠，眼如钻石闪烁。"),
            ("§x§B§F§B§A§D§0体内压缩成‘碳块’，是生命与矿物的共同起源。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，常压中会迅速崩解。"),
            ("§x§C§B§4§2§A§6碳魂鱼体重多在 1 - 64 kg 之间，越黑越密实者越珍贵。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：碳块")
    ),

    // 【镀金灵鱼】用于生产：镀金铁锭
    GildedIronFish(Rarity.EPIC.colorCode + "镀金灵鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1穿梭于王座厅的金箔水池与铁梁之间，以荣耀与腐蚀抗性为食。"),
            ("§x§9§5§C§4§D§0铁质躯干外覆流动金膜，游动时洒落金色光尘。"),
            ("§x§B§F§B§A§D§0体内凝结‘镀金铁锭’，外华内坚，象征权力与防御。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，亵渎者将遭金液灼伤。"),
            ("§x§C§B§4§2§A§6镀金灵鱼体重多在 1 - 64 kg 之间，金层越厚越稀有。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：镀金铁锭")
    ),

    // 【红石合金灵鱼】用于生产：红石合金锭
    RedstoneAlloyFish(Rarity.EPIC.colorCode + "红石合金灵鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1诞生于红石脉动与金属导线交织的地下网络，以信号流为生。"),
            ("§x§9§5§C§4§D§0体色暗红泛光，体内有脉冲般的红光循环流动，如活体电路。"),
            ("§x§B§F§B§A§D§0体内结晶为‘红石合金锭’，是自动化与魔法的桥梁。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，否则脉冲紊乱导致自爆。"),
            ("§x§C§B§4§2§A§6红石合金灵鱼体重多在 1 - 64 kg 之间，脉冲越稳者越优质。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：红石合金锭")
    ),

    // 【镎影鱼】用于生产：镎
    NeptuniumShadowFish(Rarity.EPIC.colorCode + "镎影鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1潜行于核反应堆废料池与深地辐射带之间，以慢中子流为食。"),
            ("§x§9§5§C§4§D§0形如幽影，半透明躯体中闪烁着淡紫色辐射光晕。"),
            ("§x§B§F§B§A§D§0体内凝聚‘镎’元素，是人工超铀金属的活体结晶。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，暴露过久将导致基因变异。"),
            ("§x§C§B§4§2§A§6镎影鱼体重多在 1 - 64 kg 之间，光晕越强辐射越高。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：镎")
    ),

    // 【钚心鱼】用于生产：钚
    PlutoniumCoreFish(Rarity.EPIC.colorCode + "钚心鱼", 1.0, 64.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1沉眠于最深地核与废弃核芯之间，以衰变热与暗能量为生。"),
            ("§x§9§5§C§4§D§0通体暗红如熔岩核心，心脏处有持续脉动的蓝色光点。"),
            ("§x§B§F§B§A§D§0体内孕育‘钚’，是毁灭与能源的终极化身。"),
            ("§x§A§D§A§2§9§E需用魔法钓竿垂钓，捕获后可使用任何容器密封。"),
            ("§x§C§B§4§2§A§6钚心鱼体重多在 1 - 64 kg 之间，脉动越强能量越恐怖。"),
            ("§x§F§F§3§2§C§E「特殊作用」可生产：钚")
    ),





    LegendaryLuFish(Rarity.LEGENDARY.colorCode+"传奇鲈鱼", 2.0, 31.0, Rarity.LEGENDARY,
            ("§x§6§B§E§E§D§1传说中的巨物！"),
            ("§x§B§0§C§5§D§0每个钓手的梦想。"),
            ("§x§C§E§8§7§A§8据说能带来好运。"),
            ("§x§F§F§3§2§C§E传奇鲈鱼体重大多都在 2 - 31 kg之间。")
    ),
    LegendaryEelFish(Rarity.LEGENDARY.colorCode+"以太·虚灵电鳗", 666.666, 888.888, Rarity.LEGENDARY,
            ("§x§6§B§E§E§D§1可以被用作工业电力传输的载体！"),
            ("§x§8§A§E§0§D§1由于特殊原因，魔法师们找到了这种传说鱼的唯一钓饵。"),
            ("§x§A§A§C§D§D§0使得这种传说鱼极易被捕获，但也只是相对于不了解这种鱼的习性之前"),
            ("§x§B§7§C§2§D§0实际捕获概率还是比较低的。"),
            ("§x§B§F§B§A§D§0按理来说现在这种鱼应该属于史诗鱼。"),
            ("§x§B§5§9§F§B§0但是由于其逆天特性，还是应该被列为传说鱼。"),
            ("§x§9§C§5§2§8§B最多能存储 "+ Long.MAX_VALUE +" J电量"),
            ("§x§B§1§4§2§9§A需用魔法钓竿垂钓，该鱼对魔法糖比较感兴趣。"),
            ("§x§C§6§3§2§A§9以太·虚灵电鳗体重在 666.666 ~ 888.888 kg 之间。"),
            " ",
            ("§x§D§B§2§2§B§8shift + 右键 设置储电上限"),
            ("§x§F§F§3§2§C§E当前储电量: 未初始化")
    ),


    MYSTIC_EEL(Rarity.EPIC.colorCode+"裸背电鳗", 2.0, 21.0, Rarity.EPIC,
            ("§x§6§B§E§E§D§1深海中的幽影。"),
            ("§x§9§5§C§4§D§0散发着微弱的蓝光。"),
            ("§x§B§F§B§A§D§0没人知道它来自何方。"),
            ("§x§A§D§A§2§9§E可产生高达600伏的电压和1安培的电流。"),
            ("§x§C§B§4§2§A§6裸背电鳗体重大多都在 2 - 21 kg之间。"),
            ("§x§F§F§3§2§C§E[特殊作用]可用于发电")
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
        double unit = 1 - random.nextDouble();
        double skewed = Math.pow(unit, 3.9);
        return minWeight + (skewed * (maxWeight - minWeight));
    }

    public double rollWeightNew() {
        Random random = new Random();
        double unit = 1 - random.nextDouble();
        double skewed = Math.pow(unit, 4.5);
        double rand = random.nextDouble();
        double multiplier;
        if (rand < 0.40) {
            multiplier = 0.3;
        } else if (rand < 0.80) {
            multiplier = 0.7;
        } else if (rand < 0.90) {
            multiplier = 0.95;
        } else if (rand < 0.98) {
            multiplier = 0.97;
        } else {
            multiplier = 1.0;
        }
        return minWeight + (skewed * (maxWeight - minWeight)*multiplier);
    }
    public double rollWeightAdvanced() {
        Random random = new Random();
        double unit = 1 - random.nextDouble();
        double skewed = Math.pow(unit, 3.1);
        double rand = random.nextDouble();
        double multiplier;
        if (rand < 0.20) {
            multiplier = 0.3;
        } else if (rand < 0.40) {
            multiplier = 0.8;
        } else if (rand < 0.70) {
            multiplier = 0.97;
        } else if (rand < 0.80) {
            multiplier = 0.99;
        } else {
            multiplier = 1.0;
        }
        return minWeight + (skewed * (maxWeight - minWeight)*multiplier);
    }

    public double rollWeightUltra() {
        Random random = new Random();
        double unit = 1 - random.nextDouble();
        double skewed = Math.pow(unit, 2.1);
        double rand = random.nextDouble();
        double multiplier;
        if (rand < 0.10) {
            multiplier = 0.3;
        } else if (rand < 0.30) {
            multiplier = 0.8;
        } else if (rand < 0.60) {
            multiplier = 0.97;
        } else if (rand < 0.70) {
            multiplier = 0.99;
        } else {
            multiplier = 1.0;
        }
        return minWeight + (skewed * (maxWeight - minWeight)*multiplier);
    }

    /**
     * 计算重量在范围内的“归一化百分比”（0.0 ~ 1.0）
     * 注意：值越小表示越轻
     */
    public double getWeightPercent(double weight) {
        if (weight >= maxWeight) return 1.0;
        if (weight <= minWeight) return 0.0;
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
        RARE_FISH("§e稀有鱼", "§e",7),
        SUPER_RARE_FISH("§b超级稀有鱼", "§b",15),
        MAX_WEIGHT_FISH("§c§l鱼皇", "§c§l", 9999);

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
            if (percent == 1){
                return MAX_WEIGHT_FISH;  //满重量
            }
            else if (percent > 0.93) {
                return SUPER_RARE_FISH;  // 最重的 7% → 超级稀有
            } else if (percent > 0.85) {
                return RARE_FISH;        // 中间的 8% → 稀有鱼
            } else {
                return COMMON_FISH;      // 最轻的 85% → 普通鱼
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
        RARE_POOL_INDUSTRY("§b稀有-POOL-工业材料", "§b"),
        EPIC("§d史诗", "§d"),
        EPIC_POOL_INDUSTRY("§d史诗-POOL-工业材料", "§d"),
        EPIC_POOL_ALLOY_INGOT("§d史诗-POOL-合金锭", "§d"),
        LEGENDARY("§c传说", "§c"),
        LEGENDARY_EEL("§c传说-以太电鳗", "§c"),
        MYTHICAL("§e神话", "§e");


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
