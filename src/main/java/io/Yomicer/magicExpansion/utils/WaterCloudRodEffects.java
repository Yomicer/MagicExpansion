package io.Yomicer.magicExpansion.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 水云间·鱼竿等级特殊加成
 * 每个等级升级后的特殊加成集中配置在此,后续添加新效果时直接在此扩展
 */
public class WaterCloudRodEffects {

    /** 效果类型(后续新效果在此追加) */
    public enum EffectType {
        /** 上钩速度:值 = 增加的 LURE 附魔等级(每 2 级 +1,不封顶) */
        LURE_SPEED,
        // TODO: 稀有物品概率提升
        // TODO: 杂物概率降低
        // TODO: 特殊钓物概率提升
        // TODO: 双倍收获概率
    }

    /** 单条等级效果 */
    public static final class LevelEffect {

        private final EffectType type;
        private final double value;

        public LevelEffect(EffectType type, double value) {
            this.type = type;
            this.value = value;
        }

        public EffectType getType() {
            return type;
        }

        public double getValue() {
            return value;
        }
    }

    private WaterCloudRodEffects() {
    }

    /**
     * 指定等级对应的特殊加成列表
     * 新增效果:在这里按等级追加 LevelEffect 即可,监听器无需改动
     */
    public static List<LevelEffect> getEffects(int level) {
        List<LevelEffect> effects = new ArrayList<>();

        // 上钩速度:每 2 级 +1 级 LURE 附魔
        effects.add(new LevelEffect(EffectType.LURE_SPEED, Math.max(0, level / 2)));

        return effects;
    }

    /** 便捷取值:LURE 附魔加成等级 */
    public static int getLureBonus(int level) {
        double sum = getEffects(level).stream()
                .filter(e -> e.getType() == EffectType.LURE_SPEED)
                .mapToDouble(LevelEffect::getValue)
                .sum();
        return (int) sum;
    }
}
