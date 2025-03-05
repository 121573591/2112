/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.Color
 *  java.awt.image.BufferedImage
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map$Entry
 *  java.util.Random
 */
package cn.hutool.core.img;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ColorUtil {
    private static final int RGB_COLOR_BOUND = 256;

    public static String toHex(Color color) {
        return ColorUtil.toHex(color.getRed(), color.getGreen(), color.getBlue());
    }

    public static String toHex(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new IllegalArgumentException("RGB must be 0~255!");
        }
        return String.format((String)"#%02X%02X%02X", (Object[])new Object[]{r, g, b});
    }

    public static Color getColor(String colorName) {
        if (StrUtil.isBlank(colorName)) {
            return null;
        }
        if ("BLACK".equals((Object)(colorName = colorName.toUpperCase()))) {
            return Color.BLACK;
        }
        if ("WHITE".equals((Object)colorName)) {
            return Color.WHITE;
        }
        if ("LIGHTGRAY".equals((Object)colorName) || "LIGHT_GRAY".equals((Object)colorName)) {
            return Color.LIGHT_GRAY;
        }
        if ("GRAY".equals((Object)colorName)) {
            return Color.GRAY;
        }
        if ("DARKGRAY".equals((Object)colorName) || "DARK_GRAY".equals((Object)colorName)) {
            return Color.DARK_GRAY;
        }
        if ("RED".equals((Object)colorName)) {
            return Color.RED;
        }
        if ("PINK".equals((Object)colorName)) {
            return Color.PINK;
        }
        if ("ORANGE".equals((Object)colorName)) {
            return Color.ORANGE;
        }
        if ("YELLOW".equals((Object)colorName)) {
            return Color.YELLOW;
        }
        if ("GREEN".equals((Object)colorName)) {
            return Color.GREEN;
        }
        if ("MAGENTA".equals((Object)colorName)) {
            return Color.MAGENTA;
        }
        if ("CYAN".equals((Object)colorName)) {
            return Color.CYAN;
        }
        if ("BLUE".equals((Object)colorName)) {
            return Color.BLUE;
        }
        if ("DARKGOLD".equals((Object)colorName)) {
            return ColorUtil.hexToColor("#9e7e67");
        }
        if ("LIGHTGOLD".equals((Object)colorName)) {
            return ColorUtil.hexToColor("#ac9c85");
        }
        if (StrUtil.startWith((CharSequence)colorName, '#')) {
            return ColorUtil.hexToColor(colorName);
        }
        if (StrUtil.startWith((CharSequence)colorName, '$')) {
            return ColorUtil.hexToColor("#" + colorName.substring(1));
        }
        List<String> rgb = StrUtil.split((CharSequence)colorName, ',');
        if (3 == rgb.size()) {
            Integer b;
            Integer g;
            Integer r = Convert.toInt(rgb.get(0));
            if (!ArrayUtil.hasNull(r, g = Convert.toInt(rgb.get(1)), b = Convert.toInt(rgb.get(2)))) {
                return new Color(r.intValue(), g.intValue(), b.intValue());
            }
        } else {
            return null;
        }
        return null;
    }

    public static Color getColor(int rgb) {
        return new Color(rgb);
    }

    public static Color hexToColor(String hex) {
        return ColorUtil.getColor(Integer.parseInt((String)StrUtil.removePrefix(hex, "#"), (int)16));
    }

    public static Color add(Color color1, Color color2) {
        double r1 = color1.getRed();
        double g1 = color1.getGreen();
        double b1 = color1.getBlue();
        double a1 = color1.getAlpha();
        double r2 = color2.getRed();
        double g2 = color2.getGreen();
        double b2 = color2.getBlue();
        double a2 = color2.getAlpha();
        int r = (int)((r1 * a1 / 255.0 + r2 * a2 / 255.0) / (a1 / 255.0 + a2 / 255.0));
        int g = (int)((g1 * a1 / 255.0 + g2 * a2 / 255.0) / (a1 / 255.0 + a2 / 255.0));
        int b = (int)((b1 * a1 / 255.0 + b2 * a2 / 255.0) / (a1 / 255.0 + a2 / 255.0));
        return new Color(r, g, b);
    }

    public static Color randomColor() {
        return ColorUtil.randomColor(null);
    }

    public static Color randomColor(Random random) {
        if (null == random) {
            random = RandomUtil.getRandom();
        }
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public static String getMainColor(BufferedImage image, int[] ... rgbFilters) {
        HashMap countMap = new HashMap();
        int width = image.getWidth();
        int height = image.getHeight();
        int minx = image.getMinX();
        int miny = image.getMinY();
        for (int i = minx; i < width; ++i) {
            for (int j = miny; j < height; ++j) {
                int b;
                int g;
                int pixel = image.getRGB(i, j);
                int r = (pixel & 0xFF0000) >> 16;
                if (ColorUtil.matchFilters(r, g = (pixel & 0xFF00) >> 8, b = pixel & 0xFF, rgbFilters)) continue;
                countMap.merge((Object)(r + "-" + g + "-" + b), (Object)1L, Long::sum);
            }
        }
        String maxColor = null;
        long maxCount = 0L;
        for (Map.Entry entry : countMap.entrySet()) {
            String key = (String)entry.getKey();
            Long count = (Long)entry.getValue();
            if (count <= maxCount) continue;
            maxColor = key;
            maxCount = count;
        }
        String[] splitRgbStr = StrUtil.splitToArray(maxColor, '-');
        String rHex = Integer.toHexString((int)Integer.parseInt((String)splitRgbStr[0]));
        String gHex = Integer.toHexString((int)Integer.parseInt((String)splitRgbStr[1]));
        String bHex = Integer.toHexString((int)Integer.parseInt((String)splitRgbStr[2]));
        rHex = rHex.length() == 1 ? "0" + rHex : rHex;
        gHex = gHex.length() == 1 ? "0" + gHex : gHex;
        bHex = bHex.length() == 1 ? "0" + bHex : bHex;
        return "#" + rHex + gHex + bHex;
    }

    private static boolean matchFilters(int r, int g, int b, int[] ... rgbFilters) {
        if (rgbFilters != null && rgbFilters.length > 0) {
            for (int[] rgbFilter : rgbFilters) {
                if (r != rgbFilter[0] || g != rgbFilter[1] || b != rgbFilter[2]) continue;
                return true;
            }
        }
        return false;
    }
}

