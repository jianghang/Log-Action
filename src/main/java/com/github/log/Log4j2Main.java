package com.github.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by jianghang on 2018/5/5.
 */
public class Log4j2Main {

    private static Logger logger = LogManager.getLogger(Log4j2Main.class);

    public static void main(String[] args) {
        logger.error("Hello World");
        logger.info("hello world");
        logger.debug("hello {}","debug");
    }
}
