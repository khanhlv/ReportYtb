package com.report.ytb.core;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.report.ytb.model.UserInfo;

public class CookiesManager {

    public static final String LOGIN_INFO = "LOGIN_INFO";
    public static final String HSID = "HSID";
    public static final String SSID = "SSID";
    public static final String SID = "SID";

    public static void addCookie(WebDriver driver, UserInfo userInfo) {
        driver.manage().deleteAllCookies();

        add(driver, LOGIN_INFO, userInfo.getLOGIN_INFO());
        add(driver, HSID, userInfo.getHSID());
        add(driver, SSID, userInfo.getSSID());
        add(driver, SID, userInfo.getSID());
    }

    private static void add(WebDriver driver, String key, String value) {
        driver.manage().addCookie(
                new Cookie
                        .Builder(key, value)
                        .domain(".youtube.com")
                        .path("/")
                        .expiresOn(DateUtils.addYears(new Date(), 3))
                        .isHttpOnly(true)
                        .isSecure(true)
                        .build());
    }

}

