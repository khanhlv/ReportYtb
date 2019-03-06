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
        System.setProperty("webdriver.chrome.logfile", "driver\\chromedriver_win32\\chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        System.out.println("webdriver.chrome.driver: " + System.getProperty("webdriver.chrome.driver"));
        String filePath = "data\\profiles\\chrome\\";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("--headless", "--remote-debugging-port=9222");
        chromeOptions.addArguments("--disable-web-security", "--disable-translate", "--disable-extensions", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--no-sandbox");

        chromeOptions.addArguments("disable-infobars");
//        chromeOptions.addArguments("--user-agent=" + UserAgent.getUserAgent());
        chromeOptions.setCapability("takesScreenshot", true);

        try {
            File fileCookie = new File(filePath);
            if (!fileCookie.exists()) {
                fileCookie.mkdirs();
            }

            fileCookie.setReadable(true, false);
            fileCookie.setWritable(true, false);

        } catch (Exception e) {
        }

        chromeOptions.addArguments(String.format("--user-data-dir=%s", filePath));

//        String proxyURL = String.format("%s:%s", setting.proxy.host(), setting.proxy.port());
//        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
//        proxy.setHttpProxy(proxyURL).setFtpProxy(proxyURL).setSslProxy(proxyURL);
//        capabilities.setCapability(CapabilityType.PROXY, proxy);

//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        ChromeDriver webDriver = new ChromeDriver(chromeOptions);

        return webDriver;
    }
}
