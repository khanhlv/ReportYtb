package com.report.ytb.webdriver.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.report.ytb.core.WebDriverConst;
import com.report.ytb.webdriver.IWebDriver;

public class EdgeDriverImpl implements IWebDriver {
    @Override
    public WebDriver execute() {
        System.setProperty("webdriver.edge.driver", WebDriverConst.EDGE_PATH);
        System.out.println("webdriver.edge.driver: " + System.getProperty("webdriver.edge.driver"));

        EdgeOptions edgeOptions = new EdgeOptions();

        EdgeDriver webDriver = new EdgeDriver(edgeOptions);

        webDriver.manage().window().maximize();

        return webDriver;
    }
}
