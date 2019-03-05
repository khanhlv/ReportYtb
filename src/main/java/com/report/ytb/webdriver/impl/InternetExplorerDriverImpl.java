package com.report.ytb.webdriver.impl;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.report.ytb.core.WebDriverConst;
import com.report.ytb.webdriver.IWebDriver;

public class InternetExplorerDriverImpl implements IWebDriver {
    @Override
    public WebDriver execute() {
        System.setProperty("webdriver.ie.driver", WebDriverConst.IE_PATH);
        System.out.println("webdriver.ie.driver: " + System.getProperty("webdriver.ie.driver"));

        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.setCapability("takesScreenshot", true);
        internetExplorerOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        internetExplorerOptions.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
        internetExplorerOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT); //Accept unexpected alerts
        internetExplorerOptions.setCapability("requireWindowFocus", true);
        internetExplorerOptions.setCapability("enablePersistentHover", false);
        internetExplorerOptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

        InternetExplorerDriver webDriver = new InternetExplorerDriver(internetExplorerOptions);

        webDriver.manage().window().maximize();

        return webDriver;
    }
}
