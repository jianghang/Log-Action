package com.github.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * Created by jianghang on 2018/5/5.
 */
public class Slf4jMain {

    private static Logger logger = LoggerFactory.getLogger(Slf4jMain.class);

    public static void main(String[] args) {
        MDC.put("requestUUID", UUID.randomUUID().toString().replace("-",""));
        logger.info("hello,World");
        MDC.remove("requestUUUID");
    }
}
