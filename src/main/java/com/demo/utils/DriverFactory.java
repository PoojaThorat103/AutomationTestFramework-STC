package com.demo.utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    private static DriverFactory instance = null;
    private DriverFactory(){
    }

    public static DriverFactory getInstance(){
        if(instance == null){
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver getDriver(){
        return webDriver.get();
    }

    public void setDriver(WebDriver driver){
        webDriver.set(driver);
    }

    public static WebDriver getCurrentDriver(){
        return getInstance().getDriver();
    }
}
