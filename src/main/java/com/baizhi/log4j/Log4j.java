package com.baizhi.log4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/6/11.
 */
public class Log4j {
  static Logger logger= LoggerFactory.getLogger(Log4j.class);


    public static void main(String[] args) {
        logger.error("这是error");
        logger.warn("这是warn");
        logger.info("这是info");
        logger.debug("debug");
    }
}
