package com.report.ytb.webdriver.impl;

import com.report.ytb.core.UserAgent;
import com.report.ytb.core.WebDriverConst;
import com.report.ytb.webdriver.IWebDriver;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;

public class PhantomJSDriverImpl implements IWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(PhantomJSDriverImpl.class);

    @Override
    public WebDriver execute() {
        logger.info("=================PhantomJS execute ====================");
        ArrayList<String> capability_args = new ArrayList<>();
        capability_args.add("--ignore-ssl-errors=true");
        capability_args.add("--ssl-protocol=any");
        capability_args.add("--web-security=false");
        capability_args.add("--load-images=true");
        capability_args.add("--webdriver-loglevel=INFO");
//        capability_args.add(String.format("--cookies-file=%s", setting.cookieFolderPath));

        DesiredCapabilities caps = DesiredCapabilities.phantomjs();
        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, capability_args);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "userAgent", UserAgent.getUserAgent());
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, WebDriverConst.PHANTOM_JS_PATH);

//        String proxyURL = String.format("%s:%s", setting.proxy.host(), setting.proxy.port());
//        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
//        proxy.setHttpProxy(proxyURL).setFtpProxy(proxyURL).setSslProxy(proxyURL);
//        caps.setCapability(CapabilityType.PROXY, proxy);

        PhantomJSDriver webDriver = new PhantomJSDriver(caps);

//        webDriver.manage().window().setSize(new Dimension(1920, 1080));
        webDriver.manage().window().maximize();
        Capabilities capabilities = ((RemoteWebDriver) webDriver).getCapabilities();

        System.out.println(capabilities);

        webDriver.executePhantomJS("this.onResourceRequested = function(request, net) {" +
                "   console.log('REQUEST ' + request.url);" +
                "   if (request.url.indexOf('.gif') != -1 ||" +
                "       request.url.indexOf('.jpg') != -1) " +
                "       request.url.indexOf('googleads') != -1) " +
                "       request.url.indexOf('adservice') != -1) " +
                "       request.url.indexOf('.ytimg.com') != -1) " +
                "   { " +
                "     request.abort(); " +
                "   }" +
                "};");

        return webDriver;
    }
}
