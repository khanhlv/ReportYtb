package com.report.ytb.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class WebDriverUtils {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverUtils.class);

    public final static void takesScreenshot(WebDriver driver, String path) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            logger.error("Takes Screenshot", e);
        }
    }
}
