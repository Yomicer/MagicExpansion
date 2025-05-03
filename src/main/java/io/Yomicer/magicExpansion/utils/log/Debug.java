package io.Yomicer.magicExpansion.utils.log;

import io.Yomicer.magicExpansion.MagicExpansion;

public class Debug {

    public static final java.util.logging.Logger logger = MagicExpansion.getInstance().getLogger();

    public static void logInfo(String msg){
            logger.info(msg);
    }

    public static void logWarn(String msg){
            logger.warning(msg);
    }

    public static void logError(String msg){
            logger.severe(msg);
    }

}
