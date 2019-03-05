package com.report.ytb.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ResourceUtils {

    private static final Logger logger = LoggerFactory.getLogger(ResourceUtils.class);

    public static String read(String file) {
        InputStream inputStream = ResourceUtils.class.getResourceAsStream(file);
        try {
            return IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException ex) {
            logger.error("ResourceUtils:read:String", ex);
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(ResourceUtils.read("/scenario_1.js"));
    }
}
