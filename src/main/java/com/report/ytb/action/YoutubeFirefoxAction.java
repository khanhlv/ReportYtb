package com.report.ytb.action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.report.ytb.core.CookiesManager;
import com.report.ytb.utils.ResourceUtils;
import com.report.ytb.utils.WebDriverUtils;
import com.report.ytb.webdriver.IWebDriver;
import com.report.ytb.webdriver.impl.FirefoxDriverImpl;

public class YoutubeFirefoxAction {
    public void start() throws Exception {
        IWebDriver iWebDriver = new FirefoxDriverImpl();
        WebDriver driver = iWebDriver.execute();

        driver.get("https://www.youtube.com/");

        CookiesManager.addCookie(driver, null);

        driver.get("https://www.youtube.com/watch?v=T4QD6wMR9jY");

        Thread.sleep(30000);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(ResourceUtils.read("/scenario_1.js"));

        Thread.sleep(40000);
        WebDriverUtils.takesScreenshot(driver, "data\\output\\image.png");

        driver.close();

        driver.quit();
    }

    public static void main(String[] args) throws Exception {
        new YoutubeFirefoxAction().start();
    }
}
