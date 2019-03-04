package com.report.ytb.core;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Cookie;

public class CookiesManager {

    public static final String LOGIN_INFO = "LOGIN_INFO";
    public static final String HSID = "HSID";
    public static final String SSID = "SSID";
    public static final String SID = "SID";

    public static final Map<String, Map> COOKIES = new HashMap<>();

    static {
        Map<String, String> cookieValue = new HashMap<>();
        cookieValue.put(LOGIN_INFO, "AFmmF2swRgIhAMtilanuwiHAj79ScAeUSPMbY7t3x7XNWE9j9nN68bpPAiEAr2pFAG8awztS3PQmnwcX8yxO1clAQOf4V18KeAe6bq4:QUQ3MjNmd3BaTGdkVFdiSTZiM3VEMFE4eUJBQkhWOEk1VFk3Mkk4WlFwZl9yNFlLbjhGbjRuNW00NGc2UTY5NnJYRHZ6MlhGV2htZVJPNmdnRVEzbjljMHZVdGhSV0FNb1NfYXlVSUo4WTlfX1NZbzR0MXJRR0pDbmptZy1JZ1BZSlNEZFJmbGhYc3p6NGo0cFA1WmNBcDA1SlJObjdWTXJaMTQyb0x5WmhTc3k2SDA4WV9sZkdB");
        cookieValue.put(HSID, "AScyrpHq7JbgbpfNX");
        cookieValue.put(SSID, "AjO_VBatSxu4vy1jn");
        cookieValue.put(SID, "JAewmdJLt3wAcywsTINI5syXtMrcyiyxyoM80Xt7lhp3wBfzAaGlpcwt-6M85HvM41deNA.");

        COOKIES.put("dpntpj44@gmail.com", cookieValue);
    }

    public static void main(String[] args) {
        CookiesManager.COOKIES.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((k1, v1) -> {
                System.out.println(k1);
            });

        });
    }
}

