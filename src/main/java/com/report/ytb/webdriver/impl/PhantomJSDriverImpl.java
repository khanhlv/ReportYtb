package com.report.ytb.webdriver.impl;

import com.report.ytb.webdriver.IWebDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class PhantomJSDriverImpl implements IWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(PhantomJSDriverImpl.class);

    @Override
    public WebDriver execute() {
        logger.info("=================PhantomJS execute ====================");
        ArrayList<String> capability_args = new ArrayList<>();
        capability_args.add("--ignore-ssl-errors=true");
        capability_args.add("--ssl-protocol=any");
        capability_args.add("--web-security=false");
        capability_args.add("--load-images=false");
        capability_args.add("--webdriver-loglevel=NONE");
//        capability_args.add(String.format("--cookies-file=%s", setting.cookieFolderPath));

        DesiredCapabilities caps = DesiredCapabilities.phantomjs();
        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", false);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, capability_args);

//        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "userAgent", setting.UserAgent);

//        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, file.getAbsolutePath());

//        String proxyURL = String.format("%s:%s", setting.proxy.host(), setting.proxy.port());
//        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
//        proxy.setHttpProxy(proxyURL).setFtpProxy(proxyURL).setSslProxy(proxyURL);
//        caps.setCapability(CapabilityType.PROXY, proxy);

        WebDriver webDriver = new PhantomJSDriver(caps);
        //webDriver.manage().deleteAllCookies();
        //webDriver.manage().window().setSize(new Dimension(1920, 1080));
        webDriver.manage().window().maximize();
        Capabilities capabilities = ((RemoteWebDriver) webDriver).getCapabilities();

        System.out.println(capabilities);

        return webDriver;
    }
}
