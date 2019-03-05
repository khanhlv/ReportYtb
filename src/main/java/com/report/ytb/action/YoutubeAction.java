package com.report.ytb.action;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.CharSequenceUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.report.ytb.core.CookiesManager;
import com.report.ytb.utils.WebDriverUtils;
import com.report.ytb.webdriver.IWebDriver;
import com.report.ytb.webdriver.impl.PhantomJSDriverImpl;

public class YoutubeAction {
    public void start() throws Exception {
        IWebDriver iWebDriver = new PhantomJSDriverImpl();
        WebDriver driver = iWebDriver.execute();

        driver.manage().deleteAllCookies();

        CookiesManager.COOKIES.forEach((k, v) -> {
            v.forEach((k1, v1) -> {
                driver.manage().addCookie(
                        new Cookie
                                .Builder(k1.toString(), v1.toString())
                                .domain(".youtube.com")
                                .path("/")
                                .expiresOn(DateUtils.addYears(new Date(), 3))
                                .isHttpOnly(true)
                                .isSecure(true)
                                .build());
            });
        });

        driver.get("https://www.youtube.com/watch?v=T4QD6wMR9jY&t=122");

        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("watch8-action-buttons")) == null ? false : true;
            }
        });

        Thread.sleep(5000);
        List<WebElement> elementList = driver.findElement(By.id("watch8-action-buttons")).findElements(By.tagName("button"));
        for (WebElement webElement: elementList) {
            System.out.println(webElement.getText());
            if (StringUtils.equals(webElement.getText(), "Thêm") ||
                    StringUtils.equals(webElement.getText(), "More")) {
                webElement.click();
            }
        }

        for (WebElement webElement: elementList) {
            System.out.println(webElement.getText());
            if (StringUtils.equals(webElement.getText(), "Báo cáo") ||
                    StringUtils.equals(webElement.getText(), "Report")) {
                webElement.click();
            }
        }

        Thread.sleep(5000);

        driver.findElement(By.id("Z")).click();

        Thread.sleep(5000);

        List<WebElement> elementList1 = driver.findElements(By.className("options-renderer-type-select-input"));

        for (WebElement webElement: elementList1) {
            for (WebElement webElement1: webElement.findElements(By.tagName("option"))) {
//                System.out.println(webElement1.getAttribute("value"));
                if (StringUtils.equals(webElement1.getAttribute("value"), "21")) {
                    webElement1.click();
                }
            }
        }

        Thread.sleep(5000);
        driver.findElement(By.className("options-renderer-button-submit")).click();
//        driver.findElement(By.className("options-renderer-button-continue")).click();

        Thread.sleep(10000);

//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("document.querySelector('#watch8-action-buttons').querySelector('.yt-uix-menu').querySelector('.yt-uix-clickcard').querySelector('button').click()");

        WebDriverUtils.takesScreenshot(driver, "D:\\image.png");

        FileUtils.writeStringToFile(new File("D:\\data.html"), driver.getPageSource());
        driver.close();

        driver.quit();
    }

    public static void main(String[] args) throws Exception {
        new YoutubeAction().start();
    }
}