package com.report.ytb.action;

import org.openqa.selenium.WebDriver;

import com.report.ytb.core.CookiesManager;
import com.report.ytb.utils.WebDriverUtils;
import com.report.ytb.webdriver.IWebDriver;
import com.report.ytb.webdriver.impl.InternetExplorerDriverImpl;

public class YoutubeIEAction {
    public void start() throws Exception {
        IWebDriver iWebDriver = new InternetExplorerDriverImpl();
        WebDriver driver = iWebDriver.execute();

        CookiesManager.addCookie(driver, null);

        driver.get("https://www.youtube.com/watch?v=T4QD6wMR9jY");

        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//        Thread.sleep(30000);
//
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript(ResourceUtils.read("/scenario_1.js"));

//        WebElement element = (
//                new WebDriverWait(driver, 10))
//                .until(new ExpectedCondition<WebElement>(){
//                           public WebElement apply(WebDriver d) {
//                               return d.findElement( By.id("gbqfq") );
//                           }
//                       }
//                );

//        Thread.sleep(40000);
        WebDriverUtils.takesScreenshot(driver, "D:\\test_driver\\data\\image.png");

        driver.close();

        driver.quit();
    }

    public static void main(String[] args) throws Exception {
        new YoutubeIEAction().start();
    }
}
