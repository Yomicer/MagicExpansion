package io.Yomicer.magicExpansion.utils;

import org.bukkit.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
     * 生成带有渐变色的字符串（Minecraft §x 格式）
     *
     * @param text       输入的字符串
     * @param colorList  渐变色列表
     * @return 带有渐变色的字符串
     */
    public static String getGradientNameVer2(String text, List<Color> colorList) {
        // 如果未提供颜色列表，使用默认颜色列表
        if (colorList == null || colorList.isEmpty()) {
            colorList = createCustomColorListV2();
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

    public static String getGradientNameVer2(String text) {
        return getGradientNameVer2(text, null); // 调用原始方法，使用默认颜色列表
    }



    //default color
    private static List<Color> createColorList() {
        List<Color> colorList = new ArrayList<>();
        colorList.add(Color.fromRGB(253, 183, 212)); // 淡粉色
        colorList.add(Color.fromRGB(250, 126, 179)); // 中间色
        colorList.add(Color.fromRGB(255, 105, 180)); // 亮粉色
        return colorList;
    }

    public static List<Color> createCustomColorListV2() {
        List<Color> colorList = new ArrayList<>();

        colorList.add(Color.fromRGB(0x6b, 0xee, 0xd1)); // #6beed1
        colorList.add(Color.fromRGB(0xaa, 0xcd, 0xd0)); // #aacdd0
        colorList.add(Color.fromRGB(0xbf, 0xba, 0xd0)); // #bfbad0
        colorList.add(Color.fromRGB(0x9c, 0x52, 0x8b)); // #9c528b
        colorList.add(Color.fromRGB(0xff, 0x32, 0xce)); // #ff32ce

        return colorList;
    }



    /**
     * 生成指定数量的随机颜色列表
     *
     * @param count 随机颜色的数量
     * @return 随机颜色列表
     */
    private static List<Color> createRandomColorList(int count) {
        List<Color> colorList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            colorList.add(Color.fromRGB(red, green, blue));
        }
        return colorList;
    }

    /**
     * 生成带有随机渐变色的字符串（Minecraft §x 格式）
     *
     * @param text  输入的字符串
     * @param count 渐变色数量
     * @return 带有随机渐变色的字符串
     */
    public static String getRandomGradientName(String text, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be greater than zero");
        }
        List<Color> randomColorList = createRandomColorList(count);
        return getGradientName(text, randomColorList);
    }

    // 如果需要直接调用，不指定颜色数量，默认使用3种颜色进行渐变
    public static String getRandomGradientName(String text) {
        return getRandomGradientName(text, 3); // 默认三种颜色渐变
    }



}
