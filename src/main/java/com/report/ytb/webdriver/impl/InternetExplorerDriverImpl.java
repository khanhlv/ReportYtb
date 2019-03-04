package com.report.ytb.webdriver.impl;

import com.report.ytb.core.WebDriverConst;
import com.report.ytb.webdriver.IWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorerDriverImpl implements IWebDriver {
    @Override
    public WebDriver execute() {
        System.setProperty("webdriver.ie.driver", WebDriverConst.FIREFOX_PATH);
        System.out.println("webdriver.ie.driver: " + System.getProperty("webdriver.ie.driver"));

        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        internetExplorerOptions.setCapability("ignoreZoomSetting", true);
        internetExplorerOptions.setCapability("takesScreenshot", true);

//        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        capabilities.setCapability("ignoreZoomSetting", true);
//        capabilities.setCapability("takesScreenshot", true);

        InternetExplorerDriver webDriver = new InternetExplorerDriver(internetExplorerOptions);
//        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();

        return webDriver;
    }
}
