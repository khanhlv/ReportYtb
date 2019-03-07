package com.report.ytb.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.report.ytb.core.CookiesManager;
import com.report.ytb.utils.ResourceUtils;
import com.report.ytb.utils.WebDriverUtils;
import com.report.ytb.webdriver.IWebDriver;
import com.report.ytb.webdriver.impl.ChromeDriverImpl;

public class YoutubeChromeAction {
    public void start() {
        IWebDriver iWebDriver = new ChromeDriverImpl();
        WebDriver driver = iWebDriver.execute();

        driver.get("https://www.google.com/");

        try {
            ResourceUtils.readLinkInternal("data/link.json").forEach((link) -> {
                System.out.println("GET: " + link.getLINK());

                String path = link.getLINK().substring(link.getLINK().lastIndexOf("?v=") + 3);
                try {
                    FileUtils.forceMkdir(new File("data\\output\\" + path));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                ResourceUtils.readUserInternal("data/cookies.json").forEach((v) -> {
                    if (StringUtils.isNoneEmpty(v.getLOGIN_INFO())) {
                        System.out.println(v.getUSERNAME());

                        CookiesManager.addCookie(driver, v);

                        driver.get(link.getLINK());

                        try {
                            Thread.sleep(30000);
                        } catch (InterruptedException e) {
                        }

                        JavascriptExecutor executor = (JavascriptExecutor) driver;
                        executor.executeScript(ResourceUtils.read("/scenario_chrome_2.js"));

                        try {
                            Thread.sleep(30000);
                        } catch (InterruptedException e) {
                        }
                        WebDriverUtils.takesScreenshot(driver, "data\\output\\" + path  + "\\" + v.getUSERNAME() + ".png");

                        System.out.println("TakesScreenshot: Done");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                        }
                    }
                });
            });
        } finally {
            driver.close();
            driver.quit();
        }
    }

    public static void main(String[] args) throws Exception {
        new YoutubeChromeAction().start();
    }
}
