package com.report.ytb.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.report.ytb.utils.WebDriverUtils;
import com.report.ytb.webdriver.IWebDriver;
import com.report.ytb.webdriver.impl.ChromeDriverImpl;

public class LoginAction {
    public void login() throws Exception {
        IWebDriver iWebDriver = new ChromeDriverImpl();
        WebDriver driver = iWebDriver.execute();
        driver.manage().deleteAllCookies();

        driver.get("https://accounts.google.com/signin/v2/identifier?service=youtube&hl=en&uilel=3&passive=true&continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Fapp%3Ddesktop%26hl%3Den%26action_handle_signin%3Dtrue%26next%3D%252F&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("fordf10072@gmail.com");

        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();

//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Thread.sleep(5000);
        driver.findElement(By.name("password")).sendKeys("Haha12345");

        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("cheese!");
//            }
//        });

        Thread.sleep(2000);

//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("alert('aaaa');");

        WebDriverUtils.takesScreenshot(driver, "data\\output\\image.png");

//        System.out.println(driver.getPageSource());

//        driver.close();
//
//        driver.quit();
    }

    public static void main(String[] args) throws Exception {
        new LoginAction().login();
    }
}
