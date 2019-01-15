package com.report.ytb.webdriver.impl;

import com.report.ytb.webdriver.IWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverImpl implements IWebDriver {
    @Override
    public WebDriver execute() {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("takesScreenshot", false);

//        if (setting.cookieFolderPath != null && !setting.cookieFolderPath.isEmpty()) {
//            File profileDir = new File(setting.cookieFolderPath);
//            if (!profileDir.exists())
//                profileDir.mkdirs();
//
//            FirefoxProfile profile = new FirefoxProfile(profileDir);
//            caps.setCapability(FirefoxDriver.PROFILE, profile);
//        }

//        if (setting.proxy != null && setting.proxy.isWorks()) {
//            String proxyURL = String.format("%s:%s", setting.proxy.host(), setting.proxy.port());
//            org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
//            proxy.setHttpProxy(proxyURL).setFtpProxy(proxyURL).setSslProxy(proxyURL);
//            caps.setCapability(CapabilityType.PROXY, proxy);
//        }

        WebDriver webDriver = new FirefoxDriver(caps);

        return webDriver;
    }
}
