package com.nextgen.utils.Logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static final Logger logger = LogManager.getLogger(Log.class);

    public static void info(Object msg) {
        logger.info(msg);
    }

    public static void warn(Object msg) {
        logger.info(msg);
    }

    public static void debug(Object msg) {
        logger.debug(msg);
    }

    public static void error(Object msg) {
        logger.error(msg);
    }

    public static void msg(Object msg, Level type) {
        logger.log(type, msg);
    }
}
