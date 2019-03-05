package com.report.ytb.action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.report.ytb.core.CookiesManager;
import com.report.ytb.utils.ResourceUtils;
import com.report.ytb.utils.WebDriverUtils;
import com.report.ytb.webdriver.IWebDriver;
import com.report.ytb.webdriver.impl.ChromeDriverImpl;

public class YoutubeChromeAction {
    public void start() throws Exception {
        IWebDriver iWebDriver = new ChromeDriverImpl();
        WebDriver driver = iWebDriver.execute();

        CookiesManager.addCookie(driver);

        driver.get("https://www.youtube.com/watch?v=T4QD6wMR9jY");

        Thread.sleep(30000);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(ResourceUtils.read("/scenario_chrome_1.js"));

        Thread.sleep(40000);
        WebDriverUtils.takesScreenshot(driver, "D:\\test_driver\\data\\image.png");

        driver.close();

        driver.quit();
    }

    public static void main(String[] args) throws Exception {
        new YoutubeChromeAction().start();
    }
}
