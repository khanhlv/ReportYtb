package com.report.ytb.webdriver.impl;

import java.io.File;
import java.util.Date;

import com.report.ytb.core.WebDriverConst;
import com.report.ytb.webdriver.IWebDriver;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverImpl implements IWebDriver {
    @Override
    public WebDriver execute() {
        System.setProperty("webdriver.gecko.driver", WebDriverConst.FIREFOX_PATH);
        System.out.println("webdriver.gecko.driver: " + System.getProperty("webdriver.gecko.driver"));



//        if (setting.proxy != null && setting.proxy.isWorks()) {
//            String proxyURL = String.format("%s:%s", setting.proxy.host(), setting.proxy.port());
//            org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
//            proxy.setHttpProxy(proxyURL).setFtpProxy(proxyURL).setSslProxy(proxyURL);
//            caps.setCapability(CapabilityType.PROXY, proxy);
//        }

        FirefoxOptions firefoxOptions = new FirefoxOptions();

        firefoxOptions.setCapability(FirefoxDriver.PROFILE, new FirefoxProfile(new File("D:\\ReportYtb\\driver\\geckodriver-v0.23.0-win64")));
        firefoxOptions.setCapability("marionette", true);
        firefoxOptions.setCapability("takesScreenshot", true);
        firefoxOptions.setCapability("acceptInsecureCerts", true);

        FirefoxDriver webDriver = new FirefoxDriver(firefoxOptions);

        webDriver.manage().deleteAllCookies();

        webDriver.manage().addCookie(
                new Cookie
                        .Builder("HSID", "A01OC-Urpm4MBJHia")
                        .domain(".youtube.com")
                        .path("/")
                        .expiresOn(DateUtils.addYears(new Date(), 3))
                        .isHttpOnly(true)
                        .isSecure(true)
                        .build());
        webDriver.manage().addCookie(
                new Cookie
                        .Builder("SSID", "AoP7GoZHm07oAIWZo")
                        .domain(".youtube.com")
                        .path("/")
                        .expiresOn(DateUtils.addYears(new Date(), 3))
                        .isHttpOnly(true)
                        .isSecure(true)
                        .build());
        webDriver.manage().addCookie(
                new Cookie
                        .Builder("LOGIN_INFO", "AFmmF2swRgIhAIWuXIUKgTDyUqyZFshrjC_vQu9Arq5nb3IRMmMNCCIBAiEAhD5agzGXnKUgLqrWXYLh1OpBO8Y44bxY6TeQWgZejso:QUQ3MjNmeVctNUNZUThxZ2NKS2JSZGF3Zy1SeDN5bTU5alY1WkJsT3I0YWNDZUFJa1Q5NG5GbXB3bHZmem44RFBUY0xDMTh4bnZFbUM0Z25TV200cDlQT0JiRk9HZ2oyYVRZeGlVUFRoZXlpbVhIcHQ4ZUdNY3FKUVJqSjNBN3pxU0RaUUFzaHhCYTNpLXI3NjZxWWM1ZnVfc1BsNkdyaTVUc1R5amlFaTUtVFlYSXFTOFJTekFv")
                        .domain(".youtube.com")
                        .path("/")
                        .expiresOn(DateUtils.addYears(new Date(), 3))
                        .isHttpOnly(true)
                        .isSecure(true)
                        .build());
        webDriver.manage().addCookie(
                new Cookie
                        .Builder("SID", "IAeZwMmO_Fow_Ip5k30XQimfKzNwZvgdW6c0p0pm78QZdDMx1lOYQtoGy80fcGWBVSklqA.")
                        .domain(".youtube.com")
                        .path("/")
                        .expiresOn(DateUtils.addYears(new Date(), 3))
                        .isHttpOnly(true)
                        .isSecure(true)
                        .build());
        webDriver.manage().window().maximize();

        return webDriver;
    }
}
