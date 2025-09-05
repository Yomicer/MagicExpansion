package io.Yomicer.magicExpansion.utils.itemUtils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.Material;

import java.math.BigInteger;

import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;
import static io.Yomicer.magicExpansion.utils.Utils.doGlow;

public class MagicStringBuilder {

    private static final char[] SUPERSCRIPT = {'⁰', '¹', '²', '³', '⁴', '⁵', '⁶', '⁷', '⁸', '⁹'};

    /**
     * 获取第 n 次幂的魔法糖物品（n 从 1 到 39）
     * 显示名和 Lore 均使用上标格式，如：魔法糖*9²，堆叠了9²个魔法糖
     */
    public static SlimefunItemStack getString(int power) {
        if (power < 1 || power > 39) {
            throw new IllegalArgumentException("幂次必须在 1 到 39 之间");
        }

        String id = "MAGIC_EXPANSION_FINAL_STRING_" + power;
        String displayName = "递归记忆纤维*9" + toSuperscript(power);
        // 计算 9^power 的真实值
        BigInteger base = BigInteger.valueOf(9);
        BigInteger result = base.pow(power); // 计算 9^power
        String lore = "堆叠了" + result + "个递归记忆纤维";

        return new SlimefunItemStack(
                id,
                doGlow(Material.WHITE_WOOL),
                getGradientName(displayName),
                "",
                getGradientName(lore),
                getGradientName("这到底有什么用呢？"),
                getGradientName("或许未来有用吧")
        );
    }

    /**
     * 将整数转换为 Unicode 上标字符串（如 123 -> ¹²³）
     */
    private static String toSuperscript(int n) {
        StringBuilder sb = new StringBuilder();
        for (char digit : String.valueOf(n).toCharArray()) {
            sb.append(SUPERSCRIPT[digit - '0']);
        }
        return sb.toString();
    }
}
