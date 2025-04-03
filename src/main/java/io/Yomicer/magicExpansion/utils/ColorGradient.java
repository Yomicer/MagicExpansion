package io.Yomicer.magicExpansion.utils;

import org.bukkit.Color;

import java.util.ArrayList;
import java.util.List;

public class ColorGradient {
    /*覆写颜色*/
    /**
     * 将 RGB 值转换为 Minecraft 颜色代码字符
     *
     * @param value RGB 分量值（0-255）
     * @return 十六进制字符（0-9 或 A-F）
     */
    public static char codeColor(int value) {
        if (value < 0 || value > 15) {
            throw new IllegalArgumentException("Invalid color value: " + value);
        }
        return "0123456789ABCDEF".charAt(value);
    }

    /**
     * 生成带有渐变色的字符串（Minecraft §x 格式）
     *
     * @param text       输入的字符串
     * @param colorList  渐变色列表
     * @return 带有渐变色的字符串
     */
    public static String getGradientName(String text, List<Color> colorList) {
        // 如果未提供颜色列表，使用默认颜色列表
        if (colorList == null || colorList.isEmpty()) {
            colorList = createColorList();
        }

        StringBuilder stringBuilder = new StringBuilder();

        // 如果文本为空或长度不足，补全空格
        if (text.length() == 0) {
            text += " ";
        }
        if (text.length() == 1) {
            text += " ";
        }

        int length = text.length();
        for (int i = 0; i < length; i++) {
            double p = ((double) i) / (length - 1) * (colorList.size() - 1); // 插值进度
            Color color1 = colorList.get((int) Math.floor(p)); // 起始颜色
            Color color2 = colorList.get((int) Math.ceil(p));  // 结束颜色

            // 计算插值后的 RGB 值
            int red = (int) (color1.getRed() * (1 - p + Math.floor(p)) + color2.getRed() * (p - Math.floor(p)));
            int green = (int) (color1.getGreen() * (1 - p + Math.floor(p)) + color2.getGreen() * (p - Math.floor(p)));
            int blue = (int) (color1.getBlue() * (1 - p + Math.floor(p)) + color2.getBlue() * (p - Math.floor(p)));

            // 构建 Minecraft 颜色代码
            stringBuilder.append("§x")
                    .append("§").append(codeColor(red / 16))
                    .append("§").append(codeColor(red % 16))
                    .append("§").append(codeColor(green / 16))
                    .append("§").append(codeColor(green % 16))
                    .append("§").append(codeColor(blue / 16))
                    .append("§").append(codeColor(blue % 16));

            // 添加当前字符
            stringBuilder.append(text.charAt(i));
        }

        return stringBuilder.toString();
    }



    /**
     * 生成带有渐变色的字符串（Minecraft § 格式）
     *
     * @param text 输入的字符串
     * @return 带有渐变色的字符串
     */
    public static String getGradientName(String text) {
        return getGradientName(text, null); // 调用原始方法，使用默认颜色列表
    }


    private static List<Color> createColorList() {
        List<Color> colorList = new ArrayList<>();
        colorList.add(Color.fromRGB(253, 183, 212)); // 淡粉色
        colorList.add(Color.fromRGB(250, 126, 179)); // 中间色
        colorList.add(Color.fromRGB(255, 105, 180)); // 亮粉色
        return colorList;
    }


}
