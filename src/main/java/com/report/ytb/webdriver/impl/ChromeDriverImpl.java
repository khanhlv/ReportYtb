package com.report.ytb.webdriver.impl;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.report.ytb.core.WebDriverConst;
import com.report.ytb.webdriver.IWebDriver;

public class ChromeDriverImpl implements IWebDriver {
    @Override
    public WebDriver execute() {
        System.setProperty("webdriver.chrome.driver", WebDriverConst.CHROME_PATH);
        System.out.println("webdriver.chrome.driver: " + System.getProperty("webdriver.chrome.driver"));

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setCapability("takesScreenshot", true);
        chromeOptions.addArguments("disable-infobars");

        try {
            File fileCookie = new File("D://chrome//");
            if (!fileCookie.exists()) {
                fileCookie.mkdirs();
            }

            fileCookie.setReadable(true, false);
            fileCookie.setWritable(true, false);

        } catch (Exception e) {
        }
        chromeOptions.addArguments(String.format("--user-data-dir=%s", "D://chrome//"));

//        String proxyURL = String.format("%s:%s", setting.proxy.host(), setting.proxy.port());
//        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
//        proxy.setHttpProxy(proxyURL).setFtpProxy(proxyURL).setSslProxy(proxyURL);
//        capabilities.setCapability(CapabilityType.PROXY, proxy);

//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        ChromeDriver webDriver = new ChromeDriver(chromeOptions);

        webDriver.manage().window().maximize();

        return webDriver;
    }
}
