package io.Yomicer.magicExpansion.utils.machineLore;

import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;

import javax.annotation.Nonnull;
import java.text.DecimalFormat;

public class ChargeLore {

    private static final DecimalFormat FORMAT = new DecimalFormat("###,###,###,###,###,###.#");
    private static final double TPS = (double)20.0F / (double) Slimefun.getTickerTask().getTickRate();
    private static final String PREFIX = "&8⇨ &e⚡ &7";

    @Nonnull
    public static String energyPerSecond(int energy) {
        return "&8⇨ &e⚡ &7" + formatEnergy(energy) + " J/s";
    }

    @Nonnull
    public static String energyBuffer(int energy) {
        return "&8⇨ &e⚡ &7" + format((double)energy) + " J 可储存";
    }

    @Nonnull
    public static String energyPerTick(int energy) {
        return "&8⇨ &e⚡ &7" + format((double)energy) + " J/tick ";
    }

    @Nonnull
    public static String speed(int speed) {
        return "&8⇨ &e⚡ &7速度: &b" + speed + 'x';
    }



    @Nonnull
    public static String formatEnergy(int energy) {
        return FORMAT.format((double)energy * TPS);
    }

    @Nonnull
    public static String format(double number) {
        return FORMAT.format(number);
    }

}
