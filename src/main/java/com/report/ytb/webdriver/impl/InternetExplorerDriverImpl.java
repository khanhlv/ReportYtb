package com.report.ytb.webdriver.impl;

import com.report.ytb.webdriver.IWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorerDriverImpl implements IWebDriver {
    @Override
    public WebDriver execute() {
//        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//        System.out.println("webdriver.ie.driver: " + System.getProperty("webdriver.ie.driver"));

        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability("ignoreZoomSetting", true);
        capabilities.setCapability("takesScreenshot", false);

        WebDriver webDriver = new InternetExplorerDriver(capabilities);

        return webDriver;
    }
}
