package com.report.ytb.webdriver.impl;

import com.report.ytb.webdriver.IWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverImpl implements IWebDriver {
    @Override
    public WebDriver execute() {
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        System.out.println("webdriver.chrome.driver: " + System.getProperty("webdriver.chrome.driver"));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("takesScreenshot", false);

//        try {
//            File fileCookie = new File(setting.cookiePath);
//            if (!fileCookie.exists())
//                fileCookie.mkdirs();
//
//            fileCookie.setReadable(true, false);
//            fileCookie.setWritable(true, false);
//
//        } catch (Exception e) {
//        }
//        options.addArguments(String.format("--user-data-dir=%s", setting.cookiePath));

//        String proxyURL = String.format("%s:%s", setting.proxy.host(), setting.proxy.port());
//        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
//        proxy.setHttpProxy(proxyURL).setFtpProxy(proxyURL).setSslProxy(proxyURL);
//        capabilities.setCapability(CapabilityType.PROXY, proxy);

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver webDriver = new ChromeDriver(capabilities);

        return webDriver;
    }
}
