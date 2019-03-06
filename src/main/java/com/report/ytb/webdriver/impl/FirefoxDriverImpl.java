package com.report.ytb.webdriver.impl;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.report.ytb.core.UserAgent;
import com.report.ytb.core.WebDriverConst;
import com.report.ytb.webdriver.IWebDriver;

public class FirefoxDriverImpl implements IWebDriver {
    @Override
    public WebDriver execute() {
        System.setProperty("webdriver.gecko.driver", WebDriverConst.FIREFOX_PATH);
        System.out.println("webdriver.gecko.driver: " + System.getProperty("webdriver.gecko.driver"));
        String filePath = "data\\profiles\\firefox\\";
//        if (setting.proxy != null && setting.proxy.isWorks()) {
//            String proxyURL = String.format("%s:%s", setting.proxy.host(), setting.proxy.port());
//            org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
//            proxy.setHttpProxy(proxyURL).setFtpProxy(proxyURL).setSslProxy(proxyURL);
//            caps.setCapability(CapabilityType.PROXY, proxy);
//        }

        FirefoxOptions firefoxOptions = new FirefoxOptions();

        FirefoxProfile firefoxProfile = new FirefoxProfile(new File(filePath));
        firefoxProfile.setPreference("general.useragent.override", UserAgent.getUserAgent());

        firefoxOptions.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
        firefoxOptions.setCapability("marionette", true);
        firefoxOptions.setCapability("takesScreenshot", true);
        firefoxOptions.setCapability("acceptInsecureCerts", true);

        FirefoxDriver webDriver = new FirefoxDriver(firefoxOptions);

        webDriver.manage().window().maximize();

        return webDriver;
    }
}
