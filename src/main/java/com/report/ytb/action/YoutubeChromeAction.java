package com.report.ytb.action;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.report.ytb.core.CookiesManager;
import com.report.ytb.utils.ResourceUtils;
import com.report.ytb.utils.WebDriverUtils;
import com.report.ytb.webdriver.IWebDriver;
import com.report.ytb.webdriver.impl.ChromeDriverImpl;

public class YoutubeChromeAction {
    public void start() {
        IWebDriver iWebDriver = new ChromeDriverImpl();
        WebDriver driver = iWebDriver.execute();

        String ytbId = "T4QD6wMR9jY";

        ResourceUtils.readUser("/cookies.json").forEach((v) -> {
            if (StringUtils.isNoneEmpty(v.getLOGIN_INFO())) {
                System.out.println(v.getUSERNAME());

                CookiesManager.addCookie(driver, v);

                driver.get("https://www.youtube.com/watch?v=" + ytbId);

                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                }

                LogEntries les = driver.manage().logs().get(LogType.PERFORMANCE);
                for (LogEntry le : les) {
                    System.out.println(le.getMessage());
                }

                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript(ResourceUtils.read("/scenario_chrome_1.js"));

                try {
                    Thread.sleep(40000);
                } catch (InterruptedException e) {
                }
                WebDriverUtils.takesScreenshot(driver, "data\\output\\" + v.getUSERNAME() + "_" + ytbId + ".png");
                System.out.println("TakesScreenshot: Done");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
            }
        });

        driver.close();

        driver.quit();
    }

    public static void main(String[] args) throws Exception {
        new YoutubeChromeAction().start();
    }
}
